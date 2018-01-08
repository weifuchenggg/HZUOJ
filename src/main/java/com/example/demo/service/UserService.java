package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.User;
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
public interface UserService extends IService<User> {
    public List<User> selectAll();
    public List<User> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<User> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<User> selectAll(Pagination page);
}
