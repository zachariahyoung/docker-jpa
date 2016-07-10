package com.zandroid.appointment;

import com.zandroid.config.AuditEntity;
import com.zandroid.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Appointment extends AuditEntity {

    @Column
    private String trackNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "appointment")
    private List<Product> products = new ArrayList<>();
}
