package com.province.postdoctor.entity.postdoctor_info;

import lombok.Data;

/**
 * Package: com.province.postdoctor.entity.postdoctor_info
 * <p>
 * Description： 人员管理各模块数量
 * <p>
 **/
@Data
public class PostdoctoralInfoNumber {
    /*
    基础信息
    */
    private Integer BasicInfoNumber;
    /*
    读博情况
    */
    private Integer PhdSituationNumber;
    /*
    留学情况
    */
    private Integer StudyAbroadNumber;
    /*
    学习经历
    */
    private Integer LearningExpNumber;
    /*
    工作经历
    */
    private Integer WorkExpNumber;
    /*
    代表性论文
    */
    private Integer PaperNumber;
    /*
    参与或主持的项目
    */
    private Integer ProjectNumber;
    /*
    专利情况
    */
    private Integer patentNumber;
    /*
    代表性专著
    */
    private Integer MonographNumber;
    /*
    在站科研成果或科技奖励
    */
    private Integer RewardNumber;
    /*
    申请基金资助情况
    */
    private Integer FundfoNumber;

}
