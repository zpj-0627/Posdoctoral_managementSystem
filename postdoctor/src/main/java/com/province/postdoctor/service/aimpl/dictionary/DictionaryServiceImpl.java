package com.province.postdoctor.service.aimpl.dictionary;

import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.mapper.dictionary.DictionaryMapper;
import com.province.postdoctor.service.dictionary.DictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tykj
 * @since 2020-09-27
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    public List<Dictionary> department() {
        return dictionaryMapper.department() ;
    }

    @Override
    public List<Dictionary> f_subject() {
        return dictionaryMapper.f_subject() ;
    }

}
