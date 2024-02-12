package quiz_creator;

import java.io.FileNotFoundException;

public interface Examable {
    boolean createExam(Question questionList, int numOfQ) throws FileNotFoundException ;



}
