package jp.co.biglobe.warikan.domain;

import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.factory.IPartyFactory;
import jp.co.biglobe.warikan.domain.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

public class TestPartyFactory implements IPartyFactory {
    private static int currentId;

    public Party createParty(PaymentRatio paymentRatio){
        currentId++;
        return Party.of(
                new PartyId(currentId),
                paymentRatio
        );
    }

}
