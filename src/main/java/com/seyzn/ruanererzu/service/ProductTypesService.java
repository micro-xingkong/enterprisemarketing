package com.seyzn.ruanererzu.service;

import com.seyzn.ruanererzu.domain.ProductTypesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ProductTypes)表服务接口
 *
 * @author makejava
 * @since 2023-07-01 21:48:35
 */
public interface ProductTypesService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    ProductTypesEntity queryById(Integer typeId);

    /**
     * 分页查询
     *
     * @param productTypes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ProductTypesEntity> queryByPage(ProductTypesEntity productTypes, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param productTypes 实例对象
     * @return 实例对象
     */
    boolean insert(ProductTypesEntity productTypes);

    /**
     * 修改数据
     *
     * @param productTypes 实例对象
     * @return 实例对象
     */
    boolean update(ProductTypesEntity productTypes);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}
