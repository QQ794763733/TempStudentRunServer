package liar.xiaoyu.www.temp.controller;

import liar.xiaoyu.www.temp.entity.RequestTemplate;
import liar.xiaoyu.www.temp.entity.ResponseTemplate;
import liar.xiaoyu.www.temp.service.MiyaoService;
import liar.xiaoyu.www.temp.service.impl.MiyaoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiyaoController {
    private static final String url = "/Miyao";
    private MiyaoService miyaoService = new MiyaoServiceImpl();

    @GetMapping(url)
    public ResponseTemplate<String> getMiyao(){
        ResponseTemplate<String> message = new ResponseTemplate<>();
        message.setSucces(true);
        message.setMessage("秘钥请求！");
        message.setData(miyaoService.getMiyao());
        return message;
    }

    @PutMapping(url)
    public ResponseTemplate<Boolean> changeMiyao(@RequestBody RequestTemplate<String> request){
        ResponseTemplate<Boolean> message = new ResponseTemplate<>();
        if(miyaoService.validationMiyao(request.getKey())){
            if(miyaoService.changeMiyao(request.getData())){
                message.setSucces(true);
                message.setData(true);
            }else{
                message.setMessage("秘钥修改失败！");
            }
        }else{
            message.setMessage("秘钥错误！");
        }
        return message;
    }
}
