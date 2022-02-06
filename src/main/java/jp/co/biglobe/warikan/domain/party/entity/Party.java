package jp.co.biglobe.warikan.domain.party.entity;

import jp.co.biglobe.warikan.domain.party.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Math.round;

@Getter
@AllArgsConstructor
public class Party {

    private PartyId partyId;

    private PaymentRatio paymentRatio;

    public static Party newInstance(PartyId partyId, PaymentRatio paymentRatio) {
        return new Party(partyId, paymentRatio);
    }

    public int calculateMediumPayment(int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        double largeRatio = paymentRatio.getLargeRatio();
        double mediumRatio = paymentRatio.getMediumRatio();
        double smallRatio = paymentRatio.getSmallRatio();

        double weightSum = mediumRatio * mediumMembersNum + largeRatio * largeMembersNum + smallRatio * smallMembersNum;

        return (int) round(billingAmount / weightSum);
    }

    public int calculateLargePayment(int paymentOfMediumMember) {
        double largeRatio = paymentRatio.getLargeRatio();
        return (int) round(paymentOfMediumMember * largeRatio);
    }

    public int calculateSmallPayment(int paymentOfMediumMember) {
        double smallRatio = paymentRatio.getSmallRatio();
        return (int) round(paymentOfMediumMember * smallRatio);
    }

    public int calculateBalanceDue(int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount, int paymentOfMediumMember, int paymentOfLargeMember, int paymentOfSmallMember) {
        return billingAmount - (paymentOfMediumMember * mediumMembersNum + paymentOfLargeMember * largeMembersNum + paymentOfSmallMember * smallMembersNum);
    }
}
