package haui.doan.stores.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import haui.doan.stores.dto.data.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse extends RESPONSE {

    private boolean result;

    @JsonInclude(NON_NULL)
    private Profile profile;

}
