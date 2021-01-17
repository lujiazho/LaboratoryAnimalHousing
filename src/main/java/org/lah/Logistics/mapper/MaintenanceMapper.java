package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.Logistics.domain.Maintenance;
import org.lah.Logistics.mapper.provider.MaintenDynaSqlProvider;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.MAINTENANCETABLE;

public interface MaintenanceMapper {
    // 根据参数查询检修记录总数
    @SelectProvider(type= MaintenDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type= MaintenDynaSqlProvider.class,method="selectWithParam")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="enumber",property="enumber"),
            @Result(column="maintenanceresult",property="maintenanceresult"),
            @Result(column="maintenancedate",property="maintenancedate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="maintainer_id",property="maintainer",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectMaintainerById",
                            fetchType=FetchType.EAGER))
    })
    List<Maintenance> selectByPage(Map<String, Object> params);

    // 动态插入申请
    @SelectProvider(type= MaintenDynaSqlProvider.class,method="insertMaintenance")
    void save(Maintenance maintenance);

    /*********************************** 导出 **********************************************/
    @Select("select * from "+MAINTENANCETABLE+" ")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="enumber",property="enumber"),
            @Result(column="maintenanceresult",property="maintenanceresult"),
            @Result(column="maintenancedate",property="maintenancedate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="maintainer_id",property="maintainer",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectMaintainerById",
                            fetchType=FetchType.EAGER))
    })
    List<Maintenance> getAll();
}
