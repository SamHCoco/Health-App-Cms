package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.Product;

public interface ProductService extends CrudService<Product> {

    Product createOrUpdate(Product product);

}
