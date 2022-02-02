package jp.co.biglobe.warikan.datasource;

import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

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
        Party party;
        if (Objects.isNull(map.get(new PartyId(partyId)))) {
            party = null;
        } else {
            party = Party.newInstance(new PartyId(partyId), map.get(new PartyId(partyId)));
        }
        return party;
    }
}
