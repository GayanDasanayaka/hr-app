package db;

import model.*;


import java.util.ArrayList;

public class HrAppFile {

  public static ArrayList<Department>departmentTable=new ArrayList<Department>();

  public static ArrayList<HrManagerLogin>hrManagerLoginsTable=new ArrayList<HrManagerLogin>();

  public static ArrayList<Designation>designationsTable=new ArrayList<>();

  public static ArrayList<Employee>employeeTable=new ArrayList<>();

  public  static ArrayList<HrAssistantLogin>hrAssistantLoginCredentialsTable=new ArrayList<>();

  public  static ArrayList<UserDt>userDtTable=new ArrayList<>();

  static {
    hrAssistantLoginCredentialsTable.add(new HrAssistantLogin("madu.hra@thetech.lk","madu@123"));



  }
}
