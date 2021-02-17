package ar.proyectofinal.proyectofinal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in", nullable = false)
    @Basic(optional = false)
    private Date checkIn;

    @Column(name = "check_out", nullable = false)
    @Basic(optional = false)
    private Date checkOut;

    @Column(name = "cost", nullable = false)
    @Basic(optional = false)
    private float cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guest_id")
    private User guest;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private Room room;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
