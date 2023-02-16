package com.oms.service.security;

import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oms.cmm.security.Account;
import com.oms.cmm.security.JwtTokenProvider;
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

//@Transactional
//@Service
@RequiredArgsConstructor
public class AccountService {

    private final UsrMgmtDAO usrMgmtDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    
    public String loginWithEmailAndPassword(String id, String password) throws Exception {
        UsrMgmtResDTO usrMgmtResDTO = usrMgmtDAO.selectUsrMgmt(id);
        if(usrMgmtResDTO == null) {
            throw new AccountNotFoundException(String.format("ID[%s]를 찾을 수 없습니다", id));
        }
        if(!passwordEncoder.matches(password, usrMgmtResDTO.getUserPw())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        getAuthentication(id, password);
        return getJwtToken(new Account(usrMgmtResDTO));
    }
    
    private void getAuthentication(String id, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password);
        authenticationManager.authenticate(authenticationToken);
    }
    
    private String getJwtToken(Account account) {
        return jwtTokenProvider.createToken(account.getUsername(), account.getAuthorities()
                .stream().map(Object::toString).collect(Collectors.toList()));
    }
    
}
