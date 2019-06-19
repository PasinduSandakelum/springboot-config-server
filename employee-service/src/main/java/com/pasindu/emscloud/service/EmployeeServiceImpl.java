package com.pasindu.emscloud.service;

import com.pasindu.emscloud.commons.model.Allocation;
import com.pasindu.emscloud.commons.model.Employee;
import com.pasindu.emscloud.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Employee findById(Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        if (optional.isPresent()) {

            LOGGER.info("Before calling allocation-service");
            Allocation[] response = restTemplate.getForObject("http://localhost:9291/emscloud/allocation/employee/"
                    .concat(employee.getId().toString()), Allocation[].class);
            LOGGER.info("After calling allocation-service");
            Employee employee1 = optional.get();
            employee1.setAllocations(response);
            return employee1;
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
