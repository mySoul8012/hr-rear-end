package com.ming.service;

import com.ming.bean.Menu;
import com.ming.common.HrUtils;
import com.ming.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        List<Menu> listMenu =  menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
        return listMenu;
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }

}
