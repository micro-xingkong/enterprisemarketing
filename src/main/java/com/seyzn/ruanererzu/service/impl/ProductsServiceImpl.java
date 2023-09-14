package com.seyzn.ruanererzu.service.impl;

import com.seyzn.ruanererzu.domain.ProductsEntity;
import com.seyzn.ruanererzu.mapper.ProductsMapper;
import com.seyzn.ruanererzu.service.ProductsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Products)表服务实现类
 *
 * @author makejava
 * @since 2023-07-01 20:00:26
 */
@Service("productsService")
public class ProductsServiceImpl implements ProductsService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private ProductsMapper productsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param proId 主键
     * @return 实例对象
     */
    @Override
    public ProductsEntity queryById(Integer proId) {
        return this.productsMapper.queryById(proId);
    }

    /**
     * 分页查询
     *
     * @param products 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ProductsEntity> queryByPage(ProductsEntity products, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.productsMapper.count(products);
        
        return new PageImpl<>(this.productsMapper.queryAllByLimit(products, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(ProductsEntity products) {
        return this.productsMapper.insert(products) > 0;
    }

    /**
     * 修改数据
     *
     * @param products 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(ProductsEntity products) {
       return this.productsMapper.update(products) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param proId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer proId) {
        return this.productsMapper.deleteById(proId) > 0;
    }
}
