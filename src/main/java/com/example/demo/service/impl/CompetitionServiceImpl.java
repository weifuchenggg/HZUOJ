package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Competition;
import com.example.demo.mapper.CompetitionMapper;
import com.example.demo.service.CompetitionService;
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
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition> implements CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;

    public List<Competition> selectAll() {
        return competitionMapper.selectList(new EntityWrapper<Competition>());
    }

    public List<Competition> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return competitionMapper.selectListByFilter(sql,page);
    }

    public List<Competition> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return competitionMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return competitionMapper.selectListBysql(sql);
    }

    @Override
    public List<Competition> selectAll(Pagination page){
        return competitionMapper.selectAll(page);
    }
}
