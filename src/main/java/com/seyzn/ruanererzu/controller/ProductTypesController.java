package com.seyzn.ruanererzu.controller;

import com.seyzn.ruanererzu.domain.ProductTypesEntity;
import com.seyzn.ruanererzu.service.ProductTypesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seyzn.ruanererzu.util.ReturnVO;

import javax.annotation.Resource;

/**
 * (ProductTypes)表控制层
 *
 * @author makejava
 * @since 2023-07-01 21:48:35
 */
@RestController
@RequestMapping("productTypes")
public class ProductTypesController {
    /**
     * 服务对象
     */
    @Resource
    private ProductTypesService productTypesService;

    /**
     * 分页查询
     *
     * @param productTypes 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @RequestMapping("queryByPage")
    public ReturnVO queryByPage(ProductTypesEntity productTypes, Integer page, Integer size, String orderCol, String orderDirect) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        
        //查询
        Page<ProductTypesEntity> pageVO = 
            this.productTypesService.queryByPage(
                productTypes, 
                page, size, 
                orderCol, orderDirect);
        //没有数据
        if(pageVO.getContent().isEmpty()){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(pageVO);
        return returnVO;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("queryById/{id}")
    public ReturnVO queryById(@PathVariable("id") Integer id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //查询单个
        ProductTypesEntity productTypes = this.productTypesService.queryById(id);
        
        if(productTypes == null){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(productTypes);
        
        return returnVO;
    }

    /**
     * 新增数据
     *
     * @param productTypes 实体
     * @return 新增结果
     */
    @RequestMapping("add")
    public ReturnVO add(ProductTypesEntity productTypes) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //入库
        if(!this.productTypesService.insert(productTypes)){
            //入库失败
            return returnVO;
        }
        //入库成功
        returnVO.setCode(1);
        returnVO.setMsg("添加成功");
        
        return returnVO;
    }

    /**
     * 编辑数据
     *
     * @param productTypes 实体
     * @return 编辑结果
     */
    @RequestMapping("edit")
    public ReturnVO edit(ProductTypesEntity productTypes) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //修改
        if(!this.productTypesService.update(productTypes)){
            //修改失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("修改成功");
        
        return returnVO;
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @RequestMapping("deleteById/{id}")
    public ReturnVO deleteById(Integer id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //删除
        if(!this.productTypesService.deleteById(id)){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("删除成功");
        
        return returnVO;
    }

}
