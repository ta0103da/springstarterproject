package com.example.springstarterproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springstarterproject.domain.Employee;
import com.example.springstarterproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/execute")
    public String execute(){

        Employee employee = new Employee();
        employee.setName("山田 太郎");
        employee.setAge(20);
        employee.setGender("男");
        employee.setDepartmentId(1);
        employee = service.save(employee);

        Employee employee2 = service.load(3);
        System.out.println(employee2);
        service.deleteById(3);
        List<Employee> empList = service.findAll();

        for(Employee emp : empList){
            System.out.println(emp);
        }
        service.findAll().forEach(System.out::println);

        return "finished";
    }
}
