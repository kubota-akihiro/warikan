package jp.co.biglobe.warikan.domain.valueObject;

import lombok.Getter;

@Getter
public class PaymentRatio {
    public double largeRatio = 1.2;
    public double MediumRatio = 1;
    public double smallRatio = 0.8;

    public PaymentRatio() {
    }

    public PaymentRatio(double largeRatio, double MediumRatio, double smallRatio) {
        this.largeRatio = largeRatio;
        this.MediumRatio = MediumRatio;
        this.smallRatio = smallRatio;
    }
}
