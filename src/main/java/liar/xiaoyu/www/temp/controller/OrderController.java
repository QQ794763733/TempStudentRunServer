package liar.xiaoyu.www.temp.controller;
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
    public ResponseTemplate<Boolean> addOrder(@RequestBody RequestTemplate<Order> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            message.setSucces(true);
            message.setMessage("增加成功！");
            message.setData(orderService.addOrder(request.getData()));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @GetMapping(url+"ByRidgepole")
    public ResponseTemplate<List<Order>> getOrderByRidgepole(@RequestBody RequestTemplate<Integer> request){
        ResponseTemplate<List<Order>> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            message.setSucces(true);
            message.setMessage("查询成功！");
            message.setData(orderService.getOrderByRidgepole(request.getData()));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @PutMapping(url)
    public ResponseTemplate<Boolean> acceptOrder(@RequestBody RequestTemplate<Order> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            message.setSucces(true);
            message.setMessage("接单成功！");
            message.setData(orderService.acceptOrder(request.getData()));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }

    @DeleteMapping(url)
    public ResponseTemplate<Boolean> cancelOrder(@RequestBody RequestTemplate<Integer> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            message.setSucces(true);
            message.setMessage("删除成功！");
            message.setData(orderService.cancelOrder(request.getData()));
        }else{
            message.setMessage("key错误！");
        }
        return message;
    }
}
