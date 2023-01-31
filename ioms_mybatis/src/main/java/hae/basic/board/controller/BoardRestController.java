package hae.basic.board.controller;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import able.cloud.core.message.MessageUtils;
import able.cloud.core.web.HController;
import hae.basic.board.model.Board;
import hae.basic.board.service.BoardService;
import hae.basic.cmm.exception.RestException;

/**
 * <pre>
 * 게시판 화면의 Rest 통신을 위한 컨트롤러
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
@RestController
public class BoardRestController extends HController {

	// CRUD 사용을 위한 Board 서비스
	private final BoardService boardService;
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

    /**
     * 게시판 리스트 불러오기
     *
	 * @param boardVO 검색할 보가 담긴 VO
	 * @param model
     * @return 게시글 리스트
     * @throws Exception
     */
	@RequestMapping(value="/rest/boards", method = RequestMethod.GET)
	public List<Board> selectBoardList(@ModelAttribute Board boardVO, Model model) throws Exception{
		List<Board> resultList = boardService.selectBoardList(boardVO);
		return resultList;
	}

    /**
     * 게시판 글 수정
     *
	 * @param boardVO 수정할 정보가 담긴 VO
	 * @param result 데이터 유효성 검사
     * @return 게시글 수정 처리 결과
     * @throws Exception
     */
	@RequestMapping(value="/rest/board/{id}", method = RequestMethod.PUT)
	public HashMap<String, String> updateBoard(@ModelAttribute @Valid Board boardVO, BindingResult result, Model model) throws Exception{

		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (result.hasErrors()) {
			String msg = "";
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				msg += MessageUtils.getMessage(fieldError.getCode(), fieldError.getArguments(), fieldError.getDefaultMessage()) + "\n";
			}
			throw new RestException(msg);
		} else {
			boardService.updateBoard(boardVO);
			resultMap.put("message", MessageUtils.getMessage("info.success.update"));
		}

		return resultMap;
	}

    /**
     * 게시판 글 삭제
     *
	 * @param seq path 파라메터
	 * @param model
     * @return 게시글 삭제 처리 결과
     * @throws Exception
     */
	@RequestMapping(value="/rest/board/{id}", method = RequestMethod.DELETE)
	public HashMap<String, String> deleteBoard(@PathVariable String id, Model model) throws Exception{

		HashMap<String, String> resultMap = new HashMap<String, String>();

		int result = boardService.deleteBoard(id);
		if(result>0)
			resultMap.put("message", MessageUtils.getMessage("info.success.delete"));
		else {
			resultMap.put("result", "F");
			resultMap.put("message", MessageUtils.getMessage("fail.common.msg"));
		}

		return resultMap;
	}

	/**
     * 게시판 글 입력
     *
	 * @param boardVO 입력할 정보가 담긴 VO
	 * @param result 데이터 유효성 검사
	 * @param model
     * @return 게시글 입력 처리 결과
     * @throws Exception
     */
	@RequestMapping(value="/rest/board", method = RequestMethod.POST)
	public HashMap<String, String> insertBoard(@ModelAttribute @Valid Board boardVO, BindingResult result, Model model) throws Exception{

		HashMap<String, String> resultMap = new HashMap<String, String>();
		if (result.hasErrors()) {
			String msg = "";
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				msg += MessageUtils.getMessage(fieldError.getCode(), fieldError.getArguments(), fieldError.getDefaultMessage()) + "\n";
			}
			throw new RestException(msg);
		} else {
			boardService.insertBoard(boardVO);
			resultMap.put("message", MessageUtils.getMessage("info.success.insert"));
		}
		return resultMap;
	}

}
