package com.pasindu.emscloud.repository;

import com.pasindu.emscloud.commons.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
