package com.heypli.productsvc.common.response;

import com.heypli.productsvc.common.constant.RespCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private RespCode returnCd;
    private String message;

    public static CommonResponse success() {
        return new CommonResponse(RespCode.SUCCESS, null);
    }

    public static CommonResponse fail(Exception e) {
        return new CommonResponse(RespCode.ERROR, e.getMessage());
    }

}
