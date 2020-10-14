package com.province.postdoctor.service.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Treatise;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tykj
 * @since 2020-10-12
 */
public interface TreatiseService extends IService<Treatise> {

    List<Treatise> selecttreatiseInfo(Treatise treatise);

    List<Treatise> selectBydId(Treatise treatise);

}
