package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-13
 */
public interface PatentService extends IService<Patent> {

    List<Patent> selectpatentInfo(Patent patent);

    List<Patent> selectBydId(Patent patent);

    void deleteById(String id);

}
