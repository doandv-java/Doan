package haui.doan.stores.domain.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ERole {
    CUSTOMER(0, "CUSTOMER"),
    EMPLOYEE(1, "EMPLOYEE"),
    ADMIN(2, "ADMIN");

    private int role;
    private String text;

    ERole(int role, String text) {
        this.role = role;
        this.text = text;
    }

    public static ERole of(int role) {
        return EnumSet.allOf(ERole.class).stream()
                .filter(eRole -> eRole.getRole() == role)
                .findFirst()
                .orElse(null);
    }
}
