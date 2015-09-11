import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {

    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/one_stop_activities_test","null","null");
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteStudentsQuery = "DELETE FROM students *;";
      String deleteTeachersQuery = "DELETE FROM teachers *;";
      String deleteActivitiesQuery = "DELETE FROM activities *;";
      String deleteTeachersActivitiesQuery = "DELETE FROM teachers_activities *;";
      String deleteStudentsTeachersActivitiesQuery = "DELETE FROM students_teachers_activities *;";

      con.createQuery(deleteStudentsQuery).executeUpdate();
      con.createQuery(deleteTeachersQuery).executeUpdate();
      con.createQuery(deleteActivitiesQuery).executeUpdate();
      con.createQuery(deleteTeachersActivitiesQuery).executeUpdate();
      con.createQuery(deleteStudentsTeachersActivitiesQuery).executeUpdate();


    }
  }
}
