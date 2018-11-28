import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Users users;
    private Projects projects;
    private Data data;
    private SaveLoadData saveLoadData;
    private Search search;
    private String tempchoose;
    private int choose;

    public Menu(Users users,Projects projects, Data data, SaveLoadData saveLoadData,Search search){
        this.scanner = new Scanner(System.in);
        this.users = users;
        this.projects = projects;
        this.data = data;
        this.saveLoadData = saveLoadData;
        this.search = search;
    }

    public int chooseMenu(){
        boolean iscorrectchoose;
        do {
            System.out.println("Введите пункт меню:");
            iscorrectchoose = true;
            tempchoose = scanner.nextLine();
            try {
                choose = Integer.parseInt(tempchoose);
            } catch (NumberFormatException e){
                iscorrectchoose = false;
                System.err.println("Возможен ввод только цифр!");
            }
        } while (!iscorrectchoose);
        return choose;
    }

    public void showMenu(){
        System.out.println("\t1. Пользователи.");
        System.out.println("\t2. Проекты.");
        System.out.println("\t3. Вопросоы.");
        System.out.println("\t4. Операции с данными.");
        System.out.println("\t5. Поиск");
        System.out.println("\t6. Выход");
        }

    public void showSubMenuUsers(){
        System.out.println("\t1. Сменить пользователя.");
        System.out.println("\t2. Добавить пользователя.");
        System.out.println("\t3. Список пользователей.");
        System.out.println("\t4. Назад.");
    }

    public void showSubMenuProjects(){
        System.out.println("\t1. Добавить проект.");
        System.out.println("\t2. Список проектов.");
        System.out.println("\t3. назад.");
    }

    public void showSubMenuIssues(){
        System.out.println("\t1. Добавить вопрос.");
        System.out.println("\t2. Список вопросов.");
        System.out.println("\t3. Назад.");
    }

    public void showSubMenuData(){
        System.out.println("\t1. Сохранить данные.");
        System.out.println("\t2. Загрузить данные.");
        System.out.println("\t3. Назад.");
    }

    public void menu(){
        while (true){
            showMenu();
            chooseMenu();
            switch(choose){
                case 1:
                    subMenuUsers();
                    break;
                case 2:
                    subMenuProjects();
                    break;
                case 3:
                    subMenuIssues();
                    break;
                case 4:
                    subMenuData();
                    break;
                case 5:
                    search.findIssuesByUserAndProject();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Неверный пункт меню! Повторите ввод!");
                    break;
            }
        }
    }

    public void subMenuUsers(){
        while (true){
            showSubMenuUsers();
            chooseMenu();
            switch (choose){
                case 1:
                    users.setName(users.chooseUser());
                    break;
                case 2:
                    users.addUser();
                    break;
                case 3:
                    users.showUsers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неверный пункт меню! Повторите ввод!");
                    break;
            }
        }
    }

    public void subMenuProjects(){
        while (true){
            showSubMenuProjects();
            chooseMenu();
            switch (choose){
                case 1:
                    projects.add();
                    break;
                case 2:
                    projects.showProjects();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Неверный пункт меню! Повторите ввод!");
                    break;
            }
        }
    }

    public void subMenuIssues(){
        while (true){
            showSubMenuIssues();
            chooseMenu();
            switch (choose){
                case 1:
                    data.addNote(data.getNumberOfEmptyLine());
                    break;
                case 2:
                    data.showData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Неверный пункт меню! Повторите ввод!");
                    break;
            }
        }
    }

    public void subMenuData(){
        while (true){
            showSubMenuData();
            chooseMenu();
            switch (choose){
                case 1:
                    try {
                        saveLoadData.saveDataToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        saveLoadData.loadDataFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Неверный пункт меню! Повторите ввод!");
                    break;
            }
        }
    }
}
