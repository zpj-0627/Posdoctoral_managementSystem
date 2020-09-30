package com.province.postdoctor.service.dictionary;

import com.province.postdoctor.entity.dictionary.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-09-27
 */
public interface DictionaryService extends IService<Dictionary> {
    List<Dictionary> department();

    List<Dictionary> f_subject();

}
