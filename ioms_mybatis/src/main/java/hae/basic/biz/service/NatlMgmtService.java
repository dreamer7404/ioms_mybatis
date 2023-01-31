package hae.basic.biz.service;

import hae.basic.biz.service.NatlMgmtService;
import lombok.RequiredArgsConstructor;
import hae.basic.biz.dao.NatlMgmtDAO;
import hae.basic.biz.model.NatlMgmt;

import java.util.List;

import org.springframework.stereotype.Service;

import able.cloud.core.service.HService;
import able.cloud.core.vo.HMap;


/**
 * <pre>
 * NatlMgmtService 구현
 * </pre>
 * 
 * @ClassName   : NatlMgmtServiceImpl.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.6
 * @see
 */
@RequiredArgsConstructor
@Service("natlMgmtService")
public class NatlMgmtService { // extends HService implements NatlMgmtService {

    /**
     * NatlMgmtDAO class 선언 (NatlMgmtDAO) Class Injection)
     */
	private final NatlMgmtDAO natlMgmtDAO;
//	public NatlMgmtServiceImpl(NatlMgmtDAO natlMgmtDAO) {
//		this.natlMgmtDAO = natlMgmtDAO;
//	}

    /*
     * @see hae.basic.biz.service.NatlMgmtService#insertNatlMgmt(hae.basic.biz.model.NatlMgmt)
     */
//	@Override
//    public void insertNatlMgmt(NatlMgmt natlMgmt) throws Exception {
//        natlMgmtDAO.insertNatlMgmt(natlMgmt);
//    }

    /*
     * @see hae.basic.biz.service.NatlMgmtService#updateNatlMgmt(hae.basic.biz.model.NatlMgmt)
     */
//    @Override
//    public void updateNatlMgmt(NatlMgmt natlMgmt) throws Exception {
//        natlMgmtDAO.updateNatlMgmt(natlMgmt);
//    }

    /*
     * @see hae.basic.biz.service.NatlMgmtService#deleteNatlMgmt(hae.basic.biz.model.NatlMgmt)
     */
//    @Override
//    public void deleteNatlMgmt(NatlMgmt natlMgmt) throws Exception {
//        natlMgmtDAO.deleteNatlMgmt(natlMgmt);
//    }
    
    /*
     * @see hae.basic.biz.service.NatlMgmtService#selectNatlMgmt(hae.basic.biz.model.NatlMgmt)
     */
//    @Override
//    public NatlMgmt selectNatlMgmt(NatlMgmt natlMgmt) throws Exception {
//        return natlMgmtDAO.selectNatlMgmt(natlMgmt);
//    }

    /*
     * @see hae.basic.biz.service.NatlMgmtService#selectNatlMgmtList(hae.basic.biz.model.NatlMgmt)
     */
//    public List<NatlMgmt> selectNatlMgmtList(NatlMgmt natlMgmt) throws Exception {
    public List<NatlMgmt> selectNatlMgmtList() throws Exception {
//        return natlMgmtDAO.selectNatlMgmtList(natlMgmt);
        return natlMgmtDAO.selectNatlMgmtList();
    }
}
