package io.renren.modules.sys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.common.validator.Assert;
import io.renren.modules.sys.entity.SysMenuEntity;
import io.renren.modules.sys.entity.menutype.menuTypeOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.FrontMenuEntity;
import io.renren.modules.sys.service.FrontMenuService;
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
@RequestMapping("web/frontmenu")
@Api(tags = "后台前台目录管理")
public class FrontMenuController extends AbstractController{
    @Autowired
    private FrontMenuService frontMenuService;

    /**
     * 验证参数是否正确
     */
    private void verifyForm(FrontMenuEntity menu){
        if(StringUtils.isBlank(menu.getMenuname())){
            throw new RRException("菜单名称不能为空");
        }
        if(menu.getParentid() == null){
            throw new RRException("上级菜单不能为空");
        }
        //菜单
        if(StringUtils.isBlank(menu.getMenuuri())){
            throw new RRException("菜单URL不能为空");
        }
        if(menu.getParentid()==menu.getId()){
            throw new RRException("上级菜单不能是本身菜单");
        }
        if(!StringUtils.isBlank(menu.getMenueparam())){
            List<menuTypeOne> list=new ArrayList<>();
            Gson gson=new Gson();
            menu.setMenueparam(gson.toJson(gson.fromJson(menu.getMenueparam(),list.getClass())));
        }
    }
    @GetMapping("/select")
    @RequiresPermissions("web:frontmenu:select")
    @ApiOperation(value="获取前台网站下拉目录",notes = "根据权限返回下拉数据")
    public R select(@PathVariable("id") Long id){
        List<FrontMenuEntity> menuList = frontMenuService.listOfSort(id);
        //添加顶级菜单
        FrontMenuEntity root = new FrontMenuEntity();
        root.setId(0L);
        root.setMenuname("一级菜单");
        root.setParentid(-1L);
        root.setOpen(true);
        menuList.add(root);

        return R.ok().put("menuList", menuList);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("generator:frontmenu:list")
    @ApiOperation(value="获取前台网站目录",notes = "根据权限返回数据")
    public List<FrontMenuEntity> list(@RequestParam Map<String, Object> params){
        List<FrontMenuEntity> menuList = frontMenuService.list();
        for(FrontMenuEntity frontMenuEntity : menuList){
            FrontMenuEntity parentMenuEntity = frontMenuService.getById(frontMenuEntity.getParentid());
            if(parentMenuEntity != null){
                frontMenuEntity.setParentName(parentMenuEntity.getMenuname());
            }
        }

        return menuList;
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("generator:frontmenu:info")
    @ApiOperation(value="获取目录信息",notes = "根据id返回数据")
    public R info(@PathVariable("id") Long id){
		FrontMenuEntity frontMenu = frontMenuService.getById(id);
        return R.ok().put("frontMenu", frontMenu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("generator:frontmenu:save")
    @ApiOperation(value="保存前台目录信息",notes = "通过数据修改保存目录数据")
    public R save(@RequestBody FrontMenuEntity frontMenu){
        verifyForm(frontMenu);
		frontMenuService.save(frontMenu);
        return R.ok();
    }

    /**
     * 修改
     * @param frontMenu 前台目录
     * @return
     */
    @PostMapping("/update")
    @RequiresPermissions("generator:frontmenu:update")
    @ApiOperation(value="修改前台目录信息",notes = "通过数据修改保存目录数据")
    public R update(@RequestBody FrontMenuEntity frontMenu){
        verifyForm(frontMenu);
        frontMenuService.updateById(frontMenu);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("generator:frontmenu:delete")
    @ApiOperation(value="后台删除目录信息",notes = "根据id删除目录")
    public R delete(@RequestBody Long[] ids){
        for(Long id :ids) {
            frontMenuService.delete(id);
        }
        return R.ok();
    }

}
