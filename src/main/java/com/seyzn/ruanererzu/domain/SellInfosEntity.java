package com.seyzn.ruanererzu.domain;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * (SellInfos)实体类
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
@Data
public class SellInfosEntity implements Serializable {
    private static final long serialVersionUID = -92634583446164718L;

    private Integer sellId;

    private UsersEntity user;

    private ProductsEntity product;

    private CustomersEntity customer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08")
    private Date sellTime;

    private String sellDesc;

    private Object sellCount;


}

