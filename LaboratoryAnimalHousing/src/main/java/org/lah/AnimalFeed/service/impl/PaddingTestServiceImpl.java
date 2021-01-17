package org.lah.AnimalFeed.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.controller.PaddingTestController;
import org.lah.AnimalFeed.domain.PaddingTest;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.PaddingTestMapper;
import org.lah.AnimalFeed.service.PaddingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("PaddingTestService")
@Transactional
public class PaddingTestServiceImpl implements PaddingTestService {
    @Autowired
    private PaddingTestMapper paddingtestMapper;
    private static final Log logger = LogFactory
            .getLog(PaddingTestController.class);
    //分页查询
    @Override
    public PageInfo<PaddingTest> findPageInfo(Integer PaddingTestNumber, Integer PaddingGetNumber, boolean IfPadStandard,
                                              String PersonnelNumber, String AbnormalCondition,Integer pageIndex, Integer pageSize) {
        PageInfo<PaddingTest> pi = new PageInfo<PaddingTest>();
        logger.info("\n\nmmd"+"FUCK YOU impl"+"\n\n");
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = paddingtestMapper.totalCount(PaddingTestNumber, PaddingGetNumber,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<PaddingTest> paddingTestList =	paddingtestMapper.getPaddingTest(PaddingTestNumber, PaddingGetNumber, IfPadStandard,PersonnelNumber,
                     AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(paddingTestList);
        }
        //logger.info("\n\nmmd"+"FUCK YOU impl PaddingBacterialCount2:"+PaddingBacterialCount+"\n\n");
        return pi;
    }
    @Override
    public List<PaddingTest> getAll(){
        List<PaddingTest> paddingTestList = paddingtestMapper.getAll();
        return paddingTestList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deletePaddingTest(Integer PaddingTestNumber) {
        return paddingtestMapper.deletePaddingTest(PaddingTestNumber);
    }
    //添加信息
    @Override
    public  int addPaddingTest(PaddingTest paddingTest) {
        return paddingtestMapper.addPaddingTest(paddingTest);
    }
    //修改信息
    @Override
    public int updatePaddingTest(PaddingTest paddingTest) { return paddingtestMapper.updatePaddingTest(paddingTest); }

    @Override
    public PaddingTest findPaddingTestById (Integer PaddingTestNumber){
        PaddingTest s = paddingtestMapper.findPaddingTestById(PaddingTestNumber);
        return  s;
    }


}
