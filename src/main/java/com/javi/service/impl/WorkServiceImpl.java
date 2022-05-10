package com.javi.service.impl;

import com.javi.entity.Work;
import com.javi.repository.WorkRepository;
import com.javi.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl extends AbstractServiceImpl<Work, Long> implements WorkService {

    @Autowired
    private WorkRepository workRepository;

    public WorkServiceImpl() {
        super.setRepository(workRepository);
    }
}
