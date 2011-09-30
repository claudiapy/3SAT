/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentanaPrincipal.java
 *
 * Created on 30/09/2011, 05:51:17 AM
 */
package py.una.ia.sat.ui;

import com.py.mbaez.porandu.util.EditableTableModel;
import javax.swing.UIManager;
import py.una.ia.sat.Generador;
import py.una.ia.sat.Problema;

/**
 *
 * @author Maximiliano Báez González <mxbg.py@gmail.com>
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    EditableTableModel tableModel;

    /** Creates new form VentanaPrincipal */
    public VentanaPrincipal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }
        String columnName[] = {"Backtracking", "Las Vegas", "MVR"};
        Class clazz[] = new Class[3];
        boolean editable[] = new boolean[3];

        for (int i = 0; i < 3; i++) {
            clazz[i] = Object.class;
            editable[i] = false;
        }

        tableModel = new EditableTableModel(columnName, clazz, editable);

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        clausulasTextField = new javax.swing.JTextField();
        variablesTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        pruebasTextField = new javax.swing.JTextField();
        iniciarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3SAT");

        jLabel1.setText("Clausulas:");

        jLabel2.setText("Variables:");

        clausulasTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                clausulasTextFieldKeyTyped(evt);
            }
        });

        variablesTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variablesTextFieldKeyTyped(evt);
            }
        });

        resultadosTable.setModel(tableModel);
        jScrollPane1.setViewportView(resultadosTable);

        jLabel3.setText("Pruebas :");

        pruebasTextField.setText("1");
        pruebasTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pruebasTextFieldKeyTyped(evt);
            }
        });

        iniciarButton.setText("Iniciar");
        iniciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(variablesTextField)
                                    .addComponent(clausulasTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pruebasTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(iniciarButton)
                        .addGap(165, 165, 165)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clausulasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(pruebasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(variablesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iniciarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarButtonActionPerformed
        int N = Integer.parseInt(pruebasTextField.getText());
        int clausulas = Integer.parseInt(clausulasTextField.getText());
        int variables = Integer.parseInt(variablesTextField.getText());

        Generador gen = new Generador(variables, clausulas);
        long backTime = 0;
        long vegasTime = 0;
        long mvrTime = 0;
        tableModel.removeRow();
        for (int i = 0; i < N; i++) {

            String expresion = gen.generarExpresion();
            Problema p1 = new Problema(expresion);
            Problema p2 = new Problema(expresion);
            Problema p3 = new Problema(expresion);
            long start = System.currentTimeMillis();
            p1.ResolverBacktracking();
            System.out.println("Backtraking...");
            long endBack = System.currentTimeMillis();
            p2.ResolverLasVegas();
            System.out.println("Las Vegas...");
            long endVegas = System.currentTimeMillis();
            p3.ResolverMVR();
            System.out.println("MVR....");
            long endMVR = System.currentTimeMillis();
            Object row[] = {endBack - start + "ms.", endVegas - endBack + "ms.", endMVR - endVegas + "ms."};
            tableModel.addRow(row);
            backTime += endBack - start;
            vegasTime += endVegas - endBack;
            mvrTime += endMVR - endVegas;
            System.out.println(row);

        }
        Object row[] = {backTime / N + "ms.", vegasTime / N + "ms.", mvrTime / N + "ms."};
        tableModel.addRow(row);

    }//GEN-LAST:event_iniciarButtonActionPerformed

    private void clausulasTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clausulasTextFieldKeyTyped
        
      if (!('0' <= evt.getKeyChar() && '9' >= evt.getKeyChar()))
          evt.consume();
    }//GEN-LAST:event_clausulasTextFieldKeyTyped

    private void variablesTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variablesTextFieldKeyTyped
       if (!('0' <= evt.getKeyChar() && '9' >= evt.getKeyChar()))
          evt.consume();
    }//GEN-LAST:event_variablesTextFieldKeyTyped

    private void pruebasTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pruebasTextFieldKeyTyped
        if (!('0' <= evt.getKeyChar() && '9' >= evt.getKeyChar()))
          evt.consume();
    }//GEN-LAST:event_pruebasTextFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clausulasTextField;
    private javax.swing.JButton iniciarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pruebasTextField;
    private javax.swing.JTable resultadosTable;
    private javax.swing.JTextField variablesTextField;
    // End of variables declaration//GEN-END:variables
}
