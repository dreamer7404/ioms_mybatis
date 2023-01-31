package hae.basic.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import able.cloud.core.service.HService;
import able.cloud.core.vo.HMap;
import hae.basic.board.dao.BoardDAO;
import hae.basic.board.model.Board;
import hae.basic.board.service.BoardService;

/**
 * <pre>
 * 게시판 화면의 조회,입력,수정,삭제를 위한 서비스 Implement 구현
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
@Service
public class BoardServiceImpl extends HService implements BoardService{

	private BoardDAO boardDAO;
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

    /**
     * 게시판 리스트 불러오기
     *
	 * @param vo 정보 조회를 위한 VO
     * @return 게시글 목록
     * @throws Exception
     */
	@Override
	public List<Board> selectBoardList(Board vo) throws Exception {
		return boardDAO.selectBoardList(vo);
	}

    /**
     * 게시판 입력
     *
	 * @param vo 입력 정보 VO
     * @return 게시글 입력 건수
     * @throws Exception
     */
	@Override
	public int insertBoard(Board vo) throws Exception {
		return boardDAO.insertBoard(vo);

	}

    /**
     * 게시판 조회수 업데이트
     *
	 * @param seq 게시글 Sequence
     * @return 게시글 조회수 수정 건수
     * @throws Exception
     */
	@Override
	public int updateBoardViewCount(String id) throws Exception {
		return boardDAO.updateBoardViewCount(id);

	}

    /**
     * 게시글 수정
     *
	 * @param vo 수정 정보 VO
     * @return 게시글 수정 건수
     * @throws Exception
     */
	@Override
	public int updateBoard(Board vo) throws Exception {
		 return boardDAO.updateBoard(vo);
	}

    /**
     * 게시글 삭제
     *
	 * @param seq 게시글 Sequence
     * @return 게시글 삭제 건수
     * @throws Exception
     */
	@Override
	public int deleteBoard(String id) throws Exception {
		int result = boardDAO.deleteBoard(id);
		return result;
	}

    /**
     * 게시글 상세정보 불러오기
     *
	 * @param seq 게시글 Sequence
     * @return 게시글 상세 정보
     * @throws Exception
     */
	@Override
	public Board selectBoard(String id) throws Exception {
		return boardDAO.selectBoardById(id);
	}



}
