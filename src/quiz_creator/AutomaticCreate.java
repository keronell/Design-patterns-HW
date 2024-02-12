package quiz_creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AutomaticCreate implements Examable{

    @Override
    public boolean createExam( Question questionList, int numOfQ) throws FileNotFoundException {

//            int randomQ = (int) ((Math.random() * (QuizCreator.questionList.size()-1)) + 1);
//            int randomA = (int) ((Math.random() * (QuizCreator.answersList.size() - 1)) + 1);
//            boolean ansBoolean;
//            for (int i = 0; i < numOfQ; i++) {
//
//                    if(QuizCreator.questionList.get(randomQ) instanceof MultyChoice_Question)
//                            switch(((MultyChoice_Question) Question[randomQ]).getCorrectAnsCount()) {
//                            case 0:
//                            ((MultyChoice_Question) Question[randomQ]).setBooleanToFalse();
//                            QuizCreator.answers[DataBase.answersCounter] = "There is no correct answers.";
//                            ((MultyChoice_Question) Question[randomQ]).setAnswer(DataBase.answersCounter, true);
//
//                            DataBase.answersCounter++;
//                              break;
//                            case 1:
//                                break;
//                            default:{
//
//                            ((MultyChoice_Question) Question[randomQ]).setBooleanToFalse();
//                            QuizCreator.answers[DataBase.answersCounter] = "There is more than one correct answer.";
//                            ((MultyChoice_Question) Question[randomQ]).setAnswer(DataBase.answersCounter, true);
//                            DataBase.answersCounter++;}
//                }
//                    randomQ = (int) ((Math.random() * (QuizCreator.questionCounter - 1)) + 1);
//                    for(int t=0;t<questionNum;t++)
//                        if(qIndex[t] ==randomQ){
//                            randomQ = (int) ((Math.random() * (QuizCreator.questionCounter - 1)) + 1);
//                            t=0;
//                        }
//
//            }
//
//            return printExam(Question,qIndex);
        return false;

    }
    public boolean printExam( Question [] Question, int []qIndex) throws FileNotFoundException {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");  
		LocalDateTime now = LocalDateTime.now(); 

        File test = new File("test_"+dtf.format(now)+".txt");
        File solutions = new File("solution_"+dtf.format(now)+".txt");
        PrintWriter pwTest = new PrintWriter(test);
        PrintWriter pwSolutions = new PrintWriter(solutions);

        pwTest.println("Quiz:");
        pwTest.println("Good Luck \n");
        pwSolutions.println("Quiz:");

//        for (int i = 0; i < qIndex.length; i++) {
//            int tempNum = qIndex[i];
//                if(Question[tempNum] instanceof MultyChoice_Question){
//                    pwSolutions.print("[" +(i + 1) +"] " +((MultyChoice_Question) Question[tempNum]).toString());
//                    pwTest.print("[" +(i + 1) +"] " +((MultyChoice_Question) Question[tempNum]).toString("test"));
//
//                } else{
//
//                    pwSolutions.print("[" +(i + 1) +"] " +((Open_question) Question[tempNum]).toString()+"\n");
//                    pwTest.print("[" +(i + 1) +"] " +((Open_question) Question[tempNum]).toString("test")+"\n");
//                }
//                pwSolutions.println("");
//                pwTest.println("");
//        }

        pwTest.close();                                                                                                    
        pwSolutions.close();

        if(test.exists()&&solutions.exists())
            return true;
        else
            return false;    
    }

}
