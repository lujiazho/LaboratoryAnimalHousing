package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.NewAnimal;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.NewAnimalMapper;
import org.lah.AnimalBreeding.service.NewAnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("NewAnimalService")
@Transactional
public class NewAnimalServiceImpl implements NewAnimalService {
    @Autowired
    private NewAnimalMapper nMapper;

    //分页查询
    @Override
    public PageInfo<NewAnimal> findPageInfo(String AnimalNumber, String RecordDate, String AnimalSex, String IncineratorPerson,
                                         String BroodChamber, String SowNumber,String HealthCondition,Integer pageIndex, Integer pageSize)
    {
        PageInfo<NewAnimal> pi = new PageInfo<NewAnimal>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = nMapper.totalCount(AnimalNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<NewAnimal> nList =nMapper.getNewAnimal(AnimalNumber, RecordDate, AnimalSex,IncineratorPerson,
                    BroodChamber, SowNumber, HealthCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(nList);
        }
        return pi;
    }
    @Override
    public List<NewAnimal> getAll(){
        List<NewAnimal> nList = nMapper.getAll();
        return nList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteNewAnimal(String AnimalNumber) {
        return nMapper.deleteNewAnimal(AnimalNumber);
    }
    //添加信息
    @Override
    public  int addNewAnimal(NewAnimal newanimal) {
        return nMapper.addNewAnimal(newanimal);
    }
    //修改信息
    @Override
    public int updateNewAnimal(NewAnimal newanimal) { return nMapper.updateNewAnimal(newanimal); }

    @Override
    public NewAnimal findNewAnimalByAN (String AnimalNumber){
        NewAnimal s = nMapper.findNewAnimalByAN(AnimalNumber);
        return  s;
    }
}
