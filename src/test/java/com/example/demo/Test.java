package com.example.demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    JdbcTemplate jdbcTemplate;






    @org.junit.Test
    public void fun(){
        /*User user=new User();
        List<Tt> list= ttMapper.selectList(new EntityWrapper<Tt>());
      //  List<UserRole> userRoles=userRoleMapper.selectList(new EntityWrapper<UserRole>());
        Page<Map<String,Object>> page=new Page(1,4);
        //List<Map<String,Object>> users=userMapper.selectMapsPage(page,(EntityWrapper)
         //       new EntityWrapper<>());
        List<User> users=userMapper.selectList(new EntityWrapper<>());
       // users=userMapper.getalluser(page,"hlhdidi");
        System.out.println(users);
       // users=userMapper.getusers("select * from user,role");
        //System.out.println(users);*/
    }
}
