import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class student {
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

  public String getActivityEnrolled() {
    return activity_enrolled;
  }

  public Student(String name, String age, String phone, String email, String activity_enrolled) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
    this.activity_enrolled = activity_enrolled;
  }

  @Override
  public boolean equals(Object otherStudent) {
    if(!(otherStudent instanceof Student)) {
      return false;
    } else {
      Student newStudent = (Student) otherStudent;
      return this.getName().equals(newStudent.getName()) &&
      return this.getAge().equals(newStudent.getAge()) &&
      return this.getPhone().equals(newStudent.getPhone()) &&
      return this.getEmail().equals(newStudent.getEmail()) &&
      return this.getActivityEnrolled().equals(newStudent.getActivityEnrolled());

    }
  }
  public static List<student> all() {
    String sql = "SELECT * FROM students ORDER BY name ASS";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Student.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO students(name,age,phone,email,activity_enrolled) VALUES (:name,:age,:phone,:email,:activity_enrolled)";
      this.id = (int) con.createQuery(sql,true)
      .addParameter("name",name)
      .addParameter("age",age)
      .addParameter("phone",phone)
      .addParameter("email",email)
      .addParameter("activity_enrolled",activity_enrolled)
      .executeAndFetchFirst(Student.class);
      return student;
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

    public void addTeacher(Teacher teacher) {
      try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO activities (student_id,teacher_id,activity_id) VALUES (:student_id,:teacher_id,:activity_id)";
      con.createQuery(sql)
      .addParameter("student_id",teacher.getId())
      .addParameter("teacher_id",this.getId())
      .executeUpdate();
      }
    }

    public List<Teacher> getTeacher() {
      try(Connection con = DB.sql2o.open()) {
        // look for 3 table joint.
      //String sql = "SELECT teachers,students FROM students JOIN activities ON (student.id = activities.student_id) JOIN teachers ON (activities.teacher_id = teacher.id) WHERE students.id = :id ORDER BY name";
      return con.createQuery(sql)
      .addParameter("id",id)
      .executeAndFetch(Teacher.class);
      }
    }

  }
}
