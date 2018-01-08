package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> selectAll() {
        return roleMapper.selectList(new EntityWrapper<Role>());
    }

    public List<Role> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return roleMapper.selectListByFilter(sql,page);
    }

    public List<Role> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return roleMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return roleMapper.selectListBysql(sql);
    }

    @Override
    public List<Role> selectAll(Pagination page){
        return roleMapper.selectAll(page);
    }
}
