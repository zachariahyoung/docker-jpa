package com.zandroid.product;

import com.zandroid.appointment.Appointment;
import com.zandroid.config.AuditEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product extends AuditEntity {

    @Column
    private String model;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

}
