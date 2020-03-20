package haui.doan.stores.framework;

import lombok.Data;

@Data
public class Constants {

    public interface DELETE {
        int FALSE = 0;
        int TRUE = 1;
    }

    public interface DATE_FORMAT {
        String YYYY_MM_DD = "yyyy-MM-dd";
    }

    public interface ERROR_STATUS {
        int SERVICE = 500;
        int VALIDATE = 400;
    }

    public interface IMAGE_DEFAULT {
        String NAME = "/upload/default.png";
    }

}
