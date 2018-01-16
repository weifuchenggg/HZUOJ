package com.example.demo.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Result;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author weifucheng
 * @since 2017-11-24
 */
public interface ResultMapper extends BaseMapper<Result> {

    @Select("select * from result")
    public List<Result> selectAll(Pagination page);
    @Select("select * from result  ${sql}")
    public List<Result> selectListByFilter(@Param("sql") String sql,Pagination page);
    @Select("select * from result  ${sql}")
    public List<Result> selectListByFilter(@Param("sql") String sql);
    @Select("select count(1) from result  ${sql}")
    public int selectCountByFilter(@Param("sql") String sql);
    @Select("${sql}")
    public List<Map<String,Object>> selectListBysql(@Param("sql") String sql);
    @Select("select * from result  ${sql}")
    public List<Map<String,Object>> selectListMapByFilter(@Param("sql") String sql,Pagination page);
}