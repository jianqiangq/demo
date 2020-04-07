package com.qjq.demo.Service;

import com.qjq.demo.Model.Question;
import com.qjq.demo.Model.User;
import com.qjq.demo.dto.PaginationDto;
import com.qjq.demo.dto.QuestionDto;
import com.qjq.demo.mapper.QuestionMapper;
import com.qjq.demo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service 层是组装的作用（中间层），组装 mapper 返回的数据库模型对象

@Service // Service 注解后，Spring 会自动去管理它。
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDto list(Integer page, Integer size) {

        PaginationDto paginationDTO = new PaginationDto();

        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset, size);

        List<QuestionDto> questionDtoList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());

            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto); // BeanUtils：Spring 内置的方法。
                                                             // 快速把 question 对象上所有属性拷贝到 questionDto 对象。
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }

        paginationDTO.setQuestions(questionDtoList);

        return paginationDTO;

    }
}
