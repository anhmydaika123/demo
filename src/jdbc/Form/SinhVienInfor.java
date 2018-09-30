
package jdbc.Form;

import jdbc.SinhVien;

public class SinhVienInfor extends javax.swing.JPanel {

    SinhVien sv;
    public SinhVienInfor() {
        initComponents();
    }

    public SinhVienInfor(SinhVien sv){
        this();
        setSv(sv);
        hoTen.setText(sv.getHo() + " " + sv.getTen());
        maSV.setText(sv.getMaSV());
        ngaySinh.setText(String.valueOf(sv.getNgaySinh()));
        gioiTinh.setText(sv.getGioiTinh());
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maSV = new javax.swing.JLabel();
        hoTen = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JLabel();
        gioiTinh = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mã sinh viên: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 25);
        add(jLabel1, gridBagConstraints);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Họ và tên: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 15, 29);
        add(jLabel2, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ngày sinh: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 25);
        add(jLabel3, gridBagConstraints);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Giới tính: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 15, 26);
        add(jLabel4, gridBagConstraints);

        maSV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maSV.setText("MaSV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(maSV, gridBagConstraints);

        hoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hoTen.setText("HoTen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(hoTen, gridBagConstraints);

        ngaySinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ngaySinh.setText("NgaySinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(ngaySinh, gridBagConstraints);

        gioiTinh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gioiTinh.setText("Gioitinh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(gioiTinh, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gioiTinh;
    private javax.swing.JLabel hoTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel maSV;
    private javax.swing.JLabel ngaySinh;
    // End of variables declaration//GEN-END:variables
}
