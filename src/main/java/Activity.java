import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Activity {
  private int id;
  private String activity_type;
  private String description;

  public int getId() {
    return id;
  }

  public String getName() {
    return activity_type;
  }

  public String getDescription() {
    return description;
  }

  public Activity(String activity_type,String description) {
    this.activity_type = activity_type;
    this.description = description;
  }

  public static List<Activity> all() {
    String sql = "SELECT * FROM activities";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Activity.class);
    }
  }

  @Override
  public boolean equals(Object otherActivity){
    if (!(otherActivity instanceof Activity)) {
      return false;
    } else {
      Activity newActivity = (Activity) otherActivity;
      return this.getId() == newActivity.getId() &&
      this.getName().equals(newActivity.getName()) &&
      this.getDescription().equals(newActivity.getDescription());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO activities(activity_type,description) VALUES (:activity_type,:description)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("activity_type", this.activity_type)
      .addParameter("description", this.description)
      .executeUpdate()
      .getKey();
    }
  }

  public static Activity find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM activities WHERE id=:id";
      Activity activity = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Activity.class);
      return activity;
    }
  }

  public void update(String activity_type,String description) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE activities SET (activity_type = :activity_type,description =:description) WHERE id = :id";
      con.createQuery(sql)
      .addParameter("description",description)
      .addParameter("activity_type", activity_type)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM activities WHERE id = :id;";
      con.createQuery(deleteQuery)
      .addParameter("id", id)
      .executeUpdate();

      String joinDeleteQuery = "DELETE FROM students_teachers_activities WHERE activity_id = :activityId";
      con.createQuery(joinDeleteQuery)
      .addParameter("activityId", this.getId())
      .executeUpdate();
    }
  }
}
