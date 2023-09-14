package com.seyzn.ruanererzu.util;

public class ReturnVO {
    //返回编码 1：成功  0:失败  < 0 特殊标记位
    private int code;
    //消息
    private String msg;
    //返回内容
    private Object content;

    public ReturnVO(String errMsg) {
        code = 0;
        this.msg = errMsg;
    }

    public ReturnVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReturnVO(int code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public static ReturnVO getNodataFoundReturnVO(){
        return new ReturnVO("没有找到数据！");
    }

    public static ReturnVO getSystemBusyReturnVO(){
        return new ReturnVO("系统繁忙，稍后重试！");
    }

    public static ReturnVO getSuccessDataReturnVO(){
        return new ReturnVO(1, "操作成功！");
    }

    public static ReturnVO getSuccessDataReturnVO(Object obj){
        return new ReturnVO(1, "找到数据！", obj);
    }

    public void setSuccessOper(){
        this.setCode(1);
        this.setMsg("操作成功");
    }

    public void setSuccessData(Object obj){
        this.setCode(1);
        this.setMsg("找到数据");
        this.setContent(obj);
    }
    public ReturnVO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
