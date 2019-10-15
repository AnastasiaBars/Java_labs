package ru.vlsu.lab5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import ru.vlsu.lab5.bean.Shop;
import ru.vlsu.lab5.service.MainService;

import java.util.ArrayList;


@Controller
@Scope(value= WebApplicationContext.SCOPE_SESSION)
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String getIndex(@RequestParam(name="text",required = false,defaultValue = "")String text, Model model) {
        ArrayList<Shop> shops = mainService.getAllShops();
        model.addAttribute("shop", shops);
        model.addAttribute("history",mainService.getHistory());
        model.addAttribute("text",text);
        model.addAttribute("message",mainService.getMessage());
        return "index";
    }

    @GetMapping(value = "/add")
    public String getAdd() {
        return "add";
    }

    @PostMapping(value = "/add")
    public ModelAndView postAdd(Shop shop) {
        String text = (mainService.createShop(shop)) ? "Success" : "Fail";
        return new ModelAndView("redirect:/?text=" + text);
    }


    @GetMapping(value = "/up/{id}")
    public String getUpdate(@PathVariable(value = "id")int id,Model model){
        Shop shop = mainService.getShopById(id);
        model.addAttribute("shop",shop);
        return "update";
    }

    @PostMapping(value = "up/{id}")
    public ModelAndView postUpdate(@PathVariable(value = "id")int id,Shop shop){
        shop.setIdShop(id);
        mainService.updateShop(shop);
        return new ModelAndView("redirect:/");
    }
}


