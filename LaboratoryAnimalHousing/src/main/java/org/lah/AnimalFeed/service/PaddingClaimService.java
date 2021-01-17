package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.PaddingClaim;
import org.lah.AnimalFeed.domain.PageInfo;

import javax.xml.crypto.Data;
import java.util.List;

public interface PaddingClaimService {


    //分页查询
    public PageInfo<PaddingClaim> findPageInfo(Integer PaddingGetNumber, String PaddingType, String PersonnelNumber,
                                               Integer PaddingNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deletePaddingClaim(Integer PaddingGetNumber);   //删除信息
    public int addPaddingClaim(PaddingClaim paddingClaim);   //添加信息
    public int updatePaddingClaim(PaddingClaim paddingClaim); //修改信息
    public PaddingClaim findPaddingClaimById(Integer PaddingGetNumber);
    public List<PaddingClaim> getAll();

}
