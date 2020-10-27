package cn.itcast.ssm.controller;

import cn.itcast.ssm.Service.ProductService;
import cn.itcast.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
//    查询所有产品
    private ProductService productService;
    @RequestMapping("/find.do")
 public ModelAndView finAll() throws Exception {
     ModelAndView modelAndView=new ModelAndView();
     List<Product> all = productService.findAll();
     modelAndView.addObject("productList",all);
     modelAndView.setViewName("product-list");
     return modelAndView;
 }
// 产品添加
@RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:find.do";
}
}
