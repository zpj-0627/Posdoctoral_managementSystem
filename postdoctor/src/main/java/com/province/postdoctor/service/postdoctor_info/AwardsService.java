package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-15
 */
public interface AwardsService extends IService<Awards> {

    List<Awards> selectawardsInfo(Awards awards);

    List<Awards> selectBydId(Awards awards);

    void deleteById(String id);

}
