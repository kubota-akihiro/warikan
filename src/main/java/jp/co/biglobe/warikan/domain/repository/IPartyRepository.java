package jp.co.biglobe.warikan.domain.repository;

import jp.co.biglobe.warikan.domain.entity.Party;
import lombok.NonNull;

public interface IPartyRepository {

    void save(@NonNull Party party);

    Party find(@NonNull int partyId);
}
