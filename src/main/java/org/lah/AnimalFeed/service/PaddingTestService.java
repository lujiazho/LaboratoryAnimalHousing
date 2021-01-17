package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.PaddingTest;
import org.lah.AnimalFeed.domain.PageInfo;

import java.util.List;

public interface PaddingTestService {


    //分页查询
    public PageInfo<PaddingTest> findPageInfo(Integer PaddingTestNumber, Integer PaddingGetNumber, boolean IfPadStandard,
                                              String PersonnelNumber,
                                              String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deletePaddingTest(Integer PaddingTestNumber);   //删除信息
    public int addPaddingTest(PaddingTest paddingTest);   //添加信息
    public int updatePaddingTest(PaddingTest paddingTest); //修改信息
    public PaddingTest findPaddingTestById(Integer PaddingTestNumber);
    public List<PaddingTest> getAll();

}
