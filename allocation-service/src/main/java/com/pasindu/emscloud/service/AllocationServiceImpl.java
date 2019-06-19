package com.pasindu.emscloud.service;

import com.pasindu.emscloud.commons.model.Allocation;
import com.pasindu.emscloud.commons.model.Employee;
import com.pasindu.emscloud.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public List<Allocation> findByEmployeeId(Integer id) {
        return allocationRepository.findByEmployeeId(id);
    }

    @Override
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }
}
