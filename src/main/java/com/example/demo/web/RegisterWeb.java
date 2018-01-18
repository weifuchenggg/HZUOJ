package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Register;
import com.example.demo.entity.User;
import com.example.demo.service.RegisterService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

@Controller
@RequestMapping("/register")
public class RegisterWeb {

    private final String crud="/register/RegisterCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/register/registerUi";
    }

    @RequestMapping("/toRank")
    public String toRank(String id, Model model){
        model.addAttribute("systemid",id);
        return "/register/registerUi";
    }

    @Autowired
    RegisterService registerService;

    @RequestMapping("/getregister")
    @ResponseBody
    public Map<String,Object> getregister(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Register> lists=registerService.selectAll();
        String gl="";
        if (filter!=null && !filter.equals("")){
            gl="where "+filter;
        }
        int total=registerService.selectCountByFilter(gl);
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=registerService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Register register=new Register();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("register",register);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,@RequestBody Register register){
        System.out.println(register);
        registerService.insert(register);
        return "success";
    }

    @RequestMapping("/bm")   //新增
    @ResponseBody
    public String bm(Model model,String competname,HttpSession session){
        Register register=new Register();
        /*获取登录信息*/
        User user=(User)session.getAttribute("user");

        register.setCompetname(competname);
        register.setUsername(user.getUsername());
        register.setAc(0);
        register.setTime(0);
        register.setError(0);
        System.out.println(register);
        registerService.insert(register);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(String id){
        registerService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,String id){
        Register register=registerService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("register",register);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody Register register){
        System.out.println(register);
        registerService.updateById(register);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,String id){
        Register register=registerService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("register",register);   //用户信息
        return crud;
    }


}
