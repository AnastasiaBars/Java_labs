package com.vlsu.entity3.controllers;

import com.vlsu.entity3.entity.Supply;
import com.vlsu.entity3.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupplyController {

    private SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/supplys")
    public String getSupplys(Model model) {
        model.addAttribute("supplys", supplyService.getAll());
        return "supplys";
    }

    @GetMapping("/update_supply")
    public String getUpdateSupply(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("supply", supplyService.getById(id));
        return "update_supply";
    }

    @PostMapping("/update_supply")
    public String postUpdateRecord(Supply supply, @RequestParam(name = "id") int id) {
        supply.setIdSupply(id);
        supplyService.update(supply);
        return "redirect:/supplys";
    }

    @GetMapping("/create_supply")
    public String getCreateSupply() {
        return "create_supply";
    }

    @PostMapping("/create_supply")
    public String postUpdateRecord(Supply supply) {
        supplyService.create(supply);
        return "redirect:/supplys";
    }

    @GetMapping("/delete_supply")
    public String getDeleteSupply(@RequestParam(name = "id") int id) {
        supplyService.delete(supplyService.getById(id));
        return "redirect:/supplys";
    }
}