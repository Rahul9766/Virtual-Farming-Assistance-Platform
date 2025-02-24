package com.developer.virtualFarming.repository;


import com.developer.virtualFarming.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    // Additional query methods (if needed) can be added here.
}

