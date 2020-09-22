package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebContentsDao;

import io.renren.modules.reception.service.ContentsService;
import io.renren.modules.sys.entity.ContentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webcontentsService")
public class ContentsServiceImpl extends ServiceImpl<WebContentsDao, ContentsEntity> implements ContentsService {
           @Autowired
           private WebContentsDao contentsDao;


    @Override
    public List<ContentsEntity> getContent(Long id) {
        return contentsDao.getContent(id);
    }

}