package org.lah.WelfareFeeding.mapper;

import org.lah.WelfareFeeding.domain.ExtendedBoarestruslnfo;
import org.lah.WelfareFeeding.domain.ExtendedSowsestruslnfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtendedSowsestruslnfoDao {
    int deleteByPrimaryKey(Integer actionid);

    int insert(ExtendedSowsestruslnfo record);

    int insertSelective(ExtendedSowsestruslnfo record);

    List<ExtendedSowsestruslnfo> selectByAnimalNumber(String animalNumber);

    int updateByPrimaryKeySelective(ExtendedSowsestruslnfo record);

    int updateByPrimaryKey(ExtendedSowsestruslnfo record);
}