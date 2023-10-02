package jp.co.biglobe.warikan.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentModel {
    private int paymentOfMediumMember;
    private int paymentOfLargeMember;
    private int paymentOfSmallMember;
    private int balanceDue;
}
