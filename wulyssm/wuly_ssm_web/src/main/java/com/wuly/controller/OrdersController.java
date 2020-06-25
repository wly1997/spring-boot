package com.wuly.controller;

import com.github.pagehelper.PageInfo;
import com.wuly.domain.Orders;
import com.wuly.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;
    //findall
    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv= new ModelAndView();
        List<Orders> orders = iOrdersService.findAll();
        mv.addObject("ordersList",orders);
        mv.setViewName("orders-list");

        return mv;
    }*/

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size) throws Exception {

        ModelAndView mv= new ModelAndView();
        List<Orders> orders = iOrdersService.findAll(page,size);
        PageInfo pageInfo =new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv= new ModelAndView();
        Orders orders = iOrdersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");

        return mv;

    }


}
