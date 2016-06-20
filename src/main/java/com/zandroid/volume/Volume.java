package com.zandroid.volume;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Volume extends AuditEntity implements Identifiable<Integer> {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    private final String volumeType;

    private final String status;

    private final Integer size;

    private final String name;


    Volume() {
        this.volumeType = null;
        this.status = null;
        this.size = null;
        this.name = null;
    }
}
