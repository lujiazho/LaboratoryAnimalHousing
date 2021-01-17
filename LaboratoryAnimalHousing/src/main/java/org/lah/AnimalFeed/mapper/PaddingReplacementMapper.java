package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.PaddingReplacement;

import java.util.List;


public interface PaddingReplacementMapper {


    //获取总条数
    public Integer totalCount(@Param("PaddingReplacementNumber") Integer PaddingReplacementNumber,
                              @Param("RoomNumber") Integer RoomNumber, @Param("PersonnelNumber") String PersonnelNumber);
    //获取列表
    public List<PaddingReplacement> getPaddingReplacement(@Param("PaddingReplacementNumber") Integer PaddingReplacementNumber,
                                        @Param("RoomNumber") Integer RoomNumber, @Param("PersonnelNumber") String PersonnelNumber, @Param("PaddingAmount") Integer PaddingAmount, @Param("AbnormalCondition") String AbnormalCondition,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deletePaddingReplacement(Integer PaddingReplacementNumber);   //删除饲料领取信息
    public int addPaddingReplacement(PaddingReplacement paddingReplacement);   //添加信息
    public int updatePaddingReplacement(PaddingReplacement paddingReplacement); //修改信息
    public PaddingReplacement findPaddingReplacementById(Integer PaddingReplacementNumber);
    public List<PaddingReplacement> getAll();
}
