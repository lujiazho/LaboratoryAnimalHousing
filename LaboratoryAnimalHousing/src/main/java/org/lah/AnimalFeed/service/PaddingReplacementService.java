package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.PaddingReplacement;
import org.lah.AnimalFeed.domain.PageInfo;

import java.util.List;

public interface PaddingReplacementService {


    //分页查询
    public PageInfo<PaddingReplacement> findPageInfo(Integer PaddingReplacementNumber, Integer RoomNumber,
                                            String PersonnelNumber, Integer PaddingNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deletePaddingReplacement(Integer PaddingReplacementNumber);   //删除信息
    public int addPaddingReplacement(PaddingReplacement paddingReplacement);   //添加信息
    public int updatePaddingReplacement(PaddingReplacement paddingReplacement); //修改信息
    public PaddingReplacement findPaddingReplacementById(Integer PaddingReplacementNumber);
    public List<PaddingReplacement> getAll();

}
