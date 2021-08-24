package unilever.it.org.actualsample.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import unilever.it.org.actualsample.Data;


public class ServiceWrapper<T> {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("data")
    @Expose
    private T data;
    public ServiceWrapper(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
