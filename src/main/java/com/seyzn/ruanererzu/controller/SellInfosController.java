package com.seyzn.ruanererzu.controller;

import com.seyzn.ruanererzu.util.ReturnVO;
import com.seyzn.ruanererzu.domain.SellInfosEntity;
import com.seyzn.ruanererzu.service.SellInfosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seyzn.ruanererzu.util.ReturnVO;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (SellInfos)表控制层
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
@RestController
@RequestMapping("sellInfos")
public class SellInfosController {
    /**
     * 服务对象
     */
    @Resource
    private SellInfosService sellInfosService;

    /**
     * 分页查询
     *
     * @param sellInfos 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @RequestMapping("queryByPage")
    public ReturnVO queryByPage(SellInfosEntity sellInfos, Integer page, Integer size, String orderCol, String orderDirect) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        
        //查询
        Page<SellInfosEntity> pageVO = 
            this.sellInfosService.queryByPage(
                sellInfos, 
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
        SellInfosEntity sellInfos = this.sellInfosService.queryById(id);
        
        if(sellInfos == null){
            return returnVO;
        }
        //查询成功
        returnVO = ReturnVO.getSuccessDataReturnVO(sellInfos);
        
        return returnVO;
    }

    /**
     * 新增数据
     *
     * @param sellInfos 实体
     * @return 新增结果
     */
    @RequestMapping("add")
    public ReturnVO add(SellInfosEntity sellInfos) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //入库
        if(!this.sellInfosService.insert(sellInfos)){
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
     * @param sellInfos 实体
     * @return 编辑结果
     */
    @RequestMapping("edit")
    public ReturnVO edit(SellInfosEntity sellInfos) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //修改
        if(!this.sellInfosService.update(sellInfos)){
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
    public ReturnVO deleteById(@PathVariable Integer id) {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //删除
        if(!this.sellInfosService.deleteById(id)){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("删除成功");
        
        return returnVO;
    }
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @RequestMapping("getProTypeSellInfo")
    public ReturnVO getProTypeSellInfo() {
        //定义失败的返回对象
        ReturnVO returnVO = ReturnVO.getNodataFoundReturnVO();
        //获取信息
        Map<String, Object> sellTypeInfoMap = this.sellInfosService.getProTypeSellInfo();
        if(sellTypeInfoMap.isEmpty()){
            //删除失败
            return returnVO;
        }
        //修改成功
        returnVO.setCode(1);
        returnVO.setMsg("查询成功");
        returnVO.setContent(sellTypeInfoMap);

        return returnVO;
    }

}
