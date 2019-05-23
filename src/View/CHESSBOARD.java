package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class CHESSBOARD {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "A.I.Chess ist ready zu destroyen!");
    private static final String COLS = "ABCDEFGH";

    CHESSBOARD() {
        initializeGui();
    }
    
    
    
    
    

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        //beispiel buttons mit m�glicher funktion
        tools.add(new JButton("Neues Spiel")); 
        tools.add(new JButton("Speichern")); 
        tools.add(new JButton("Alter Spielstand")); 
        tools.addSeparator();
        tools.add(new JButton("Schlie�en")); 
        tools.addSeparator();
        tools.add(message);
        
        //noch Platz f�r andere Elemente
        gui.add(new JLabel("..."), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        // creating board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                
                b.setMargin(buttonMargin);
                // chess pieces are prolly 64x64 px in size so now create empty image
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setText(String.valueOf(ii) + String.valueOf(jj));
                
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                    b.setForeground(Color.WHITE); 
                } else {
                    b.setBackground(Color.BLACK);
                    b.setForeground(Color.BLACK); 
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
        
     // if a button gets clicked 
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    String text = ((JButton) e.getSource()).getText();
                    //JOptionPane.showMessageDialog(null, text);
                    System.out.println(text);
                    PlayerSelected(text);
                    
                }
            }
        };
        
        
        

        //fill the chess board
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                    default:
                        chessBoardSquares[ii][jj].addActionListener(listener); // action listener added
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }
    
    void PlayerSelected(String text) {
		
		
	}






	// formatierungen:
    public final JComponent getChessBoard() {
        return chessBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                CHESSBOARD cb =
                        new CHESSBOARD();

                JFrame f = new JFrame("A.I.Chess");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // minimum size it needs to be
                // in order display the components within it
                f.pack();
                // minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
        
        
     
        
        //JOptionPane.showMessageDialog(null, gui);
        
    }
}
