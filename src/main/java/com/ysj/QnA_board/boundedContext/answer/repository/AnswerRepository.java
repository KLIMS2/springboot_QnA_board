package com.ysj.QnA_board.boundedContext.answer.repository;

import com.ysj.QnA_board.boundedContext.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer>
{

}
