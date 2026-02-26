package ua.com.laboratory02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

public class ItemScreen extends JFrame {
    public ItemGroup itemGroup;
    private final JPanel itemsPanel;
    public MainScreen mainScreen;

    /**
     * Constructs an ItemScreen for the specified item group.
     * Initializes all UI components including:
     * - Main container with scrollable panel
     * - Toolbar with navigation buttons
     * - Item display area
     * - Form for adding new items
     *
     * @param itemGroup the ItemGroup to display and manage
     * @param mframe the parent MainScreen for navigation purposes
     */
    public ItemScreen(ItemGroup itemGroup, MainScreen mframe) {
        super("єМагазин");
        this.mainScreen = mframe;
        this.itemGroup = itemGroup;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        itemsPanel = new JPanel();
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(new Color(173, 216, 230));

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

        addToolBarButton(toolBar, "Назад");
        toolBar.addSeparator(new Dimension(20, 0));
        addToolBarButton(toolBar, "Додати товар");
        Component backTool = toolBar.getComponentAtIndex(0);
        Component addTool = toolBar.getComponentAtIndex(2);

        ((JButton)backTool).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemScreen.this.setVisible(false);
                mframe.setVisible(true);
                ItemScreen.this.dispose();
            }
        });
        ((JButton) addTool).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemScreen.this.setVisible(false);
                JFrame inputProduct = new JFrame("Введіть дані про товар");
                inputProduct.setSize(800, 600);
                inputProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inputProduct.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Введіть дані про товар", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel formPanel = new JPanel(new GridBagLayout());
                formPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                // Назва товару (Product name)
                JLabel nameLabel = new JLabel("Назва товару:");
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextField nameField = new JTextField(25);
                styleTextField(nameField);

                // Опис товару (Product description)
                JLabel descrLabel = new JLabel("Опис товару:");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextArea descrTextArea = new JTextArea(5, 25);
                descrTextArea.setLineWrap(true);
                descrTextArea.setWrapStyleWord(true);
                styleTextArea(descrTextArea);

                // Виробник (Manufacturer)
                JLabel manufacturerLabel = new JLabel("Виробник:");
                manufacturerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextField manufacturerField = new JTextField(25);
                styleTextField(manufacturerField);

                NumberFormat integerFormat = NumberFormat.getIntegerInstance();
                integerFormat.setGroupingUsed(false); // Disable commas
                // Ціна (Price)
                JLabel priceLabel = new JLabel("Ціна:");
                priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JFormattedTextField priceField = new JFormattedTextField(integerFormat);
                priceField.setColumns(25);
                styleTextField(priceField);

                // Кількість на складі (Quantity in stock)
                JLabel quantityLabel = new JLabel("Кількість на складі:");
                quantityLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JFormattedTextField quantityField = new JFormattedTextField(integerFormat);
                quantityField.setColumns(25);
                styleTextField(quantityField);

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

                gbc.gridx = 0;
                gbc.gridy = 2;
                formPanel.add(manufacturerLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(manufacturerField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                formPanel.add(priceLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(priceField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                formPanel.add(quantityLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(quantityField, gbc);

                buttonPanel.add(cancelButton);
                buttonPanel.add(saveButton);

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(formPanel, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                cancelButton.addActionListener(ev -> {
                    inputProduct.dispose();
                    ItemScreen.this.setVisible(true);
                });

                saveButton.addActionListener(ev -> {
                    try {
                        ItemScreen.this.addItem(new Item(nameField.getText(),
                                descrTextArea.getText(),
                                manufacturerField.getText(),
                                Integer.parseInt(priceField.getText()),
                                Integer.parseInt(quantityField.getText())), mframe);
                        addItemsToPanel();
                        inputProduct.dispose();
                        ItemScreen.this.setVisible(true);
                    } catch (IllegalPriceException ipe) {
                        JOptionPane.showMessageDialog(null, "Ціна не може бути від'ємною!");
                    } catch (IllegalCountException ice) {
                        JOptionPane.showMessageDialog(null, "Кількість не може бути від'ємною!");
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Введіть число!");
                    } catch (ItemUniquenessException iue) {
                        JOptionPane.showMessageDialog(null, "Товар з такою назвою вже існує!");
                    }
                });

                inputProduct.add(mainPanel);
                inputProduct.setVisible(true);
            }

            /**
             * Applies consistent styling to text fields.
             * @param textField the JComponent to style
             */
            private void styleTextField(JComponent textField) {
                textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            }

            /**
             * Applies consistent styling to text areas.
             * @param textArea the JTextArea to style
             */
            private void styleTextArea(JTextArea textArea) {
                textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            }

            /**
             * Creates a consistently styled button with specified text and color.
             *
             * @param text the button text
             * @param color the background color
             * @return the created JButton
             */
            private JButton createStyledButton(String text, Color color) {
                JButton button = new JButton(text);
                button.setFont(new Font("Segoe UI", Font.BOLD, 18));
                button.setBackground(color);
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
                return button;
            }
        });

        JLabel titleLabel = new JLabel(itemGroup.getName(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 51, 153));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        mainPanel.add(toolBar, BorderLayout.NORTH);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(173, 216, 230));
        headerPanel.add(titleLabel, BorderLayout.NORTH);
        headerPanel.add(itemsPanel, BorderLayout.CENTER);
        mainPanel.add(headerPanel, BorderLayout.CENTER);

        add(scrollPane);
    }

    /**
     * Creates and adds a styled button to the toolbar with hover effects.
     *
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

    /**
     * Adds a new item to the current group after validating its uniqueness across all groups.
     *
     * @param item the Item to add
     * @param mframe the MainScreen containing all groups for uniqueness validation
     * @throws ItemUniquenessException if an item with the same name already exists
     */
    void addItem(Item item, MainScreen mframe) throws ItemUniquenessException {
        for (ItemGroup group : mframe.store)
            for (Item item1 : group.getItems())
                if (item.getName().equalsIgnoreCase(item1.getName()))
                    throw new ItemUniquenessException();
        this.itemGroup.addItem(item);
    }

    /**
     * Refreshes the items display panel by:
     * 1. Clearing all current items
     * 2. Creating new JItemPanel for each item in the group
     * 3. Updating the UI
     */
    void addItemsToPanel() {
        itemsPanel.removeAll();
        for (Item item : this.itemGroup.getItems()) {
            JItemPanel itemPanel = new JItemPanel(itemsPanel, item, this);
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }
}
