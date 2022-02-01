package jp.co.biglobe.warikan.api.payment;

import jp.co.biglobe.warikan.datasource.PartyRepository;
import jp.co.biglobe.warikan.domain.PaymentModel;
import jp.co.biglobe.warikan.domain.repository.IPartyRepository;
import jp.co.biglobe.warikan.service.PartyApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentCalculationApi {

    private IPartyRepository partyRepository = new PartyRepository();
    private PartyApplicationService partyApplicationService = new PartyApplicationService(partyRepository);

    @GetMapping("/payment/calculate")
    public PaymentCalculationResponse calculate(PaymentCalculationRequest request) {
        // todo 計算結果を返す
        int largeMembersNum = request.getLargeMembers();
        int mediumMembersNum = request.getMediumMembers();
        int smallMembersNum = request.getSmallMembers();
        int billingAmount = request.getBillingAmount();
        int partyId = request.getPartyId();

        PaymentModel paymentModel = partyApplicationService.calculate(partyId, largeMembersNum, mediumMembersNum, smallMembersNum, billingAmount);

        return new PaymentCalculationResponse(paymentModel.getPaymentOfLargeMember(), paymentModel.getPaymentOfMediumMember(), paymentModel.getPaymentOfSmallMember(), paymentModel.getBalanceDue());
    }

}
