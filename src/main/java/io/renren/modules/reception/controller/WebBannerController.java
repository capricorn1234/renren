package io.renren.modules.reception.controller;


import com.google.gson.Gson;
import io.renren.common.utils.R;


import io.renren.modules.reception.model.BannerviewModel;
import io.renren.modules.reception.service.BannerService;
import io.renren.modules.sys.entity.BannerEntity;
import io.renren.modules.sys.entity.imgtype.Type;
import io.renren.modules.sys.entity.imgtype.imgTypeOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
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
@Api(tags = "前台信息1")
public class WebBannerController {
    @Autowired
    private BannerService bannerService;



    /**
     * 信息
     */
    @PostMapping("/getBannerList")
    @ResponseBody
    @ApiOperation(value = "Banner信息",notes = "Banner信息")
    public R getBannerList(){
        List<BannerEntity> data = bannerService.list();
        List<BannerviewModel> list= new ArrayList<>();
        Iterator<BannerEntity> iterable=data.iterator();
        Gson gson=new Gson();
        while(iterable.hasNext()){
            BannerEntity entity=iterable.next();
            List<imgTypeOne> imglist=new ArrayList<>();
            BannerviewModel<imgTypeOne> view=new BannerviewModel<>();
            view.setList(gson.fromJson(entity.getImguri(),imglist.getClass()));
            view.setDescription(entity.getDescription());
            view.setId(entity.getId());
            view.setTitle(entity.getTitle());
            list.add(view);
        }
        return R.ok().put("bannerlist",list);
    }



}
