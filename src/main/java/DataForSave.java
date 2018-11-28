import java.io.Serializable;
import java.util.ArrayList;

public class DataForSave implements Serializable {
    private int[][] storeddata;
    private ArrayList<String> usersArrayList;
    private ArrayList<String> projectsArrayList;
    private ArrayList<String> issuesArrayList;

    public int[][] getStoreddata() {
        return storeddata;
    }

    public void setStoreddata(int[][] storeddata) {
        this.storeddata = storeddata;
    }

    public ArrayList<String> getUsersArrayList() {
        return usersArrayList;
    }

    public void setUsersArrayList(ArrayList<String> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    public ArrayList<String> getProjectsArrayList() {
        return projectsArrayList;
    }

    public void setProjectsArrayList(ArrayList<String> projectsArrayList) {
        this.projectsArrayList = projectsArrayList;
    }

    public ArrayList<String> getIssuesArrayList() {
        return issuesArrayList;
    }

    public void setIssuesArrayList(ArrayList<String> issuesArrayList) {
        this.issuesArrayList = issuesArrayList;
    }
}
