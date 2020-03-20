package haui.doan.stores.domain.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EPay {
    BANK(0, "Bank"),
    COD(2, "COD");

    private int value;
    private String text;

    EPay(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static EPay of(int value) {
        return EnumSet.allOf(EPay.class).stream()
                .filter(ePay -> ePay.getValue() == value)
                .findFirst()
                .orElse(null);
    }
}
