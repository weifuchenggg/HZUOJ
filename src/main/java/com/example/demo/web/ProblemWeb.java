package com.example.demo.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.Problem;
import com.example.demo.service.ProblemService;
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
@RequestMapping("/problem")
public class ProblemWeb {

    private final String crud="/problem/ProblemCrud";  //增删改查页面

    @RequestMapping("/index")
    public String index(){
        return "/problem/problemUi";
    }

    @Autowired
    ProblemService problemService;

    @RequestMapping("/getproblem")
    @ResponseBody
    public Map<String,Object> getproblem(int page, int rows,String filter,String sort,String order){
        System.out.println("page="+page+"    rows="+rows+"   filter="+filter+"   "+sort+" "+ order);
        List<Problem> lists=problemService.selectAll();
        int total=problemService.selectCount(new EntityWrapper<>());
        //分页
        Page<Map<String,Object>> pg=new Page(page,rows);
        lists=problemService.selectListByFilter(filter,sort,order,pg);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",total);
        map.put("rows",lists);
        return map;
    }

    @RequestMapping("/toAdd")   //跳转新增页面
    public String toAdd(Model model){
        Problem problem=new Problem();
        model.addAttribute("readonly",false);
        model.addAttribute("vis_add",true);   //增加按钮显示
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("problem",problem);   //用户信息
        return crud;
    }

    @RequestMapping("/add")   //新增
    @ResponseBody
    public String add(Model model,@RequestBody Problem problem){
        System.out.println(problem);
        problemService.insert(problem);
        return "success";
    }

    @RequestMapping("/del")  //删除
    @ResponseBody
    public String del(String id){
        problemService.deleteById(id);
        return "sucess";
    }

    @RequestMapping("/toUpdate")  //跳到修改页面
    public String toUpdate(Model model,String id){
        Problem problem=problemService.selectById(id);
        model.addAttribute("readonly",false);   //可以读写
        model.addAttribute("vis_save",true);   //保存按钮显示
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("problem",problem);   //用户信息
        return crud;
    }

    @RequestMapping("/update")  //修改
    @ResponseBody
    public String update(Model model,@RequestBody Problem problem){
        System.out.println(problem);
        problemService.updateById(problem);
        return "sucess";
    }

    @RequestMapping("/toView")  //跳到查看页面
    public String toView(Model model,String id){
        Problem problem=problemService.selectById(id);
        model.addAttribute("readonly",true);
        model.addAttribute("vis_save",false);   //保存按钮隐藏
        model.addAttribute("vis_add",false);   //增加按钮隐藏
        model.addAttribute("problem",problem);   //用户信息
        return crud;
    }


}
