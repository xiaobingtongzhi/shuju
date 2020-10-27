package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
//    根据id查询
@Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{ordersId})")
public List<Traveller> findById(String ordersId) throws Exception;
}
