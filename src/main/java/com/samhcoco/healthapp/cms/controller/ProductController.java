package com.samhcoco.healthapp.cms.controller;

import com.samhcoco.healthapp.cms.model.Product;
import com.samhcoco.healthapp.cms.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("create")
    public String create(Model model) {
        if (!model.containsAttribute("product")) {
            model.addAttribute("product", new Product());
        }
        return "product/edit";
    }

    @GetMapping({"{id}"})
    public String getProduct(Model model, @PathVariable Long id) {
        val product = productService.getById(id);
        if (nonNull(product)) {
            model.addAttribute("product", product);
        } else {
            model.addAttribute("product", new Product());
        }
        return "product/edit";
    }

    @PostMapping("create")
    public ModelAndView createOrUpdate(@ModelAttribute Product product, ModelMap model) {
        val result = productService.createOrUpdate(product);
        if (isNull(result)) {
            return new ModelAndView("redirect:/product/create", model);
        }
        model.addAttribute("product", result);
        return new ModelAndView("redirect:/product/" + result.getId(), model);
    }

}
