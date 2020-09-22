package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.ColumnEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Mapper
public interface ColumnDao extends BaseMapper<ColumnEntity> {

    void updateStatus(@Param("id") Long id,@Param("status")boolean status);
}
