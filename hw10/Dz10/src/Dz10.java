/* Домашнє завдання №10, Вус Павло, ІПЗ-1, група №6
 * Написати графічну програму, що показує файлову систему у вигляді дерева і дозволяє по ній переміщуватися, розкриваючи та закриваючи підкаталоги*/
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;

public class Dz10 extends JFrame {
    private JTree tree;

    public Dz10() {
        super("Домашнє завдання №10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        File rootFile = new File("C:/");
        DefaultMutableTreeNode rootNode = new FileNode(rootFile);

        DefaultTreeModel model = new DefaultTreeModel(rootNode);
        tree = new JTree(model);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Dz10 frame = new Dz10();
        frame.setVisible(true);
    }
}