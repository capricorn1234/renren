package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebClassifyDao;
import io.renren.modules.reception.service.ClassifyService;
import io.renren.modules.sys.entity.ContentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webclassifyService")
public class ClassifyServiceImpl extends ServiceImpl<WebClassifyDao, ContentsEntity> implements ClassifyService {
   @Autowired
   private WebClassifyDao classifyDao;






    @Override
    public List<ContentsEntity> getClassifyPageList(Long classifyId, int pagesize, int pageNo) {
        return classifyDao.getClassifyPageList(classifyId,pagesize,pageNo);
    }

    @Override
    public Long getTotalCount(Long classifyId) {
        return classifyDao.getTotalCount(classifyId);
    }

}