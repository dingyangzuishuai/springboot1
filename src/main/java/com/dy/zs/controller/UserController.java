package com.dy.zs.controller;


import com.dy.zs.pojo.User;
import com.dy.zs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/loginpage")
    public String loginpage(){
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "main";
    }
    @PostMapping("/login")
    public String getlogin(@RequestParam("usercode") String usercode,@RequestParam("password") String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = userService.checkpwd(usercode);
        if (user==null) {
            session.setAttribute("error1","username is wrong!!!");
            return "login";
        }else{
            if(password.equals(user.getPwd())){
                session.setAttribute("user",user);
                System.out.println(session.getAttribute("user"));
                session.removeAttribute("error1");
                session.removeAttribute("error2");
                return "main";
            }else{
                session.setAttribute("error2","password is wrong!!!");
                return "login";
            }
        }
    }
//    @GetMapping("/login")
//    public String getlogin2(@RequestParam("username") String username,@RequestParam("password") String password, HttpServletRequest request){
//        HttpSession session = request.getSession();
//        User user = userService.checkpwd(username,password);
//        if (user==null) {
//            session.removeAttribute("user");
//            return "login";
//        }else{
//            session.setAttribute("user",user);
//            session.setAttribute("username",username);
//            session.setAttribute("password",password);
//            System.out.println(session.getAttribute("user"));
//            return "main";
//        }
//
//    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/getregister")
    public String getregister(@RequestParam("usercode") String usercode,@RequestParam("password") String password,@RequestParam("name") String name,
                              @RequestParam("gender") String gender,@RequestParam("s_class") String s_class,HttpServletRequest request){
        HttpSession session=request.getSession();
        int result = userService.addUser(new User(usercode,password,name,gender,s_class));
        if(result==0){
            session.removeAttribute("error3");
            return "login";
        }else{
            session.setAttribute("error3","your register message is wrong,please check it and try again");
            return "register";
        }
    }

}