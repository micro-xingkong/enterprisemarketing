package com.seyzn.ruanererzu.service.impl;

import com.seyzn.ruanererzu.domain.ProductTypesEntity;
import com.seyzn.ruanererzu.mapper.ProductTypesMapper;
import com.seyzn.ruanererzu.service.ProductTypesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ProductTypes)表服务实现类
 *
 * @author makejava
 * @since 2023-07-01 21:48:35
 */
@Service("productTypesService")
public class ProductTypesServiceImpl implements ProductTypesService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private ProductTypesMapper productTypesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public ProductTypesEntity queryById(Integer typeId) {
        return this.productTypesMapper.queryById(typeId);
    }

    /**
     * 分页查询
     *
     * @param productTypes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProductTypesEntity> queryByPage(ProductTypesEntity productTypes, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.productTypesMapper.count(productTypes);
        
        return new PageImpl<>(this.productTypesMapper.queryAllByLimit(productTypes, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param productTypes 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(ProductTypesEntity productTypes) {
        return this.productTypesMapper.insert(productTypes) > 0;
    }

    /**
     * 修改数据
     *
     * @param productTypes 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(ProductTypesEntity productTypes) {
       return this.productTypesMapper.update(productTypes) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.productTypesMapper.deleteById(typeId) > 0;
    }
}
