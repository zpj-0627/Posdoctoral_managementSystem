package com.province.postdoctor.result;

import lombok.Data;

import java.util.List;

@Data
public class NumberResult<T> {
    private List<T> data;
}
