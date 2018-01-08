package com.example.demo.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    public List<User> selectAll(Pagination page);
    @Select("select * from user  ${sql}")
    public List<User> selectListByFilter(@Param("sql") String sql,Pagination page);
    @Select("select * from user  ${sql}")
    public List<User> selectListByFilter(@Param("sql") String sql);
    @Select("${sql}")
    public List<Map<String,Object>> selectListBysql(@Param("sql") String sql);
}