package hae.basic.biz.controller;

import able.cloud.core.vo.HMap;
import able.cloud.core.web.HController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hae.basic.biz.dao.UsrLogin;
import hae.basic.biz.model.UsrMgmt;
import hae.basic.biz.service.UsrMgmtService;
import hae.basic.cmm.security.util.Sha256;
import hae.basic.cmm.security.util.Utils;
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
public class AuthController extends HController {
    
//    private final UsrMgmtService usrMgmtService;
    
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

}
