package quiz_creator;

import java.util.ArrayList;
import java.util.Iterator;

public class MultyChoice_Question extends Question {


    //Class attributes
    private String question;// - Question string

    public ArrayList<Answer> answersList = new ArrayList<>();



    public MultyChoice_Question(String question, DifficultyLevel difficultyLevel) {                       // - Multiple choise question constractor
        super(difficultyLevel);
        setQuestion(question);                                  // - Set question
    }


    public void setQuestion(String question) {                  // - Set question function
        this.question = question;
    }

    public void setAnswer(String answer, boolean type) {                  // - Set question function
        answersList.add(new Answer(answer, type));
    }

    public Iterator<Answer> getIterator() {
        return answersList.iterator(); // Return an iterator to the internal list
    }

    public Answer getAnswer(int index) {
        if (index < 0 || index >= answersList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return answersList.get(index);
    }
    public int getNumAnswers() {
        return answersList.size();
    }


    public void removeAnswer(int ansNum) {
        answersList.remove(ansNum);
    }



    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question: ").append(question).append("\n");
        int i = 1;
        for (Answer answer : answersList) {
            sb.append(i++).append(". ").append(answer).append("  [" +answer.getAnswerType() +"]"+"\n");
        }
        return sb.toString();
    }


//    @Override
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//
//        sb.append(question + " " +"ID: " +getQuestionID()+" \n");
//        int j = 0;
//
//        while(j<getAnsCount()){					// A loop that runs on the answers and prints only indexes
//            if (getFitAns(j) != 0) {			// that aren't 0
//                sb.append((j + 1) + ") " + QuizCreator.answers[getFitAns(j)] +" (" +getboolAnsType(j) +").\n");
//            }
//            j++;
//
//        }
//
//        sb.append("\n");
//    return sb.toString();
//    }
//
//    public String toString(String test) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(question +": \n");
//
//
//        int j = 0;
//        while(j<getAnsCount()){					// A loop that runs on the answers and prints only indexes
//            if (getFitAns(j) != 0) {			// that aren't 0
//            sb.append((j + 1) + ") " + QuizCreator.answers[getFitAns(j)] +".\n");
//            }
//            j++;
//
//        }
//
//        sb.append("\n");
//
//        return sb.toString();
//    }
//
//    public String toStringQ (){
//        StringBuffer sb = new StringBuffer();
//        sb.append(question +": \n");
//
//        return sb.toString();
//
//    }
}
