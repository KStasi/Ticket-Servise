package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Performance;

public interface PerformanceService {
    public void create(Performance performance);

    public List<Performance> getAll();

    public Performance getById(Long id);

    public void update(Performance performance);

    public void deleteById(Long id);
} 