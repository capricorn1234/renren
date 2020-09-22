package io.renren.modules.reception.service;



import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.sys.entity.FrontMenuEntity;

import java.util.List;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
public interface FrontMenuService extends IService<FrontMenuEntity> {


    //
    List<FrontMenuEntity> getMenuList();
}

