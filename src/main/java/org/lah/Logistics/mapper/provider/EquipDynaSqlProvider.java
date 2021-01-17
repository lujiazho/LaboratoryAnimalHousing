package org.lah.Logistics.mapper.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.lah.Logistics.controller.NumberFindServlet;
import org.lah.Logistics.domain.Equip;

import java.text.SimpleDateFormat;
import java.util.Map;

import static org.lah.Commons.LahConstants.EQUIPTABLE;

public class EquipDynaSqlProvider {
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(EquipDynaSqlProvider.class);

    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(EQUIPTABLE);
                if(params.get("equip") != null){
                    Equip equip = (Equip)params.get("equip");
                    if(equip.getLoggingdate() != null && !equip.getLoggingdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(equip.getLoggingdate());
                        WHERE("  loggingdate LIKE '"+sdate+"%' ");
                    }
                    if(equip.getEquipmentname() != null && equip.getEquipmentname().getId()!=0){
                        WHERE(" equipmentname_id = #{equip.equipmentname.id} ");
                    }
                    if(equip.getSpecificationmodel() != null && equip.getSpecificationmodel().getId()!=0){
                        WHERE(" specificationmodel_id = #{equip.specificationmodel.id} ");
                    }
                    if(equip.getUsage() != null && equip.getUsage()!=0){
                        WHERE(" `usage` = #{equip.usage} ");
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
                FROM(EQUIPTABLE);
                if(params.get("equip") != null){
                    Equip equip = (Equip)params.get("equip");
                    if(equip.getLoggingdate() != null && !equip.getLoggingdate().equals("")){
                        String sdate = (new SimpleDateFormat("yyyy-MM-dd")).format(equip.getLoggingdate());
                        WHERE("  loggingdate LIKE '"+sdate+"%' ");
                    }
                    if(equip.getEquipmentname() != null && equip.getEquipmentname().getId()!=0){
                        WHERE(" equipmentname_id = #{equip.equipmentname.id} ");
                    }
                    if(equip.getSpecificationmodel() != null && equip.getSpecificationmodel().getId()!=0){
                        WHERE(" specificationmodel_id = #{equip.specificationmodel.id} ");
                    }
                    if(equip.getUsage() != null && equip.getUsage()!=0){
                        WHERE(" `usage` = #{equip.usage} ");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertEquip(final Equip equip){

        return new SQL(){
            {
                INSERT_INTO(EQUIPTABLE);

                if(equip.getEquipmentname() != null && !equip.getEquipmentname().equals("")){
                    VALUES("equipmentname_id", "#{equipmentname.id}");
                }
                if(equip.getSpecificationmodel() != null && !equip.getSpecificationmodel().equals("")){
                    VALUES("specificationmodel_id", "#{specificationmodel.id}");
                }
                if(equip.getEquipmentnumber() != null && !equip.getEquipmentnumber().equals("")){
                    VALUES("equipmentnumber", "#{equipmentnumber}");
                }
                if(equip.getUsage() != null && !equip.getUsage().equals("")){
                    VALUES("usage", "1");
                }
            }
        }.toString();
    }

    /*********************************** ReNew加的 **********************************************/
    public String findEquipById(final Integer id){
        return new SQL(){
            {
                SELECT("*");
                FROM(EQUIPTABLE);
                WHERE("id="+id);
            }
        }.toString();
    }

    /*********************************** 查设备编号用 **********************************************/
    public String selectDynByEidSid(final String eid, final String sid){
        return new SQL(){
            {
                SELECT("*");
                FROM(EQUIPTABLE);
                WHERE("equipmentname_id = "+eid+" and specificationmodel_id = "+sid+" ");
            }
        }.toString();
    }
}
