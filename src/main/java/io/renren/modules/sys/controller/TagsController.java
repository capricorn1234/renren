package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.entity.ClassifyEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.TagsEntity;
import io.renren.modules.sys.service.TagsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@RestController
@RequestMapping("web/tags")
@Api(tags = "tag管理")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    /**
     * select 下拉选择框
     * @return
     */
    @GetMapping("/select")
    @RequiresPermissions("web:tags:select")
    @ApiOperation(value = "tag列表内容下拉管理",notes = "tag下拉列表内容获取")
    public R select(){
        List<TagsEntity> menuList = tagsService.list();
        return R.ok().put("tagsList", menuList);
    }


    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("web:tags:list")
    @ApiOperation(value = "tag列表内容管理",notes = "tag列表内容获取")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tagsService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:tags:info")
    @ApiOperation(value = "tag列表内容管理",notes = "通过id获取内容")
    public R info(@PathVariable("id") Long id){
		TagsEntity tags = tagsService.getById(id);

        return R.ok().put("tags", tags);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("generator:tags:save")
    @ApiOperation(value = "tag列表保存内容管理",notes = "tag列表保存内容获取")
    public R save(@RequestBody TagsEntity tags){
		tagsService.save(tags);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("generator:tags:update")
    @ApiOperation(value = "tag列表更新内容管理",notes = "tag列表更新内容获取")
    public R update(@RequestBody TagsEntity tags){
		tagsService.updateById(tags);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("generator:tags:delete")
    @ApiOperation(value = "tag列表删除内容管理",notes = "tag列表删除内容获取")
    public R delete(@RequestBody Long[] ids){
		tagsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
