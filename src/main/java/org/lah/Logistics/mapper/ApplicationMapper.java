package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.Logistics.domain.Application;
import org.lah.Logistics.mapper.provider.ApplicDynaSqlProvider;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.APPLICATIONTABLE;

public interface ApplicationMapper {
    /**************************************  查询全部订单   ***********************************************/
    // 根据参数查询申请记录总数
    @SelectProvider(type= ApplicDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type= ApplicDynaSqlProvider.class,method="selectWithParam")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="demandnum",property="demandnum"),
            @Result(column="receivednum",property="receivednum"),
            @Result(column="applicationdate",property="applicationdate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="employee_id",property="employee",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Application> selectByPage(Map<String, Object> params);

    /**************************************  查询未完成订单   ********************************************/
    // 根据参数查询申请记录总数
    @SelectProvider(type= ApplicDynaSqlProvider.class,method="countUnfinished")
    Integer countUnfinished(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type= ApplicDynaSqlProvider.class,method="selectWithParamUnfinished")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="demandnum",property="demandnum"),
            @Result(column="receivednum",property="receivednum"),
            @Result(column="applicationdate",property="applicationdate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="employee_id",property="employee",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Application> selectByPageUnfinished(Map<String, Object> params);


    // 动态插入申请
    @SelectProvider(type= ApplicDynaSqlProvider.class,method="insertApplication")
    void save(Application application);

    @Select("select * from "+APPLICATIONTABLE+" where id = #{a_id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="demandnum",property="demandnum"),
            @Result(column="receivednum",property="receivednum"),
            @Result(column="applicationdate",property="applicationdate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="employee_id",property="employee",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    Application findApplicationById(Integer a_id);

    //注意这里不只有一个参数，则#{}中的标识符得加@Param
    @Update("update "+APPLICATIONTABLE+" set receivednum = #{sum} where id = #{id}")
    int updateApplication(@Param("sum")int sum, @Param("id")int id);

    /*********************************** 导出 **********************************************/
    @Select("select * from "+APPLICATIONTABLE+" ")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="equipmentnumber",property="equipmentnumber"),
            @Result(column="demandnum",property="demandnum"),
            @Result(column="receivednum",property="receivednum"),
            @Result(column="applicationdate",property="applicationdate",javaType=java.util.Date.class),
            @Result(column="ename_id",property="ename",
                    one=@One(select="org.lah.Logistics.mapper.NameMapper.selectById",
                            fetchType= FetchType.EAGER)),
            @Result(column="sname_id",property="sname",
                    one=@One(select="org.lah.Logistics.mapper.ModelMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="employee_id",property="employee",
                    one=@One(select="org.lah.Logistics.mapper.EmployeeMapper.selectById",
                            fetchType=FetchType.EAGER))
    })
    List<Application> getAll();
}
