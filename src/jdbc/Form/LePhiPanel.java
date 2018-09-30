/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.Form;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.GiaoVien;

public class LePhiPanel extends javax.swing.JPanel {

    GiaoVien gv = null;
    DefaultTableModel dtm;

    public LePhiPanel() {
        initComponents();
    }

    public LePhiPanel(GiaoVien gv) {
        this();
        setGv(gv);
    }

    public GiaoVien getGv() {
        return gv;
    }

    public void setGv(GiaoVien gv) {
        this.gv = gv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMT = new javax.swing.JTable();
        btThuPhi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();

        jTableMT.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMT);

        btThuPhi.setText("Thu Phí");
        btThuPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThuPhiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel1.setText("Mã sinh viên:");

        txtMaSV.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        btSearch.setText("Tìm");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThuPhi)
                .addGap(316, 316, 316))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btThuPhi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMTMouseClicked

    }//GEN-LAST:event_jTableMTMouseClicked

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        String maSV = txtMaSV.getText();
        Vector v = gv.sinhVienDK(maSV);//lấy ra danh sách sinh viên đó chưa nộp tiền
        Vector tieuDe = new Vector();
        tieuDe.add("Họ");
        tieuDe.add("Tên");
        tieuDe.add("Mã KT");
        tieuDe.add("Tên Môn Thi");
        tieuDe.add("Ngày thi");
        tieuDe.add("Giờ thi");
        tieuDe.add("Số ĐK");
        tieuDe.add("Lệ phí");
        tieuDe.add("CBThu");
        dtm = new DefaultTableModel(v, tieuDe);
        jTableMT.setModel(dtm);
    }//GEN-LAST:event_btSearchActionPerformed

    private void btThuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThuPhiActionPerformed
        int i = jTableMT.getSelectedRow(); //lấy vị trí dòng mình chọn
        if (i >= 0) {
            String maSv = txtMaSV.getText();//lấy mã sinh viên từ text field
            String maKT = dtm.getValueAt(i, 2).toString(); //lấy mã kỳ thi từ table
            dtm.removeRow(i); //xóa dòng hiện tại
            if(gv.thuPhi(maSv, maKT))//thao tác thu phí
                JOptionPane.showMessageDialog(null, "ok");
            else
                JOptionPane.showMessageDialog(null, "Error");
        } else {
            JOptionPane.showMessageDialog(null, "Xin chọn dòng!");
        }
    }//GEN-LAST:event_btThuPhiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btThuPhi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMT;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
