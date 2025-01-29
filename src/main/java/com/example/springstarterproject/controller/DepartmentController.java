package com.example.springstarterproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springstarterproject.domain.Department;
import com.example.springstarterproject.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping("/execute")
    public String execute(){

        Department department = service.load(1);
        System.out.println(department);
        return "finished";
    }
}
