import java.util.*;

import javax.lang.model.util.ElementScanner6;

import java.sql.*;

// java TestDB <mode> <arguments>
//     <mode> : 1 - arguments : <dml query>
//     <mode> : 2 - arguments : <insert query>
//     <mode> : 3 - arguments : <ddl query>

public class TestDB
{
    public static void main(String[] args)
    {
        try 
        {   
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_empdb", "root", "");
            Statement st = con.createStatement();
            DatabaseMetaData mData = con.getMetaData();

            ArrayList<Employee> empList = new ArrayList<Employee>();

            
            System.out.println("Setting auto commit to false...");
            System.out.println("MetaData = " + mData);

            int mode = Integer.parseInt(args[0]);
            ResultSet rs;

            if(mode == 1)
            {
                //Create table //Delete table
                Statement employee = con.createStatement();

                String employeeTableQuery = args[1];

                employee.executeUpdate(employeeTableQuery);

                System.out.println("Query executed successfully!");
            }
            else if(mode == 2)
            {
                //Insert into table
                
                PreparedStatement pst = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?)");
                
                pst.setInt(1, Integer.parseInt(args[1]));
                pst.setString(2, args[2]);
                pst.setInt(3, Integer.parseInt(args[3]));
                pst.setString(4, args[4]);
                pst.executeUpdate();
                
                System.out.println("\nInsertion Accomplished!");
            }
            else if(mode == 3)
            {
                //Display table
                rs = st.executeQuery(args[1]);
                Employee emp = new Employee(rs);
                System.out.println("ID\tNAME\tSAL\tDEPT");
                // while(rs.next())
                // {
                //     System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
                //     System.out.println();
                // }
                System.out.println("\nRetrieval Successful!");
            }

            con.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }
}