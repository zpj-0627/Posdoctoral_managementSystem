package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Postdoctoraproject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-16
 */
public interface PostdoctoraprojectService extends IService<Postdoctoraproject> {

    List<Postdoctoraproject> selectpostdoctoraprojectInfo(Postdoctoraproject postdoctoraproject);

    List<Postdoctoraproject> selectBydId(Postdoctoraproject postdoctoraproject);

}
