package com.province.postdoctor.service.aimpl.postdoctor_info;

import com.province.postdoctor.entity.postdoctor_info.Fundapplication;
import com.province.postdoctor.mapper.postdoctor_info.FundapplicationMapper;
import com.province.postdoctor.service.postdoctor_info.FundapplicationService;
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
public class FundapplicationServiceImpl extends ServiceImpl<FundapplicationMapper, Fundapplication> implements FundapplicationService {

    @Resource
    private FundapplicationMapper fundapplicationMapper;

    @Override
    public List<Fundapplication> selectfundapplicationInfo(Fundapplication fundapplication) {
        return fundapplicationMapper.selectfundapplicationInfo(fundapplication);
    }

    @Override
    public List<Fundapplication> selectBydId(Fundapplication fundapplication) {
        return fundapplicationMapper.selectBydId(fundapplication);
    }

    @Override
    public void deleteById(String id) {
        fundapplicationMapper.deleteById(id);
    }
}
