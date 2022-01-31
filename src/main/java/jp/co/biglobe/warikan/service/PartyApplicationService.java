package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.factory.PartyFactory;
import jp.co.biglobe.warikan.domain.service.PartyService;
import jp.co.biglobe.warikan.domain.PaymentModel;
import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

public class PartyApplicationService {


    private IPartyRepository partyRepository;
    private PartyService partyService;

    public PartyApplicationService(IPartyRepository partyRepository) {
        this.partyRepository = partyRepository;
        partyService = new PartyService(partyRepository);
    }


    public PaymentModel calculate(int partyId, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Party party = partyRepository.find(partyId);
        int paymentOfMediumMember = party.calculateMediumPayment(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int paymentOfLargeMember = party.calculateLargePayment(paymentOfMediumMember);
        int paymentOfSmallMember = party.calculateSmallPayment(paymentOfMediumMember);
        int balanceDue = party.calculateBalanceDue(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount, paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember);

        return new PaymentModel(paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember, balanceDue);
    }

    public int registerParty(double largeRatio, double mediumRatio, double smallRatio) {
        PaymentRatio paymentRatio = new PaymentRatio(largeRatio, mediumRatio, smallRatio);
        Party party = PartyFactory.createParty(paymentRatio);
        partyRepository.save(party);
        return party.getPartyId().getValue();
    }


}
