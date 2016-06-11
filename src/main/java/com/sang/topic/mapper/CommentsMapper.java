package com.sang.topic.mapper;

import com.sang.topic.model.Comments;

import java.util.List;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

    List<Comments> selectByPostId(Integer topicId);

    int selectCount();
}