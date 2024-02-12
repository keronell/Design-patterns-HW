package quiz_creator;
import java.io.Serializable;

public abstract class Question  implements Serializable{
    
	   protected int questionID;
	   protected static int questionCounter;


	protected enum DifficultyLevel {EASY, NORMAL, HARD}
	   protected DifficultyLevel difficultyLevel;

	   public Question(DifficultyLevel difficultyLevel){
	    setDifficultyLevel(difficultyLevel);
	    setID();                                                    // - Sets question unic ID
	   }
	   
	   public static void setQuestionCounter(int qNum){
		questionCounter++;
	   }
	    public void setID(){
	        this.questionID = ++questionCounter;                      // - sets question ID number
                                     // - adds +1 to question counter
	    }
	    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
	        this.difficultyLevel = difficultyLevel;
	    }

	    public int getQuestionID() {
	     return this.questionID;
	    }

	    public abstract String getQuestion();

	    public DifficultyLevel getDifficultyLevel() {
	        return difficultyLevel;
	    }

	    public abstract String toString();

	    
	}