package com.zandroid.volume;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityListeners(AuditingEntityListener.class)
public class Volume {

    private @Id @GeneratedValue
    Long id;

    private final String volumeType;

    private final String status;

    private final Integer size;

    private final String name;

    @Version
    private Long version;

    @CreatedBy
    @JsonIgnore
    private String user;

    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdDate;

    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime modifiedDate;


    Volume() {
        this.volumeType = null;
        this.status = null;
        this.size = null;
        this.name = null;
        this.user = null;
    }
}
