package jp.co.biglobe.warikan.domain.payment.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Math.round;

@AllArgsConstructor
@Getter
public class SmallPayment {
    int value;

    public static SmallPayment newInstance(double smallRatio, MediumPayment mediumPayment) {
        return new SmallPayment((int) round(mediumPayment.getValue() * smallRatio));
    }
}
