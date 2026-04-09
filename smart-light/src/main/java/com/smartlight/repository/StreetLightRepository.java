package com.smartlight.repository;

import com.smartlight.entity.StreetLight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetLightRepository extends JpaRepository<StreetLight, Long> {
}