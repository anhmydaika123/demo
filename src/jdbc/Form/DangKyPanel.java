
package jdbc.Form;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import jdbc.*;

public class DangKyPanel extends javax.swing.JPanel {
        
    private SinhVien sv;
    
    public DangKyPanel() {
        initComponents();
    }
    
    public DangKyPanel(SinhVien sv){
        this();
        setSv(sv);
        Vector v = LichThiMon.getHocKy();//Lấy mã học kỳ để đưa vào Combobox
        DefaultComboBoxModel dcbk = new DefaultComboBoxModel(v);
        this.CBListKyThi.setModel(dcbk);
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

        jLabel1 = new javax.swing.JLabel();
        CBListMonThi = new javax.swing.JComboBox<>();
        jButtonDK = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CBListKyThi = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Chọn kỳ thi:");

        CBListMonThi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButtonDK.setText("Đăng ký");
        jButtonDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Chọn môn thi: ");

        CBListKyThi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        CBListKyThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBListKyThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDK)
                    .addComponent(CBListKyThi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBListMonThi, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBListKyThi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBListMonThi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addComponent(jButtonDK)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CBListKyThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBListKyThiActionPerformed
        String maHK = CBListKyThi.getSelectedItem().toString(); 
        Vector<LichThiMon> vl = LichThiMon.getKyThi(maHK); //láy danh sách LichThiMon để thêm vào Combobox các môn thi
        DefaultComboBoxModel dcbl = new DefaultComboBoxModel(vl);
        this.CBListMonThi.setModel(dcbl);
    }//GEN-LAST:event_CBListKyThiActionPerformed

    private void jButtonDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDKActionPerformed
        LichThiMon ltm = (LichThiMon) CBListMonThi.getSelectedItem();
        DangKyThi dk = new DangKyThi();
        if(dk.dangKyThi(sv,ltm.getMaKT()))
            JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
        else
            JOptionPane.showMessageDialog(null, "Thất bại!");
    }//GEN-LAST:event_jButtonDKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBListKyThi;
    private javax.swing.JComboBox<String> CBListMonThi;
    private javax.swing.JButton jButtonDK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
