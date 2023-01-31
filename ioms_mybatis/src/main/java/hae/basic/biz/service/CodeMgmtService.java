package hae.basic.biz.service;

import hae.basic.biz.service.CodeMgmtService;
import lombok.RequiredArgsConstructor;
import hae.basic.biz.dao.CodeMgmtDAO;
import hae.basic.biz.dao.UsrMgmtDAO;
import hae.basic.biz.model.CodeMgmt;

import java.util.List;

import org.springframework.stereotype.Service;

import able.cloud.core.service.HService;
import able.cloud.core.vo.HMap;


/**
 * <pre>
 * CodeMgmtService 구현
 * </pre>
 * 
 * @ClassName   : CodeMgmtServiceImpl.java
 * @Description : 클래스 설명을 기술합니다.
 * @author Windows ≫c¿eAU 
 * @since 2023.1.19
 * @see
 */

@RequiredArgsConstructor
@Service("codeMgmtService")
public class CodeMgmtService { // extends HService implements CodeMgmtService {

    /**
     * CodeMgmtDAO class 선언 (CodeMgmtDAO) Class Injection)
     */
	private final CodeMgmtDAO codeMgmtDAO;

    /*
     * @see hae.basic.biz.service.CodeMgmtService#insertCodeMgmt(hae.basic.biz.model.CodeMgmt)
     */
    public void insertCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.insertCodeMgmt(codeMgmt);
    }

    /*
     * @see hae.basic.biz.service.CodeMgmtService#updateCodeMgmt(hae.basic.biz.model.CodeMgmt)
     */
    public void updateCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.updateCodeMgmt(codeMgmt);
    }

    /*
     * @see hae.basic.biz.service.CodeMgmtService#deleteCodeMgmt(hae.basic.biz.model.CodeMgmt)
     */
    public void deleteCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.deleteCodeMgmt(codeMgmt);
    }
    
    /*
     * @see hae.basic.biz.service.CodeMgmtService#selectCodeMgmt(hae.basic.biz.model.CodeMgmt)
     */
    public CodeMgmt selectCodeMgmt(String id) throws Exception {
        return codeMgmtDAO.selectCodeMgmt(id);
    }

    /*
     * @see hae.basic.biz.service.CodeMgmtService#selectCodeMgmtList(hae.basic.biz.model.CodeMgmt)
     */
    public List<CodeMgmt> selectCodeMgmtList(CodeMgmt codeMgmt) throws Exception {
        return codeMgmtDAO.selectCodeMgmtList(codeMgmt);
    }
}
