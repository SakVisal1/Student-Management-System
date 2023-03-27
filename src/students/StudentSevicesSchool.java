package students;
import java.util.List;

public interface StudentSevicesSchool {
    boolean  insert(List<Student> arr);
    void update(List<Student> arr, int index);
    void delete(List<Student> arr, int index);
    boolean search(List<Student> arr, int a);
    void show(List<Student> arr);

}
