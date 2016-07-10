package com.zandroid.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zandroid.config.AuditEntity;
import com.zandroid.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data

public class Appointment extends AuditEntity {
	@Column(name = "TRAK_NBR")
	private String trackNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "appointment")
	private Set<Product> products = new HashSet<Product>();
}
