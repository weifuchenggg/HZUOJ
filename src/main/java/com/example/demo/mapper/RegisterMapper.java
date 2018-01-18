package com.example.demo.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Register;
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
public interface RegisterMapper extends BaseMapper<Register> {

    @Select("select * from register")
    public List<Register> selectAll(Pagination page);
    @Select("select * from register  ${sql}")
    public List<Register> selectListByFilter(@Param("sql") String sql,Pagination page);
    @Select("select * from register  ${sql}")
    public List<Register> selectListByFilter(@Param("sql") String sql);
    @Select("${sql}")
    public List<Map<String,Object>> selectListBysql(@Param("sql") String sql);
    @Select("select * from register  ${sql}")
    public List<Map<String,Object>> selectListMapByFilter(@Param("sql") String sql,Pagination page);
    @Select("select count(1) from register  ${sql}")
    public int selectCountByFilter(@Param("sql") String sql);

    @Select("${sql}")
    public List<Map<String,Object>> selectListMapByFilter(@Param("sql") String sql,@Param("list") List list);
    @Select("${sql}")
    public Integer selectListMapCountByFilter(@Param("sql") String sql,@Param("list") List list);
}