package com.oms.controller;

import javax.servlet.http.HttpServletRequest;

import able.cloud.core.vo.HMap;
import able.cloud.core.web.HController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.cmm.utils.AES128;
import com.oms.dao.UsrLogin;
import com.oms.dto.req.UsrMgmtReqDTO;
import com.oms.dto.res.UsrMgmtResDTO;
import com.oms.service.UsrMgmtService;
import com.oms.service.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 1. 19.
 * @see
 */

@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthController extends HController {
    
    private final CustomUserDetailsService userDetailsService;
    
    private final UsrMgmtService usrMgmtService;
    
    /*
     * 사용자 로그인
     */
    @GetMapping(value = "/auth/login")
    public HMap login(UsrLogin usrLogin) throws Exception {
        
        HMap resultMap = new HMap();
        
        // 파라미터 null체크
//        if(Utils.isNull(usrLogin.getUserId()) || Utils.isNull(usrLogin.getUserPw())) {
//            return null;
//        }
//        
//        // 파라미터 vaidation 체크
//        
//            
//        // 사용자정보 가져오기
//        UsrMgmt usrMgmt = usrMgmtService.selectUsrMgmt(usrLogin.getUserId());
//        
//        // 사용자정보 유무 체크 
//        if(usrMgmt == null || 
//                Utils.isNull(usrMgmt.getUserNm()) ||
//                Utils.isNull(usrMgmt.getBlnsCoCd()) ||
//                Utils.isNull(usrMgmt.getGrpCd())) {
//            return null;
//        }
//        
//        
//        
//        // 패스워드 체크
//        String usrPw = Sha256.encrypt(usrLogin.getUserPw());
//        if(!usrMgmt.getUserPw().equals(usrPw)){
//            return null;
//        }
//        
//        // 사용여부
//        if(!usrMgmt.getUseYn().equals("Y")) {
//            return null;
//        }
        
        // 비밀번호잠김일시 체크
//            if(usrMgmt.getPwLockDtm()) {
//                return null;
//            }
        
//        resultMap.put("usrEeno", usrMgmt.getUserEeno()); // 사용자번호
//        resultMap.put("usrNm", usrMgmt.getUserNm()); // 사용자이름
//        resultMap.put("blnsCoCd", usrMgmt.getBlnsCoCd()); // 소속회사
//        resultMap.put("grpCd", usrMgmt.getGrpCd()); // 그룹코드 
        resultMap.put("accessToken", "accessToken"); // accessToken
        resultMap.put("refreshToken", "refreshToken"); // refreshToken
      
        return resultMap;
    }
    
    
    /*
     * @AuthenticationPrincipal
     *  - 로그인 세션 정보를 애노테이션으로 간편하게 받을 수 있다
     *  - UserDetailsService에서 Return한 객체를 파라미터로 직접 받아 사용할 수 있다.
     *  - name 뿐만 아니라 다양한 정보를 받을 수 있다
     */
    @PostMapping("/auth/login")
    public Long login(@RequestBody UsrMgmtReqDTO usrMgmtReqDTO,HttpServletRequest request) throws Exception {
        
        // db
        UsrMgmtResDTO usrMgmtResDTO = usrMgmtService.selectUsrMgmt(usrMgmtReqDTO.getUserEeno());
        if(usrMgmtResDTO == null) {
            return -1L;
        }
        
        // password
        if(!usrMgmtResDTO.getUserPw().equals(AES128.SHA256(usrMgmtReqDTO.getUserPw()))) {
            return -1L;
        }
        
        // useYn
        if(!usrMgmtResDTO.getUseYn().equals("Y")) {
            return -1L;
        }
        
        return 1L;
    }
    
    @PostMapping("/auth/test2")
    public Long test2(HttpServletRequest request) {
        return 2L;
    }

}
