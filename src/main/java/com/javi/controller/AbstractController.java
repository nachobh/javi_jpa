package com.javi.controller;

import com.javi.service.CommonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
public abstract class AbstractController<T, K> {

    @Setter
    @Autowired
    private CommonService<T, K> service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody T entity) {
        service.create(entity);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/json")
    public T read(K key) {
        return service.read(key);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody T entity) {
        service.update(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(K key) {
        service.delete(key);
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET, produces = "application/json")
    public T findByName(String name) {
        return service.findByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/readAll", method = RequestMethod.GET, produces = "application/json")
    public Collection<T> readAll() {
        return service.readAll();
    }

}
