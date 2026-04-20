package com.project.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.ResultBean;
import com.project.user.entity.Tuser;
import com.project.user.query.LoginQuery;
import com.project.user.query.UserAddQuery;
import com.project.user.query.UserDeleteQuery;
import com.project.user.query.UserQuery;
import com.project.user.query.UserUpdateQuery;
import com.project.user.vo.UserInfoVO;

/**
 * UserService
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:15
 * 描述
 *
 */
public interface UserService  extends IService<Tuser> {

    ResultBean<?> login(LoginQuery query);

    ResultBean<?> addUser(UserAddQuery query);

    ResultBean<?> updateUser(UserUpdateQuery query);

    ResultBean<?> deleteUser(UserDeleteQuery query);

    IPage<UserInfoVO> query(Page<Tuser> page, UserQuery query);

}
