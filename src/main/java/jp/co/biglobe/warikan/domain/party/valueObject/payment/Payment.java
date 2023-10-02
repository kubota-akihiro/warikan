package jp.co.biglobe.warikan.domain.party.valueObject.payment;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject.LargePayment;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject.MediumPayment;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject.SmallPayment;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject.BalanceDue;
import lombok.Getter;

@Getter
public class Payment {
    private LargePayment largePayment;
    private MediumPayment mediumPayment;
    private SmallPayment smallPayment;
    private BalanceDue balanceDue;

    public Payment(PaymentRatio paymentRatio, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        this.mediumPayment = MediumPayment.newInstance(paymentRatio, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        this.largePayment = LargePayment.newInstance(paymentRatio.getLargeRatio(), this.mediumPayment);
        this.smallPayment = SmallPayment.newInstance(paymentRatio.getSmallRatio(), this.mediumPayment);
        this.balanceDue = BalanceDue.newInstance(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount, this.largePayment, this.mediumPayment, this.smallPayment);
    }

}
