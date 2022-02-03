package com.heypli.productsvc.domain.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfoRequest {

    @NotNull(message = "{valid.notnull}")
    private Long        prodId;
    private String      prodName;
    private String      prodDesc;
}
