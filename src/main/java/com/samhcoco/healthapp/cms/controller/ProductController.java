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

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private static final String PRODUCT = "product";

    private final ProductService productService;

    @GetMapping("create")
    public String create(Model model) {
        if (!model.containsAttribute(PRODUCT)) {
            model.addAttribute(PRODUCT, new Product());
        }
        return "product/edit";
    }

    @GetMapping({"{id}"})
    public String getProduct(Model model, @PathVariable Long id) {
        val product = productService.getById(id);
        if (nonNull(product)) {
            model.addAttribute(PRODUCT, product);
        } else {
            model.addAttribute(PRODUCT, new Product());
        }
        return format("%s/edit", PRODUCT);
    }

    @PostMapping("create")
    public ModelAndView createOrUpdate(@ModelAttribute Product product, ModelMap model) {
        val result = productService.createOrUpdate(product);
        if (isNull(result)) {
            return new ModelAndView("redirect:/product/create", model);
        }
        model.addAttribute(PRODUCT, result);
        return new ModelAndView("redirect:/product/" + result.getId(), model);
    }

}
