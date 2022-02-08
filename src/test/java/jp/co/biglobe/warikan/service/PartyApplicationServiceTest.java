package jp.co.biglobe.warikan.service;


import jp.co.biglobe.warikan.datasource.TestPartyRepository;
import jp.co.biglobe.warikan.domain.factory.TestPartyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyApplicationServiceTest {
    private PartyApplicationService partyApplicationService = new PartyApplicationService(new TestPartyRepository(), new TestPartyFactory());

    @Test
    public void calculatePayment() {
        partyApplicationService.registerParty(1.2, 1.0, 0.8);
        partyApplicationService.registerParty(1.2, 1.0, 0.8);
        assertCalculatePayment(1, 1, 2, 0, 20000,
                7500, 6250, 5000, 0);
        assertCalculatePayment(2, 1, 2, 0, 20000,
                7500, 6250, 5000, 0);
//        //存在しないIDを入力してエラーになるパターン
//        assertCalculatePayment(3, 1, 2, 0, 20000,
//                7500, 6250, 5000, 0);
        assertCalculatePayment(1, 1, 2, 2, 30000,
                7500, 6250, 5000, 0);
        assertCalculatePayment(1, 1, 2, 2, 35000,
                8750, 7292, 5834, -2);
        assertCalculatePayment(1, 1, 2, 2, 20000,
                5000, 4167, 3334, -2);
        assertCalculatePayment(2, 5, 3, 4, 20000,
                1967, 1639, 1311, 4);

        partyApplicationService.registerParty(1.0, 1.0, 1.0);
        assertCalculatePayment(3, 5, 2, 3, 30000,
                3000, 3000, 3000, 0);
        partyApplicationService.registerParty(1.5, 1.0, 0.5);
        assertCalculatePayment(4, 1, 1, 1, 30000,
                15000, 10000, 5000, 0);


    }

    private void assertCalculatePayment(int partyId, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount,
                                        int expectedPaymentOfLargeMember, int expectedPaymentOfMediumMember, int expectedPaymentOfSmallMember, int expectedBalanceDue) {

        PaymentModel paymentModel = partyApplicationService.calculatePayment(partyId, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        assertEquals(expectedPaymentOfLargeMember, paymentModel.getPaymentOfLargeMember());
        assertEquals(expectedPaymentOfMediumMember, paymentModel.getPaymentOfMediumMember());
        assertEquals(expectedPaymentOfSmallMember, paymentModel.getPaymentOfSmallMember());
        assertEquals(expectedBalanceDue, paymentModel.getBalanceDue());
    }

}
