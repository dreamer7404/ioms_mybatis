package com.oms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oms.dao.NatlMgmtDAO;
import com.oms.model.NatlMgmt;

import lombok.RequiredArgsConstructor;


/**
 * <pre>
 * NatlMgmtService 
 * </pre>
 * 
 * @ClassName   : NatlMgmtService.java
 * @Description : 
 * @author 안경수
 * @since 2023.1.6
 * @see
 */
@RequiredArgsConstructor
@Service("natlMgmtService")
public class NatlMgmtService {

	private final NatlMgmtDAO natlMgmtDAO;
	
    public List<NatlMgmt> selectNatlMgmtList() throws Exception {
        return natlMgmtDAO.selectNatlMgmtList();
    }
}
