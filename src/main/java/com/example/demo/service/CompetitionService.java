package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Competition;
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
public interface CompetitionService extends IService<Competition> {
    public List<Competition> selectAll();
    public List<Competition> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<Competition> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<Competition> selectAll(Pagination page);
}
