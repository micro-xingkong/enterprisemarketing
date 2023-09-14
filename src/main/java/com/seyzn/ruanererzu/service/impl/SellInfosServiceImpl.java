package com.seyzn.ruanererzu.service.impl;

import com.seyzn.ruanererzu.domain.SellInfosEntity;
import com.seyzn.ruanererzu.mapper.SellInfosMapper;
import com.seyzn.ruanererzu.service.SellInfosService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (SellInfos)表服务实现类
 *
 * @author ywb
 * @since 2023-06-29 19:23:21
 */
@Service("sellInfosService")
public class SellInfosServiceImpl implements SellInfosService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private SellInfosMapper sellInfosMapper;
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 通过ID查询单条数据
     *
     * @param sellId 主键
     * @return 实例对象
     */
    @Override
    public SellInfosEntity queryById(Integer sellId) {
        return this.sellInfosMapper.queryById(sellId);
    }

    /**
     * 分页查询
     *
     * @param sellInfos 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SellInfosEntity> queryByPage(SellInfosEntity sellInfos, Integer page, Integer size, String orderCol, String orderDirect) {
        if(page == null || page <= 0){
            page = PAGE_DEFAULT;
        }
        if(size == null || size <= 0){
            size = SIZE_DEFAULT;
        }

        Sort sort = null;
        if(orderCol != null) {
            Sort.Order order = new Sort.Order(("DESC".equals(orderDirect) ? Sort.Direction.DESC : Sort.Direction.ASC), orderCol);
            sort = Sort.by(order);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        if(sort != null){
            pageRequest = PageRequest.of(page - 1, size, sort);
        }
        
        long total = this.sellInfosMapper.count(sellInfos);
        
        return new PageImpl<>(this.sellInfosMapper.queryAllByLimit(sellInfos, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param sellInfos 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(SellInfosEntity sellInfos) {
        return this.sellInfosMapper.insert(sellInfos) > 0;
    }

    /**
     * 修改数据
     *
     * @param sellInfos 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(SellInfosEntity sellInfos) {
       return this.sellInfosMapper.update(sellInfos) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param sellId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sellId) {
        return this.sellInfosMapper.deleteById(sellId) > 0;
    }

    /**
     * 查询类别销售趋势信息
     */
    @Override
    public Map<String, Object> getProTypeSellInfo(){
        //定义最终结果
        Map<String, Object> result = new HashMap<>();

        //查询有数据的最有一天的时间
        String lastDateStr = this.sellInfosMapper.getLastSellTime();
        //转换为日期对象
        Date lastDate = null;
        try {
            lastDate = DATE_FORMAT.parse(lastDateStr);
        } catch (ParseException e) {
            lastDate = new Date();
        }

        //定义列表，放置时间字符串
        List<String> dateList = new ArrayList<>();
        //添加最后一天的时间
        dateList.add(lastDateStr);

        //循环取前六天时间，并插入到列表
        for (int i = 0; i < 6; i++) {
            Date newDate = new Date(lastDate.getTime() - (1000 * 60 * 60 * 24 * (i + 1)));
            dateList.add(0, DATE_FORMAT.format(newDate));
        }

        //调用销售数据的查询
        List<Map<String, Object>> values = this.sellInfosMapper.getProTypeSellInfo(dateList);

        //解析查询结果，封装到echarts图需要信息
        //图例
        List<String> legDate = new ArrayList<>();
        //数据列表
        List<Map<String, Object>> serList = new ArrayList<>();

        for (Map<String, Object> row: values) {
            //添加图例信息
            legDate.add(row.get("type_name").toString());
            //每个类别信息封装为一个Map
            Map<String, Object> rowSerDate = new HashedMap();
            /*
            {
									name: '日用品',
									type: 'line',
									smooth: true,
									data: [179, 122, 121, 104, 90, 100, 20]
								},
             */
            rowSerDate.put("name", row.get("type_name").toString());
            rowSerDate.put("type", "line");
            rowSerDate.put("smooth", "true");

            //类别数据列表
            List<Double> rowDataList = new ArrayList<>();
            for (String day : dateList ) {
                rowDataList.add(Double.parseDouble(row.get(day).toString()));
            }

            rowSerDate.put("data", rowDataList);

            //每个类型，添加到数据列表
            serList.add(rowSerDate);
        }

        //添加图例信息到最终map
        result.put("legDate", legDate);
        //添加数据
        result.put("serList", serList);
        //添加x轴
        result.put("xData", dateList);


        return result;
    }

}
