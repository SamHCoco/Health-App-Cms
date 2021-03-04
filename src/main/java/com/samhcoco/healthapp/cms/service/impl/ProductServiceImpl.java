package com.samhcoco.healthapp.cms.service.impl;

import com.samhcoco.healthapp.cms.configuration.GatewayProperties;
import com.samhcoco.healthapp.cms.model.Product;
import com.samhcoco.healthapp.cms.service.HttpService;
import com.samhcoco.healthapp.cms.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String RESOURCE = "product";
    private static final String SERVICE = "store-service";

    private final GatewayProperties zuul;
    private final HttpService httpService;

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product create(@NonNull Product product) {
        val url = format("%s/%s/%s", zuul.getBaseUrl(), SERVICE, RESOURCE);
        val response = httpService.post(url, product);
        return response.getBody();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
