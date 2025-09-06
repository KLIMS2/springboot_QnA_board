package com.ysj.QnA_board.boundedContext.answer.entity;

import com.ysj.QnA_board.boundedContext.question.entity.Question;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Answer
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

  @ManyToOne
  private Question question;
}
