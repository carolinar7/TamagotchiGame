package juniorProj;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class main {    
    /*// Leaderboard Variables
    static String topUserScore1 = "";
    static String topUserScore2 = "";
    static String topUserScore3 = "";
    static String topUserScore4 = "";
    static String topUserScore5 = "";
    static String topUserScore6 = "";
    static String topUserScore7 = "";
    static String topUserScore8 = "";
    static String topUserScore9 = "";
    static String topUserScore10 = "";
    static int topScore1 = 0;
    static int topScore2 = 0;
    static int topScore3 = 0;
    static int topScore4 = 0;
    static int topScore5 = 0;
    static int topScore6 = 0;
    static int topScore7 = 0;
    static int topScore8 = 0;
    static int topScore9 = 0;
    static int topScore10 = 0;*/
    
    // Format
    static DecimalFormat form = new DecimalFormat("0.00");
    
    // Variable for User Info
    static String sName;
    static String sPass;
    static char[] hPass;
    private static String password;
    
    // General Variables for Game
    static String pet;
    static String name;
    static int day = 0;
    static double money = 0;
    
    // Food Variables
    static String food = "";
    static int chickenFeetA = 0;
    static int khashA = 0;
    static int spamA = 0;
    
    // Toy Variables
    static String toy = "";
    static int ballA = 0;
    static int basterA = 0;
    static int boneA = 0;
    
    // Current Stats for Pet
    static int currentHunger = 10;
    static int currentHappiness = 10;
    static String state = "Good";
    
    // Fonts and Colors
    static Color aBlue = Color.decode("#aec6cf");
    static Font titleFont = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 60);
    static Font wordComic = new Font("Comic Sans MS", Font.BOLD, 30);
    static Font wordComicS = new Font("Comic Sans MS", Font.BOLD, 20);
    static Font wordTimes = new Font("Times New Roman", Font.BOLD, 30);
    static Font shopFont = new Font("Comic Sans MS", Font.BOLD, 16);
    
    /*// Variables Used for Database Connection
    static DBConnectionManagerSingleton dbmt;
    static Connection conn;
    PreparedStatement ps;
    static Statement stmt;
    Statement s;
    static ResultSet rs1;*/

    public static void main(String[] args) throws Exception {
        mainMenu();
    }

    public static void mainMenu() throws Exception{
        /*// CONNECTS TO DATABASE
        dbmt =  DBConnectionManagerSingleton.getInstance();
        System.out.println(dbmt);    
        conn = dbmt.getConnection();
        stmt = dbmt.getStatement();*/

        // CREATING FRAME
        JFrame f = new JFrame();
        JPanel N = new JPanel();
        JPanel S = new JPanel();
        JPanel M = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // IMPORTING IMAGES
        ImageIcon Title = new ImageIcon("Headers/petGame.png");
        ImageIcon Login = new ImageIcon("Text/loginM.png");
        ImageIcon Register = new ImageIcon("Text/registerM.png");
        ImageIcon Leaderboard = new ImageIcon("Text/leaderboardM.png");
        ImageIcon Exit = new ImageIcon("Text/exitM.png");

        // TOP AND BOTTOM
        N.add(new JLabel(Title));
        S.add(new JLabel("Created By Frederick Santiago, Justin Backman, and Nicolous Yardich"));

        // MIDDLE PANEL BUTTONS
        JButton A = new JButton(Login);
        A.setBorderPainted(false);
        A.setBackground(aBlue);
        A.setActionCommand("Login");
        A.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                login();
                f.dispose();
            }
        });

        JButton B = new JButton(Register);
        B.setBorderPainted(false);
        B.setBackground(aBlue);
        B.setActionCommand("Register");
        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                register();
                f.dispose();
            }
        });

        JButton C = new JButton(Leaderboard);
        C.setBorderPainted(false);
        C.setBackground(aBlue);
        C.setActionCommand("Leaderboard");
        C.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                leaderboard();
                f.dispose();
            }
        });

        JButton D = new JButton(Exit);
        D.setBorderPainted(false);
        D.setBackground(aBlue);
        D.setActionCommand("Exit");
        D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                f.dispose();
            }
        });

        // ADDING BUTTONS
        M.add(A);
        M.add(B);
        M.add(C);
        M.add(D);

        // COLORING EVERYTHING
        N.setBackground(aBlue);
        S.setBackground(aBlue);
        M.setBackground(aBlue);

        // ADDING EVERYTHING TO FRAME AND POLISHING FRAME
        f.add(N, BorderLayout.NORTH);
        f.add(M, BorderLayout.CENTER);
        f.add(S, BorderLayout.SOUTH);
        f.setSize(500,775);
        f.setResizable(false);
        f.setTitle("Pet Game - Main Menu");

        // FORCING TO MIDDLE OF SCREEN REGARDLESS OF MONITOR SIZE
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);

        f.setVisible(true);
    }

    public static void login() {
        // Images
        ImageIcon iLogin = new ImageIcon("Headers/login.PNG");
        ImageIcon iLoginB = new ImageIcon("Text/loginB.PNG");
        ImageIcon allCharacters = new ImageIcon("Characters/allCharacters.PNG");
        ImageIcon iBack = new ImageIcon("back.PNG");
        
        // Text Fields and Buttons
        JTextField tName = new JTextField();
        JPasswordField tPass = new JPasswordField();
        JFrame login = new JFrame("Pet Game - Login");
        JButton bLogin = new JButton(iLoginB);
        JButton back = new JButton(iBack);
        
        //JLabel wName = new JLabel("Incorrect Username");
        JLabel wPass = new JLabel("Incorrect Password");
        JLabel wName = new JLabel("Incorrect Username");

        // Login Frame
        login.setSize(500, 775);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.getContentPane().setBackground(aBlue);
        login.setLayout(null);

        // Header Label
        JLabel header = new JLabel(iLogin);
        header.setBounds(40, 30, 450, 150);
        header.setFont(titleFont);
        login.add(header);

        // Username Label
        JLabel uName = new JLabel("Username: ");
        uName.setBounds(10, 200, 170, 40);
        uName.setFont(wordComic);
        login.add(uName);

        // Password Label
        JLabel uPass = new JLabel("Password: ");
        uPass.setBounds(10, 300, 170, 40);
        uPass.setFont(wordComic);
        login.add(uPass);

        // All Characters Label
        JLabel lCharacter = new JLabel(allCharacters);
        lCharacter.setBounds(0, 525, 500, 204);
        login.add(lCharacter);

        // Username Text
        tName.setFont(wordTimes);
        tName.setBounds(180, 200, 250, 40);
        login.getContentPane().add(tName);
        tName.setVisible(true);

        // Password Text
        tPass.setFont(wordTimes);
        tPass.setBounds(180, 300, 250, 40);
        login.getContentPane().add(tPass);
        tPass.setVisible(true);

        // Username Wrong
        wName.setFont(wordComic);
        wName.setBounds(180, 235, 350, 40);
        wName.setForeground(Color.red);
        login.getContentPane().add(wName);
        wName.setVisible(false);

        // Password Wrong
        wPass.setFont(wordComic);
        wPass.setBounds(180, 335, 350, 40);
        wPass.setForeground(Color.red);
        login.getContentPane().add(wPass);
        wPass.setVisible(false);

        // Login in Middle of Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        login.setLocation(dim.width/2-login.getSize().width/2, dim.height/2-login.getSize().height/2);

        // Login Visible
        login.setVisible(true);

        // Login Button
        bLogin.setBounds(115, 400, 250, 105);
        bLogin.setBorderPainted(false);
        login.getContentPane().add(bLogin);
        bLogin.setVisible(true);

        // Back Button
        back.setBounds(10, 463, 80, 40);
        back.setBorderPainted(false);
        login.getContentPane().add(back);
        back.setVisible(true);

        back.addActionListener(e -> {
            try {
                mainMenu();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            login.dispose();
        });

        // Assign Name and Password Text Fields to Variables
        bLogin.addActionListener(e -> {
            wName.setVisible(false);
            wPass.setVisible(false);
            name = tName.getText();
            hPass = tPass.getPassword();
            password = "";
            for(char a : hPass) {
                password += a;
            }
            // SQL to compare Username and Password
            sName = "a";
            sPass = "a";

            if (!sName.equals(name)) {
                wName.setVisible(true);
            }

            else if (!sPass.equals(password)) {
                wPass.setVisible(true);
            }

            else {
                game();
                login.dispose();
            }
        });
    }

    public static void register() {
        // Images
        ImageIcon iRegister = new ImageIcon("Headers/register.PNG");
        ImageIcon iBack = new ImageIcon("back.PNG");
        ImageIcon iRegisterB = new ImageIcon("Text/registerB.PNG");
        ImageIcon allCharacters = new ImageIcon("Characters/allCharacters.PNG");

        // Text Fields and Buttons
        JTextField tName = new JTextField();
        JPasswordField tPass = new JPasswordField();
        JFrame login = new JFrame("Pet Game - Register");
        JButton bLogin = new JButton(iRegisterB);
        JButton back = new JButton(iBack);

        // Login Frame
        login.setSize(500, 775);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.getContentPane().setBackground(aBlue);
        login.setLayout(null);

        // Header Label
        JLabel header = new JLabel(iRegister);
        header.setBounds(40, 30, 450, 150);
        header.setFont(titleFont);
        login.add(header);

        // Username Label
        JLabel uName = new JLabel("Username: ");
        uName.setBounds(10, 200, 170, 40);
        uName.setFont(wordComic);
        login.add(uName);

        // Password Label
        JLabel uPass = new JLabel("Password: ");
        uPass.setBounds(10, 300, 170, 40);
        uPass.setFont(wordComic);
        login.add(uPass);

        // All Characters Label
        JLabel lCharacter = new JLabel(allCharacters);
        lCharacter.setBounds(0, 525, 500, 204);
        login.add(lCharacter);

        // Username Text
        tName.setFont(wordTimes);
        tName.setBounds(180, 200, 250, 40);
        login.getContentPane().add(tName);
        tName.setVisible(true);

        // Password Text
        tPass.setFont(wordTimes);
        tPass.setBounds(180, 300, 250, 40);
        login.getContentPane().add(tPass);
        tPass.setVisible(true);

        // Login in Middle of Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        login.setLocation(dim.width/2-login.getSize().width/2, dim.height/2-login.getSize().height/2);

        // Login Visible
        login.setVisible(true);

        // Login Button
        bLogin.setBounds(115, 400, 250, 105);
        bLogin.setBorderPainted(false);
        login.getContentPane().add(bLogin);
        bLogin.setVisible(true);

        // Back Button
        back.setBounds(10, 463, 80, 40);
        back.setBorderPainted(false);
        login.getContentPane().add(back);
        back.setVisible(true);

        back.addActionListener(e -> {
            try {
                mainMenu();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            login.dispose();
        });

        // Assign Name and Password Text Fields to Variables
        bLogin.addActionListener(e -> {
            name = tName.getText();
            hPass = tPass.getPassword();
            password = "";
            for(char a : hPass) {
                password += a;
            }
            // SQL to compare Username and Password
            if(name != "" && hPass.length != 0) {
                petSelect();
                login.dispose();
            }
        });
    }

    public static void leaderboard() {
        // Objects
        JFrame leaderboard = new JFrame("Pet Game - Leaderboard");
        JLabel title = new JLabel("Leaderboard");
        ImageIcon iBack = new ImageIcon("back.PNG");
        JButton back = new JButton(iBack);
        JLabel a = new JLabel("1: "); //+ topUserScore1);
        JLabel b = new JLabel("2: "); // + topUserScore2);
        JLabel c = new JLabel("3: "); // + topUserScore3);
        JLabel d = new JLabel("4: ");// + topUserScore4);
        JLabel e1 = new JLabel("5: ");// + topUserScore5);
        JLabel f = new JLabel("6: ");// + topUserScore6);
        JLabel g = new JLabel("7: ");// + topUserScore7);
        JLabel h = new JLabel("8: ");// + topUserScore8);
        JLabel i = new JLabel("9: ");// + topUserScore9);
        JLabel j = new JLabel("10: ");// + topUserScore10);
        
        // Leaderboard Frame
        leaderboard.setLayout(null);
        leaderboard.setResizable(false);
        leaderboard.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        leaderboard.setLocation(dim.width/2-leaderboard.getSize().width/2, dim.height/2-leaderboard.getSize().height/2);
        leaderboard.getContentPane().setBackground(aBlue);
        leaderboard.setVisible(true);
        
        // Title Text
        title.setBounds(0, 30, 500, 60);
        title.setFont(titleFont);
        title.setHorizontalAlignment(JLabel.CENTER);
        leaderboard.add(title);
        title.setVisible(true);
   
        // 1 on Leaderboards
        a.setBounds(10, 100, 400, 50);
        a.setFont(wordComic);
        leaderboard.add(a);
        a.setVisible(true);

        // 2 on Leaderboards
        b.setBounds(10, 150, 400, 50);
        b.setFont(wordComic);
        leaderboard.add(b);
        b.setVisible(true);

        // 3 on Leaderboards
        c.setBounds(10, 200, 400, 50);
        c.setFont(wordComic);
        leaderboard.add(c);
        c.setVisible(true);

        // 4 on Leaderboards
        d.setBounds(10, 250, 400, 50);
        d.setFont(wordComic);
        leaderboard.add(d);
        d.setVisible(true);

        // 5 on Leaderboards
        e1.setBounds(10, 300, 400, 50);
        e1.setFont(wordComic);
        leaderboard.add(e1);
        e1.setVisible(true);

        // 6 on Leaderboards
        f.setBounds(10, 350, 400, 50);
        f.setFont(wordComic);
        leaderboard.add(f);
        f.setVisible(true);

        // 7 on Leaderboards
        g.setBounds(10, 400, 400, 50);
        g.setFont(wordComic);
        leaderboard.add(g);
        g.setVisible(true);

        // 8 on Leaderboards
        h.setBounds(10, 450, 400, 50);
        h.setFont(wordComic);
        leaderboard.add(h);
        h.setVisible(true);

        // 9 on Leaderboards
        i.setBounds(10, 500, 400, 50);
        i.setFont(wordComic);
        leaderboard.add(i);
        i.setVisible(true);

        // 10 on Leaderboards
        j.setBounds(10, 550, 400, 50);
        j.setFont(wordComic);
        leaderboard.add(j);
        j.setVisible(true);   
                
     // Back Button
        back.setBounds(20, 650, 80, 40);
        back.setBorderPainted(false);
        leaderboard.getContentPane().add(back);
        back.setVisible(true);
        
        // Back Button Listener
        back.addActionListener(e -> {
        	try {
				mainMenu();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
            leaderboard.dispose();
         });


    

        // Retrieves the 10 highest scores and usernames  
        /*rs1 = stmt.executeQuery("select username, maxTurns from Player Order by maxTurns DESC");
        while(rs1.next()) {
            topUserScore1 = rs1.getString(1);
            topUserScore2 = rs1.getString(3);
            topUserScore3 = rs1.getString(5);
            topUserScore4 = rs1.getString(7);
            topUserScore5 = rs1.getString(9);
            topUserScore6 = rs1.getString(11);
            topUserScore7 = rs1.getString(13);
            topUserScore8 = rs1.getString(15);
            topUserScore9 = rs1.getString(17);
            topUserScore10 = rs1.getString(19);
            topScore1 = rs1.getInt(2);
            topScore2 = rs1.getInt(4);
            topScore3 = rs1.getInt(6);
            topScore4 = rs1.getInt(8);
            topScore5 = rs1.getInt(10);
            topScore6 = rs1.getInt(12);
            topScore7 = rs1.getInt(14);
            topScore8 = rs1.getInt(16);
            topScore9 = rs1.getInt(18);
            topScore10 = rs1.getInt(20);
            System.out.println(topUserScore1 + " " + topScore1);
        }*/
        // Displays the Highest Scores
    }
    
    public static void win() {
        
    }
    
    public static void over() {
        // Objects
        JFrame over = new JFrame("Pet Game - Lost!");
        JLabel uOver = new JLabel("You lost!");
        ImageIcon exitP = new ImageIcon("Text/exitM.png");
        JButton exit = new JButton(exitP);

        // Over Text
        uOver.setBounds(0, 150, 500, 60);
        uOver.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        uOver.setHorizontalAlignment(JLabel.CENTER);
        over.add(uOver);
        uOver.setVisible(true);

        // Over Frame
        over.setLayout(null);
        over.setResizable(false);
        over.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        over.setLocation(dim.width / 2 - over.getSize().width / 2, dim.height / 2 - over.getSize().height / 2);
        over.getContentPane().setBackground(aBlue);
        over.setVisible(true);

        // Exit Button
        exit.setBounds(0, 275, 500, 250);
        exit.setBorderPainted(false);
        exit.setBackground(aBlue);
        over.add(exit);

        exit.addActionListener(e -> {
            over.dispose();
        });
    }


    public static void petSelect() {
        // Objects
        JFrame petSelect = new JFrame("Pet Game - Pet Select");
        ImageIcon title = new ImageIcon("Headers/select pet screen.png");
        JLabel titleL = new JLabel(title);
        ImageIcon squid = new ImageIcon("Characters/SquidGood.png");
        ImageIcon lilBoi = new ImageIcon("Characters/LBGood.png");
        ImageIcon egg = new ImageIcon("Characters/eggslide.png");
        JButton char1 = new JButton(squid);
        JButton char2 = new JButton(lilBoi);
        JButton char3 = new JButton(egg);
        JLabel dChar1 = new JLabel("Squid");
        JLabel dChar2 = new JLabel("Lil Boi");
        JLabel dChar3 = new JLabel("Egg");
        
        // Pet Select Frame
        petSelect.setLayout(null);
        petSelect.setResizable(false);
        petSelect.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        petSelect.setLocation(dim.width/2-petSelect.getSize().width/2, dim.height/2-petSelect.getSize().height/2);
        petSelect.getContentPane().setBackground(aBlue);
        petSelect.setVisible(true);

        // Header
        titleL.setBounds(20, 50, 500, 131);
        titleL.setVisible(true);
        petSelect.getContentPane().add(titleL);
        
        // Squid Text
        dChar1.setBounds(15, 550, 140, 100);
        dChar1.setFont(wordComic);
        dChar1.setHorizontalAlignment(JLabel.CENTER);
        titleL.setVisible(true);
        petSelect.getContentPane().add(dChar1);

        // Lil Boi Text
        dChar2.setBounds(172, 550, 140, 100);
        dChar2.setFont(wordComic);
        dChar2.setHorizontalAlignment(JLabel.CENTER);
        titleL.setVisible(true);
        petSelect.getContentPane().add(dChar2);

        // Egg Text
        dChar3.setBounds(330, 550, 140, 100);
        dChar3.setFont(wordComic);
        dChar3.setHorizontalAlignment(JLabel.CENTER);
        titleL.setVisible(true);
        petSelect.getContentPane().add(dChar3);

        // Squid Button
        char1.setBounds(15, 280, 140, 300);
        petSelect.add(char1);
        char1.setVisible(true);

        // Lil Boi Button
        char2.setBounds(172, 280, 140, 300);
        petSelect.add(char2);
        char2.setVisible(true);

        // Egg Button
        char3.setBounds(330, 280, 140, 300);
        petSelect.add(char3);
        char3.setVisible(true);

        // Squid Button Listener
        char1.addActionListener(e -> {
            pet = "Squid";
            day++;
            game();
            petSelect.dispose();
        });

        // Lil Boi Button Listener
        char2.addActionListener(e -> {
            pet = "LB";
            day++;
            game();
            petSelect.dispose();
        });

        // Egg Listener
        char3.addActionListener(e -> {
            pet = "Egg";
            day++;
            game();
            petSelect.dispose();
        });
    }

    public static void game() {
    
        // CREATING FRAME
        JFrame g = new JFrame("Pet Game");
        JPanel Ng = new JPanel();
        Ng.setBackground(aBlue);
        JPanel Sg = new JPanel();
        Sg.setBackground(aBlue);
        JPanel Mg = new JPanel();
        Mg.setBackground(aBlue);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setLayout(new BorderLayout());
        g.setSize(500,775);
        g.setResizable(false);
        Dimension dim1 = Toolkit.getDefaultToolkit().getScreenSize();
        g.setLocation(dim1.width/2-g.getSize().width/2, dim1.height/2-g.getSize().height/2);

        if (currentHappiness <= 0) {
    		over();
    		g.dispose();
    	}
        
        // Middle Panel
        ImageIcon EggAlright = new ImageIcon("Characters/" + pet + state + ".png");
        JButton Egg = new JButton(EggAlright);
        Egg.setBorderPainted(false);
        Egg.setBackground(aBlue);
        ImageIcon hunger = new ImageIcon("Hunger/hu" + currentHunger + ".png");
        ImageIcon happy = new ImageIcon("Happiness/h" + currentHappiness + ".png");

        JLabel LHappiness = new JLabel(happy, JLabel.CENTER);
        LHappiness.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel LHunger = new JLabel(hunger, JLabel.CENTER);
        LHunger.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel LMoney = new JLabel("Money: $" + form.format(money) + "                               ", JLabel.CENTER);
        LMoney.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel LDays = new JLabel("                         Days: " + day, JLabel.CENTER);
        LDays.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        Mg.add(LMoney);
        Mg.add(LDays);
        Mg.add(LHappiness);
        Mg.add(LHunger);
        Mg.add(Egg);


        // North Panel
        ImageIcon Top = new ImageIcon("Headers/PGTop.png");
        JLabel Title = new JLabel(Top, JLabel.CENTER);

        Ng.add(Title);

        //South Panel
        ImageIcon Feed = new ImageIcon("Text/Feed.png");
        JButton FeedB = new JButton(Feed);
        FeedB.setBorderPainted(false);
        FeedB.setBackground(aBlue);
        Mg.add(FeedB);
        
        FeedB.addActionListener(e -> {
            feed();
            g.dispose();
        });

        ImageIcon Play = new ImageIcon("Text/Play.png");
        JButton PlayB = new JButton(Play);
        PlayB.setBorderPainted(false);
        PlayB.setBackground(aBlue);
        Mg.add(PlayB);
        
        PlayB.addActionListener(e -> {
            play();
            g.dispose();
        });
        
        ImageIcon Work = new ImageIcon("Text/Work.png");
        JButton WorkB = new JButton(Work);
        WorkB.setBorderPainted(false);
        WorkB.setBackground(aBlue);
        Sg.add(WorkB);
        
        WorkB.addActionListener(e -> {
            work();
            g.dispose();
        });
        
        ImageIcon Shop = new ImageIcon("Text/Shop.png");
        JButton ShoaBlue = new JButton(Shop);
        ShoaBlue.setBorderPainted(false);
        ShoaBlue.setBackground(aBlue);
        Sg.add(ShoaBlue);

        ShoaBlue.addActionListener(e -> {
            shop();
            g.dispose();
        });

        g.add(Ng, BorderLayout.NORTH);
        g.add(Mg, BorderLayout.CENTER);
        g.add(Sg, BorderLayout.SOUTH);
        g.setVisible(true);
    }

    public static void shop() {
        // Objects
        JFrame shop = new JFrame("Pet Game - Shop");
        ImageIcon title = new ImageIcon("Headers/Shop title.png");
        JLabel titleL = new JLabel(title);
        ImageIcon iChickenFeet = new ImageIcon("Food/CHICKEN FEET.png");
        ImageIcon iKhash = new ImageIcon("Food/khash.png");
        ImageIcon iSpam = new ImageIcon("Food/spam.png");
        JButton chickenFeet = new JButton(iChickenFeet);
        JButton khash = new JButton(iKhash);
        JButton spam = new JButton(iSpam);
        JLabel dChickenFeet = new JLabel("Chicken Feet: $2");
        JLabel dKhash = new JLabel("Khash: $13");
        JLabel dSpam = new JLabel("Spam: $5");
        ImageIcon iBack = new ImageIcon("back.PNG");
        JButton back = new JButton(iBack);
        ImageIcon iBall = new ImageIcon("Toys/ball.png");
        ImageIcon iBaster = new ImageIcon("Toys/baster.png");
        ImageIcon iBone = new ImageIcon("Toys/bone.png");
        JButton ball = new JButton(iBall);
        JButton baster = new JButton(iBaster);
        JButton bone = new JButton(iBone);
        JLabel dBall = new JLabel("     Ball: $4");
        JLabel dBaster = new JLabel("Baster: $10");
        JLabel dBone = new JLabel("Bone: $2.50");

        // Shop Frame
        shop.setLayout(null);
        shop.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        shop.setLocation(dim.width/2-shop.getSize().width/2, dim.height/2-shop.getSize().height/2);
        shop.getContentPane().setBackground(aBlue);
        shop.setResizable(false);
        shop.setVisible(true);

        // Header
        titleL.setBounds(20, -5, 500, 131);
        shop.add(titleL);

        // Ball Button
        ball.setBounds(15, 130, 140, 190);
        shop.add(ball);

        // baster Button
        baster.setBounds(172, 130, 140, 190);
        shop.add(baster);

        // Bone Button
        bone.setBounds(330, 130, 140, 190);
        shop.add(bone);

        // Ball Text
        dBall.setBounds(15, 315, 140, 50);
        dBall.setFont(shopFont);
        ball.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dBall);
        dBall.setVisible(true);

        // Baster Text
        dBaster.setBounds(172, 315, 140, 50);
        dBaster.setFont(shopFont);
        dBaster.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dBaster);
        dBaster.setVisible(true);

        // Bone Text
        dBone.setBounds(330, 315, 140, 50);
        dBone.setFont(shopFont);
        dBone.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dBone);
        dBone.setVisible(true);

        // Chicken Feet Button
        chickenFeet.setBounds(15, 380, 140, 190);
        shop.add(chickenFeet);
                
        // Khash Button
        khash.setBounds(172, 380, 140, 190);
        shop.add(khash);
                
        // Spam Button
        spam.setBounds(330, 380, 140, 190);
        shop.add(spam);
        
        // Chicken Feet Text
        dChickenFeet.setBounds(15, 570, 140, 50);
        dChickenFeet.setFont(shopFont);
        chickenFeet.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dChickenFeet);
        dChickenFeet.setVisible(true);

        // Khash Text
        dKhash.setBounds(172, 570, 140, 50);
        dKhash.setFont(shopFont);
        dKhash.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dKhash);
        dKhash.setVisible(true);

        // Spam Text
        dSpam.setBounds(330, 570, 140, 50);
        dSpam.setFont(shopFont);
        dSpam.setHorizontalAlignment(JLabel.CENTER);
        shop.add(dSpam);
        dSpam.setVisible(true);
                
        // Back Button
        back.setBounds(20, 650, 80, 40);
        back.setBorderPainted(false);
        shop.getContentPane().add(back);
        back.setVisible(true);    
                
        // Back Button Listener
        back.addActionListener(e -> {
            game();
            shop.dispose();
        });

        // Ball Button Listener
        ball.addActionListener(e -> {
            if(money >= 4) {
                ballA++;
                money-= 4;
                shop.dispose();
                game();
            }
        });
        
        // Baster Button Listener
        baster.addActionListener(e -> {
            if (money >= 10) {
                basterA++;
                money -= 10;
                shop.dispose();
                game();
            }
        });

        // Bone Button Listener
        bone.addActionListener(e -> {
            if (money >= 2.5) {
                boneA++;
                money -= 2.5;
                shop.dispose();
                game();
            }
        });
        
        // Chicken Feet Button Listener
        chickenFeet.addActionListener(e -> {
            if(money >= 2) {
                chickenFeetA++;
                money-= 2;
                shop.dispose();
                game();
            }
        });

        // Khash Button Listener
        khash.addActionListener(e -> {
            if(money >= 13) {
                khashA++;
                money-= 13;
                shop.dispose();
                game();
            }
        });

        // Spam Button Listener
        spam.addActionListener(e -> {
            if(money >= 5) {
                spamA++;
                money-= 5;
                shop.dispose();
                game();
            }
        });
    }

    public static void feed() {
        // Objects
        JFrame feed = new JFrame("Pet Game - Feed");
        ImageIcon title = new ImageIcon("Headers/feedtitle.png");
        JLabel titleL = new JLabel(title);
        ImageIcon iChickenFeet = new ImageIcon("Food/CHICKEN FEET.png");
        ImageIcon iKhash = new ImageIcon("Food/khash.png");
        ImageIcon iSpam = new ImageIcon("Food/spam.png");
        JButton chickenFeet = new JButton(iChickenFeet);
        JButton khash = new JButton(iKhash);
        JButton spam = new JButton(iSpam);
        JLabel dChickenFeet = new JLabel(" Chicken Feet");
        JLabel dKhash = new JLabel("Khash");
        JLabel dSpam = new JLabel("Spam");
        ImageIcon iBack = new ImageIcon("back.PNG");
        JButton back = new JButton(iBack);
        JLabel cChickenFeet = new JLabel(chickenFeetA + "x");
        JLabel cKhash = new JLabel(khashA + "x");
        JLabel cSpam = new JLabel(spamA + "x");

        // Feed Frame
        feed.setLayout(null);
        feed.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        feed.setLocation(dim.width/2-feed.getSize().width/2, dim.height/2-feed.getSize().height/2);
        feed.getContentPane().setBackground(aBlue);
        feed.setResizable(false);
        feed.setVisible(true);

        // Header
        titleL.setBounds(20, 50, 500, 131);
        feed.add(titleL);

        // Chicken Feet Button
        chickenFeet.setBounds(15, 280, 140, 190);
        feed.add(chickenFeet);
        
        // Khash Button
        khash.setBounds(172, 280, 140, 190);
        feed.add(khash);
        
        // Spam Button
        spam.setBounds(330, 280, 140, 190);
        feed.add(spam);
        
        // Chicken Feet Counter
        cChickenFeet.setBounds(15, 230, 140, 50);
        cChickenFeet.setFont(wordComicS);
        cChickenFeet.setHorizontalAlignment(JLabel.CENTER);
        feed.add(cChickenFeet);
        
        // Khash Counter
        cKhash.setBounds(172, 230, 140, 50);
        cKhash.setFont(wordComicS);
        cKhash.setHorizontalAlignment(JLabel.CENTER);
        feed.add(cKhash);
        
        // Spam Counter
        cSpam.setBounds(330, 230, 140, 50);
        cSpam.setFont(wordComicS);
        cSpam.setHorizontalAlignment(JLabel.CENTER);
        feed.add(cSpam);
        
        // Chicken Feet Text
        dChickenFeet.setBounds(15, 150, 140, 700);
        dChickenFeet.setFont(wordComicS);
        dChickenFeet.setHorizontalAlignment(JLabel.CENTER);
        feed.add(dChickenFeet);
        dChickenFeet.setVisible(true);

        // Khash Text
        dKhash.setBounds(172, 150, 140, 700);
        dKhash.setFont(wordComicS);
        dKhash.setHorizontalAlignment(JLabel.CENTER);
        feed.add(dKhash);
        dKhash.setVisible(true);

        // Spam Text
        dSpam.setBounds(330, 150, 140, 700);
        dSpam.setFont(wordComicS);
        dSpam.setHorizontalAlignment(JLabel.CENTER);
        feed.add(dSpam);
        dSpam.setVisible(true);
        
        // Back Button
        back.setBounds(20, 650, 80, 40);
        back.setBorderPainted(false);
        feed.getContentPane().add(back);
        back.setVisible(true);
        
        
        // Back Button Listener
        back.addActionListener(e -> {
            game();
            feed.dispose();
        });

        // Chicken Feet Button Listener
        chickenFeet.addActionListener(e -> {
            if(chickenFeetA != 0) {
                chickenFeetA--;
                currentHunger += 3;
                feed.dispose();
                update();
            }
        });

        // Khash Button Listener
        khash.addActionListener(e -> {
            if(khashA != 0) {
                khashA--;
                currentHunger += 12;
                feed.dispose();
                update();
            }
        });

        // Spam Button Listener
        spam.addActionListener(e -> {
            if(spamA != 0) {
                spamA--;
                currentHunger += 5;
                feed.dispose();
                update();
            }
        });
    }

    public static void play() {
        // Objects
        JFrame play = new JFrame("Pet Game - Play");
        ImageIcon title = new ImageIcon("Headers/playbutton.png");
        JLabel titleL = new JLabel(title);
        ImageIcon iBall = new ImageIcon("Toys/ball.png");
        ImageIcon iBaster = new ImageIcon("Toys/baster.png");
        ImageIcon iBone = new ImageIcon("Toys/bone.png");
        JButton ball = new JButton(iBall);
        JButton baster = new JButton(iBaster);
        JButton bone = new JButton(iBone);
        JLabel dBall = new JLabel("     Ball");
        JLabel dBaster = new JLabel("Baster");
        JLabel dBone = new JLabel("Bone");
        ImageIcon iBack = new ImageIcon("back.PNG");
        JButton back = new JButton(iBack);
        JLabel cBall = new JLabel(ballA + "x");
        JLabel cBaster = new JLabel(basterA + "x");
        JLabel cBone = new JLabel(boneA + "x");
        
        // Play Frame
        play.setLayout(null);
        play.setSize(500, 775);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        play.setLocation(dim.width/2-play.getSize().width/2, dim.height/2-play.getSize().height/2);
        play.getContentPane().setBackground(aBlue);
        play.setResizable(false);
        play.setVisible(true);
        
        // Header
        titleL.setBounds(20, 50, 500, 131);
        play.add(titleL);

        // Ball Button
        ball.setBounds(15, 280, 140, 190);
        play.add(ball);
        
        // baster Button
        baster.setBounds(172, 280, 140, 190);
        play.add(baster);
        
        // Bone Button
        bone.setBounds(330, 280, 140, 190);
        play.add(bone);
        
        // Ball Counter
        cBall.setBounds(15, 230, 140, 50);
        cBall.setFont(wordComicS);
        cBall.setHorizontalAlignment(JLabel.CENTER);
        play.add(cBall);
                
        // Baster Counter
        cBaster.setBounds(172, 230, 140, 50);
        cBaster.setFont(wordComicS);
        cBaster.setHorizontalAlignment(JLabel.CENTER);
        play.add(cBaster);
                
        // Bone Counter
        cBone.setBounds(330, 230, 140, 50);
        cBone.setFont(wordComicS);
        cBone.setHorizontalAlignment(JLabel.CENTER);
        play.add(cBone);
        
        // Ball Text
        dBall.setBounds(15, 150, 140, 700);
        dBall.setFont(wordComicS);
        ball.setHorizontalAlignment(JLabel.CENTER);
        play.add(dBall);
        dBall.setVisible(true);
        
        // Baster Text
        dBaster.setBounds(172, 150, 140, 700);
        dBaster.setFont(wordComicS);
        dBaster.setHorizontalAlignment(JLabel.CENTER);
        play.add(dBaster);
        dBaster.setVisible(true);

        // Bone Text
        dBone.setBounds(330, 150, 140, 700);
        dBone.setFont(wordComicS);
        dBone.setHorizontalAlignment(JLabel.CENTER);
        play.add(dBone);
        dBone.setVisible(true);
        
        // Back Button
        back.setBounds(20, 650, 80, 40);
        back.setBorderPainted(false);
        play.getContentPane().add(back);
        back.setVisible(true);
        
        // Back Button Listener
        back.addActionListener(e -> {
            game();
            play.dispose();
        });

        // Chicken Feet Button Listener
        ball.addActionListener(e -> {
            if(ballA != 0) {
                ballA--;
                currentHappiness++;
                play.dispose();
                update();
            }
        });

        // Baster Button Listener
        baster.addActionListener(e -> {
            if(basterA != 0) {
                basterA--;
                currentHappiness += 3;
                play.dispose();
                update();
            }
        });

        // Bone Button Listener
        bone.addActionListener(e -> {
            if(boneA != 0) {
                boneA--;
                currentHappiness += 1;
                play.dispose();
                update();
            }
        });
    }
    
    public static void work() {
        // Objects
        JFrame work = new JFrame("Pet Game - Work");    
        ImageIcon kk = new ImageIcon("Text/ok.png");
        JButton ok = new JButton(kk);
        
        // Find How Much They Make
        Random r = new Random();
        double tMoney = Double.parseDouble(form.format(r.nextInt(7)*r.nextDouble()+3));
        
        // Work Frame
        work.setLayout(null);
        work.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        work.setLocation(dim.width / 2 - work.getSize().width / 2, dim.height / 2 - work.getSize().height / 2);
        work.getContentPane().setBackground(aBlue);
        work.setResizable(false);
        work.setVisible(true);
        
        // Tell Them How Much They Made
        JLabel moneys = new JLabel("You made " + tMoney + "$");
        moneys.setBounds(0, 150, 500, 60);
        moneys.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
        moneys.setHorizontalAlignment(JLabel.CENTER);
        work.add(moneys);
        moneys.setVisible(true);
        
        // Money Button
        ok.setBounds(175, 275, 150, 63);
        ok.setBorderPainted(false);
        ok.setBackground(aBlue);
        work.add(ok);
        
        ok.addActionListener(e -> {
            money += tMoney;
            work.dispose();
            update();
        });
    }
    
    public static void update() {
        
        currentHunger -= 2;
        
        if(currentHappiness > 10) {
            currentHappiness = 10;
        }
        
        if(currentHunger > 10) {
            currentHunger = 10;
        }
        
        if(currentHunger == 6 || currentHunger == 5) {
            currentHappiness--;
        }
        
        else if(currentHunger == 4 || currentHunger == 3) {
            currentHappiness -= 2;
        }
        
        else if(currentHunger == 2 || currentHunger == 1) {
            currentHappiness -= 3;
        }
        
        if(currentHappiness > 7) {
            state = "Good";
        }
        
        else if(currentHappiness > 3) {
            state = "Alright";
        }
        
        else if(currentHappiness > 0) {
            state = "Bad";
        }
        
        if(currentHunger == 0) {
            over();
        }
        
        else if(currentHappiness == 0) {
            over();
        }
        
        else if(day == 30) {
            win();
        }
        
        else {
            day++;
            game();
        }
        
    }
}

