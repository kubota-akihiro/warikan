package jp.co.biglobe.warikan.service;

import jp.co.biglobe.warikan.domain.party.factory.IPartyFactory;
import jp.co.biglobe.warikan.domain.party.service.PartyService;
import jp.co.biglobe.warikan.domain.party.entity.Party;
import jp.co.biglobe.warikan.domain.party.repository.IPartyRepository;
import jp.co.biglobe.warikan.domain.party.valueObject.PaymentRatio;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
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

        int paymentOfMediumMember = party.getMediumPayment(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int paymentOfLargeMember = party.getLargePayment(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int paymentOfSmallMember = party.getSmallPayment(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);
        int balanceDue = party.getBalanceDue(party.getPaymentRatio(), largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);

        return new PaymentModel(paymentOfMediumMember, paymentOfLargeMember, paymentOfSmallMember, balanceDue);
    }

    public int registerParty(double largeRatio, double mediumRatio, double smallRatio) {
        PaymentRatio paymentRatio = PaymentRatio.newInstance(largeRatio, mediumRatio, smallRatio);
        Party party = partyFactory.createParty(paymentRatio);
        partyRepository.save(party);
        return party.getPartyId().getValue();
    }


}
