package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Postdoctoraproject;
import com.province.postdoctor.mapper.postdoctor_info.PostdoctoraprojectMapper;
import com.province.postdoctor.service.postdoctor_info.PostdoctoraprojectService;
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
 * @since 2020-10-16
 */
@Service
public class PostdoctoraprojectServiceImpl extends ServiceImpl<PostdoctoraprojectMapper, Postdoctoraproject> implements PostdoctoraprojectService {

    @Resource
    private PostdoctoraprojectMapper postdoctoraprojectMapper;

    @Override
    public List<Postdoctoraproject> selectpostdoctoraprojectInfo(Postdoctoraproject postdoctoraproject) {
        return postdoctoraprojectMapper.selectpostdoctoraprojectInfo(postdoctoraproject);
    }

    @Override
    public List<Postdoctoraproject> selectBydId(Postdoctoraproject postdoctoraproject) {
        return postdoctoraprojectMapper.selectBydId(postdoctoraproject);
    }
}
