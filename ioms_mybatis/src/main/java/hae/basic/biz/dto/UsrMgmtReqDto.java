package hae.basic.biz.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 1. 31.
 * @see
 */

@Alias("UsrMgmtReqDto")
@Data
@AllArgsConstructor
public class UsrMgmtReqDto {
    private String userEeno;     // USER_EENO(tb_usr_mgmt) : VARCHAR(20)
    private String userPw;   
}
