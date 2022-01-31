package jp.co.biglobe.warikan.domain;

import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.valueObject.PartyId;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyFactory {

    private static final File FILE = new File("party_data.csv");

    public static Party createParty(PaymentRatio paymentRatio) {

        List<Integer> idList = new ArrayList<>();
        try (
                FileReader fr = new FileReader(FILE);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = br.readLine();
            while (line != null) {
                String[] columns = line.split(",");
                idList.add(Integer.parseInt(columns[0]));
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int partyId;
        if (idList.isEmpty()) {
            partyId = 1;
        } else {
            partyId = Collections.max(idList) + 1;
        }


        return Party.of(
                new PartyId(partyId),
                paymentRatio
        );

    }
}


