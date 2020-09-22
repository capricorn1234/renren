package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.GoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:54
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
	
}
