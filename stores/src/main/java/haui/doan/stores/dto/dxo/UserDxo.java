package haui.doan.stores.dto.dxo;

import haui.doan.stores.domain.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDxo extends DXO {

    private static final long serialVersionUID = 1110574983275718827L;

    private Long id;

    private String userName;

    private String imageLink;

    private MultipartFile image;

    private String address;

    private String phone;

    private EGender gender;

    private Date birthDay;

    private int deleted;

    private String usernameOld;

}
