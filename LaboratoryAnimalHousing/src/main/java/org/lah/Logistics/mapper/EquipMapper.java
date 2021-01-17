package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.Logistics.domain.Application;
import org.lah.Logistics.domain.Equip;
import org.lah.Logistics.mapper.provider.EquipDynaSqlProvider;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.*;

/**
 * EquipMapper接口
 */
public interface EquipMapper {
    // 动态插入垃圾
    @SelectProvider(type= EquipDynaSqlProvider.class, method="insertEquip")
    void save(Equip equip);

    // 根据参数查询设备记录总数
    @SelectProvider(type=EquipDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type=EquipDynaSqlProvider.class,method="selectWithParam")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="usage",property="usage"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="equipmentname_id",property="equipmentname",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="specificationmodel_id",property="specificationmodel",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Equip> selectByPage(Map<String, Object> params);

    @Update("update "+EQUIPTABLE+" set `usage` = #{usage} where id = #{id}")
    int updateEquip(@Param("usage")int usage, @Param("id")int id);

    @Delete("delete from "+EQUIPTABLE+" where id = #{eid}")
    int deleteEquip(@Param("eid")int eid);

    /*********************************** ReNew加的 **********************************************/
    //获取总条数
    Integer totalCount(@Param("c_classname") String c_classname, @Param("c_classid") Integer c_classid, @Param("c_counsellor") String c_counsellor);

    //注意这里只有一个参数，则#{}中的标识符可以任意取
    @Select("select * from "+EQUIPTABLE+" where id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="usage",property="usage"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="equipmentname_id",property="equipmentname",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="specificationmodel_id",property="specificationmodel",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    Equip findEquipById(int id);

    /*********************************** 查设备编号用 **********************************************/
    // 动态查询
    @SelectProvider(type=EquipDynaSqlProvider.class,method="selectDynByEidSid")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="usage",property="usage"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="equipmentname_id",property="equipmentname",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="specificationmodel_id",property="specificationmodel",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Equip> selectByEidSid(String eid, String sid);

    @Select("select * from "+EQUIPTABLE+" ")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="usage",property="usage"),
            @Result(column="loggingdate",property="loggingdate",javaType=java.util.Date.class),
            @Result(column="equipmentname_id",property="equipmentname",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="specificationmodel_id",property="specificationmodel",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Equip> getAll();
}
