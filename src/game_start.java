
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohan
 */

public class game_start extends javax.swing.JFrame {
    //clock tune
    
    public void clocktune()
    {
        InputStream in;
     try{
     
     in=new FileInputStream(new File(getClass().getResource("/audios/timetune.wav").getFile()));
     
     AudioStream a=new AudioStream(in);
     AudioPlayer.player.start(a);
    if(optionselected.getText().equals("y"))
    {
        AudioPlayer.player.stop(a);
    }
    }catch(Exception e){System.out.print(e.getMessage());
    }
    }
    
    
    
    
    
    
    
    //timer
    public void time()
    {
        java.util.Timer timer = new java.util.Timer(); //new timer
        counter = 30; //setting the counter to 30 sec
        TimerTask task = new TimerTask() {         
            public void run() {                
                jLabel31.setText(Integer.toString(counter)); //the timer lable to counter.
                counter --;
                if (counter == -1){
                    timer.cancel();      
                    JOptionPane.showMessageDialog(null,"Time's Up "+ name.getText());
                    prize();
                } 
                else if(optionselected.getText().equals("y"))
                {
                    timer.cancel();
                }else if(isIt){
                    timer.cancel();
                    isIt = false;
                }
            }
        };
    timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    
    
    
public void gque() throws ClassNotFoundException, SQLException
{
    int questionnumber[]= {1,2,3,4,5,6,7};
    
    
    Random rand=new Random();
    int finalque=questionnumber[rand.nextInt(questionnumber.length)];
    
    
    Class.forName("java.sql.DriverManager");
    Connection c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc","root","12345");
    Statement s=(Statement) c.createStatement();
    String a="SELECT question,a,b,c,d,answer FROM questions where que_no='"+finalque+"';";
    ResultSet rs=s.executeQuery(a);
    
    if(rs.next())
    {
        String get_que=rs.getString("question");
        String get_oa=rs.getString("a");
        String get_ob=rs.getString("b");
        String get_oc=rs.getString("c");
        String get_od=rs.getString("d");
        String get_ans=rs.getString("answer");
        
        jTextArea2.setText(""+get_que);
        option1.setText(""+get_oa);
         option2.setText(""+get_ob);
          option3.setText(""+get_oc);
           option4.setText(""+get_od);
           correctanswer.setText(""+get_ans);
        optionselected.setText("");
               
    }
}
    /**
     * Creates new form game_start
     */
     int counter = 10;
    Boolean isIt = false;
    public game_start() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        initComponents();
        
        
        currentquestion.setVisible(false);
        currentquestion.setText("1");
        fname.setVisible(false);
        fgender.setVisible(false);
        correctanswer.setVisible(false);
        optionselected.setVisible(false);
      this.setIconImage(new ImageIcon(getClass().getResource("/pics/kbclogo.jpg")).getImage());
      this.setTitle("KBC~ "+name.getText()+" game play");
        this.setResizable(false);
        this.setSize(1362,728);
       
        $_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28)); 
$_1.setForeground(new Color(255,184,0));
jTextArea2.setFont( new Font("Terbuchet",Font.PLAIN,28));
jTextArea2.setBackground(new Color(30,35,127));
name.setVisible(false);
gque();
//which almost comes upto 3 lines
       
           
        
        
        
        
        // Timer section below
         
       time();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        $_15 = new javax.swing.JLabel();
        $_14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        $_13 = new javax.swing.JLabel();
        $_12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        $_9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        $_10 = new javax.swing.JLabel();
        $_8 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        $_6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        $_7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        $_5 = new javax.swing.JLabel();
        option3panel = new javax.swing.JPanel();
        option3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        option4panel = new javax.swing.JPanel();
        option4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        $_4 = new javax.swing.JLabel();
        option2panel = new javax.swing.JPanel();
        option2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        option1panel = new javax.swing.JPanel();
        option1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        $_2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        $_3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        $_1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        $_11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        correctanswer = new javax.swing.JLabel();
        optionselected = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        fgender = new javax.swing.JLabel();
        currentquestion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Phone_65px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 10, 65, 80);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/quit.png"))); // NOI18N
        jLabel6.setText("QUITE");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(860, 20, 150, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Conference_65px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 10, 70, 80);

        $_15.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_15.setForeground(new java.awt.Color(255, 51, 0));
        $_15.setText("15.   7Crore");
        getContentPane().add($_15);
        $_15.setBounds(1080, 30, 240, 28);

        $_14.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_14.setForeground(new java.awt.Color(255, 51, 0));
        $_14.setText("14.   5Crore");
        getContentPane().add($_14);
        $_14.setBounds(1080, 70, 240, 28);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/50_65px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 30, 70, 50);

        $_13.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_13.setForeground(new java.awt.Color(255, 51, 0));
        $_13.setText("13.   3Crore");
        getContentPane().add($_13);
        $_13.setBounds(1080, 110, 250, 28);

        $_12.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_12.setForeground(new java.awt.Color(255, 51, 0));
        $_12.setText("12.   1Crore");
        getContentPane().add($_12);
        $_12.setBounds(1080, 150, 240, 28);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Swap_75px.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(670, 20, 75, 60);

        $_9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_9.setForeground(new java.awt.Color(255, 255, 255));
        $_9.setText("9.   12,50,000");
        getContentPane().add($_9);
        $_9.setBounds(1090, 270, 240, 28);

        jSeparator5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(480, 510, 90, 10);

        $_10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_10.setForeground(new java.awt.Color(255, 255, 255));
        $_10.setText("10.   25,00,000");
        getContentPane().add($_10);
        $_10.setBounds(1080, 230, 250, 28);

        $_8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_8.setForeground(new java.awt.Color(255, 51, 0));
        $_8.setText("8.   6,40,000  ");
        getContentPane().add($_8);
        $_8.setBounds(1090, 310, 240, 28);

        jSeparator8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(0, 580, 120, 10);

        jSeparator9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator9);
        jSeparator9.setBounds(930, 510, 120, 10);

        jSeparator10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator10);
        jSeparator10.setBounds(930, 580, 120, 10);

        jLabel31.setFont(new java.awt.Font("Utsaah", 1, 48)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 0));
        jLabel31.setText("30");
        jLabel31.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel31PropertyChange(evt);
            }
        });
        getContentPane().add(jLabel31);
        jLabel31.setBounds(510, 530, 40, 40);

        $_6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_6.setForeground(new java.awt.Color(255, 255, 255));
        $_6.setText("6.   1,60,000");
        getContentPane().add($_6);
        $_6.setBounds(1090, 390, 230, 30);

        jSeparator7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(0, 510, 120, 10);

        $_7.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_7.setForeground(new java.awt.Color(255, 255, 255));
        $_7.setText("7.   3,20,000");
        getContentPane().add($_7);
        $_7.setBounds(1090, 350, 240, 28);

        jSeparator6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(480, 580, 90, 10);

        $_5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_5.setForeground(new java.awt.Color(255, 255, 255));
        $_5.setText("5.   80,000");
        getContentPane().add($_5);
        $_5.setBounds(1090, 430, 240, 28);

        option3panel.setBackground(new java.awt.Color(30, 35, 127));
        option3panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 210, 241), 1, true));
        option3panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option3panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option3panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option3panelMouseExited(evt);
            }
        });

        option3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        option3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 102, 0));
        jLabel28.setText("C.");

        javax.swing.GroupLayout option3panelLayout = new javax.swing.GroupLayout(option3panel);
        option3panel.setLayout(option3panelLayout);
        option3panelLayout.setHorizontalGroup(
            option3panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, option3panelLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        option3panelLayout.setVerticalGroup(
            option3panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        getContentPane().add(option3panel);
        option3panel.setBounds(120, 560, 360, 50);

        option4panel.setBackground(new java.awt.Color(30, 35, 127));
        option4panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 210, 241), 1, true));
        option4panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option4panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option4panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option4panelMouseExited(evt);
            }
        });

        option4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        option4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 102, 0));
        jLabel30.setText("D.");

        javax.swing.GroupLayout option4panelLayout = new javax.swing.GroupLayout(option4panel);
        option4panel.setLayout(option4panelLayout);
        option4panelLayout.setHorizontalGroup(
            option4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, option4panelLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        option4panelLayout.setVerticalGroup(
            option4panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(option4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(option4panelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel30))
        );

        getContentPane().add(option4panel);
        option4panel.setBounds(570, 560, 360, 50);

        $_4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_4.setForeground(new java.awt.Color(255, 51, 0));
        $_4.setText("4.   40,000");
        getContentPane().add($_4);
        $_4.setBounds(1090, 470, 240, 28);

        option2panel.setBackground(new java.awt.Color(30, 35, 127));
        option2panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 210, 241), 1, true));
        option2panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option2panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option2panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option2panelMouseExited(evt);
            }
        });

        option2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        option2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 102, 0));
        jLabel29.setText("B.");

        javax.swing.GroupLayout option2panelLayout = new javax.swing.GroupLayout(option2panel);
        option2panel.setLayout(option2panelLayout);
        option2panelLayout.setHorizontalGroup(
            option2panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, option2panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        option2panelLayout.setVerticalGroup(
            option2panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        getContentPane().add(option2panel);
        option2panel.setBounds(570, 490, 360, 50);

        jLabel22.setText("jLabel22");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(0, 0, 40, 14);

        option1panel.setBackground(new java.awt.Color(30, 35, 127));
        option1panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 210, 241), 1, true));
        option1panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                option1panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option1panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option1panelMouseExited(evt);
            }
        });

        option1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        option1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 102, 0));
        jLabel27.setText("A.");

        javax.swing.GroupLayout option1panelLayout = new javax.swing.GroupLayout(option1panel);
        option1panel.setLayout(option1panelLayout);
        option1panelLayout.setHorizontalGroup(
            option1panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, option1panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        option1panelLayout.setVerticalGroup(
            option1panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        getContentPane().add(option1panel);
        option1panel.setBounds(120, 490, 360, 50);

        jPanel1.setBackground(new java.awt.Color(30, 35, 127));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 210, 241), 3, true));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setAutoscrolls(false);
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(120, 370, 810, 100);

        $_2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_2.setForeground(new java.awt.Color(255, 255, 255));
        $_2.setText("2.   10,000");
        getContentPane().add($_2);
        $_2.setBounds(1090, 550, 250, 28);

        jSeparator4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 420, 120, 10);

        $_3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_3.setForeground(new java.awt.Color(255, 255, 255));
        $_3.setText("3.   20,000");
        getContentPane().add($_3);
        $_3.setBounds(1090, 510, 250, 28);

        jSeparator3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(215, 218, 227), 3, true));
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(930, 420, 120, 10);

        $_1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_1.setForeground(new java.awt.Color(255, 255, 255));
        $_1.setText("1.   5,000");
        getContentPane().add($_1);
        $_1.setBounds(1090, 590, 250, 28);

        jSeparator1.setBackground(new java.awt.Color(255, 153, 102));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(1050, 10, 20, 610);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Kaun_Banega_Crorepati_logo.png"))); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(400, 90, 250, 270);

        $_11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        $_11.setForeground(new java.awt.Color(255, 255, 255));
        $_11.setText("11.   50,00,000");
        getContentPane().add($_11);
        $_11.setBounds(1080, 190, 250, 28);

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/-background Wallpapers for Desktop Blue textures background Wallpapers.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 770);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(150, 490, 100, 100);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(280, 490, 100, 100);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(450, 500, 100, 100);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(610, 500, 100, 100);

        name.setText("jLabel32");
        getContentPane().add(name);
        name.setBounds(0, 0, 40, 14);
        getContentPane().add(correctanswer);
        correctanswer.setBounds(970, 480, 0, 0);

        optionselected.setText("jLabel23");
        getContentPane().add(optionselected);
        optionselected.setBounds(940, 310, 40, 14);

        fname.setText("jLabel23");
        getContentPane().add(fname);
        fname.setBounds(20, 90, 40, 14);

        fgender.setText("jLabel23");
        getContentPane().add(fgender);
        fgender.setBounds(20, 110, 40, 14);

        currentquestion.setText("jLabel23");
        getContentPane().add(currentquestion);
        currentquestion.setBounds(1000, 100, 40, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1panelMouseEntered
option1panel.setBackground(new Color(150,132,0));        // TODO add your handling code here:
    }//GEN-LAST:event_option1panelMouseEntered

    private void option1panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1panelMouseExited
option1panel.setBackground(new Color(30,35,127));       // TODO add your handling code here:
    }//GEN-LAST:event_option1panelMouseExited

    private void option2panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2panelMouseEntered
option2panel.setBackground(new Color(150,132,0));           // TODO add your handling code here:
    }//GEN-LAST:event_option2panelMouseEntered

    private void option4panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option4panelMouseEntered
option4panel.setBackground(new Color(150,132,0));           // TODO add your handling code here:
    }//GEN-LAST:event_option4panelMouseEntered

    private void option3panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3panelMouseEntered
option3panel.setBackground(new Color(150,132,0));           // TODO add your handling code here:
    }//GEN-LAST:event_option3panelMouseEntered

    private void option2panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2panelMouseExited
option2panel.setBackground(new Color(30,35,127));        // TODO add your handling code here:
    }//GEN-LAST:event_option2panelMouseExited

    private void option4panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option4panelMouseExited
option4panel.setBackground(new Color(30,35,127));        // TODO add your handling code here:
    }//GEN-LAST:event_option4panelMouseExited

    private void option3panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3panelMouseExited
option3panel.setBackground(new Color(30,35,127));        // TODO add your handling code here:
    }//GEN-LAST:event_option3panelMouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
phone p=new phone();
p.jTextArea1.setEditable(false);
p.jTextArea1.setText(this.jTextArea2.getText()+"\n"+
        "A. "+option1.getText()+"             B. "+option2.getText()+"\n"+
        "C. "+option3.getText()+"             D. "+option4.getText());
p.jLabel8.setText(" Alright "+this.name.getText()+". The answer is option "+correctanswer.getText().toUpperCase());
p.jLabel2.setText("Hello, "+fname.getText());
if(fgender.getText().contains("Male"))
        {
            p.jLabel4.setIcon(new ImageIcon(getClass().getResource("/pics/male.png").getFile()));
                        p.jLabel7.setIcon(new ImageIcon(getClass().getResource("/pics/male.png").getFile()));
        }
else if(fgender.getText().contains("Female"))
{
                p.jLabel4.setIcon(new ImageIcon(getClass().getResource("/pics/female.png").getFile()));
                            p.jLabel7.setIcon(new ImageIcon(getClass().getResource("/pics/female.png").getFile()));
    
}
p.setVisible(true);
jLabel2.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
polls p=new polls();
p.setVisible(true);
String name=correctanswer.getText();
p.jLabel1.setIcon(new ImageIcon(getClass().getResource("/pics/"+name+".png").getFile()));

    jLabel3.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked



 
   
if(correctanswer.getText().contains("a")||correctanswer.getText().contains("A"))
{
    option2panel.setVisible(false);
    option3panel.setVisible(false);
}
else if(correctanswer.getText().contains("b")||correctanswer.getText().contains("B"))
{
    option1panel.setVisible(false);
    option4panel.setVisible(false);
}
else if(correctanswer.getText().contains("c")||correctanswer.getText().contains("C"))
{
    option1panel.setVisible(false);
    option4panel.setVisible(false);
}
else if(correctanswer.getText().contains("a")||correctanswer.getText().contains("A"))
{
    option2panel.setVisible(false);
    option3panel.setVisible(false);
}

     jLabel4.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            gque();
            color_reset();
// TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jLabel5.setVisible(false);
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jLabel31PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel31PropertyChange

    }//GEN-LAST:event_jLabel31PropertyChange

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void option1panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1panelMouseClicked
option1panel.setVisible(true);
option2panel.setVisible(true);
option3panel.setVisible(true);
option4panel.setVisible(true);
        if(correctanswer.getText().contains("a") || correctanswer.getText().contains("A"))
{
    option1panel.setBackground(Color.GREEN);
  
    
     optionselected.setText("y");
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/check.png").getFile());
    JOptionPane.showMessageDialog(this,"Correct answer "+name.getText(),"",JOptionPane.INFORMATION_MESSAGE,i);
    
 
    try {
        gque();
        color_reset();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    }     time(); 
     currentquestion.setText(Integer.toString(Integer.parseInt(currentquestion.getText())+1));
    question_color_change();
}
else
{
    
    if(correctanswer.getText().contains("c")||correctanswer.getText().contains("C"))
    {
        option3panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("b")||correctanswer.getText().contains("B"))
    {
        option2panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("d")||correctanswer.getText().contains("D"))
    {
        option4panel.setBackground(Color.GREEN);
    }
    {
       
        
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/wrong.png").getFile());
    JOptionPane.showMessageDialog(this,"It's a wrong answer "+name.getText()+"\n"+"Better luck next time","",JOptionPane.INFORMATION_MESSAGE,i);
     prize();}
}// TODO add your handling code here:
    }//GEN-LAST:event_option1panelMouseClicked

    private void option2panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2panelMouseClicked
option1panel.setVisible(true);
option2panel.setVisible(true);
option3panel.setVisible(true);
option4panel.setVisible(true);
if(correctanswer.getText().contains("b") || correctanswer.getText().contains("B"))
{
        option2panel.setBackground(Color.GREEN);
    optionselected.setText("y");
    
     final ImageIcon i=new ImageIcon(getClass().getResource("/pics/check.png").getFile());
    JOptionPane.showMessageDialog(this,"Absolutely correct answer "+name.getText(),"",JOptionPane.INFORMATION_MESSAGE,i);
    
   
    try {
        gque();
        color_reset();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    }time(); 
    currentquestion.setText(Integer.toString(Integer.parseInt(currentquestion.getText())+1));
    question_color_change();
}
else
{
    
    if(correctanswer.getText().contains("a")||correctanswer.getText().contains("A"))
    {
        option1panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("c")||correctanswer.getText().contains("C"))
    {
        option3panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("d")||correctanswer.getText().contains("D"))
    {
        option4panel.setBackground(Color.GREEN);
    }
    
   {
       
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/wrong.png").getFile());
    JOptionPane.showMessageDialog(this,"It's a wrong answer "+name.getText()+"\n"+"Better luck next time","",JOptionPane.INFORMATION_MESSAGE,i);
    prize();}    
}        // TODO add your handling code here:
    }//GEN-LAST:event_option2panelMouseClicked

    private void option4panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option4panelMouseClicked
option1panel.setVisible(true);
option2panel.setVisible(true);
option3panel.setVisible(true);
option4panel.setVisible(true);
if(correctanswer.getText().contains("d")  ||  correctanswer.getText().contains("D"))
{
     option4panel.setBackground(Color.GREEN);
     optionselected.setText("y");
    
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/check.png").getFile());
    JOptionPane.showMessageDialog(this,""+name.getText()+" ,it's the correct answer !","",JOptionPane.INFORMATION_MESSAGE,i);
     
   
    try {
        gque();
        color_reset();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    }time(); 
    currentquestion.setText(Integer.toString(Integer.parseInt(currentquestion.getText())+1));
    question_color_change();
}
else
{
    
    if(correctanswer.getText().contains("a")||correctanswer.getText().contains("A"))
    {
        option1panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("b")||correctanswer.getText().contains("B"))
    {
        option2panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("c")||correctanswer.getText().contains("C"))
    {
        option3panel.setBackground(Color.GREEN);
    }
    
   {
       
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/wrong.png").getFile());
    JOptionPane.showMessageDialog(this,"It's a wrong answer "+name.getText()+"\n"+"Better luck next time","",JOptionPane.INFORMATION_MESSAGE,i);
    prize();}
}        // TODO add your handling code here:
    }//GEN-LAST:event_option4panelMouseClicked

    private void option3panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3panelMouseClicked
option1panel.setVisible(true);
option2panel.setVisible(true);
option3panel.setVisible(true);
option4panel.setVisible(true);
if(correctanswer.getText().contains("c")  ||  correctanswer.getText().contains("C"))
{
       option3panel.setBackground(Color.GREEN);
     optionselected.setText("y");
     
     final ImageIcon i=new ImageIcon(getClass().getResource("/pics/check.png").getFile());
    JOptionPane.showMessageDialog(this,"Correct answer "+name.getText(),"",JOptionPane.INFORMATION_MESSAGE,i);
   
 
    try {
        gque();
        color_reset();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
    }time(); 
     currentquestion.setText(Integer.toString(Integer.parseInt(currentquestion.getText())+1));
     question_color_change();
}
else
{
    
    if(correctanswer.getText().contains("a")||correctanswer.getText().contains("A"))
    {
        option1panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("b")||correctanswer.getText().contains("B"))
    {
        option2panel.setBackground(Color.GREEN);
    }
    else if(correctanswer.getText().contains("d")||correctanswer.getText().contains("D"))
    {
        option4panel.setBackground(Color.GREEN);
    }
    
   {
       
    final ImageIcon i=new ImageIcon(getClass().getResource("/pics/wrong.png").getFile());
    JOptionPane.showMessageDialog(this,"It's a wrong answer "+name.getText()+"\n"+"Better luck next time","",JOptionPane.INFORMATION_MESSAGE,i);
     prize();
    
    }
        
        
 }
// TODO add your handling code here:

    }//GEN-LAST:event_option3panelMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
quite();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(game_start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game_start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game_start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game_start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new game_start().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(game_start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel $_1;
    private javax.swing.JLabel $_10;
    private javax.swing.JLabel $_11;
    private javax.swing.JLabel $_12;
    private javax.swing.JLabel $_13;
    private javax.swing.JLabel $_14;
    private javax.swing.JLabel $_15;
    private javax.swing.JLabel $_2;
    private javax.swing.JLabel $_3;
    private javax.swing.JLabel $_4;
    private javax.swing.JLabel $_5;
    private javax.swing.JLabel $_6;
    private javax.swing.JLabel $_7;
    private javax.swing.JLabel $_8;
    private javax.swing.JLabel $_9;
    private javax.swing.JLabel correctanswer;
    private javax.swing.JLabel currentquestion;
    public javax.swing.JLabel fgender;
    public javax.swing.JLabel fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextArea jTextArea2;
    public javax.swing.JLabel name;
    private javax.swing.JLabel option1;
    private javax.swing.JPanel option1panel;
    private javax.swing.JLabel option2;
    private javax.swing.JPanel option2panel;
    private javax.swing.JLabel option3;
    private javax.swing.JPanel option3panel;
    private javax.swing.JLabel option4;
    private javax.swing.JPanel option4panel;
    private javax.swing.JLabel optionselected;
    // End of variables declaration//GEN-END:variables
public void color_reset()
{
    option3panel.setBackground(new Color(30,35,127));
    option2panel.setBackground(new Color(30,35,127));
    option1panel.setBackground(new Color(30,35,127));
    option4panel.setBackground(new Color(30,35,127));
}




/* here the code for changing the color of the questional panel on right is written which changes
color according to the currentquestion label value
*/
public void question_color_change()
{
    
    if(currentquestion.getText().equals("2"))
    {
        $_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_2.setForeground(new Color(255,184,0));
        color_reset2();
    }
    else if(currentquestion.getText().equals("3"))
    {
        $_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_3.setForeground(new Color(255,184,0));
        color_reset3();
    }
    else if(currentquestion.getText().equals("4"))
    {
        $_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_4.setForeground(new Color(255,184,0));
        color_reset4();
    }
    else if(currentquestion.getText().equals("5"))
    {
        final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money.png").getFile());
        JOptionPane.showMessageDialog(this,"Congo "+name.getText()+"\n"+"You will take minimum of"+"\n"+"40,000Rs at home","",JOptionPane.INFORMATION_MESSAGE,img);
        $_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_5.setForeground(new Color(255,184,0));
        color_reset5();
    }
    else if(currentquestion.getText().equals("6"))
    {
        $_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_6.setForeground(new Color(255,184,0));
        color_reset6();
    }
    else if(currentquestion.getText().equals("7"))
    {
        $_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_7.setForeground(new Color(255,184,0));
        color_reset7();
    }
    else if(currentquestion.getText().equals("8"))
    {
        $_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_8.setForeground(new Color(255,184,0));
        color_reset8();
    }
    else if(currentquestion.getText().equals("9"))
    {
        final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money1.png").getFile());
        JOptionPane.showMessageDialog(this,"Congo "+name.getText()+"\n"+"You will take minimum of"+"\n"+"6,40,000Rs at home","",JOptionPane.INFORMATION_MESSAGE,img);
        $_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_9.setForeground(new Color(255,184,0));
        color_reset9();
    }
    else if(currentquestion.getText().equals("10"))
    {
        $_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_10.setForeground(new Color(255,184,0));
        color_reset10();
    }
    else if(currentquestion.getText().equals("11"))
    {
        $_11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_11.setForeground(new Color(255,184,0));
        color_reset11();
    }
    else if(currentquestion.getText().equals("12"))
    {
        $_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_12.setForeground(new Color(255,184,0));
        color_reset12();
    }
    else if(currentquestion.getText().equals("13"))
    {
        final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money3.png").getFile());
        JOptionPane.showMessageDialog(this,"Crorepati !!! \n"+"1crore app ke naam "+name.getText(),"",JOptionPane.INFORMATION_MESSAGE,img);
        $_13.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_13.setForeground(new Color(255,184,0));
        color_reset13();
    }
    else if(currentquestion.getText().equals("14"))
    {
        final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money3.png").getFile());
        JOptionPane.showMessageDialog(this,"3crore app ke naam "+name.getText(),"",JOptionPane.INFORMATION_MESSAGE,img);
        $_14.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_14.setForeground(new Color(255,184,0));
        color_reset14();
    }
    else if(currentquestion.getText().equals("15"))
    {
         final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money3.png").getFile());
        JOptionPane.showMessageDialog(this,name.getText()+", 5crore !!!!"+"\n"+"ek dam laa javab uttar !!","",JOptionPane.INFORMATION_MESSAGE,img);
        $_15.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
        $_15.setForeground(new Color(255,184,0));
        color_reset15();
    }
     else if(currentquestion.getText().equals("16"))
    {
         final ImageIcon img=new ImageIcon(getClass().getResource("/pics/money3.png").getFile());
        JOptionPane.showMessageDialog(this,name.getText()+", 7crore !!!  \n"+"no words to say \n"+"Salute "+name.getText()+" salute !!!","",JOptionPane.INFORMATION_MESSAGE,img);
       cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText("   70000000");
        c.jLabel6.setText("Seven Crore............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
}




// reseting color section !! i know its preety clunky algorithm but it works man !! lol

public void color_reset2()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
}

public void color_reset3()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
}

public void color_reset4()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
}

public void color_reset5()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
}

public void color_reset6()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
}

public void color_reset7()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
}

public void color_reset8()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
}

public void color_reset9()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
}

public void color_reset10()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
}

public void color_reset11()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
    $_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_10.setForeground(Color.WHITE);
}

public void color_reset12()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
    $_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_10.setForeground(Color.WHITE);
    $_11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_11.setForeground(Color.WHITE);
}

public void color_reset13()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
    $_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_10.setForeground(Color.WHITE);
    $_11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_11.setForeground(Color.WHITE);
    $_12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_12.setForeground(Color.WHITE);
}

public void color_reset14()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
    $_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_10.setForeground(Color.WHITE);
    $_11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_11.setForeground(Color.WHITE);
    $_12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_12.setForeground(Color.WHITE);
     $_13.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_13.setForeground(Color.WHITE);
}

public void color_reset15()
{
    $_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_1.setForeground(Color.WHITE);
    $_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_2.setForeground(Color.WHITE);
    $_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_3.setForeground(Color.WHITE);
    $_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_4.setForeground(Color.WHITE);
    $_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_5.setForeground(Color.WHITE);
    $_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_6.setForeground(Color.WHITE);
    $_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_7.setForeground(Color.WHITE);
    $_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_8.setForeground(Color.WHITE);
     $_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_9.setForeground(Color.WHITE);
    $_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_10.setForeground(Color.WHITE);
    $_11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_11.setForeground(Color.WHITE);
    $_12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_12.setForeground(Color.WHITE);
     $_13.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_13.setForeground(Color.WHITE);
         $_14.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
    $_14.setForeground(Color.WHITE);
}



private void close() {
         WindowEvent winc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winc); //To change body of generated methods, choose Tools | Templates.
    }



public void prize()
{
    String totalprize=null;
        int wrong=Integer.parseInt(currentquestion.getText());
        if(wrong<=4)
        {
            totalprize="  0";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
    c.jLabel6.setText("Zero................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
        else if(wrong>4 && wrong<=8)
        {
            totalprize="  40000";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
     c.jLabel6.setText("Forty Thousand..................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
        else if(wrong>8&&wrong<=12)
        {
            totalprize="  640000";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
     c.jLabel6.setText("Six Lakh Forty Thousand...................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
        else if(wrong==13)
        {
            totalprize="10000000";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
     c.jLabel6.setText("One Crore............................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
        else if(wrong==14)
        {
            totalprize="30000000";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
     c.jLabel6.setText("Three Crore.........................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
        else if(wrong==15)
        {
            totalprize="50000000";
            cheque c=new cheque();
    c.setVisible(true);
    c.jLabel5.setText(""+totalprize);
     c.jLabel6.setText("Five Crore............................");
    c.jLabel2.setText(this.name.getText());
    close();
        }
}




public void quite()
{
    int que=Integer.parseInt(currentquestion.getText());
    int quit_que=que-1;
    String totalprize=null;
    if(que>=1&&que<=4)
    {
        JOptionPane.showMessageDialog(this,"You cant quite at this stage !","NO QUITE, BE A BRAVE PERSON",JOptionPane.ERROR_MESSAGE);
    }
    else if(quit_que==4)
    {
        totalprize="  40000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Forty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==5)
    {
        totalprize="  80000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Eihty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==6)
    {
        totalprize="  160000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("One Lakh Sixty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==7)
    {
        totalprize="  320000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Three Lakh Twenty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==8)
    {
        totalprize="  640000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Six Lakh Forty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==9)
    {
        totalprize="  1250000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Twelve Lakh Fifty Thousand............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==10)
    {
        totalprize="  2500000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Twenty Five Lakh............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==11)
    {
        totalprize="  5000000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Fifty Lakh............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==12)
    {
        totalprize="  10000000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("One Crore............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==13)
    {
        totalprize="  30000000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Three Crore............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==14)
    {
        totalprize="  50000000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Five Crore............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
    else if(quit_que==15)
    {
        totalprize="  70000000";
        cheque c=new cheque();
        c.setVisible(true);
        c.jLabel5.setText(""+totalprize);
        c.jLabel6.setText("Seven Crore............................");
        c.jLabel2.setText(this.name.getText());
        close();
    }
}

}

