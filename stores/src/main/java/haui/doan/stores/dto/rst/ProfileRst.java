package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.data.Profile;
import haui.doan.stores.dto.response.ProfileResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRst extends RST {

    private static final long serialVersionUID = 8362681010268830948L;

    private boolean result;

    private Profile profile;

    @Override
    public ProfileResponse toResponse() {
        ProfileResponse response = new ProfileResponse();
        response.setResult(result);
        response.setProfile(profile);
        return response;
    }


}

