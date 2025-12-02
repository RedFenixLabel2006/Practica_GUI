import javax.swing.*;
import java.awt.event.*;
import java.lang.foreign.ValueLayout;

public class Eleccion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JTextField textField1;
    private ButtonGroup buttonGroup;

    public Eleccion() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        boolean valido = true;
        while(valido) {
            try{
                int num =  Integer.parseInt(textField1.getText());
                if(num >= 0) {
                    dispose();
                    valido = false;
                }else {
                    JOptionPane.showMessageDialog(null, "Numero no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                    textField1.setText("");
                }
                /*
                    // Opcional: obtener cuál radio button está seleccionado
                        if (radioButton1.isSelected()) {
                            System.out.println("Opción 1 seleccionada");
                        } else if (radioButton2.isSelected()) {
                            System.out.println("Opción 2 seleccionada");
                        } else if (radioButton3.isSelected()) {
                            System.out.println("Opción 3 seleccionada");
                        }
                */
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "El numero no puede ser una letra", "ERROR", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
                valido = false;
            }
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Eleccion dialog = new Eleccion();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
