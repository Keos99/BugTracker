import java.util.ArrayList;

public class Data {
    //TODO добавить автоувеличение массива Data

    private Users users;
    private Projects projects;
    private Issues issues;
    private int[][] data;

    public Data(Users users, Projects projects, Issues issues) {
        this.users = users;
        this.projects = projects;
        this.issues = issues;
        data = new int[4][50];
    }

    public int[][] getData() {
        return data;
    }

    public void showData(){ //TODO переписать
        for (int count = 0; count < data[1].length; count++){
            int numbercount = count + 1;
            for (int count2 = 0; count2 < data.length; count2++){
                if (data[3][count] == 0) {
                  return;
                } else {
                    if (count2 == 0){
                        System.out.println("Вопрос № " + numbercount);
                        System.out.print("\tПользователь: " + users.getStorredName(data[count2][count]) + "\t");
                    } else if (count2 == 1) {
                        System.out.println("\tПроект: " + projects.getStoredProjectName(data[count2][count]));
                    } else if (count2 == 2) {
                        System.out.println("\tВопрос: \n\t" + issues.getStorredIssue(data[count2][count]));
                        System.out.println("\n");
                    }
                }
            }
        }
    }

    public void showData(ArrayList<Integer> linenumbers){
        for (int i = 0; i < linenumbers.size(); i++) {
            int numbercount = i + 1;
            System.out.println("Вопрос № " + numbercount);
            System.out.print("\tПользователь: " + users.getStorredName(data[0][linenumbers.get(i)]) + "\t");
            System.out.println("\tПроект: " + projects.getStoredProjectName(data[1][linenumbers.get(i)]));
            System.out.println("\tВопрос: \n\t" + issues.getStorredIssue(data[2][linenumbers.get(i)]));
            System.out.println("\n");
        }
    }

    public void addNote(int emptylinenumber){
        //TODO добавить отмену добавления записи
        data[0][emptylinenumber] = users.getUserNumber();
        data[1][emptylinenumber] = projects.getProjectNumber(projects.chooseProject());
        data[2][emptylinenumber] = issues.addIssue();
        data[3][emptylinenumber] = 1;
    }

    public int getNumberOfEmptyLine(){
        int emptyLineNumber = -1;
        for (int count = 0; count < data[3].length; count++){
            if (data[3][count] == 0){
                return emptyLineNumber = count;
            }
        }
        return emptyLineNumber;
    }

    public void loadSavedData(int [][] data) {
        this.data = data;
    }
}
