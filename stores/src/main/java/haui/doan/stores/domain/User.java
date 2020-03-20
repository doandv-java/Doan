package haui.doan.stores.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private int gender;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "status")
    private int status;

    @Column(name = "deleted")
    private int deleted;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Order> orders = new ArrayList<>();
}
