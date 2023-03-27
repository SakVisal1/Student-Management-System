package students;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> arr = new ArrayList<>();
        Student obj = new Student();

        int choose;
        do {
            choose = obj.menu();

            switch (choose){
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("-------Insert Student---------");
                    obj.insert(arr);
                }
                case 2 -> {
                    System.out.println("------------------------");
                    System.out.println("------Edit Student--------");

                    if (arr.size() > 0){
                        int update = (int) obj.validate("Enter ID To Any Update : ");
                        obj.update(arr,update);
                    }else {
                        System.out.println("No Student Recorded Yet!!!!!");
                    }
                }
                case 3 -> {
                    System.out.println("----------------------");
                    System.out.println("----------Search Student-------");

                    if (arr.size() > 0){
                        int id = (int) obj.validate("Enter ID To Search Here ::: ");
                        obj.search(arr,id);
                    }else {
                        System.out.println("No Student Recorded Yet!!!");
                    }
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("-----------Delete Student----------");

                    if (arr.size() > 0){
                        int index = (int) obj.validate("Enter ID To Delete ::: ");
                        obj.delete(arr,index);
                        System.out.println("valued of index is : "+index);



                    }else {
                        System.out.println("No Student Recorded Yet!!!");
                    }

                }
                case 5 -> {
                    System.out.println("----------------------");
                    System.out.println("-------Show Student---------");
                    obj.show(arr);
                }
                case 6 -> {}
                default -> System.out.println("Invalid Chosen Sorry !!!!!!!!!");
            }
        }while ( choose != 6);

    }
    }
