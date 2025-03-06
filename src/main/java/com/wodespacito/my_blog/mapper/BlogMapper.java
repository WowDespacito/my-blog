package com.wodespacito.my_blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wodespacito.my_blog.pojo.Blog;
import com.wodespacito.my_blog.pojo.BlogListItem;

@Mapper
public interface BlogMapper {
    /**
     * 动态查询博客列表
     * @param status 博客状态，null 时查询所有博客
     * @return 博客列表
     */
    List<BlogListItem> getBlogList(Integer status);
    
    /**
     * 根据 ID 查询博客详情
     * @param id 博客 ID
     * @return 博客详情
     */
    @Select("SELECT * FROM data_blog WHERE id = #{id}")
    Blog getBlogDetail(Integer id);

    /**
     * 添加新博客
     * @param blog 博客对象
     */
    @Insert("INSERT INTO data_blog(title, content, author, create_time, update_time, status) VALUES(#{title}, #{content}, #{author}, #{createTime}, #{updateTime}, #{status})")
    void addBlog(Blog blog);

    /**
     * 更新博客
     * @param blog 博客对象
     */
    @Update("UPDATE data_blog SET title = #{title}, content = #{content}, updateTime = #{updateTime} WHERE id = #{id}")
    void updateBlog(Blog blog);

    /**
     * 删除博客（逻辑删除，将状态设置为 -1）
     * @param id 博客 ID
     */
    @Update("UPDATE data_blog SET status = -1 WHERE id = #{id}")
    void deleteBlog(Integer id);
}
