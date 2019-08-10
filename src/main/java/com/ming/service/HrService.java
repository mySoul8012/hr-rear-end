package com.ming.service;

import com.ming.bean.Hr;
import com.ming.common.HrUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface HrService extends UserDetailsService {
    public int hrReg(String username, String password);

    public List<Hr> getHrsByKeywords(String keywords);


    public int updateHr(Hr hr);

    public int updateHrRoles(Long hrId, Long[] rids);

    public Hr getHrById(Long hrId);

    public int deleteHr(Long hrId);

    public List<Hr> getAllHrExceptAdmin();
    public List<Hr> getAllHr();
}
