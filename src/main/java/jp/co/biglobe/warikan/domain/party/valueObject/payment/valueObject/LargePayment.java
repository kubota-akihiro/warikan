package jp.co.biglobe.warikan.domain.party.valueObject.payment.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Math.round;

@AllArgsConstructor
@Getter
public class LargePayment {
    int value;

    public static LargePayment newInstance(double largeRatio, MediumPayment mediumPayment) {
        return new LargePayment((int) round(mediumPayment.getValue() * largeRatio));
    }
}
