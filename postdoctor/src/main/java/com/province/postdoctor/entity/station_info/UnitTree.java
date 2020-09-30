package com.province.postdoctor.entity.station_info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: postdoctor
 * @author: lsn
 * @create: 2020-09-28 14:41
 * @description: 设站单位管理树
 */
@Data
public class UnitTree {
    /**
     * 节点id
     */
    @JsonProperty("id")
    private String dId;

    /**
     * 节点名称
     */
    @JsonProperty("title")
    private String dName;

    /**
     * 节点的父节点id
     */
    @JsonProperty("parentId")
    private String dPid;

}
