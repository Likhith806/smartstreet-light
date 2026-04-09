package com.smartlight.service;

import com.smartlight.entity.StreetLight;
import com.smartlight.repository.StreetLightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class StreetLightService {

    @Autowired
    private StreetLightRepository repo;

    @PersistenceContext
    private EntityManager entityManager;

    // ✅ Add light (AI logic)
    public StreetLight save(StreetLight light) {

        int brightness;
        if (light.getLightLevel() < 30) brightness = 90;
        else if (light.getLightLevel() < 60) brightness = 60;
        else brightness = 30;

        light.setBrightness(brightness);
        return repo.save(light);
    }

    // ✅ Get all lights
    public List<StreetLight> getAll() {
        return repo.findAll();
    }

    // ✅ Toggle ON/OFF
    public StreetLight toggle(Long id) {
        StreetLight light = repo.findById(id).orElse(null);

        if (light != null) {
            if (light.getStatus().equals("ON")) {
                light.setStatus("OFF");
                light.setBrightness(0);
            } else {
                light.setStatus("ON");

                int level = light.getLightLevel();
                if (level < 30) light.setBrightness(90);
                else if (level < 60) light.setBrightness(60);
                else light.setBrightness(30);
            }

            return repo.save(light);
        }

        return null;
    }

    // 🔥 CLEAR ALL + RESET AUTO_INCREMENT
    @Transactional
    public void deleteAll() {
        repo.deleteAll();

        // Reset ID counter
        entityManager
            .createNativeQuery("ALTER TABLE street_light AUTO_INCREMENT = 1")
            .executeUpdate();
    }
}