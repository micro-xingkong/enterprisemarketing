package com.seyzn.ruanererzu.service.impl;

import com.seyzn.ruanererzu.domain.CustomersEntity;
import com.seyzn.ruanererzu.mapper.CustomersMapper;
import com.seyzn.ruanererzu.service.CustomersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Customers)表服务实现类
 *
 * @author ywb
 * @since 2023-06-29 19:23:20
 */
@Service("customersService")
public class CustomersServiceImpl implements CustomersService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private CustomersMapper customersMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param cusId 主键
     * @return 实例对象
     */
    @Override
    public CustomersEntity queryById(Integer cusId) {
        return this.customersMapper.queryById(cusId);
    }

    /**
     * 分页查询
     *
     * @param customers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CustomersEntity> queryByPage(CustomersEntity customers, Integer page, Integer size, String orderCol, String orderDirect) {
        if(page == null || page <= 0){
            page = PAGE_DEFAULT;
        }
        if(size == null || size <= 0){
            size = SIZE_DEFAULT;
        }

        Sort sort = null;
        if(orderCol != null) {
            Sort.Order order = new Sort.Order(("DESC".equals(orderDirect) ? Sort.Direction.DESC : Sort.Direction.ASC), orderCol);
            sort = Sort.by(order);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        if(sort != null){
            pageRequest = PageRequest.of(page - 1, size, sort);
        }
        
        long total = this.customersMapper.count(customers);
        
        return new PageImpl<>(this.customersMapper.queryAllByLimit(customers, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param customers 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(CustomersEntity customers) {
        return this.customersMapper.insert(customers) > 0;
    }

    /**
     * 修改数据
     *
     * @param customers 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(CustomersEntity customers) {
       return this.customersMapper.update(customers) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param cusId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cusId) {
        return this.customersMapper.deleteById(cusId) > 0;
    }
}
