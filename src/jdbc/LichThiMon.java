
package jdbc;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LichThiMon extends MonThi{
    
    private final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa";
    private Connection connection;
    private String maKT;
    private int soLuong, soDK;
    private Date ngayThi;
    private Time gioThi;
    private boolean cBThu;
    //----------------------------------------------------

    public LichThiMon() {
        connect();
    }

    public LichThiMon(String maKT, int soLuong, int soDK, Date ngayThi, Time gioThi, String maMT, String tenMT, int lePhi) {
        super(maMT, tenMT, lePhi);
        this.maKT = maKT;
        this.soLuong = soLuong;
        this.soDK = soDK;
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
    }

    public LichThiMon (String maKT){
        this();
        try {
            String sql = "Select KyThi.MaMT,TenMT,Ngay,GioThi,SL,SoDK, MonThi.LePhi from MonThi, KyThi where KyThi.MaMT = MonThi.MaMT and KyThi.MaKT = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,maKT);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                this.maKT = maKT;
                setMaMT(rs.getString(1));
                setTenMT(rs.getString(2));
                this.ngayThi = rs.getDate(3);
                this.gioThi = rs.getTime(4);
                this.soLuong = rs.getInt(5);
                this.soDK = rs.getInt(6);
                setLePhi(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichThiMon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public LichThiMon (String maKT, boolean cbThu){
        this();
         setcBThu(cbThu);
        try {
            String sql = "Select KyThi.MaMT,TenMT,Ngay,GioThi,SL,SoDK, MonThi.LePhi from MonThi, KyThi where KyThi.MaMT = MonThi.MaMT and KyThi.MaKT = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,maKT);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                this.maKT = maKT;
                setMaMT(rs.getString(1));
                setTenMT(rs.getString(2));
                this.ngayThi = rs.getDate(3);
                this.gioThi = rs.getTime(4);
                this.soLuong = rs.getInt(5);
                this.soDK = rs.getInt(6);
                setLePhi(rs.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichThiMon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-----------------------------------------------------
    
    public void connect(){
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
        }
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
        }
    }
    
    public Vector toVector(){
        Vector v = new Vector();
        v.add(getMaKT());v.add(getTenMT());v.add(getNgayThi());v.add(getGioThi());v.add(getSoDK()); v.add(iscBThu());
        return v;
    }
    
    public Vector toVector(String maSV){
        SinhVien sv =  new SinhVien(maSV);
        Vector v = new Vector();
        v.add(sv.getHo()); v.add(sv.getTen());v.add(getMaKT());v.add(getTenMT());v.add(getNgayThi());v.add(getGioThi());v.add(getSoDK());v.add(getLePhi()); v.add(iscBThu());
        return v;
    }
    
    public  Vector<Vector> getListMT(SinhVien sv, String mahk){//phương thức dùng để đưa vào JTable, lấy danh sách lịch thi môn của sinh viên đó
        Vector<LichThiMon> lt =new LichThiMon().getKyThi(sv, mahk);
        Vector<Vector> listMT = new Vector<Vector>();
        for(LichThiMon ltsv : lt) listMT.add(ltsv.toVector());
        return listMT;
    }
    
    public  Vector<Vector> getListMT(String maSV){ //phương thức dùng để đưa vào JTable, lấy danh sách lịch thi môn của sinh viên chưa nộp lệ phí
        Vector<LichThiMon> lt =new LichThiMon().getKyThiSVChuaNopLePhi(maSV);
        Vector<Vector> listMT = new Vector<Vector>();
        for(LichThiMon ltsv : lt) listMT.add(ltsv.toVector(maSV));
        return listMT;
    }
    
    public Vector<LichThiMon> getKyThi(SinhVien sv, String mahk){ //dùng để láy danh sách lịch thi môn của sinh viên nào chưa nộp tiền hoặc đã nộp tiền
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa");
            PreparedStatement st = cn.prepareStatement("Select MaKT, CBThu from DangKyThi where left(makt,3)=? and MaSV = ?");
            st.setString(1, mahk);
            st.setString(2,sv.getMaSV());
            ResultSet rs = st.executeQuery();
            Vector<LichThiMon> listMonThi = new Vector<LichThiMon>();
            while(rs.next()){
                if(rs.getString(2)!=null){
                    listMonThi.add(new LichThiMon(rs.getString(1),true));
                }
                    
                else
                    listMonThi.add(new LichThiMon(rs.getString(1),false));
                    
            }
            cn.close();
            return listMonThi;
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
            return null;
        }
    }
    
    public Vector<LichThiMon> getKyThiSVChuaNopLePhi(String maSV){ //lấy danh sách lịch thi môn của sinh viên nào chưa nộp lệ phí
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa");
            PreparedStatement st = cn.prepareStatement("Select MaKT, CBThu from DangKyThi where MaSV = ?");
            st.setString(1, maSV);
            ResultSet rs = st.executeQuery();
            Vector<LichThiMon> listMonThi = new Vector<LichThiMon>();
            while(rs.next()){
                if(rs.getString(2)==null){
                    listMonThi.add(new LichThiMon(rs.getString(1),false));
                }
                    
            }
            cn.close();
            return listMonThi;
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
            return null;
        }
    }
    
    public static Vector<LichThiMon> getKyThi(String mahk){//dùng để lấy danh sách môn thi của mã học kì đó
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa");
            PreparedStatement st = cn.prepareStatement("Select MaKT from KyThi where left(makt,3)=? ");
            st.setString(1, mahk);
            ResultSet rs = st.executeQuery();
            Vector<LichThiMon> listMonThi = new Vector<LichThiMon>();
            while(rs.next()){
                listMonThi.add(new LichThiMon(rs.getString(1)));
            }
            cn.close();
            return listMonThi;
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Loi khong tim thay thiet bi driver \n" + ex.toString());
            return null;
        }
    }
    
    public static Vector getHocKy(){//dùng để lấy danh sách của tất cả mã học kì thuộc bảng kỳ thi để đưa vào Combobox
        try {
            Vector v = new Vector();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa");
            PreparedStatement st = cn.prepareStatement("Select LEFT(MaKT,3) from KyThi GROUP BY LEFT(MaKT,3)");//lấy ra mã học kì từ 3 chữ cái đầu tiên của maKT
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                v.add(rs.getString(1));
            }
            return v;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LichThiMon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
            return null;
        }
        
    }
    
    public static Vector getHocKy(SinhVien sv){//dùng để lấy danh sách học kỳ của sinh viên đó đã đăng ký môn thi để thêm vào combobox
        try {
            Vector v = new Vector();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QL_ThiCDR;user=sa;password=sa");
            PreparedStatement st = cn.prepareStatement("Select LEFT(MaKT,3) from DangKyThi where MaSV = ? GROUP BY LEFT(MaKT,3)");
            st.setString(1,sv.getMaSV());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                v.add(rs.getString(1));
            }
            return v;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LichThiMon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            System.out.println("Loi ket noi \n"+ex.toString());
            return null;
        }
    }
    
    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoDK() {
        return soDK;
    }

    public void setSoKD(int soDK) {
        this.soDK = soDK;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public Time getGioThi() {
        return gioThi;
    }

    public void setGioThi(Time gioThi) {
        this.gioThi = gioThi;
    }

    public boolean iscBThu() {
        return cBThu;
    }

    public void setcBThu(boolean cBThu) {
        this.cBThu = cBThu;
    }

    
    @Override
    public String toString() {
        return "LichThiMon{" + "maKT=" + maKT + ", MaMT=" + getMaMT() + ", TenMT=" + getTenMT() +  ", ngayThi=" + ngayThi + ", gioThi=" + gioThi + ", soLuong=" + soLuong + ", soDK=" + soDK +'}';
    }
    
}
