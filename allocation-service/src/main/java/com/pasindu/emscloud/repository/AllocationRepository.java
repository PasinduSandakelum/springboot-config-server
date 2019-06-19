package com.pasindu.emscloud.repository;

import com.pasindu.emscloud.commons.model.Allocation;
import com.pasindu.emscloud.commons.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
    List<Allocation> findByEmployeeId(Integer id);
}
