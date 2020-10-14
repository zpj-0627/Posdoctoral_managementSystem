package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Treatise;
import com.province.postdoctor.mapper.postdoctor_info.ThesisMapper;
import com.province.postdoctor.mapper.postdoctor_info.TreatiseMapper;
import com.province.postdoctor.service.postdoctor_info.TreatiseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tykj
 * @since 2020-10-12
 */
@Service
public class TreatiseServiceImpl extends ServiceImpl<TreatiseMapper, Treatise> implements TreatiseService {

    @Resource
    private TreatiseMapper treatiseMapper;

    @Override
    public List<Treatise> selecttreatiseInfo(Treatise treatise) {
        return treatiseMapper.selecttreatiseInfo(treatise);
    }

    @Override
    public List<Treatise> selectBydId(Treatise treatise) {
        return treatiseMapper.selectBydId(treatise);
    }
}
