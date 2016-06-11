package com.sang.topic.web.controller;

import com.sang.topic.model.Comments;
import com.sang.topic.model.User;
import com.sang.topic.service.CommentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentsController {
    CommentsService commentsService = new CommentsService();

    @RequestMapping(value = "/c", method = RequestMethod.POST)
    public Map<String, Object> create(Comments comments, HttpSession httpSession){
        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String message = "";
        User user = (User) httpSession.getAttribute("sessionUser");
        if(user != null) {
            comments.setUserId(user.getId());
            int n = commentsService.insert(comments);
            if (n > 0)
                success = true;
            else message = "回复失败";
        }else{
            message = "请登录后再回复";
        }
        resultMap.put("success", success);
        resultMap.put("message", message);
        return resultMap;
    }
}