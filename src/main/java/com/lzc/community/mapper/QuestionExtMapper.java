package com.lzc.community.mapper;

import com.lzc.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question Record);
}