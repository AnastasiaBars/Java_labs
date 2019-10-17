package com.vlsu.entity3.controllers;

import com.vlsu.entity3.entity.Shop;
import com.vlsu.entity3.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

    private ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/")
    public String getHome() {
        return "redirect:/shops";
    }

    @GetMapping("/shops")
    public String getShops(Model model) {
        model.addAttribute("shops", shopService.getAll());
        return "shops";
    }

    @GetMapping("/update_shop")
    public String getUpdateShop(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("shop", shopService.getById(id));
        return "update_shop";
    }

    @PostMapping("/update_shop")
    public String postUpdateShop(Shop shop, @RequestParam(name = "id") int id) {
        shop.setIdShop(id);
        shopService.update(shop);
        return "redirect:/shops";
    }

    @GetMapping("/create_shop")
    public String getCreateShop() {
        return "create_shop";
    }

    @PostMapping("/create_shop")
    public String postUpdateShop(Shop shop) {
        shopService.create(shop);
        return "redirect:/shops";
    }

    @GetMapping("/delete_shop")
    public String getDeleteShop(@RequestParam(name = "id") int id) {
        shopService.delete(shopService.getById(id));
        return "redirect:/shops";
    }
}