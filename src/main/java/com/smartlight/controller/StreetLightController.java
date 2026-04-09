package com.smartlight.controller;

import com.smartlight.entity.StreetLight;
import com.smartlight.service.StreetLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/light")
@CrossOrigin
public class StreetLightController {

    @Autowired
    private StreetLightService service;

    @PostMapping("/add")
    public StreetLight addLight(@RequestBody StreetLight light) {
        return service.save(light);
    }

    @GetMapping("/all")
    public List<StreetLight> getAllLights() {
        return service.getAll();
    }

    @PutMapping("/toggle/{id}")
    public StreetLight toggleLight(@PathVariable Long id) {
        return service.toggle(id);
    }

    // 🔥 CLEAR API
    @DeleteMapping("/clear")
    public void clearAllLights() {
        service.deleteAll();
    }
}