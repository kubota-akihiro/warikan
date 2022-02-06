package jp.co.biglobe.warikan.domain.party.factory;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;

public interface IPartyFactory {

    Party createParty(PaymentRatio paymentRatio);
}
