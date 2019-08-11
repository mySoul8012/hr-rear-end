package com.ming.mapper;

import com.ming.bean.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);

}
