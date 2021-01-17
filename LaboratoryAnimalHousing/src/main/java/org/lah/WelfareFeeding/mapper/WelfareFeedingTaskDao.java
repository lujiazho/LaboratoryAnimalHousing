package org.lah.WelfareFeeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.WelfareFeeding.domain.WelfareFeedingTask;
import org.lah.WelfareFeeding.domain.WelfareFeedingTaskKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WelfareFeedingTaskDao {
    int deleteByPrimaryKey(WelfareFeedingTaskKey key);

    int insert(WelfareFeedingTask record);

    int insertSelective(WelfareFeedingTask record);

    int selectCount(@Param("maintenancestaff") String maintenancestaff);

    WelfareFeedingTask selectByPrimaryKey(WelfareFeedingTaskKey key);

    List<WelfareFeedingTask> selectByStaffing(@Param("maintenancestaff") String maintenancestaff, @Param("offset") int offset, @Param("limit") int limit);

    int updateByPrimaryKeySelective(WelfareFeedingTask record);

    int updateByPrimaryKey(WelfareFeedingTask record);
}