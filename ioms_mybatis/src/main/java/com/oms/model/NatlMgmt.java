package com.oms.model;

import java.sql.Timestamp;

import lombok.Data;

/**
 * <pre>
 * NatlMgmt VO
 * </pre>
 *
 * @Class Name : NatlMgmt.java
 * @Description : 클래스 설명을 기술합니다. 
 * @author 안경수
 * @since 2023.1.6
 * @see 
 */
@Data
public class NatlMgmt{

    private String dlExpdCoCd;     // DL_EXPD_CO_CD(tb_natl_mgmt) : VARCHAR(4)
    private String dlExpdNatCd;     // DL_EXPD_NAT_CD(tb_natl_mgmt) : VARCHAR(5)
    private String dlExpdRegnCd;     // DL_EXPD_REGN_CD(tb_natl_mgmt) : VARCHAR(4)
    private String natNm;     // NAT_NM(tb_natl_mgmt) : VARCHAR(40)
    private String dytmPlnNatCd;     // DYTM_PLN_NAT_CD(tb_natl_mgmt) : VARCHAR(5)
    private String prdnMstNatCd;     // PRDN_MST_NAT_CD(tb_natl_mgmt) : VARCHAR(5)
    private String pprrEeno;     // PPRR_EENO(tb_natl_mgmt) : VARCHAR(20)
    private Timestamp framDtm;     // FRAM_DTM(tb_natl_mgmt) : DATETIME(19)
    private String updrEeno;     // UPDR_EENO(tb_natl_mgmt) : VARCHAR(20)
    private Timestamp mdfyDtm;     // MDFY_DTM(tb_natl_mgmt) : DATETIME(19)
    
}
