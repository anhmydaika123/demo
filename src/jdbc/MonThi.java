package jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonThi {

    private final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa";
    private Connection connection;
    private String maMT, tenMT;
    private int lePhi;
    //------------------------------------------------------

    public MonThi() {
        connect();
    }

    public MonThi(String maMT, String tenMT, int lePhi) {
        this.maMT = maMT;
        this.tenMT = tenMT;
        this.lePhi = lePhi;
    }

    public void connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay lop sql driver " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Loi ket noi "+ ex.toString());
        }
    }
    

    public String getMaMT() {
        return maMT;
    }

    public void setMaMT(String maMT) {
        this.maMT = maMT;
    }

    public String getTenMT() {
        return tenMT;
    }

    public void setTenMT(String tenMT) {
        this.tenMT = tenMT;
    }

    public int getLePhi() {
        return lePhi;
    }

    public void setLePhi(int lePhi) {
        this.lePhi = lePhi;
    }

}
