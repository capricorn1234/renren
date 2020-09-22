package io.renren.modules.sys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import io.renren.common.validator.Assert;
import io.renren.modules.sys.entity.imgtype.imgTypeOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.BannerEntity;
import io.renren.modules.sys.service.BannerService;
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
@RequestMapping("web/banner")
@Api(tags = "轮播图服务")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("web:banner:list")
    @ApiOperation(value = "后台管理轮播图信息",notes = "后台管理轮播图信息")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bannerService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("web:banner:info")
    @ApiOperation(value = "后台管理轮播图查询信息",notes = "通过id查询轮播图内容")
    public R info(@PathVariable("id") Long id){
		BannerEntity banner = bannerService.getById(id);
        return R.ok().put("banner", banner);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("web:banner:save")
    @ApiOperation(value = "后台管理轮播图修改、增加信息",notes = "修改增加")
    public R save(@RequestBody BannerEntity banner){
        verifyfrom(banner);
		bannerService.save(banner);
        return R.ok();
    }
    @PostMapping("/update")
    @RequiresPermissions("web:banner:update")
    @ApiOperation(value = "后台管理轮播图修改信息",notes = "修改")
    public R update(@RequestBody BannerEntity banner){
        verifyfrom(banner);
        bannerService.updateById(banner);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("web:banner:delete")
    @ApiOperation(value = "后台管理删除轮播图信息",notes = "删除轮播图信息")
    public R delete(@RequestBody Long[] ids){
		bannerService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
    private void verifyfrom(BannerEntity entity){
        Assert.isBlank(entity.getTitle(),"标题不能为空");
        List<imgTypeOne> imglist=new ArrayList<>();
        Gson gson=new Gson();
        entity.setImguri(gson.toJson(gson.fromJson(entity.getImguri(),imglist.getClass())));
    }

}
