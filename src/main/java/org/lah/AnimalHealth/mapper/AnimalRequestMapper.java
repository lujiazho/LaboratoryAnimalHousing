package org.lah.AnimalHealth.mapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalHealth.domain.Request;
import org.springframework.format.annotation.DateTimeFormat;

import static org.lah.Commons.LahConstants.REQUESTTABLE;

import java.util.Date;
import java.util.List;
import java.util.Map;
public interface AnimalRequestMapper {
    @Select("SELECT * FROM "+REQUESTTABLE)
    List<Request> select();
}
