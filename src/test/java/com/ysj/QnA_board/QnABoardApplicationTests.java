package com.ysj.QnA_board;

import com.ysj.QnA_board.boundedContext.question.entity.Question;
import com.ysj.QnA_board.boundedContext.question.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class QnABoardApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;

	@BeforeEach
	public void beforeEach()
	{
		questionRepository.deleteAll();
		questionRepository.initAutoIncrement();

		questionRepository.save(Question.builder()
				.title("cookie")
				.content("질문1: cookie란 무엇인가요?")
				.build());

		questionRepository.save(Question.builder()
				.title("bean")
				.content("질문2: bean이란 무엇인가요?")
				.build());
	}

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

	@Test
	@DisplayName("findAll()")
	public void t2()
	{
		List<Question> questions = questionRepository.findAll();
		questions.forEach(question -> {
			System.out.println(question.getTitle());
			System.out.println(question.getContent());
			System.out.println(question.getCreateData());
		});
	}

	@Test
	@DisplayName("findBy()")
	public void t3()
	{
		Question question = questionRepository.findByTitle("cookie");

		System.out.println(question.getTitle());
		System.out.println(question.getContent());
		System.out.println(question.getCreateData());
	}

	@Test
	@DisplayName("findByLike()")
	public void t4()
	{
		Question question = questionRepository.findByTitleLike("coo%");

		System.out.println(question.getTitle());
		System.out.println(question.getContent());
		System.out.println(question.getCreateData());
	}

	@Test
	@DisplayName("데이터 수정")
	public void t5()
	{
		Optional<Question> questionOptional = questionRepository.findById(2);
		Question question;

		if(questionOptional.isPresent())
		{
			question = questionOptional.get();

			System.out.println(question.getTitle());
			System.out.println(question.getContent());
			System.out.println(question.getCreateData());

			question.setTitle("asdf");
			question.setContent("asdf");
			questionRepository.save(question);
		}
	}

	@Test
	@DisplayName("데이터 삭제")
	public void t6()
	{
		Optional<Question> questionOptional = questionRepository.findById(2);
		Question question;

		if(questionOptional.isPresent())
		{
			question = questionOptional.get();

			System.out.println(question.getTitle());
			System.out.println(question.getContent());
			System.out.println(question.getCreateData());

			questionRepository.delete(question);
		}
	}
}
