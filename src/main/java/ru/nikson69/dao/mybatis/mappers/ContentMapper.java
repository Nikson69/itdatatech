package ru.nikson69.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.nikson69.dao.ContentDao;
import ru.nikson69.model.Content;
import ru.nikson69.model.ContentSearchParametrs;

import java.util.List;

@EnableWebMvc
@Repository("contentDao")
public interface ContentMapper extends ContentDao {
    static final Logger logger = LoggerFactory.getLogger(ContentMapper.class);

    @Select("SELECT * FROM CONTENT " +
            "WHERE " +
            "((#{name} IS NULL) OR (locate(#{name},Name))) and " +
            "((#{description} IS NULL) OR (locate(#{description},Description))) and " +
            "((#{categories} IS NULL) OR (locate(concat('|',#{categories},'|'),Categories))) and " +
            "((#{createdBefore} IS NULL) OR (#{createdBefore} <= Created)) and " +
            "((#{createdAfter} IS NULL) OR (#{createdAfter} >= Created)) " +
            "ORDER BY Created DESC " +
             "LIMIT #{count} offset #{from}" )
    List<Content> findByParams(ContentSearchParametrs contentSearchParametrs);

    @Select("SELECT COUNT(*) FROM CONTENT " +
            "WHERE " +
            "((#{name} IS NULL) OR (locate(#{name},Name))) and " +
            "((#{description} IS NULL) OR (locate(#{description},Description))) and " +
            "((#{categories} IS NULL) OR (locate(concat('|',#{categories},'|'),Categories))) and " +
            "((#{createdBefore} IS NULL) OR (#{createdBefore} <= Created)) and " +
            "((#{createdAfter} IS NULL) OR (#{createdAfter} >= Created)) " +
            "ORDER BY Created DESC ")
   Integer countByParams(ContentSearchParametrs contentSearchParametrs);

    @Insert("INSERT INTO CONTENT" +
            " (Name, Description, Path, Categories)" +
            " VALUES" +
            " (#{name}, #{description}, #{path}, #{categories})")
    void saveContent(Content content);

    @Update("UPDATE CONTENT " +
            "SET " +
            "Name = #{name}, " +
            "Description = #{description}, " +
            "Path = #{path}, " +
            "Categories = #{categories} " +
            "WHERE id = #{id};")
    void updateContent(Content content);

    @Delete("DELETE FROM CONTENT WHERE id = #{id}")
    void deleteById(int id);

    @Select("SELECT * FROM CONTENT " +
            "WHERE id = #{id}")
    Content findById(int id);



}
