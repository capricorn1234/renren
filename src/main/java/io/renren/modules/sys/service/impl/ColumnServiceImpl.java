package io.renren.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ColumnDao;
import io.renren.modules.sys.entity.ColumnEntity;
import io.renren.modules.sys.service.ColumnService;


@Service("columnService")
public class ColumnServiceImpl extends ServiceImpl<ColumnDao, ColumnEntity> implements ColumnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ColumnEntity> page = this.page(
                new Query<ColumnEntity>().getPage(params),
                new QueryWrapper<ColumnEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public void updateStatus(Long id, boolean status) {
        baseMapper.updateStatus(id,status);
    }

}