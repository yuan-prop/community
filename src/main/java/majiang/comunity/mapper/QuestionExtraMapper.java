package majiang.comunity.mapper;

import majiang.comunity.dto.QuestionQueryDTO;
import majiang.comunity.model.Question;

import java.util.List;

public interface QuestionExtraMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}