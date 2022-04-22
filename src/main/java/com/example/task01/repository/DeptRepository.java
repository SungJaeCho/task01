package com.example.task01.repository;

import com.example.task01.domain.Dept;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Dept, Long> {
}
