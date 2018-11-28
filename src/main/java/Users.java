import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    //TODO Добавить выбор для записи одинаковых имен
    //TODO Добавить обработчик пользователей с одинаковыми именами

    private String name;
    private String tempname;
    private ArrayList<String> users;

    private Scanner scannerLine;
    private Scanner scannerInt;
    String flush;

    public Users(){
        users = new ArrayList<>();
        this.scannerLine = new Scanner(System.in);
        this.scannerInt = new Scanner(System.in);
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public String getStorredName(int usernumber){
        return users.get(usernumber);
    }

    public int getUserNumber(){
        int userNumber = -1;
        for (int count = 0;count < users.size();count++){
            if (name.equals(users.get(count))){
                userNumber = count;
                break;
            }
        }
        return userNumber;
    }

    public int getUserNumber(String username){
        int userNumber = -1;
        for (int count = 0;count < users.size();count++){
            if (username.equals(users.get(count))){
                userNumber = count;
                break;
            }
        }
        return userNumber;
    }

    public String chooseUser (){
        int tempChooseNumber = 0;
        boolean iscorrectnumber = false;
        do {
            showUsers();
            System.out.println("Выберите пользователя:");
            tempChooseNumber = scannerInt.nextInt() - 1;
            if (tempChooseNumber >= users.size() || tempChooseNumber <= -1){
                System.out.println("Неверный ввод.\n");
            } else {
                iscorrectnumber = true;
            }
        } while(!iscorrectnumber);

        return users.get(tempChooseNumber);
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Добро пожаловать в BugTracker " + this.name + "!");
    }

    public void addUser(){
        System.out.println("Введите имя пользователя");
        String tempname = scannerLine.nextLine();
        users.add(tempname);
    }

    public void addUser(String name){
        users.add(name);
    }

    public void userVerification() throws IOException {
        System.out.println("Введите имя:");
        tempname = scannerLine.nextLine();
        if (isRegisterd()){
            setName(tempname);
        } else {
            addUser(tempname);
            setName(tempname);
        }
        System.out.println();
    }

    public void showUsers(){
        System.out.println("Зарегестрированные пользователи:");
        for (String temp : users) {
            System.out.println("\t" + temp);
        }
        System.out.println();
    }

    public boolean isRegisterd(){
        boolean isregistered = false;
        for (int i = 0; i < users.size(); i++) {
            if (tempname.equals(users.get(i))){
                isregistered = true;
            }
        }
        return isregistered;
    }

    public void loadSavedData(ArrayList<String> users){
        this.users = users;
    }

}