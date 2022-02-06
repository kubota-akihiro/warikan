package jp.co.biglobe.warikan.domain.party.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class PartyId {
    private int value;

    public static PartyId newInstance(int partyId) {
        return new PartyId(partyId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartyId partyId = (PartyId) o;
        return value == partyId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
