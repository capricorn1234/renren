package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.FrontMenuEntity;
import io.renren.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-09-14 11:10:55
 */
public interface FrontMenuService extends IService<FrontMenuEntity> {

    List<FrontMenuEntity> getUserMenuList(Long userId);

    List<FrontMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    List<FrontMenuEntity> queryListParentId(Long parentId);

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 删除
     */
    void delete(Long menuId);

    List<FrontMenuEntity> listOfSort(Long id);
}

