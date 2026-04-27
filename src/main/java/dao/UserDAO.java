package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.UserModel;

public class UserDAO {

    public UserModel validarLogin(UserModel userModel) {
        String sql = "SELECT * FROM users WHERE username = ? AND psw = ?";

        try (var con = ConnectionFactory.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userModel.getUsername());
            stmt.setString(2, userModel.getPassword());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserModel user = new UserModel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("psw"));
                user.setFuncao(rs.getString("funcao"));
                return user;
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
