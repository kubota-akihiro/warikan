package jp.co.biglobe.warikan.domain.valueObject;

import lombok.Getter;

@Getter
public class PaymentRatio {
    private double largeRatio = 1.2;
    private double MediumRatio = 1;
    private double smallRatio = 0.8;

    public PaymentRatio() {
    }

    public PaymentRatio(double largeRatio, double MediumRatio, double smallRatio) {
        this.largeRatio = largeRatio;
        this.MediumRatio = MediumRatio;
        this.smallRatio = smallRatio;
    }
}
