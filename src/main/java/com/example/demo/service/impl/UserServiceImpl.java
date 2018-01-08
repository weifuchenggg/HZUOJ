package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weifucheng
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> selectAll() {
        return userMapper.selectList(new EntityWrapper<User>());
    }

    public List<User> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return userMapper.selectListByFilter(sql,page);
    }

    public List<User> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return userMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return userMapper.selectListBysql(sql);
    }

    @Override
    public List<User> selectAll(Pagination page){
        return userMapper.selectAll(page);
    }
}
