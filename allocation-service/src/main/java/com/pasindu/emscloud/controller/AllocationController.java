package com.pasindu.emscloud.controller;

import com.pasindu.emscloud.commons.model.Allocation;
import com.pasindu.emscloud.commons.model.Employee;
import com.pasindu.emscloud.service.AllocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emscloud")
public class AllocationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationController.class);
    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {
        return new ResponseEntity<Allocation>(allocationService.save(allocation), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/allocation/employee/{empId}", method = RequestMethod.GET)
    public ResponseEntity<List<Allocation>> fetchByEmployeeId(@PathVariable(value = "empId") Integer id) {
        return new ResponseEntity<>(allocationService.findByEmployeeId(id), HttpStatus.OK);
    }
}
