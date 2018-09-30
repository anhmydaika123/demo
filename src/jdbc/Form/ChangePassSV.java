/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.Form;

import javax.swing.JOptionPane;
import jdbc.GiaoVien;
import jdbc.SinhVien;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

/**
 *
 * @author nguye
 */
public class ChangePassSV extends javax.swing.JPanel {

    SinhVien sv = null;
    GiaoVien gv = null;

    public ChangePassSV() {
        initComponents();
    }

    public ChangePassSV(SinhVien sv) {
        this();
        setSv(sv);
    }

    public ChangePassSV(GiaoVien gv) {
        this();
        setGv(gv);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        oldPass = new javax.swing.JPasswordField();
        newPass = new javax.swing.JPasswordField();
        againPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Mật khẩu cũ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("Nhập lại mật khẩu mới:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setText("Mật khẩu mới:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 2, 0);
        add(oldPass, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(newPass, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 29, 0);
        add(againPass, gridBagConstraints);

        jButton1.setText("Thay đổi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String oldPass = String.valueOf(this.oldPass.getPassword());
        String newPass = String.valueOf(this.newPass.getPassword());
        String againPass = String.valueOf(this.againPass.getPassword());
        if (this.getSv() != null) {
            if (newPass.equals("")) {
                JOptionPane.showMessageDialog(null, "Moi nhập mật khẩu mới");
            } else if (!newPass.equals(againPass)) {
                JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu sai!");
            } else if (sv.thayDoiMatKhau(oldPass, newPass)) {
                JOptionPane.showMessageDialog(null, "successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ!");
            }
        }
        if (this.getGv() != null) {
            if (newPass.equals("")) {
                JOptionPane.showMessageDialog(null, "Moi nhập mật khẩu mới");
            } else if (!newPass.equals(againPass)) {
                JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu sai!");
            } else if (gv.thayDoiMatKhau(oldPass, newPass)) {
                JOptionPane.showMessageDialog(null, "successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public GiaoVien getGv() {
        return gv;
    }

    public void setGv(GiaoVien gv) {
        this.gv = gv;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField againPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JPasswordField oldPass;
    // End of variables declaration//GEN-END:variables
}
