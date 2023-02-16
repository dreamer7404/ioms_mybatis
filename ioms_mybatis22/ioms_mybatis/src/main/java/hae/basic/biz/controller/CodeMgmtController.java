package hae.basic.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import able.cloud.core.web.HController;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hae.basic.biz.model.CodeMgmt;
import hae.basic.biz.service.CodeMgmtService;
import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * CodeMgmt Controller
 * </pre>
 * 
 * @ClassName   : CodeMgmtController.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.19
 * @see
 */

@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class CodeMgmtController extends HController {

    /**
     * CodeMgmtService 선언 (CodeMgmtService) Class Injection)
     */
	private final CodeMgmtService codeMgmtService;

    /**
     * 정보 등록 화면
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/codeMgmt/insertItemForm", method = RequestMethod.GET)
	public String insertItemForm(@ModelAttribute CodeMgmt codeMgmt, Model model) throws Exception {
		return "codeMgmt/codeMgmtInsertForm";
	}

    /**
     * 정보 등록
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/codeMgmt/insertItem", method = RequestMethod.POST)
	public String insertItem(@ModelAttribute @Valid CodeMgmt codeMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		//form 유효성 검사
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				logger.debug("ObjectError : " + e);
			}
			return "codeMgmt/codeMgmtInsertForm";
		}
		codeMgmtService.insertCodeMgmt(codeMgmt);
		return "forward:/codeMgmt/selectItemList";
	}

 /**
     * 정보 수정 화면
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/codeMgmt/updateItemForm", method = RequestMethod.GET)
	public String updateItemForm(@ModelAttribute CodeMgmt codeMgmt, Model model) throws Exception {
		String id = ""; //codeMgmt의 getID 메서드
		model.addAttribute("codeMgmt", selectItem(id));
		return "codeMgmt/codeMgmtModifyForm";
	}

    /**
     * 정보 수정
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/codeMgmt/updateItem", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute @Valid CodeMgmt codeMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		
		//form 유효성 검사
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				logger.debug("ObjectError : " + e);
			}
			return "codeMgmt/codeMgmtModifyForm";
		}
		
		codeMgmtService.updateCodeMgmt(codeMgmt);
		String id = ""; //codeMgmt의 getID 메서드
		model.addAttribute("codeMgmt", selectItem(id));
		return "codeMgmt/codeMgmtDetailView";
	}

    /**
     * 정보 삭제
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    @RequestMapping(path="/codeMgmt/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@ModelAttribute CodeMgmt codeMgmt) throws Exception {
		codeMgmtService.deleteCodeMgmt(codeMgmt);
		return "forward:/codeMgmt/selectItemList";
	}

    /**
     * 정보를 가져오기
     *
     * @param id - 저장 할 정보가 담긴 id
     * @return
     * @throws Exception
     */
	public CodeMgmt selectItem(String id) throws Exception {
		return codeMgmtService.selectCodeMgmt(id); 
	}

	/**
	 * 정보 조회 화면
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/codeMgmt/selectItemById")
	public String selectItemById(@ModelAttribute CodeMgmt codeMgmt, @RequestParam("selectedId") String id, Model model) throws Exception {
		model.addAttribute("codeMgmt", selectItem(id));
		return "codeMgmt/codeMgmtDetailView";
	}

	/**
	 * 목록을 조회한다.
     * @param codeMgmt - 저장 할 정보가 담긴 VO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/codeMgmt/selectItemList")
	public String selectItemList(@ModelAttribute("codeMgmt") CodeMgmt codeMgmt, Model model) throws Exception {
		List<CodeMgmt> codeMgmtList = codeMgmtService.selectCodeMgmtList(codeMgmt);
		model.addAttribute("resultList", codeMgmtList);
		return "codeMgmt/codeMgmtList";
	}
}