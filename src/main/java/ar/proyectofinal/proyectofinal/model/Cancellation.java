package ar.proyectofinal.proyectofinal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cancellations")
public class Cancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    @Basic(optional = false)
    private Date createdAt;

    @OneToOne(optional = false)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
