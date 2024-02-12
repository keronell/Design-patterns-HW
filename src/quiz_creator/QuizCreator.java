package quiz_creator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class QuizCreator {

    public static Scanner s = new Scanner(System.in);

    public static ArrayList<Question> questionList = new ArrayList<Question>();
    public static ArrayList<String> answersList = new ArrayList<String>();

    public static int aNum;                                // Answer number user choose
    public static int qNum;
    // Question number user choose





    public static int getInt() {                                // Checks input (loops till user input int)
        while (!s.hasNextInt()) {
            System.out.println("Invalid input, please enter a number!");
            s.nextLine();
        }
        return s.nextInt();
    }

    public static boolean getBoolean() {                        // Checks input (loops till user input boolean)
        while (!s.hasNextBoolean()) {
            System.out.println("Invalid input, please enter true or false: ");
            s.next();
        }
        return s.nextBoolean();
    }

    Iterator<Question> iterator = questionList.iterator();
    public void printQuestions() {
        Question question = null;
        while (iterator.hasNext()){
            question = iterator.next();
            System.out.println(question.toString());
        }
    }
    public static void printQuestionArrL() {                    // Function that print list of Questions and answers

        for (int i = 0; i < questionList.size(); i++)            // A loop that runs on the question array
            if (questionList.get(i) instanceof MultyChoice_Question)
                System.out.print("[" + (i + 1) + "] " + ((MultyChoice_Question) questionList.get(i)).toString());
            else
                System.out.print("[" + (i + 1) + "] " + ((Open_question) questionList.get(i)).toString() + "\n");
    }

    public static void printSpecificQuestion(int qNum) {    // A loop that prints specific question (works the same as the previous one)
        if (questionList.get(qNum) instanceof MultyChoice_Question)
            System.out.print("[" + (qNum + 1) + "] " + ((MultyChoice_Question) questionList.get(qNum)).toString());
        else
            System.out.print("[" + (qNum + 1) + "] " + ((Open_question) questionList.get(qNum)).toString() + "\n");

    }

    public static void addAnsToQuestion() {                            // Adding new answers to question
        printQuestionArrL();                                        // Prints a list of questions

        System.out.println("In which multy choice question you want to add answers:");

        qNum = getInt() - 1;                                        // Int of question that user want to edit

        for (int i = 0; i < answersList.size(); i++)
            System.out.println((i + 1) + "] " + answersList.get(i));      // Loop that print all answers from the answers box

        System.out.println("\nEnter number of answer you want to add: ");
        aNum = getInt() - 1;                                    // Int of answer that user wants to add


        System.out.println("Is this answer is true or false: ");
        ((MultyChoice_Question) questionList.get(qNum)).setAnswer(answersList.get(aNum), getBoolean());        // Place answer in question Class with boolean type

        System.out.println("Your question is: ");                // Prints edited question
        printSpecificQuestion(qNum);

    }

    public static void addQuestionToTray() {                            // Adding new question to tray
        System.out.println("Do you want to add:\n \n [1] Open Question. \n [2] Multiple choice question");
        if (getInt() == 1)
            aNum = 1;
        else
            aNum = 2;
        s.nextLine();
        System.out.println("Type question text you want to add: ");
        String userQ = s.nextLine();

        System.out.println("Enter the difficulty level (EASY, MEDIUM, HARD):");
        String difficultyInput = s.nextLine();
        while (!isValidDifficulty(difficultyInput)) {
            System.out.println("Invalid difficulty level. Please try again.");
            difficultyInput = s.nextLine();
            isValidDifficulty(difficultyInput);
        }
        Question.DifficultyLevel difficultyLevel = Question.DifficultyLevel.valueOf(difficultyInput.toUpperCase());
        if (aNum == 1) {
            System.out.println("Type answer for your question:");
            String ans = s.nextLine();
            questionList.add(new Open_question(userQ, ans, difficultyLevel));
        } else
            questionList.add(new MultyChoice_Question(userQ, difficultyLevel));
        System.out.println("Your question is: \n");

        System.out.println("\u001B[32m" + "  [" + (questionList.size()) + "] " + questionList.get((questionList.size() - 1)) + ":"
                + "\u001B[0m");


    }

    public static boolean isValidDifficulty(String input) {
        for (Question.DifficultyLevel difficulty : Question.DifficultyLevel.values()) {
            if (input.equalsIgnoreCase(difficulty.name())) {
                return true;
            }
        }
        return false;
    }

    public static void addAnsToTrayArrL() {                            // Adding new Answer to tray
        System.out.println("Type answer option you want to add to a tray");

        s.nextLine();
        String userA = s.nextLine();

        answersList.add(userA);


        for (int i = 0; i < answersList.size(); i++) {
            if (i == answersList.size() - 1)
                System.out.print("\u001B[32m");
            System.out.println((i + 1) + "] " + answersList.get(i));
        }
        System.out.println("\u001B[0m");

        System.out.println("Answer added successfully");

    }


    public static void editQuestionString() {                            // Edit question string from tray

        printQuestionArrL();


        System.out.println("Choose question you want to edit: ");
        qNum = getInt() - 1;
        //If user inputs wrong input
        // While loop starts till user input if right
        while (qNum >= questionList.size()) {
            System.out.println("Wrong input. There is only " + (questionList.size() - 1) + " questions!");
            System.out.println("Choose question you want to edit: ");
            qNum = getInt() - 1;
        }

        System.out.println("Now, enter an edited question: ");
        s.nextLine();
        String userQ = s.nextLine();


        if (questionList.get(qNum) instanceof MultyChoice_Question)
            ((MultyChoice_Question) questionList.get(qNum)).setQuestion(userQ);                    // Sets new String to the Multy choice question
        else
            ((Open_question) questionList.get(qNum)).setQuestion(userQ);                    // Sets new String to the Open question
        System.out.println("Your question now is: \n");

        printSpecificQuestion(qNum);

    }

    public static void editAnsString() {                            // Edit Answer from tray

        printQuestionArrL();
        System.out.println("Do you want to edit:\n \n [1] Open Question answer. \n [2] Multiple choice question answers");
        if (getInt() == 1)
            editAnsStringOpen();
        else
            editAnsStringMultyC();
    }

    public static void editAnsStringOpen() {

        for (int i = 0; i < questionList.size(); i++) {
            if (questionList.get(i) instanceof Open_question) {
                System.out.println("\n  [" + (i + 1) + "] " + questionList.get(i) + ":" + " (" + questionList.get(i).getDifficultyLevel() + " question)");
                System.out.println(((Open_question) questionList.get(i)).getAnswer() + ".");
            }
        }
        System.out.println("Choose Open question you want to edit: ");
        aNum = getInt() - 1;

        System.out.println("Now, enter an edited answer");
        s.nextLine();
        String userAnswer = s.nextLine();

        ((Open_question) questionList.get(aNum)).setAnswer(userAnswer);

        System.out.println("Your edited answer is: \n");

        printSpecificQuestion(aNum);
    }


    public static void editAnsStringMultyC() {
        for (int i = 0; i < answersList.size(); i++)
            System.out.println((i + 1) + "] " + answersList.get(i));

        System.out.println("Choose answer you want to change: ");
        aNum = getInt();

        System.out.println("Now, enter an edited answer");
        System.out.println("(New answer will change automatically in all related questions)");
        s.nextLine();
        String userAnswer = s.nextLine();

        answersList.set(aNum, userAnswer);

        System.out.println("Your edited answer is: \n");
        System.out.println((aNum + 1) + "] " + answersList.get(aNum));
    }

    public static void deleteAnsFromQuestion() {                            // Delete answer from question

        printQuestionArrL();

        System.out.println("Choose multy choice question where you want to delete an answer: ");

        qNum = getInt() - 1;

        while (questionList.get(qNum) instanceof Open_question) {
            System.out.println("You can only delete answers from Multy Choice questions!");

            System.out.println("Choose multy choice question where you want to delete an answer: ");
            qNum = getInt() - 1;
        }
        printSpecificQuestion(qNum);
        System.out.println("Choose answer you want to delete: ");

        aNum = getInt() - 1;
        while (aNum >= ((MultyChoice_Question) questionList.get(qNum)).getNumAnswers()) {
            System.out.println("Choose answer you want to delete: ");
            aNum = getInt() - 1;
        }

        ((MultyChoice_Question) questionList.get(qNum)).removeAnswer(aNum);

        System.out.println("Updated question is: ");

        printSpecificQuestion(qNum);

    }

    public static void deleteQuestion() {                            // Delete question from tray with all answers in it (links for answers)
        printQuestionArrL();
        System.out.println("Which question you want to delete?");

        qNum = getInt() - 1;

        questionList.remove(qNum);

        printQuestionArrL();
    }


    public static boolean createQuiz() throws FileNotFoundException {//Finally Quiz creating function

        System.out.println("| Do you want to create exam manualy or automatic?|");
        System.out.println("|[1] - Manual creation.                           |");
        System.out.println("|[2] - Automatic test creator 2000.               |");
        aNum = getInt();
        boolean isValidNumOfQ = false;
        while (!isValidNumOfQ) {
            System.out.println("How many questions do you want in your quiz?");
            try {
                qNum = ExceptionNumOfQ.setNumOfQ(getInt());
                isValidNumOfQ = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Question> quizQuestion = new ArrayList<Question>();
//                       // Creates a new array of questions (links to questions) for quiz
//        if (aNum == 2) {
//            AutomaticCreate acExam = new AutomaticCreate();
//            if (acExam.createExam(question, quizQuestion))
//                System.out.println("Exam created succesfully! ");
//            return acExam.createExam(question, quizQuestion);
//        }
//
//
//        printQuestionArrL();
//        System.out.println("Choose question from the tray you want to add: ");
//
//        for (int i = 0; i < qNum; i++) {                        // User start to fill quiz array with questions from the list
//            System.out.println("Choose question number " + (i + 1) + ": ");
//            aNum = getInt() - 1;
//            while (aNum - 1 >= questionList.size()) {
//                System.out.println("There is only " + questionList.size() + " questions (pick one that exists.)");
//                aNum = getInt() - 1;
//            }
//
//            quizQuestion[i] = aNum;
//        }
//
//        printQuiz(quizQuestion);
//        boolean testDone = false;                                // Additional menu for user to edit questions (can be removed)
//        System.out.println("Do you want to change/add answers in questions?");
//
//        while (!testDone) {
//            System.out.println("|[1] - Add new answers to exists question.   |");
//            System.out.println("|[2] - Edit answer.                          |");
//            System.out.println("|[3] - Delete answer from question.          |");
//            System.out.println("|[4] - Save and create Quiz file.            |");
//
//            switch (getInt()) {
//                case 1 -> QuizCreator.addAnsToQuestion();
//                case 2 -> QuizCreator.editAnsString();
//                case 3 -> QuizCreator.deleteAnsFromQuestion();
////                case 4 -> testDone = isTestOk(quizQuestion, testDone);
//                default -> System.out.println("INVALID INPUT");
//
//            }
//
//        }
//
//
//        ManualCreate mcExam = new ManualCreate();
//        if (mcExam.createExam(question, quizQuestion))
//            System.out.println("Exam created succesfully! ");
//        return (mcExam.createExam(question, quizQuestion));
//    }
//
//    public static boolean isTestOk(int[] quizQuestion, boolean testDone) {
//        while (!testDone) {
//            try {
//                for (int i = 0; i < quizQuestion.length; i++) {
//                    if (question[quizQuestion[i]] instanceof MultyChoice_Question)
//                        ExceptionNumOfAns.setNumOfQ(((MultyChoice_Question) question[quizQuestion[i]]).getAnsCount());
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                return false;
//            }
//            testDone = true;
//        }
        return true;
    }

    public static void printQuiz(int[] quizQuestion) {    // A function that prints the quiz before printing it in to file
//
//
//        for (int i = 0; i < quizQuestion.length; i++) {
//            int tempNum = quizQuestion[i];
//            if (question[tempNum] instanceof MultyChoice_Question)
//                System.out.print("[" + (i + 1) + "] " + ((MultyChoice_Question) question[tempNum]).toString());
//            else
//                System.out.print("[" + (i + 1) + "] " + ((Open_question) question[tempNum]).toString() + "\n");
//        }

    }


    public static boolean saveToFile(String fileName) throws IOException {
        File f = new File(fileName);
        ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(f));

        outFile.writeObject(questionList);
        outFile.writeObject(answersList);
        outFile.close();
        return false;
    }

    public static boolean readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File(fileName);
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(f));


        questionList = (ArrayList<Question>) inFile.readObject();
        answersList = (ArrayList<String>) inFile.readObject();
        inFile.close();


        for (int i = 0; i < answersList.size(); i++)
            if (answersList.get(i) == null) {
                answersList.remove(i);
                i--;

            }
        for (String i : answersList) {
            System.out.println(i);
        }
        return true;
    }


}
