package com.seyzn.ruanererzu.service;

import com.seyzn.ruanererzu.domain.SellInfosEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * (SellInfos)表服务接口
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
public interface SellInfosService {

    /**
     * 通过ID查询单条数据
     *
     * @param sellId 主键
     * @return 实例对象
     */
    SellInfosEntity queryById(Integer sellId);

    /**
     * 分页查询
     *
     * @param sellInfos 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SellInfosEntity> queryByPage(SellInfosEntity sellInfos, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param sellInfos 实例对象
     * @return 实例对象
     */
    boolean insert(SellInfosEntity sellInfos);

    /**
     * 修改数据
     *
     * @param sellInfos 实例对象
     * @return 实例对象
     */
    boolean update(SellInfosEntity sellInfos);

    /**
     * 通过主键删除数据
     *
     * @param sellId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sellId);
    /**
     * 查询类别销售趋势信息
     */
    Map<String, Object> getProTypeSellInfo();

}
