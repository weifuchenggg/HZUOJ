package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
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
@RequestMapping("/competition")
public class CompetitionWeb {

    private final String crud="/competition/CompetitionCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/competition/competitionUi";
    }

    @Autowired
    CompetitionService competitionService;

    @RequestMapping("/getcompetition")
    @ResponseBody
    public Map<String,Object> getcompetition(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Competition> lists=competitionService.selectAll();
        int total=competitionService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=competitionService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        for (Competition competition: lists){
            competition.setRegister("点击报名");
        }
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Competition competition=new Competition();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("competition",competition);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,@RequestBody Competition competition){
        System.out.println(competition);
        competitionService.insert(competition);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(String id){
        competitionService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,String id){
        Competition competition=competitionService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("competition",competition);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody Competition competition){
        System.out.println(competition);
        competitionService.updateById(competition);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,String id){
        Competition competition=competitionService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("competition",competition);   //用户信息
        return crud;
    }


}
