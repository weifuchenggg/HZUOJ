package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Problem;
import com.example.demo.mapper.ProblemMapper;
import com.example.demo.service.ProblemService;
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
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {
    @Autowired
    ProblemMapper problemMapper;

    public List<Problem> selectAll() {
        return problemMapper.selectList(new EntityWrapper<Problem>());
    }

    public List<Problem> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return problemMapper.selectListByFilter(sql,page);
    }

    public List<Problem> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return problemMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return problemMapper.selectListBysql(sql);
    }

    @Override
    public List<Problem> selectAll(Pagination page){
        return problemMapper.selectAll(page);
    }

    @Override
    public int selectCountByFilter(String sql) {
        return problemMapper.selectCountByFilter(sql);
    }
}
