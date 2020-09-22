package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ClassifyEntity;
import io.renren.modules.sys.entity.FrontMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
public interface ClassifyService extends IService<ClassifyEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

