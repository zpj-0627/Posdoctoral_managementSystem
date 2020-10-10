package com.province.postdoctor.service.dictionary;

import com.baomidou.mybatisplus.extension.service.IService;
import com.province.postdoctor.entity.dictionary.Dictionary;
import com.province.postdoctor.entity.dictionary.smTable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Package: com.province.postdoctor.service.aimpl.dictionary
 * <p>
 * Description： TODO
 * <p>
 * Author: 作者
 * <p>
 * Date: Created in 2020/10/5 19:28
 * <p>
 * Company: 公司
 * <p>
 * Copyright: Copyright (c) 2017
 * <p>
 * Version: 0.0.1
 * <p>
 * Modified By:
 */
public interface DictionaryService extends IService<Dictionary> {
    List<Dictionary> department();

    List<Dictionary> f_subject();

    List<smTable> selectDicTable();

    List<smTable> selectDicTableByName(String smName);

    List<smTable> selectDicTableById(String nodeId);

    int add(Dictionary dictionary);

}
