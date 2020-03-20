package haui.doan.stores.dto.request;

import haui.doan.stores.domain.enums.EGender;
import haui.doan.stores.domain.enums.ERole;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends REQUEST {

    private static final long serialVersionUID = 7255868713349060068L;

    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private int role;

    private String name;

    private String imageLink;

    private MultipartFile image;

    private String address;

    private String phone;

    @NotBlank
    private int gender;

    private String birthDay;

    private int status;

    private int deleted;

    private String usernameOld;

    /**
     * Convert data prom controller to business layer
     *
     * @return the data of user {@link UserDxo}
     */
    @Override
    public UserDxo toDxo() {
        UserDxo userDxo = new UserDxo();
        userDxo.setId(id);
        userDxo.setUserName(StringUtils.trimToEmpty(username));
        userDxo.setRole(ERole.of(role));
        userDxo.setName(StringUtils.capitalize(StringUtils.trimToEmpty(name)));
        userDxo.setImageLink(imageLink);
        userDxo.setImage(image);
        userDxo.setAddress(StringUtils.capitalize(StringUtils.trimToEmpty(address)));
        userDxo.setPhone(StringUtils.trimToEmpty(phone));
        userDxo.setGender(EGender.of(gender));
        userDxo.setStatus(status);
        birthDay = StringUtils.trimToEmpty(birthDay);
        Date birthDate = null;
        //Check string birth day is null
        if (StringUtils.isNotEmpty(birthDay)) {
            birthDate = DateUtils.parseExact(birthDay, Constants.DATE_FORMAT.YYYY_MM_DD);
        }
        userDxo.setBirthDay(birthDate);
        //Check id if create or update data
        if (id != null) {
            //update user
            userDxo.setDeleted(deleted);
        } else {
            //create user
            userDxo.setDeleted(Constants.DELETE.FALSE);
        }
        userDxo.setUsernameOld(StringUtils.trimToEmpty(usernameOld));
        return userDxo;
    }
}
