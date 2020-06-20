package com.sidiak.CarShop.model.Car;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


import com.sidiak.CarShop.model.Seller;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "mark", length = 15, nullable = false)
    private String mark;

    @Column(name = "model", length = 15, nullable = false)
    private String model;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "vin_code")
    private String vinCode;

    @Column(name = "year_of_production")
    private Integer year;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "fuel_type")
    private String fuel;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_Id",referencedColumnName = "user_id")
    private Seller seller;

    public Car(Long id, String mark, String model,
               String category, BigDecimal price, String vinCode,
               Integer year, Integer mileage, String fuel,
               Date createdAt, Date updatedAt, Seller seller) {
        this.carId = id;
        this.mark = mark;
        this.model = model;
        this.category = category;
        this.price = price;
        this.vinCode = vinCode;
        this.year = year;
        this.mileage = mileage;
        this.fuel = fuel;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.seller = seller;
    }

    @PrePersist
    public void onPrePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = new Date();
    }


}

