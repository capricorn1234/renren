package io.renren.modules.reception.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import io.renren.modules.reception.service.ClassifyService;
import io.renren.modules.sys.entity.ContentsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "前台信息2")
public class WebClassifyController {
    @Autowired
    private ClassifyService classifyService;


    /**
     * 信息
     */
    @PostMapping("/getClassifyPageList")
    @ResponseBody
    @ApiOperation(value = "ClassifyPageList信息",notes = "ClassifyPageList信息")
    public R getClassifyPageList(@RequestParam Long classifyId,@RequestParam int pageNo,@RequestParam int pagesize){
        List<ContentsEntity> data = classifyService.getClassifyPageList(classifyId,pageNo,pagesize);
        Long totalCount = classifyService.getTotalCount(classifyId);
        PageUtils page=new PageUtils(data,totalCount.intValue(),pagesize,pageNo);
        return R.ok().put("page",page);
    }




}
