package io.renren.modules.reception.controller;


import io.renren.common.utils.R;

import io.renren.modules.reception.service.ColumnService;
import io.renren.modules.sys.entity.ColumnEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@RestController
@RequestMapping("/api")
@Api(tags = "前台信息3")
public class WebColumnController {
    @Autowired
    private ColumnService columnService;


    /**
     * 信息
     */
    @PostMapping("/getColumnList")
    @ResponseBody
    @ApiOperation(value = "ColumnList信息",notes = "ColumnList信息")
    public R getColumnList(){
//        List<ContentsEntity> columnDataList1 = columnService.getColumnDataList();
//        String columnDataList = Arrays.toString(new List[]{columnDataList1});
//        List<ColumnEntity> data = columnService.getColumnList();
//        for (ColumnEntity  columnEntity:data) {
//            columnEntity.setColumndata(columnDataList);
//        }
        List<ColumnEntity> data = columnService.getColumnList();
        return R.ok().put("data",data);
    }


}
