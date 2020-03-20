package haui.doan.stores.domain.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EUserStatus {
    OFFLINE(0),
    ONLINE(1);

    private int status;

    EUserStatus(int status) {
        this.status = status;
    }

    public static EUserStatus ofStatus(int status) {
        return EnumSet.allOf(EUserStatus.class).stream()
                .filter(eUserStatus -> eUserStatus.getStatus() == status)
                .findFirst()
                .orElse(null);
    }

}
