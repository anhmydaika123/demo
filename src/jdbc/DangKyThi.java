package jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DangKyThi {

    private final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa";
    private Connection connection;
    private String maKT, maSV, CBThu;
    private int lePhi;
    private Date ngayNop;
    //---------------------------------------

    public DangKyThi() {
        connect();
    }

    public DangKyThi(String maKT, String maSV, String CBThu, int lePhi, Date ngayNop) {
        this.maKT = maKT;
        this.maSV = maSV;
        this.CBThu = CBThu;
        this.lePhi = lePhi;
        this.ngayNop = ngayNop;
    }

    

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getCBThu() {
        return CBThu;
    }

    public void setCBThu(String CBThu) {
        this.CBThu = CBThu;
    }

    public int getLePhi() {
        return lePhi;
    }

    public void setLePhi(int lePhi) {
        this.lePhi = lePhi;
    }

    public Date getNgayNop() {
        return ngayNop;
    }

    public void setNgayNop(Date ngayNop) {
        this.ngayNop = ngayNop;
    }

    public void connect() {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi sql driver " + ex.toString());
        }
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Loi ket noi " + ex.toString());
        }
    }

    public boolean dangKyThi(SinhVien sv, String maKT) {
        String sql_1 = "Insert into DangKyThi(MaKT, MaSV)"
                + "Values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql_1);
            st.setString(1, maKT);
            st.setString(2, sv.getMaSV());
            int d = st.executeUpdate();
            if(d>0)
                return true;
            else return false;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.toString());
            return false;
        }
    }
    
    

}
