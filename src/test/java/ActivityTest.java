import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ActivityTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  //Test whether the array is empty or nor
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Activity.all().size(), 0);
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
}
