package jp.co.biglobe.warikan.api.party;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
public class PartyRegistrationResponse {

    @Getter
    private final int createdPartyId;

}

