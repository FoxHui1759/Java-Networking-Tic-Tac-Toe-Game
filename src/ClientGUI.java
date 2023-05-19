import javax.swing.*;
import java.awt.*;
/**
 * This is a class for client's GUI
 * Players can play tic-tac-toe with another player via this GUI
 */
public class ClientGUI {
    private JFrame frame = new JFrame();
    private JMenuBar menubar = new JMenuBar();
    private JMenu control = new JMenu("Control");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenu help = new JMenu("Help");
    private JMenuItem instruction = new JMenuItem("Instruction");
    private JPanel mainPanel = new JPanel();
    private JPanel messagePanel = new JPanel();
    private JLabel message = new JLabel("Enter your player name...");
    private JPanel gridPanel = new JPanel();
    private JButton grid1 = new JButton("");
    private JButton grid2 = new JButton("");
    private JButton grid3 = new JButton("");
    private JButton grid4 = new JButton("");
    private JButton grid5 = new JButton("");
    private JButton grid6 = new JButton("");
    private JButton grid7 = new JButton("");
    private JButton grid8 = new JButton("");
    private JButton grid9 = new JButton("");

    private JPanel inputPanel = new JPanel();
    private JTextField textField = new JTextField(15);
    private JButton submitButton = new JButton("Submit");

    /**
     * This method is used to build the GUI for players.
     * The GUI include
     * 1 JMenuBar which consists of 2 JMenu which each JMenu consists of its corresponding JMenuItem,
     * 1 message title,
     * 1 3 x 3 tic-tac-toe board,
     * 1 textbox for player’s entering his/her name,
     * 1 submit button for submitting the player’s name.
     */
    public void go(){
        control.add(exit);
        help.add(instruction);
        menubar.add(control);
        menubar.add(help);
        frame.setJMenuBar(menubar);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(message, BorderLayout.WEST);
        mainPanel.add(messagePanel);

        gridPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;

        grid7.setPreferredSize(new Dimension(100, 70));
        grid7.setBackground(Color.white);
        grid7.setEnabled(false);
        gridPanel.add(grid7, c);
        c.gridx = 1;
        grid8.setPreferredSize(new Dimension(100, 70));
        grid8.setBackground(Color.white);
        grid8.setEnabled(false);
        gridPanel.add(grid8, c);
        c.gridx = 2;
        grid9.setPreferredSize(new Dimension(100, 70));
        grid9.setBackground(Color.white);
        grid9.setEnabled(false);
        gridPanel.add(grid9, c);
        c.gridx = 0;
        c.gridy = 1;
        grid4.setPreferredSize(new Dimension(100, 70));
        grid4.setBackground(Color.white);
        grid4.setEnabled(false);
        gridPanel.add(grid4, c);
        c.gridx = 1;
        grid5.setPreferredSize(new Dimension(100, 70));
        grid5.setBackground(Color.white);
        grid5.setEnabled(false);
        gridPanel.add(grid5, c);
        c.gridx = 2;
        grid6.setPreferredSize(new Dimension(100, 70));
        grid6.setBackground(Color.white);
        grid6.setEnabled(false);
        gridPanel.add(grid6, c);
        c.gridx = 0;
        c.gridy = 2;
        grid1.setPreferredSize(new Dimension(100, 70));
        grid1.setBackground(Color.white);
        grid1.setEnabled(false);
        gridPanel.add(grid1, c);
        c.gridx = 1;
        grid2.setPreferredSize(new Dimension(100, 70));
        grid2.setBackground(Color.white);
        grid2.setEnabled(false);
        gridPanel.add(grid2, c);
        c.gridx = 2;
        grid3.setPreferredSize(new Dimension(100, 70));
        grid3.setBackground(Color.white);
        grid3.setEnabled(false);
        gridPanel.add(grid3, c);
        mainPanel.add(gridPanel);

        inputPanel.add(textField);
        inputPanel.add(submitButton);
        mainPanel.add(inputPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setVisible(true);
    }

    /**
     * This method is used to enable all grid button of a player in the GUI.
     */
    public void enableAllButton(){
        grid1.setEnabled(true);
        grid2.setEnabled(true);
        grid3.setEnabled(true);
        grid4.setEnabled(true);
        grid5.setEnabled(true);
        grid6.setEnabled(true);
        grid7.setEnabled(true);
        grid8.setEnabled(true);
        grid9.setEnabled(true);
    }

    /**
     * This method is used to disable all grid button of a player in the GUI.
     */
    public void disableAllButton(){
        grid1.setEnabled(false);
        grid2.setEnabled(false);
        grid3.setEnabled(false);
        grid4.setEnabled(false);
        grid5.setEnabled(false);
        grid6.setEnabled(false);
        grid7.setEnabled(false);
        grid8.setEnabled(false);
        grid9.setEnabled(false);
    }

    /**
     * This method is the getter of Grid1.
     * @return JButton grid1
     */
    public JButton getGrid1() {
        return grid1;
    }

    /**
     * This method is the getter of Grid2.
     * @return JButton grid2
     */
    public JButton getGrid2() {
        return grid2;
    }

    /**
     * This method is the getter of Grid3.
     * @return JButton grid3
     */
    public JButton getGrid3() {
        return grid3;
    }

    /**
     * This method is the getter of Grid4
     * @return JButton grid4
     */
    public JButton getGrid4() {
        return grid4;
    }

    /**
     * This method is the getter of Grid5.
     * @return JButton grid5
     */
    public JButton getGrid5() {
        return grid5;
    }

    /**
     * This method is the getter of Grid6.
     * @return JButton gird6
     */
    public JButton getGrid6() {
        return grid6;
    }

    /**
     * This method is the getter of Grid7.
     * @return JButton grid7
     */
    public JButton getGrid7() {
        return grid7;
    }

    /**
     * This method is the getter of Grid8.
     * @return JButton grid8
     */
    public JButton getGrid8() {
        return grid8;
    }

    /**
     * This method is the getter of Grid9
     * @return JButton grid9
     */
    public JButton getGrid9() {
        return grid9;
    }

    /**
     * This method is the getter of submit button
     * @return JButton submitButton
     */
    public JButton getSubmitButton() {
        return submitButton;
    }

    /**
     * This method is the getter of exit
     * @return JMenuItem exit
     */
    public JMenuItem getExit() {
        return exit;
    }

    /**
     * This method is the getter of instruction
     * @return JMenuItem instruction
     */
    public JMenuItem getInstruction() {
        return instruction;
    }

    /**
     * This method is the getter of message
     * @return JLabel message
     */
    public JLabel getMessage() {
        return message;
    }

    /**
     * This method is the getter of textField
     * @return JTextField textField
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * This method is the getter of frame
     * @return JFrame frame
     */
    public JFrame getFrame(){
        return frame;
    }

    /**
     * This method is used to let the GUI show pop message
     * @param message This the message to be showed
     */
    public void popMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}