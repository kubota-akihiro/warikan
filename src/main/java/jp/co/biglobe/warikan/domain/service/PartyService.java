package jp.co.biglobe.warikan.domain.service;

import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import lombok.AllArgsConstructor;

//ドメインサービス
@AllArgsConstructor
public class PartyService {

    private IPartyRepository partyRepository;

}
