package liar.xiaoyu.www.temp.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Required;

public class RequestTemplate<T> {
    private String action;
    @NotNull
    private String key;
    private T data;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
