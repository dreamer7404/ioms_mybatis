package hae.basic.biz.dao;

import java.util.List;

import hae.basic.biz.dto.UsrMgmtResDto;
import hae.basic.biz.model.UsrMgmt;

/**
 * <pre>
 * UsrMgmt DAO 인터페이스
 * </pre>
 *
 * @Class Name  : UsrMgmtDAO.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.19
 * @see 
*/
public interface UsrMgmtDAO {

    /**
     * 
     * 정보를 등록한다
     *
     * @param usrMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void insertUsrMgmt(UsrMgmt usrMgmt) throws Exception;

    /**
     * 
     * 정보를 수정한다
     *
     * @param usrMgmt - 수정할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void updateUsrMgmt(UsrMgmt usrMgmt) throws Exception;
 
    /**
     * 
     * 정보를 삭제한다
     *
     * @param usrMgmt - 삭제할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void deleteUsrMgmt(UsrMgmt usrMgmt) throws Exception;
    


    /**
     * 
     * 정보를 조회한다
     *
     * @param String - 조회할 정보가 담긴 id
     * @return UsrMgmt
     * @throws Exception
     */
    UsrMgmtResDto selectUsrMgmt(String id) throws Exception;

    /**
     * 
     * 목록을 조회한다
     *
     * @param usrMgmt - 조회할 정보가 담긴 VO
     * @return List<HMap>
     * @throws Exception
     */
    List<UsrMgmtResDto> selectUsrMgmtList() throws Exception;
}
