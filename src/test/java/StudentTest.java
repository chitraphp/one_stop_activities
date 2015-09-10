import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class StudentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Student.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Student firstStudent = new Student("chitra", 23, "503-789-3298", "xsa@gmail.com");
    Student secondStudent = new Student("chitra", 23, "503-789-3298", "xsa@gmail.com");
    assertTrue(firstStudent.equals(secondStudent));
  }

  @Test
  public void find_findsstudentInDatabase_true() {
    Student myStudent = new Student("chitra", 23, "503-789-3298", "xsa@gmail.com");
    myStudent.save();
    Student savedStudent = Student.find(myStudent.getId());
    assertTrue(myStudent.equals(savedStudent));
  }

  @Test
  public void addActivity_addsActivityToStudent() {
    Student myStudent = new Student("chitra", 23, "503-789-3298", "xsa@gmail.com");
    myStudent.save();

    Activity myFirstActivity = new Activity("swimming", "aaaaaaaaa");
    myFirstActivity.save();

    Activity mySecondActivity = new Activity("yoga", "yogaaaaaaaaaa");
    mySecondActivity.save();

    Teacher myFirstTeacher = new Teacher("teach1", "Quali1", "low", 10, 23.00,"loca1", 5, "2015-09-09", "2015-10-10", "12.00");
    myFirstTeacher.save();

    Teacher mySecondTeacher = new Teacher("teach2", "Quali2", "low", 10, 23.00,"loca2", 5, "2015-09-09", "2015-10-10", "12.00");
    mySecondTeacher.save();



    myStore.addBrand(myBrand);
    Brand savedBrand = myStore.getBrands().get(0);
    assertTrue(myStudentequals(savedBrand));
  }

  // @Test
  // public void getBrands_returnsAllBrands_ArrayList() {
  //   Brand myBrand = new Brand("Nike");
  //   myStudentsave();
  //
  //   Store myStore = new Store("Target");
  //   myStore.save();
  //
  //   myStore.addBrand(myBrand);
  //   List savedBrands = myStore.getBrands();
  //   assertEquals(savedBrands.size(), 1);
  // }

}
