package org.lah.AnimalFeed.service.impl;

import org.lah.AnimalFeed.domain.PaddingReplacement;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.PaddingReplacementMapper;
import org.lah.AnimalFeed.service.PaddingReplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("PaddingReplacementService")
@Transactional
public class PaddingReplacementServiceImpl implements PaddingReplacementService {
    @Autowired
    private PaddingReplacementMapper paddingreplacementMapper;

    //分页查询
    @Override
    public PageInfo<PaddingReplacement> findPageInfo(Integer PaddingReplacementNumber, Integer RoomNumber,
                                            String PersonnelNumber, Integer PaddingNumber, String AbnormalCondition,Integer pageIndex, Integer pageSize) {
        PageInfo<PaddingReplacement> pi = new PageInfo<PaddingReplacement>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = paddingreplacementMapper.totalCount(PaddingReplacementNumber, RoomNumber,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<PaddingReplacement> paddingReplacementList =	paddingreplacementMapper.getPaddingReplacement(PaddingReplacementNumber,RoomNumber,PersonnelNumber,PaddingNumber,
                    AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(paddingReplacementList);
        }
        return pi;
    }
    @Override
    public List<PaddingReplacement> getAll(){
        List<PaddingReplacement> paddingReplacementList = paddingreplacementMapper.getAll();
        return paddingReplacementList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deletePaddingReplacement(Integer PaddingReplacementNumber) {
        return paddingreplacementMapper.deletePaddingReplacement(PaddingReplacementNumber);
    }
    //添加信息
    @Override
    public  int addPaddingReplacement(PaddingReplacement paddingReplacement) {
        return paddingreplacementMapper.addPaddingReplacement(paddingReplacement);
    }
    //修改信息
    @Override
    public int updatePaddingReplacement(PaddingReplacement paddingReplacement) { return paddingreplacementMapper.updatePaddingReplacement(paddingReplacement); }

    @Override
    public PaddingReplacement findPaddingReplacementById (Integer PaddingReplacementNumber){
        PaddingReplacement s = paddingreplacementMapper.findPaddingReplacementById(PaddingReplacementNumber);
        return  s;
    }


}
