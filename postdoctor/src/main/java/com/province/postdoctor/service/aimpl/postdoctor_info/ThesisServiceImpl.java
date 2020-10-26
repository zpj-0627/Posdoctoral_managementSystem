package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Thesis;
import com.province.postdoctor.mapper.postdoctor_info.PostdoctorrinformationMapper;
import com.province.postdoctor.mapper.postdoctor_info.ThesisMapper;
import com.province.postdoctor.service.postdoctor_info.ThesisService;
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
 * @since 2020-10-10
 */
@Service
public class ThesisServiceImpl extends ServiceImpl<ThesisMapper, Thesis> implements ThesisService {


    @Resource
    private ThesisMapper thesisMapper;

    @Override
    public List<Thesis> selectthesisInfo(Thesis thesis) {
        return thesisMapper.selectthesisInfo(thesis);
    }

    @Override
    public List<Thesis> selectBydId(Thesis thesis) {
        return thesisMapper.selectBydId(thesis);
    }

    @Override
    public void deleteById(String id) {
        thesisMapper.deleteById(id);
    }
}
