package com.ndourcodeur.springbootawslambdademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    @NotBlank(message = "This field is required!")
    private String name;
    @NotBlank(message = "This field is required!")
    private String price;
    private boolean isInStock;
    @NotBlank(message = "This field is required!")
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
