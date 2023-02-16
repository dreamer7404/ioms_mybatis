package com.oms.dto.res;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 1. 31.
 * @see
 */
@Alias("usrMgmtResDTO")
@Data
@AllArgsConstructor
public class UsrMgmtResDTO {
    private String userEeno;     // USER_EENO(tb_usr_mgmt) : VARCHAR(20)
    private String userNm;     // USER_NM(tb_usr_mgmt) : VARCHAR(50)
    private String userPw;     // USER_NM(tb_usr_mgmt) : VARCHAR(50)
    private String blnsCoCd;     // BLNS_CO_CD(tb_usr_mgmt) : VARCHAR(4)
    private String userDcd;     // USER_DCD(tb_usr_mgmt) : VARCHAR(8)
    private String userEmlAdr;     // USER_EML_ADR(tb_usr_mgmt) : VARCHAR(100)
    private String useYn;     // USE_YN(tb_usr_mgmt) : VARCHAR(1)
    private String pprrEeno;     // PPRR_EENO(tb_usr_mgmt) : VARCHAR(20)
    private Timestamp framDtm;     // FRAM_DTM(tb_usr_mgmt) : DATETIME(19)
    private String updrEeno;     // UPDR_EENO(tb_usr_mgmt) : VARCHAR(20)
    private Timestamp mdfyDtm;     // MDFY_DTM(tb_usr_mgmt) : DATETIME(19)
    private Timestamp pwAltrDtm;     // PW_ALTR_DTM(tb_usr_mgmt) : DATETIME(19)
    private Timestamp finLgiDtm;     // FIN_LGI_DTM(tb_usr_mgmt) : DATETIME(19)
    private Timestamp pwLockDtm;     // PW_LOCK_DTM(tb_usr_mgmt) : DATETIME(19)
    private Integer pwErrOft;     // PW_ERR_OFT(tb_usr_mgmt) : INTEGER(11)
    private String userChgPw;     // USER_CHG_PW(tb_usr_mgmt) : VARCHAR(1)
    private String grpCd;     // GRP_CD(tb_usr_mgmt) : VARCHAR(3)
    private String userOsetLgi;     // USER_OSET_LGI(tb_usr_mgmt) : VARCHAR(1)
    private String useGbn;     // USE_GBN(tb_usr_mgmt) : VARCHAR(1)
}
