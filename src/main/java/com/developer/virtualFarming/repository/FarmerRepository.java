package com.developer.virtualFarming.repository;



import com.developer.virtualFarming.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    // Custom query methods (if needed) can be added here.
}

