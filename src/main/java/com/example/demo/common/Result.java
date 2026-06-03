package com.example.demo.common;

import java.io.Serializable;

/**
 * 统一网络传输结果响应类
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;     // 状态码
    private String msg;   // 提示信息
    private Object data;  // 返回数据

    // 无参构造（Jackson反序列化需要）
    public Result() {
    }

    // 全参构造
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // ================= 成功快捷方法 =================

    /**
     * 成功返回（无数据）
     */
    public static Result success() {
        return new Result(200, "操作成功", null);
    }

    /**
     * 成功返回（有数据）
     */
    public static Result success(Object data) {
        return new Result(200, "操作成功", data);
    }

    /**
     * 成功返回（自定义提示信息和数据）
     */
    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    // ================= 失败快捷方法 =================

    /**
     * 失败返回（默认通用失败）
     */
    public static Result error() {
        return new Result(500, "系统异常，请稍后再试", null);
    }

    /**
     * 失败返回（自定义错误码和错误信息）
     */
    public static Result error(int code, String msg) {
        return new Result(code, msg, null);
    }

    /**
     * 失败返回（自定义错误信息）
     */
    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

    // ================= Getter 和 Setter =================

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
}