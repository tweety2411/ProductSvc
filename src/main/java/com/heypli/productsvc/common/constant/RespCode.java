package com.heypli.productsvc.common.constant;

public enum RespCode {
    SUCCESS("SUCCESS"),
    NO_PRODUCT("NO_PRODUCT"),
    ERROR("ERROR");

    private String codeName;

    private RespCode(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeName() {
        return this.getCodeName();
    }
}
