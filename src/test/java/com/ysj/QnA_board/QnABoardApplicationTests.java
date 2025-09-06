package com.ysj.QnA_board;

import com.ysj.QnA_board.boundedContext.question.entity.Question;
import com.ysj.QnA_board.boundedContext.question.repository.QuestionRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class QnABoardApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	@DisplayName("데이터 생성")
	public void t1()
	{
		Question question = Question.builder()
				.title("question1")
				.content("content1")
				.build();

		questionRepository.save(question);
	}

}
