import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton btnOK;
    private JTextField tfName;
    private JPanel jpanel;
    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JRadioButton rbOther;
    private JTextArea taOutput;
    private JComboBox cbProgram;
    private JCheckBox cbC;
    private JCheckBox cbJava;
    private JCheckBox cbCpp;

    public GUI() {
        JRadioButton btngrpGender[] = { rbMale, rbFemale, rbOther };
        JCheckBox cbgrpLanguages[] = { cbC, cbJava, cbCpp };
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                if (name.equals("")) {
                    tfName.setText(JOptionPane.showInputDialog(null, "Please don't forget to enter your name!"));
                    return;
                }
                if (cbProgram.getSelectedIndex() == 0) {
                    int res = JOptionPane.showConfirmDialog(null, "No program. Use BSCS?");
                    if (res == JOptionPane.YES_OPTION) {
                        cbProgram.setSelectedIndex(1);
                    }
                    return;
                }
                String gender;
                String language = "";
                taOutput.setText("Hello, " + name + "!");
                int ctr_progs = 0;
                for (JRadioButton rb : btngrpGender) {
                    if (rb.isSelected()) {
                        gender = rb.getText();
                        taOutput.append("\nYou are a " + gender);
                    }
                }
                for (JCheckBox cb : cbgrpLanguages) {
                    if (cb.isSelected()) {
                        ctr_progs++;
                    }
                }
                if (ctr_progs == 0) {
                    taOutput.append("\nNo languages learned yet.");
                } else {
                    taOutput.append("\nYour programming languages: ");
                    for (JCheckBox cb : cbgrpLanguages) {
                        if (cb.isSelected()) {
                            taOutput.append(cb.getText() + ", ");
                        }
                    }
                }
                taOutput.append("\nYour program is " + cbProgram.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        GUI app = new GUI();
        app.setContentPane(app.jpanel);
        app.setSize(1000, 400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Windows Dialog");
        app.setVisible(true);
    }
}
