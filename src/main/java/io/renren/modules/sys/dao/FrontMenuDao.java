package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.FrontMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
@Mapper
public interface FrontMenuDao extends BaseMapper<FrontMenuEntity> {
    /**
     * 获取全部目录列表
     * @return
     */
    List<FrontMenuEntity> queryNotList();

    List<FrontMenuEntity> queryListParentId(Long parentId);

    List<FrontMenuEntity> listOfSort(@Param("id") Long id);
}
