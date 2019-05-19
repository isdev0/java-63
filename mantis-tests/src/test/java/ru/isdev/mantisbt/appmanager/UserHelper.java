package ru.isdev.mantisbt.appmanager;

import ru.isdev.mantisbt.model.UserData;
import ru.isdev.mantisbt.model.Users;

import java.sql.*;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public Users all() {

        Users users = new Users();

        try {
            Connection conn = DriverManager.getConnection(app.getProperty("mantisbt.dbconnectionstring"));
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, username, email, access_level FROM mantis_user_table WHERE NOT access_level=90");
            while(rs.next()) {
                users.add( new UserData()
                        .withId(rs.getInt("id"))
                        .withUsername(rs.getString("username"))
                        .withEmail(rs.getString("email"))
                );
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return users;
    }

}
