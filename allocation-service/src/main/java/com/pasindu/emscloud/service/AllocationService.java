package com.pasindu.emscloud.service;

import com.pasindu.emscloud.commons.model.Allocation;
import com.pasindu.emscloud.commons.model.Employee;

import java.util.List;

public interface AllocationService {

    Allocation save(Allocation allocation);
    List<Allocation> findByEmployeeId(Integer id);

}
