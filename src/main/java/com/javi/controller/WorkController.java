package com.javi.controller;

import com.javi.entity.Work;
import com.javi.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javi/work")
public class WorkController extends AbstractController<Work, Long> {

    @Autowired
    private WorkService workService;

    public WorkController() {
        super.setService(workService);
    }
}
