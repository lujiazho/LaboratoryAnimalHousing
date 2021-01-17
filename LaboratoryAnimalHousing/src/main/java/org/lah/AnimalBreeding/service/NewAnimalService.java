package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.NewAnimal;
import org.lah.AnimalBreeding.domain.PageInfo;
import java.util.List;

public interface NewAnimalService {


    //分页查询
    public PageInfo<NewAnimal> findPageInfo(String AnimalNumber, String RecordDate, String AnimalSex, String IncineratorPerson,
                                            String BroodChamber, String SowNumber,String HealthCondition,Integer pageIndex, Integer pageSize);

    public int deleteNewAnimal(String AnimalNumber);   //删除信息
    public int addNewAnimal(NewAnimal newanimal);   //添加信息
    public int updateNewAnimal(NewAnimal newanimal); //修改信息

    public NewAnimal findNewAnimalByAN(String AnimalNumber);
    public List<NewAnimal> getAll();

}
