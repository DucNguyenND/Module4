package com.repository;

import com.model.Comment;
import com.model.MyBlog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment,Integer> {
    List<Comment> findbyMyBlog(MyBlog myBlog);
}
