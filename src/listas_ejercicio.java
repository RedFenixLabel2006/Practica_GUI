import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class listas_ejercicio extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList<String> Lista;
    private JScrollPane scrollPane;

    public listas_ejercicio(String[] items) {
        // Crear los componentes
        contentPane = new JPanel(new BorderLayout(10, 10));
        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancelar");
        Lista = new JList<>(items);
        scrollPane = new JScrollPane(Lista);

        // Configurar la lista
        Lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Lista.setVisibleRowCount(10);// espacio para la lista
        Lista.setSelectionModel(new DefaultListSelectionModel() { // permite generar una lista y que nada sea seleccionable
            @Override
            public void setSelectionInterval(int index0, int index1) {
                // Evita cualquier selección
            }
        });

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonOK);
        buttonPanel.add(buttonCancel);

        // Agregar componentes al contentPane
        contentPane.add(new JLabel("Seleccione elementos:"), BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar márgenes
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configurar el diálogo
        setContentPane(contentPane);
        setModal(true);
        setTitle("Lista de Elementos");
        getRootPane().setDefaultButton(buttonOK);

        // Listeners
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

        // Llamar onCancel() cuando se cierra con la X
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    private void onOK() {
        // Obtener elementos seleccionados
        java.util.List<String> seleccionados = Lista.getSelectedValuesList();


        System.out.println("Elementos seleccionados:");
        for (String item : seleccionados) {
            System.out.println("  - " + item);
        }
        dispose();

    }

    private void onCancel() {
        System.out.println("Cancelado");
        dispose();
    }
}
    /*public static void main(String[] args) {
        // Usar SwingUtilities para el thread de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear la lista de elementos
                String[] lista = {
                        "Manzana",
                        "Pera",
                        "Naranja",
                        "Plátano",
                        "Uva",
                        "Sandía",
                        "Melón",
                        "Fresa",
                        "Piña",
                        "Kiwi"
                };

                // Crear y mostrar el diálogo
                listas_ejercicio dialog = new listas_ejercicio(lista);
                dialog.pack();
                dialog.setLocationRelativeTo(null); // Centrar en pantalla
                dialog.setVisible(true);

                // Después de cerrar el diálogo
                System.out.println("\nDiálogo cerrado");
            }
        });
    }
}
*/

/*public class listas_ejercicio extends JDialog {
    private JPanel contentPane;
    private JButton buttonVolver;
    private JList<String> Lista;
    private JScrollPane scrollPane;

    public listas_ejercicio(String[] items) {

        // Crear componentes
        contentPane = new JPanel(new BorderLayout(10, 10));
        buttonVolver = new JButton("Volver");
        Lista = new JList<>(items);
        scrollPane = new JScrollPane(Lista);

        // Evitar selección
        Lista.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                // No permite seleccionar
            }
        });

        Lista.setVisibleRowCount(10);

        // Panel del único botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonVolver);

        // Agregar componentes al contenedor
        contentPane.add(new JLabel("Lista de elementos (solo lectura):"), BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configurar diálogo
        setContentPane(contentPane);
        setModal(true);
        setTitle("Lista de Elementos");

        // Listener botón VOLVER
        buttonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // cerrar ventana
            }
        });

        // Cerrar con la X
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}*/