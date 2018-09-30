package jdbc.Form;

import java.util.Vector;
import jdbc.SinhVien;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jdbc.LichThiMon;

public class HuyMonThiPanel extends javax.swing.JPanel {

    private SinhVien sv = null;
    DefaultTableModel dtm;

    public HuyMonThiPanel() {
        initComponents();
    }

    public HuyMonThiPanel(SinhVien sv) {
        this();
        setSv(sv);
        Vector v = LichThiMon.getHocKy(sv); //lấy mã học kỳ của sinh vien đã đăng ký môn thi sau đó thêm vào table
        DefaultComboBoxModel dcbk = new DefaultComboBoxModel(v);
        this.cbHocKy.setModel(dcbk);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbHocKy = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLMT = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Chọn học kỳ: ");

        cbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "116", "216", "117", "217", "118", "218" }));
        cbHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHocKyActionPerformed(evt);
            }
        });

        jTableLMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLMT);

        jButton1.setText("Hủy môn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(167, 167, 167))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHocKyActionPerformed
        String maHK = cbHocKy.getSelectedItem().toString();
        Vector v = new LichThiMon().getListMT(sv, maHK); //lấy danh sách các LichThiMon.toVector() của sinh viên đã đăng ký
        Vector tieuDe = new Vector(); //Danh sách làm tiêu đề
        tieuDe.add("Mã KT");
        tieuDe.add("Tên Môn Thi");
        tieuDe.add("Ngày thi");
        tieuDe.add("Giờ thi");
        tieuDe.add("Số ĐK");
        tieuDe.add("CBThu");
        dtm = new DefaultTableModel(v, tieuDe); //đưa các danh sách và tiêu đề vào Model table
        jTableLMT.setModel(dtm);

    }//GEN-LAST:event_cbHocKyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            int i = jTableLMT.getSelectedRow();
            String maKT = dtm.getValueAt(i, 0).toString();//láy giá trị tại dòng, cột
            System.out.println(i + maKT);
            if (i >= 0) {
                int value = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn không?", "Bạn chắc chắn không?", JOptionPane.YES_NO_OPTION);
                if (value == 0) {
                    sv.huyMonThi(maKT);
                    dtm.removeRow(i);
                    //------------Refresh lại Table----------------
                    Vector v = LichThiMon.getHocKy(sv); //lấy mã học kỳ của sinh vien đã đăng ký môn thi sau đó thêm vào table
                    DefaultComboBoxModel dcbk = new DefaultComboBoxModel(v);
                    this.cbHocKy.setModel(dcbk);
                }
                System.out.println(value);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Xin chọn dòng!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLMT;
    // End of variables declaration//GEN-END:variables
}
