package ua.com.laboratory02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class JItemPanel {
    private Item item;

    /**
     * Constructs a JItemPanel for the specified Item.
     * Initializes all UI components including item name label, action buttons,
     * and sets up event handlers for all actions.
     *
     * @param parentPanel the parent panel to which this item panel will be added
     * @param item the Item this panel represents
     * @param frame the parent ItemScreen for navigation and updates
     */
    public JItemPanel(JPanel parentPanel, Item item, ItemScreen frame) {
        this.item = item;

        JPanel groupPanel = new JPanel();
        groupPanel.setBackground(new Color(245, 245, 220));

        groupPanel.setLayout(new BorderLayout());
        groupPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        groupPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 51, 153));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);

        JButton deleteButton = createIconButton("delete.png", "Видалити");
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(e -> {
            Object[] options = {"Так", "Ні"};
            int dialog = JOptionPane.showOptionDialog(null,
                    "Ви впевнені, що хочете видалити цей товар?", "Підтвердити",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (dialog == JOptionPane.YES_OPTION) {
                for (int i = 0; i < frame.itemGroup.getItems().size(); i++) {
                    if (frame.itemGroup.getItems().get(i).getName().equalsIgnoreCase(this.item.getName())) {
                        frame.itemGroup.getItems().remove(i); }
                }
                frame.addItemsToPanel();
            }
        });
        JButton editButton = createIconButton("edit.png", "Редагувати");
        editButton.setFocusPainted(false);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
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
                nameField.setText(item.getName());
                styleTextField(nameField);

                // Опис товару (Product description)
                JLabel descrLabel = new JLabel("Опис товару:");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextArea descrTextArea = new JTextArea(5, 25);
                descrTextArea.setText(item.getDecsr());
                descrTextArea.setLineWrap(true);
                descrTextArea.setWrapStyleWord(true);
                styleTextArea(descrTextArea);

                // Виробник (Manufacturer)
                JLabel manufacturerLabel = new JLabel("Виробник:");
                manufacturerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextField manufacturerField = new JTextField(25);
                manufacturerField.setText(item.getManufacturer());
                styleTextField(manufacturerField);

                NumberFormat integerFormat = NumberFormat.getIntegerInstance();
                integerFormat.setGroupingUsed(false); // Disable commas
                // Ціна (Price)
                JLabel priceLabel = new JLabel("Ціна:");
                priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JFormattedTextField priceField = new JFormattedTextField(integerFormat);
                priceField.setColumns(25);
                priceField.setValue(item.getPrice());
                styleTextField(priceField);

                // Кількість на складі (Quantity in stock)
                JLabel quantityLabel = new JLabel("Кількість на складі:");
                quantityLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JFormattedTextField quantityField = new JFormattedTextField(integerFormat);
                quantityField.setColumns(25);
                quantityField.setValue(item.getCount());
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
                    frame.setVisible(true);
                });

                saveButton.addActionListener(ev -> {
                    try {
                        changeItem(JItemPanel.this.item.getName(),
                                nameField.getText(),
                                descrTextArea.getText(),
                                manufacturerField.getText(),
                                ((Number) priceField.getValue()).intValue(),
                                ((Number) quantityField.getValue()).intValue(),
                                frame.mainScreen);
                        frame.addItemsToPanel();
                        inputProduct.dispose();
                        frame.setVisible(true);
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
        });

        JButton infoButton = createIconButton("info.png", "Редагувати");
        infoButton.setFocusPainted(false);
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame inputProduct = new JFrame("Введіть дані про товар");
                inputProduct.setSize(800, 600);
                inputProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inputProduct.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Інформація про товар", SwingConstants.CENTER);
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
                JLabel nameValue= new JLabel(item.getName());
                nameValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
                nameValue.setForeground(new Color(0, 51, 153));


                // Опис товару (Product description)
                JLabel descrLabel = new JLabel("Опис товару:");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JLabel descrValue = new JLabel(item.getDecsr());
                descrValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
                descrValue.setForeground(new Color(0, 51, 153));

                // Виробник (Manufacturer)
                JLabel manufacturerLabel = new JLabel("Виробник:");
                manufacturerLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JLabel manufacturerValue = new JLabel(item.getManufacturer());
                manufacturerValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
                manufacturerValue.setForeground(new Color(0, 51, 153));

                // Ціна (Price)
                JLabel priceLabel = new JLabel("Ціна:");
                priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JLabel priceValue = new JLabel(String.valueOf(item.getPrice()));
                priceValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
                priceValue.setForeground(new Color(0, 51, 153));

                // Кількість на складі (Quantity in stock)
                JLabel quantityLabel = new JLabel("Кількість на складі:");
                quantityLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JLabel quantityValue = new JLabel(String.valueOf(item.getCount()));
                quantityValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
                quantityValue.setForeground(new Color(0, 51, 153));

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
                buttonPanel.setOpaque(false);
                JButton okButton = createStyledButton("ОК", new Color(0, 102, 204));

                gbc.gridx = 0;
                gbc.gridy = 0;
                formPanel.add(nameLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(nameValue, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                formPanel.add(descrLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(descrValue, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                formPanel.add(manufacturerLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(manufacturerValue, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                formPanel.add(priceLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(priceValue, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                formPanel.add(quantityLabel, gbc);

                gbc.gridx = 1;
                formPanel.add(quantityValue, gbc);

                buttonPanel.add(okButton);

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(formPanel, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                okButton.addActionListener(ev -> {
                    inputProduct.dispose();
                    frame.setVisible(true);
                });

                inputProduct.add(mainPanel);
                inputProduct.setVisible(true);
            }
        });

        buttonPanel.add(infoButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        groupPanel.add(nameLabel, BorderLayout.WEST);
        groupPanel.add(buttonPanel, BorderLayout.EAST);

        parentPanel.add(groupPanel);
        parentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    /**
     * Modifies an existing item's properties after validating uniqueness of the new name.
     *
     * @param old the original name of the item (for identification)
     * @param newname the new name for the item
     * @param descr the new description
     * @param manuf the new manufacturer
     * @param price the new price
     * @param count the new count
     * @param mframe the main application frame containing all items
     * @throws ItemUniquenessException if an item with the new name already exists
     */
    private void changeItem(String old, String newname, String descr,
                            String manuf, int price, int count, MainScreen mframe) throws ItemUniquenessException {
        for (ItemGroup group : mframe.store)
            for (Item item1 : group.getItems())
                if (item1.getName().equalsIgnoreCase(newname) && !item1.getName().equalsIgnoreCase(old))
                    throw new ItemUniquenessException();

        for (ItemGroup group : mframe.store)
            for (Item item1 : group.getItems())
                if (item1.getName().equalsIgnoreCase(old)) {
                    item1.setName(newname);
                    item1.setDecsr(descr);
                    item1.setManufacturer(manuf);
                    item1.setCount(count);
                    item1.setPrice(price);
                    break;
                }
    }

    /**
     * Creates an icon button with hover effects and tooltip.
     *
     * @param iconPath path to the icon image file
     * @param tooltip text to display as tooltip
     * @return the created JButton
     */
    private JButton createIconButton(String iconPath, String tooltip) {
        ImageIcon originalIcon = new ImageIcon(iconPath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);

        JButton button = new JButton(icon);
        button.setToolTipText(tooltip);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(173, 216, 230)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(225, 238, 255));
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0, 102, 204)),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(null);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(173, 216, 230)),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                ));
            }
        });

        return button;
    }

    /**
     * Applies consistent styling to text fields.
     *
     * @param textField the text field component to style
     */
    private void styleTextField(JComponent textField) {
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    }

    /**
     * Applies consistent styling to text areas.
     *
     * @param textArea the text area component to style
     */
    private void styleTextArea(JTextArea textArea) {
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    }

    /**
     * Creates a consistently styled button with specified text and background color.
     *
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
}
