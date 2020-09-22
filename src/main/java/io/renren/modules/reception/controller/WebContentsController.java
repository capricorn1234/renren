package io.renren.modules.reception.controller;


import io.renren.common.utils.R;

import io.renren.modules.reception.service.ContentsService;
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
@Api(tags = "前台信息4")
public class WebContentsController {
    @Autowired
    private ContentsService contentsService;



    /**
     * 信息
     */
    @PostMapping("/getContent")
    @ResponseBody
    @ApiOperation(value = "Content信息",notes = "Content信息")
    public R getContent(@RequestParam Long id){
        List<ContentsEntity> data = contentsService.getContent(id);
        return R.ok().put("data",data);
    }



}
