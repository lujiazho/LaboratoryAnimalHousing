package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.PaddingTest;

import java.util.List;


public interface PaddingTestMapper {


    //获取总条数
    public Integer totalCount(@Param("PaddingTestNumber") Integer PaddingTestNumber,
                              @Param("PaddingGetNumber") Integer PaddingGetNumber, @Param("PersonnelNumber") String PersonnelNumber);
    //获取列表
    public List<PaddingTest> getPaddingTest(@Param("PaddingTestNumber") Integer PaddingTestNumber,
                                        @Param("PaddingGetNumber") Integer PaddingGetNumber, @Param("IfPadStandard") boolean IfPadStandard,@Param("PersonnelNumber") String PersonnelNumber
                                            , @Param("AbnormalCondition") String AbnormalCondition,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deletePaddingTest(Integer PaddingTestNumber);   //删除饲料领取信息
    public int addPaddingTest(PaddingTest paddingTest);   //添加信息
    public int updatePaddingTest(PaddingTest paddingTest); //修改信息
    public PaddingTest findPaddingTestById(Integer PaddingTestNumber);
    public List<PaddingTest> getAll();
}
