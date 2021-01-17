package org.lah.Logistics.mapper.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jdbc.SQL;
import org.lah.Commons.controller.login;
import org.lah.Logistics.domain.Waste;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Map;

import static org.lah.Commons.LahConstants.WASTETABLE;;

/**
 * @Description: 用户动态SQL语句提供类
 */
public class WasteDynaSqlProvider {
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(login.class);
    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(WASTETABLE);
                if(params.get("waste") != null){
                    Waste waste = (Waste)params.get("waste");
                    if(waste.getLoggingdate() != null && !waste.getLoggingdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(waste.getLoggingdate());
                        WHERE("  loggingdate LIKE '"+sdate+"%' ");
                    }
                    if(waste.getWastetype() != null && waste.getWastetype()!=0){
                        WHERE("  wastetype = #{waste.wastetype} ");
                    }
                    if(waste.getRecycable() != null && waste.getRecycable()!=0){
                        WHERE(" recycable = #{waste.recycable} ");
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
                FROM(WASTETABLE);
                if(params.get("waste") != null){
                    Waste waste = (Waste)params.get("waste");
                    if(waste.getLoggingdate() != null && !waste.getLoggingdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(waste.getLoggingdate());
                        WHERE("  loggingdate LIKE '"+sdate+"%' ");
                    }
                    if(waste.getWastetype() != null && waste.getWastetype()!=0){
                        WHERE("  wastetype = #{waste.wastetype} ");
                    }
                    if(waste.getRecycable() != null && waste.getRecycable()!=0){
                        WHERE(" recycable = #{waste.recycable} ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertWaste(final Waste waste){

        return new SQL(){
            {
                INSERT_INTO(WASTETABLE);
                logger.info("Provider:");
                logger.info("date:"+waste.getLoggingdate());
                logger.info("weight:"+waste.getWasteweight());
                logger.info("recyc:"+waste.getRecycable());
                logger.info("type:"+waste.getWastetype());

                if(waste.getWasteweight() != null && !waste.getWasteweight().equals("")){
                    VALUES("wasteweight", "#{wasteweight}");
                }
                if(waste.getRecycable() != null && !waste.getRecycable().equals("")){
                    VALUES("recycable", "#{recycable}");
                }
                if(waste.getWastetype() != null && !waste.getWastetype().equals("")){
                    VALUES("wastetype", "#{wastetype}");
                }
            }
        }.toString();
    }
}
