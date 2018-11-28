import java.util.ArrayList;
import java.util.Scanner;

public class Issues {

    private StringBuilder issueTemp;
    private ArrayList<String> issues;
    Scanner scanner;

    public ArrayList<String> getIssues() {
        return issues;
    }

    public Issues (){
        issues  = new ArrayList<>();
        issueTemp = new StringBuilder();
        this.scanner = new Scanner(System.in);
    }

    public String getStorredIssue(int issuenumber){
        return issues.get(issuenumber);
    }

    public void loadSavedData(ArrayList<String> issues) {
        this.issues = issues;
    }

    public int addIssue (){
        issueTemp.delete(0,issueTemp.capacity());
        System.out.println("Введите Ваш вопрос:");
        issueTemp.append(scanner.nextLine());
        issues.add(issueTemp.toString());
        return getLineNumberOfIssue();
    }

    public int getLineNumberOfIssue (){
        int linenumberofissue = -1;
        for (int count = 0; count < issues.size(); count++){
            if (issues.get(count).equals(issueTemp.toString())){
                linenumberofissue = count;
                break;
            }
        }
        return linenumberofissue;
    }
}
