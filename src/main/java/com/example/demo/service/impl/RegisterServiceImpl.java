package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Register;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.service.RegisterService;
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
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    public List<Register> selectAll() {
        return registerMapper.selectList(new EntityWrapper<Register>());
    }

    public List<Register> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return registerMapper.selectListByFilter(sql,page);
    }

    @Override
    public List<Map<String, Object>> selectListMapByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return registerMapper.selectListMapByFilter(sql,page);
    }

    public List<Register> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return registerMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return registerMapper.selectListBysql(sql);
    }

    @Override
    public List<Register> selectAll(Pagination page){
        return registerMapper.selectAll(page);
    }

    @Override
    public int selectCountByFilter(String sql) {
        return registerMapper.selectCountByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListMapByFilter(String sql, List list) {
        return registerMapper.selectListMapByFilter(sql,list);
    }

    @Override
    public Integer selectListMapCountByFilter( String sql,List list) {
        return registerMapper.selectListMapCountByFilter(sql,list);
    }
}
