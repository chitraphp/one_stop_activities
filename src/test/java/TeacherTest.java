import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TeacherTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  //Test whether the array is empty or nor
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Teacher.all().size(), 0);
  }

  //Test for override objects
  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Activity firstActivity = new Activity("Yoga","union of the individual consciousness");
    Activity secondActivity = new Activity("Yoga","union of the individual consciousness");
    assertTrue(firstActivity.equals(secondActivity));
  }

  @Test
  public void save_savesObjectIntoDatabase() {
    Activity myActivity = new Activity ("Yoga","union of the individual consciousness");
    myActivity.save();
    assertEquals(myActivity.all().get(0),myActivity);
  }

  @Test
  public void getId_returnsCorrectId() {
    Activity myActivity = new Activity("Yoga","union of the individual consciousness");
    myActivity.save();
    assertEquals(Activity.all().get(0).getId(),myActivity.getId());
  }

  @Test
  public void find_returnsCorrectActivity() {
    Activity myActivity = new Activity ("Yoga","union of the individual consciousness");
    myActivity.save();
    Activity savedActivity = Activity.find(myActivity.getId());
    assertEquals(myActivity,savedActivity);
  }

  @Test
   public void delete_deletesFromDatabase() {
     Activity myActivity = new Activity("Yoga","union of the individual consciousness");
     myActivity.save();
     myActivity.delete();
     assertEquals(Activity.all().size(), 0);
   }


   @Test
    public void getAllStudents() {
      Student myStudent = new Student("chitra", 23, "503-789-3298", "xsa@gmail.com");
      myStudent.save();

      Student mySecondStudent = new Student("chitra2", 29, "503-789-3298", "mnba@gmail.com");
      mySecondStudent.save();


      Activity myFirstActivity = new Activity("swimming", "aaaaaaaaa");
      myFirstActivity.save();

      Activity mySecondActivity = new Activity("yoga", "yogaaaaaaaaaa");
      mySecondActivity.save();

      Teacher myFirstTeacher = new Teacher("teach1", "Quali1", "low", 10, 23.00,"loca1", 5, "2015-09-09", "2015-10-10", "12.00");
      myFirstTeacher.save();

      Teacher mySecondTeacher = new Teacher("teach2", "Quali2", "low", 10, 23.00,"loca2", 5, "2015-09-09", "2015-10-10", "12.00");
      mySecondTeacher.save();

      myStudent.addActivity(myFirstActivity,myFirstTeacher);
      myStudent.addActivity(mySecondActivity,mySecondTeacher);
      mySecondStudent.addActivity(myFirstActivity,myFirstTeacher);
      Integer i = 2;
      assertEquals(i, myFirstTeacher.availableSeats());
    }



}
