import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;

public class Teacher {
  private int id;
  private String name;
  private String qualification;
  private String experience;
  private int no_of_students;
  private double fees;
  private String location;
  private int spots_available;
  private String class_start_date;
  private String class_end_date;
  private String time;
  private int activity_id;


  public Teacher(String name, String qualification, String experience, int no_of_students, double fees, String location, int spots_available,String class_start_date,String class_end_date,String time, int activity_id) {
    this.name = name;
    this.qualification = qualification;
    this.experience = experience;
    this.no_of_students = no_of_students;
    this.fees = fees;
    this.location = location;
    this.spots_available = spots_available;
    this.class_start_date = class_start_date;
    this.class_end_date = class_end_date;
    this.time = time;
    this.time = activity_id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getQualification() {
    return qualification;
  }

  public String getExperience() {
    return experience;
  }
  public String getNo_Of_Students() {
    return no_of_students;
  }
  public String getFees() {
    return fees;
  }
  public String getLocation() {
    return location;
  }
  public String getSpots_Available() {
    return spots_available;
  }

  public String getClass_Start_Date() {
    return class_start_date;
  }

  public String getClass_End_Date() {
    return class_end_date;
  }
  public String getTime() {
    return time;
  }

  public int getActivity_id() {
    return time;
  }




  @Override
  public boolean equals(Object otherTeacher){
    if (!(otherTeacher instanceof Teacher)) {
      return false;
    } else {
      Teacher newTeacher = (Teacher) otherTeacher;
      return this.getName().equals(newTeacher.getName()) &&
             this.getId() == newTeacher.getId();
    }
  }


  public static List<Teacher> all() {
    String sql = "SELECT * FROM Teachers";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Teacher.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Teachers(name, qualification, experience, no_of_students, fees, location, spots_available, class_start_date, class_end_date, time, activity_id) VALUES (:name, :qualification, :experience, :no_of_students, :fees, :location, :spots_available, :class_start_date, :class_end_date, :time, :activity_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", name)
        .addParameter("qualification", qualification)
        .addParameter("experience", experience)
        .addParameter("no_of_students", no_of_students)
        .addParameter("fees", fees)
        .addParameter("location", location)
        .addParameter("spots_available", spots_available)
        .addParameter("class_start_date", class_start_date)
        .addParameter("class_end_date", class_end_date)
        .addParameter("time", time)
        .addParameter("activity_id", activity_id)
        .executeUpdate()
        .getKey();
    }
  }

  public static Teacher find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM Teachers where id=:id";
      Teacher Teacher = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Teacher.class);
      return Teacher;
    }
  }

  public void update(String name) {
    this.name = name;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET name = :name WHERE id = :id";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String qualification) {
    this.qualification = qualification;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET qualification = :qualification WHERE id = :id";
      con.createQuery(sql)
        .addParameter("qualification", qualification)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String experience) {
    this.experience = experience;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET experience = :experience WHERE id = :id";
      con.createQuery(sql)
        .addParameter("experience", experience)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String no_of_students) {
    this.no_of_students = no_of_students;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET no_of_students = :no_of_students WHERE id = :id";
      con.createQuery(sql)
        .addParameter("no_of_students", no_of_students)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String fees) {
    this.fees = fees;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET fees = :fees WHERE id = :id";
      con.createQuery(sql)
        .addParameter("fees", fees)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String location) {
    this.location = location;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET location = :location WHERE id = :id";
      con.createQuery(sql)
        .addParameter("location", location)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String spots_available) {
    this.spots_available = spots_available;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET spots_available = :spots_available WHERE id = :id";
      con.createQuery(sql)
        .addParameter("spots_available", spots_available)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String class_start_date) {
    this.class_start_date = class_start_date;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET class_start_date = :class_start_date WHERE id = :id";
      con.createQuery(sql)
        .addParameter("class_start_date", class_start_date)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String class_end_date) {
    this.class_end_date = class_end_date;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET class_end_date = :class_end_date WHERE id = :id";
      con.createQuery(sql)
        .addParameter("class_end_date", class_end_date)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String time) {
    this.time = time;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET time = :time WHERE id = :id";
      con.createQuery(sql)
        .addParameter("time", time)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(int activity_id) {
    this.activity_id = activity_id;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE Teachers SET activity_id = :activity_id WHERE id = :id";
      con.createQuery(sql)
        .addParameter("activity_id", activity_id)
        .addParameter("id", id)
        .executeUpdate();
    }
  }







  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM Teachers WHERE id = :id;";
        con.createQuery(deleteQuery)
          .addParameter("id", id)
          .executeUpdate();

      // String joinDeleteQuery = "DELETE FROM Teachers_brands WHERE Teacher_id = :Teacher_id";
      //   con.createQuery(joinDeleteQuery)
      //     .addParameter("Teacher_id", this.getId())
      //     .executeUpdate();
    }
  }

  public void addStudent(Student student) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO student_activities (student_id, activity_id) VALUES (:student_id, :activity_id)";
      con.createQuery(sql)
        .addParameter("student_id", student.getId())
        .addParameter("activity_id", this.getId())
        .executeUpdate();
    }
  }

    public List<Student> getStudents() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT students.* FROM teachers JOIN students_activities ON (students_activities.Teacher_id = Teachers.id) JOIN students ON (students_activities.student_id = student.id) WHERE Teacher_id=:id ";
        return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetch(Student.class);
    }
  }


}
