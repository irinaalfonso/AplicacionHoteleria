package ar.proyectofinal.proyectofinal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    @Basic(optional = false)
    private Date createdAt;

    @Column(name = "card", nullable = false)
    @Basic(optional = false)
    private String card;

    @Column(name = "card_number", nullable = false)
    @Basic(optional = false)
    private String cardNumber;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
