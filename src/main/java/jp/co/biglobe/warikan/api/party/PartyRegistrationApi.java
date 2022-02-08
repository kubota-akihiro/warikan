package jp.co.biglobe.warikan.api.party;

import jp.co.biglobe.warikan.service.PartyApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartyRegistrationApi {

    @Autowired
    private PartyApplicationService partyApplicationService;

    @GetMapping("/party/register")
    public PartyRegistrationResponse register(PartyRegistrationRequest request) {

        double largeRatio = request.getLargeRatio();
        double mediumRatio = request.getMediumRatio();
        double smallRatio = request.getSmallRatio();

        int createdPartyId = partyApplicationService.registerParty(largeRatio, mediumRatio, smallRatio);

        return new PartyRegistrationResponse(createdPartyId);

    }
}
