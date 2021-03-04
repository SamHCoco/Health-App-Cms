package com.samhcoco.healthapp.cms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long id;
    private String name;
    private Float price;
    private Long manufacturerId;
    private String description;
    private String category;
    private String imageUrl;
}
