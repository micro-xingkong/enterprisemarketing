package com.seyzn.ruanererzu.mapper;

import com.seyzn.ruanererzu.domain.CustomersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Customers)表数据库访问层
 *
 * @author ywb
 * @since 2023-06-29 19:23:20
 */
public interface CustomersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param cusId 主键
     * @return 实例对象
     */
    CustomersEntity queryById(Integer cusId);

    /**
     * 查询指定行数据
     *
     * @param customers 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CustomersEntity> queryAllByLimit(@Param("customers") CustomersEntity customers, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param customers 查询条件
     * @return 总行数
     */
    long count(CustomersEntity customers);

    /**
     * 新增数据
     *
     * @param customers 实例对象
     * @return 影响行数
     */
    int insert(CustomersEntity customers);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustomersEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CustomersEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustomersEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CustomersEntity> entities);

    /**
     * 修改数据
     *
     * @param customers 实例对象
     * @return 影响行数
     */
    int update(CustomersEntity customers);

    /**
     * 通过主键删除数据
     *
     * @param cusId 主键
     * @return 影响行数
     */
    int deleteById(Integer cusId);

}

