//package persistence;
//import models.*;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
///**
// * Created by carlboy03
// */
//public class DAOCourse implements DAOGeneric{
//
//
//
//    @Override
//    public ArrayList<Course> getAllObjetcs() {
//        ArrayList<Course> courses=new ArrayList<Course>();
//        Person person=null;
//        Connection connection= DbConnection.getConnection();
//        PreparedStatement statement = null;
//
//        try{
//            String sql = "select *\n" +
//                    "from Person where person_type=0";
//            statement = connection.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                courses.add(new Course( rs.getInt("person_id"),
//                        rs.getString("person_name"),
//                        rs.getString("person_last_name"),
//                        rs.getInt("person_type"),
//                        rs.getString("person_uprm_id"),
//                        rs.getString("person_rfid")));
//            }
//            rs.close();
//        }
//        catch(Exception e){
//            System.out.println("Failed SQL Extraction");
//            e.printStackTrace();
//
//        }
//        finally{
//            try{
//                if(statement!=null)
//                    statement.close();
//            }catch(SQLException se){
//            }
//            try{
//                if(connection!=null)
//                    connection.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        if (students.size()==0){
//            students.add( new Person());
//            System.out.println("Person does not Exist");
//        }
//        return students;
//    }
//
//    @Override
//    public Object getObjectById(Integer id) {
//
//        Person person=null;
//        Connection connection= DbConnection.getConnection();
//        PreparedStatement statement = null;
//
//        try{
//            String sql = "select *\n" +
//                    "from Person\n" +
//                    "where person_id = ?";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                person = new Person( rs.getInt("person_id"),
//                        rs.getString("person_name"),
//                        rs.getString("person_last_name"),
//                        rs.getInt("person_type"),
//                        rs.getString("person_uprm_id"),
//                        rs.getString("person_rfid"));
//            }
//            rs.close();
//        }
//        catch(Exception e){
//            System.out.println("Failed SQL Extraction");
//            e.printStackTrace();
//
//        }
//        finally{
//            try{
//                if(statement!=null)
//                    statement.close();
//            }catch(SQLException se){
//            }
//            try{
//                if(connection!=null)
//                    connection.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        if (person==null){
//            person= new Person();
//            System.out.println("Person does not Exist");
//        }
//        return person;
//    }
//
//    @Override
//    public void updateObject(Object object) {
//
//    }
//
//    @Override
//    public void deleteObject(Object object) {
//
//    }
//}
