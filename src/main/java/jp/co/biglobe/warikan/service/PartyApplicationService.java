package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.factory.IPartyFactory;
import jp.co.biglobe.warikan.domain.service.PartyService;
import jp.co.biglobe.warikan.domain.dto.PaymentModel;
import jp.co.biglobe.warikan.domain.entity.Party;
import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.valueObject.PaymentRatio;

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


    public PaymentModel calculate(int partyId, int largeMembersNum, int mediumMembersNum, int smallMembersNum, int billingAmount) {
        Party party = partyRepository.find(partyId);
        if (Objects.isNull(party)) {
            throw new RuntimeException("指定した飲み会のidは存在していません");
        }

        int paymentOfMediumMember = party.calculateMediumPayment(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int paymentOfLargeMember = party.calculateLargePayment(paymentOfMediumMember);
        int paymentOfSmallMember = party.calculateSmallPayment(paymentOfMediumMember);
        int balanceDue = party.calculateBalanceDue(largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount, paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember);

        return new PaymentModel(paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember, balanceDue);
    }

    public int registerParty(double largeRatio, double mediumRatio, double smallRatio) {
        PaymentRatio paymentRatio = new PaymentRatio(largeRatio, mediumRatio, smallRatio);
        Party party = partyFactory.createParty(paymentRatio);
        partyRepository.save(party);
        return party.getPartyId().getValue();
    }


}
