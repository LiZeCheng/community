package com.lzc.community.service;

import com.lzc.community.dto.QuestionDTO;
import com.lzc.community.mapper.QuestionMapper;
import com.lzc.community.mapper.UserMapper;
import com.lzc.community.model.Question;
import com.lzc.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> qquestionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator()); //这里要注意Mybatis的驼峰处理。
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            qquestionDTOList.add(questionDTO);
        }
        return qquestionDTOList;
    }
}
