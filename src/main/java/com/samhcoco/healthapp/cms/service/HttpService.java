package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.Response;

public interface HttpService {

    <T> Response<T> post(String url, T body);

    <T> Response<T> get(String url, T responseType);

}
