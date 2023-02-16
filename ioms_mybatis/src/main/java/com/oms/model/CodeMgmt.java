package com.oms.model;

import java.sql.Timestamp;

import lombok.Data;

/**
 * <pre>
 * CodeMgmt VO
 * </pre>
 *
 * @Class Name : CodeMgmt.java
 * @Description : 클래스 설명을 기술합니다. 
 * @author 안경수
 * @since 2023.1.19
 * @see 
 */

@Data
public class CodeMgmt{

    private String dlExpdGCd;     // DL_EXPD_G_CD(tb_code_mgmt) : VARCHAR(4)
    private String dlExpdPrvsCd;     // DL_EXPD_PRVS_CD(tb_code_mgmt) : VARCHAR(4)
    private String dlExpdPrvsNm;     // DL_EXPD_PRVS_NM(tb_code_mgmt) : VARCHAR(200)
    private Integer sortSn;     // SORT_SN(tb_code_mgmt) : INTEGER(3)
    private String useYn;     // USE_YN(tb_code_mgmt) : CHAR(1)
    private String pprrEeno;     // PPRR_EENO(tb_code_mgmt) : VARCHAR(20)
    private Timestamp framDtm;     // FRAM_DTM(tb_code_mgmt) : DATETIME(19)
    private String updrEeno;     // UPDR_EENO(tb_code_mgmt) : VARCHAR(20)
    private Timestamp mdfyDtm;     // MDFY_DTM(tb_code_mgmt) : DATETIME(19)
    
}
