
package vue;

import facade.GestionParkVoitures;
import java.util.Iterator;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import voiture.impl.Voiture;

/**
 *
 * @author Boubacar
 */
public class ListVoiture extends javax.swing.JFrame implements Vue {

  /**
   * Creates new form ListVoiture.
   */
  private GestionParkVoitures facade;
  DefaultTableModel modele;

  public ListVoiture(GestionParkVoitures facade) {
    this.facade = facade;
    facade.register(this);
    initComponents();
    this.addRowToJtable();

  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTable2 = new javax.swing.JTable();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    jSupprimerVoiture = new javax.swing.JToggleButton();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel2.setLayout(null);

    jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

    }, new String[] { "Numero", "Marque", "Mode", "Numero Moteur" }));
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable2MouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(jTable2);

    jPanel2.add(jScrollPane2);
    jScrollPane2.setBounds(35, 6, 550, 156);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

    }, new String[] { "Marque", "Largeur", "Hauteur", "Hiver" }));
    jScrollPane1.setViewportView(jTable1);

    jPanel2.add(jScrollPane1);
    jScrollPane1.setBounds(35, 200, 559, 262);

    jButton1.setText("Retour");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    jPanel2.add(jButton1);
    jButton1.setBounds(603, 78, 108, 29);

    jSupprimerVoiture.setText("supprimer");
    jSupprimerVoiture.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jSupprimerVoitureActionPerformed(evt);
      }
    });
    jPanel2.add(jSupprimerVoiture);
    jSupprimerVoiture.setBounds(603, 43, 108, 29);

    jLabel1.setIcon(
        new javax.swing.ImageIcon("/Users/lastking24/Downloads/parcImages/multi-storey-car-park-1271917_960_720.jpg")); // NOI18N
    jLabel1.setText("jLabel1");
    jPanel2.add(jLabel1);
    jLabel1.setBounds(0, 0, 1020, 480);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel2,
        javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable2MouseClicked
    // TODO add your handling code here:

    DefaultTableModel modele = (DefaultTableModel) jTable1.getModel();
    modele.getDataVector().removeAllElements();
    ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
    int row = jTable2.getSelectedRow();
    Integer index = Integer.parseInt((jTable2.getModel().getValueAt(row, 0).toString()));
    Object rowData[] = new Object[4];
    Voiture voiture = facade.getVoitures().get(index);
    for (int i = 0; i < voiture.getPneus().size(); i++) {
      rowData[0] = voiture.getPneus().get(i).getMarque();
      rowData[1] = voiture.getPneus().get(i).getLargeur();
      rowData[2] = voiture.getPneus().get(i).getHauteur();
      rowData[3] = voiture.getPneus().get(i).isHiver();
      modele.addRow(rowData);

    }
  }// GEN-LAST:event_jTable2MouseClicked

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
    CreerVoiture creerVoiture = new CreerVoiture(this.facade);
    creerVoiture.setVisible(true);
  }// GEN-LAST:event_jButton1ActionPerformed

  private void jSupprimerVoitureActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jSupprimerVoitureActionPerformed
    int row = jTable2.getSelectedRow();
    Integer index = Integer.parseInt((jTable2.getModel().getValueAt(row, 0).toString()));
    facade.supprimerVoiture(index);
    ListVoiture list = new ListVoiture(this.facade);
    list.setVisible(true);
  }// GEN-LAST:event_jSupprimerVoitureActionPerformed

  public void addRowToJtable() {
    this.modele = (DefaultTableModel) jTable2.getModel();
    Object rowData[] = new Object[4];
    Iterator it = facade.getVoitures().entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry voiture = (Map.Entry<Integer, Voiture>) it.next();
      rowData[0] = (Integer) voiture.getKey();
      rowData[1] = (String) ((Voiture) voiture.getValue()).getMarque();
      rowData[2] = (String) ((Voiture) voiture.getValue()).getModele();
      rowData[3] = (Integer) ((Voiture) voiture.getValue()).getMoteur().getNumeroSerie();
      modele.addRow(rowData);

    }

  }

  @Override
  public void update(GestionParkVoitures facede) {
    this.facade = facede;
    this.modele = (DefaultTableModel) jTable2.getModel();
    modele.getDataVector().removeAllElements();
    this.addRowToJtable();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JToggleButton jSupprimerVoiture;
  private javax.swing.JTable jTable1;
  private javax.swing.JTable jTable2;
  // End of variables declaration//GEN-END:variables

}