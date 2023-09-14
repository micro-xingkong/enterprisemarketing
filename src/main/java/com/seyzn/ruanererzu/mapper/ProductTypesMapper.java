package com.seyzn.ruanererzu.mapper;

import com.seyzn.ruanererzu.domain.ProductTypesEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ProductTypes)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-01 21:48:35
 */
public interface ProductTypesMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    ProductTypesEntity queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param productTypes 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ProductTypesEntity> queryAllByLimit(@Param("productTypes") ProductTypesEntity productTypes, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param productTypes 查询条件
     * @return 总行数
     */
    long count(ProductTypesEntity productTypes);

    /**
     * 新增数据
     *
     * @param productTypes 实例对象
     * @return 影响行数
     */
    int insert(ProductTypesEntity productTypes);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductTypesEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductTypesEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductTypesEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ProductTypesEntity> entities);

    /**
     * 修改数据
     *
     * @param productTypes 实例对象
     * @return 影响行数
     */
    int update(ProductTypesEntity productTypes);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}

