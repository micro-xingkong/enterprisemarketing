package com.seyzn.ruanererzu.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Products)实体类
 *
 * @author makejava
 * @since 2023-07-01 20:00:26
 */
@Data
public class ProductsEntity implements Serializable {
    private static final long serialVersionUID = 710974931801041639L;
    
    private Integer proId;
    
    private ProductTypesEntity productTypes;
    
    private String proName;
    
    private String proDesc;
    
    private Double proPrice;
    
    private Integer delMark;

}

