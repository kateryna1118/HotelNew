
package ua.softserve.hotel.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="ORDERS")
public class HotelOrder implements Serializable{
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //������
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

//    @OneToMany(mappedBy="order")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="order")
    private Set<AddServiceHistory> addServiceHistory = new HashSet<AddServiceHistory>();

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="ROOM_TYPE_ID")
    private RoomType roomType;


    //��� ����� ��������� ������ ���������� ����� ��� ���������
    //����� ������������� �� ������ roomState � Room
    @Column(nullable = true, name = "NUMBER")
    private int number;

    //���� �������� ���������
    @Column(name = "DATE_IN")
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date DateIn;

    //���� �������� ���������
    @Column(name = "DATE_OUT")
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date DateOut;

    //����� - �� ������� ��� ��� �����
//    @Column(name = "Booking")
//    private double booking;

     //������ ������ - �����+����� �� AddServiceHistory
    //� AddServiceHistory ����� ����� � ���-�� ���� � �� ����
    //���� � �����
    @Column(name = "BALANCE")
    private double balance;

    public Date getDateIn() {
        return DateIn;
    }

    public void setDateIn(Date DateIn) {
        this.DateIn = DateIn;
    }

    public Date getDateOut() {
        return DateOut;
    }

    public void setDateOut(Date DateOut) {
        this.DateOut = DateOut;
    }

    public Set<AddServiceHistory> getAddServiceHistory() {
        return addServiceHistory;
    }

    public void setAddServiceHistory(Set<AddServiceHistory> addServiceHistory) {
        this.addServiceHistory = addServiceHistory;
    }

    public double getBalans() {
        return balance;
    }

    public void setBalans(double balans) {
        this.balance = balans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


}
