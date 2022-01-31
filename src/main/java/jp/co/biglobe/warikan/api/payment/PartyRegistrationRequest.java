package jp.co.biglobe.warikan.api.payment;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class PartyRegistrationRequest {


    /**
     * 多めの割合
     */
    private double largeRatio;

    /**
     * 通常の割合
     */
    private double mediumRatio;

    /**
     * 少なめの割合
     */
    private double smallRatio;

}
