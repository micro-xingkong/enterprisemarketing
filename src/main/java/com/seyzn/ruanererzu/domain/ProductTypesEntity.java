package com.seyzn.ruanererzu.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (ProductTypes)实体类
 *
 * @author makejava
 * @since 2023-07-01 21:48:35
 */
@Data
public class ProductTypesEntity implements Serializable {
    private static final long serialVersionUID = -69755677371747011L;
    
    private Integer typeId;
    
    private String typeName;
    
    private String typeDesc;
    
    private Integer delMark;

}

