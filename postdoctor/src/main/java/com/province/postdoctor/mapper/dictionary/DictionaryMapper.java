package com.province.postdoctor.mapper.dictionary;

import com.province.postdoctor.entity.dictionary.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.province.postdoctor.entity.dictionary.smTable;
import org.springframework.web.bind.annotation.PathVariable;

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

    List<smTable> selectDicTable();

    List<smTable> selectDicTableByName(String smName);

    List<smTable> selectDicTableById(String nodeId);

    int add(Dictionary dictionary);

}
