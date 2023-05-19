import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

/**
 * This is the client control class.
 * This class handles the connection issue and communication between the client and the server.
 */
public class ClientControl {
    private Socket sock;
    private PrintWriter writer;
    private int playerID;
    private ClientGUI gui;

    /**
     * This method is the main of the class.
     * It creates a clientControl object and calls the go method of it.
     * The go method is used to set up the GUI and the sock for connection.
     * After than, the go method will handle the communication between the player and the server.
     * @param args Unused.
     */
    public static void main(String[] args) {
        ClientControl clientControl = new ClientControl();
        clientControl.go();
    }

    private void go(){
        gui = new ClientGUI();
        gui.getExit().addActionListener(new exitListener());
        gui.getInstruction().addActionListener(new instructionListener());
        gui.getSubmitButton().addActionListener(new submitButtonListener());
        gui.getGrid1().addActionListener(new grid1Listener());
        gui.getGrid2().addActionListener(new grid2Listener());
        gui.getGrid3().addActionListener(new grid3Listener());
        gui.getGrid4().addActionListener(new grid4Listener());
        gui.getGrid5().addActionListener(new grid5Listener());
        gui.getGrid6().addActionListener(new grid6Listener());
        gui.getGrid7().addActionListener(new grid7Listener());
        gui.getGrid8().addActionListener(new grid8Listener());
        gui.getGrid9().addActionListener(new grid9Listener());
        gui.go();

        try {
            sock = new Socket("127.0.0.1", 10000);
            writer = new PrintWriter(sock.getOutputStream());

            InputStreamReader steamReader = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(steamReader);

            playerID = Integer.parseInt(reader.readLine());
            System.out.println("Connected to server as Player "+ playerID);

            String command;
            while ((command = reader.readLine()) != null){
                System.out.println("Command from server: " + command);
                if (command.equals("NOT READY"))
                    gui.popMessage("The game is not ready to start. Please wait.");
                else if (command.equals("LEFT")){
                    gui.popMessage("Game Ends. One of the players left");
                    gui.disableAllButton();
                    gui.getSubmitButton().setEnabled(false);
                    gui.getTextField().setEnabled(false);
                    break;
                }
                else if (command.equals("DRAW")){
                    gui.popMessage("Draw.");
                    gui.disableAllButton();
                    gui.getSubmitButton().setEnabled(false);
                    gui.getTextField().setEnabled(false);
                    break;
                }
                else if (command.equals("WIN")){
                    gui.popMessage("Congratulations. You Win.");
                    gui.disableAllButton();
                    gui.getSubmitButton().setEnabled(false);
                    gui.getTextField().setEnabled(false);
                    break;
                }
                else if (command.equals("LOSE")){
                    gui.popMessage("You lose.");
                    gui.disableAllButton();
                    gui.getSubmitButton().setEnabled(false);
                    gui.getTextField().setEnabled(false);
                    break;
                }
                else if (command.startsWith("NewMove:")){
                    String[] s = command.split(" ");
                    int value = Integer.parseInt(s[1]);
                    String sign = s[2];
                    if (value == 1){
                        gui.getGrid1().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid1().setForeground(Color.GREEN);
                            gui.getGrid1().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid1().setForeground(Color.RED);
                            gui.getGrid1().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 2){
                        gui.getGrid2().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid2().setForeground(Color.GREEN);
                            gui.getGrid2().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid2().setForeground(Color.RED);
                            gui.getGrid2().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 3){
                        gui.getGrid3().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid3().setForeground(Color.GREEN);
                            gui.getGrid3().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid3().setForeground(Color.RED);
                            gui.getGrid3().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 4){
                        gui.getGrid4().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid4().setForeground(Color.GREEN);
                            gui.getGrid4().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid4().setForeground(Color.RED);
                            gui.getGrid4().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 5){
                        gui.getGrid5().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid5().setForeground(Color.GREEN);
                            gui.getGrid5().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid5().setForeground(Color.RED);
                            gui.getGrid5().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 6){
                        gui.getGrid6().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid6().setForeground(Color.GREEN);
                            gui.getGrid6().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid6().setForeground(Color.RED);
                            gui.getGrid6().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 7){
                        gui.getGrid7().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid7().setForeground(Color.GREEN);
                            gui.getGrid7().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid7().setForeground(Color.RED);
                            gui.getGrid7().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else if (value == 8){
                        gui.getGrid8().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid8().setForeground(Color.GREEN);
                            gui.getGrid8().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid8().setForeground(Color.RED);
                            gui.getGrid8().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    else {
                        gui.getGrid9().setText(sign);
                        if (sign.equals("X")){
                            gui.getGrid9().setForeground(Color.GREEN);
                            gui.getGrid9().setFont(new Font("arial", Font.BOLD, 30));
                        } else{
                            gui.getGrid9().setForeground(Color.RED);
                            gui.getGrid9().setFont(new Font("arial", Font.BOLD, 30));
                        }
                    }
                    if (sign.equals("X") && playerID == 1) {
                        gui.disableAllButton();
                        gui.getMessage().setText("Valid move, wait for your opponent.");
                    }
                    if (sign.equals("O") && playerID == 2){
                        gui.disableAllButton();
                        gui.getMessage().setText("Valid move, wait for your opponent.");
                    }
                }
                else if (command.equals("YOUR TURN NOW")){
                    enableToMove();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void enableToMove(){
        gui.enableAllButton();
        gui.getMessage().setText("Your opponent has moved, now is your turn");
    }
    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println("EXIT");
            System.out.println("Player " + playerID + " is sending: EXIT");
            System.exit(0);
        }
    }
    private class instructionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.popMessage("""
                    Some information about the game
                    Criteria for a valid move:
                    -The move is not occupied by any mark.
                    -The move is made in the player's turn.
                    -The move is made within the 3 x 3 board.
                    The game would continue and switch among the opposite player util it reachs either of of the following conditions:
                    -Player 1 wins.
                    -Player 2 wins.
                    -Draw.""");
        }
    }
    private class submitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            writer.println("SUBMIT");
            writer.flush();
            System.out.println("Client is sending: SUBMIT");
            gui.getMessage().setText("WELCOME " + gui.getTextField().getText());
            gui.getSubmitButton().setEnabled(false);
            gui.getTextField().setEnabled(false);
            gui.getFrame().setTitle("Tic Tac Toe: " + gui.getTextField().getText());
            if (playerID == 1){
                System.out.println("Player " + playerID + "'s buttons have been enable");
                gui.enableAllButton();
            }
        }
    }
    private class grid1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid1().getText().equals("")){
                writer.println("1");
                writer.flush();
                System.out.println("Client is sending: 1");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }

    private class grid2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid2().getText().equals("")){
                writer.println("2");
                writer.flush();
                System.out.println("Client is sending: 2");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid3().getText().equals("")){
                writer.println("3");
                writer.flush();
                System.out.println("Client is sending: 3");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid4().getText().equals("")){
                writer.println("4");
                writer.flush();
                System.out.println("Client is sending: 4");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid5Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid5().getText().equals("")){
                writer.println("5");
                writer.flush();
                System.out.println("Client is sending: 5");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid6Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid6().getText().equals("")){
                writer.println("6");
                writer.flush();
                System.out.println("Client is sending: 6");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid7Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid7().getText().equals("")){
                writer.println("7");
                writer.flush();
                System.out.println("Client is sending: 7");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid8Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid8().getText().equals("")){
                writer.println("8");
                writer.flush();
                System.out.println("Client is sending: 8");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
    private class grid9Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gui.getGrid9().getText().equals("")){
                writer.println("9");
                writer.flush();
                System.out.println("Client is sending: 9");
            } else {
                gui.popMessage("Invalid move. Please try again.");
            }

        }
    }
}
