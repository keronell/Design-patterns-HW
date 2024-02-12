package quiz_creator;
public class ExceptionNumOfQ {
    public static final int MAX_Q_NUM = 10;
    
    public static int setNumOfQ(int qNum) throws Exception {
        if(qNum>MAX_Q_NUM)
            throw new Exception("Maximum number of questions is "+ MAX_Q_NUM +"!");
        else
         return qNum;
    }  
}
