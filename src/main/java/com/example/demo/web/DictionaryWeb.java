package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Dictionary;
import com.example.demo.service.DictionaryService;
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
@RequestMapping("/dictionary")
public class DictionaryWeb {

    private final String crud="/dictionary/DictionaryCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/dictionary/dictionaryUi";
    }

    @Autowired
    DictionaryService dictionaryService;

    @RequestMapping("/getdictionary")
    @ResponseBody
    public Map<String,Object> getdictionary(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Dictionary> lists=dictionaryService.selectAll();
        int total=dictionaryService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=dictionaryService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Dictionary dictionary=new Dictionary();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("dictionary",dictionary);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,@RequestBody Dictionary dictionary){
        System.out.println(dictionary);
        dictionaryService.insert(dictionary);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(Integer id){
        dictionaryService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,Integer id){
        Dictionary dictionary=dictionaryService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("dictionary",dictionary);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody Dictionary dictionary){
        System.out.println(dictionary);
        dictionaryService.updateById(dictionary);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,Integer id){
        Dictionary dictionary=dictionaryService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("dictionary",dictionary);   //用户信息
        return crud;
    }


}
