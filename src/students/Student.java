package students;
import java.util.List;
import java.util.Scanner;


public class Student implements StudentSevicesSchool {
    float id;
    String name;
    String gender;
    float age;
    float score;
    public Student(){}

    public float validate(String txt){
        Scanner cin = new Scanner(System.in);
        boolean isTrue = false;
        float num = 0;
        String numberStr;

        do {
            try {
                System.out.print(txt);
                numberStr = cin.nextLine();
                num = Float.parseFloat(numberStr);
                isTrue = true;
            }catch (Exception e){
                System.out.println("Please Input Your Number!!!");
                isTrue = false;
            }
        }while (!isTrue);

        return num;
    }

    public int menu(){
        System.out.println("--------------Student--------------");
        System.out.println("1. Insert Student To System");
        System.out.println("2. Edit Student Information");
        System.out.println("3. Search Student Information");
        System.out.println("4. Delete Student Information");
        System.out.println("5. Show Student Information");
        System.out.println("6. Exit");
        int choose = (int) validate("Enter Menu : ");
        return choose;
    }

    void input(Scanner cin){
        id = (int) validate("Enter ID : ");
        System.out.print("Enter Name  : ");
        name = cin.nextLine();
        System.out.print("Enter Gender : ");
        gender = cin.nextLine();
        age =(int)validate("Enter Age : ");
        score = validate( "Enter Score : ");
    }

    public Student(int id, String name, String gender, int age, float score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean insert(List<Student> arr) {
        Scanner cin = new Scanner(System.in);
        Student obj = new Student();
        obj.input(cin);
        arr.add(obj);
        if (arr.size() > 0){
            System.out.println("Successfully To Insert");
            return true;
        }else {
            System.out.println("Cannot Add Something else");
            return false;
        }
    }

    @Override
    public void update(List<Student> arr, int index) {
        Scanner cin = new Scanner(System.in);
        int c = 0;
        for(int i = 0; i < arr.size(); i++){
            if(index == arr.get(i).id){
                id = (int) arr.get(i).id;
                System.out.print("Enter New Name    : ");
                name = cin.nextLine();
                System.out.print("Enter New Gender  : ");
//                cin.nextLine();
                gender = cin.nextLine();
                age = (int) validate("Enter New Age   :");
                score = validate("Enter New Score : ");
                arr.set(i, new Student((int)id, name, gender, (int)age, score));
                c++;
            }
        }

        if (c>0){
            System.out.println("Successfully To Update");
        }else {
            System.out.println("Record Not Found Try Again!!!");
        }
    }

    @Override
    public void delete(List<Student> arr, int index) {
        int c = 0;
        for(int i = 0; i < arr.size(); i++){
            if(index == arr.get(i).id){
                arr.remove(i);
                c++;
            }
        }

        if (c>0){
            System.out.println("Successfully To Delete");
        }else {
            System.out.println("Record Not Found!!!");
        }

    }

    @Override
    public boolean search(List<Student> arr, int index) {
        boolean isFound;

        List<Student> newArr =  arr.stream().filter((p) -> p.id == index).toList();
        long l = newArr.size();

        if (l>0){
            System.out.println(l);
            List<Student> arrL = (List<Student>) newArr;
            for (Student student : arrL) {
                System.out.println(student);
            }
            isFound = true;
        }else {
            System.out.println("Recorded Not Found!!!!");
            isFound = false;
        }

        return isFound;
    }

    @Override
    public void show(List<Student> arr) {
        if (arr.size() > 0){
            System.out.println("----------------------");
            arr.forEach(
                    (obj) -> System.out.println(obj)
            );
            System.out.println("----------------------");
        }else {
            System.out.println("No Student Record Yet!!!");
        }
    }

}

