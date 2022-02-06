package jp.co.biglobe.warikan.domain.factory;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.factory.IPartyFactory;
import jp.co.biglobe.warikan.domain.party.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;

public class TestPartyFactory implements IPartyFactory {
    private static int currentId;

    public Party createParty(PaymentRatio paymentRatio) {
        currentId++;
        return Party.newInstance(
                PartyId.newInstance(currentId),
                paymentRatio
        );
    }

}
