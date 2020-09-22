package io.renren.modules.reception.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



import io.renren.modules.reception.service.TagsService;
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
@Api(tags = "前台信息6")
public class WebTagsController {
    @Autowired
    private TagsService tagsService;


    /**
     * 信息
     */
    @PostMapping("/getTagPageList")
    @ResponseBody
    @ApiOperation(value = "TagPageList信息",notes = "TagPageList信息")
    public R getTagPageList(@RequestParam Long tagid,@RequestParam int pageNo,@RequestParam int pagesize){
        List<ContentsEntity> data = tagsService.getTagPageList(tagid,pageNo,pagesize);
        Long totalCount = tagsService.getTotalCount(tagid);
        PageUtils page=new PageUtils(data,totalCount.intValue(),pagesize,pageNo);
        return R.ok().put("page",page);
    }


}
