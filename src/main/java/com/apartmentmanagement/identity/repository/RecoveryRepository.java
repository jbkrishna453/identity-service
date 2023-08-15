package com.apartmentmanagement.identity.repository;

import com.apartmentmanagement.identity.entity.RecoveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecoveryRepository extends JpaRepository<RecoveryEntity,Integer> {
    RecoveryEntity findByRecoveryId(Long recoveryId);
}
