package com.ming.service.impl;

import com.ming.bean.Menu;
import com.ming.common.HrUtils;
import com.ming.mapper.MenuMapper;
import com.ming.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }

}
