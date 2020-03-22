package haui.doan.stores.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "producer")
    private String producer;

    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @Column(name = "cost")
    private double cost;

    @Column(name = "year_release")
    private String yearRelease;

    @Column(name = "os")
    private String os;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "gpu")
    private String gpu;

    @Column(name = "screen")
    private String screen;

    @Column(name = "ram")
    private String ram;

    @Column(name = "power")
    private int power;

    @Column(name = "storage")
    private String storage;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<TicketItem> ticketItems = Collections.EMPTY_LIST;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = Collections.EMPTY_LIST;
}
