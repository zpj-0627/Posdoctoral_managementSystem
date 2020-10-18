package com.province.postdoctor.service.aimpl.dictionary;

import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.dictionary.smTable;
import com.province.postdoctor.mapper.dictionary.DictionaryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.province.postdoctor.service.dictionary.DictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> department() {
        return dictionaryMapper.department() ;
    }

    @Override
    public List<Dictionary> f_subject() {
        return dictionaryMapper.f_subject() ;
    }

    @Override
    public List<smTable> selectDicTable() {
        return dictionaryMapper.selectDicTable();
    }

    @Override
    public List<smTable> selectDicTableByName(String smName) {
        return dictionaryMapper.selectDicTableByName(smName);
    }

    @Override
    public List<smTable> selectDicTableById(String nodeId) {
        return dictionaryMapper.selectDicTableById(nodeId);
    }

    @Override
    public int add(Dictionary dictionary) {
        return dictionaryMapper.add(dictionary);
    }

    @Override
    public void deleteById(String id) {
         dictionaryMapper.deleteById(id);
    }


}
