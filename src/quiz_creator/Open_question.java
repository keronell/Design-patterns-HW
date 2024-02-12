package quiz_creator;

public class Open_question extends Question{
	
	 //Class attributes
    private String question;                // - Question string
    private String correctAnswer;           // - Correct answer for open question

	   public Open_question(String question, String correctAnswer, DifficultyLevel difficultyLevel){  // - Open question constractor
	        super(difficultyLevel); 
	        setQuestion(question);                                  // - Set question                                             // - Sets question unic ID 
	        setAnswer(correctAnswer);                               // - Sets Answer to open question 
	        
	    }
	   
	    public void setQuestion(String question) {                  // - Set question function
	        this.question = question;
	    }

	    public void setAnswer(String answer) {                  // - Set question function
	        this.correctAnswer = answer;
	    }

	    public String getQuestion() {
	        return question;
	    }

		public String getAnswer() {
	        return correctAnswer;
	    }

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(question + "\n" + correctAnswer + "\n");
			return sb.toString();
		}

		public String toString(String test) {
			StringBuffer sb = new StringBuffer();
			sb.append(question +  " " +getQuestionID()+"\n_______________________________\n");
			return sb.toString(); 
		}
}
