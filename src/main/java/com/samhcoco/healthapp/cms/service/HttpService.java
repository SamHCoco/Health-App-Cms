package com.samhcoco.healthapp.cms.service;

import com.samhcoco.healthapp.cms.model.Response;
import org.springframework.http.ResponseEntity;

public interface HttpService {

    <T> Response<T> post(String url, T body);

//     Class<?> post(String url, Object body, Class<?> type);

}
