package hae.basic.board.service;

import java.util.List;

import able.cloud.core.vo.HMap;
import hae.basic.board.model.Board;

/**
 * <pre>
 * 게시판 화면의 조회,입력,수정,삭제를 위한 서비스 인터페이스 클래스
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
public interface BoardService {

	/**
	 * 게시글 입력
	 * @param vo 입력 정보
	 * @return 입력 건수
	 * @exception Exception
	 */
	int insertBoard(Board vo) throws Exception;

	/**
	 * 게시글 수정
	 * @param vo 수정 정보
	 * @return 업데이트 수정 건수
	 * @exception Exception
	 */
	int updateBoard(Board vo) throws Exception;

	/**
	 * 게시글 삭제
	 * @param seq 게시글 Sequence
	 * @return 삭제 건수
	 * @exception Exception
	 */
	int deleteBoard(String id) throws Exception;

	/**
	 * 게시글 조회수 업데이트
	 * @param seq 게시글 Sequence
	 * @return 업데이트 건수
	 * @exception Exception
	 */
	int updateBoardViewCount(String id) throws Exception;

	/**
	 * 게시글 상세 정보를 조회한다.
	 * @param seq 게시글 Sequence
	 * @return 게시글 상세 정보
	 * @exception Exception
	 */
	Board selectBoard(String id) throws Exception;

	/**
	 * 게시글 목록을 조회한다.
	 * @param vo 조회할 정보 VO
	 * @return 게시글 목록
	 * @exception Exception
	 */
	List<Board> selectBoardList(Board vo) throws Exception;

}
