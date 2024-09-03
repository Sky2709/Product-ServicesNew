package com.akash.productservicesnew.repositories;

import com.akash.productservicesnew.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(UUID uuid);


    boolean existsById(UUID id);
}
