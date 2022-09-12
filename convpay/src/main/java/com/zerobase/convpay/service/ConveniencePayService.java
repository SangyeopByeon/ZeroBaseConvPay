package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService {
    private  final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private  final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest payRequest) {
        CardUseResult cardUseResult;
        MoneyUseResult moneyUseResult;

        if(payRequest.getPayMethodType() == PayMethodType.CARD) {
            cardAdapter.authorization();
            cardAdapter.approval();
            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());
        }else{
            moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
        }


        // fail fast
        // Exception case1
        // Exception case2
        // Exception case3

        if (cardUseResult == CardUseResult.USE_FAIL || moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case(Only one)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest){
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success Case(Only one)
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}