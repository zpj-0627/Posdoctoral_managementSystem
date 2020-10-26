package com.province.postdoctor.mapper.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.entity.postdoctor_info.Postdoctoraproject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-16
 */
public interface PostdoctoraprojectMapper extends BaseMapper<Postdoctoraproject> {

    List<Postdoctoraproject> selectpostdoctoraprojectInfo(Postdoctoraproject postdoctoraproject);

    List<Postdoctoraproject> selectBydId(Postdoctoraproject postdoctoraproject);

    void deleteById(String id);

}
