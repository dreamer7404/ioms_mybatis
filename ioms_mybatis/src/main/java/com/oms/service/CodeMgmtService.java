package com.oms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oms.dao.CodeMgmtDAO;
import com.oms.model.CodeMgmt;

import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * CodeMgmtService
 * </pre>
 * 
 * @ClassName   : CodeMgmtService.java
 * @Description : 클래스 설명을 기술합니다.
 * @author 안경수 
 * @since 2023.1.19
 * @see
 */

@RequiredArgsConstructor
@Service("codeMgmtService")
public class CodeMgmtService { 

	private final CodeMgmtDAO codeMgmtDAO;

    public void insertCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.insertCodeMgmt(codeMgmt);
    }

    public void updateCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.updateCodeMgmt(codeMgmt);
    }

    public void deleteCodeMgmt(CodeMgmt codeMgmt) throws Exception {
        codeMgmtDAO.deleteCodeMgmt(codeMgmt);
    }
    
    public CodeMgmt selectCodeMgmt(String id) throws Exception {
        return codeMgmtDAO.selectCodeMgmt(id);
    }

    public List<CodeMgmt> selectCodeMgmtList(CodeMgmt codeMgmt) throws Exception {
        return codeMgmtDAO.selectCodeMgmtList(codeMgmt);
    }
}
