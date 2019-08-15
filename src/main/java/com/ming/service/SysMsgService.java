package com.ming.service;

import com.ming.bean.Hr;
import com.ming.bean.MsgContent;
import com.ming.bean.SysMsg;
import com.ming.common.HrUtils;
import com.ming.mapper.SysMsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysMsgService {
    @Autowired
    SysMsgMapper sysMsgMapper;
    @Autowired
    HrService hrService;

    // 系统消息权限  管理员可以发送
    @PreAuthorize("hasRole('ROLE_admin')")
    public boolean sendMsg(MsgContent msg) {
        int result = sysMsgMapper.sendMsg(msg);
        List<Hr> allHr = hrService.getAllHr();
        int result2 = sysMsgMapper.addMsg2AllHr(allHr, msg.getId());
        return result2==allHr.size();
    }

    public List<SysMsg> getSysMsgByPage(Integer page, Integer size) {
        int start = (page - 1) * size;
        return sysMsgMapper.getSysMsg(start,size, HrUtils.getCurrentHr().getId());
    }

    public boolean markRead(Long flag) {
        if (flag != -1) {
            return sysMsgMapper.markRead(flag,HrUtils.getCurrentHr().getId())==1;
        }
        sysMsgMapper.markRead(flag, HrUtils.getCurrentHr().getId());
        return true;
    }
}