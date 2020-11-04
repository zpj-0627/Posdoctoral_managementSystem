package com.province.postdoctor.result;


import lombok.Data;

import java.util.List;

@Data
public class StatisticsResult<T> {
    private String xAxis;
    private String htitle;
    private String ptitle;
    private String yAxis;
    private List<T> Data;
}
