package org.lah.AnimalHealth.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lah.AnimalHealth.domain.Animal;
import org.lah.AnimalHealth.domain.Qua;

import java.util.List;

import static org.lah.Commons.LahConstants.ANIMALTABLE;
import static org.lah.Commons.LahConstants.QUATABLE;

public interface QuaMapper {
    @Insert("INSERT INTO "+QUATABLE+" VALUES(#{id},#{var},#{info},#{cons},#{name})")
    void login(@Param("id")String id,
               @Param("var") String var,
               @Param("info")String info,
               @Param("cons")String cons,
               @Param("name")String name);
    @Select("SELECT * FROM "+QUATABLE)
    List<Qua> select();
    @Select("SELECT * FROM "+QUATABLE+" WHERE id=#{id}")
    List<Qua> select2(@Param("id") String id);
    @Select("SELECT * FROM "+QUATABLE+" WHERE var=#{var}")
    List<Qua> select3(@Param("var") String var);
}
