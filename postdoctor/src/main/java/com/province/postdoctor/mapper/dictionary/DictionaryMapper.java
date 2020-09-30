package com.province.postdoctor.mapper.dictionary;

import com.province.postdoctor.entity.dictionary.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-09-27
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    List<Dictionary> department();

    List<Dictionary> f_subject();
}
