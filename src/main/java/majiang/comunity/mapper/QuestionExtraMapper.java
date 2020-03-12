package majiang.comunity.mapper;

import majiang.comunity.model.Question;
import majiang.comunity.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtraMapper {
    int incView(Question record);
}