package com.example.springstarterproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springstarterproject.domain.Department;
import com.example.springstarterproject.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

        public Department load(Integer id){
        return repository.load(id);
    }
}
