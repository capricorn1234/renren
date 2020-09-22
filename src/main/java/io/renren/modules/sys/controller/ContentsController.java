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

import io.renren.modules.sys.entity.ContentsEntity;
import io.renren.modules.sys.service.ContentsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.validation.Valid;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@RestController
@RequestMapping("generator/contents")
@Api(tags = "内容管理")
public class ContentsController {
    @Autowired
    private ContentsService contentsService;
    @GetMapping("/select")
    @RequiresPermissions("web:classify:select")
    @ApiOperation(value = "内容管理信息",notes = "内容管理信息，获取select的下拉列表")
    public R select(){
        List<ContentsEntity> menuList = contentsService.list();
        return R.ok().put("ContentsList", menuList);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("web:contents:list")
    @ApiOperation(value="获取前台网站目录",notes = "根据权限返回数据")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = contentsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("web:contents:info")
    @ApiOperation(value="查找内容信息",notes = "查找内容数据")
    public R info(@PathVariable("id") Long id){
		ContentsEntity contents = contentsService.getById(id);

        return R.ok().put("contents", contents);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("web:contents:save")
    @ApiOperation(value="保存内容信息",notes = "保存内容数据")
    public R save(@RequestBody @Valid  ContentsEntity contents){
		contentsService.save(contents);

        return R.ok();
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("web:contents:update")
    @ApiOperation(value="修改内容信息",notes = "修改内容数据")
    public R update(@RequestBody ContentsEntity contents){
        contentsService.updateById(contents);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("web:contents:delete")
    @ApiOperation(value="删除内容信息",notes = "删除内容数据")
    public R delete(@RequestBody Long[] ids){
		contentsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
