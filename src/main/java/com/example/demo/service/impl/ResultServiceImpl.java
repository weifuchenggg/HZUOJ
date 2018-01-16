package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Result;
import com.example.demo.mapper.ResultMapper;
import com.example.demo.service.ResultService;
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
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements ResultService {
    @Autowired
    ResultMapper resultMapper;

    public List<Result> selectAll() {
        return resultMapper.selectList(new EntityWrapper<Result>());
    }

    public List<Result> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return resultMapper.selectListByFilter(sql,page);
    }

    public List<Result> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return resultMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return resultMapper.selectListBysql(sql);
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
        return resultMapper.selectListMapByFilter(sql,page);
    }

    @Override
    public List<Result> selectAll(Pagination page){
        return resultMapper.selectAll(page);
    }

    @Override
    public int selectCountByFilter(String sql) {
        return resultMapper.selectCountByFilter(sql);
    }
}
