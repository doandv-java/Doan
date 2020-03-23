package haui.doan.stores.dto.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private Long id;

    private String userName;

    private String password;

    private String role;

    private String name;

    private String imageLink;

    private String phone;

    private String address;

    private String gender;

    private Date birthDay;

    private int status;

    private int deleted;
}
