package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Awards;
import com.province.postdoctor.mapper.postdoctor_info.AwardsMapper;
import com.province.postdoctor.service.postdoctor_info.AwardsService;
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
 * @since 2020-10-15
 */
@Service
public class AwardsServiceImpl extends ServiceImpl<AwardsMapper, Awards> implements AwardsService {

    @Resource
    private AwardsMapper awardsMapper;


    @Override
    public List<Awards> selectawardsInfo(Awards awards) {
        return awardsMapper.selectawardsInfo(awards);
    }

    @Override
    public List<Awards> selectBydId(Awards awards) {
        return awardsMapper.selectBydId(awards);
    }
}
