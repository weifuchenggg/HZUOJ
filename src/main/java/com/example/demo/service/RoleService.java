package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.demo.entity.Role;
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
public interface RoleService extends IService<Role> {
    public List<Role> selectAll();
    public List<Role> selectListByFilter(String filter, String sort, String order, Pagination page);
    public List<Role> selectListByFilter(String filter, String sort, String order);
    public List<Map<String,Object>> selectListBysql(String sql);
    public List<Role> selectAll(Pagination page);
}
