package com.oms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import able.cloud.core.web.HController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oms.cmm.global.Consts;
import com.oms.cmm.utils.Utils;
import com.oms.dto.req.UsrMgmtReqDTO;
import com.oms.dto.res.UsrMgmtResDTO;
import com.oms.service.UsrMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "UsrMgmtController", description = "")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UsrMgmtController extends HController {

    private final HttpServletRequest request;
    
	private final UsrMgmtService usrMgmtService;
   
	
	/**
     * 사용자 정보 등록, 수정, 삭제
     */
	@Operation(summary = "사용자 정보 등록,수정,삭제", description = "")
	@PostMapping(value = "/usrmgmt")
    public Integer insertUsrMgmt(@ModelAttribute UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
	    
        String method = Utils.getMethod(request); 
	    if(method.equals(Consts.INSERT)) { // dto
	        
	    }else if(method.equals(Consts.UPDATE)) { // ids, dto
            
        }else if(method.equals(Consts.DELETE)) { // id
            
        }
	    return 0;
    }

	@Operation(summary = "사용자 정보 조회")
	@GetMapping(value = "/usrmgmt/{id}")
	public UsrMgmtResDTO usrmgmt(@PathVariable("id") String id) throws Exception {
	    return usrMgmtService.selectUsrMgmt(id);  
	}

	@Operation(summary = "사용자 목록을 조회")
	@GetMapping("/usrmgmts")
	public List<UsrMgmtResDTO> selectUsrMgmtList(@ModelAttribute UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
	    List<UsrMgmtResDTO> list = usrMgmtService.selectUsrMgmtList(usrMgmtReqDTO);
	    return list;
	}
	
	
}