import java.util.ArrayList;
import java.util.Scanner;

public class Projects {
    //TODO добавить проверку одинаковых названий проектов и выбор записывать их или нет

    private ArrayList<String> projects;
    private Scanner scanner;

    public Projects(){
        projects = new  ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public ArrayList<String> getProjects() {
        return projects;
    }

    public String getStoredProjectName(int projectnumber){
        return projects.get(projectnumber);
    }

    public int getProjectNumber(String projectname){
        int projectnumber = -1;
        for (int count = 0; count < projects.size(); count++){
            if (projectname.equals(projects.get(count))){
                projectnumber = count;
                return projectnumber;
            }
        }
        return projectnumber;
    }

    public String chooseProject(){
        int tempChooseNumber;
        boolean iscorrectnumber = false;
        do {
            showProjects();
            System.out.println("Выберите проект: ");
            tempChooseNumber = scanner.nextInt() - 1;
            if (tempChooseNumber >= projects.size() || tempChooseNumber <= -1){
                System.err.println("Неверный ввод.\n");
            } else {
                iscorrectnumber = true;
            }
        } while(!iscorrectnumber);
        return projects.get(tempChooseNumber);
    }

    public void add (){
        System.out.println("Введите название нового проекта: ");
        projects.add(scanner.nextLine());
    }

    public void showProjects(){
        if(projects.size() > 0){
            System.out.println("Список проектов:");
            for (int count = 1; count - 1 < projects.size();count++){
                System.out.println("\t" + count + ") " + projects.get(count-1));
            }
            System.out.println();
        } else {
            System.out.println("Список проектов пуст");
            add();
            showProjects();
        }

    }

    public void loadSavedData(ArrayList<String> projects){
        this.projects = projects;
    }
}
