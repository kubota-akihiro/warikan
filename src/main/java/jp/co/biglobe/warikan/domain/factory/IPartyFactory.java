package jp.co.biglobe.warikan.domain.factory;

import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

public interface IPartyFactory {

    Party createParty(PaymentRatio paymentRatio);
}
