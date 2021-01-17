package org.lah.WelfareFeeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.WelfareFeeding.domain.TempAnimalrecordlnfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempAnimalrecordlnfoDao {
    int deleteByPrimaryKey(String animalnumber);

    int insert(TempAnimalrecordlnfo record);

    int insertSelective(TempAnimalrecordlnfo record);

    int selectCount();

    List<TempAnimalrecordlnfo> selectOrderByPrimaryKey(@Param("offset") int offset, @Param("limit") int limit);

    TempAnimalrecordlnfo selectByPrimaryKey(String animalnumber);

    int updateByPrimaryKeySelective(TempAnimalrecordlnfo record);

    int updateByPrimaryKey(TempAnimalrecordlnfo record);
}