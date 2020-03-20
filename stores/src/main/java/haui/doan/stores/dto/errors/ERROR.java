package haui.doan.stores.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ERROR implements Serializable {

    private static final long serialVersionUID = 6502371702706002488L;

    private String field;

    private String message;

}
