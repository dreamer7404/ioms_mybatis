package com.oms.dao;

import java.util.List;

import able.cloud.core.vo.HMap;
import com.oms.model.CodeMgmt;

/**
 * <pre>
 * CodeMgmt DAO 인터페이스
 * </pre>
 *
 * @Class Name  : CodeMgmtDAO.java
 * @Description : 클래스 설명을 기술합니다.
 * @author 안경수 
 * @since 2023.1.19
 * @see 
*/
public interface CodeMgmtDAO {

    /**
     * 
     * 정보를 등록한다
     *
     * @param codeMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void insertCodeMgmt(CodeMgmt codeMgmt) throws Exception;

    /**
     * 
     * 정보를 수정한다
     *
     * @param codeMgmt - 수정할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void updateCodeMgmt(CodeMgmt codeMgmt) throws Exception;
 
    /**
     * 
     * 정보를 삭제한다
     *
     * @param codeMgmt - 삭제할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
    void deleteCodeMgmt(CodeMgmt codeMgmt) throws Exception;
    


    /**
     * 
     * 정보를 조회한다
     *
     * @param String - 조회할 정보가 담긴 id
     * @return CodeMgmt
     * @throws Exception
     */
    CodeMgmt selectCodeMgmt(String id) throws Exception;

    /**
     * 
     * 목록을 조회한다
     *
     * @param codeMgmt - 조회할 정보가 담긴 VO
     * @return List<HMap>
     * @throws Exception
     */
    List<CodeMgmt> selectCodeMgmtList(CodeMgmt codeMgmt) throws Exception;
}
