import java.io.IOException;

public class BugTracker {
    private Users users;
    private Projects projects;
    private Issues issues;
    private Data data;
    private DataForSave dataForSave;
    private SaveLoadData saveLoadData;
    private Search search;
    private Menu menu;

    public BugTracker(){
        this.users = new Users();
        this.projects = new Projects();
        this.issues = new Issues();
        this.dataForSave = new DataForSave();
        this.data = new Data(users,projects,issues);
        this.saveLoadData = new SaveLoadData(users,projects,issues,data,dataForSave);
        this.search = new Search(users,projects,data,issues);
        this.menu = new Menu(users,projects,data,saveLoadData,search);
    }

    public void start(){
        try {
            users.userVerification();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu.menu();
    }
}
