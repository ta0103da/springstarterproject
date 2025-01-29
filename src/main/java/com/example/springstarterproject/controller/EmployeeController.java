package com.example.springstarterproject.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springstarterproject.domain.Employee;
import com.example.springstarterproject.form.EmployeeForm;
import com.example.springstarterproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @ModelAttribute
    public EmployeeForm setUpForm() {
        return new EmployeeForm();
    }
    @Autowired
    private EmployeeService service;

    // @RequestMapping("/execute")
    // public String execute(Model model){

    //     // Employee employee = new Employee();
    //     // employee.setName("山田 太郎");
    //     // employee.setAge(20);
    //     // employee.setGender("男");
    //     // employee.setDepartmentId(1);
    //     // employee = service.save(employee);

    //     // Employee employee2 = service.load(3);
    //     // System.out.println(employee2);
    //     // service.deleteById(3);
    //     List<Employee> empList = service.findAll();

    //     model.addAttribute("employees", empList);

    //     for(Employee emp : empList){
    //         System.out.println(emp);
    //     }
    //     service.findAll().forEach(System.out::println);

    //     return "employeeFinish";
    //     // return "finished";
    // }

    
    @RequestMapping("")
    public String execute(){
        return "/employeeInput";
    }
    @RequestMapping("/input")
    public String executeInput(@Validated EmployeeForm form,BindingResult result,
            RedirectAttributes redirectAttributes,Model model){

        Employee employee = new Employee();
        BeanUtils.copyProperties(form, employee);
        employee = service.save(employee);

        redirectAttributes.addFlashAttribute("questionnaire", employee);

        return "/finished";
    }
}
