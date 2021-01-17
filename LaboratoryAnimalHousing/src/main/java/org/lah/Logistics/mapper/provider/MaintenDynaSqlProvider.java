package org.lah.Logistics.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.lah.Logistics.domain.Maintenance;

import java.text.SimpleDateFormat;
import java.util.Map;

import static org.lah.Commons.LahConstants.MAINTENANCETABLE;

public class MaintenDynaSqlProvider {
    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(MAINTENANCETABLE);
                if(params.get("maintenance") != null){
                    Maintenance maintenance = (Maintenance)params.get("maintenance");
                    if(maintenance.getMaintenancedate() != null && !maintenance.getMaintenancedate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(maintenance.getMaintenancedate());
                        WHERE("  maintenancedate LIKE '"+sdate+"%' ");
                    }
                    if(maintenance.getEname() != null && maintenance.getEname().getId()!=0){
                        WHERE(" ename_id = #{maintenance.ename.id} ");
                    }
                    if(maintenance.getSname() != null && maintenance.getSname().getId()!=0){
                        WHERE(" sname_id = #{maintenance.sname.id} ");
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
                FROM(MAINTENANCETABLE);
                if(params.get("maintenance") != null){
                    Maintenance maintenance = (Maintenance)params.get("maintenance");
                    if(maintenance.getMaintenancedate() != null && !maintenance.getMaintenancedate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(maintenance.getMaintenancedate());
                        WHERE("  maintenancedate LIKE '"+sdate+"%' ");
                    }
                    if(maintenance.getEname() != null && maintenance.getEname().getId()!=0){
                        WHERE(" ename_id = #{maintenance.ename.id} ");
                    }
                    if(maintenance.getSname() != null && maintenance.getSname().getId()!=0){
                        WHERE(" sname_id = #{maintenance.sname.id} ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertMaintenance(final Maintenance maintenance){

        return new SQL(){
            {
                INSERT_INTO(MAINTENANCETABLE);
                if(maintenance.getEname() != null && !maintenance.getEname().equals("")){
                    VALUES("ename_id", "#{ename.id}");
                }
                if(maintenance.getSname() != null && !maintenance.getSname().equals("")){
                    VALUES("sname_id", "#{sname.id}");
                }
                if(maintenance.getEnumber() != null && !maintenance.getEnumber().equals("")){
                    VALUES("enumber", "#{enumber}");
                }
                if(maintenance.getMaintenanceresult() != null && !maintenance.getMaintenanceresult().equals("")){
                    VALUES("maintenanceresult", "#{maintenanceresult}");
                }
                if(maintenance.getMaintainer() != null && !maintenance.getMaintainer().equals("")){
                    VALUES("maintainer_id", "#{maintainer.id}");
                }
            }
        }.toString();
    }
}
