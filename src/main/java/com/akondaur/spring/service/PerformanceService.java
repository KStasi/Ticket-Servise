package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Performance;
import com.akondaur.spring.dao.PerformanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {
    @Autowired
    PerformanceDAO performanceDAO;

    public void create(Performance performance) {
        performanceDAO.create(performance);
    }

    public List<Performance> getAll() {
        return performanceDAO.getAll();
    }

    public Performance getById(Long id) {
        return performanceDAO.getById(id);
    }

    public void update(Performance performance) {
        performanceDAO.update(performance);
    }

    public void deleteById(Long id) {
        performanceDAO.deleteById(id);
    }
} 