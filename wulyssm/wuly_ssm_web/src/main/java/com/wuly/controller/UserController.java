package com.wuly.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.wuly.domain.Product;
import com.wuly.domain.Role;
import com.wuly.domain.UserInfo;
import com.wuly.service.IRoleService;
import com.wuly.service.IUserInfoService;
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
    private IUserInfoService userInfoService;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv =new ModelAndView();
        List<UserInfo> users = userInfoService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userInfoService.save(userInfo);
        return "redirect:findAll.do";

    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id)throws Exception{
        ModelAndView mv =new ModelAndView();
        UserInfo user = userInfoService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show1");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true)String id)throws Exception{
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo = userInfoService.findById(id);
        mv.addObject("user",userInfo);
        List<Role> roles = userInfoService.findOtherRole(id);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true)String userId,@RequestParam(name = "ids", required = true)String[] roleId){
        userInfoService.addRoleToUser(userId,roleId);
        return "redirect:findAll.do";
    }
}
