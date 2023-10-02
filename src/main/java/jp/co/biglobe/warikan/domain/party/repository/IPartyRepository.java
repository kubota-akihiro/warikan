package jp.co.biglobe.warikan.domain.party.repository;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import lombok.NonNull;

public interface IPartyRepository {

    void save(@NonNull Party party);

    Party find(@NonNull int partyId);
}
