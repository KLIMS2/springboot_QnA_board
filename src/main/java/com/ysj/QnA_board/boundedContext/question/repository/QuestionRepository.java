package com.ysj.QnA_board.boundedContext.question.repository;

import com.ysj.QnA_board.boundedContext.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>
{

}
