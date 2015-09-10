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
    this.activity_id = activity_id;
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
  public int getNo_Of_Students() {
    return no_of_students;
  }
  public double getFees() {
    return fees;
  }
  public String getLocation() {
    return location;
  }
  public int getSpots_Available() {
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
    return activity_id;
  }




  @Override
  public boolean equals(Object otherTeacher){
    if (!(otherTeacher instanceof Teacher)) {
      return false;
    } else {
      Teacher newTeacher = (Teacher) otherTeacher;
      return this.getName().equals(newTeacher.getName()) &&
      this.getId() == newTeacher.getId() &&
      this.getQualification().equals(newTeacher.getQualification()) &&
      this.getExperience().equals(newTeacher.getExperience()) &&
      this.getNo_Of_Students() == newTeacher.getNo_Of_Students() &&
      this.getFees() == newTeacher.getFees() &&
      this.getLocation().equals(newTeacher.getLocation()) &&
      this.getSpots_Available() == newTeacher.getSpots_Available() &&
      this.getClass_Start_Date().equals(newTeacher.getClass_Start_Date()) &&
      this.getClass_End_Date().equals(newTeacher.getClass_End_Date()) &&
      this.getTime().equals(newTeacher.getTime()) &&
      this.getActivity_id() == newTeacher.getActivity_id();

    }
  }


  public static List<Teacher> all() {
    String sql = "SELECT * FROM teachers";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Teacher.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO teachers(name, qualification, experience, no_of_students, fees, location, spots_available, class_start_date, class_end_date, time, activity_id) VALUES (:name, :qualification, :experience, :no_of_students, :fees, :location, :spots_available, :class_start_date, :class_end_date, :time, :activity_id)";
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
      String sql = "SELECT * FROM teachers where id=:id";
      Teacher Teacher = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Teacher.class);
      return Teacher;
    }
  }

  public void update(String name,String qualification,String experience,int no_of_students, double fees,String address,int spots_avaialble, String class_start_date,String class_end_date, String time,Integer activity_id) {
    this.name = name;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE teachers SET (name = :name,qualification =:qualification,experience =:experience,no_of_students =:no_of_students,fees =: fees,address =:address,spots_avaialble=:spots_avaialble,class_start_date=:class_start_date,class_end_date=:class_end_date,time=:time,activity_id=:activity_id) WHERE id = :id";
      con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .addParameter("qualification",qualification)
      .addParameter("experience",experience)
      .addParameter("no_of_students",no_of_students)
      .addParameter("fees",fees)
      .addParameter("address",address)
      .addParameter("spots_avaialble",spots_avaialble)
      .addParameter("class_start_date",class_start_date)
      .addParameter("class_end_date",class_end_date)
      .addParameter("time",time)
      .addParameter("activity_id",activity_id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM teachers WHERE id = :id;";
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
