package jp.co.biglobe.warikan.domain.payment.entity;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.payment.valueObject.BalanceDue;
import jp.co.biglobe.warikan.domain.payment.valueObject.LargePayment;
import jp.co.biglobe.warikan.domain.payment.valueObject.MediumPayment;
import jp.co.biglobe.warikan.domain.payment.valueObject.SmallPayment;
import lombok.Getter;

@Getter
public class Payment {
    private LargePayment largePayment;
    private MediumPayment mediumPayment;
    private SmallPayment smallPayment;
    private BalanceDue balanceDue;

    public Payment(Party party, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        this.mediumPayment = MediumPayment.newInstance(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        this.largePayment = LargePayment.newInstance(party.getPaymentRatio().getLargeRatio(), this.mediumPayment);
        this.smallPayment = SmallPayment.newInstance(party.getPaymentRatio().getSmallRatio(), this.mediumPayment);
        this.balanceDue = BalanceDue.newInstance(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount, this.largePayment, this.mediumPayment, this.smallPayment);
    }

}
