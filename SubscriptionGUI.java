/**
 * Graphical User Interface for managing AI subscription plans.
 * Provides panels for input, buttons for operations and a display area for output.
 *
 * @author Nikita Chaudhary
 * @version 2026
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class SubscriptionGUI extends JFrame {

    // ============================================================
    // VARIABLES
    // ============================================================

    private ArrayList<AIModel> store;

    private JTextArea displayArea;

    private JTextField modelNameField;
    private JTextField priceField;
    private JTextField parameterField;
    private JTextField contextField;
    private JTextField quotaField;
    private JTextField slotsField;
    private JTextField promptField;
    private JTextField responseField;
    private JTextField memberNameField;
    private JTextField indexField;

    private JButton addPersonalBtn;
    private JButton addProBtn;
    private JButton displayAllBtn;
    private JButton clearBtn;
    private JButton addPromptBtn;
    private JButton addMemberBtn;
    private JButton removeMemberBtn;
    private JButton checkPlanBtn;
    private JButton exportBtn;
    private JButton loadBtn;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public SubscriptionGUI() {

        // Create storage
        store = new ArrayList<>();

        // Window settings
        setTitle("AI Subscription Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create GUI components
        createFormPanel();
        createButtonPanel();
        createDisplayPanel();

        // Setup button actions
        setupButtonActions();

        // Center the window
        setLocationRelativeTo(null);
    }


    // ============================================================
    // FORM PANEL
    // ============================================================

    private void createFormPanel() {

        JPanel formPanel = new JPanel(
                new GridLayout(10, 2, 5, 5)
        );

        formPanel.setPreferredSize(
                new Dimension(500, 400)
        );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 2),
                        "Form Panel",
                        0,
                        0,
                        new Font("Arial", Font.BOLD, 14),
                        Color.BLUE
                )
        );

        formPanel.setBackground(
                new Color(245, 250, 255)
        );

        // Add input fields
        modelNameField = addField(
                formPanel,
                "Model Name:"
        );

        priceField = addField(
                formPanel,
                "Model Price:"
        );

        parameterField = addField(
                formPanel,
                "Parameter (in b):"
        );

        contextField = addField(
                formPanel,
                "Context Window:"
        );

        quotaField = addField(
                formPanel,
                "Prompt Quota:"
        );

        slotsField = addField(
                formPanel,
                "Member Slots:"
        );

        promptField = addField(
                formPanel,
                "Prompt Text:"
        );

        responseField = addField(
                formPanel,
                "Response Length:"
        );

        memberNameField = addField(
                formPanel,
                "Member Name:"
        );

        indexField = addField(
                formPanel,
                "Index Number:"
        );

        add(
                formPanel,
                BorderLayout.WEST
        );
    }


    // ============================================================
    // BUTTON PANEL
    // ============================================================

    private void createButtonPanel() {

        JPanel buttonPanel = new JPanel(
                new GridLayout(5, 2, 10, 10)
        );

        buttonPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 2),
                        "Button Panel",
                        0,
                        0,
                        new Font("Arial", Font.BOLD, 14),
                        Color.BLUE
                )
        );

        buttonPanel.setBackground(Color.WHITE);

        // Create buttons
        addPersonalBtn = new JButton(
                "ADD Personal Plan"
        );

        addProBtn = new JButton(
                "ADD Pro Plan"
        );

        displayAllBtn = new JButton(
                "Display ALL"
        );

        clearBtn = new JButton(
                "Clear"
        );

        addPromptBtn = new JButton(
                "ADD Prompt"
        );

        addMemberBtn = new JButton(
                "ADD Members"
        );

        removeMemberBtn = new JButton(
                "REMOVE Member"
        );

        checkPlanBtn = new JButton(
                "Check Plan Type"
        );

        exportBtn = new JButton(
                "Export to File"
        );

        loadBtn = new JButton(
                "Load from File"
        );

        // Store buttons in an array
        JButton[] buttons = {
                addPersonalBtn,
                addProBtn,
                displayAllBtn,
                clearBtn,
                addPromptBtn,
                addMemberBtn,
                removeMemberBtn,
                checkPlanBtn,
                exportBtn,
                loadBtn
        };

        // Style buttons
        for (JButton button : buttons) {

            button.setBackground(
                    new Color(173, 216, 230)
            );

            button.setFont(
                    new Font("Arial", Font.BOLD, 14)
            );

            button.setFocusPainted(false);

            button.setForeground(Color.BLACK);
        }

        // Add buttons
        buttonPanel.add(addPersonalBtn);
        buttonPanel.add(addProBtn);

        buttonPanel.add(displayAllBtn);
        buttonPanel.add(clearBtn);

        buttonPanel.add(addPromptBtn);
        buttonPanel.add(addMemberBtn);

        buttonPanel.add(removeMemberBtn);
        buttonPanel.add(checkPlanBtn);

        buttonPanel.add(exportBtn);
        buttonPanel.add(loadBtn);

        add(
                buttonPanel,
                BorderLayout.EAST
        );
    }


    // ============================================================
    // DISPLAY PANEL
    // ============================================================

    private void createDisplayPanel() {

        JPanel displayPanel = new JPanel(
                new BorderLayout()
        );

        displayPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY, 2),
                        "Display Panel",
                        0,
                        0,
                        new Font("Arial", Font.BOLD, 14),
                        Color.BLUE
                )
        );

        // Display area
        displayArea = new JTextArea();

        displayArea.setEditable(false);

        displayArea.setOpaque(true);

        displayArea.setBackground(
                new Color(245, 245, 245)
        );

        displayArea.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        // Add scroll bar
        JScrollPane scrollPane = new JScrollPane(
                displayArea
        );

        scrollPane.setPreferredSize(
                new Dimension(1000, 250)
        );

        displayPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                displayPanel,
                BorderLayout.SOUTH
        );
    }


    // ============================================================
    // BUTTON ACTIONS
    // ============================================================

    private void setupButtonActions() {

        // Add Personal Plan
        addPersonalBtn.addActionListener(
                e -> addPersonalPlan()
        );

        // Add Pro Plan
        addProBtn.addActionListener(
                e -> addProPlan()
        );

        // Display all plans
        displayAllBtn.addActionListener(
                e -> displayAllPlans()
        );

        // Clear
        clearBtn.addActionListener(
                e -> clearAll()
        );

        // Add Prompt
        addPromptBtn.addActionListener(
                e -> addPrompt()
        );

        // Add Member
        addMemberBtn.addActionListener(
                e -> addMember()
        );

        // Remove Member
        removeMemberBtn.addActionListener(
                e -> removeMember()
        );

        // Check Plan Type
        checkPlanBtn.addActionListener(
                e -> checkPlanType()
        );

        // Export
        exportBtn.addActionListener(
                e -> exportToFile()
        );

        // Load
        loadBtn.addActionListener(
                e -> loadFromFile()
        );
    }


    // ============================================================
    // ADD PERSONAL PLAN
    // ============================================================

    private void addPersonalPlan() {

        try {

            String modelName =
                    modelNameField.getText().trim();

            double price =
                    Double.parseDouble(
                            priceField.getText()
                    );

            int parameters =
                    Integer.parseInt(
                            parameterField.getText()
                    );

            int context =
                    Integer.parseInt(
                            contextField.getText()
                    );

            int quota =
                    Integer.parseInt(
                            quotaField.getText()
                    );

            AIModel plan = new PersonalPlan(
                    modelName,
                    price,
                    parameters,
                    context,
                    quota
            );

            store.add(plan);

            JOptionPane.showMessageDialog(
                    this,
                    "Added to Personal Plan",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: Invalid input.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ============================================================
    // ADD PRO PLAN
    // ============================================================

    private void addProPlan() {

        try {

            String modelName =
                    modelNameField.getText().trim();

            double price =
                    Double.parseDouble(
                            priceField.getText()
                    );

            int parameters =
                    Integer.parseInt(
                            parameterField.getText()
                    );

            int context =
                    Integer.parseInt(
                            contextField.getText()
                    );

            int slots =
                    Integer.parseInt(
                            slotsField.getText()
                    );

            AIModel plan = new ProPlan(
                    modelName,
                    price,
                    parameters,
                    context,
                    slots
            );

            store.add(plan);

            JOptionPane.showMessageDialog(
                    this,
                    "Added to Pro Plan",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: Invalid input.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ============================================================
    // DISPLAY ALL PLANS
    // ============================================================

    private void displayAllPlans() {

        if (store.isEmpty()) {

            displayArea.append(
                    "No plans available.\n"
            );

            return;
        }

        displayArea.setText("");

        int number = 1;

        for (AIModel plan : store) {

            displayArea.append(
                    "Plan " + number + "\n"
            );

            displayArea.append(
                    plan.display()
            );

            displayArea.append(
                    "\n====================================\n"
            );

            number++;
        }
    }


    // ============================================================
    // ADD PROMPT
    // ============================================================

    private void addPrompt() {

        int index = validateIndex();

        if (index == -1) {
            return;
        }

        AIModel plan = store.get(index);

        // Prompt only works with PersonalPlan
        if (!(plan instanceof PersonalPlan)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Operation only allowed for PersonalPlan",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Check response length
        if (responseField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a numeric response length.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {

            int responseLength =
                    Integer.parseInt(
                            responseField.getText()
                    );

            String prompt =
                    promptField.getText();

            String result =
                    plan.enterPrompt(
                            prompt,
                            responseLength
                    );

            JOptionPane.showMessageDialog(
                    this,
                    "Prompt added successfully!",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

            displayArea.append(
                    result
                    + "\n========================================\n"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: Response length must be a number.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ============================================================
    // ADD MEMBER
    // ============================================================

    private void addMember() {

        int index = validateIndex();

        if (index == -1) {
            return;
        }

        AIModel plan = store.get(index);

        if (!(plan instanceof ProPlan)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Operation only allowed for ProPlan",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String memberName =
                memberNameField.getText().trim();

        if (memberName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a member name.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        ProPlan pro = (ProPlan) plan;

        String result =
                pro.addTeamMember(memberName);

        displayArea.append(
                result + "\n"
        );
    }


    // ============================================================
    // REMOVE MEMBER
    // ============================================================

    private void removeMember() {

        int index = validateIndex();

        if (index == -1) {
            return;
        }

        AIModel plan = store.get(index);

        if (!(plan instanceof ProPlan)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Operation only allowed for ProPlan",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ProPlan pro = (ProPlan) plan;

        String result =
                pro.removeTeamMember();

        displayArea.append(
                result + "\n"
        );
    }


    // ============================================================
    // CHECK PLAN TYPE
    // ============================================================

    private void checkPlanType() {

        int index = validateIndex();

        if (index == -1) {
            return;
        }

        AIModel plan = store.get(index);

        if (plan instanceof PersonalPlan) {

            displayArea.append(
                    "This is a PersonalPlan.\n"
            );

        } else if (plan instanceof ProPlan) {

            displayArea.append(
                    "This is a ProPlan.\n"
            );
        }
    }


    // ============================================================
    // EXPORT TO FILE
    // ============================================================

    private void exportToFile() {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("plans.txt")
                    );

            for (AIModel plan : store) {

                writer.println(
                        plan.display()
                );

                writer.println(
                        "----------------------"
                );
            }

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Exported to plans.txt",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error exporting file.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ============================================================
    // LOAD FROM FILE
    // ============================================================

    private void loadFromFile() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("plans.txt")
                    );

            displayArea.setText("");

            String line;

            while ((line = reader.readLine()) != null) {

                displayArea.append(
                        line + "\n"
                );
            }

            reader.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Loaded from plans.txt",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading file.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ============================================================
    // ADD FIELD
    // ============================================================

    private JTextField addField(
            JPanel panel,
            String label
    ) {

        panel.add(
                new JLabel(label)
        );

        JTextField field =
                new JTextField();

        panel.add(field);

        return field;
    }


    // ============================================================
    // VALIDATE INDEX
    // ============================================================

    private int validateIndex() {

        try {

            String text =
                    indexField.getText().trim();

            if (text.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error: Index must be a valid number.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return -1;
            }

            int index =
                    Integer.parseInt(text) - 1;

            if (index >= 0 &&
                    index < store.size()) {

                return index;

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Error: Invalid index. "
                                + "Please enter a number within range.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return -1;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: Index must be a valid number.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return -1;
        }
    }


    // ============================================================
    // CLEAR ALL
    // ============================================================

    private void clearAll() {

        clearFields();

        displayArea.setText("");
    }


    // ============================================================
    // CLEAR INPUT FIELDS
    // ============================================================

    private void clearFields() {

        modelNameField.setText("");

        priceField.setText("");

        parameterField.setText("");

        contextField.setText("");

        quotaField.setText("");

        slotsField.setText("");

        promptField.setText("");

        responseField.setText("");

        memberNameField.setText("");

        indexField.setText("");
    }


    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            SubscriptionGUI gui =
                    new SubscriptionGUI();

            gui.setVisible(true);
        });
    }
}