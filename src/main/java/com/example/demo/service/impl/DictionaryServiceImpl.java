package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Dictionary;
import com.example.demo.mapper.DictionaryMapper;
import com.example.demo.service.DictionaryService;
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
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    public List<Dictionary> selectAll() {
        return dictionaryMapper.selectList(new EntityWrapper<Dictionary>());
    }

    public List<Dictionary> selectListByFilter(String filter, String sort, String order, Pagination page) {
        String sql="";
        if (filter!=null &&  !order.equals("")){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("") ){
            sql+=" order by "+sort+" "+order;
        }
        return dictionaryMapper.selectListByFilter(sql,page);
    }

    public List<Dictionary> selectListByFilter(String filter, String sort, String order) {
        String sql="";
        if (filter!=null &&  !order.equals("") ){
            sql+=" where " +filter;
        }
        if (order!=null &&  !order.equals("")){
            sql+=" order by "+sort+" "+order;
        }
        return dictionaryMapper.selectListByFilter(sql);
    }

    @Override
    public List<Map<String, Object>> selectListBysql(String sql) {
        return dictionaryMapper.selectListBysql(sql);
    }

    @Override
    public List<Dictionary> selectAll(Pagination page){
        return dictionaryMapper.selectAll(page);
    }
}
