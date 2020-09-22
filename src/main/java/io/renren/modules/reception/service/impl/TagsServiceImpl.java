package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebTagsDao;
import io.renren.modules.reception.service.TagsService;
import io.renren.modules.sys.entity.ContentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webtagsService")
public class TagsServiceImpl extends ServiceImpl<WebTagsDao, ContentsEntity> implements TagsService {
@Autowired
private WebTagsDao tagsDao;


    @Override
    public List<ContentsEntity> getTagPageList(Long tagid,int pagesize,int pageNo) {
        return tagsDao.getTagPageList(tagid,pagesize,pageNo);
    }

    @Override
    public Long getTotalCount(Long tagid) {
        return tagsDao.getTotalCount(tagid);
    }

}