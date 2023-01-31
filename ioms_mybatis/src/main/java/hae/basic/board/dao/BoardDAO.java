package hae.basic.board.dao;

import java.util.List;
import able.cloud.core.vo.HMap;
import hae.basic.board.model.Board;

/**
 * <pre>
 * 게시판 화면의 조회,입력,수정,삭제를 위한 DAO 인터페이스
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
public interface BoardDAO {

	/**
	 * 게시판 목록을 조회한다.
	 * @param vo 조회할 정보가 담긴 vo
	 * @return 메세지 목록
	 * @exception Exception
	 */
	public List<Board> selectBoardList(Board vo) throws Exception;

	/**
	 * 게시판 상세 목록을 조회한다.
	 * @param seq 게시글 Sequence
	 * @return 게시글 상세 정보
	 * @exception Exception
	 */
	public Board selectBoardById(String id) throws Exception;

	/**
	 * 메세지 입력
	 * @param vo 입력할 정보가 담긴 vo
	 * @return void
	 * @exception Exception
	 */
	public int insertBoard(Board vo) throws Exception;

	/**
	 * 게시글 수정
	 * @param vo 수정할 정보가 담긴 vo
	 * @return 업데이트 수정 건수
	 * @exception Exception
	 */
	public int updateBoard(Board vo) throws Exception;

	/**
	 * 게시글 삭제
	 * @param seq 게시글 Sequence
	 * @return 삭제 건수
	 * @exception Exception
	 */
	public int deleteBoard(String id) throws Exception;

	/**
	 * 게시글 조회수 업데이트
	 * @param seq 게시글 Sequence
	 * @return 업데이트 건수
	 * @exception Exception
	 */
	public int updateBoardViewCount(String id) throws Exception;

}

