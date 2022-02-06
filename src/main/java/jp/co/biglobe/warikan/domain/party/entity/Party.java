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

}
