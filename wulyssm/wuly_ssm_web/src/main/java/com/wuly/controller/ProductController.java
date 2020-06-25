package com.wuly.controller;

import com.wuly.domain.Product;
import com.wuly.service.IProdectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProdectService iprodectService;
//findall
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {


        ModelAndView mv= new ModelAndView();
        List<Product> products = iprodectService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list1");

        return mv;
    }
    //save.ao
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        iprodectService.save(product);
        return "redirect:findAll.do";

    }
}
