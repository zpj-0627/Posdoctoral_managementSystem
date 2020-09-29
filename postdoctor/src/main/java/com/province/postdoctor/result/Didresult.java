package com.province.postdoctor.result;

import lombok.Data;

import java.util.List;

@Data
public class Didresult<T> {
    private Integer status;
    private List<T> data;
}
