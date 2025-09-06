package com.ysj.QnA_board.boundedContext.answer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Answer
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}
