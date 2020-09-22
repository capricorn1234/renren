package io.renren.modules.reception.controller;


import io.renren.common.utils.R;
import io.renren.modules.reception.service.FrontMenuService;
import io.renren.modules.sys.entity.FrontMenuEntity;
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
@Api(tags = "前台信息5")
public class WebFrontMenuController {
    @Autowired
    private FrontMenuService frontMenuService;



    /**
     * 信息
     */
    @PostMapping("/getMenuList")
    @ResponseBody
    @ApiOperation(value = "MenuList信息",notes = "MenuList信息")
    public R getMenuList(){
        List<FrontMenuEntity> data=frontMenuService.list();
        return R.ok().put("data",data);
        //;
    }



}
