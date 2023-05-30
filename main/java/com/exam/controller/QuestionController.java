package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.tablesdiawli.Utilisateur;
import com.exam.tablesdiawli.tabledialquizz.QuizzLiDkhelt;
import com.exam.tablesdiawli.tabledialquizz.LesQuestions;
import com.exam.tablesdiawli.tabledialquizz.Quiz;
import com.exam.tablesdiawli.tabledialquizz.Scoring;
import com.exam.fonctionsautomatique.AttemptedQuizRepository;
import com.exam.fonctionsautomatique.UserRepository;
import com.exam.finkansawbolesfonctions.QuestionService;
import com.exam.finkansawbolesfonctions.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private AttemptedQuizRepository attemptedQuizRepo;
	
	@PostMapping(value="/add-questions",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LesQuestions> addQuestion(@RequestBody LesQuestions question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping(value="/update-questions",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LesQuestions> updateQuestion(@RequestBody LesQuestions question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<?> getAllQuestion(@PathVariable("quizId") Long quizId) throws Exception{
		Quiz quiz=this.quizService.getQuizById(quizId);
		Set<LesQuestions> question=quiz.getQuestion();
		List<LesQuestions> listOfQuestions=new ArrayList<>(question);
		if(listOfQuestions.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			listOfQuestions=listOfQuestions.subList(0,Integer.parseInt(quiz.getNumberOfQuestions())+1);
		}
		return ResponseEntity.ok(listOfQuestions);
	}
	
	@GetMapping("/admin/{quizId}")
	public ResponseEntity<?> getAllQuestionForAdmin(@PathVariable("quizId") Long quizId) throws Exception{
		System.out.println("quiz to be fetch with id :"+quizId);
		Quiz quiz=this.quizService.getQuizById(quizId);
		Set<LesQuestions> question=quiz.getQuestion();
		List<LesQuestions> listOfQuestions=new ArrayList<>(question);
		return ResponseEntity.ok(listOfQuestions);
	}
	
	@GetMapping("/ById/{quesId}")
	public LesQuestions getQuestion(@PathVariable("quesId") Long quesId) throws Exception {
		LesQuestions question=this.questionService.getQuestionById(quesId);
		System.out.println("Question content is:"+question.getContent());
		return this.questionService.getQuestionById(quesId);
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) throws Exception{
		this.questionService.deletequestion(quesId);
	}
	
	@PostMapping("/evaluate-quiz")
	public ResponseEntity<?> evaluateQuiz(@RequestBody List<LesQuestions> questions){
		System.out.println(questions);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		//set attempted quiz to specific user
		Utilisateur theUser=this.userRepository.findByUsername(username);
		QuizzLiDkhelt attemptedQuiz=new QuizzLiDkhelt();
	    attemptedQuiz.setUsername(username);
		Integer correctAnswers=0;
		double marksObtained = 0;
		Integer attempted=0;
		for(LesQuestions theQues:questions) {
			try {
				LesQuestions question=this.questionService.getQuestionById(theQues.getQuesId());
				//set specific question attended by user in his/her attempted quiz so it can access limited number of time to quiz
				if(theQues.getGivenAnswer().trim().equals(question.getAnswer().trim())) {
					correctAnswers=correctAnswers+1;
					attempted=attempted+1;
				}
				else {
					attempted=attempted+1;
				}
				double marksObtainedPerQuestion=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksObtained=correctAnswers*marksObtainedPerQuestion;
				//set a list to questions in users attempted quiz
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		Scoring result=new Scoring();
		
		result.setCorrectAnswers(correctAnswers);
		result.setAttempted(attempted);
		result.setMarksObtained(marksObtained);
		result.setQuestions(questions);
		
		return ResponseEntity.ok(result);
	}
	
	
	
	

}
