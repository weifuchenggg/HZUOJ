package com.example.demo.web;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hzuoj")
public class Index {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user, Model model){
        System.out.println(user);
        List<User> lists=userMapper.selectListByFilter("where username='"+user.getUsername()+"'");
        if(lists==null || lists.size()==0 || lists.get(0).getPassword().equals(user.getPassword())==false){
            return "error";
        }
        return "sucess";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user,Model model){
        System.out.println(user);
        List<User> lists=userMapper.selectListByFilter("where username='"+user.getUsername()+"'");
        if(lists==null || lists.size()==0 ){
            userMapper.insert(user);
            return "sucess";
        }
        return "error";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);   //用户信息
        model.addAttribute("vis_register",false);
        model.addAttribute("vis_login",true);
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        User user=new User();
        model.addAttribute("user",user);   //用户信息
        model.addAttribute("vis_register",true);
        model.addAttribute("vis_login",false);
        return "login";
    }

    @RequestMapping("/index")
    public String index(String src,Model model){
        if (src==null || src.equals("")){
            src="/nav/index";
        }
        model.addAttribute("src",src);
        System.out.println(src);
        return "index";
    }


}
