package jp.co.biglobe.warikan.service;


import jp.co.biglobe.warikan.datasource.TestPartyRepository;
import jp.co.biglobe.warikan.domain.TestPartyFactory;
import jp.co.biglobe.warikan.domain.dto.PaymentModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyApplicationServiceTest {
    private PartyApplicationService partyApplicationService = new PartyApplicationService(new TestPartyRepository(), new TestPartyFactory());

    @Test
    public void calculatePayment() {
        partyApplicationService.registerParty(1.2, 1.0, 0.8);
        PaymentModel paymentModel = partyApplicationService.calculate(1, 1, 2, 0, 20000);

        assertEquals(7500, paymentModel.getPaymentOfLargeMember());
        assertEquals(6250, paymentModel.getPaymentOfMediumMember());
        assertEquals(0, paymentModel.getBalanceDue());


        assertEquals(2, 2);
        assertEquals(3, 3);
        assertEquals(4, 4);

    }

}
