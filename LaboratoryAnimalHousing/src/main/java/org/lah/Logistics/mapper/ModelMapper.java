package org.lah.Logistics.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.Logistics.domain.Model;
import org.lah.Logistics.domain.Name;
import org.lah.Logistics.mapper.provider.EquipDynaSqlProvider;
import org.lah.Logistics.mapper.provider.ModelDynaSqlProvider;
import org.lah.Logistics.mapper.provider.NameDynaSqlProvider;

import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.EQUIPSPECTABLE;

/**
 * @Description: ModelMapper接口
 */
public interface ModelMapper {
    @Select("select * from "+EQUIPSPECTABLE+" ")
    List<Model> selectAllModel();

    @Select("select * from "+EQUIPSPECTABLE+" where id = #{id}")
    Model selectById(int id);

    @Select("select * from "+EQUIPSPECTABLE+" where eid = #{eid}")
    List<Model> selectWanted(String eid);

    @SelectProvider(type= ModelDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    // 动态查询
    @SelectProvider(type= ModelDynaSqlProvider.class,method="selectWithParam")
    List<Model> selectByPage(Map<String, Object> params);

    // 动态插入设备型号
    @SelectProvider(type=ModelDynaSqlProvider.class,method="insertSpec")
    void save(Model model);
}
