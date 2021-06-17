import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.*;
import java.awt.event.*;

public class MeuJSplitPane extends JFrame {
    private JList lstDiretorio;
    private File arquivoCorrente, dir[];
    private JLabel lbl;

    public MeuJSplitPane() {
        super("Estudando o SplitPane");
        Container tela = getContentPane();
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        arquivoCorrente = new File("imagens");
        dir = arquivoCorrente.listFiles();
        
        lstDiretorio = new JList();
    }

    public static void main(String[] args) {
        new MeuJSplitPane().setVisible(true);
    }
}
