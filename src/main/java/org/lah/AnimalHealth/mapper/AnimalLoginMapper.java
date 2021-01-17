package org.lah.AnimalHealth.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalHealth.domain.Animal;
import org.springframework.format.annotation.DateTimeFormat;

import static org.lah.Commons.LahConstants.ANIMALTABLE;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AnimalLoginMapper {
    @Insert("INSERT INTO "+ANIMALTABLE+" VALUES(#{id},#{var},#{state},#{health},#{date})")
    void login(@Param("id")String id,
                                      @Param("var") String var,
                                        @Param("state")String state,
                                        @Param("health")String health,
                                        @Param("date")Date date);
    @Update("UPDATE "+ANIMALTABLE+" SET state='已检疫',health=#{health} WHERE id=#{id}")
    void update(@Param("id")String id,
               @Param("health")String health);
}
