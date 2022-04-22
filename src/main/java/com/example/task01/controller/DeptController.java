package com.example.task01.controller;

import com.example.task01.domain.Dept;
import com.example.task01.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping("/api/dept")
    public ResponseEntity<?> deptSave(@RequestBody Dept dept) {
        System.out.println("deptName:" + dept.getDname());
        return new ResponseEntity<>(deptService.save(dept), HttpStatus.CREATED);
    }

    @GetMapping("/api/dept")
    public ResponseEntity<String> deptSelectAll() {

        return ResponseEntity.ok("OK");
    }

}
