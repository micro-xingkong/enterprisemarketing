package com.seyzn.ruanererzu.service;

import com.seyzn.ruanererzu.domain.CustomersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Customers)表服务接口
 *
 * @author ywb
 * @since 2023-06-29 19:23:20
 */
public interface CustomersService {

    /**
     * 通过ID查询单条数据
     *
     * @param cusId 主键
     * @return 实例对象
     */
    CustomersEntity queryById(Integer cusId);

    /**
     * 分页查询
     *
     * @param customers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CustomersEntity> queryByPage(CustomersEntity customers, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param customers 实例对象
     * @return 实例对象
     */
    boolean insert(CustomersEntity customers);

    /**
     * 修改数据
     *
     * @param customers 实例对象
     * @return 实例对象
     */
    boolean update(CustomersEntity customers);

    /**
     * 通过主键删除数据
     *
     * @param cusId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cusId);

}
