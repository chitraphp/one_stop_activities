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

  post("/students", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("name");
    int age = Integer.parseInt(request.queryParams("age"));
    String phone = request.queryParams("phone");
    String email = request.queryParams("email");
    Student newStudent = new Student(name,age,phone,email);
    newStudent.save();
    model.put("newStudent", newStudent);
    model.put("allActivities", Activity.all());
    model.put("template", "templates/student_activity.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/student_activity", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    int activity_id = Integer.parseInt(request.queryParams("activity_id"));
    int student_id = Integer.parseInt(request.queryParams("student_id"));
    Student student = Student.find(student_id);
    Activity activity = Activity.find(activity_id);
    model.put("activity", activity);
    model.put("student", student);
    model.put("activities", Activity.all());
    model.put("teachers", Teacher.all());
    model.put("template", "templates/student_teacher.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teachers", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  //model.put("teachers", Teacher.all());
  model.put("template", "templates/teachers.vtl");
  return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/add_teacher", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    int student_id = Integer.parseInt(request.queryParams("student_id"));
    int activity_id = Integer.parseInt(request.queryParams("activity_id"));
    int teacher_id = Integer.parseInt(request.queryParams("teacher_id"));
    Student student = Student.find(student_id);
    Teacher teacher = Teacher.find(teacher_id);
    Activity activity = Activity.find(activity_id);
    student.addActivity(activity,teacher);
    //List<Activity>  activities = student.getActivities();

    model.put("students", Student.all());
    //model.put("activities",activities);
    model.put("template", "templates/student_activities.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teacher", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("allActivities", Activity.all());
    model.put("template", "templates/teacher.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


post("/teacher", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  // int teacher_id = Integer.parseInt(request.queryParams("teacher_id"));
  String name = request.queryParams("name");
  String qualification = request.queryParams("qualification");
  String experience = request.queryParams("experience");
  int no_of_students = Integer.parseInt(request.queryParams("no_of_students"));
  int fees = Integer.parseInt(request.queryParams("fees"));
  String location = request.queryParams("location");
  //String spots_available = request.queryParams("spots_available");
  String class_start_date = request.queryParams("class_start_date");
  String class_end_date = request.queryParams("class_end_date");
  String class_time = request.queryParams("class_time");
  int activity_id = Integer.parseInt(request.queryParams("activity_id"));
  Activity activity = Activity.find(activity_id);
  Teacher newTeacher = new Teacher(name,qualification,experience,no_of_students,fees,location,class_start_date,class_end_date,class_time);
  newTeacher.save();
  newTeacher.addActivity(activity);

  model.put("teachers", Teacher.all());
  model.put("template", "templates/teachers.vtl");
  return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

get("/activity", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  model.put("template", "templates/activity.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


post("/activity", (request, response) -> {
  HashMap<String, Object> model = new HashMap<String, Object>();
  String type = request.queryParams("type");
  String description = request.queryParams("description");
  Activity activity = new Activity(type,description);
  activity.save();
  //model.put("activity", activity);
  model.put("allActivities", Activity.all());
  model.put("template", "templates/teacher.vtl");
  return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


 }
 }
