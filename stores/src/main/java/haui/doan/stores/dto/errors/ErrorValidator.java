package haui.doan.stores.dto.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorValidator extends ERROR {

    public ErrorValidator(String field, String message) {
        super(field, message);
    }
}
