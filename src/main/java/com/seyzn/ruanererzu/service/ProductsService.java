package com.seyzn.ruanererzu.service;

import com.seyzn.ruanererzu.domain.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Products)表服务接口
 *
 * @author makejava
 * @since 2023-07-01 20:00:26
 */
public interface ProductsService {

    /**
     * 通过ID查询单条数据
     *
     * @param proId 主键
     * @return 实例对象
     */
    ProductsEntity queryById(Integer proId);

    /**
     * 分页查询
     *
     * @param products 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ProductsEntity> queryByPage(ProductsEntity products, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    boolean insert(ProductsEntity products);

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    boolean update(ProductsEntity products);

    /**
     * 通过主键删除数据
     *
     * @param proId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer proId);

}
