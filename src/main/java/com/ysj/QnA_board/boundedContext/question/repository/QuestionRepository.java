package com.ysj.QnA_board.boundedContext.question.repository;

import com.ysj.QnA_board.boundedContext.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface QuestionRepository extends JpaRepository<Question, Integer>
{
  @Modifying
  @Transactional
  @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1;", nativeQuery = true)
  void initAutoIncrement();

  Question findByTitle(String title);

  Question findByTitleLike(String titleLike);
}
