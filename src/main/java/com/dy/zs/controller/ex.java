//package com.dy.zs.controller;
//
//import com.artbrain.dao.UserDetailsServiceDAO;
//import com.artbrain.entity.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class UserController {
//
//  @Autowired
//  private UserDetailsServiceDAO userDetailsServiceDAO;
//
//  @PreAuthorize("isAnonymous()")
//  @RequestMapping(value = "/registration", method = RequestMethod.POST)
//  public String registration(User newUser) {
//    try {
//      if (userDetailsServiceDAO.loadUserEntityByUsername(newUser.getUsername()) != null) {
//        return "redirect:" + "/login?registration&error";
//      } else {
//        userDetailsServiceDAO.saveUser(newUser);
//        return "redirect:" + "/login?registration&success";
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//      return "redirect:" + "/login?registration&errorServer";
//    }
//  }
//
//  @PreAuthorize("isAnonymous()")
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public String loginPage() {
//    return "login";
//  }
//}
//@RequestMapping("/admin")
//public String index(Model model, HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        Integer userId = null;
//        if (!UserRole.ADMIN.getValue().equals(user.getUserRole())) {
//        // 用户查询自己的文章, 管理员查询所有的
//        userId = user.getUserId();
//        }
//        //文章列表
//        List<Article> articleList = articleService.listRecentArticle(userId, 5);
//        model.addAttribute("articleList", articleList);
//
//        //评论列表
//        List<Comment> commentList = commentService.listRecentComment(userId, 5);
//        model.addAttribute("commentList", commentList);
//        return "Admin/index";
//        }
//@RequestMapping(value = "/loginVerify", method = RequestMethod.POST, produces = {"text/plain;charset=UTF-8"})
//@ResponseBody
//public String loginVerify(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String rememberme = request.getParameter("rememberme");
//        User user = userService.getUserByNameOrEmail(username);
//        if (user == null) {
//        map.put("code", 0);
//        map.put("msg", "用户名无效！");
//        } else if (!user.getUserPass().equals(password)) {
//        map.put("code", 0);
//        map.put("msg", "密码错误！");
//        } else if (user.getUserStatus() == 0) {
//        map.put("code", 0);
//        map.put("msg", "账号已禁用！");
//        } else {
//        //登录成功
//        map.put("code", 1);
//        map.put("msg", "");
//        //添加session
//        request.getSession().setAttribute("user", user);
//        //添加cookie
//        if (rememberme != null) {
//        //创建两个Cookie对象
//        Cookie nameCookie = new Cookie("username", username);
//        //设置Cookie的有效期为3天
//        nameCookie.setMaxAge(60 * 60 * 24 * 3);
//        Cookie pwdCookie = new Cookie("password", password);
//        pwdCookie.setMaxAge(60 * 60 * 24 * 3);
//        response.addCookie(nameCookie);
//        response.addCookie(pwdCookie);
//        }
//        user.setUserLastLoginTime(new Date());
//        user.setUserLastLoginIp(getIpAddr(request));
//        userService.updateUser(user);
//
//        }
//        String result = new JSONObject(map).toString();
//        return result;
//        }
