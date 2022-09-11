package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;

public class PayCancelResponse {
    PayCancelResult payCancelResult;
    Integer payCancceledAmount;

    public PayCancelResponse(PayCancelResult payCancelResult, Integer payCancceledAmount) {
        this.payCancelResult = payCancelResult;
        this.payCancceledAmount = payCancceledAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayCancceledAmount() {
        return payCancceledAmount;
    }

    public void setPayCancceledAmount(Integer payCancceledAmount) {
        this.payCancceledAmount = payCancceledAmount;
    }
}
