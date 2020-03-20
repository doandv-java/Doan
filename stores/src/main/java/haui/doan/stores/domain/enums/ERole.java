package haui.doan.stores.domain.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ERole {
    CUSTOMER(0, "CUSTOMER"),
    EMPLOYEE(1, "EMPLOYEE"),
    ADMIN(2, "ADMIN");

    private int value;
    private String text;

    ERole(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public static ERole of(int value) {
        return EnumSet.allOf(ERole.class).stream()
                .filter(eRole -> eRole.getValue() == value)
                .findFirst()
                .orElse(null);
    }
}
