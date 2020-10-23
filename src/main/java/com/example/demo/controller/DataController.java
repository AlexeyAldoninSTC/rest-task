package com.example.demo.controller;

import com.example.demo.entity.Data;
import com.example.demo.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/data/{id}")
    public Data getDataById(@PathVariable("id") Integer id) {
        return dataService.getById(id);
    }

    @GetMapping("/data")
    public List<Data> getAllData() {
        return dataService.getAllData();
    }
}
