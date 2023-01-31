package hae.basic.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import able.cloud.core.web.HController;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hae.basic.biz.model.NatlMgmt;
import hae.basic.biz.service.NatlMgmtService;
import hae.basic.cmm.security.util.Sha256;
import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * NatlMgmt Controller
 * </pre>
 * 
 * @ClassName   : NatlMgmtController.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.6
 * @see
 */
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class NatlMgmtRestController extends HController {

    /**
     * NatlMgmtService 선언 (NatlMgmtService) Class Injection)
     */
	private final NatlMgmtService natlMgmtService;

    /**
     * 정보 등록 화면
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/natlMgmt/insertItemForm", method = RequestMethod.POST)
	public String insertItemForm(@ModelAttribute NatlMgmt natlMgmt, Model model) throws Exception {
//		return "natlMgmt/natlMgmtInsertForm";
	    return null;
	}

    /**
     * 정보 등록
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/natlMgmt/insertItem", method = RequestMethod.POST)
	public String insertItem(@ModelAttribute @Valid NatlMgmt natlMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		//form 유효성 검사
//		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError e : list) {
//				logger.debug("ObjectError : " + e);
//			}
//			return "natlMgmt/natlMgmtInsertForm";
//		}
//		natlMgmtService.insertNatlMgmt(natlMgmt);
//		return "forward:/natlMgmt/selectItemList";
	    return null;
	}

 /**
     * 정보 수정 화면
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/natlMgmt/updateItemForm", method = RequestMethod.GET)
	public String updateItemForm(@ModelAttribute NatlMgmt natlMgmt, Model model) throws Exception {
//		String id = ""; //natlMgmt의 getID 메서드
//		model.addAttribute("natlMgmt", selectItem(natlMgmt));
//		return "natlMgmt/natlMgmtModifyForm";
	    return null;
	}

    /**
     * 정보 수정
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param result
	 * @param model
	 * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/natlMgmt/updateItem", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute @Valid NatlMgmt natlMgmt, BindingResult result, Model model,
			HttpServletRequest request) throws Exception {
		
		//form 유효성 검사
//		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError e : list) {
//				logger.debug("ObjectError : " + e);
//			}
//			return "natlMgmt/natlMgmtModifyForm";
//		}
//		
//		natlMgmtService.updateNatlMgmt(natlMgmt);
//		String id = ""; //natlMgmt의 getID 메서드
//		model.addAttribute("natlMgmt", selectItem(natlMgmt));
//		return "natlMgmt/natlMgmtDetailView";
	    
	    return null;
	}

    /**
     * 정보 삭제
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    @RequestMapping(path="/natlMgmt/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@ModelAttribute NatlMgmt natlMgmt) throws Exception {
//		natlMgmtService.deleteNatlMgmt(natlMgmt);
//		return "forward:/natlMgmt/selectItemList";
        return null;
	}

    /**
     * 정보를 가져오기
     *
     * @param id - 저장 할 정보가 담긴 id
     * @return
     * @throws Exception
     */
	public NatlMgmt selectItem(@ModelAttribute NatlMgmt natlMgmt) throws Exception {
//		return natlMgmtService.selectNatlMgmt(natlMgmt); 
	    return null;
	}

	/**
	 * 정보 조회 화면
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/natlMgmt/selectItemById")
	public String selectItemById(@ModelAttribute NatlMgmt natlMgmt, @RequestParam("selectedId") String id, Model model) throws Exception {
//		model.addAttribute("natlMgmt", selectItem(natlMgmt));
//		return "natlMgmt/natlMgmtDetailView";
	    return null;
	}

	/**
	 * 목록을 조회한다.
     * @param natlMgmt - 저장 할 정보가 담긴 VO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/natlMgmt/selectItemList")
	public List<NatlMgmt> selectItemList(@ModelAttribute("natlMgmt") NatlMgmt natlMgmt) throws Exception {
		
	    
	    String pass = Sha256.encrypt("Dreamer915!");
	    
	    return natlMgmtService.selectNatlMgmtList();
	}
}