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
 * @Author:吴宸煊
 * @Date: Created in 13:38 2018/1/17
 * @Description:用户controller
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description:进入登陆页面
     * @param:
     * @return:String
     */
    @GetMapping
    public String loginIndex(){
        return  PageConstant.LOGIN;
    }

    /**
     * @Description:用户登陆
     * @param: name
     * @param:password
     * @param:session
     * @param:attributes
     * @return:String
     */
    @RequestMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam  String password,
                         HttpSession session,
                         RedirectAttributes attributes){
        // 判断用户名是否为空
        boolean checkName=(null==name||"".equals(name));
        // 判断密码是否为空
        boolean checkPassord=(null==password||"".equals(password));
        if(checkName||checkPassord){
            attributes.addFlashAttribute("nullNameAndPassword","用户名或密码不能为空");
            return PageConstant.REDIRECT;
        }
        // 在数据库中查找
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
     * @param:
     * @return:String
     */
    @RequestMapping("/toRegist")
    public String insert() {
        return PageConstant.REGIST;
    }

    /**
     * @Description:用户注册信息
     * @param: userPO
     * @return:String
     */
    @RequestMapping("/regist")
    public String save(UserPO userPO,RedirectAttributes attributes) {
        // 获取用户名
        String name=userPO.getName();
        UserPO user=userService.getName(name);
        if(null!=user){
            attributes.addFlashAttribute("mess","用户名已被注册");
           return  PageConstant.REDIRECTTO;
       }
        userService.save(userPO);
        return PageConstant.SUCCESS;
    }
}

