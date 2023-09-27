package com.chongdong.ailiaoapp.component;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
@ServerEndpoint(value = "/relationship/{username}")
@Component
@Slf4j
public class WebSocketServer {
    /**
     *记录当前在线链接数
     * */
    public static final Map<String, Session> sessionMap=new ConcurrentHashMap<>();

    /**
     * 创建redis的操作
     * */
    private static RedisTemplate<Object,Object> redisTemplate;

    /**
     * 建立连接成功后调用的方法
     * */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username){
        //@PathParam("username") String username 指登录的当前用户的用户名或用户id
        //session 指当前用户登录的session，将session存入到Map中
        sessionMap.put(username,session);
        //告诉我们服务器有新用户加入了他的用户名是username={}   在线人数是sessionMap.size()
        log.info("有新用户加入，username={},当前在线人数为：{}",username,sessionMap.size());
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        result.set("users", array);
        for (Object key : sessionMap.keySet()) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.set("username",key);
            // {"username": "zhang", "username": "admin"}
            array.add(jsonObject);
        }
        //        {"users": [{"username": "zhang"},{ "username": "admin"}]}
        sendAllMessage(JSONUtil.toJsonStr(result));// 后台发送消息给所有的客户端

    }
    // 后台发送消息给所有的客户端
    private void sendAllMessage(String message) {
        try {
            for (Session session : sessionMap.values()) {
                log.info("服务端给客户端[{}]发送消息{}", session.getId(), message);
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            log.error("服务端发送消息给客户端失败", e);
        }
    }
    /**
     * 收到客户端消息后调用的方法
     * 后台收到客户端发送过来的消息
     * onMessage 是一个消息的中转站
     * */
    @OnMessage
    public void onMessage(String message,Session session,@PathParam("username") String username){
        log.info("服务端收到用户username={}的消息:{}", username, message);
        JSONObject obj = JSONUtil.parseObj(message);
        String toUsername = obj.getStr("to"); // to表示发送给哪个用户，比如 admin
        String text = obj.getStr("text"); // 发送的消息文本  hello
        Session toSession = sessionMap.get(toUsername);//根据to用户名来获取session，再通过session发送消息文本。
        if(toSession!=null){
            //服务端 再把消息组装一下，组装后的消息包含发送人和发送的文本内容
            JSONObject jsonObject=new JSONObject();
            jsonObject.set("from",username);//from指发送人
            jsonObject.set("text",text);//发送的消息文本  hello
            this.sendMessage(jsonObject.toString(),toSession);
            log.info("发送给用户username={}，消息：{}",toUsername,jsonObject.toString());
        }else {
            log.info("发送失败，未找到用户username={}的session",toUsername);
        }

    }
    /**
     *
     * 服务端发送消息给客户端
     * */
    private void sendMessage(String message,Session toSession){
        try {
            log.info("服务端给客户端[{}]发送消息{}",toSession.getId(),message);
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("服务端发送消息给客户端失败",e);
        }
    }
    /**
     * 错误
     * */
    @OnError
    public void onError(Session session,Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }

}
