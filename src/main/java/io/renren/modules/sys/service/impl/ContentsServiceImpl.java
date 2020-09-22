package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ContentsDao;
import io.renren.modules.sys.entity.ContentsEntity;
import io.renren.modules.sys.service.ContentsService;


@Service("contentsService")
public class ContentsServiceImpl extends ServiceImpl<ContentsDao, ContentsEntity> implements ContentsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ContentsEntity> page = this.page(
                new Query<ContentsEntity>().getPage(params),
                new QueryWrapper<ContentsEntity>()
        );

        return new PageUtils(page);
    }

}