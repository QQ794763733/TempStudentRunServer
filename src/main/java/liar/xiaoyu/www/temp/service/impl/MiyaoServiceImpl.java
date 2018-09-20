package liar.xiaoyu.www.temp.service.impl;

import liar.xiaoyu.www.temp.dao.MiyaoDao;
import liar.xiaoyu.www.temp.dao.impl.MiyaoImpl;
import liar.xiaoyu.www.temp.service.MiyaoService;

public class MiyaoServiceImpl implements MiyaoService {
    MiyaoDao miyaoDao = new MiyaoImpl();
    @Override
    public Boolean changeMiyao(String value) {
        Boolean flag = false;
        Integer integer = miyaoDao.updateMiyao(value);
        if(integer > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public String getMiyao() {
        return miyaoDao.selectMiyaoValue();
    }

    @Override
    public Boolean validationMiyao(String value) {
        Boolean flag = false;
        if(value.equals(miyaoDao.selectMiyaoValue())){
            flag = true;
        }
        return flag;
    }
}
