package com.oms.dto.res;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author Windows ≫c¿eAU
 * @since 2023. 2. 14.
 * @see
 */
@Data
@AllArgsConstructor
public class AuthResDTO {
    private String accessToken;
    private String refreshToken;
    private String userNm;
}
