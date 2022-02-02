package jp.co.biglobe.warikan.domain.factory;

import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

public class TestPartyFactory implements IPartyFactory {
    private static int currentId;

    public Party createParty(PaymentRatio paymentRatio) {
        currentId++;
        return Party.newInstance(
                new PartyId(currentId),
                paymentRatio
        );
    }

}
