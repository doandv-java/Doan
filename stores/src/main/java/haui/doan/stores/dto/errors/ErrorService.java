package haui.doan.stores.dto.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorService extends ERROR {
    public ErrorService(String field, String message) {
        super(field, message);
    }
}
