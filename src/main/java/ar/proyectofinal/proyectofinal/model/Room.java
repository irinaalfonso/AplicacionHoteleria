package ar.proyectofinal.proyectofinal.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "price", nullable = false)
    @Basic(optional = false)
    private float price;

    @Column(name = "occupancy", nullable = false)
    @Basic(optional = false)
    private int occupancy;

    @Column(name = "availability", nullable = false)
    @Basic(optional = false)
    private int availability;

    @Column(name = "facilities")
    private String facilities;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
