package com.apartmentmanagement.identity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recovery")
public class RecoveryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "recovery_id", nullable = false)
    private Long recoveryId;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
