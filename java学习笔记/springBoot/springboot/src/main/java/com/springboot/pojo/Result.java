package com.springboot.pojo;

public class Result {       // Result 对象格式
    private Integer code;   // 成员变量必须相同
    private String msg;
    private Object data;
    public Result() {
    }
    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    // 快速构建 Result对象的三个方法
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }
    public static Result success() {
        return new Result(1, "success", null);
    }
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}
