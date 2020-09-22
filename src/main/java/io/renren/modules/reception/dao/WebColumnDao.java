package io.renren.modules.reception.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.ColumnEntity;
import io.renren.modules.sys.entity.ContentsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Mapper
public interface WebColumnDao extends BaseMapper<ColumnEntity> {
    //
    List<ColumnEntity> getColumnList();
    //
    List<ContentsEntity> getColumnDataList();
}
