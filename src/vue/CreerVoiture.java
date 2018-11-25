
package vue;

import facade.GestionParkVoitures;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Boubacar DIALLO
 */
@SuppressWarnings("serial")
public class CreerVoiture extends javax.swing.JFrame implements Vue {

  /**
   * Creates new form CreerVoiture
   */
  GestionParkVoitures face;

  /**
   * 
   * @param facade
   */
  public CreerVoiture(GestionParkVoitures facade) {
    initComponents();
    face = facade;
    face.register(this);
  }

  
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDialog1 = new javax.swing.JDialog();
    jDialog2 = new javax.swing.JDialog();
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    fichierPath = new javax.swing.JTextField();
    ListeVoiture = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();

    javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
    jDialog1.getContentPane().setLayout(jDialog1Layout);
    jDialog1Layout.setHorizontalGroup(
        jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
    jDialog1Layout.setVerticalGroup(
        jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

    javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
    jDialog2.getContentPane().setLayout(jDialog2Layout);
    jDialog2Layout.setHorizontalGroup(
        jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
    jDialog2Layout.setVerticalGroup(
        jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(null);
    jPanel1.add(jLabel2);
    jLabel2.setBounds(85, 255, 0, 0);

    jButton1.setText("Creer voiture avec XML");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton1);
    jButton1.setBounds(85, 113, 288, 29);

    jButton2.setText("Creer voiture");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton2);
    jButton2.setBounds(85, 213, 288, 29);
    jPanel1.add(fichierPath);
    fichierPath.setBounds(428, 113, 195, 26);

    ListeVoiture.setText("Liste voiture");
    ListeVoiture.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ListeVoitureActionPerformed(evt);
      }
    });
    jPanel1.add(ListeVoiture);
    ListeVoiture.setBounds(93, 273, 280, 29);

    jButton3.setText("Acceil");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });
    jPanel1.add(jButton3);
    jButton3.setBounds(430, 210, 122, 29);

    jLabel3.setIcon(new javax.swing.ImageIcon("/Users/lastking24/Downloads/parcImages/IPARC.jpg")); // NOI18N
    jLabel3.setText("jLabel3");
    jPanel1.add(jLabel3);
    jLabel3.setBounds(0, 0, 860, 400);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1,
        javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void ListeVoitureActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ListeVoitureActionPerformed
    ListVoiture listVoiture = new ListVoiture(this.face);
    listVoiture.setVisible(true);
    this.setVisible(false);

  }// GEN-LAST:event_ListeVoitureActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    CreerVoitureInput creerVoitureInput = new CreerVoitureInput(this.face);
    creerVoitureInput.setVisible(Boolean.TRUE);
    this.setVisible(false);
  }// GEN-LAST:event_jButton2ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null);
    File file = fileChooser.getSelectedFile();
    String absolutePathOfFile = file.getAbsolutePath();
    fichierPath.setText(absolutePathOfFile);
    face.creerVoitureApartirXml(absolutePathOfFile);
    // Boîte du message d'information
    JOptionPane jop1;
    jop1 = new JOptionPane();
    jop1.showMessageDialog(null, "contenu fichier XML est importé", "Information", JOptionPane.INFORMATION_MESSAGE);
  }// GEN-LAST:event_jButton1ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    Accueil accueil = new Accueil(this.face);
    accueil.setVisible(true);
  }// GEN-LAST:event_jButton3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ListeVoiture;
  private javax.swing.JTextField fichierPath;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JDialog jDialog1;
  private javax.swing.JDialog jDialog2;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  // End of variables declaration//GEN-END:variables

  @Override
  public void update(GestionParkVoitures facede) {
    this.face = facede;
  }
}
