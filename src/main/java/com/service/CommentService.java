package com.service;

import com.model.Comment;
import com.model.MyBlog;
import com.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;
    public List<Comment> findCommentbyBlog(Optional<MyBlog> myBlog){
        return commentRepo.findbyMyBlog(myBlog);
    }
    public void saveCommnet(Comment comment){
        commentRepo.save(comment);
    }
}
