package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.party.factory.IPartyFactory;
import jp.co.biglobe.warikan.domain.party.service.PartyService;
import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import jp.co.biglobe.warikan.domain.party.valueObject.payment.Payment;

import java.util.Objects;

public class PartyApplicationService {


    private IPartyRepository partyRepository;
    private PartyService partyService;
    private IPartyFactory partyFactory;

    public PartyApplicationService(IPartyRepository partyRepository, IPartyFactory partyFactory) {
        this.partyRepository = partyRepository;
        this.partyService = new PartyService(partyRepository);
        this.partyFactory = partyFactory;
    }


    public PaymentModel calculatePayment(int partyId, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Party party = partyRepository.find(partyId);
        if (Objects.isNull(party)) {
            throw new RuntimeException("指定した飲み会のidは存在していません");
        }

        Payment payment = new Payment(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int paymentOfMediumMember = payment.getMediumPayment().getValue();
        int paymentOfLargeMember = payment.getLargePayment().getValue();
        int paymentOfSmallMember = payment.getSmallPayment().getValue();
        int balanceDue = payment.getBalanceDue().getValue();

        return new PaymentModel(paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember, balanceDue);
    }

    public int registerParty(double largeRatio, double mediumRatio, double smallRatio) {
        PaymentRatio paymentRatio = PaymentRatio.newInstance(largeRatio, mediumRatio, smallRatio);
        Party party = partyFactory.createParty(paymentRatio);
        partyRepository.save(party);
        return party.getPartyId().getValue();
    }


}
