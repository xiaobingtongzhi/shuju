package cn.itcast.ssm.controller;

import cn.itcast.ssm.Service.OrdersService;
import cn.itcast.ssm.domain.Orders;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
   @RequestMapping("/findAll.do")
//   查询所有订单
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception{
       ModelAndView modelAndView =new ModelAndView();
        List<Orders> all = ordersService.findAll(page,size);
//        分页，，，，，PageInfo就是分页的bean
        PageInfo pageInfo=new PageInfo(all);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }
//    id订单查询
    @RequestMapping("/findById.do")
    public ModelAndView finById(@RequestParam(name = "id", required=true) String ordersId) throws Exception {
            ModelAndView modelAndView=new ModelAndView();
            Orders orders=ordersService.findById(ordersId);
            modelAndView.addObject("orders",orders);
            modelAndView.setViewName("orders-show");
;        return modelAndView;
    }

}
