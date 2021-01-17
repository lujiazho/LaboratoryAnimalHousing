package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.lah.Logistics.domain.Name;
import org.lah.Logistics.mapper.provider.NameDynaSqlProvider;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.EQUIPNAMETABLE;

/**
 * @Description: NameMapper接口
 */
public interface NameMapper {
    @Select("select * from "+EQUIPNAMETABLE+" ")
    List<Name> selectAllName();

    @Select("select * from "+EQUIPNAMETABLE+" where id = #{id}")
    Name selectById(int id);

    // 动态查询
    @SelectProvider(type= NameDynaSqlProvider.class,method="selectWithParam")
    List<Name> selectByPage(Map<String, Object> params);

    @SelectProvider(type=NameDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态插入名字
    @SelectProvider(type=NameDynaSqlProvider.class,method="insertName")
    void save(Name name);
}
