package com.group.monitor.controller;

import com.group.monitor.constant.PageConstant;
import com.group.monitor.entity.UserPO;
import com.group.monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Description:用户controller
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description:进入登陆页面
     */
    @GetMapping
    public String loginIndex(){
        return  PageConstant.LOGIN;
    }

    /**
     * @Description:用户登陆
     */
    @RequestMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam  String password,
                         HttpSession session,
                         RedirectAttributes attributes){
        boolean checkName=(null==name||"".equals(name));
        boolean checkPassord=(null==password||"".equals(password));
        if(checkName||checkPassord){
            attributes.addFlashAttribute("nullNameAndPassword","用户名或密码不能为空");
            return PageConstant.REDIRECT;
        }
        UserPO user=userService.getUser(name,password);
        if(null==user){
            attributes.addFlashAttribute("message","用户名或者密码错误");
            return PageConstant.REDIRECT;
        }
        session.setAttribute("user",user);
        return PageConstant.INDEX;
    }


    /**
     * @Description:进入注册页面
     */
    @RequestMapping("/toRegist")
    public String insert() {
        return PageConstant.REGIST;
    }

    /**
     * @Description:用户注册信息
     */
    @RequestMapping("/regist")
    public String save(UserPO userPO,RedirectAttributes attributes) {
        // 获取用户名
        String name=userPO.getLoginName();
        UserPO user=userService.getName(name);
        if(null!=user){
            attributes.addFlashAttribute("mess","用户名已被注册");
           return  PageConstant.REDIRECTTO;
       }
        userService.save(userPO);
        return PageConstant.SUCCESS;
    }
}

