package com.oms.dto.req;

import org.apache.ibatis.type.Alias;

import com.oms.dto.CommReqDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 1. 31.
 * @see
 */

@Alias("usrMgmtReqDTO")
@Data
@AllArgsConstructor
public class UsrMgmtReqDTO extends CommReqDTO {
    private String userEeno;     // USER_EENO(tb_usr_mgmt) : VARCHAR(20)
    private String userPw;  
}
