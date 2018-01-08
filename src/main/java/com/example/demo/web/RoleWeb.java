package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

@Controller
@RequestMapping("/role")
public class RoleWeb {

    private final String crud="/role/RoleCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/role/roleUi";
    }

    @Autowired
    RoleService roleService;

    @RequestMapping("/getrole")
    @ResponseBody
    public Map<String,Object> getrole(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Role> lists=roleService.selectAll();
        int total=roleService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=roleService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Role role=new Role();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("role",role);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //跳转新增页面
    @ResponseBody
    public String add(Model model,Role role){
        System.out.println(role);
        roleService.insert(role);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(Integer id){
        roleService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,Integer id){
        Role role=roleService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("role",role);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,Role role){
        System.out.println(role);
        roleService.updateById(role);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,Integer id){
        Role role=roleService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("role",role);   //用户信息
        return crud;
    }


}
