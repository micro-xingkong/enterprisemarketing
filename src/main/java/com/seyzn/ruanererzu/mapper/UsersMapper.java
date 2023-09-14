package com.seyzn.ruanererzu.mapper;

import com.seyzn.ruanererzu.domain.UsersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

/**
 * (Users)表数据库访问层
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
public interface UsersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UsersEntity queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param users 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UsersEntity> queryAllByLimit(@Param("users") UsersEntity users, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param users 查询条件
     * @return 总行数
     */
    long count(UsersEntity users);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(UsersEntity users);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UsersEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UsersEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UsersEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UsersEntity> entities);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(UsersEntity users);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

    /**
     * 登录
     * @param param
     * @return
     */
   UsersEntity login(Map<String, Object> param);
}

