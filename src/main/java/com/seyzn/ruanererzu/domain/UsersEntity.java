package com.seyzn.ruanererzu.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Users)实体类
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
@Data
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = -14464691059531168L;
    
    private Integer userId;
    
    private String userName;
    
    private String userPwd;
    
    private String userPic;
    
    private Integer userType;
    
    private String remark;
    
    private Integer delMark;

}

