import java.io.*;

public class SaveLoadData implements Serializable {
    private Users users;
    private Projects projects;
    private Issues issues;
    private Data data;
    private DataForSave dataForSave;
    private File file;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public SaveLoadData (Users users, Projects projects, Issues issues, Data data, DataForSave dataForSave){
        this.users = users;
        this.projects = projects;
        this.issues = issues;
        this.data = data;
        this.dataForSave = dataForSave;
        this.file = new File("data.dat");
    }

    public void prepareDataForSaveToFile(){
        dataForSave.setUsersArrayList(users.getUsers());
        dataForSave.setProjectsArrayList(projects.getProjects());
        dataForSave.setIssuesArrayList(issues.getIssues());
        dataForSave.setStoreddata(data.getData());
    }

    public void loadSavedData(){
        users.loadSavedData(dataForSave.getUsersArrayList());
        projects.loadSavedData(dataForSave.getProjectsArrayList());
        issues.loadSavedData(dataForSave.getIssuesArrayList());
        data.loadSavedData(dataForSave.getStoreddata());
    }

    public void saveDataToFile() throws IOException {
        try {
            file.delete();
            out = new ObjectOutputStream(new FileOutputStream("data.dat"));
            prepareDataForSaveToFile();
            out.writeObject(dataForSave);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public void loadDataFromFile() throws IOException {
        try {
            in = new ObjectInputStream(new FileInputStream("data.dat"));
            dataForSave = (DataForSave) in.readObject();
            loadSavedData();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }


}
