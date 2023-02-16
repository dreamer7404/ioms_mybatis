package com.oms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oms.dao.UsrMgmtDAO;
import com.oms.dto.req.UsrMgmtReqDTO;
import com.oms.dto.res.UsrMgmtResDTO;
import com.oms.model.UsrMgmt;

import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * UsrMgmtService
 * </pre>
 * 
 * @ClassName   : UsrMgmtService.java
 * @Description : 
 * @author 안경수 
 * @since 2023.1.19
 * @see
 */

@RequiredArgsConstructor
@Service("usrMgmtService")
public class UsrMgmtService { 

	private final UsrMgmtDAO usrMgmtDAO;

    public void insertUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.insertUsrMgmt(usrMgmt);
    }

    public void updateUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.updateUsrMgmt(usrMgmt);
    }

    public void deleteUsrMgmt(UsrMgmt usrMgmt) throws Exception {
        usrMgmtDAO.deleteUsrMgmt(usrMgmt);
    }
    
    public UsrMgmtResDTO selectUsrMgmt(String id) throws Exception {
        return usrMgmtDAO.selectUsrMgmt(id);
    }

    public List<UsrMgmtResDTO> selectUsrMgmtList(UsrMgmtReqDTO usrMgmtReqDTO) throws Exception {
        return usrMgmtDAO.selectUsrMgmtList(usrMgmtReqDTO);
    }
}
