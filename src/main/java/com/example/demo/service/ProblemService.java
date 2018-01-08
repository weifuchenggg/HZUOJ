package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Problem;
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
public interface ProblemService extends IService<Problem> {
    public List<Problem> selectAll();
    public List<Problem> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<Problem> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<Problem> selectAll(Pagination page);
}
