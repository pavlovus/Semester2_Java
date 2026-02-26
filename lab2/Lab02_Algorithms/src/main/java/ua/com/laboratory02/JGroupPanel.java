package ua.com.laboratory02;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Objects;

public class JGroupPanel {
    private JButton openButton;
    private ItemGroup group;

    /**
     * Constructs a JGroupPanel for the specified ItemGroup.
     * Initializes all UI components including group name label, action buttons,
     * and sets up event handlers for all actions.
     *
     * @param parentPanel the parent panel to which this group panel will be added
     * @param group the ItemGroup this panel represents
     * @param mframe the main application frame for navigation and updates
     */
    public JGroupPanel(JPanel parentPanel, ItemGroup group, MainScreen mframe) {
        this.group = group;

        JPanel groupPanel = new JPanel();
        groupPanel.setBackground(new Color(240, 248, 255));

        groupPanel.setLayout(new BorderLayout());
        groupPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        groupPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        JLabel nameLabel = new JLabel(group.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 51, 153));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);

        JButton deleteButton = createIconButton("delete.png", "Видалити");
        deleteButton.setFocusPainted(false);

        JButton editButton = createIconButton("edit.png", "Редагувати");
        editButton.setFocusPainted(false);

        JButton statButton = createIconButton("pie-chart.png", "Вивести статистику");
        statButton.setFocusPainted(false);

        JButton infoButton = createIconButton("info.png", "Інформація");
        infoButton.setFocusPainted(false);

        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mframe.setVisible(false);
                JFrame statStore = new JFrame("Статистика магазину");
                statStore.setSize(800, 600);
                statStore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                statStore.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel(group.getName(), SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel contentPanel = new JPanel(new GridBagLayout());
                contentPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                int sum = 0;
                for(int i = 0; i < group.getItems().size(); i++){
                    Item item = group.getItems().get(i);
                    JLabel groupLabel = new JLabel(item.getName() + ": ");
                    groupLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                    groupLabel.setForeground(new Color(0, 51, 153));
                    gbc.gridx = 0;
                    gbc.gridy = i;
                    contentPanel.add(groupLabel, gbc);

                    sum += item.getSum();

                    JLabel itemsLabel = new JLabel(item.toString());
                    itemsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                    gbc.gridx = 1;
                    contentPanel.add(itemsLabel, gbc);
                }

                JLabel sumLabel = new JLabel("Загальна ціна товарів: ");
                sumLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
                sumLabel.setForeground(new Color(0, 51, 153));
                JLabel sumValue = new JLabel(String.valueOf(sum));
                sumValue.setFont(new Font("Segoe UI", Font.BOLD, 20));

                gbc.gridx = 0;
                gbc.gridy = group.getItems().size();
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
                    mframe.setVisible(true);
                });
                buttonPanel.add(okButton);

                statStore.add(mainPanel);
                statStore.setVisible(true);
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mframe.setVisible(false);
                JFrame infoGroup = new JFrame("Інформація про групу");
                infoGroup.setSize(800, 600);
                infoGroup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                infoGroup.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Інформація про групу", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel formPanel = new JPanel(new GridBagLayout());
                formPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                JLabel nameLabel = new JLabel("Назва групи: ");
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
                JLabel nameValue = new JLabel(group.getName());
                nameValue.setFont(new Font("Segoe UI", Font.BOLD, 24));
                nameValue.setForeground(new Color(0, 51, 153));



                JLabel descrLabel = new JLabel("Опис групи: ");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
                JLabel descrValue = new JLabel(group.getDescription());
                descrValue.setFont(new Font("Segoe UI", Font.BOLD, 24));
                descrValue.setForeground(new Color(0, 51, 153));


                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
                buttonPanel.setOpaque(false);

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

                JButton okButton = createStyledButton("ОК", new Color(0, 102, 204));
                buttonPanel.add(okButton);

                mainPanel.add(titleLabel, BorderLayout.NORTH);
                mainPanel.add(formPanel, BorderLayout.CENTER);
                mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                // Обробники подій
                okButton.addActionListener(ev -> {
                    infoGroup.dispose();
                    mframe.setVisible(true);
                });

                infoGroup.add(mainPanel);
                infoGroup.setVisible(true);
            }
        });

        deleteButton.addActionListener(e -> {
            Object[] options = {"Так", "Ні"};
            int dialog = JOptionPane.showOptionDialog(null,
                    "Ви впевнені, що хочете видалити цю групу?", "Підтвердити",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (dialog == JOptionPane.YES_OPTION) {
                for (int i = 0; i < mframe.store.size(); i++)
                    if (mframe.store.get(i).getName().equalsIgnoreCase(this.group.getName())) {
                        mframe.store.remove(i); break;}
                mframe.addStoreToPanel();
            }

        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mframe.setVisible(false);
                JFrame inputGroup = new JFrame("Відредагуйте групу");
                inputGroup.setSize(800, 600);
                inputGroup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inputGroup.setLocationRelativeTo(null);

                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(new Color(173, 216, 230));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

                JLabel titleLabel = new JLabel("Відредагуйте групу", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
                titleLabel.setForeground(new Color(0, 51, 153));
                titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

                JPanel formPanel = new JPanel(new GridBagLayout());
                formPanel.setOpaque(false);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.anchor = GridBagConstraints.WEST;

                JLabel nameLabel = new JLabel("Нова назва групи:");
                nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextField nameField = new JTextField(25);
                nameField.setText(group.getName());
                styleTextField(nameField);

                JLabel descrLabel = new JLabel("Новий опис групи:");
                descrLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                JTextArea descrTextArea = new JTextArea(5, 25);
                descrTextArea.setText(group.getDescription());
                descrTextArea.setLineWrap(true);
                descrTextArea.setWrapStyleWord(true);
                styleTextArea(descrTextArea);

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
                buttonPanel.setOpaque(false);
                JButton saveButton = createStyledButton("Зберегти зміни", new Color(0, 102, 204));
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

                // Обробники подій
                cancelButton.addActionListener(ev -> {
                    inputGroup.dispose();
                    mframe.setVisible(true);
                });

                saveButton.addActionListener(ev -> {
                    String text = nameField.getText();
                    if (text.isEmpty()) {
                        JOptionPane.showMessageDialog(inputGroup, "Група повинна мати якусь назву");
                    } else {
                        try {
                            mframe.changeItemGroup(JGroupPanel.this.group.getName(), text, descrTextArea.getText());
                        } catch (GroupUniquenessException ex) {
                            JOptionPane.showMessageDialog(inputGroup, "Група з такою назвою вже існує");
                        }
                        mframe.addStoreToPanel();
                        inputGroup.dispose();
                        mframe.setVisible(true);
                    }
                });

                inputGroup.add(mainPanel);
                inputGroup.setVisible(true);
            }
        });
        openButton = createIconButton("arrowSide.png", "Показати товари");
        openButton.setFocusPainted(false);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mframe.setVisible(false);
                ItemScreen itemScreen = new ItemScreen(group, mframe);
                itemScreen.addItemsToPanel();
                itemScreen.setVisible(true);
            }
        });

        buttonPanel.add(infoButton);
        buttonPanel.add(statButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(openButton);


        groupPanel.add(nameLabel, BorderLayout.WEST);
        groupPanel.add(buttonPanel, BorderLayout.EAST);

        parentPanel.add(groupPanel);
        parentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    /**
     * Creates a button with an icon and tooltip text.
     * The button has hover effects and custom styling.
     *
     * @param iconPath the path to the icon image file
     * @param tooltip the tooltip text to display
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
     * @param field the JTextField to style
     */
    private void styleTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 51, 153)), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    /**
     * Applies consistent styling to text areas.
     *
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
     * Creates a consistently styled button with specified text and background color.
     * Includes hover effects and custom padding.
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
