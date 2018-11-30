import com.student.Student;
import com.util.DButil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Eve
 * @Date: 2018/11/30 10:00
 * @Version 1.0
 */

public class test2 {
    @Test
    public void add() {
        Student student = new Student(80, "等等", "洛杉矶");
        Connection connection = DButil.getConn();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            if (!statement.execute("insert into dept values (" + student.getDeptno() + ",'"
                    + student.getDname() + "','" + student.getLoc() + "')")) {
                System.out.println("操作成功");
            } else {
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButil.closeResource(connection, statement, null);
    }

    @Test
    public void select() throws SQLException {
        Connection connection;
        ResultSet rs;
        connection = DButil.getConn();
        Statement statement;
        statement = connection.createStatement();
        rs = statement.executeQuery("select * from dept");
        while (rs.next()) {
            System.out.print(rs.getInt(1) + "\t\t" + rs.getString(2)
                    + "\t\t" + rs.getString(3));
            System.out.println();
        }
        DButil.closeResource(connection, statement, rs);
    }

    @Test
    public void del() throws SQLException {
        Connection connection = DButil.getConn();
        Statement statement;
        statement = connection.createStatement();
        if (!statement.execute("delete from dept where deptno = 80")) {
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
        DButil.closeResource(connection, statement, null);
    }

    @Test
    public void update() throws SQLException {
        Connection connection = DButil.getConn();
        Statement statement;
        statement = connection.createStatement();
        if (!statement.execute("update dept set loc = '旧金山' where deptno = 10")) {
            System.out.println("操作成功");
        } else {
            System.out.println("操作失败");
        }
        DButil.closeResource(connection, statement, null);
    }
}
