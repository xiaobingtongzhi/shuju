package cn.itcast.ssm.controller;

import cn.itcast.ssm.Service.UserService;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;
//添加用户
@RequestMapping("/save.do")
public String save(UserInfo userInfo) throws Exception{
    userService.save(userInfo);
    return "redirect:findAll.do";

}
//用户查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
    ModelAndView modelAndView=new ModelAndView();
    List<UserInfo> list=userService.findAll();
    modelAndView.addObject("userList",list);
    modelAndView.setViewName("user-list");
    return modelAndView;
    }
//用户详情
@RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
    ModelAndView modelAndView=new ModelAndView();
    UserInfo userInfo=userService.findById(id);
    modelAndView.addObject("user",userInfo);
    modelAndView.setViewName("user-show");
    return modelAndView;
}
//查询用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String usersid) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
    //    根据用户id查询用户
UserInfo userInfo=userService.findById(usersid);
//        根据用户id查询可以添加的角色
       List<Role> otherRoles= userService.findOtherRoles(usersid);
       modelAndView.addObject("user",userInfo);
       modelAndView.addObject("roleList",otherRoles);
       modelAndView.setViewName("user-role-add");
       return modelAndView;

    }
    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }


}
