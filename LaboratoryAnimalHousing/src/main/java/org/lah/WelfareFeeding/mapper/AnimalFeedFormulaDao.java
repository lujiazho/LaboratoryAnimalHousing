package org.lah.WelfareFeeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.WelfareFeeding.domain.AnimalFeedFormula;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalFeedFormulaDao {
    int deleteByPrimaryKey(String feednumber);

    String insert(AnimalFeedFormula record);

    int insertSelective(AnimalFeedFormula record);

    AnimalFeedFormula selectByPrimaryKey(String feednumber);

    int selectCount();

    List<AnimalFeedFormula> selectOrderByPrimaryKey(@Param("offset") int offset, @Param("limit") int limit);

    int updateByPrimaryKeySelective(AnimalFeedFormula record);

    int updateByPrimaryKey(AnimalFeedFormula record);
}