package com.akondaur.spring.controller;
import java.util.List;

import com.akondaur.model.Performance;
import com.akondaur.spring.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PerformanceController {
    @Autowired
    public PerformanceService performanceService;

    @GetMapping("/performance")
    public List<Performance> getPerformanceAll() {
        return performanceService.getAll();
    }

    @PostMapping("/performance")
    public Performance createPerformance(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "theatre") String theatre
        ) {
        Performance performance = new Performance();
        performance.setId(id);
        performance.setName(name);
        performance.setDescription(description);
        performance.setType(type);
        performance.setTheatre(theatre);

        performanceService.create(performance);
        return performance;
    }

    @GetMapping("/performance/{id}")
    public Performance getPerformance(@PathVariable Long id) {
        return performanceService.getById(id);
    }

    @PutMapping("/performance/{id}")
    public Performance updatePerformance(@PathVariable Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "type", required = false) Integer type,
            @RequestParam(value = "theatre", required = false) String theatre
        ) {
        Performance performance = performanceService.getById(id);

        performance.setName(name);
        performance.setDescription(description);
        performance.setType(type);
        performance.setTheatre(theatre);

        performanceService.update(performance);
        return performance;
    }

    @DeleteMapping("/performance/{id}")
    public Performance deletePerformance(@PathVariable Long id) {
        Performance performance = performanceService.getById(id);
        performanceService.deleteById(id);
        return performance;
    }
}
