package jp.co.biglobe.warikan.datasource;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.party.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class TestPartyRepository implements IPartyRepository {
    private Map<PartyId, PaymentRatio> map = new HashMap<>();

    @Override
    public void save(Party party) {
        map.put(party.getPartyId(), party.getPaymentRatio());
    }

    @Override
    public Party find(int partyId) {
        PartyId tempPartyId = PartyId.newInstance(partyId);
        PaymentRatio paymentRatio = map.get(tempPartyId);
        Party party;
        if (Objects.isNull(paymentRatio)) {
            party = null;
        } else {
            party = Party.newInstance(tempPartyId, paymentRatio);
        }
        return party;
    }
}
