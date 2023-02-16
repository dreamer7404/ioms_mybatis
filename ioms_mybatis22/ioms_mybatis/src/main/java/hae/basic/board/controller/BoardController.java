package hae.basic.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import able.cloud.core.web.HController;
import hae.basic.board.model.Board;
import hae.basic.board.service.BoardService;


/**
 * <pre>
 * 게시판 화면 메인 컨트롤러
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
@Controller
public class BoardController extends HController {


	// CRUD 사용을 위한 Board 서비스
	private final BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

    /**
     *게시판 메인화면 호출
     *
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/board")
	public String selectBoardList(ModelMap model) throws Exception {
		return "board/boardList";
	}

    /**
     *게시판 입력화면 호출
     *
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/board/insertForm")
	public String insertBoardForm(ModelMap model) throws Exception {
		return "board/boardInsertForm";
	}

    /**
     *게시판 수정화면 호출
     *
	 * @param seq path 파라메터
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/board/{id}", method = RequestMethod.POST)
	public String boardUpdateForm(@PathVariable String id, ModelMap model) throws Exception {
		Board result = boardService.selectBoard(id);
		model.addAttribute("result", result);

		return "board/boardUpdateForm";
	}

    /**
     *게시판 상세화면 호출
     *
     * @param seq path 파라메터
	 * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/board/{id}", method = RequestMethod.GET)
	public String boardDetailView(@PathVariable String id, ModelMap model) throws Exception {
		boardService.updateBoardViewCount(id);	// 조회수 업데이트
		Board result = boardService.selectBoard(id);
		model.addAttribute("result", result);

		return "board/boardDetailView";
	}
}
