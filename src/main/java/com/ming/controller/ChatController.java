package com.ming.controller;

import com.ming.bean.Hr;
import com.ming.bean.MsgContent;
import com.ming.bean.RespBean;
import com.ming.bean.SysMsg;
import com.ming.service.HrService;
import com.ming.service.SysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    HrService hrService;
    @Autowired
    SysMsgService sysMsgService;

    @RequestMapping(value = "/hrs", method = RequestMethod.GET)
    public List<Hr> getAllHr() {
        return hrService.getAllHrExceptAdmin();
    }

    @RequestMapping(value = "/nf", method = RequestMethod.POST)
    public RespBean sendNf(MsgContent msg) {
        if (sysMsgService.sendMsg(msg)) {
            return RespBean.ok("发送成功!");
        }
        return RespBean.error("发送失败!");
    }

    @RequestMapping("/sysmsgs")
    public List<SysMsg> getSysMsg(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return sysMsgService.getSysMsgByPage(page, size);
    }

    @RequestMapping(value = "/markread", method = RequestMethod.PUT)
    public RespBean markRead(Long flag) {
        if (sysMsgService.markRead(flag)) {
            if (flag == -1) {
                return RespBean.ok("multiple");
            } else {
                return RespBean.ok("single");
            }
        } else {
            if (flag == -1) {
                return RespBean.error("multiple");
            } else {
                return RespBean.error("single");
            }
        }
    }
}
