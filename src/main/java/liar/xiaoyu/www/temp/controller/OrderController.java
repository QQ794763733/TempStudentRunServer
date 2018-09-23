package liar.xiaoyu.www.temp.controller;

import liar.xiaoyu.www.temp.common.MyWebSocket;
import liar.xiaoyu.www.temp.entity.Order;
import liar.xiaoyu.www.temp.entity.RequestTemplate;
import liar.xiaoyu.www.temp.entity.ResponseTemplate;
import liar.xiaoyu.www.temp.service.MiyaoService;
import liar.xiaoyu.www.temp.service.OrderService;
import liar.xiaoyu.www.temp.service.impl.MiyaoServiceImpl;
import liar.xiaoyu.www.temp.service.impl.OrderServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrderController {
    public static final String url = "/Order";
    OrderService orderService = new OrderServiceImpl();
    MiyaoService miyaoService = new MiyaoServiceImpl();

    @GetMapping(url)
    public ResponseTemplate<List<Order>> getAllOrder(@RequestParam("key") String key){
        ResponseTemplate<List<Order>> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(key)){
            message.setSucces(true);
            message.setMessage("查询成功！");
            message.setData(orderService.getAllOrder());
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @PostMapping(url)
    public ResponseTemplate<Integer> addOrder(@RequestBody RequestTemplate<Order> request){
        ResponseTemplate<Integer> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            Integer id = orderService.addOrder(request.getData());
            message.setSucces(true);
            message.setMessage("插入成功！");
            message.setData(id);
            try {
                MyWebSocket.sendAllStaff("新的订单"+message.getData());
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @GetMapping(url+"ByRidgepole")
    public ResponseTemplate<List<Order>> getOrderByRidgepole(@RequestParam("key")String key,@RequestParam("ridgepole")Integer ridgepole){
        ResponseTemplate<List<Order>> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(key)){
            message.setSucces(true);
            message.setMessage("查询成功！");
            message.setData(orderService.getOrderByRidgepole(ridgepole));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @GetMapping(url+"ByUUID")
    public ResponseTemplate<List<Order>> getOrderUUID(@RequestParam("key")String key,@RequestParam("uuid")String uuid){
        ResponseTemplate<List<Order>> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(key)){
            message.setSucces(true);
            message.setMessage("查询成功！");
            message.setData(orderService.getOrderByUUID(uuid));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @PutMapping(url)
    public ResponseTemplate<Boolean> acceptOrder(@RequestBody RequestTemplate<Order> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            if(orderService.acceptOrder(request.getData())){
                message.setSucces(true);
                message.setMessage("接单成功！");
                message.setData(true);
                try {
                    MyWebSocket.sendAllClient(request.getData().getId()+"");
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            }else{
                message.setSucces(false);
                message.setMessage("此单已被别人接了！");
                message.setData(false);
            }
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @DeleteMapping(url)
    public ResponseTemplate<Boolean> cancelOrder(@RequestBody RequestTemplate<Integer> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            Boolean aBoolean = orderService.cancelOrder(request.getData());
            if(aBoolean){
                message.setSucces(true);
                message.setMessage("删除成功！");
                message.setData(aBoolean);
                try {
                    MyWebSocket.sendAllStaff("订单"+request.getData()+"取消！");
                }catch (Exception e){
                    System.out.println(e.toString());
                }
            }else{
                message.setSucces(aBoolean);
                message.setMessage("删除成功！");
                message.setData(aBoolean);
            }

        }else{
            message.setMessage("key错误！");
        }
        return message;
    }
}
