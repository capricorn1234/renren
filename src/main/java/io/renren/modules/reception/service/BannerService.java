package io.renren.modules.reception.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.sys.entity.BannerEntity;


import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
public interface BannerService extends IService<BannerEntity> {

    //
    List<BannerEntity> getBannerList();

}

