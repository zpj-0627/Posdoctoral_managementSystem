package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Patent;
import com.province.postdoctor.mapper.postdoctor_info.PatentMapper;
import com.province.postdoctor.service.postdoctor_info.PatentService;
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
 * @since 2020-10-13
 */
@Service
public class PatentServiceImpl extends ServiceImpl<PatentMapper, Patent> implements PatentService {

    @Resource
    private PatentMapper patentMapper;

    @Override
    public List<Patent> selectpatentInfo(Patent patent) {
        return patentMapper.selectpatentInfo(patent);
    }

    @Override
    public List<Patent> selectBydId(Patent patent) {
        return patentMapper.selectBydId(patent);
    }
}
