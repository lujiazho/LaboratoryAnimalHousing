package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.PaddingClaim;

import java.util.Date;
import java.util.List;


public interface PaddingClaimMapper {


    //获取总条数
    public Integer totalCount(@Param("PaddingGetNumber") Integer PaddingGetNumber,
                              @Param("PaddingType") String PaddingType, @Param("PersonnelNumber") String PersonnelNumber);
    //获取列表
    public List<PaddingClaim> getPaddingClaim(@Param("PaddingGetNumber") Integer PaddingGetNumber,
                                        @Param("PaddingType") String PaddingType, @Param("PersonnelNumber") String PersonnelNumber, @Param("PaddingNumber") Integer PaddingNumber, @Param("AbnormalCondition") String AbnormalCondition,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deletePaddingClaim(Integer PaddingGetNumber);   //删除饲料领取信息
    public int addPaddingClaim(PaddingClaim paddingClaim);   //添加信息
    public int updatePaddingClaim(PaddingClaim paddingClaim); //修改信息
    public PaddingClaim findPaddingClaimById(Integer PaddingGetNumber);
    public List<PaddingClaim> getAll();
}
