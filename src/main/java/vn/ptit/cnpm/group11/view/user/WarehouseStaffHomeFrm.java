/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.ptit.cnpm.group11.view.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vn.ptit.cnpm.group11.model.User;
import vn.ptit.cnpm.group11.view.provider.SearchProviderFrm;

/**
 *
 * @author Admin
 */
public class WarehouseStaffHomeFrm extends javax.swing.JFrame implements ActionListener{
    private User user;
    /**
     * Creates new form WarehouseStaffHomeView
     */
    public WarehouseStaffHomeFrm(User user) {
        initComponents();
        this.user = user;
        this.setLocationRelativeTo(null);
        this.lblWarehouseStaffName.setText(user.getFullName());
        
        addActionListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWarehouseStaffHomeView = new javax.swing.JLabel();
        lblWarehouseStaffName = new javax.swing.JLabel();
        btnImportBookTitle = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblWarehouseStaffHomeView.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblWarehouseStaffHomeView.setText("Trang chủ nhân viên kho");

        lblWarehouseStaffName.setText("Tên nhân viên kho");

        btnImportBookTitle.setText("Nhập truyện từ nhà cung cấp");

        btnCancel.setText("Huỷ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWarehouseStaffHomeView, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImportBookTitle)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWarehouseStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblWarehouseStaffHomeView, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblWarehouseStaffName)
                .addGap(36, 36, 36)
                .addComponent(btnImportBookTitle)
                .addGap(27, 27, 27)
                .addComponent(btnCancel)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(WarehouseStaffHomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(WarehouseStaffHomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(WarehouseStaffHomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(WarehouseStaffHomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WarehouseStaffHomeFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImportBookTitle;
    private javax.swing.JLabel lblWarehouseStaffHomeView;
    private javax.swing.JLabel lblWarehouseStaffName;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() instanceof JButton)) {
            if (e.getSource().equals(btnCancel)) {
                this.dispose();
                LoginFrm loginFrm = new LoginFrm();
                loginFrm.setVisible(true);
            } else if (e.getSource().equals(btnImportBookTitle)) {
                SearchProviderFrm searchProviderFrm = new SearchProviderFrm(user);
                searchProviderFrm.setVisible(true);
            }
            
        } 
    }
    private void addActionListener(){
        btnImportBookTitle.addActionListener(this);
        btnCancel.addActionListener(this);
    }
}
