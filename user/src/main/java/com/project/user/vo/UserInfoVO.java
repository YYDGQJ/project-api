package com.project.user.vo;

import lombok.Data;

/**
 * 用户信息返回对象（不包含密码）
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
public class UserInfoVO {

    private Long id;

    private String userId;

    private String userName;

    private String userPhone;

    private String dept;

    private String position;

    /**
     * 1-启用，0-停用
     */
    private Integer status;

    /**
     * 角色
     */
    private String role;

}

