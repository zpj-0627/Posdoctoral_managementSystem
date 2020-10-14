package com.province.postdoctor.mapper.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.entity.postdoctor_info.Treatise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tykj
 * @since 2020-10-12
 */
public interface TreatiseMapper extends BaseMapper<Treatise> {

    List<Treatise> selecttreatiseInfo(Treatise treatise);

    List<Treatise> selectBydId(Treatise treatise);

}
