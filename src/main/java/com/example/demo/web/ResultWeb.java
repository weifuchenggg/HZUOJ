package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Result;
import com.example.demo.service.ResultService;
import com.example.demo.util.MyDeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.function.ObjDoubleConsumer;

@Controller
@RequestMapping("/result")
public class ResultWeb {

    private final String crud="/result/ResultCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/result/resultUi";
    }

    @Autowired
    ResultService resultService;

    @RequestMapping("/getresult")
    @ResponseBody
    public Map<String,Object> getresult(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Map<String,Object>> lists;
        int total=resultService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=resultService.selectListMapByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        MyDeCode.deCode(lists,"state","oj_result");
        MyDeCode.deCode(lists,"language","oj_language");
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Result result=new Result();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("result",result);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,Result result){
        result.setCreatetime(new Date());
        result.setState("0");
        result.setUser("weifucheng");
        System.out.println(result);
        resultService.insert(result);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(String id){
        resultService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,String id){
        Result result=resultService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("result",result);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody Result result){
        System.out.println(result);
        resultService.updateById(result);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,String id){
        Result result=resultService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("result",result);   //用户信息
        return crud;
    }


}
