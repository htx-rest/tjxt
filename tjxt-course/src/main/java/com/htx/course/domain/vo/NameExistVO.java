package com.htx.course.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName NameExistVO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NameExistVO {
    public static final NameExistVO EXISTED = new NameExistVO(true);
    public static final NameExistVO NOT_EXIST = new NameExistVO(false);

    private Boolean existed;
}
