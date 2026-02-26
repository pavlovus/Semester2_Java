package ua.com.laboratory02;

import org.w3c.dom.Node;

import java.awt.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainScreen extends JFrame {
    public Store<ItemGroup> store = new Store<>();
    private final JPanel groupsPanel;

    /**
     * Constructs the main application window.
     * Initializes all UI components including:
     * - Main container with scrollable panel
     * - Toolbar with action buttons
     * - Groups display area
     * Sets up event handlers for all actions.
     */
    public MainScreen() {
        super("єМагазин");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        groupsPanel = new JPanel();
        groupsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        groupsPanel.setBackground(new Color(173, 216, 230));

        JToolBar toolBar = new JToolBar();
        toolBar.setBackground(Color.decode("#E6F0FF"));
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setBorderPainted(false);
        toolBar.setOpaque(true);
        toolBar.setFocusable(false);
        toolBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        toolBar.setBorder(BorderFactory.createEmptyBorder(5, 15, 0, 15));
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        toolBar.setPreferredSize(new Dimension(100, 50));

        addToolBarButton(toolBar, "Додати групу товарів");
        toolBar.addSeparator(new Dimension(20, 0));
        addToolBarButton(toolBar, "Зберегти конфігурацію");
        toolBar.addSeparator(new Dimension(20, 0));
        addToolBarButton(toolBar, "Знайти товар");
        toolBar.addSeparator(new Dimension(20, 0));
        addToolBarButton(toolBar, "Вивести статистику складу");
        Component addTool = toolBar.getComponentAtIndex(0);
        Component saveTool = toolBar.getComponentAtIndex(2);
        Component findTool = toolBar.getComponentAtIndex(4);
        Component statTool = toolBar.getComponentAtIndex(6);
        ((JButton)findTool).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.this.setVisible(false);
                JFrame findStore = new JFrame("Пошук в магазині");
                findStore.setSize(800, 600);
                findStore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                findStore.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Пошук в магазині", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel searchContainer = new JPanel();
                searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.Y_AXIS));
                searchContainer.setBackground(new Color(173, 216, 230));
                searchContainer.setAlignmentX(Component.CENTER_ALIGNMENT);

                JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
                searchPanel.setBackground(new Color(173, 216, 230));
                searchPanel.setMaximumSize(new Dimension(600, 60));

                JTextField searchField = new JTextField(25);
                searchField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                searchField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 51, 153)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
                searchField.setMaximumSize(new Dimension(400, 40));

                ImageIcon icon = new ImageIcon(new ImageIcon("find.png")
                        .getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH));

                JButton searchButton = new JButton(icon);
                searchButton.setToolTipText("Шукати");
                searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                searchButton.setContentAreaFilled(false);
                searchButton.setOpaque(true);

                searchButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        searchButton.setBackground(new Color(0, 76, 153));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        searchButton.setBackground(new Color(0, 102, 204));
                    }
                });
                searchButton.setBackground(new Color(0, 102, 204));
                searchButton.setPreferredSize(new Dimension(120, 40));

                searchPanel.add(searchField);
                searchPanel.add(searchButton);

                searchContainer.add(searchPanel); // !!! без VerticalGlue

                JPanel itemsPanel = new JPanel(new GridBagLayout());
                itemsPanel.setBackground(new Color(173, 216, 230));
                JScrollPane scrollPane = new JScrollPane(itemsPanel);
                scrollPane.setBorder(BorderFactory.createEmptyBorder());
                scrollPane.getViewport().setBackground(new Color(173, 216, 230));
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                JPanel centerPanel = new JPanel();
                centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
                centerPanel.setBackground(new Color(173, 216, 230));
                centerPanel.add(searchContainer);
                centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
                centerPanel.add(scrollPane);

                JPanel buttonPanel = new JPanel();
                buttonPanel.setOpaque(false);
                JButton backButton = createStyledButton("Назад", new Color(0, 102, 204));
                backButton.addActionListener(ev -> {
                    findStore.dispose();
                    MainScreen.this.setVisible(true);
                });

                // Пошук і вивід товарів
                searchButton.addActionListener(ev -> {
                    itemsPanel.removeAll();

                    ArrayList<Item> foundItems = findItems(searchField.getText());
                    if (foundItems.isEmpty()) {
                        JOptionPane.showMessageDialog(findStore, "Схоже, що товарів з такою назвою не існує");
                    } else {
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.insets = new Insets(10, 10, 10, 10);
                        gbc.anchor = GridBagConstraints.WEST;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        gbc.weightx = 0.5;

                        for (int i = 0; i < foundItems.size(); i++) {
                            Item item = foundItems.get(i);

                            JLabel nameLabel = new JLabel(item.getName() + ": ");
                            nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                            nameLabel.setForeground(new Color(0, 51, 153));
                            gbc.gridx = 0;
                            gbc.gridy = i;
                            itemsPanel.add(nameLabel, gbc);

                            JLabel infoLabel = new JLabel(item.toString());
                            infoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
                            gbc.gridx = 1;
                            itemsPanel.add(infoLabel, gbc);
                        }
                    }
                    itemsPanel.revalidate();
                    itemsPanel.repaint();
                });

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(centerPanel, BorderLayout.CENTER);
                buttonPanel.add(backButton);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                findStore.add(mainPanel);
                findStore.setVisible(true);
            }
        });
        ((JButton)statTool).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.this.setVisible(false);
                JFrame statStore = new JFrame("Статистика магазину");
                statStore.setSize(800, 600);
                statStore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                statStore.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Статистика магазину", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel contentPanel = new JPanel(new GridBagLayout());
                contentPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                int sum = 0;
                for(int i = 0; i < store.size(); i++){
                    ItemGroup group = store.get(i);
                    JLabel groupLabel = new JLabel(group.getName() + ": ");
                    groupLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
                    groupLabel.setForeground(new Color(0, 51, 153));
                    gbc.gridx = 0;
                    gbc.gridy = i;
                    contentPanel.add(groupLabel, gbc);
                    String s = "";
                    for(Item item : group.getItems()){
                        s += item.getName() + "; ";
                        sum += item.getSum();
                    }
                    JLabel itemsLabel = new JLabel(s);
                    itemsLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
                    gbc.gridx = 1;
                    contentPanel.add(itemsLabel, gbc);
                }

                JLabel sumLabel = new JLabel("Загальна ціна товарів: ");
                sumLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                sumLabel.setForeground(new Color(0, 51, 153));
                JLabel sumValue = new JLabel(String.valueOf(sum));
                sumValue.setFont(new Font("Segoe UI", Font.BOLD, 20));

                gbc.gridx = 0;
                gbc.gridy = store.size();
                contentPanel.add(sumLabel, gbc);
                gbc.gridx = 1;
                contentPanel.add(sumValue, gbc);

                JScrollPane scrollPane = new JScrollPane(contentPanel);
                scrollPane.setBorder(null);
                scrollPane.getViewport().setBackground(new Color(173, 216, 230));
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
                buttonPanel.setOpaque(false);
                JButton okButton = createStyledButton("ОК", new Color(0, 102, 204));

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(scrollPane, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                okButton.addActionListener(ev -> {
                    statStore.dispose();
                    MainScreen.this.setVisible(true);
                });
                buttonPanel.add(okButton);

                statStore.add(mainPanel);
                statStore.setVisible(true);
            }
        });
        ((JButton) addTool).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.this.setVisible(false);
                JFrame inputGroup = new JFrame("Введіть дані про групу");
                inputGroup.setSize(800, 600);
                inputGroup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inputGroup.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Введіть дані про групу", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel formPanel = new JPanel(new GridBagLayout());
                formPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                JLabel nameLabel = new JLabel("Назва групи:");
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextField nameField = new JTextField(25);
                styleTextField(nameField);

                JLabel descrLabel = new JLabel("Опис групи:");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextArea descrTextArea = new JTextArea(5, 25);
                descrTextArea.setLineWrap(true);
                descrTextArea.setWrapStyleWord(true);
                styleTextArea(descrTextArea);

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
                buttonPanel.setOpaque(false);
                JButton saveButton = createStyledButton("Зберегти", new Color(0, 102, 204));
                JButton cancelButton = createStyledButton("Скасувати", new Color(153, 153, 153));

                gbc.gridx = 0;
                gbc.gridy = 0;
                formPanel.add(nameLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(nameField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                formPanel.add(descrLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(new JScrollPane(descrTextArea), gbc);

                buttonPanel.add(cancelButton);
                buttonPanel.add(saveButton);

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(formPanel, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);
                cancelButton.addActionListener(ev -> {
                    inputGroup.dispose();
                    MainScreen.this.setVisible(true);
                });
                saveButton.addActionListener(ev -> {
                    String text = nameField.getText();
                    if (text.isEmpty()) {
                        JOptionPane.showMessageDialog(inputGroup, "Група повинна мати якусь назву");
                    } else {
                    try {
                    addItemGroup(new ItemGroup(nameField.getText(), descrTextArea.getText()));
                    } catch (GroupUniquenessException ex) {
                        JOptionPane.showMessageDialog(inputGroup, "Група повинна з такою назвою вже існує");
                    }
                    addStoreToPanel();
                    inputGroup.dispose();
                    MainScreen.this.setVisible(true);}
                });
                inputGroup.add(mainPanel);
                inputGroup.setVisible(true);
            }
        });
        ((JButton)saveTool).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupFile groupFile = new GroupFile("data.dat");
                try {
                    groupFile.saveGroups(MainScreen.this.store);
                    JOptionPane.showMessageDialog(MainScreen.this, "Конфігурацію успішно збережено!", "Повідомлення конфігурації", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException _) {}
            }
        });
        mainPanel.add(toolBar, BorderLayout.NORTH);
        mainPanel.add(groupsPanel, BorderLayout.CENTER);
        add(scrollPane);
    }

    /**
     * Applies consistent styling to text fields.
     * @param field the JTextField to style
     */
    private void styleTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 51, 153)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    /**
     * Applies consistent styling to text areas.
     * @param area the JTextArea to style
     */
    private void styleTextArea(JTextArea area) {
        area.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        area.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 51, 153)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
    }

    /**
     * Searches for items matching the given string in their names.
     * @param str the search string to match against item names
     * @return ArrayList of matching Item objects, or null if input is null
     */
    public ArrayList<Item> findItems(String str) {
        if (str == null) return null;

        ArrayList<Item> res = new ArrayList<>();
        String searchQuery = str.toLowerCase();

        for (ItemGroup group : this.store) {
            for (Item item : group.getItems()) {
                String itemName = item.getName();
                if (itemName != null) {
                    if (itemName.toLowerCase().contains(searchQuery)) {
                        res.add(item);
                    }
                }
            }
        }
        return res;
    }

    /**
     * Creates a consistently styled button with specified text and background color.
     * @param text the button text
     * @param bgColor the background color
     * @return the created JButton
     */
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    /**
     * Adds a new item group to the store after validating its name uniqueness.
     * @param group the ItemGroup to add
     * @throws GroupUniquenessException if a group with the same name already exists
     */
    private void addItemGroup(ItemGroup group) throws GroupUniquenessException {
        for (ItemGroup group1 : this.store)
            if (group1.getName().equalsIgnoreCase(group.getName()))
                throw new GroupUniquenessException();
        this.store.add(group);
    }

    /**
     * Modifies an existing item group's properties after validating uniqueness of the new name.
     * @param oldname the original name of the group (for identification)
     * @param name the new name for the group
     * @param descr the new description
     * @throws GroupUniquenessException if a group with the new name already exists
     */
    public void changeItemGroup(String oldname, String name, String descr) throws GroupUniquenessException {
        for (ItemGroup group : this.store)
            if (group.getName().equalsIgnoreCase(name) && !group.getName().equalsIgnoreCase(oldname))
                throw new GroupUniquenessException();
        for (ItemGroup group : this.store)
            if (group.getName().equalsIgnoreCase(oldname)) {
                group.setName(name);
                group.setDescription(descr);
                return;
            }
    }

    /**
     * Refreshes the groups display panel by:
     * 1. Clearing all current groups
     * 2. Creating new JGroupPanel for each group in the store
     * 3. Updating the UI
     */
    void addStoreToPanel() {
        groupsPanel.removeAll();
        for (ItemGroup group : this.store) {
            JGroupPanel groupPanel = new JGroupPanel(groupsPanel, group, this);
        }
        groupsPanel.revalidate();
        groupsPanel.repaint();
    }

    /**
     * Creates and adds a styled button to the toolbar with hover effects.
     * @param toolbar the JToolBar to add the button to
     * @param text the text to display on the button
     */
    private void addToolBarButton(JToolBar toolbar, String text){
        JButton button = new JButton(text);
        button.setBackground(new Color(200, 220, 240));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setForeground(new Color(0, 51, 153));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(173, 216, 230)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0, 102, 204)),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(173, 216, 230)),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
            }
        });

        toolbar.add(button);
    }
}
