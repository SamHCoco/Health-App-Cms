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
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String RESOURCE = "product";
    private static final String SERVICE = "store-service";

    private final GatewayProperties zuul;
    private final HttpService httpService;

    @Override
    public Product getById(Long id) {
        val url = format("%s/%s/%s/%s", zuul.getBaseUrl(), SERVICE, RESOURCE, id);
        val response = httpService.get(url, new Product());
        return response.getBody();
    }

    @Override
    public Product create(@NonNull Product product) {
        val url = format("%s/%s/%s", zuul.getBaseUrl(), SERVICE, RESOURCE);
        val response = httpService.post(url, product);
        return response.getBody();
    }

    @Override
    public Product update(@NonNull Product product) {
        val url = format("%s/%s/%s", zuul.getBaseUrl(), SERVICE, RESOURCE);
        val response = httpService.put(url, product);
        return response.getBody();
    }

    @Override
    public Product createOrUpdate(@NonNull Product product) {
        val id = product.getId();
        if (isNull(id)) {
            return create(product);
        }
        return update(product);
    }

    @Override
    public void delete(Long id) {

    }
}
