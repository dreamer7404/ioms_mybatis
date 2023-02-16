package com.oms.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oms.cmm.security.Account;
import com.oms.dao.UsrMgmtDAO;
import com.oms.dto.res.UsrMgmtResDTO;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 13.
 * @see
 */

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UsrMgmtDAO usrMgmtDAO;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        
        UsrMgmtResDTO usrMgmtResDTO = null;
        
        try {
            usrMgmtResDTO = usrMgmtDAO.selectUsrMgmt(id);
            if(usrMgmtResDTO == null) throw new UsernameNotFoundException(String.format("ID : [%s]를 찾을 수 없습니다", id));
        
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return new Account(usrMgmtResDTO);
    }
    

}
