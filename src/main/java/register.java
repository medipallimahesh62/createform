import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String fn = request.getParameter("first_name");
        String ln = request.getParameter("last_name");
        String mail = request.getParameter("email");
        String pass = request.getParameter("password");
        String gen = request.getParameter("gender");
        String hobb = request.getParameter("hobbies");
        String soi = request.getParameter("source_of_income");
        String in = request.getParameter("income");
        String pic = request.getParameter("picture");
        String age1 = request.getParameter("age");
        String bio1 = request.getParameter("bio");
        String cpass = request.getParameter("confirmpass");
        double in1 = Double.parseDouble(in);
        int age2 = Integer.parseInt(age1);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/form";
            String jdbcUsername = "root";
            String jdbcPassword = "";
            Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, fn);
            ps.setString(2, ln);
            ps.setString(3, mail);
            ps.setString(4, pass);
            ps.setString(5, gen);
            ps.setString(6, hobb);
            ps.setString(7, soi);
            ps.setDouble(8, in1);
            ps.setString(9, pic);
            ps.setInt(10, age2);
            ps.setString(11, bio1);
            ps.setString(12, cpass);
            int i = ps.executeUpdate();
            PrintWriter out = resp.getWriter();
            out.println("Data saved successfully");

        } catch (Exception e) {

            System.out.println(e);

        }

    }
}