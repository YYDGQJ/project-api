package com.project.user.query;

import lombok.Data;

/**
 * 用户查询请求
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
public class UserQuery {

    private String userId;
    private String userName;
    private String userPhone;
    private String dept;
    private String position;
    private String role;
}

