import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listar_cosechadores extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTable table1;


    private String [] columnas= {"Rut",
            "Nombre",
            "Dirección",
            "Email",
            "Fecha Nac",
            "Nro Cuadrillas",
            "Monto Impago $",
            "Monto Pagado $"
    };

    public Listar_cosechadores() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        cargarDatosTabla();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        Listar_cosechadores dialog = new Listar_cosechadores();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void cargarDatosTabla() {

        int filas = 10;
        String[][] datos = new String[filas][columnas.length];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas.length; j++) {
                datos[i][j] = "a";
            }
        }

        table1.setModel(new DefaultTableModel(datos, columnas));
    }
}
