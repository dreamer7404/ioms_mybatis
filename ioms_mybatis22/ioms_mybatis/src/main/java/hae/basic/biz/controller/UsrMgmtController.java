package hae.basic.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import able.cloud.core.web.HController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hae.basic.biz.dto.CommReqDTO;
import hae.basic.biz.dto.UsrMgmtReqDTO;
import hae.basic.biz.dto.UsrMgmtResDTO;
import hae.basic.biz.service.UsrMgmtService;
import hae.basic.biz.utils.WebUtils;
import hae.basic.cmm.consts.Consts;
import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * UsrMgmt Controller
 * </pre>
 * 
 * @ClassName   : UsrMgmtController.java
 * @Description : 클래스 설명을 기술합니다.
 * @author 안경수
 * @since 2023.1.19
 * @see
 */
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class UsrMgmtController extends HController {

    private final HttpServletRequest request;
    private final WebUtils webUtils;
    
	private final UsrMgmtService usrMgmtService;
   
	
	/**
     * 사용자 정보 등록, 수정, 삭제
     */
	@PostMapping(value = "/usrmgmt")
    public Integer insertUsrMgmt(@ModelAttribute UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
	    
        String method = webUtils.getMethod(request);
	    if(method.equals(Consts.INSERT)) { // dto
	        
	    }else if(method.equals(Consts.UPDATE)) { // ids, dto
            
        }else if(method.equals(Consts.DELETE)) { // id
            
        }
	    return 0;
    }

	/**
	 * 사용자 정보 조회 
	 */
	@GetMapping(value = "/usrmgmt/{id}")
	public UsrMgmtResDTO usrmgmt(@PathVariable("id") String id) throws Exception {
	    return usrMgmtService.selectUsrMgmt(id);
	}

	/**
	 * 사용자 목록을 조회한다. (뒤에 -s붙힘)
	 */
	@GetMapping(value = "/usrmgmts")
	public List<UsrMgmtResDTO> selectUsrMgmtList(@ModelAttribute UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
	    return usrMgmtService.selectUsrMgmtList(usrMgmtReqDTO);
	}
	
	
}