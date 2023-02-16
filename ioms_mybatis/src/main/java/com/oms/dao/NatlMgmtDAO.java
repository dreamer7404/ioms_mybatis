package com.oms.dao;

import java.util.List;

import able.cloud.core.vo.HMap;
import com.oms.model.NatlMgmt;

/**
 * <pre>
 * NatlMgmt DAO 인터페이스
 * </pre>
 *
 * @Class Name  : NatlMgmtDAO.java
 * @Description : 
 * @author 안경수 
 * @since 2023.1.6
 * @see 
*/
public interface NatlMgmtDAO {

    /**
     * 
     * 정보를 등록한다
     *
     * @param natlMgmt - 저장 할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
//    void insertNatlMgmt(NatlMgmt natlMgmt) throws Exception;

    /**
     * 
     * 정보를 수정한다
     *
     * @param natlMgmt - 수정할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
//    void updateNatlMgmt(NatlMgmt natlMgmt) throws Exception;
 
    /**
     * 
     * 정보를 삭제한다
     *
     * @param natlMgmt - 삭제할 정보가 담긴 VO
     * @return
     * @throws Exception
     */
//    void deleteNatlMgmt(NatlMgmt natlMgmt) throws Exception;
    


    /**
     * 
     * 정보를 조회한다
     *
     * @param String - 조회할 정보가 담긴 id
     * @return NatlMgmt
     * @throws Exception
     */
//    NatlMgmt selectNatlMgmt(NatlMgmt natlMgmt) throws Exception;

    /**
     * 
     * 목록을 조회한다
     *
     * @param natlMgmt - 조회할 정보가 담긴 VO
     * @return List<HMap>
     * @throws Exception
     */
//    List<NatlMgmt> selectNatlMgmtList(NatlMgmt natlMgmt) throws Exception;
    List<NatlMgmt> selectNatlMgmtList() throws Exception;
}
