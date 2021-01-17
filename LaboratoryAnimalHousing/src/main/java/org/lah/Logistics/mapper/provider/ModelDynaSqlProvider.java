package org.lah.Logistics.mapper.provider;


import org.apache.ibatis.jdbc.SQL;
import org.lah.Logistics.domain.Equip;
import org.lah.Logistics.domain.Model;
import org.lah.Logistics.domain.Name;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.EQUIPNAMETABLE;
import static org.lah.Commons.LahConstants.EQUIPSPECTABLE;

public class ModelDynaSqlProvider {
    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(EQUIPSPECTABLE);
                if(params.get("model") != null){
                    Model model = (Model) params.get("model");
                    if(model.getEid() != null && model.getEid()!=0){
                        WHERE("eid = #{model.eid}");
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
                FROM(EQUIPSPECTABLE);
                if(params.get("model") != null){
                    Model model = (Model) params.get("model");
                    if(model.getEid() != null && model.getEid()!=0){
                        WHERE("eid = #{model.eid}");
                    }
                }
            }
        }.toString();
    }

    // 动态插入
    public String insertSpec(final Model model){

        return new SQL(){
            {
                INSERT_INTO(EQUIPSPECTABLE);
                if(model.getName() != null && !model.getName().equals("")){
                    VALUES("name", "#{name}");
                }
                if(model.getEid() != null && !model.getEid().equals("")){
                    VALUES("eid", "#{eid}");
                }
            }
        }.toString();
    }

}
