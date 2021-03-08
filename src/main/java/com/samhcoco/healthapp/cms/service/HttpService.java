package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.Response;

public interface HttpService {

    <T> Response<T> post(String url, T body);

    <T> Response<T> put(String url, T body);

    <T> Response<T> get(String url, T responseType);

    <T> Response<T> delete(String url, T responseType);

}
