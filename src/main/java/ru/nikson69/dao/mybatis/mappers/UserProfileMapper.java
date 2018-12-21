package ru.nikson69.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ru.nikson69.dao.UserProfileDao;
import ru.nikson69.model.UserProfile;

import java.util.List;

@Repository("userProfileDao")
public interface UserProfileMapper extends UserProfileDao {
    String findById = "SELECT * FROM USER_PROFILE WHERE id = #{id}";

    @Select(findById)
    UserProfile findById(int id);

    @Select("SELECT * FROM USER_PROFILE WHERE type = #{type}")
    UserProfile findByType(String type) ;

    @Select("SELECT type FROM USER_PROFILE ORDER BY type ASC")
    List<UserProfile> findAll();

}
