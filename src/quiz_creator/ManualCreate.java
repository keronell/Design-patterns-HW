package quiz_creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManualCreate implements Examable{

    @Override
    public boolean createExam(Question questionList, int numOfQ) throws FileNotFoundException  {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");  
		LocalDateTime now = LocalDateTime.now(); 

        File test = new File("test_"+dtf.format(now)+".txt");
        File solutions = new File("solution_"+dtf.format(now)+".txt");
        PrintWriter pwTest = new PrintWriter(test);
        PrintWriter pwSolutions = new PrintWriter(solutions);
        

            

            pwTest.println("Quiz:");
		    pwTest.println("Good Luck \n");
            pwSolutions.println("Quiz:");


//            for (int i = 0; i < qIndex.length; i++) {
//		        int tempNum = qIndex[i];
//                switch(((MultyChoice_Question) Question[tempNum]).getCorrectAnsCount()) {
//                    case 0:
//                    ((MultyChoice_Question) Question[tempNum]).setBooleanToFalse();
//                    QuizCreator.answers[DataBase.answersCounter] = "There is no correct answers.";
//                    ((MultyChoice_Question) Question[tempNum]).setAnswer(DataBase.answersCounter, true);
//
//                    DataBase.answersCounter++;
//                      break;
//                    case 1:
//                        break;
//                    default:{
//
//                    ((MultyChoice_Question) Question[tempNum]).setBooleanToFalse();
//                    QuizCreator.answers[DataBase.answersCounter] = "There is more than one correct answer.";
//                    ((MultyChoice_Question) Question[tempNum]).setAnswer(DataBase.answersCounter, true);
//                    DataBase.answersCounter++;}
//                }
//                    if(Question[tempNum] instanceof MultyChoice_Question){
//                        pwSolutions.print("[" +(i + 1) +"] " +((MultyChoice_Question) Question[tempNum]).toString());
//                        pwTest.print("[" +(i + 1) +"] " +((MultyChoice_Question) Question[tempNum]).toString("test"));
//
//                    } else{
//
//                        pwSolutions.print("[" +(i + 1) +"] " +((Open_question) Question[tempNum]).toString()+"\n");
//                        pwTest.print("[" +(i + 1) +"] " +((Open_question) Question[tempNum]).toString("test")+"\n");
//                    }
//                    pwSolutions.println("");
//                    pwTest.println("");
//            }
//
//        pwTest.close();
//        pwSolutions.close();
//        if(test.exists()&&solutions.exists())
//            return true;
//        else
            return false;
//
    }
//
}
