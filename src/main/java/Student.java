import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Student {
  private int id;
  private String name;
  private int age;
  private String phone;
  private String email;


  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }


  public Student(String name, int age, String phone, String email) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  @Override
  public boolean equals(Object otherStudent) {
    if (!(otherStudent instanceof Student)) {
      return false;
    } else {
      Student newStudent = (Student) otherStudent;
      return this.getId() == newStudent.getId() &&
      this.getName().equals(newStudent.getName()) &&
      this.getAge() == newStudent.getAge() &&
      this.getPhone().equals(newStudent.getPhone()) &&
      this.getEmail().equals(newStudent.getEmail());

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
      String sql = "UPDATE students SET name =:name, age =:age, phone =:phone, email =:email WHERE id=:id";
      con.createQuery(sql)
      .addParameter("name",name)
      .addParameter("age",age)
      .addParameter("phone",phone)
      .addParameter("email",email)
      .executeUpdate();
      }
    }

    public void addActivity(Activity activity, Teacher teacher) {
      try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO students_teachers_activities (student_id,activity_id,teacher_id) VALUES (:student_id,:activity_id,:teacher_id)";
      con.createQuery(sql)
      .addParameter("student_id",this.getId())
      .addParameter("activity_id",activity.getId())
      .addParameter("teacher_id",teacher.getId())
      .executeUpdate();
      }
    }

    public List<Activity> getActivities() {
      try(Connection con = DB.sql2o.open()) {

      String sql = "SELECT activities .* FROM students JOIN students_teachers_activities ON (students.id = students_teachers_activities.student_id) JOIN activities ON (students_teachers_activities.activity_id = activities.id) JOIN teachers ON (students_teachers_activities.teacher_id = teachers.id) WHERE student_id = :id";
      return con.createQuery(sql)
      .addParameter("id",id)
      .executeAndFetch(Activity.class);
      }
    }

    public Teacher getStudentActivityTeacher(int activity_id) {
      try(Connection con = DB.sql2o.open()) {

      String sql = "SELECT teachers.* FROM activities JOIN students_teachers_activities ON (activities.id = students_teachers_activities.activity_id) JOIN teachers ON (students_teachers_activities.teacher_id = teachers.id) JOIN students ON (students_teachers_activities.student_id = students.id) WHERE student_id = :id and activity_id = :activity_id";
      return con.createQuery(sql)
      .addParameter("id",id)
      .addParameter("activity_id" ,activity_id)
      .executeAndFetchFirst(Teacher.class);
      }
    }

  }
