package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Postdoctorrinformation;
import com.province.postdoctor.mapper.postdoctor_info.PostdoctorrinformationMapper;
import com.province.postdoctor.service.postdoctor_info.PostdoctorrinformationService;
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
 * @since 2020-10-05
 */
@Service
public class PostdoctorrinformationServiceImpl extends ServiceImpl<PostdoctorrinformationMapper, Postdoctorrinformation> implements PostdoctorrinformationService {

    @Resource
    private PostdoctorrinformationMapper postdoctorrinformationMapper;

    @Override
    public List<Postdoctorrinformation> selectpostdoctorInfo(Postdoctorrinformation postdoctorrinformation) {
        return postdoctorrinformationMapper.selectpostdoctorInfo(postdoctorrinformation);
    }

    @Override
    public List<Postdoctorrinformation> selectBydId(Postdoctorrinformation postdoctorrinformation) {
        return postdoctorrinformationMapper.selectBydId(postdoctorrinformation);
    }
}
