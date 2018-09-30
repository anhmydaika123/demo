package jdbc;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiaoVien {

    private final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa";
    private String maCB, hoTen, quyenUser, matKhau;
    private PreparedStatement stmt;
    private Connection connection;
    //------------------------------------------------

    public GiaoVien() {
        connect();
    }

    public GiaoVien(String MaCB) {
        //goi ham dung mac dinh
        this();
        try {
            stmt = connection.prepareStatement("Select * from GiaoVien where MaCB = ?");
            stmt.setString(1, MaCB);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                this.maCB = rs.getString(1);
                this.hoTen = rs.getString(2);
                this.quyenUser = rs.getString(3);
                this.matKhau = rs.getString(4);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn" + e.toString());
        }
    }
    //---------------------------------------------------------------------------------

    public void connect() {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
        }
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n" + ex.toString());
        }
    }

    public ResultSet getDataId(String maCB) {
        ResultSet rs;
        String sql = "Select * From GiaoVien Where MaCB = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, maCB);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("Loi " + ex.toString());
            return null;
        }

    }

    public boolean thuPhi(String maSV, String maKT) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
        }
        try {
            connection = DriverManager.getConnection(url);
            String sql = "UPDATE dbo.DangKyThi SET CBThu = 'R' WHERE MaSV = ? and MaKT = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maSV);
            st.setString(2, maKT);
            int t = st.executeUpdate();
            if (t > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n" + ex.toString());
            return false;
        }

    }

    public Vector<Vector> sinhVienDK(String maSV) {
        Vector<Vector> v = new Vector<Vector>();
        LichThiMon ltm = new LichThiMon();
        v = ltm.getListMT(maSV); //lấy danh sách sinh viên đó chưa nộp tiền
        return v;
    }

    public boolean nhapDiem(String maSV, String maKT, int diem) {
        String sql = "update DangKyThi set DiemThi = ? where MaSV = ? and MaKT = ?";
        try {
            connection = DriverManager.getConnection(url);
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, diem);
            stmt.setString(2, maSV);
            stmt.setString(3, maKT);
            int c = stmt.executeUpdate();
            if (c > 0) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Loi :" + ex.toString());
            return false;
        }
    }

    public boolean thayDoiMatKhau(String matKhauCu, String matKhauMoi) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url);
            ResultSet rs = getDataId(this.getMaCB());
            if (rs.next()) {
                if (rs.getString(4).equals(matKhauCu)) {
                    String sql = "Update GiaoVien set MatKhau = ? where MaCB = ?";
                    stmt = connection.prepareStatement(sql);
                    stmt.setString(1, matKhauMoi);
                    stmt.setString(2, this.getMaCB());
                    stmt.executeUpdate();
                    connection.close();
                }
                else
                    return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public GiaoVien Login(String maCB, String matKhau) {
        GiaoVien gv = new GiaoVien(maCB);
        if (gv.getMatKhau().equals(matKhau)) {
            return gv;
        } else {
            return null;
        }
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuyenUser() {
        return quyenUser;
    }

    public void setQuyenUser(String quyenUser) {
        this.quyenUser = quyenUser;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "GiaoVien[" + "MaCB: " + maCB + "|| HoTen: " + hoTen + "|| quyenUser: " + quyenUser + "|| matKhau: " + matKhau + ']';
    }

}
