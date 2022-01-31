package jp.co.biglobe.warikan.api.payment;

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

