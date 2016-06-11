package com.sang.topic.admin.controller;

import com.sang.topic.service.CommentsService;
import com.sang.topic.util.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/admin/comments")
public class AdminCommentsController {
    CommentsService commentsService = new CommentsService();

    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView commentsIndex(Integer postId, Integer p){
        Page page = new Page();
        if(p != null) page.setCurrentPage(p);
        page.setUrl("comments?p=");

        Map map = new HashMap<String, Object>();
        map.put("comments", commentsService.getCommentsByPostIdAndPage(postId, page));
        map.put("page", page);
        return new ModelAndView("admin/comments/index", map);
    }

}