package com.example.task01.service;

import com.example.task01.domain.Dept;
import com.example.task01.repository.DeptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService {
    private final DeptRepository deptRepository;

    public DeptService(final DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Transactional
    public Dept save(Dept dept) {
        return deptRepository.save(dept);
    }
}
