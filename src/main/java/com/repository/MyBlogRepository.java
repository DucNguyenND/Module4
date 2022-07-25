package com.repository;

import com.model.MyBlog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface MyBlogRepository extends PagingAndSortingRepository<MyBlog,Integer> {

}
