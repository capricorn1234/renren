package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.FrontMenuDao;
import io.renren.modules.sys.entity.FrontMenuEntity;
import io.renren.modules.sys.service.FrontMenuService;


@Service("frontMenuService")
public class FrontMenuServiceImpl extends ServiceImpl<FrontMenuDao, FrontMenuEntity> implements FrontMenuService {

    @Override
    public List<FrontMenuEntity> getUserMenuList(Long userId) {
        return null;
    }
    @Override
    public List<FrontMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<FrontMenuEntity> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<FrontMenuEntity> userMenuList = new ArrayList<>();
        for(FrontMenuEntity menu : menuList){
            if(menuIdList.contains(menu.getId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<FrontMenuEntity> queryListParentId(Long parentId) {
        return baseMapper.queryListParentId(parentId);
    }
    /**
     * 获取所有菜单列表
     */
    private List<FrontMenuEntity> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<FrontMenuEntity> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<FrontMenuEntity> getMenuTreeList(List<FrontMenuEntity> menuList, List<Long> menuIdList){
        List<FrontMenuEntity> subMenuList = new ArrayList<FrontMenuEntity>();

        for(FrontMenuEntity entity : menuList){
            //目录
            entity.setList(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
            subMenuList.add(entity);
        }

        return subMenuList;
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FrontMenuEntity> page = this.page(
                new Query<FrontMenuEntity>().getPage(params),
                new QueryWrapper<FrontMenuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void delete(Long menuId) {
        //删除菜单
        this.removeById(menuId);
        //删除与菜单相关的子目录
        List<Long> menuIdList=new ArrayList<>();
        queryListParentId(menuId, menuIdList);
        if(menuIdList==null)return;
        for(Long id:menuIdList){
            this.delete(id);
        }

    }

    @Override
    public List<FrontMenuEntity> listOfSort(Long id) {
        List<FrontMenuEntity> front=baseMapper.listOfSort(id);
        return front;
    }

}