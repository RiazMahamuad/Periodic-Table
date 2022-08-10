import ConectionMySQL.ConnectionProvider;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.temporal.TemporalAdjusters.next;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class TableList extends javax.swing.JFrame {

  
    public TableList() {
       
        initComponents();
         NothingFoundImage.setVisible(false);
         NothingText.setVisible(false);
        
       
    }
    public void searchAuto(String str)
    {
         int chackid=0;
        
        
        String Serial =Name.getText();
          if(Name.getText().trim().isEmpty())
            {
                jLabel1.setVisible(true);
                jLabel1.setText("Search only Atomic Number");
                 img1.setVisible(false);
                  NothingFoundImage.setVisible(false);
                  NothingText.setVisible(false);
                  
         
            }
          else if(Name.getText().trim().isEmpty())
          {
              jLabel1.setText("Search only Atomic Number");
              
             // img1.setVisible(false);
          }
          
          else
        try
        {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from image where Serial= '"+Serial+"'");
            while(rs.next())
            {
                chackid=1;
                byte[] img =rs.getBytes("image");
                ImageIcon image=new ImageIcon(img);
                Image im= image.getImage();
                Image myimg= im.getScaledInstance(img1.getWidth(), img1.getHeight(), WIDTH);
                ImageIcon newImage= new ImageIcon(myimg);
                img1.setIcon(newImage);
                img1.setVisible(true);
               //  NothingFoundImage.setVisible(true);
                 
            }
            
       
           if (chackid==0)
            {
                //JOptionPane.showMessageDialog(null," ID does not match");
               // final ImageIcon icon=new ImageIcon("Image/nothingFound.gif");
               // JOptionPane.showMessageDialog(null," ","tex",+JOptionPane.INFORMATION_MESSAGE,icon);
                img1.setVisible(false);
                 jLabel1.setVisible(false);
                NothingFoundImage.setVisible(true);
                NothingText.setVisible(true);
            }
        }
        catch(Exception e)
        {

            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     ResultSet rs;
   public class func
  {
      public ResultSet find(String s) throws SQLException
      {
         
           Connection con=ConnectionProvider.getCon();
           PreparedStatement pst=con.prepareStatement("select * from image where Serial=?");
           pst.setString(1, s);
           rs=pst.executeQuery();
          return null;
      }
  }
  * */
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Name = new javax.swing.JTextField();
        img1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NothingFoundImage = new javax.swing.JLabel();
        NothingText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(220, 240));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1480, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1480, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Name.setBackground(new java.awt.Color(32, 33, 36));
        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setBorder(null);
        Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameFocusLost(evt);
            }
        });
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameKeyReleased(evt);
            }
        });
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 500, 20));
        Name.getAccessibleContext().setAccessibleParent(this);

        img1.setForeground(new java.awt.Color(32, 33, 36));
        jPanel1.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 1070, 420));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/searchBar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 810, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("Search only Atomic Number");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 510, 90));

        NothingFoundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nothingFound.gif"))); // NOI18N
        jPanel1.add(NothingFoundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 170, 120));

        NothingText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NothingText.setForeground(new java.awt.Color(255, 255, 255));
        NothingText.setText("Nothing Found...");
        jPanel1.add(NothingText, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusLost
        // TODO add your handling code here:
      
    }//GEN-LAST:event_NameFocusLost

    private void NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameFocusGained
        // TODO add your handling code here:
        // jLabel2.setVisible(false);
      
    }//GEN-LAST:event_NameFocusGained

    private void NameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameKeyReleased
        // TODO add your handling code here:
        
        String SearchString=Name.getText();
        searchAuto(SearchString);
      
        
    }//GEN-LAST:event_NameKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NothingFoundImage;
    private javax.swing.JLabel NothingText;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
