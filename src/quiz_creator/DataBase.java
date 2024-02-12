package quiz_creator;
	import java.util.Scanner;

	public class DataBase {

		public static  void questionBox() {						// Question tray
			// Question 1
			Question q1 = new MultyChoice_Question("What is the largest country in the world by land area?",Question.DifficultyLevel.HARD);

			((MultyChoice_Question)q1).setAnswer("Paris", true);
			((MultyChoice_Question)q1).setAnswer("Berlin", false);
			((MultyChoice_Question)q1).setAnswer("London", false);
			QuizCreator.questionList.add(q1);



			Question q2 = new MultyChoice_Question("What is the optimal temperature for teaching?", Question.DifficultyLevel.HARD );
			//Answers of the 1 question (Link to answers array and is answers true or false)
			((MultyChoice_Question)q2).setAnswer("Mumu", true);
			((MultyChoice_Question)q2).setAnswer("Momo", true);
			((MultyChoice_Question)q2).setAnswer("Koko", false);
			QuizCreator.questionList.add(q2);

			// Question 2
			Question q3 = new MultyChoice_Question("What is the best language?",Question.DifficultyLevel.EASY);
			//Answers of the 2 question (Link to answers array and is answers true or false)
			((MultyChoice_Question)q3).setAnswer("Language of love", true);
			((MultyChoice_Question)q3).setAnswer("C++", false);
			((MultyChoice_Question)q3).setAnswer("Ram 64", false);
			((MultyChoice_Question)q3).setAnswer("Rahel", false);
			QuizCreator.questionList.add(q3);

			// Question 3
			Question q4 = new MultyChoice_Question("Best name?",Question.DifficultyLevel.NORMAL);
			//Answers of the 3 question (Link to answers array and is answers true or false)
			((MultyChoice_Question)q4).setAnswer("Rak", false);
			((MultyChoice_Question)q4).setAnswer("Tami 4", false);
			((MultyChoice_Question)q4).setAnswer("Ezekiel", false);
			((MultyChoice_Question)q4).setAnswer("Your", true);
			QuizCreator.questionList.add(q4);
			// Question 4
			Question q5 = new MultyChoice_Question("1+1?",Question.DifficultyLevel.EASY);
			//Answers of the 4 question (Link to answers array and is answers true or false)
			((MultyChoice_Question)q5).setAnswer("1", true);
			((MultyChoice_Question)q5).setAnswer("Ratatui", false);
			((MultyChoice_Question)q5).setAnswer("tratata", false);
			((MultyChoice_Question)q5).setAnswer("omg its godzilla", true);
			((MultyChoice_Question)q5).setAnswer("8 but turn it 90 degree left", false);
			((MultyChoice_Question)q5).setAnswer("100% oiler", false);
			((MultyChoice_Question)q5).setAnswer("Oiler", false);
			((MultyChoice_Question)q5).setAnswer("24", false);
			((MultyChoice_Question)q5).setAnswer("2", true);
			QuizCreator.questionList.add(q5);

			// Question 5
			Question q6 = new MultyChoice_Question("2+1?",Question.DifficultyLevel.HARD);
			//Answers of the 5 question (Link to answers array and is answers true or false)
			((MultyChoice_Question)q6).setAnswer("88", true);
			((MultyChoice_Question)q6).setAnswer("45", false);
			((MultyChoice_Question)q6).setAnswer("4", false);
			((MultyChoice_Question)q6).setAnswer("3", true);
			QuizCreator.questionList.add(q6);

			// Answers box

			QuizCreator.answersList.add("Yes! Yes! Yes!");
			QuizCreator.answersList.add("No! No! No!");
			QuizCreator.answersList.add("15");
			QuizCreator.answersList.add("Im, calling the police!");
			QuizCreator.answersList.add("911");
			QuizCreator.answersList.add("Strange");
			QuizCreator.answersList.add("Silence");



			// Question 11 (Open question)
			QuizCreator.questionList.add(new Open_question("What is the color of the sun?", "White",Question.DifficultyLevel.NORMAL));

			// Question 12 (Open question)
			QuizCreator.questionList.add(new Open_question("Is it possible to work and study?", "Everything is possible if you believe in yourself",Question.DifficultyLevel.EASY));

			// Question 13 (Open question)
			QuizCreator.questionList.add(new Open_question("Who let the dogs out?","Who, who, who, who, who?",Question.DifficultyLevel.HARD));

		}

		
	}

