package hae.basic.biz.service;

import java.util.List;

import able.cloud.core.service.HService;

import org.springframework.stereotype.Service;

import hae.basic.biz.dao.UsrMgmtDAO;
import hae.basic.biz.dto.CommReqDTO;
import hae.basic.biz.dto.UsrMgmtReqDTO;
import hae.basic.biz.dto.UsrMgmtResDTO;
import hae.basic.biz.model.UsrMgmt;
//import hae.basic.biz.service.UsrMgmtService;
import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * UsrMgmtService 구현
 * </pre>
 * 
 * @ClassName   : UsrMgmtServiceImpl.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.19
 * @see
 */

@RequiredArgsConstructor
@Service("usrMgmtService")
public class UsrMgmtService { //Impl  //extends HService implements UsrMgmtService {

    /**
     * UsrMgmtDAO class 선언 (UsrMgmtDAO) Class Injection)
     */
	private final UsrMgmtDAO usrMgmtDAO;

    /*
     * @see hae.basic.biz.service.UsrMgmtService#insertUsrMgmt(hae.basic.biz.model.UsrMgmt)
     */
//	@Override
    public void insertUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.insertUsrMgmt(usrMgmt);
    }

    /*
     * @see hae.basic.biz.service.UsrMgmtService#updateUsrMgmt(hae.basic.biz.model.UsrMgmt)
     */
//    @Override
    public void updateUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.updateUsrMgmt(usrMgmt);
    }

    /*
     * @see hae.basic.biz.service.UsrMgmtService#deleteUsrMgmt(hae.basic.biz.model.UsrMgmt)
     */
//    @Override
    public void deleteUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.deleteUsrMgmt(usrMgmt);
    }
    
    /*
     * @see hae.basic.biz.service.UsrMgmtService#selectUsrMgmt(hae.basic.biz.model.UsrMgmt)
     */
//    @Override
    public UsrMgmtResDTO selectUsrMgmt(String id) throws Exception {
        return usrMgmtDAO.selectUsrMgmt(id);
    }

    /*
     * @see hae.basic.biz.service.UsrMgmtService#selectUsrMgmtList(hae.basic.biz.model.UsrMgmt)
     */
//    @Override
    public List<UsrMgmtResDTO> selectUsrMgmtList(UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
        return usrMgmtDAO.selectUsrMgmtList(usrMgmtReqDTO);
    }
}
