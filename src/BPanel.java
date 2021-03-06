
import java.awt.Color;

/**
 *
 * @author xx450
 */
public class BPanel extends javax.swing.JPanel implements Comparable<BPanel> {

    private final Chrono chrono;
    private final JTimeForm parent;
    private final String label;

    /**
     * Creates new form BPanel
     */
    public BPanel(String label, int i, JTimeForm parent) {
        initComponents();
        this.setDefaultColor();
        this.label = label;
        this.jButton1.setText(label);
        this.chrono = new Chrono();
        this.parent = parent;

    }

    public void updateText() {
        this.jButton1.setText(this.label + " " + this.chrono.toString());
        this.revalidate();
    }

    public Chrono getChrono() {
        return chrono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItem2);

        jButton1.setText("jButton1");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMargin(new java.awt.Insets(0, 5, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.chrono.isStarted()) {
            this.parent.stopAll();
        } else {
            this.parent.stopAll();
            this.setAlternativeColor();
            this.getChrono().start();
        }
        this.parent.update();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    void setDefaultColor() {
        this.jButton1.setBackground(new Color(238, 238, 238));
        this.jButton1.setForeground(new Color(50, 50, 50));
    }

    void setAlternativeColor() {
        this.jButton1.setBackground(new Color(238, 100, 100));
        this.jButton1.setForeground(Color.white);
    }

    @Override
    public int compareTo(BPanel o) {
        this.chrono.normalize();
        int ret = Long.compare(o.getChrono().getTotal(), this.chrono.getTotal());
        if (ret == 0) {
            ret = this.label.compareTo(o.label);
        }
        return ret;
    }
}
