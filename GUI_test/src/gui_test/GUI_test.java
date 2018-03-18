/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_test;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rhalhas
 */
public class GUI_test {

    /**
     * @param args the command line arguments
     */
    
    //Funkcja ladujaca zasoby
    public ImageIcon ZaladujZasoby (String nazwaZasobu){
        ImageIcon obraz = null;
        java.net.URL imgURL = getClass().getClassLoader().getResource(nazwaZasobu);
        if (imgURL != null) {
            obraz = new ImageIcon(imgURL);
            return obraz;
        } else {
            System.err.println("Nie znaleziono pliku: " + nazwaZasobu);
            return null;
        }    
    }
    
    public GUI_test() {
        //Tworzenie okna glownego
        JFrame okno = new JFrame();
        okno.setBounds(20, 20, 1170, 1000);
        okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container panel = okno.getContentPane();
        panel.setLayout(new BorderLayout());
        
        //Tworzenie panelu Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        JPanel menuTop = new JPanel();
        menuTop.setBackground(Color.white);
        menuTop.setLayout(new GridLayout(4,0,0,10));
        JPanel menuMiddle = new JPanel();
        menuMiddle.setBackground(Color.white);
        menuMiddle.setLayout(new BorderLayout());
        JPanel menuBottom = new JPanel();
        menuBottom.setBackground(Color.white);
        menuBottom.setLayout(new GridLayout(3,0,0,10));
        menuPanel.add(menuTop, NORTH);
        menuPanel.add(menuMiddle, CENTER);
        menuPanel.add(menuBottom, SOUTH);
        
        //Tworzenie ramek wokol menu
        JPanel separatorSrodekPanel = new JPanel();
        separatorSrodekPanel.setBackground(Color.black);
        JPanel ramkaPrawaPanel = new JPanel();
        ramkaPrawaPanel.setBackground(Color.black);
        JPanel menuRamkaPanel = new JPanel(); //panel trzymajacy menuPanel oraz ramki
        menuRamkaPanel.setLayout(new BorderLayout());
        panel.add(menuRamkaPanel, EAST);
        menuRamkaPanel.add(menuPanel,CENTER);
        menuRamkaPanel.add(separatorSrodekPanel,WEST);
        menuRamkaPanel.add(ramkaPrawaPanel,EAST);
        
        //Tworzenie ramki lewej i dolnej
        JPanel ramkaLewaPanel = new JPanel();
        ramkaLewaPanel.setBackground(Color.black);
        panel.add(ramkaLewaPanel, WEST);
        JPanel ramkaDolnaPanel = new JPanel();
        ramkaDolnaPanel.setBackground(Color.black);
        panel.add(ramkaDolnaPanel, SOUTH);
        
        //Tworzenie menu
        JButton finanseButton = new JButton();
        finanseButton.setIcon(ZaladujZasoby("resources/ksiegowosc.jpg"));
        finanseButton.setBorder(createEmptyBorder());
        JButton infrastrukturaButton = new JButton();
        infrastrukturaButton.setIcon(ZaladujZasoby("resources/infrastruktura.jpg"));
        infrastrukturaButton.setBorder(createEmptyBorder());
        JButton prasaButton = new JButton();
        prasaButton.setIcon(ZaladujZasoby("resources/info.jpg"));
        prasaButton.setBorder(createEmptyBorder());
        JButton nextTurnButton = new JButton();
        nextTurnButton.setIcon(ZaladujZasoby("resources/next.jpg"));
        nextTurnButton.setBorder(createEmptyBorder());
        menuTop.add(finanseButton);
        menuTop.add(infrastrukturaButton);
        menuTop.add(prasaButton);
        menuTop.add(nextTurnButton);
        
        JButton dzielnicaNButton = new JButton();
        dzielnicaNButton.setIcon(ZaladujZasoby("resources/dzielnicaN.jpg"));
        dzielnicaNButton.setBorder(createEmptyBorder());
        JButton dzielnicaSButton = new JButton();
        dzielnicaSButton.setIcon(ZaladujZasoby("resources/dzielnicaS.jpg"));
        dzielnicaSButton.setBorder(createEmptyBorder());
        JButton dzielnicaEButton = new JButton();
        dzielnicaEButton.setIcon(ZaladujZasoby("resources/dzielnicaE.jpg"));
        dzielnicaEButton.setBorder(createEmptyBorder());
        menuBottom.add(dzielnicaNButton);
        menuBottom.add(dzielnicaSButton);
        menuBottom.add(dzielnicaEButton);
        //Koniec definicji menu
        
        //Tworzenie paska info na gorze
        String tempInfo = "Gracz A      Finanse : 230       Tura : 15";
        JPanel pasekInfoPanel = new JPanel();
        pasekInfoPanel.setLayout(new FlowLayout());
        pasekInfoPanel.setBackground(Color.black);
        panel.add(pasekInfoPanel,NORTH);
        JLabel graczLabel = new JLabel();
        graczLabel.setText(tempInfo);
        graczLabel.setForeground(Color.yellow);
        pasekInfoPanel.add(graczLabel);
        
        //Tworzenie okna centralnego
        JPanel mapaPanel = new JPanel();
        mapaPanel.setLayout(new GridBagLayout());
        GridBagConstraints ograniczenia = new GridBagConstraints();
        panel.add(mapaPanel,CENTER);
        JButton mapaButton = new JButton();
        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                mapaButton = new JButton();
                mapaButton.setIcon(ZaladujZasoby("resources/river.jpg"));
                mapaButton.setBorder(createEmptyBorder());
                ograniczenia.gridwidth = 1;
                ograniczenia.gridx = i;
                ograniczenia.gridy = j;
                mapaPanel.add(mapaButton, ograniczenia);
            }
        }
        //Koniec tworzenia okna centralnego
        
        okno.setTitle("Tytul gry");
        okno.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here    
        SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            new GUI_test();
        }
    });
        
    }
    
}
