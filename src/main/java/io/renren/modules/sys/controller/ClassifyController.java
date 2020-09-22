package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.entity.FrontMenuEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.ClassifyEntity;
import io.renren.modules.sys.service.ClassifyService;
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
@RequestMapping("generator/classify")
@Api(tags = "分类服务")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;
    /**
     * 下拉选择列表
     */
    @GetMapping("/select")
    @RequiresPermissions("web:classify:select")
    @ApiOperation(value = "分类管理信息",notes = "分类管理信息，获取select的下拉列表")
    public R select(){
        List<ClassifyEntity> menuList = classifyService.list();
        return R.ok().put("classifyList", menuList);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("web:classify:list")
    @ApiOperation(value = "分类管理列表信息",notes = "获取列表信息 分页")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classifyService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("web:classify:info")
    @ApiOperation(value = "分类管理查询id",notes = "通过id查询信息")
    public R info(@PathVariable("id") Long id){
		ClassifyEntity classify = classifyService.getById(id);

        return R.ok().put("classify", classify);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("web:classify:save")
    @ApiOperation(value = "分类保存管理",notes = "通过保存查询信息")
    public R save(@RequestBody ClassifyEntity classify){
		classifyService.save(classify);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("web:classify:update")
    @ApiOperation(value = "分类更新管理",notes = "通过classify实体更新信息")
    public R update(@RequestBody ClassifyEntity classify){
		classifyService.updateById(classify);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("web:classify:delete")
    @ApiOperation(value = "分类删除管理",notes = "通过id删除")
    public R delete(@RequestBody Long[] ids){
		classifyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
