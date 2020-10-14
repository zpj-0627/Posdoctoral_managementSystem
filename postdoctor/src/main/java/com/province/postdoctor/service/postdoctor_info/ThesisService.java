package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-10
 */
public interface ThesisService extends IService<Thesis> {

    List<Thesis> selectthesisInfo(Thesis thesis);

    List<Thesis> selectBydId(Thesis thesis);

}
