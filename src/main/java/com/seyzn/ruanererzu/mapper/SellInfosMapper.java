package com.seyzn.ruanererzu.mapper;

import com.seyzn.ruanererzu.domain.SellInfosEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

/**
 * (SellInfos)表数据库访问层
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
public interface SellInfosMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param sellId 主键
     * @return 实例对象
     */
    SellInfosEntity queryById(Integer sellId);

    /**
     * 查询指定行数据
     *
     * @param sellInfos 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SellInfosEntity> queryAllByLimit(@Param("sellInfos") SellInfosEntity sellInfos, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sellInfos 查询条件
     * @return 总行数
     */
    long count(SellInfosEntity sellInfos);

    /**
     * 新增数据
     *
     * @param sellInfos 实例对象
     * @return 影响行数
     */
    int insert(SellInfosEntity sellInfos);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SellInfosEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SellInfosEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SellInfosEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SellInfosEntity> entities);

    /**
     * 修改数据
     *
     * @param sellInfos 实例对象
     * @return 影响行数
     */
    int update(SellInfosEntity sellInfos);

    /**
     * 通过主键删除数据
     *
     * @param sellId 主键
     * @return 影响行数
     */
    int deleteById(Integer sellId);

    /**
     * 查询类别销售趋势信息
     */
    List<Map<String, Object>> getProTypeSellInfo(List<String> date);
    /**
     * 查询最大销售时间
     */
    String getLastSellTime();


}

