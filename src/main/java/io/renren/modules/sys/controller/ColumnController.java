package io.renren.modules.sys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.common.validator.Assert;
import io.renren.modules.sys.entity.columnTypeentity.ColumnType1;
import io.renren.modules.sys.entity.columnTypeentity.ColumnType2;
import io.renren.modules.sys.entity.columnTypeentity.ColumnType3;
import io.renren.modules.sys.form.ColumnFrom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.ColumnEntity;
import io.renren.modules.sys.service.ColumnService;
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
@RequestMapping("generator/column")
@Api(tags = "栏目管理")
public class ColumnController {
    @Autowired
    private ColumnService columnService;
    @PostMapping("/statu")
    @RequiresPermissions("web:column:status")
    @ApiOperation(value = "栏目激活管理",notes ="通过id激活栏目")
    public R activeStatus(@RequestParam Long id){
        columnService.updateStatus(id,true);
        return R.ok();
    }


    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("web:column:list")
    @ApiOperation(value = "栏目列表管理",notes ="获取栏目列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = columnService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("web:column:info")
    @ApiOperation(value = "栏目信息管理",notes ="通过id获取栏目信息")
    public R info(@PathVariable("id") Long id){
		ColumnEntity column = columnService.getById(id);
        return R.ok().put("column", column);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("web:column:save")
    @ApiOperation(value = "栏目保存管理",notes ="保存新的栏目")
    public R save(@RequestBody ColumnFrom columnFrom){
        ColumnEntity columnEntity=this.QueryAndverifyFromData(columnFrom);
		columnService.save(columnEntity);
        return R.ok();
    }

    /**
     * 1.过滤多余栏目内容多余数据
     * 2.验证表单数据正确性
     * 3.生成JSON填充columnData字段
     * 4.返回columnEntity栏目实体对象
     * @param columnFrom 表单内容
     * @return columnEntity 栏目实体
     */

    private ColumnEntity QueryAndverifyFromData(ColumnFrom columnFrom) {
        ColumnEntity columnEntity=new ColumnEntity();
        columnEntity.setId(columnFrom.getId());
        Assert.isNull(columnFrom.getColumntype(),"类型不能为空");
        Assert.isBlank(columnFrom.getColumndata(),"数据不能为空");
        columnEntity.setColumntype(columnFrom.getColumntype());
        Gson gson=new Gson();
        //try {
            if (columnFrom.getColumntype() == Constant.ColumnType.text.getValue()) {//文本类型对应生成内容
                ColumnType1 columnType1=gson.fromJson(columnFrom.getColumndata(), ColumnType1.class);
                columnEntity.setColumndata(gson.toJson(columnType1));
            }
            if (columnFrom.getColumntype() == Constant.ColumnType.ListAndImg.getValue()) {//列表图文类型对应生成内容
                List<ColumnType2> list = new ArrayList<>();
                list=gson.fromJson(columnFrom.getColumndata(), list.getClass());
                columnEntity.setColumndata(gson.toJson(list));
            }
            if (columnFrom.getColumntype() == Constant.ColumnType.TagORClassify.getValue()) {//列表tag和图片对应内容生成
                List<ColumnType3> list=new ArrayList<>();
                gson.fromJson(columnFrom.getColumndata(), list.getClass());
                columnEntity.setColumndata(gson.toJson(list));
            }
//        }catch(JsonSyntaxException e){
//            throw new RRException("数据类型不正确");
//        }
        columnEntity.setColumnsort(columnFrom.getColumnsort());
        columnEntity.setColumntitle(columnFrom.getColumntitle());
        columnEntity.setSavetime(DateTime.now().toDate());
        return columnEntity;
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("web:column:update")
    @ApiOperation(value = "栏目更新管理",notes ="更新栏目")
    public R update(@RequestBody ColumnFrom from){
        ColumnEntity columnEntity=this.QueryAndverifyFromData(from);
		columnService.updateById(columnEntity);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("web:column:delete")
    @ApiOperation(value = "栏目删除管理",notes ="删除栏目")
    public R delete(@RequestBody Long[] ids){
		columnService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
