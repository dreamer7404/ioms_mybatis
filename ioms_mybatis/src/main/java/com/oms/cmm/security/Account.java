package com.oms.cmm.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oms.dto.res.UsrMgmtResDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 13.
 * @see
 */


@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Account implements UserDetails{
    
    private UsrMgmtResDTO usrMgmtResDTO;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return usrMgmtResDTO.getGrpCd().equals("001") ? "ROLE_ADMIN" : "ROLE_USER";
            }
        });
        return null;
    }
    
    @Override
    public String getPassword() {
        return this.usrMgmtResDTO.getUserPw();
    }
    
    @Override
    public String getUsername() {
        return this.usrMgmtResDTO.getUserNm();
    }
    
    // 계정 기간만료여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    // 계정 잠겨있는지 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    // 비밀번호 기간만료여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    // 휴먼계정여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
