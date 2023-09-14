package com.seyzn.ruanererzu.controller;

import com.seyzn.ruanererzu.domain.ProductsEntity;
import com.seyzn.ruanererzu.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seyzn.ruanererzu.util.ReturnVO;

import javax.annotation.Resource;

/**
 * (Products)表控制层
 *
 * @author makejava
 * @since 2023-07-01 20:00:26
 */
@RestController
@RequestMapping("products")
public class ProductsController {
    /**
     * 服务对象
     */
    @Resource
    private ProductsService productsService;

    /**
     * 分页查询
     *
     * @param products 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @RequestMapping("queryByPage")
    public ReturnVO queryByPage(ProductsEntity products, Integer page, Integer size, String orderCol, String orderDirect) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        
        //查询
        Page<ProductsEntity> pageVO = 
            this.productsService.queryByPage(
                products, 
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
        ProductsEntity products = this.productsService.queryById(id);
        
        if(products == null){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(products);
        
        return returnVO;
    }

    /**
     * 新增数据
     *
     * @param products 实体
     * @return 新增结果
     */
    @RequestMapping("add")
    public ReturnVO add(ProductsEntity products) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //入库
        if(!this.productsService.insert(products)){
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
     * @param products 实体
     * @return 编辑结果
     */
    @RequestMapping("edit")
    public ReturnVO edit(ProductsEntity products) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //修改
        if(!this.productsService.update(products)){
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
        if(!this.productsService.deleteById(id)){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("删除成功");
        
        return returnVO;
    }

}
