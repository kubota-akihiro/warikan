package jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BalanceDue {
    int value;

    public static BalanceDue newInstance(int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount, LargePayment largePayment, MediumPayment mediumPayment,SmallPayment smallPayment) {
        int balanceDue = billingAmount - (largePayment.getValue() * largeMembersNum + mediumPayment.getValue() * mediumMembersNum + smallPayment.getValue() * smallMembersNum);
        return new BalanceDue(balanceDue);
    }
}
