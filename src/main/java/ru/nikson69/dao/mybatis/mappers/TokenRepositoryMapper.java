package ru.nikson69.dao.mybatis.mappers;

import org.apache.ibatis.annotations.*;
import ru.nikson69.model.PersistentLogin;

import java.util.Date;

public interface TokenRepositoryMapper {

    @Insert("INSERT INTO PERSISTENT_LOGINS" +
            " (series, username, token, last_used)" +
            " VALUES" +
            " (#{series}, #{username}, #{token}, #{last_used})")
    void createNewToken(PersistentLogin persistentLogin);

    @Update("UPDATE PERSISTENT_LOGINS" +
            " SET" +
            " token = #{token},last_used = #{date}" +
            " WHERE" +
            " series = #{series}")
    void updateToken(@Param("series") String series, @Param("token") String token, @Param("date") Date date);

    @Select("SELECT username, series, token, last_used " +
            " FROM PERSISTENT_LOGINS" +
            " WHERE " +
            " series = #{series}")
    @Results(value = {
            @Result(property="username", column = "username"),
            @Result(property="series", column = "series"),
            @Result(property="token", column = "token"),
            @Result(property="last_used", column = "last_used")
    })
    PersistentLogin getTokenForSeries(@Param("series") String series);


    @Delete("DELETE from PERSISTENT_LOGINS WHERE username = #{username}")
    void removeUserTokens(@Param("username")String username);

}