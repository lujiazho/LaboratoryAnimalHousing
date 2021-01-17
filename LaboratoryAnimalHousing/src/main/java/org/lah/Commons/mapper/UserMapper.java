package org.lah.Commons.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lah.Commons.domain.User;
import static org.lah.Commons.LahConstants.USERTABLE;

public interface UserMapper {
    @Select("select * from " + USERTABLE + " where loginname = #{loginname} and password = #{password}")
    User findWithLoginNameAndPassword(@Param("loginname")String loginname,
                                      @Param("password") String password);
}
