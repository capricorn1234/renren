package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebBannerDao;
import io.renren.modules.reception.service.BannerService;
import io.renren.modules.sys.entity.BannerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webbannerService")
public class BannerServiceImpl extends ServiceImpl<WebBannerDao, BannerEntity> implements BannerService {
     @Autowired
     private WebBannerDao bannerDao;


    @Override
    public List<BannerEntity> getBannerList() {
        return bannerDao.getBannerList();
    }

}