/*
 * ClientFrame类定义了客户端的主界面，通过可视化方式生成
 * 包括两个列表（在线用户列表和聊天用户列表）、聊天显示区域、输入框、以及发送按钮
 * 使用方法：
 * 1.在在线用户列表中，鼠标右键点击，可选择将用户添加到聊天列表
 * 2.在聊天用户列表中，鼠标右键点击，可选择将用户移出聊天用户列表
 * 3.输入框中的消息会发送至聊天列表中的所有用户
 * 4.send按钮发送消息
 * 5.消息以“username：”方式开头，发送和接收的消息都会在聊天显示区域显示
 */
package views;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import p2pclient.P2PClient;

/**
 *
 * @author ws
 */
public class ClientFrame extends javax.swing.JFrame {

    private P2PClient client;
    public String username;
    public DefaultListModel model_list1;

    /**
     * Creates new form ClientFrame
     */
    public ClientFrame() {

  
        client = new P2PClient(this);
        client.register();
        initComponents();
        this.setTitle(username);
        while(model_list1==null)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.jList1.setModel(model_list1);
        DefaultListModel model = new DefaultListModel();
        this.jList2.setModel(model);
    }


    public void appendText(String data) {
        String message = this.jEditorPane1.getText();
        message = message + data + "\n";
        this.jEditorPane1.setText(message);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jSplitPane5 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jSplitPane6 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jPopupMenu1.setLabel("");
        jPopupMenu1.setName("add to chat list"); // NOI18N

        jMenuItem3.setText("add to chat list");
        jMenuItem3.setName("add"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jMenuItem4.setText("remove from chat list");
        jMenuItem4.setName("remove from chat list"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(190);

        jSplitPane2.setDividerLocation(370);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setAutoscrolls(true);

        jScrollPane2.setAutoscrolls(true);

        jEditorPane1.setEditable(false);
        jScrollPane2.setViewportView(jEditorPane1);

        jSplitPane2.setTopComponent(jScrollPane2);

        jSplitPane3.setDividerLocation(350);

        jEditorPane2.setPreferredSize(new java.awt.Dimension(250, 21));
        jScrollPane3.setViewportView(jEditorPane2);

        jSplitPane3.setLeftComponent(jScrollPane3);

        jButton1.setText("发送");
        jButton1.setPreferredSize(new java.awt.Dimension(20, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jSplitPane3.setRightComponent(jButton1);

        jSplitPane2.setRightComponent(jSplitPane3);

        jSplitPane1.setRightComponent(jSplitPane2);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        jSplitPane4.setDividerLocation(90);
        jSplitPane4.setAutoscrolls(true);

        jScrollPane4.setAutoscrolls(true);
        jScrollPane4.setHorizontalScrollBar(null);

        jSplitPane5.setDividerLocation(30);
        jSplitPane5.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane5.setAutoscrolls(true);

        jLabel1.setText("UserList");
        jSplitPane5.setTopComponent(jLabel1);

        jScrollPane6.setAutoscrolls(true);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jList1);

        jSplitPane5.setRightComponent(jScrollPane6);

        jScrollPane4.setViewportView(jSplitPane5);

        jSplitPane4.setLeftComponent(jScrollPane4);

        jScrollPane5.setAutoscrolls(true);
        jScrollPane5.setHorizontalScrollBar(null);

        jSplitPane6.setDividerLocation(30);
        jSplitPane6.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane6.setAutoscrolls(true);

        jLabel2.setText("ChatList");
        jSplitPane6.setTopComponent(jLabel2);

        jScrollPane7.setAutoscrolls(true);

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jList2);

        jSplitPane6.setRightComponent(jScrollPane7);

        jScrollPane5.setViewportView(jSplitPane6);

        jSplitPane4.setRightComponent(jScrollPane5);

        jScrollPane1.setViewportView(jSplitPane4);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Setup");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    Object[] users = this.jList2.getSelectedValues();
    DefaultListModel listModel = (DefaultListModel) jList2.getModel();
    for (Object user : users) {
        listModel.removeElement(user);
    }
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    if (evt.getButton() == 3 && this.jList1.getSelectedIndex() >= 0) {
        this.jPopupMenu1.removeAll();
        this.jPopupMenu1.add(jMenuItem3);
        this.jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }
}//GEN-LAST:event_jList1MouseClicked

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    Object[] users = this.jList1.getSelectedValues();
    DefaultListModel listModel = (DefaultListModel) jList2.getModel();
    for (Object user : users) {
        listModel.addElement(user);
    }
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
    if (evt.getButton() == 3 && this.jList2.getSelectedIndex() >= 0) {
        this.jPopupMenu1.removeAll();
        this.jPopupMenu1.add(jMenuItem4);
        this.jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
    }
}//GEN-LAST:event_jList2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String message = this.jEditorPane2.getText();
        DefaultListModel model = (DefaultListModel) jList2.getModel();
        Object[] elements = model.toArray();
        this.client.sendMessage(elements, message);
        this.jEditorPane2.setText("");
        this.appendText(this.username+":"+message);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    // End of variables declaration//GEN-END:variables
}
