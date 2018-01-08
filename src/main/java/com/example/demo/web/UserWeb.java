package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

@Controller
@RequestMapping("/user")
public class UserWeb {

    private final String crud="/user/UserCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/user/userUi";
    }

    @Autowired
    UserService userService;

    @RequestMapping("/getuser")
    @ResponseBody
    public Map<String,Object> getuser(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<User> lists=userService.selectAll();
        int total=userService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=userService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        User user=new User();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("user",user);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,@RequestBody User user){
        System.out.println(user);
        userService.insert(user);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(String id){
        userService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,String id){
        User user=userService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("user",user);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody User user){
        System.out.println(user);
        userService.updateById(user);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,String id){
        User user=userService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("user",user);   //用户信息
        return crud;
    }

    @RequestMapping("/toRank")  //跳到查看页面
    public String toRank(Model model){
        return "/user/userRankUi";
    }
}
