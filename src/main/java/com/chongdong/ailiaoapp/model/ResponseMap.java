package com.chongdong.ailiaoapp.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMap {
    private Boolean flag;
    private String message;
    private Object data;
    /**
     * 静态成功返回方法
     * @return ResponseMap
     */
    public static ResponseMap success(){
        return create(true,"成功",null);
    }
    /**
     * 静态成功返回方法
     * @param data 返回数据
     * @return ResponseMap
     */
    public static ResponseMap success(Object data){
        return create(true,"成功",data);
    }
    /**
     * 静态失败返回方法
     * @return ResponseMap
     */
    public static ResponseMap failure(){
        return create(false,"失败",null);
    }
    /**
     * 灵活自定义消息
     * @param message 消息内容
     * @return this
     */
    public ResponseMap message(String message){
        this.setMessage(message);
        return this;
    }
    /**
     * 灵活自定义数据
     * @param object 数据内容
     * @return this
     */
    public ResponseMap data(Object object){
        this.setData(object);
        return this;
    }
}
