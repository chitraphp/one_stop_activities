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
      return con.createQuery(sql).executeAndFetch(Activity.class);
    }
  }

  @Override
  public boolean equals(Object otherActivity){
    if (!(otherActivity instanceof Activity)) {
      return false;
    } else {
      Activity newActivity = (Activity) otherActivity;
      return this.getName().equals(newActivity.getName()) &&
      return this.getDescription().equals(newActivity.getDescription());
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
      return Activity;
    }
  }

  public void addStudent(Student student) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO students_courses (student_id, course_id) VALUES (:student_id, :course_id)";
      con.createQuery(sql)
      .addParameter("student_id", student.getId())
      .addParameter("course_id", this.getId())
      .executeUpdate();
    }
  }

  public ArrayList<Student> getStudents() {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT student_id FROM students_courses WHERE course_id = :course_id";
      List<Integer> studentIds = con.createQuery(sql)
      .addParameter("course_id", this.getId())
      .executeAndFetch(Integer.class);

      ArrayList<Student> students = new ArrayList<Student>();

      for (Integer studentId : studentIds) {
        String studentQuery = "Select * From students WHERE id = :studentId";
        Student student = con.createQuery(studentQuery)
        .addParameter("studentId", studentId)
        .executeAndFetchFirst(Student.class);
        students.add(student);
      }
      return students;
    }
  }

  public void update(String activity_type) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE courses SET activity_type = :activity_type WHERE id = :id";
      con.createQuery(sql)
      .addParameter("activity_type", activity_type)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM courses WHERE id = :id;";
      con.createQuery(deleteQuery)
      .addParameter("id", id)
      .executeUpdate();

      String joinDeleteQuery = "DELETE FROM students_courses WHERE course_id = :courseId";
      con.createQuery(joinDeleteQuery)
      .addParameter("courseId", this.getId())
      .executeUpdate();
    }
  }
}
