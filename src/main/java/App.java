import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
  }

  get("/", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/index.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

  get("/students", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    model.put("template", "templates/student.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/add_student_info", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    String age = request.queryParams("age");
    String phone = request.queryParams("phone");
    String email = request.queryParams("email");
    Student newStudent = new Student(name,age,phone,email);
    newStudent.save();
    model.put("newStudent", newStudent);
    model.put("allActivities", Activity.all());
    model.put("template", "templates/student_activities.vtl");
    return null;
  });

  post("/student_activity", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    int id = Integer.parseInt(request.queryParams("activity_id"));
    Activity activity = new activity.find(id)
    model.put("activity", activity);
    model.put("template", "templates/student_teacher.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  post("/add_teacher", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    int student_id = Integer.parseInt(request.queryParams("student_id"));
    int activity_id = Integer.parseInt(request.queryParams("activity_id"));
    int teacher_id = Integer.parseInt(request.queryParams("teacher_id"));
    Student student = Student.find(student_id);
    student.addActivity(activity_id,teacher_id);
    List<Activity>  activities = student.getActivities();

    model.put("student", student);
    model.put("activities",activities);
    model.put("template", "templates/student_activities.vtl");
    return null;
  });

// post("/teachers", (request, response) -> {
//   HashMap<String, Object> model = new HashMap<String, Object>();
//   String teacher_id = request.queryParams("teacher_id");
//   String name = request.queryParams("name");
//   String qualification = request.queryParams("qualification");
//   String experience = request.queryParams("experience");
//   String no_of_students = request.queryParams("no_of_students");
//   String fees = request.queryParams("fees");
//   String location = request.queryParams("location");
//   String spots_available = request.queryParams("spots_available");
//   String class_start_date = request.queryParams("class_start_date");
//   String class_end_date = request.queryParams("class_end_date");
//   String class_time = request.queryParams("class_time");
//   String activity_id = request.queryParams("activity_id");
//
//   Teacher newTeacher = new    Teacher(name,qualification,experience,no_of_students,fees,location,spots_available,class_start_date,class_end_date,class_time,activity_id);
//   newTeacher.save();
//
//
//   model.put("newTeacher", newTeacher);
//   model.put("template", "templates/teacher.vtl");
//   return null;
// });
//
// get("/activities", (request, response) -> {
//   HashMap<String, Object> model = new HashMap<String, Object>();
//
//   model.put("template", "templates/activity.vtl");
//   return new ModelAndView(model, layout);
// }, new VelocityTemplateEngine());
//
//
// post("/activities", (request, response) -> {
//   HashMap<String, Object> model = new HashMap<String, Object>();
//   String type = request.queryParams("type");
//   Activity activity = new Activity(type);
//   activity.save();
//
//
//   model.put("activity", activity);
//   model.put("template", "templates/teacher.vtl");
//   return null;
// });
//
//
 }
 }
