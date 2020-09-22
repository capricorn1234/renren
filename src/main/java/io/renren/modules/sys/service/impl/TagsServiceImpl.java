package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.TagsDao;
import io.renren.modules.sys.entity.TagsEntity;
import io.renren.modules.sys.service.TagsService;


@Service("tagsService")
public class TagsServiceImpl extends ServiceImpl<TagsDao, TagsEntity> implements TagsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TagsEntity> page = this.page(
                new Query<TagsEntity>().getPage(params),
                new QueryWrapper<TagsEntity>()
        );

        return new PageUtils(page);
    }

}