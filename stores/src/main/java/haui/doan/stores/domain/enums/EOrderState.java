package haui.doan.stores.domain.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EOrderState {
    CART(0, "CART"),
    NEW(1, "NEW"),
    PAYED(2, "PAYED"),
    SUCCESS(3, "SUCCESS"),
    CANCEL(4, "CANCEL");

    private int state;
    private String text;

    EOrderState(int state, String text) {
        this.state = state;
        this.text = text;
    }

    public static EOrderState of(int state) {
        return EnumSet.allOf(EOrderState.class).stream()
                .filter(eOrderState -> eOrderState.getState() == state)
                .findFirst()
                .orElse(null);
    }

}
