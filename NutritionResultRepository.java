package com.nutri.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.nutri.model.NutritionResult;

public interface NutritionResultRepository extends JpaRepository<NutritionResult, Long> {

}
