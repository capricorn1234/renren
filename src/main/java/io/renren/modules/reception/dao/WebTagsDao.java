package io.renren.modules.reception.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface WebTagsDao extends BaseMapper<ContentsEntity> {
    //
    List<ContentsEntity> getTagPageList(Long tagid, int pagesize, int pageNo);
    //查询总条数
    Long getTotalCount(Long tagid);
}
