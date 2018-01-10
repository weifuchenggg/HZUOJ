package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Result;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author weifucheng
 */
public interface ResultService extends IService<Result> {
    public List<Result> selectAll();
    public List<Result> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<Result> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<Map<String,Object>> selectListMapByFilter(String filter, String sort, String order, Pagination page);
    public List<Result> selectAll(Pagination page);
}
