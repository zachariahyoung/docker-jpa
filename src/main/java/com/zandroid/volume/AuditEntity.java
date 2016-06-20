package com.zandroid.volume;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 *
 */
@MappedSuperclass
@Data
@EntityListeners(value=AuditingEntityListener.class)
public abstract class AuditEntity {

    /**
     * createTimestamp
     */
    @Column(name = "CreateTimestamp", nullable = false, updatable = false)
    @JsonIgnore
    @CreatedDate
    private LocalDateTime createTimestamp;
    /**
     * lastUpdatedTimestamp
     */
    @Column(name = "CreateProgramCode", nullable = false, length = 30)
    @JsonIgnore
    private String createProgramCode;
    /**
     * lastUpdatedTimestamp
     */
    @Column(name = "LastUpdatedTimestamp", nullable = false)
    @JsonIgnore
    @LastModifiedDate
    private LocalDateTime lastUpdatedTimestamp;
    /**
     * lastUpdatedProgramCode
     */
    @Column(name = "LastUpdatedProgramCode", nullable = false, length = 30)
    @JsonIgnore
    private String lastUpdatedProgramCode;
    /**
     * createUserId
     */
    @Column(name = "CreateUserID", length = 8, nullable = false)
    @JsonIgnore
    @CreatedBy
    private String createUserId;
    /**
     * lastUpdatedUserId
     */
    @Column(name = "LastUpdatedUserID", length = 8, nullable = false)
    @JsonIgnore
    @LastModifiedBy
    private String lastUpdatedUserId;

    @Version
    private Long version;

    /**
     * Prepersist method which invokes before this entity is persisted
     */
    @PrePersist
    public void prePersist() {
        setCreateProgramCode("claimsService");
        setLastUpdatedProgramCode("claimsService");
    }
}