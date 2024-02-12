package quiz_creator;

public class Answer
{
    protected String answerStr;
    protected boolean answerType;

    public Answer(String answerStr, boolean answerType){
        setAnswerStr(answerStr);
        setAnswerType(answerType);
    }
    public void setAnswerStr(String answerStr){
        this.answerStr = answerStr;
    }
    public void setAnswerType(boolean answerType){
        this.answerType = answerType;
    }

    public String getAnswerStr() {
        return this.answerStr;
    }

    public boolean getAnswerType(){
        return this.answerType;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(answerStr);
        return sb.toString();
    }

}
