package jp.co.biglobe.warikan.datasource;

import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.party.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;

@Repository
public class PartyRepository implements IPartyRepository {

    private static final File FILE = new File("party_data.csv");

    @Override
    public void save(@NonNull Party party) {
        try (FileWriter filewriter = new FileWriter(FILE, true)) {
            filewriter.write(String.format(
                    "%s,%s,%s,%s\n",
                    party.getPartyId().getValue(),
                    party.getPaymentRatio().getLargeRatio(),
                    party.getPaymentRatio().getMediumRatio(),
                    party.getPaymentRatio().getSmallRatio()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Party find(@NonNull int partyId) {

        Double largeRatio = null;
        Double mediumRatio = null;
        Double smallRatio = null;
        try (
                FileReader fr = new FileReader(FILE);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = br.readLine();
            while (line != null) {
                String[] columns = line.split(",");
                if (columns[0].equals(String.valueOf(partyId))) {
                    largeRatio = Double.parseDouble(columns[1]);
                    mediumRatio = Double.parseDouble(columns[2]);
                    smallRatio = Double.parseDouble(columns[3]);
                    break;
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Party party;
        if (Objects.isNull(largeRatio) || Objects.isNull(mediumRatio) || Objects.isNull(smallRatio)) {
            party = null;
        } else {
            party = Party.newInstance(PartyId.newInstance(partyId), PaymentRatio.newInstance(largeRatio, mediumRatio, smallRatio));
        }

        return party;
    }


}
