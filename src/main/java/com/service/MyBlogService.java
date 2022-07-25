package com.service;

import com.model.MyBlog;
import com.repository.MyBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBlogService {
    @Autowired
    MyBlogRepository myBlogRepository;
    public Page<MyBlog> getall(Pageable pageable){
        return myBlogRepository.findAll(pageable);
    }
    public void save(MyBlog myBlog){
        myBlogRepository.save(myBlog);
    }
    public void delete(int id){
        myBlogRepository.deleteById(id);
    }
    public Optional<MyBlog> findBlogbyid(int id){
        return myBlogRepository.findById(id);
    }
}
