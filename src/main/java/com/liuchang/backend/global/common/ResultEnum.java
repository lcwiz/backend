package com.liuchang.backend.global.common;

public enum ResultEnum {

    SUCCESS(0,"成功返回"),//成功
    FAIL(1,"失败"),//失败
    UNAUTHORIZED(401,"未认证"),//未认证（签名错误）
    NOT_FOUND(404,"资源不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");//服务器内部错误


    private int rtnCode;
    private String rtnName;


    ResultEnum(int rtnCode, String rtnName) {
        this.rtnCode = rtnCode;
        this.rtnName = rtnName;
    }

    /**
     * 通过传入的http状态码返回对应文字说明
     * @param rsltCode
     * @return
     */
    public String getName(int rsltCode){
        for(ResultEnum rsltEnum:ResultEnum.values()){
            if(rsltEnum.getRtnCode()== rsltCode){
                return rsltEnum.getRtnName();
            }
        }
        return "";
    }

    public int getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnName() {
        return rtnName;
    }

    public void setRtnName(String rtnName) {
        this.rtnName = rtnName;
    }
}
