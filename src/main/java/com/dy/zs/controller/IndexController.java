package com.dy.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dyzs
 * @create 2022-01-23-17:17
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
