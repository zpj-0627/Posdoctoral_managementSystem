package com.province.postdoctor.entity.station_info;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: demo
 * @author: zpj
 * @create: 2020-08-14
 * @description:
 */
@Data
public class PoetTable implements Serializable {
    private String dId;
    private String dName;
    private String dType;
    private String department;
    private String fsubject;
    private String Industry;
    private String cddepartment;
    private String fixedphone;
    private String fax;
}
