package com.ysj.QnA_board.boundedContext.question.entity;

import com.ysj.QnA_board.boundedContext.answer.entity.Answer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Question
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 256)
  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createData;

  @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
  private List<Answer> answers = new ArrayList<>();
}