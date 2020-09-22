package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ClassifyDao;
import io.renren.modules.sys.entity.ClassifyEntity;
import io.renren.modules.sys.service.ClassifyService;


@Service("classifyService")
public class ClassifyServiceImpl extends ServiceImpl<ClassifyDao, ClassifyEntity> implements ClassifyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ClassifyEntity> page = this.page(
                new Query<ClassifyEntity>().getPage(params),
                new QueryWrapper<ClassifyEntity>()
        );

        return new PageUtils(page);
    }



}