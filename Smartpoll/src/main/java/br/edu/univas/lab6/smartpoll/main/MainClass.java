package br.edu.univas.lab6.smartpoll.main;

import java.util.ArrayList;
import java.util.List;

import br.edu.univas.lab6.smartpoll.entity.Question;
import br.edu.univas.lab6.smartpoll.entity.User;
import br.edu.univas.lab6.smartpoll.managers.SimpleEntityManager;
import br.edu.univas.lab6.smartpoll.service.UserService;

public class MainClass {

	public static void main(String[] args) {

		List<Question> questions = new ArrayList<Question>();

		SimpleEntityManager simpleEntityManager = new SimpleEntityManager();

		/*QuestionService questionService = new QuestionService(
				simpleEntityManager);

		questions = questionService.findByMonthVote(12);

		System.out.println(questions.size());
		for (Question question : questions) {
			System.out.println(question.getTitle());
			System.out.println(question.getResults().size());

		}
   */
		System.out.println();
		
		UserService service = new UserService(simpleEntityManager);
		User user = service.findByEmailPassword("tscodeler@gmail.com", "camila");
		
		System.out.println(user.getName());

		simpleEntityManager.close();
	}
}
