import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Student {
  private int id;
  private String name;
  private String age;
  private String phone;
  private String email;
  private String activity_enrolled;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAge() {
    return age;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }


  public Student(String name, String age, String phone, String email) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
    this.activity_enrolled = activity_enrolled;
  }

  @Override
  public boolean equals(Object otherStudent) {
    if (!(otherStudent instanceof Student)) {
      return false;
    } else {
      Student newStudent = (Student) otherStudent;
      return this.getId() == newStudent.getId() &&
      this.getName().equals(newStudent.getName()) &&
      this.getAge().equals(newStudent.getAge()) &&
      this.getPhone().equals(newStudent.getPhone()) &&
      this.getEmail().equals(newStudent.getEmail()) &&
      this.getActivityEnrolled().equals(newStudent.getActivityEnrolled());

    }
  }
  public static List<Student> all() {
    String sql = "SELECT * FROM students ORDER BY name ASC";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Student.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO students(name,age,phone,email) VALUES (:name,:age,:phone,:email)";
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name",name)
      .addParameter("age",age)
      .addParameter("phone",phone)
      .addParameter("email",email)
      .addParameter("activity_enrolled")
      .executeUpdate()
      .getKey();
    }
  }

  public static Student find(int id) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM students where id = :id";
    Student student = con.createQuery(sql)
    .addParameter("id",id)
    .executeAndFetchFirst(Student.class);
    return student;
    }
  }
  public void delete(int id) {
    try(Connection con =DB.sql2o.open()) {
      String sql = "DELETE FROM students WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id",id)
      .executeUpdate();
    }
  }
  public void update(String name,String age, String phone,String email,String activity_enrolled) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE students SET name =:name, age =:age, phone =:phone, email =:email, activity_enrolled =:activity_enrolled WHERE id=:id";
      con.createQuery(sql)
      .addParameter("name",name)
      .addParameter("age",age)
      .addParameter("phone",phone)
      .addParameter("email",email)
      .addParameter("activity_enrolled",activity_enrolled)
      .executeUpdate();
      }
    }

    public void addActivity(Activity activity) {
      try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO students_activities (student_id,activity_id) VALUES (:student_id,:activity_id)";
      con.createQuery(sql)
      .addParameter("student_id",this.getId())
      .addParameter("activity_id",activity.getId())
      .executeUpdate();
      }
    }

    public List<Activity> getActivity() {
      try(Connection con = DB.sql2o.open()) {

      String sql = "SELECT activities .* FROM students JOIN students_activities ON (student.id = students_activities.student_id) JOIN activities ON (students_activities.activity_id = activity.id) WHERE students.id = :id ORDER BY name";
      return con.createQuery(sql)
      .addParameter("id",id)
      .executeAndFetch(Activity.class);
      }
    }

  }
