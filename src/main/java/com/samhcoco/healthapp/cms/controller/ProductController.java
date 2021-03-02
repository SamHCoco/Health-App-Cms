package com.samhcoco.healthapp.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping
    public String getProduct(Model model) {
        return "product/edit";
    }

    @PostMapping("/{id}")
    public String create(@PathVariable Long id, Model model) {
        // todo - add product service
        return null;
    }

}
