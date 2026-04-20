package com.project.user.query;

import lombok.Data;

/**
 * 用户新增请求
 */
@Data
public class UserAddQuery {

    private String userId;

    private String userName;

    private String userPhone;

    private String dept;

    private String position;

    private String passWord;

    /**
     * 1-启用，0-停用
     */
    private String status;

    /**
     * 角色
     */
    private String role;
}

