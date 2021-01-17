package org.lah.WelfareFeeding.mapper;

import org.lah.WelfareFeeding.domain.EnvironmentalStandard;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalStandardDao {
    int deleteByPrimaryKey(String environmentalstandardsnumber);

    String insert(EnvironmentalStandard record);

    int insertSelective(EnvironmentalStandard record);

    EnvironmentalStandard selectByPrimaryKey(String environmentalstandardsnumber);

    EnvironmentalStandard selectByAnimalNumber(String animalnumber);


    int updateByPrimaryKeySelective(EnvironmentalStandard record);

    int updateByPrimaryKey(EnvironmentalStandard record);
}