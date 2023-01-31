package hae.basic.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import able.cloud.core.web.HController;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hae.basic.biz.dto.UsrMgmtResDto;
import hae.basic.biz.model.UsrMgmt;
import hae.basic.biz.service.UsrMgmtService;
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

    /**
     * UsrMgmtService 선언 (UsrMgmtService) Class Injection)
     */
	private final UsrMgmtService usrMgmtService;

    /**
     * 정보 등록 화면
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/usrMgmt/insertItemForm", method = RequestMethod.GET)
	public String insertItemForm(@ModelAttribute UsrMgmt usrMgmt, Model model) throws Exception {
		return "usrMgmt/usrMgmtInsertForm";
	}

    /**
     * 정보 등록
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/usrMgmt/insertItem", method = RequestMethod.POST)
	public String insertItem(@ModelAttribute @Valid UsrMgmt usrMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		//form 유효성 검사
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				logger.debug("ObjectError : " + e);
			}
			return "usrMgmt/usrMgmtInsertForm";
		}
		usrMgmtService.insertUsrMgmt(usrMgmt);
		return "forward:/usrMgmt/selectItemList";
	}

 /**
     * 정보 수정 화면
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/usrMgmt/updateItemForm", method = RequestMethod.GET)
	public String updateItemForm(@ModelAttribute UsrMgmt usrMgmt, Model model) throws Exception {
		String id = ""; //usrMgmt의 getID 메서드
		model.addAttribute("usrMgmt", selectItem(id));
		return "usrMgmt/usrMgmtModifyForm";
	}

    /**
     * 정보 수정
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/usrMgmt/updateItem", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute @Valid UsrMgmt usrMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		
		//form 유효성 검사
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				logger.debug("ObjectError : " + e);
			}
			return "usrMgmt/usrMgmtModifyForm";
		}
		
		usrMgmtService.updateUsrMgmt(usrMgmt);
		String id = ""; //usrMgmt의 getID 메서드
		model.addAttribute("usrMgmt", selectItem(id));
		return "usrMgmt/usrMgmtDetailView";
	}

    /**
     * 정보 삭제
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    @RequestMapping(path="/usrMgmt/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@ModelAttribute UsrMgmt usrMgmt) throws Exception {
		usrMgmtService.deleteUsrMgmt(usrMgmt);
		return "forward:/usrMgmt/selectItemList";
	}

    /**
     * 정보를 가져오기
     *
     * @param id - 저장 할 정보가 담긴 id
     * @return
     * @throws Exception
     */
	public UsrMgmtResDto selectItem(String id) throws Exception {
		return usrMgmtService.selectUsrMgmt(id); 
	}

	/**
	 * 정보 조회 화면
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usrMgmt/selectItemById")
	public String selectItemById(@ModelAttribute UsrMgmt usrMgmt, @RequestParam("selectedId") String id, Model model) throws Exception {
		model.addAttribute("usrMgmt", selectItem(id));
		return "usrMgmt/usrMgmtDetailView";
	}

	/**
	 * 목록을 조회한다.
     * @param usrMgmt - 저장 할 정보가 담긴 VO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/usrMgmt/selectItemList")
	public List<UsrMgmtResDto> selectItemList() throws Exception {
	    return usrMgmtService.selectUsrMgmtList();
	}
}