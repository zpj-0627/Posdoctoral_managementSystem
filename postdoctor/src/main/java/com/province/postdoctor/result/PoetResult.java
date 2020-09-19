package com.province.postdoctor.result;

import lombok.Data;

import java.util.List;
@Data
public class PoetResult<T> {

        private Integer code;
        private String msg;
        private Long count;
        private List<T> data;

}
