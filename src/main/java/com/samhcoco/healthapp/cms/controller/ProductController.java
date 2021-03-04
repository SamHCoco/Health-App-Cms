package com.samhcoco.healthapp.cms.controller;

import com.samhcoco.healthapp.cms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getProduct(Model model) {
        return "product/edit";
    }

    @PostMapping("/{id}")
    public String create(@PathVariable Long id, Model model) {
        // todo - finish
        return null;
    }

}
