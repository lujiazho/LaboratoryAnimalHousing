package org.lah.Logistics.mapper.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jdbc.SQL;
import org.lah.Logistics.controller.EquipController;
import org.lah.Logistics.domain.Application;
import org.lah.Logistics.domain.Employee;
import org.lah.Logistics.domain.Model;
import org.lah.Logistics.domain.Name;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.APPLICATIONTABLE;

public class ApplicDynaSqlProvider {
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(ApplicDynaSqlProvider.class);
    /**************************************  查询全部订单   ***********************************************/
    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(APPLICATIONTABLE);
                if(params.get("application") != null){
                    Application application = (Application)params.get("application");
                    if(application.getApplicationdate() != null && !application.getApplicationdate().equals("")){
                        WHERE("  applicationdate LIKE CONCAT ('%',#{application.applicationdate},'%') ");
                    }
                    if(application.getEname() != null && !application.getEname().equals("")){
                        WHERE(" ename_id LIKE CONCAT ('%',#{application.ename.id},'%') ");
                    }
                    if(application.getSname() != null && !application.getSname().equals("")){
                        WHERE(" sname_id LIKE CONCAT ('%',#{application.sname.id},'%') ");
                    }
                    if(application.getEmployee() != null && !application.getEmployee().equals("")){
                        WHERE(" employee_id LIKE CONCAT ('%',#{application.employee.id},'%') ");
                    }
                    if(application.getDemandnum() != null && !application.getDemandnum().equals("")){
                        WHERE(" demandnum LIKE CONCAT ('%',#{application.demandnum},'%') ");
                    }
                    if(application.getReceivednum() != null && !application.getReceivednum().equals("")){
                        WHERE(" receivednum LIKE CONCAT ('%',#{application.receivednum},'%') ");
                    }
                }
            }
        }.toString();

        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }

        return sql;
    }
    // 动态查询总数量
    public String count(final Map<String, Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(APPLICATIONTABLE);
                if(params.get("application") != null){
                    Application application = (Application)params.get("application");
                    if(application.getEname() != null && !application.getEname().equals("")){
                        WHERE("  ename_id LIKE CONCAT ('%',#{application.ename.id},'%') ");
                    }
                    if(application.getSname() != null && !application.getSname().equals("")){
                        WHERE(" sname_id LIKE CONCAT ('%',#{application.sname.id},'%') ");
                    }
                    if(application.getDemandnum() != null && !application.getDemandnum().equals("")){
                        WHERE(" demandnum LIKE CONCAT ('%',#{application.demandnum},'%') ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertApplication(final Application application){

        return new SQL(){
            {
                INSERT_INTO(APPLICATIONTABLE);
                if(application.getEname() != null && !application.getEname().equals("")){
                    VALUES("ename_id", "#{ename.id}");
                }
                if(application.getSname() != null && !application.getSname().equals("")){
                    VALUES("sname_id", "#{sname.id}");
                }
                if(application.getDemandnum() != null && !application.getDemandnum().equals("")){
                    VALUES("demandnum", "#{demandnum}");
                }
                if(application.getEmployee() != null && !application.getEmployee().equals("")){
                    VALUES("employee_id", "#{employee.id}");
                }
                if(application.getReceivednum() != null && !application.getReceivednum().equals("")){
                    VALUES("receivednum", "0");
                }
            }
        }.toString();
    }

    /**************************************  查询未完成订单   ********************************************/
    // 分页动态查询
    public String selectWithParamUnfinished(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(APPLICATIONTABLE);
                if(params.get("application") != null){
                    Application application = (Application)params.get("application");
                    if(application.getApplicationdate() != null && !application.getApplicationdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(application.getApplicationdate());
                        WHERE("  applicationdate LIKE '"+sdate+"%' ");
                    }
                    if(application.getEname() != null && application.getEname().getId()!=0){
                        WHERE(" ename_id = #{application.ename.id} ");
                    }
                    if(application.getSname() != null && application.getSname().getId()!=0){
                        WHERE(" sname_id = #{application.sname.id} ");
                    }
//                    if(application.getEmployee() != null && !application.getEmployee().equals("")){
//                        WHERE(" employee_id LIKE CONCAT ('%',#{application.employee.id},'%') ");
//                    }
                    WHERE(" demandnum > receivednum");
                }
            }
        }.toString();

        if(params.get("pageModel") != null){
            sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
        }

        return sql;
    }
    // 动态查询总数量
    public String countUnfinished(final Map<String, Object> params){
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(APPLICATIONTABLE);
                if(params.get("application") != null){
                    Application application = (Application)params.get("application");
//                    logger.info("\n\n\nApplication: " + application + "\n\n");
                    // 三项条件查
                    if(application.getApplicationdate() != null && !application.getApplicationdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(application.getApplicationdate());
                        WHERE("  applicationdate LIKE '"+sdate+"%' ");
                    }
                    if(application.getEname() != null && application.getEname().getId()!=0){
                        WHERE(" ename_id = #{application.ename.id} ");
                    }
                    if(application.getSname() != null && application.getSname().getId()!=0){
                        WHERE(" sname_id = #{application.sname.id} ");
                    }
                    WHERE(" demandnum > receivednum");
                }
            }
        }.toString();
    }
}
