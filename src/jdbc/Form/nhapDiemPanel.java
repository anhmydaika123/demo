
package jdbc.Form;

import javax.swing.JOptionPane;
import jdbc.GiaoVien;


public class nhapDiemPanel extends javax.swing.JPanel {

    private GiaoVien gv = null;
    public nhapDiemPanel() {
        initComponents();
    }
    
    public nhapDiemPanel(GiaoVien gv){
        this();
        setGv(gv);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaKT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Mã sinh viên:");

        txtMaSV.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Mã kỳ thi:");

        txtMaKT.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel3.setText("Điểm:");

        txtDiem.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtDiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemKeyTyped(evt);
            }
        });

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btOK)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btOK)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        String maSV = txtMaSV.getText();
        String maKT = txtMaKT.getText();
        int diem = (int) txtDiem.getText().charAt(0) - 48; // chuyển rổi kiểu char thành kiểu số int
        if(gv.nhapDiem(maSV, maKT, diem))
            JOptionPane.showMessageDialog(null, "Đã nhập: " + diem + " điểm");
        else
            JOptionPane.showMessageDialog(null, "Error!!!");
    }//GEN-LAST:event_btOKActionPerformed

    private void txtDiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemKeyTyped
        char ch = evt.getKeyChar();
        if(ch<'0' || ch>'9') evt.setKeyChar('\0'); // ràng buộc người nhập
        
    }//GEN-LAST:event_txtDiemKeyTyped

    public GiaoVien getGv() {
        return gv;
    }

    public void setGv(GiaoVien gv) {
        this.gv = gv;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtMaKT;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
