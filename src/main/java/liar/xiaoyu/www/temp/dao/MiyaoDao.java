package liar.xiaoyu.www.temp.dao;

import liar.xiaoyu.www.temp.entity.Miyao;

import java.util.List;

public interface MiyaoDao {

    Integer insertMiyao(String value);

    Integer deleteMiyaoByID(Integer id);

    Integer updateMiyao(String value);

    Miyao selectMiyaoByID(Integer id);

    List<Miyao> selectAllMiyao();

    String selectMiyaoValue();
}
