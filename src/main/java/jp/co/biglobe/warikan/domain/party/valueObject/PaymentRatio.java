package jp.co.biglobe.warikan.domain.party.valueObject;

import lombok.Getter;

@Getter
public class PaymentRatio {
    private double largeRatio = 1.2;
    private double MediumRatio = 1;
    private double smallRatio = 0.8;

    private PaymentRatio() {
    }

    private PaymentRatio(double largeRatio, double MediumRatio, double smallRatio) {
        this.largeRatio = largeRatio;
        this.MediumRatio = MediumRatio;
        this.smallRatio = smallRatio;
    }

    public static PaymentRatio newInstance() {
        return new PaymentRatio();
    }

    public static PaymentRatio newInstance(double largeRatio, double MediumRatio, double smallRatio) {
        return new PaymentRatio(largeRatio, MediumRatio, smallRatio);
    }

}
