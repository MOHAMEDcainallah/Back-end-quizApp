package com.exam.finkansawbolesfonctions.servicesdialquizz;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.tablesdiawli.tabledialquizz.LesQuestions;
import com.exam.tablesdiawli.tabledialquizz.Quiz;
import com.exam.fonctionsautomatique.QuestionRepository;
import com.exam.finkansawbolesfonctions.QuestionService;

@Service()
public class QuesServiceImpl implements QuestionService {

	@Autowired 
	private QuestionRepository questionRepository;
	@Override
	public LesQuestions addQuestion(LesQuestions question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public LesQuestions updateQuestion(LesQuestions question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Set<LesQuestions> getQuestions() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Set<LesQuestions> questionsOfQuiz(Quiz quiz) {
		
		return new HashSet<>(this.questionRepository.findByQuiz(quiz));
	}

	@Override
	public void deletequestion(Long quesId) throws Exception {
		LesQuestions question=this.questionRepository.findById(quesId).get();
		if(question==null) {
			throw new Exception("Question is not found please enter valid ques id");
		}
		this.questionRepository.deleteById(quesId);

	}

	@Override
	public LesQuestions getQuestionById(Long quesId) throws Exception {
		LesQuestions question=this.questionRepository.findById(quesId).get();
		if(question==null) {
			throw new Exception("Question is not found please enter valid ques id");
		}
		return question;
	}

}
