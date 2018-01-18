package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Register;
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
public interface RegisterService extends IService<Register> {
    public List<Register> selectAll();
    public List<Register> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<Register> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<Map<String,Object>> selectListMapByFilter(String filter, String sort, String order, Pagination page);
    public List<Register> selectAll(Pagination page);
    public int selectCountByFilter(@Param("sql") String sql);
    public List<Map<String,Object>> selectListMapByFilter(@Param("sql") String sql,@Param("list") List list);
    public Integer selectListMapCountByFilter(@Param("sql") String sql,@Param("list") List list);
}
