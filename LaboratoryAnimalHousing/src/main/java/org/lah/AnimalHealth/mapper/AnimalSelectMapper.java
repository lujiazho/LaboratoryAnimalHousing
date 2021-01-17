package org.lah.AnimalHealth.mapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalHealth.domain.Animal;
import org.springframework.format.annotation.DateTimeFormat;

import static org.lah.Commons.LahConstants.ANIMALTABLE;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AnimalSelectMapper {
    @Select("SELECT * FROM "+ANIMALTABLE)
    List<Animal> select();
    @Select("SELECT * FROM "+ANIMALTABLE+" WHERE id=#{id}")
    List<Animal> select2(@Param("id") String id);
    @Select("SELECT * FROM "+ANIMALTABLE+" WHERE var=#{var}")
    List<Animal> select3(@Param("var") String var);
}
