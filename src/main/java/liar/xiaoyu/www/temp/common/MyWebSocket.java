package liar.xiaoyu.www.temp.common;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/WebSocketConnection/{identity}")
public class MyWebSocket {
    static CopyOnWriteArrayList<Session> clients = new CopyOnWriteArrayList<>();
    static CopyOnWriteArrayList<Session> staffs = new CopyOnWriteArrayList<>();

    @OnOpen
    public  void open(Session session, EndpointConfig conf, @PathParam("identity")String identity){
        System.out.println(session.getContainer());
        if(identity.equals("staff")){
            staffs.add(session);
            System.out.println("加入了一个员工");
        }else{
            clients.add(session);
            System.out.println("加入了一个客户");
        }
    }

    @OnMessage
    public void message(Session session, String msg){
        System.out.println(msg);
    }
    @OnError
    public void error(Session session, Throwable error){
        System.out.println(error.toString());
        clients.remove(session);
        staffs.remove(session);
    }
    @OnClose
    public void close(Session session, CloseReason reason){
        System.out.println(session+reason.toString());
        clients.remove(session);
        staffs.remove(session);
    }

    public static void sendAllClient(String msg){
        for(Session session:clients){
            if(session.isOpen()){
                session.getAsyncRemote().sendText(msg);
            }
        }
    }

    public static void sendAllStaff(String msg){
        for(Session session:staffs){
            if(session.isOpen()){
                session.getAsyncRemote().sendText(msg);
            }
        }
    }
}