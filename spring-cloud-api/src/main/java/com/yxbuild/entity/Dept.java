package com.yxbuild.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:03 2019/1/10
 * @Modified By:
 */
@Data
public class Dept implements Serializable {
    private String deptId;

    private String deptName;

    private String db_source;

    private String state;
}
