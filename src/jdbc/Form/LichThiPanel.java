
package jdbc.Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdbc.LichThiMon;
import jdbc.SinhVien;

public class LichThiPanel extends javax.swing.JPanel {
    private SinhVien sv;
    
    public LichThiPanel() {
        initComponents();
    }

    public LichThiPanel(SinhVien sv){
        this();
        setSv(sv);
        Vector v = LichThiMon.getHocKy(sv); //lấy mã học kỳ của sinh vien đã đăng ký môn thi sau đó thêm vào combobox
        DefaultComboBoxModel dcbk = new DefaultComboBoxModel(v);
        this.cbHocKy.setModel(dcbk);
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
        cbHocKy = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLMT = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(152, 174, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHocKyActionPerformed
        String maHK = cbHocKy.getSelectedItem().toString();
        Vector v = new LichThiMon().getListMT(sv, maHK); //lấy danh sách các LichThiMon.toVector() của sinh viên đã đăng ký 
        Vector tieuDe= new Vector(); //Dach sách làm tiêu đề
        tieuDe.add("Mã KT"); 
        tieuDe.add("Tên Môn Thi");
        tieuDe.add("Ngày thi");
        tieuDe.add("Giờ thi");
        tieuDe.add("Số ĐK");
        tieuDe.add("CBThu");
        DefaultTableModel dtm = new DefaultTableModel(v,tieuDe); //đưa các danh sách và tiêu đề vào Model table
        jTableLMT.setModel(dtm);
        //-----------------Phần lọc ra những môn mà sinh viên chưa nộp lệ phí---------------------
        Vector str = new Vector();
        int d = jTableLMT.getRowCount(); //Đếm số dòng mà table hiện có
        while(d>0){
            if(dtm.getValueAt(d-1, 5).toString().equals("false")){//dtm.getValueAt(d-1, 5).toString() lấy giá trị của cột CBThu so sách với "false"
                str.add(dtm.getValueAt(d-1, 1));//add tên môn thi mà sinh viên chưa nộp vào vector str
                dtm.removeRow(d-1);//remove dòng 
                d--;
            }
            else
                d--;
        }
        for(int i=0;i<str.size();i++){
            JOptionPane.showMessageDialog(null, "ban chưa nộp lệ phí môn: " + str.get(i));
        }
    }//GEN-LAST:event_cbHocKyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLMT;
    // End of variables declaration//GEN-END:variables
}
