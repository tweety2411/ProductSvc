package com.heypli.productsvc.common.response;

import com.heypli.productsvc.common.constant.RespCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CommonDataResponse<T> {

    private RespCode    respCode;
    private String      message;
    private T    data;

    public CommonDataResponse(T data) {
        this.respCode = RespCode.SUCCESS;
        this.data     = data;
    }
}
