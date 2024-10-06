package org.example.service;

import org.example.article.ArticleApplication;
import org.example.article.po.Comment;
import org.example.article.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArticleApplication.class)
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;


    @Test
    public void testFindCommentList(){
        System.out.println(commentService.findCommentList());
    }

    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    @Test
    public void testFindCommentListByParentid(){
        System.out.println(commentService.findCommentListByParentid("3", 1, 2));
    }


    @Test
    public void testUpdateCommentLikenum(){
        System.err.println("-----");
        commentService.updateCommentLikenum("2");
        System.err.println("-----");
    }

}
