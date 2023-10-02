package jp.co.biglobe.warikan.domain.party.entity;

import jp.co.biglobe.warikan.domain.party.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.jar.Attributes;

import static java.lang.Math.round;

@Getter
@AllArgsConstructor
public class Party {

    private PartyId partyId;

    private PaymentRatio paymentRatio;

    public static Party newInstance(PartyId partyId, PaymentRatio paymentRatio) {
        return new Party(partyId, paymentRatio);
    }


    public int getMediumPayment(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Payment payment = new Payment(paymentRatio, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        return payment.getMediumPayment().getValue();
    }

    public int getLargePayment(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Payment payment = new Payment(paymentRatio, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        return payment.getLargePayment().getValue();
    }

    public int getSmallPayment(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Payment payment = new Payment(paymentRatio, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        return payment.getSmallPayment().getValue();
    }

    public int getBalanceDue(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Payment payment = new Payment(paymentRatio, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        return payment.getBalanceDue().getValue();
    }
}
