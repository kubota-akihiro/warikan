package jp.co.biglobe.warikan.domain.party.service;

import jp.co.biglobe.warikan.domain.party.repository.IPartyRepository;
import lombok.AllArgsConstructor;

//ドメインサービス
@AllArgsConstructor
public class PartyService {

    private IPartyRepository partyRepository;

}
