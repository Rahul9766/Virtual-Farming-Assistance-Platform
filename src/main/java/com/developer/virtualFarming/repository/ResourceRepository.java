package com.developer.virtualFarming.repository;



import com.developer.virtualFarming.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    // Additional query methods (if needed) can be added here.
}
