package cn.itcast.ssm.Service.impl;

import cn.itcast.ssm.Service.OrdersService;
import cn.itcast.ssm.dao.OrdersDao;
import cn.itcast.ssm.domain.Orders;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceimpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception{

        return ordersDao.findById(ordersId);
    }
}
