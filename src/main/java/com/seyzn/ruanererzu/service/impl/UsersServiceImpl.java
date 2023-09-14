package com.seyzn.ruanererzu.service.impl;

import com.seyzn.ruanererzu.domain.UsersEntity;
import com.seyzn.ruanererzu.mapper.UsersMapper;
import com.seyzn.ruanererzu.service.UsersService;
import com.seyzn.ruanererzu.util.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Users)表服务实现类
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private UsersMapper usersMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UsersEntity queryById(Integer userId) {
        return this.usersMapper.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param users       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UsersEntity> queryByPage(UsersEntity users, Integer page, Integer size, String orderCol, String orderDirect) {
        if (page == null || page <= 0) {
            page = PAGE_DEFAULT;
        }
        if (size == null || size <= 0) {
            size = SIZE_DEFAULT;
        }

        Sort sort = null;
        if (orderCol != null) {
            Sort.Order order = new Sort.Order(("DESC".equals(orderDirect) ? Sort.Direction.DESC : Sort.Direction.ASC), orderCol);
            sort = Sort.by(order);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        if (sort != null) {
            pageRequest = PageRequest.of(page - 1, size, sort);
        }

        long total = this.usersMapper.count(users);

        return new PageImpl<>(this.usersMapper.queryAllByLimit(users, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(UsersEntity users) {
        return this.usersMapper.insert(users) > 0;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(UsersEntity users) {
        return this.usersMapper.update(users) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.usersMapper.deleteById(userId) > 0;
    }

    /**
     * 登录
     *
     * @param userName
     * @param userPwd
     * @return
     */
    public UsersEntity login(String userName, String userPwd) {
        //封装入参到一个Map中
        Map<String, Object> param = new HashMap<>();
        param.put("userName", userName);
        //对密码进行加密  123 -- d8/ZDtAN2a7IDQmuAZ1B0w==
        System.out.println(PasswordUtil.degistPwd(userPwd));
        param.put("userPwd", PasswordUtil.degistPwd(userPwd));

        return this.usersMapper.login(param);
    }
}
