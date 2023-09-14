package com.seyzn.ruanererzu.service;

import com.seyzn.ruanererzu.domain.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Users)表服务接口
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UsersEntity queryById(Integer userId);

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UsersEntity> queryByPage(UsersEntity users, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    boolean insert(UsersEntity users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    boolean update(UsersEntity users);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 登录
     * @param userName
     * @param userPwd
     * @return
     */
    UsersEntity login(String userName, String userPwd);
}
