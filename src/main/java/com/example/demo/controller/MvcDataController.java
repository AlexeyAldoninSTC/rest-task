package com.example.demo.controller;

import com.example.demo.entity.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcDataController {

    private final DataController dataController;

    public MvcDataController(DataController dataController) {
        this.dataController = dataController;
    }

    @GetMapping("/data/all")
    public String getAllData(Model model) {
        model.addAttribute("articles", dataController.getAllData());
        return "all_data";
    }

    @GetMapping("/data")
    public String getDataById(@RequestParam("id") int id, Model model) {
        Data data = dataController.getDataById(id);
        model.addAttribute("article", data);
        return "single_data";
    }
}
