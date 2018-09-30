package jdbc;

import java.sql.Date;
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;

public class SinhVien {

    private final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://127.0.0.1;databaseName=QL_ThiCDR;user=sa;password=sa";
    private Connection connection;
    private PreparedStatement stmt;

    private String maSV, ho, ten, gioiTinh, matKhau;
    private Date ngaySinh;

    //---------------------------------------------------------------
    public SinhVien() {
        connect();
    }

    public SinhVien(String MaSV) {
        //goi ham dung mac dinh
        this();
        try {
            stmt = connection.prepareStatement("Select * from SinhVien where MaSV = ?");
            stmt.setString(1, MaSV);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maSV = MaSV;
                ho = rs.getString(2);
                ten = rs.getString(3);
                ngaySinh = rs.getDate(4);
                gioiTinh = rs.getString(5);
                matKhau = rs.getString(6);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối");
        }
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "SinhVien: " + " MaSV: " + maSV + " || Ho: " + ho + " || Ten: " + ten + " || GioiTinh: " + gioiTinh + " || MatKhau: " + matKhau + " || ngaySinh: " + ngaySinh;
    }

    public String connect() {

        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url);
            return "Ket noi csdl thanh cong";
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy lớp sql driver" + ex.toString());
            return "Ket noi that bai!";
        } catch (SQLException ex) {
            System.out.println("Loi ket noi" + ex.toString());
            return "Ket noi that bai!";
        }
    }

    public ResultSet getData() {
        ResultSet rs = null;
        String sql = "Select * From SinhVien";
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Loi 1: " + ex.toString());
        }
        return rs;
    }

    public ResultSet getDataId(String maSV) {
        ResultSet rs;
        String sql = "Select * From SinhVien Where MaSV = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, maSV);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("Loi " + ex.toString());
            return null;
        }

    }

    public void showData(ResultSet rs) {
        try {
            if (rs.next()) {
                this.maSV = rs.getString(1);
                this.ho = rs.getString(2);
                this.ten = rs.getString(3);
                this.ngaySinh = rs.getDate(4);
                this.gioiTinh = rs.getString(5);
                this.matKhau = rs.getString(6);
            } else {
                System.out.println("MaSV hoac Mat khau khong hop le");
                connection.close();
            }
            System.out.println(toString());
            connection.close();
            System.out.println("-------------------------------------------------------------------------");
        } catch (SQLException ex) {
            System.out.println("Loi " + ex.toString());
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
            ResultSet rs = getDataId(this.getMaSV());
            if (rs.next()) {
                if (rs.getString(6).equals(matKhauCu)) {
                    String sql = "Update SinhVien set MatKhau = ? where MaSV = ?";
                    stmt = connection.prepareStatement(sql);
                    stmt.setString(1, matKhauMoi);
                    stmt.setString(2, this.getMaSV());
                    stmt.executeUpdate();
                    connection.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public SinhVien login(String maSV, String matKhau) {
        SinhVien sv = new SinhVien(maSV);
        if (sv.getMatKhau().equals(matKhau)) {
            return sv;
        } else {
            return null;
        }
    }

    public boolean huyMonThi(String maKT) {
        String sql_1 = "DELETE dbo.DangKyThi WHERE MaSV = ? AND MaKT= ? ";
        String sql_2 = "UPDATE dbo.KyThi Set SoDK = SoDK - 1  Where MaKT = ?";
        try {
            connection = DriverManager.getConnection(url);
            stmt = connection.prepareStatement(sql_1);
            stmt.setString(1, this.getMaSV());
            stmt.setString(2, maKT);
            int c = stmt.executeUpdate();
            if (c > 0) {
                stmt = connection.prepareStatement(sql_2);
                stmt.setString(1, maKT);
                stmt.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
