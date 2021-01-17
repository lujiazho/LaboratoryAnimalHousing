package org.lah.Logistics.mapper.provider;

import org.apache.ibatis.jdbc.SQL;
import org.lah.Logistics.domain.Name;
import static org.lah.Commons.LahConstants.EQUIPNAMETABLE;
import java.util.List;
import java.util.Map;

public class NameDynaSqlProvider {
    // 分页动态查询
    public String selectWithParam(final Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM(EQUIPNAMETABLE);
                if(params.get("name") != null){
                    Name name = (Name) params.get("name");
                    if(name.getId() != null && name.getId()!=0){
                        WHERE("id = #{name.id} ");
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
                FROM(EQUIPNAMETABLE);
                if(params.get("name") != null){
                    Name name = (Name) params.get("name");
                    if(name.getId() != null && name.getId()!=0){
                        WHERE("id = #{name.id} ");
                    }
                }
            }
        }.toString();
    }
    // 动态插入
    public String insertName(final Name name){

        return new SQL(){
            {
                INSERT_INTO(EQUIPNAMETABLE);
                if(name.getName() != null && !name.getName().equals("")){
                    VALUES("name", "#{name}");
                }
            }
        }.toString();
    }
}
