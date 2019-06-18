package com.pasindu.emscloud.controller;

import com.pasindu.emscloud.commons.model.Employee;
import com.pasindu.emscloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emscloud")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
    }
}
