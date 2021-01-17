package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.*;
import org.lah.Logistics.domain.Waste;
import org.lah.Logistics.mapper.provider.WasteDynaSqlProvider;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.WASTETABLE;

/**
 * WasteMapper接口
 * */
public interface WasteMapper {
    // 动态插入垃圾
    @SelectProvider(type=WasteDynaSqlProvider.class, method="insertWaste")
    void save(Waste waste);

    // 根据参数查询垃圾记录总数
    @SelectProvider(type=WasteDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type=WasteDynaSqlProvider.class,method="selectWithParam")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="wasteweight",property="wasteweight"),
            @Result(column="recycable",property="recycable"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="wastetype",property="wastetype")
    })
    List<Waste> selectByPage(Map<String, Object> params);

    @Select("select * from "+WASTETABLE+" ")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="wasteweight",property="wasteweight"),
            @Result(column="recycable",property="recycable"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="wastetype",property="wastetype")
    })
    List<Waste> selectAllWaste();
}
