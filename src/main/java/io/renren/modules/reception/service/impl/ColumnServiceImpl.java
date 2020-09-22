package io.renren.modules.reception.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.reception.dao.WebColumnDao;
import io.renren.modules.reception.service.ColumnService;
import io.renren.modules.sys.entity.ColumnEntity;
import io.renren.modules.sys.entity.ContentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("webcolumnService")
public class ColumnServiceImpl extends ServiceImpl<WebColumnDao, ColumnEntity> implements ColumnService {
@Autowired
private WebColumnDao columnDao;



    @Override
    public List<ColumnEntity> getColumnList() {
        return columnDao.getColumnList();
    }

    @Override
    public List<ContentsEntity> getColumnDataList() {
        return columnDao.getColumnDataList();
    }

}