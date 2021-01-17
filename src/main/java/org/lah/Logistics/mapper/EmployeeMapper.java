package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.lah.Logistics.domain.Employee;

import java.util.List;

import static org.lah.Commons.LahConstants.EMPLOYEETABLE;
import static org.lah.Commons.LahConstants.USERTABLE;

public interface EmployeeMapper {
    @Select("select * from "+USERTABLE+" where id = #{id}")
    Employee selectById(int id);

    @Select("select * from "+EMPLOYEETABLE+" where Employeeid = #{id}")
    @Results({
            @Result(id=true,column="Employeeid",property="id"),
            @Result(column="EmployeeName",property="username"),
            @Result(column="EmployeeNumber",property="number"),
            @Result(column="EmployeeDepartment",property="department"),
            @Result(column="EmployeeRole",property="position"),
            @Result(column="EmployeePhoneNumber",property="phone"),
    })
    Employee selectMaintainerById(int id);

    @Select("select * from "+EMPLOYEETABLE+" where EmployeeRole = '维修工'")
    @Results({
            @Result(id=true,column="Employeeid",property="id"),
            @Result(column="EmployeeName",property="username"),
            @Result(column="EmployeeNumber",property="number"),
            @Result(column="EmployeeDepartment",property="department"),
            @Result(column="EmployeeRole",property="position"),
            @Result(column="EmployeePhoneNumber",property="phone"),
    })
    List<Employee> findAllMaintainer();
}
