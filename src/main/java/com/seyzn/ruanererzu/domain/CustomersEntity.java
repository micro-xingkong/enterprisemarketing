package com.seyzn.ruanererzu.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Customers)实体类
 *
 * @author ywb
 * @since 2023-06-29 19:23:20
 */
@Data
public class CustomersEntity implements Serializable {
    private static final long serialVersionUID = -98247192167816916L;
    
    private Integer cusId;
    
    private String cusName;
    
    private String cusDesc;
    
    private Integer delMark;

}

