package com.oms.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Statements
 * </pre>
 *
 * @author 안경수
 * @since 2023. 2. 8.
 * @see
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("commReqDTO")
public class CommReqDTO {
    private String orderBy;
    private Integer pageNo;
    private Integer pageSize;

}
