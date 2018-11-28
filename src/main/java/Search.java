import java.util.ArrayList;

public class Search {
    private Users users;
    private Projects projects;
    private Issues issues;
    private Data bugdata;
    private ArrayList<Integer> tempdata;
    private int[][] data;

    private int usernumber;
    private int projectnumber;

    public Search(Users users, Projects projects, Data data,Issues issues){
        usernumber = 0;
        projectnumber = 0;
        this.users = users;
        this.projects = projects;
        this.issues = issues;
        this.bugdata = data;
        tempdata = new ArrayList<>();
    }

    public void findIssuesByUserAndProject(){
        if (issues.getIssues().size() != 0){
            this.data = bugdata.getData();
            usernumber = users.getUserNumber(users.chooseUser());
            projectnumber = projects.getProjectNumber(projects.chooseProject());

            if (data != null){
                for (int i = 0; i < data[1].length; i++) {
                    if (data[0][i] == usernumber && data[1][i] == projectnumber && data[3][i] == 1) {
                        tempdata.add(i);
                    }
                }
            }
            if (tempdata.size() != 0){
                bugdata.showData(tempdata);
                tempdata.clear();
            } else {
                System.out.println("Записей не найдено!");
            }
        } else {
            System.out.println("Вопросы еще никто не добавлял.");
            System.out.println("Поиск прерван!\n");
        }
    }
}
