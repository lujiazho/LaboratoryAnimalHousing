package org.lah.WelfareFeeding.mapper;

import org.lah.WelfareFeeding.domain.ExtendedBoarestruslnfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendedBoarestruslnfoDao {
    int deleteByPrimaryKey(Integer actionid);

    int insert(ExtendedBoarestruslnfo record);

    int insertSelective(ExtendedBoarestruslnfo record);

    List<ExtendedBoarestruslnfo> selectByAnimalNumber(String animalNumber);

    int updateByPrimaryKeySelective(ExtendedBoarestruslnfo record);

    int updateByPrimaryKey(ExtendedBoarestruslnfo record);
}