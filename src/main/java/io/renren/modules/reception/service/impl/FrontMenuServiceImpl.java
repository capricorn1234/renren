package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebFrontMenuDao;
import io.renren.modules.reception.service.FrontMenuService;
import io.renren.modules.sys.entity.FrontMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webfrontMenuService")
public class FrontMenuServiceImpl extends ServiceImpl<WebFrontMenuDao, FrontMenuEntity> implements FrontMenuService {
@Autowired
private WebFrontMenuDao frontMenuDao;



    @Override
    public List<FrontMenuEntity> getMenuList() {
        return frontMenuDao.getMenuList();
    }

}