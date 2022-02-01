package jp.co.biglobe.warikan.api.party;

import jp.co.biglobe.warikan.datasource.PartyRepository;
import jp.co.biglobe.warikan.domain.factory.PartyFactory;
import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import jp.co.biglobe.warikan.service.PartyApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartyRegistrationApi {
    private IPartyRepository partyRepository = new PartyRepository();
    private PartyFactory partyFactory = new PartyFactory();
    private PartyApplicationService partyApplicationService = new PartyApplicationService(partyRepository, partyFactory);

    @GetMapping("/party/register")
    public PartyRegistrationResponse registerParty(PartyRegistrationRequest request) {

        double largeRatio = request.getLargeRatio();
        double mediumRatio = request.getMediumRatio();
        double smallRatio = request.getSmallRatio();

        int createdPartyId = partyApplicationService.registerParty(largeRatio, mediumRatio, smallRatio);

        return new PartyRegistrationResponse(createdPartyId);

    }
}
