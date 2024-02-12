package quiz_creator;

public class ExceptionNumOfAns {
    public static final int MIN_A_NUM = 3;
    public static boolean setNumOfQ(int numOfAns) throws Exception {
        if(numOfAns<MIN_A_NUM)
            throw new Exception("Minimum number of answers for question is "+ MIN_A_NUM +"! \nEdit one of questions to meet the necessary condition!");
        else
        return true;
    }   
}
