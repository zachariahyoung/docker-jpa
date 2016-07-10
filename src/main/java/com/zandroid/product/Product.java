package com.zandroid.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zandroid.appointment.Appointment;
import com.zandroid.config.AuditEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data

public class Product extends AuditEntity {

    @Column(name = "PRD_MDL_NBR")
    private String model;

    @Column(name = "PRD_SPEC_DSC")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

}
