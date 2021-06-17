import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.awt.*;

public class MeuJList extends JFrame implements ListSelectionListener, ActionListener {
    private DefaultListModel<String> modeloLista;
    private JPanel pnNorte;
    private JPanel pnCentro;
    private JPanel pnSul;
    private JList<String> lstCor;
    //private JLabel lblSelecionado;
    private JTextField txtValor;
    private JTextArea taTexto;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    public MeuJList() {
        super("Estudando JList");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container tela = getContentPane();
        tela.setLayout(new BorderLayout());

        txtValor = new JTextField();
        pnNorte = new JPanel();
        pnNorte.setLayout(new GridLayout(1, 2, 5, 5));
        pnNorte.add(txtValor);

        modeloLista = new DefaultListModel<String>();
        modeloLista.addElement("Amarelo");
        modeloLista.addElement("Vermelho");
        modeloLista.addElement("Verde");
        modeloLista.addElement("Azul");
        modeloLista.addElement("Preto");
        modeloLista.addElement("Laranja");
        modeloLista.addElement("Branco");
        modeloLista.addElement("Rosa");

        lstCor = new JList<String>(modeloLista);
        lstCor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstCor.addListSelectionListener(this);

        taTexto = new JTextArea();
        pnCentro = new JPanel();
        pnCentro.setLayout(new GridLayout(1, 2, 5, 5));
        pnCentro.add(new JScrollPane(lstCor));
        pnCentro.add(taTexto);

        btn1 = new JButton("Excluir Item");
        btn1.addActionListener(this);
        btn2 = new JButton("Quantidade de itens");
        btn2.addActionListener(this);
        btn3 = new JButton("Mostrar texto");
        btn3.addActionListener(this);
        btn4 = new JButton("Excluir todos");
        btn4.addActionListener(this);
        btn5 = new JButton("Inserir item");
        btn5.addActionListener(this);
        btn6 = new JButton("Botao 6");
        btn7 = new JButton("Botao 7");
        btn8 = new JButton("Botao 8");

        pnSul = new JPanel();
        pnSul.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnSul.setPreferredSize(new Dimension(400, 150));
        pnSul.setBackground(new Color(190, 190, 190));
        
        pnSul.add(btn1);
        pnSul.add(btn2);
        pnSul.add(btn3);
        pnSul.add(btn4);
        pnSul.add(btn5);
        pnSul.add(btn6);
        pnSul.add(btn7);
        pnSul.add(btn8);

        tela.add(pnNorte, BorderLayout.NORTH);
        tela.add(pnCentro, BorderLayout.CENTER);
        tela.add(pnSul, BorderLayout.SOUTH);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == lstCor) {
            /* Color[] selCor = {Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.ORANGE, Color.WHITE, Color.PINK};
            Color cor = selCor[lstCor.getSelectedIndex()];
            lstCor.setBackground(cor);
            lblSelecionado.setText("Selecionado: " + lstCor.getSelectedValue()); */
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int indice = lstCor.getSelectedIndex();
        
        if (e.getSource() == btn1) {
            modeloLista.remove(indice);
        }
        
        int tamanho = modeloLista.getSize();

        if (tamanho == modeloLista.getSize()) {
            if (tamanho <= 0) {
                btn1.setEnabled(false);
            } else {
                if (indice == modeloLista.getSize()) {
                    indice--;
                }
            }
        }

        lstCor.setSelectedIndex(indice);

        if (e.getSource() == btn2) {
            taTexto.setText("Quantidade de itens: " + tamanho);
        }

        if (e.getSource() == btn3) {
            txtValor.setText("texto: " + lstCor.getSelectedValue());
        }

        if (e.getSource() == btn4) {
            modeloLista.removeAllElements();
        }

        if (e.getSource() == btn5) {
            if (indice == -1) {
                indice = 0;
            } else {
                indice++;
            }

            modeloLista.insertElementAt(txtValor.getText(), indice);
        }
    }

    public static void main(String[] args) {
        new MeuJList().setVisible(true);
    }
}