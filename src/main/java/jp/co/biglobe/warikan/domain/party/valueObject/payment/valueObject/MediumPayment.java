package jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject;

import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Math.round;

@AllArgsConstructor
@Getter
public class MediumPayment {
    int value;

    public static MediumPayment newInstance(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        double largeRatio = paymentRatio.getLargeRatio();
        double mediumRatio = paymentRatio.getMediumRatio();
        double smallRatio = paymentRatio.getSmallRatio();

        double weightSum = mediumRatio * mediumMembersNum + largeRatio * largeMembersNum + smallRatio * smallMembersNum;

        return new MediumPayment( (int) round(billingAmount / weightSum));
    }

}
