import java.io.*;
import java.net.*;

/**
 * This is the server class.
 * This class handles the connection issue and communication between the client and the server.
 * This class also hold the data of the game.
 */
public class Server {
    private ServerSocket serverSock;
    private int numPlayer;
    private ClientHandler player1Handler;
    private ClientHandler player2Handler;
    private boolean isPlayer1Ready = false;
    private boolean isPlayer2Ready = false;
    private Board board;

    /**
     * This method is the main of the class
     * It creates a server object and calls the go method of it.
     * The go method is used to set up the server and handle the communication between players and the server.
     * This sets up clientHandler for each player.
     * @param args Unused.
     */
    public static void main(String[] args){
        Server server = new Server();
        System.out.println("Server is running...");
        server.go();
    }

    private void go(){
        try{
            serverSock = new ServerSocket(10000);
            System.out.println("Waiting for connections...");
            while (numPlayer < 2) {
                Socket sock = serverSock.accept();
                numPlayer++;
                System.out.println("Player " + numPlayer + " has connected to the server");

                ClientHandler clientHandler = new ClientHandler(sock, numPlayer);
                if (numPlayer == 1){
                    player1Handler = clientHandler;
                } else {
                    player2Handler = clientHandler;
                }
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
            System.out.println("We now have 2 players. Game will starts after both players submit their names.");
            board = new Board();
            System.out.println("Game Board created");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable{
        private Socket sock;
        private int playerID;
        private PrintWriter writer;
        private BufferedReader reader;
        public ClientHandler(Socket sock, int id){
            this.sock = sock;
            this.playerID = id;
            try{
                this.writer = new PrintWriter(sock.getOutputStream());
                InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                this.reader = new BufferedReader(streamReader);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        public void run(){
            try{
                writer.println(playerID);
                writer.flush();

                String command;
                while ((command = reader.readLine()) != null) {
                    System.out.println("Command from player" + playerID + ": " + command);
                    if (command.equals("SUBMIT")){
                        if (playerID == 1)
                            isPlayer1Ready = true;
                        else
                            isPlayer2Ready = true;
                        System.out.println("Player " + playerID + " has submitted his/her name");
                    }
                    else if (!(isPlayer1Ready && isPlayer2Ready)) {
                        writer.println("NOT READY");
                        writer.flush();
                        System.out.println("Server sent NOT READY");
                    }
                    else {
                        String sign;
                        if (playerID == 1)
                            sign = "X";
                        else
                            sign = "O";
                        board.newMove(Integer.parseInt(command) - 1, sign);
                        player1Handler.getWriter().println("NewMove: " + command + " " + sign);
                        player1Handler.getWriter().flush();
                        player2Handler.getWriter().println("NewMove: " + command + " " + sign);
                        player2Handler.getWriter().flush();

                        if (board.isWon(sign)){
                            if (sign.equals("X")){
                                player1Handler.getWriter().println("WIN");
                                player1Handler.getWriter().flush();
                                player2Handler.getWriter().println("LOSE");
                                player2Handler.getWriter().flush();
                                System.out.println("Game's ended. Player 1 win");
                            }else{
                                player1Handler.getWriter().println("LOSE");
                                player1Handler.getWriter().flush();
                                player2Handler.getWriter().println("WIN");
                                player2Handler.getWriter().flush();
                                System.out.println("Game's ended. Player 2 win");
                            }
                            break;
                        }
                        else if (board.isDraw()){
                            player1Handler.getWriter().println("DRAW");
                            player1Handler.getWriter().flush();
                            player2Handler.getWriter().println("DRAW");
                            player2Handler.getWriter().flush();
                            System.out.println("Game's ended. DRAW");
                            break;
                        }

                        if (playerID == 1){
                            player2Handler.getWriter().println("YOUR TURN NOW");
                            player2Handler.getWriter().flush();
                            System.out.println("It's Player2's turn now");
                        } else {
                            player1Handler.getWriter().println("YOUR TURN NOW");
                            player1Handler.getWriter().flush();
                            System.out.println("It's Player1's turn now");
                        }
                    }
                }
            } catch(Exception ex){
                if (playerID == 1){
                    player2Handler.getWriter().println("LEFT");
                    player2Handler.getWriter().flush();
                    System.out.println("Game's ended. Player 1 left.");
                } else {
                    player1Handler.getWriter().println("LEFT");
                    player1Handler.getWriter().flush();
                    System.out.println("Game's ended. Player 2 left.");
                }
            }
        }

        public PrintWriter getWriter() {
            return writer;
        }
    }
}

