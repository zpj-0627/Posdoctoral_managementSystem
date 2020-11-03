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
    private int BasicInfoNumber;
    /*
    读博情况
    */
    private int PhdSituationNumber;
    /*
    留学情况
    */
    private int StudyAbroadNumber;
    /*
    学习经历
    */
    private int LearningExpNumber;
    /*
    工作经历
    */
    private int WorkExpNumber;
    /*
    代表性论文
    */
    private int PaperNumber;
    /*
    参与或主持的项目
    */
    private int ProjectNumber;
    /*
    专利情况
    */
    private int patentNumber;
    /*
    代表性专著
    */
    private int MonographNumber;
    /*
    在站科研成果或科技奖励
    */
    private int RewardNumber;
    /*
    申请基金资助情况
    */
    private int FundfoNumber;

}
