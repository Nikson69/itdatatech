package ru.nikson69.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ru.nikson69.dao.UserDao;
import ru.nikson69.model.User;
import ru.nikson69.model.UserProfile;

import java.util.List;
import java.util.Set;

@Repository("userDao")
public interface UserMapper extends UserDao {

    @Select("SELECT * FROM APP_USER WHERE id = #{id}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="ssoId", column="ssoid"),
            @Result(property="password", column="password"),
            @Result(property="userProfiles", javaType= Set.class, column="id",
                    many=@Many(select="getProfilesFor"))})
    User findById(int id);

    @Select("SELECT * FROM APP_USER WHERE ssoid = #{ssoId}")
    @Results(value = {
            @Result(property="id", column="id"),
            @Result(property="ssoId", column="ssoid"),
            @Result(property="password", column="password"),
            @Result(property="userProfiles", javaType= Set.class, column="id",
                    many=@Many(select="getProfilesFor"))})
    User findBySSO(String ssoId);

    @Select("SELECT * FROM APP_USER")
    List<User> findAllUsers();

    @Select("SELECT up.id as id,\n" +
            "up.type as type FROM\n" +
            " APP_USER_USER_PROFILE as uup,\n" +
            " USER_PROFILE as up\n" +
            "where\n" +
            "uup.user_profile_id = up.id\n" +
            "and uup.user_id = #{id}")
    Set<UserProfile> getProfilesFor(int id);


}
