package org.lah.AnimalHealth.mapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalHealth.domain.Animal;
import org.springframework.format.annotation.DateTimeFormat;

import static org.lah.Commons.LahConstants.ANIMALTABLE;

import java.util.Date;
import java.util.List;
import java.util.Map;
public interface AnimalDeleteMapper {
    @Delete("delete from "+ANIMALTABLE+" where id=#{id}")
    void delete(@Param("id") String id);
}
