import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class FileNode extends DefaultMutableTreeNode {
    private final File file;

    public FileNode(File file) {
        super(file.getName());
        this.file = file;

        if (file.isDirectory()) {
            addChildren();
        }
    }

    private void addChildren() {
        File[] files = file.listFiles();

        // Обробка випадку, коли listFiles() повертає null
        if (files == null) return;

        for (File child : files) {
            // Додаємо тільки видимі файли/директорії
            if (!child.isHidden()) {
                add(new FileNode(child));
            }
        }
    }

    @Override
    public String toString() {
        return file.getName().isEmpty() ? file.getPath() : file.getName();
    }
}
