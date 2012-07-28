package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "F_NAME")
    private String fName;

    @Column(name = "L_NAME")
    private String lName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private int phone;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private User user;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getPhon() {
        return phone;
    }

    public void setPhon(int phon) {
        this.phone = phon;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
