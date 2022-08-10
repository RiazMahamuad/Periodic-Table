
import ConectionMySQL.ConnectionProvider;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Game extends javax.swing.JFrame {

    static double score = 0;
    static int count = 0;
    static int Wcount = 0;
    Timer t;
    int k = 1;
    int m = 0;

    String[] arr = {
        "Hydrogen", "Helium ", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium",
        "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon",
        "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc",
        "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium",
        "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium",
        "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Cesium", "Barium", "Lanthanum",
        "Cerium", "Praseodymium", "Neodymium", "Promethium", "Samarium", "Europium",
        "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium",
        "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium",
        "Astatine", "Radon", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium",
        "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Ensteinium", "Fermium", "Mendelevium", "Nobelium",
        "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium",
        "Copernicium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson"};

    Random r = new Random();
    int randomString = r.nextInt(arr.length);
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
       

    public Game() {
        
        initComponents();
       

        conn = ConnectionProvider.getCon();
        //MaxScore Show
        try {

            String sql = "select max(ScoreList) from maxscore";
            // TableUpdateLive();
            pst = conn.prepareStatement(sql);
            // TableUpdateLive();
            rs = pst.executeQuery();
            // TableUpdateLive();
            if (rs.next()) {

                String max = rs.getString("max(ScoreList)");
                MaxScore.setText(max);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
          
        //show Table data
        DefaultTableModel mode = (DefaultTableModel) jTable1.getModel();
  
        try {
            TableUpdateLive();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from maxscore");

            while (rs.next()) {

                mode.addRow(new Object[]{rs.getString(1)});
     
      
                // B=new JButton("Open");
              
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
        TableUpdateLive();

        setLocationRelativeTo(this);

        randomString = r.nextInt(arr.length); //random string
        jLabel1.setText(arr[randomString]);//random string

        AllEliment.setVisible(false);
        All.setVisible(false);
        Write.setVisible(false);
        WriteValue.setVisible(false);
        WrongValue.setVisible(false);
        Wrong.setVisible(false);
        score1.setVisible(false);
        ScoreValue.setVisible(false);
        DesablePT.setVisible(false);
         disableAllEliment();
        TimeLabel.setVisible(false);
        Miniut.setVisible(false);
        ColonLabel.setVisible(false);
        Time.setVisible(false);
        Secondlebel.setVisible(false);
        jLabel1.setVisible(false);
        
         EndGame.setVisible(false);
        HideScore.setVisible(false);
        ShowScore.setVisible(false);
        
        PlayAgain.setVisible(false);
        jLabel6.setVisible(false);
        MaxScore.setVisible(false);
        jScrollPane2.setVisible(false);
        jTable1.setVisible(false);
        Delete.setVisible(false);

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Time.setText(String.valueOf(k));
                k++;
                if (k == 60) {
                    m++;
                    Miniut.setText(String.valueOf(m));
                    k = 1;

                }
            }
        });

        //t.start();

    }
    //table is update live

    private void TableUpdateLive() {

        String sql = "select *from maxscore";
        try {

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
      
        
    }
    
        
   private void disableAllEliment()
   {
        //disableall buttun
        H.setVisible(false);
        He.setVisible(false);
        Li.setVisible(false);
        Be.setVisible(false);
        B.setVisible(false);
        C.setVisible(false);
        N.setVisible(false);
        O.setVisible(false);
        F.setVisible(false);
        Ne.setVisible(false);
        Na.setVisible(false);
        Mg.setVisible(false);
        Al.setVisible(false);
        Si.setVisible(false);
        P.setVisible(false);
        S.setVisible(false);
        Cl.setVisible(false);
        Ar.setVisible(false);
        K.setVisible(false);
        Ca.setVisible(false);
        Sc.setVisible(false);
        Ti.setVisible(false);
        V.setVisible(false);
        Cr.setVisible(false);
        Mn.setVisible(false);
        Fe.setVisible(false);
        Co.setVisible(false);
        Ni.setVisible(false);
        Cu.setVisible(false);
        Zn.setVisible(false);
        Ga.setVisible(false);
        Ge.setVisible(false);
        As.setVisible(false);
        Se.setVisible(false);
        Br.setVisible(false);
        Kr.setVisible(false);
        Rb.setVisible(false);
        Sr.setVisible(false);
        Y.setVisible(false);
        Zr.setVisible(false);
        Nb.setVisible(false);
        Mo.setVisible(false);
        Tc.setVisible(false);
        Ru.setVisible(false);
        Rh.setVisible(false);
        Pd.setVisible(false);
        Ag.setVisible(false);
        Cd.setVisible(false);
        In.setVisible(false);
        Sn.setVisible(false);
        Sb.setVisible(false);
        Te.setVisible(false);
        I.setVisible(false);
        Xe.setVisible(false);
        Cs.setVisible(false);
        Ba.setVisible(false);
        Hf.setVisible(false);
        Ta.setVisible(false);
        W.setVisible(false);
        Re.setVisible(false);
        Os.setVisible(false);
        Ir.setVisible(false);
        Pt.setVisible(false);
        Au.setVisible(false);
        Hg.setVisible(false);
        Tl.setVisible(false);
        Pb.setVisible(false);
        Bi.setVisible(false);
        Po.setVisible(false);
        At.setVisible(false);
        Rn.setVisible(false);
        Fr.setVisible(false);
        Ra.setVisible(false);
        Rf.setVisible(false);
        Db.setVisible(false);
        Sg.setVisible(false);
        Bh.setVisible(false);
        Hs.setVisible(false);
        Mt.setVisible(false);
        Ds.setVisible(false);
        Rg.setVisible(false);
        Cn.setVisible(false);
        Nh.setVisible(false);
        FI.setVisible(false);
        Mc.setVisible(false);
        Lv.setVisible(false);
        Ts.setVisible(false);
        Og.setVisible(false);
        La.setVisible(false);
        Ce.setVisible(false);
        Pr.setVisible(false);
        Nd.setVisible(false);
        Pm.setVisible(false);
        Sm.setVisible(false);
        Eu.setVisible(false);
        Gd.setVisible(false);
        Tb.setVisible(false);
        Dy.setVisible(false);
        Ho.setVisible(false);
        Er.setVisible(false);
        Tm.setVisible(false);
        Yb.setVisible(false);
        Lu.setVisible(false);
        Ac.setVisible(false);
        Th.setVisible(false);
        Pa.setVisible(false);
        U.setVisible(false);
        Np.setVisible(false);
        Pu.setVisible(false);
        Am.setVisible(false);
        Bk.setVisible(false);
        Cf.setVisible(false);
        Es.setVisible(false);
        Fm.setVisible(false);
        Md.setVisible(false);
        No.setVisible(false);
        Lr.setVisible(false);
   }
   private void EnableAllEliment()
   {
         //Enable allButton
        H.setVisible(true);
        He.setVisible(true);
        Li.setVisible(true);
        Be.setVisible(true);
        B.setVisible(true);
        C.setVisible(true);
        N.setVisible(true);
        O.setVisible(true);
        F.setVisible(true);
        Ne.setVisible(true);
        Na.setVisible(true);
        Mg.setVisible(true);
        Al.setVisible(true);
        Si.setVisible(true);
        P.setVisible(true);
        S.setVisible(true);
        Cl.setVisible(true);
        Ar.setVisible(true);
        K.setVisible(true);
        Ca.setVisible(true);
        Sc.setVisible(true);
        Ti.setVisible(true);
        V.setVisible(true);
        Cr.setVisible(true);
        Mn.setVisible(true);
        Fe.setVisible(true);
        Co.setVisible(true);
        Ni.setVisible(true);
        Cu.setVisible(true);
        Zn.setVisible(true);
        Ga.setVisible(true);
        Ge.setVisible(true);
        As.setVisible(true);
        Se.setVisible(true);
        Br.setVisible(true);
        Kr.setVisible(true);
        Rb.setVisible(true);
        Sr.setVisible(true);
        Y.setVisible(true);
        Zr.setVisible(true);
        Nb.setVisible(true);
        Mo.setVisible(true);
        Tc.setVisible(true);
        Ru.setVisible(true);
        Rh.setVisible(true);
        Pd.setVisible(true);
        Ag.setVisible(true);
        Cd.setVisible(true);
        In.setVisible(true);
        Sn.setVisible(true);
        Sb.setVisible(true);
        Te.setVisible(true);
        I.setVisible(true);
        Xe.setVisible(true);
        Cs.setVisible(true);
        Ba.setVisible(true);
        Hf.setVisible(true);
        Ta.setVisible(true);
        W.setVisible(true);
        Re.setVisible(true);
        Os.setVisible(true);
        Ir.setVisible(true);
        Pt.setVisible(true);
        Au.setVisible(true);
        Hg.setVisible(true);
        Tl.setVisible(true);
        Pb.setVisible(true);
        Bi.setVisible(true);
        Po.setVisible(true);
        At.setVisible(true);
        Rn.setVisible(true);
        Fr.setVisible(true);
        Ra.setVisible(true);
        Rf.setVisible(true);
        Db.setVisible(true);
        Sg.setVisible(true);
        Bh.setVisible(true);
        Hs.setVisible(true);
        Mt.setVisible(true);
        Ds.setVisible(true);
        Rg.setVisible(true);
        Cn.setVisible(true);
        Nh.setVisible(true);
        FI.setVisible(true);
        Mc.setVisible(true);
        Lv.setVisible(true);
        Ts.setVisible(true);
        Og.setVisible(true);
        La.setVisible(true);
        Ce.setVisible(true);
        Pr.setVisible(true);
        Nd.setVisible(true);
        Pm.setVisible(true);
        Sm.setVisible(true);
        Eu.setVisible(true);
        Gd.setVisible(true);
        Tb.setVisible(true);
        Dy.setVisible(true);
        Ho.setVisible(true);
        Er.setVisible(true);
        Tm.setVisible(true);
        Yb.setVisible(true);
        Lu.setVisible(true);
        Ac.setVisible(true);
        Th.setVisible(true);
        Pa.setVisible(true);
        U.setVisible(true);
        Np.setVisible(true);
        Pu.setVisible(true);
        Am.setVisible(true);
        Bk.setVisible(true);
        Cf.setVisible(true);
        Es.setVisible(true);
        Fm.setVisible(true);
        Md.setVisible(true);
        No.setVisible(true);
        Lr.setVisible(true);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        H = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        SCORE = new javax.swing.JLabel();
        EnablePT = new javax.swing.JLabel();
        He = new javax.swing.JLabel();
        Li = new javax.swing.JLabel();
        Be = new javax.swing.JLabel();
        B = new javax.swing.JLabel();
        N = new javax.swing.JLabel();
        O = new javax.swing.JLabel();
        F = new javax.swing.JLabel();
        Ne = new javax.swing.JLabel();
        Na = new javax.swing.JLabel();
        Mg = new javax.swing.JLabel();
        Al = new javax.swing.JLabel();
        Si = new javax.swing.JLabel();
        P = new javax.swing.JLabel();
        S = new javax.swing.JLabel();
        Cl = new javax.swing.JLabel();
        Ar = new javax.swing.JLabel();
        K = new javax.swing.JLabel();
        Ca = new javax.swing.JLabel();
        Sc = new javax.swing.JLabel();
        Ti = new javax.swing.JLabel();
        V = new javax.swing.JLabel();
        Cr = new javax.swing.JLabel();
        Mn = new javax.swing.JLabel();
        Fe = new javax.swing.JLabel();
        Co = new javax.swing.JLabel();
        Ni = new javax.swing.JLabel();
        Cu = new javax.swing.JLabel();
        Zn = new javax.swing.JLabel();
        Ga = new javax.swing.JLabel();
        Ge = new javax.swing.JLabel();
        As = new javax.swing.JLabel();
        Se = new javax.swing.JLabel();
        Br = new javax.swing.JLabel();
        Kr = new javax.swing.JLabel();
        Rb = new javax.swing.JLabel();
        Sr = new javax.swing.JLabel();
        Y = new javax.swing.JLabel();
        Zr = new javax.swing.JLabel();
        Nb = new javax.swing.JLabel();
        Mo = new javax.swing.JLabel();
        Tc = new javax.swing.JLabel();
        Ru = new javax.swing.JLabel();
        Rh = new javax.swing.JLabel();
        Pd = new javax.swing.JLabel();
        Ag = new javax.swing.JLabel();
        Cd = new javax.swing.JLabel();
        In = new javax.swing.JLabel();
        Sn = new javax.swing.JLabel();
        Sb = new javax.swing.JLabel();
        Te = new javax.swing.JLabel();
        I = new javax.swing.JLabel();
        Xe = new javax.swing.JLabel();
        Cs = new javax.swing.JButton();
        Ba = new javax.swing.JButton();
        Hf = new javax.swing.JButton();
        Ta = new javax.swing.JButton();
        W = new javax.swing.JButton();
        Re = new javax.swing.JButton();
        Os = new javax.swing.JButton();
        Ir = new javax.swing.JButton();
        Pt = new javax.swing.JButton();
        Au = new javax.swing.JButton();
        Hg = new javax.swing.JButton();
        Tl = new javax.swing.JButton();
        Pb = new javax.swing.JButton();
        Bi = new javax.swing.JButton();
        Po = new javax.swing.JButton();
        At = new javax.swing.JButton();
        Rn = new javax.swing.JButton();
        Fr = new javax.swing.JButton();
        Ra = new javax.swing.JButton();
        Rf = new javax.swing.JButton();
        Db = new javax.swing.JButton();
        Sg = new javax.swing.JButton();
        Bh = new javax.swing.JButton();
        Hs = new javax.swing.JButton();
        Mt = new javax.swing.JButton();
        Ds = new javax.swing.JButton();
        Rg = new javax.swing.JButton();
        Cn = new javax.swing.JButton();
        Nh = new javax.swing.JButton();
        FI = new javax.swing.JButton();
        Mc = new javax.swing.JButton();
        Lv = new javax.swing.JButton();
        Ts = new javax.swing.JButton();
        Og = new javax.swing.JButton();
        La = new javax.swing.JButton();
        Ce = new javax.swing.JButton();
        Pr = new javax.swing.JButton();
        Nd = new javax.swing.JButton();
        Pm = new javax.swing.JButton();
        Sm = new javax.swing.JButton();
        Eu = new javax.swing.JButton();
        Gd = new javax.swing.JButton();
        Tb = new javax.swing.JButton();
        Dy = new javax.swing.JButton();
        Ho = new javax.swing.JButton();
        Er = new javax.swing.JButton();
        Tm = new javax.swing.JButton();
        Yb = new javax.swing.JButton();
        Lu = new javax.swing.JButton();
        Ac = new javax.swing.JButton();
        Th = new javax.swing.JButton();
        Pa = new javax.swing.JButton();
        U = new javax.swing.JButton();
        Np = new javax.swing.JButton();
        Pu = new javax.swing.JButton();
        Am = new javax.swing.JButton();
        Cm = new javax.swing.JButton();
        Bk = new javax.swing.JButton();
        Cf = new javax.swing.JButton();
        Es = new javax.swing.JButton();
        Fm = new javax.swing.JButton();
        Md = new javax.swing.JButton();
        No = new javax.swing.JButton();
        Lr = new javax.swing.JButton();
        ShowScore = new javax.swing.JButton();
        AllEliment = new javax.swing.JLabel();
        Write = new javax.swing.JLabel();
        Wrong = new javax.swing.JLabel();
        score1 = new javax.swing.JLabel();
        All = new javax.swing.JLabel();
        WriteValue = new javax.swing.JLabel();
        WrongValue = new javax.swing.JLabel();
        ScoreValue = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        PlayAgain = new javax.swing.JButton();
        DesablePT = new javax.swing.JLabel();
        Miniut = new javax.swing.JLabel();
        ColonLabel = new javax.swing.JLabel();
        Secondlebel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        MaxScore = new javax.swing.JLabel();
        EndGame = new javax.swing.JButton();
        Delete = new javax.swing.JLabel();
        HideScore = new javax.swing.JButton();
        PlayGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(220, 140));
        setMinimumSize(new java.awt.Dimension(1480, 630));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1480, 700));

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));
        jPanel1.setMinimumSize(new java.awt.Dimension(1260, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1480, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 230, 40));

        H.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        H.setForeground(new java.awt.Color(51, 255, 51));
        H.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        H.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HMouseClicked(evt);
            }
        });
        jPanel1.add(H, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 40, 40));

        C.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        C.setForeground(new java.awt.Color(255, 255, 0));
        C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMouseClicked(evt);
            }
        });
        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 220, 40, 40));

        SCORE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SCORE.setForeground(new java.awt.Color(204, 255, 255));
        SCORE.setText("0\n");
        jPanel1.add(SCORE, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 70, 30));

        EnablePT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PredicTable.png"))); // NOI18N
        EnablePT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnablePTKeyPressed(evt);
            }
        });
        jPanel1.add(EnablePT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 1000, 620));

        He.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeMouseClicked(evt);
            }
        });
        jPanel1.add(He, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 160, 40, 40));

        Li.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LiMouseClicked(evt);
            }
        });
        jPanel1.add(Li, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 40, 40));

        Be.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeMouseClicked(evt);
            }
        });
        jPanel1.add(Be, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 50, 40));

        B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BMouseClicked(evt);
            }
        });
        jPanel1.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 40, 40));

        N.setText("jLabel4");
        N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NMouseClicked(evt);
            }
        });
        jPanel1.add(N, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 220, -1, 40));

        O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OMouseClicked(evt);
            }
        });
        jPanel1.add(O, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 40, 40));

        F.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FMouseClicked(evt);
            }
        });
        jPanel1.add(F, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 220, 50, 40));

        Ne.setText("Ne");
        Ne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NeMouseClicked(evt);
            }
        });
        jPanel1.add(Ne, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, 40, 40));

        Na.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NaMouseClicked(evt);
            }
        });
        jPanel1.add(Na, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 40, 40));

        Mg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MgMouseClicked(evt);
            }
        });
        jPanel1.add(Mg, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 40, 40));

        Al.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlMouseClicked(evt);
            }
        });
        jPanel1.add(Al, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, 40, 40));

        Si.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SiMouseClicked(evt);
            }
        });
        jPanel1.add(Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 40, 40));

        P.setText("jLabel3");
        P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PMouseClicked(evt);
            }
        });
        jPanel1.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 280, -1, 40));

        S.setText("S");
        S.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SMouseClicked(evt);
            }
        });
        jPanel1.add(S, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 40, 40));

        Cl.setText("Cl");
        Cl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClMouseClicked(evt);
            }
        });
        jPanel1.add(Cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 280, 50, 40));

        Ar.setText("Ar");
        Ar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArMouseClicked(evt);
            }
        });
        jPanel1.add(Ar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 280, 30, 40));

        K.setText("K");
        K.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KMouseClicked(evt);
            }
        });
        jPanel1.add(K, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 40, 40));

        Ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaMouseClicked(evt);
            }
        });
        jPanel1.add(Ca, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 50, 40));

        Sc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScMouseClicked(evt);
            }
        });
        jPanel1.add(Sc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 40, 40));

        Ti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TiMouseClicked(evt);
            }
        });
        jPanel1.add(Ti, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 40, 40));

        V.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VMouseClicked(evt);
            }
        });
        jPanel1.add(V, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 346, 40, 30));

        Cr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrMouseClicked(evt);
            }
        });
        jPanel1.add(Cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 40, 40));

        Mn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MnMouseClicked(evt);
            }
        });
        jPanel1.add(Mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 40, 40));

        Fe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FeMouseClicked(evt);
            }
        });
        jPanel1.add(Fe, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 40, 40));

        Co.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoMouseClicked(evt);
            }
        });
        jPanel1.add(Co, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 40, 40));

        Ni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NiMouseClicked(evt);
            }
        });
        jPanel1.add(Ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 40, 40));

        Cu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CuMouseClicked(evt);
            }
        });
        jPanel1.add(Cu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 40, 30));

        Zn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZnMouseClicked(evt);
            }
        });
        jPanel1.add(Zn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 50, 40));

        Ga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GaMouseClicked(evt);
            }
        });
        jPanel1.add(Ga, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 40, 30));

        Ge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeMouseClicked(evt);
            }
        });
        jPanel1.add(Ge, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, 40, 30));

        As.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AsMouseClicked(evt);
            }
        });
        jPanel1.add(As, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, 40, 40));

        Se.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeMouseClicked(evt);
            }
        });
        jPanel1.add(Se, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 350, 40, 30));

        Br.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrMouseClicked(evt);
            }
        });
        jPanel1.add(Br, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 340, 30, 40));

        Kr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KrMouseClicked(evt);
            }
        });
        jPanel1.add(Kr, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, 40, 30));

        Rb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RbMouseClicked(evt);
            }
        });
        jPanel1.add(Rb, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 40, 30));

        Sr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SrMouseClicked(evt);
            }
        });
        jPanel1.add(Sr, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 40, 40));

        Y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YMouseClicked(evt);
            }
        });
        jPanel1.add(Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 40, 30));

        Zr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZrMouseClicked(evt);
            }
        });
        jPanel1.add(Zr, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 40, 30));

        Nb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NbMouseClicked(evt);
            }
        });
        jPanel1.add(Nb, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 40, 40));

        Mo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoMouseClicked(evt);
            }
        });
        jPanel1.add(Mo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 40, 30));

        Tc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TcMouseClicked(evt);
            }
        });
        jPanel1.add(Tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 40, 40));

        Ru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RuMouseClicked(evt);
            }
        });
        jPanel1.add(Ru, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 40, 40));

        Rh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RhMouseClicked(evt);
            }
        });
        jPanel1.add(Rh, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 40, 40));

        Pd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PdMouseClicked(evt);
            }
        });
        jPanel1.add(Pd, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 40, 40));

        Ag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgMouseClicked(evt);
            }
        });
        jPanel1.add(Ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 40, 40));

        Cd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CdMouseClicked(evt);
            }
        });
        jPanel1.add(Cd, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 40, 40));

        In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InMouseClicked(evt);
            }
        });
        jPanel1.add(In, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 40, 40));

        Sn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SnMouseClicked(evt);
            }
        });
        jPanel1.add(Sn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 40, 40));

        Sb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SbMouseClicked(evt);
            }
        });
        jPanel1.add(Sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 40, 40));

        Te.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeMouseClicked(evt);
            }
        });
        jPanel1.add(Te, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 410, 40, 40));

        I.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IMouseClicked(evt);
            }
        });
        jPanel1.add(I, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 410, 40, 40));

        Xe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XeMouseClicked(evt);
            }
        });
        jPanel1.add(Xe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 410, 40, 40));

        Cs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CsMouseClicked(evt);
            }
        });
        jPanel1.add(Cs, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 40, 40));

        Ba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BaMouseClicked(evt);
            }
        });
        jPanel1.add(Ba, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 50, 40));

        Hf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HfMouseClicked(evt);
            }
        });
        jPanel1.add(Hf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 50, 40));

        Ta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaMouseClicked(evt);
            }
        });
        jPanel1.add(Ta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 40, 40));

        W.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WMouseClicked(evt);
            }
        });
        jPanel1.add(W, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 50, 40));

        Re.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReMouseClicked(evt);
            }
        });
        jPanel1.add(Re, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 50, 40));

        Os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OsActionPerformed(evt);
            }
        });
        Os.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OsKeyPressed(evt);
            }
        });
        jPanel1.add(Os, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 40, 40));

        Ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IrMouseClicked(evt);
            }
        });
        jPanel1.add(Ir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 50, 40));

        Pt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PtMouseClicked(evt);
            }
        });
        jPanel1.add(Pt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 40, 40));

        Au.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AuMouseClicked(evt);
            }
        });
        jPanel1.add(Au, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 40, 40));

        Hg.setText("Hg");
        Hg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HgMouseClicked(evt);
            }
        });
        jPanel1.add(Hg, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 50, 40));

        Tl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TlMouseClicked(evt);
            }
        });
        jPanel1.add(Tl, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 470, 40, 40));

        Pb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PbMouseClicked(evt);
            }
        });
        jPanel1.add(Pb, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 50, 40));

        Bi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BiMouseClicked(evt);
            }
        });
        jPanel1.add(Bi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 470, 40, 40));

        Po.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PoMouseClicked(evt);
            }
        });
        jPanel1.add(Po, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 470, 50, 40));

        At.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AtMouseClicked(evt);
            }
        });
        jPanel1.add(At, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 470, 50, 40));

        Rn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RnMouseClicked(evt);
            }
        });
        jPanel1.add(Rn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 470, 40, 40));

        Fr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FrMouseClicked(evt);
            }
        });
        jPanel1.add(Fr, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 535, 40, 40));

        Ra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaMouseClicked(evt);
            }
        });
        jPanel1.add(Ra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 50, 40));

        Rf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RfMouseClicked(evt);
            }
        });
        jPanel1.add(Rf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 50, 40));

        Db.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DbMouseClicked(evt);
            }
        });
        jPanel1.add(Db, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 40, 40));

        Sg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SgMouseClicked(evt);
            }
        });
        jPanel1.add(Sg, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 40, 40));

        Bh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BhMouseClicked(evt);
            }
        });
        Bh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhActionPerformed(evt);
            }
        });
        jPanel1.add(Bh, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 40, 40));

        Hs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HsMouseClicked(evt);
            }
        });
        jPanel1.add(Hs, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 40, 40));

        Mt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MtMouseClicked(evt);
            }
        });
        jPanel1.add(Mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 50, 40));

        Ds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DsMouseClicked(evt);
            }
        });
        jPanel1.add(Ds, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 535, 40, 40));

        Rg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RgMouseClicked(evt);
            }
        });
        jPanel1.add(Rg, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 535, 50, 40));

        Cn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CnMouseClicked(evt);
            }
        });
        jPanel1.add(Cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 40, 40));

        Nh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhMouseClicked(evt);
            }
        });
        jPanel1.add(Nh, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 535, 40, 40));

        FI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FIMouseClicked(evt);
            }
        });
        FI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FIActionPerformed(evt);
            }
        });
        jPanel1.add(FI, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, 40, 40));

        Mc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                McMouseClicked(evt);
            }
        });
        jPanel1.add(Mc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, 40, 40));

        Lv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LvMouseClicked(evt);
            }
        });
        jPanel1.add(Lv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 540, 40, 30));

        Ts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TsMouseClicked(evt);
            }
        });
        jPanel1.add(Ts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1109, 535, 40, 40));

        Og.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OgMouseClicked(evt);
            }
        });
        Og.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OgActionPerformed(evt);
            }
        });
        jPanel1.add(Og, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 530, 40, 40));

        La.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LaMouseClicked(evt);
            }
        });
        jPanel1.add(La, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 40, 50));

        Ce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CeMouseClicked(evt);
            }
        });
        jPanel1.add(Ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 40, 40));

        Pr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrMouseClicked(evt);
            }
        });
        jPanel1.add(Pr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 590, 40, 40));

        Nd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NdMouseClicked(evt);
            }
        });
        jPanel1.add(Nd, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 590, 40, 40));

        Pm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PmMouseClicked(evt);
            }
        });
        jPanel1.add(Pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 40, 40));

        Sm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SmMouseClicked(evt);
            }
        });
        jPanel1.add(Sm, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 40, 40));

        Eu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EuMouseClicked(evt);
            }
        });
        jPanel1.add(Eu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 595, 40, 30));

        Gd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GdMouseClicked(evt);
            }
        });
        jPanel1.add(Gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 595, 40, 40));

        Tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbMouseClicked(evt);
            }
        });
        jPanel1.add(Tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 590, 40, 40));

        Dy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DyMouseClicked(evt);
            }
        });
        jPanel1.add(Dy, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, 40, 40));

        Ho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoMouseClicked(evt);
            }
        });
        jPanel1.add(Ho, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 595, 30, 40));

        Er.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ErMouseClicked(evt);
            }
        });
        jPanel1.add(Er, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 595, 40, 30));

        Tm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TmMouseClicked(evt);
            }
        });
        jPanel1.add(Tm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 590, 40, 40));

        Yb.setText("Yb");
        Yb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YbMouseClicked(evt);
            }
        });
        jPanel1.add(Yb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 595, 30, 30));

        Lu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LuMouseClicked(evt);
            }
        });
        jPanel1.add(Lu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 595, 40, 30));

        Ac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcMouseClicked(evt);
            }
        });
        jPanel1.add(Ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 40, 40));

        Th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThMouseClicked(evt);
            }
        });
        jPanel1.add(Th, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 650, 40, 40));

        Pa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaMouseClicked(evt);
            }
        });
        Pa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaActionPerformed(evt);
            }
        });
        jPanel1.add(Pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 650, 40, 40));

        U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMouseClicked(evt);
            }
        });
        jPanel1.add(U, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 40, 40));

        Np.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NpMouseClicked(evt);
            }
        });
        jPanel1.add(Np, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 40, 40));

        Pu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PuMouseClicked(evt);
            }
        });
        jPanel1.add(Pu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 655, 50, 40));

        Am.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AmMouseClicked(evt);
            }
        });
        jPanel1.add(Am, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 650, 40, 40));

        Cm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmMouseClicked(evt);
            }
        });
        Cm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmActionPerformed(evt);
            }
        });
        jPanel1.add(Cm, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 655, 40, 30));

        Bk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BkMouseClicked(evt);
            }
        });
        jPanel1.add(Bk, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 40, 40));

        Cf.setText("Cf");
        Cf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CfMouseClicked(evt);
            }
        });
        jPanel1.add(Cf, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 40, 40));

        Es.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EsMouseClicked(evt);
            }
        });
        jPanel1.add(Es, new org.netbeans.lib.awtextra.AbsoluteConstraints(939, 650, 50, 40));

        Fm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FmMouseClicked(evt);
            }
        });
        jPanel1.add(Fm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, 40, 40));

        Md.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MdMouseClicked(evt);
            }
        });
        Md.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MdActionPerformed(evt);
            }
        });
        jPanel1.add(Md, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 650, 40, 40));

        No.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoMouseClicked(evt);
            }
        });
        jPanel1.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 650, 50, 40));

        Lr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LrMouseClicked(evt);
            }
        });
        jPanel1.add(Lr, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 650, 40, 40));

        ShowScore.setBackground(new java.awt.Color(32, 33, 36));
        ShowScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        ShowScore.setForeground(new java.awt.Color(0, 204, 204));
        ShowScore.setText("Show Score List");
        ShowScore.setBorder(null);
        ShowScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowScoreActionPerformed(evt);
            }
        });
        jPanel1.add(ShowScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 160, 30));

        AllEliment.setForeground(new java.awt.Color(255, 255, 255));
        AllEliment.setText("Eliment");
        jPanel1.add(AllEliment, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 260, -1, -1));

        Write.setForeground(new java.awt.Color(255, 255, 255));
        Write.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/yes.png"))); // NOI18N
        jPanel1.add(Write, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 300, 30, -1));

        Wrong.setForeground(new java.awt.Color(255, 255, 255));
        Wrong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/No.png"))); // NOI18N
        jPanel1.add(Wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 340, -1, -1));

        score1.setForeground(new java.awt.Color(255, 255, 255));
        score1.setText("Score");
        jPanel1.add(score1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 380, -1, -1));

        All.setBackground(new java.awt.Color(20, 148, 20));
        All.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        All.setForeground(new java.awt.Color(204, 255, 255));
        All.setText("118");
        jPanel1.add(All, new org.netbeans.lib.awtextra.AbsoluteConstraints(1381, 260, 30, -1));

        WriteValue.setBackground(new java.awt.Color(20, 148, 20));
        WriteValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WriteValue.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(WriteValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 300, 40, 20));

        WrongValue.setBackground(new java.awt.Color(20, 148, 20));
        WrongValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WrongValue.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(WrongValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 340, 40, 20));

        ScoreValue.setBackground(new java.awt.Color(20, 148, 20));
        ScoreValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ScoreValue.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(ScoreValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 380, 50, 20));

        TimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setText("Time");
        jPanel1.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 210, -1, -1));

        Time.setBackground(new java.awt.Color(20, 148, 20));
        Time.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(204, 255, 255));
        jPanel1.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 210, 30, 20));

        PlayAgain.setBackground(new java.awt.Color(32, 33, 36));
        PlayAgain.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        PlayAgain.setForeground(new java.awt.Color(0, 204, 204));
        PlayAgain.setText("Play Again");
        PlayAgain.setBorder(null);
        PlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayAgainActionPerformed(evt);
            }
        });
        jPanel1.add(PlayAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 420, 150, 30));

        DesablePT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DesablePT1.png"))); // NOI18N
        jPanel1.add(DesablePT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 1020, 600));

        Miniut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Miniut.setForeground(new java.awt.Color(204, 255, 255));
        Miniut.setText("0");
        jPanel1.add(Miniut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 210, 30, 20));

        ColonLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ColonLabel.setForeground(new java.awt.Color(204, 255, 255));
        ColonLabel.setText(":");
        jPanel1.add(ColonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 210, 10, 20));

        Secondlebel.setForeground(new java.awt.Color(204, 255, 255));
        Secondlebel.setText("Sec");
        jPanel1.add(Secondlebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 206, 30, 30));

        jTable1.setBackground(new java.awt.Color(32, 33, 36));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null}
            },
            new String [] {
                "ScoreList", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 150, 340));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("MaxScore :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        MaxScore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MaxScore.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(MaxScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 50, 20));

        EndGame.setBackground(new java.awt.Color(32, 33, 36));
        EndGame.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        EndGame.setForeground(new java.awt.Color(0, 204, 204));
        EndGame.setText("End Game");
        EndGame.setBorder(null);
        EndGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndGameActionPerformed(evt);
            }
        });
        jPanel1.add(EndGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 150, 160, 30));

        Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Delete.png"))); // NOI18N
        Delete.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DeleteAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 30, 30));

        HideScore.setBackground(new java.awt.Color(32, 33, 36));
        HideScore.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        HideScore.setForeground(new java.awt.Color(0, 204, 204));
        HideScore.setText("Hide Score List");
        HideScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HideScoreActionPerformed(evt);
            }
        });
        jPanel1.add(HideScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 160, 30));

        PlayGame.setBackground(new java.awt.Color(32, 33, 36));
        PlayGame.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        PlayGame.setForeground(new java.awt.Color(0, 204, 204));
        PlayGame.setText("PLAY NOW");
        PlayGame.setBorder(null);
        PlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayGameActionPerformed(evt);
            }
        });
        jPanel1.add(PlayGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 170, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMouseClicked

        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[0])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }


    }//GEN-LAST:event_HMouseClicked

    private void HAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_HAncestorAdded

    private void CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());
        // jLabel1.setText(arr[randomString]);
        if (num.equals(arr[5])) {

            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;
            //jLabel1.setText(arr[randomString]);
            randomString = r.nextInt(arr.length); //randomNumber
            // randomString=r.nextInt(arr[randomString]);
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }

    }//GEN-LAST:event_CMouseClicked

    private void HeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[1])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }

    }//GEN-LAST:event_HeMouseClicked

    private void LiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LiMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[2])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }

    }//GEN-LAST:event_LiMouseClicked

    private void BeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[3])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }

    }//GEN-LAST:event_BeMouseClicked

    private void BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[4])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }

    }//GEN-LAST:event_BMouseClicked

    private void NMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[6])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");
        }

    }//GEN-LAST:event_NMouseClicked

    private void OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[7])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_OMouseClicked

    private void FMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[8])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_FMouseClicked

    private void NeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[9])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NeMouseClicked

    private void NaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[10])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NaMouseClicked

    private void MgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[11])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_MgMouseClicked

    private void AlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[12])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AlMouseClicked

    private void SiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SiMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[13])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SiMouseClicked

    private void PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[14])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PMouseClicked

    private void SMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[15])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SMouseClicked

    private void ArMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[17])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ArMouseClicked

    private void ClMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[16])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ClMouseClicked

    private void KMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[18])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_KMouseClicked

    private void CaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaMouseClicked
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[19])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CaMouseClicked

    private void ScMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[20])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ScMouseClicked

    private void TiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TiMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[21])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TiMouseClicked

    private void VMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[22])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_VMouseClicked

    private void CrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[23])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CrMouseClicked

    private void MnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MnMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[24])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_MnMouseClicked

    private void FeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[25])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_FeMouseClicked

    private void CoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[26])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CoMouseClicked

    private void NiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NiMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[27])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NiMouseClicked

    private void CuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[28])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CuMouseClicked

    private void ZnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZnMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[29])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ZnMouseClicked

    private void GaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[30])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_GaMouseClicked

    private void GeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[31])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_GeMouseClicked

    private void AsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[32])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AsMouseClicked

    private void SeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[33])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SeMouseClicked

    private void BrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[34])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_BrMouseClicked

    private void KrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[35])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_KrMouseClicked

    private void RbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[36])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RbMouseClicked

    private void SrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[37])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SrMouseClicked

    private void YMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[38])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_YMouseClicked

    private void ZrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[39])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ZrMouseClicked

    private void NbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[40])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NbMouseClicked

    private void MoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[41])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_MoMouseClicked

    private void TcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TcMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[42])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TcMouseClicked

    private void RuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[43])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RuMouseClicked

    private void RhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RhMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[44])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RhMouseClicked

    private void PdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PdMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[45])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PdMouseClicked

    private void AgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[46])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AgMouseClicked

    private void CdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CdMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[47])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CdMouseClicked

    private void InMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[48])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_InMouseClicked

    private void SnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SnMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[49])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SnMouseClicked

    private void SbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[50])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SbMouseClicked

    private void TeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[51])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TeMouseClicked

    private void IMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[52])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_IMouseClicked

    private void XeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[53])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_XeMouseClicked

    private void BhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BhActionPerformed

    private void FIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FIActionPerformed

    private void OgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OgActionPerformed

    private void CmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmActionPerformed

    private void MdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MdActionPerformed

    private void ShowScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowScoreActionPerformed
        //  new Game().setVisible(true);
        jLabel6.setVisible(true);
        MaxScore.setVisible(true);
        jScrollPane2.setVisible(true);
        jTable1.setVisible(true);
        HideScore.setVisible(true);
        Delete.setVisible(true);
        ShowScore.setVisible(false);
        TableUpdateLive();


    }//GEN-LAST:event_ShowScoreActionPerformed

    private void PlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayAgainActionPerformed
        // TODO add your handling code here:
        EnableAllEliment();
        t.start();
        Miniut.setText("0");
        m = 0;

        // t.start();
        randomString = r.nextInt(arr.length); //randomNumber
        jLabel1.setText(arr[randomString]);

        PlayAgain.setVisible(false);
        ShowScore.setVisible(true);
        jLabel1.setVisible(true);
        EndGame.setVisible(true);

        AllEliment.setVisible(false);
        All.setVisible(false);
        Write.setVisible(false);
        WriteValue.setVisible(false);
        WrongValue.setVisible(false);
        Wrong.setVisible(false);
        score1.setVisible(false);
        ScoreValue.setVisible(false);
        /*
        //Enable allButton
        H.setVisible(true);
        He.setVisible(true);
        Li.setVisible(true);
        Be.setVisible(true);
        B.setVisible(true);
        C.setVisible(true);
        N.setVisible(true);
        O.setVisible(true);
        F.setVisible(true);
        Ne.setVisible(true);
        Na.setVisible(true);
        Mg.setVisible(true);
        Al.setVisible(true);
        Si.setVisible(true);
        P.setVisible(true);
        S.setVisible(true);
        Cl.setVisible(true);
        Ar.setVisible(true);
        K.setVisible(true);
        Ca.setVisible(true);
        Sc.setVisible(true);
        Ti.setVisible(true);
        V.setVisible(true);
        Cr.setVisible(true);
        Mn.setVisible(true);
        Fe.setVisible(true);
        Co.setVisible(true);
        Ni.setVisible(true);
        Cu.setVisible(true);
        Zn.setVisible(true);
        Ga.setVisible(true);
        Ge.setVisible(true);
        As.setVisible(true);
        Se.setVisible(true);
        Br.setVisible(true);
        Kr.setVisible(true);
        Rb.setVisible(true);
        Sr.setVisible(true);
        Y.setVisible(true);
        Zr.setVisible(true);
        Nb.setVisible(true);
        Mo.setVisible(true);
        Tc.setVisible(true);
        Ru.setVisible(true);
        Rh.setVisible(true);
        Pd.setVisible(true);
        Ag.setVisible(true);
        Cd.setVisible(true);
        In.setVisible(true);
        Sn.setVisible(true);
        Sb.setVisible(true);
        Te.setVisible(true);
        I.setVisible(true);
        Xe.setVisible(true);
        Cs.setVisible(true);
        Ba.setVisible(true);
        Hf.setVisible(true);
        Ta.setVisible(true);
        W.setVisible(true);
        Re.setVisible(true);
        Os.setVisible(true);
        Ir.setVisible(true);
        Pt.setVisible(true);
        Au.setVisible(true);
        Hg.setVisible(true);
        Tl.setVisible(true);
        Pb.setVisible(true);
        Bi.setVisible(true);
        Po.setVisible(true);
        At.setVisible(true);
        Rn.setVisible(true);
        Fr.setVisible(true);
        Ra.setVisible(true);
        Rf.setVisible(true);
        Db.setVisible(true);
        Sg.setVisible(true);
        Bh.setVisible(true);
        Hs.setVisible(true);
        Mt.setVisible(true);
        Ds.setVisible(true);
        Rg.setVisible(true);
        Cn.setVisible(true);
        Nh.setVisible(true);
        FI.setVisible(true);
        Mc.setVisible(true);
        Lv.setVisible(true);
        Ts.setVisible(true);
        Og.setVisible(true);
        La.setVisible(true);
        Ce.setVisible(true);
        Pr.setVisible(true);
        Nd.setVisible(true);
        Pm.setVisible(true);
        Sm.setVisible(true);
        Eu.setVisible(true);
        Gd.setVisible(true);
        Tb.setVisible(true);
        Dy.setVisible(true);
        Ho.setVisible(true);
        Er.setVisible(true);
        Tm.setVisible(true);
        Yb.setVisible(true);
        Lu.setVisible(true);
        Ac.setVisible(true);
        Th.setVisible(true);
        Pa.setVisible(true);
        U.setVisible(true);
        Np.setVisible(true);
        Pu.setVisible(true);
        Am.setVisible(true);
        Bk.setVisible(true);
        Cf.setVisible(true);
        Es.setVisible(true);
        Fm.setVisible(true);
        Md.setVisible(true);
        No.setVisible(true);
        Lr.setVisible(true);
        */

        TableUpdateLive();

    }//GEN-LAST:event_PlayAgainActionPerformed

    private void CsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[54])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CsMouseClicked

    private void BaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[55])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_BaMouseClicked

    private void HfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HfMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[71])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_HfMouseClicked

    private void TaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[72])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TaMouseClicked

    private void WMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[73])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_WMouseClicked

    private void ReMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[74])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ReMouseClicked

    private void OsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OsKeyPressed
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[75])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_OsKeyPressed

    private void IrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[76])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_IrMouseClicked

    private void PtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PtMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[77])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PtMouseClicked

    private void AuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[78])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AuMouseClicked

    private void HgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[79])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_HgMouseClicked

    private void TlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TlMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[80])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TlMouseClicked

    private void PbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[81])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PbMouseClicked

    private void BiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BiMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[82])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_BiMouseClicked

    private void PoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PoMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[83])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PoMouseClicked

    private void AtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[84])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AtMouseClicked

    private void RnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RnMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[85])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RnMouseClicked

    private void FrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[86])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_FrMouseClicked

    private void RaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[87])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RaMouseClicked

    private void RfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RfMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[103])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RfMouseClicked

    private void DbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[104])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_DbMouseClicked

    private void SgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[105])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SgMouseClicked

    private void BhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BhMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[106])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_BhMouseClicked

    private void HsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[107])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_HsMouseClicked

    private void MtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MtMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[108])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_MtMouseClicked

    private void DsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[109])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_DsMouseClicked

    private void RgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[110])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_RgMouseClicked

    private void CnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CnMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[111])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CnMouseClicked

    private void NhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[112])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NhMouseClicked

    private void FIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FIMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[113])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_FIMouseClicked

    private void McMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_McMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[114])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_McMouseClicked

    private void LvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LvMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[115])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_LvMouseClicked

    private void TsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[116])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TsMouseClicked

    private void OgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OgMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[117])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_OgMouseClicked

    private void LaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[56])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_LaMouseClicked

    private void CeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CeMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[57])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CeMouseClicked

    private void PrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[58])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PrMouseClicked

    private void NdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NdMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[59])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NdMouseClicked

    private void PmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[60])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PmMouseClicked

    private void SmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[61])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_SmMouseClicked

    private void EuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[62])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_EuMouseClicked

    private void GdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GdMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[63])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_GdMouseClicked

    private void TbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[64])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TbMouseClicked

    private void DyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DyMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[65])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_DyMouseClicked

    private void HoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[66])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_HoMouseClicked

    private void ErMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ErMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[67])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ErMouseClicked

    private void TmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[68])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_TmMouseClicked

    private void YbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YbMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[69])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_YbMouseClicked

    private void LuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[70])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_LuMouseClicked

    private void AcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[88])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AcMouseClicked

    private void ThMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[89])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_ThMouseClicked

    private void PaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PaActionPerformed

    private void PaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[90])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PaMouseClicked

    private void UMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[91])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_UMouseClicked

    private void NpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NpMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[92])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NpMouseClicked

    private void PuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PuMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[93])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_PuMouseClicked

    private void AmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[94])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_AmMouseClicked

    private void CmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[95])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CmMouseClicked

    private void BkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BkMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[96])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_BkMouseClicked

    private void CfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CfMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[97])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_CfMouseClicked

    private void EsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EsMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[98])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_EsMouseClicked

    private void FmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FmMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[99])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_FmMouseClicked

    private void MdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MdMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[100])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_MdMouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[101])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_NoMouseClicked

    private void LrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LrMouseClicked
        // TODO add your handling code here:
        String num = String.valueOf(jLabel1.getText());

        if (num.equals(arr[102])) {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = score + 1;
            SCORE.setText(String.valueOf(score));//lblscore
            count = count + 1;

            randomString = r.nextInt(arr.length); //randomNumber
            jLabel1.setText(arr[randomString]);

        } else {
            AllEliment.setVisible(false);
            All.setVisible(false);
            Write.setVisible(false);
            WriteValue.setVisible(false);
            WrongValue.setVisible(false);
            Wrong.setVisible(false);
            score1.setVisible(false);
            ScoreValue.setVisible(false);

            score = (score - (0.25));
            SCORE.setText(String.valueOf(score));
            Wcount = Wcount + 1;

            JOptionPane.showMessageDialog(this, " Wrong");

        }
    }//GEN-LAST:event_LrMouseClicked

    private void EndGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndGameActionPerformed
        // TODO add your handling code here:
        t.stop();

        AllEliment.setVisible(true);
        All.setVisible(true);
        Write.setVisible(true);
        WriteValue.setVisible(true);
        WrongValue.setVisible(true);
        Wrong.setVisible(true);
        score1.setVisible(true);
        ScoreValue.setVisible(true);

        WriteValue.setText(String.valueOf(count));
        WrongValue.setText(String.valueOf(Wcount));
        ScoreValue.setText(String.valueOf(score));
        SCORE.setText(" ");

        score = 0;
        count = 0;
        Wcount = 0;
        k = 1;

        /*
        try
        {
            
        
         String id=MaxScore.getText();
        
         Connection con=ConnectionProvider.getCon();
         PreparedStatement pst=con.prepareStatement("insert into maxscore values(?)");
            
          pst.setString(1, id);
           pst.executeUpdate();
        }catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null, ex);
        }
         */
        PlayAgain.setVisible(true);
        EndGame.setVisible(false);
        jLabel1.setVisible(false);
        disableAllEliment();
        /*
        //disableall buttun
        H.setVisible(false);
        He.setVisible(false);
        Li.setVisible(false);
        Be.setVisible(false);
        B.setVisible(false);
        C.setVisible(false);
        N.setVisible(false);
        O.setVisible(false);
        F.setVisible(false);
        Ne.setVisible(false);
        Na.setVisible(false);
        Mg.setVisible(false);
        Al.setVisible(false);
        Si.setVisible(false);
        P.setVisible(false);
        S.setVisible(false);
        Cl.setVisible(false);
        Ar.setVisible(false);
        K.setVisible(false);
        Ca.setVisible(false);
        Sc.setVisible(false);
        Ti.setVisible(false);
        V.setVisible(false);
        Cr.setVisible(false);
        Mn.setVisible(false);
        Fe.setVisible(false);
        Co.setVisible(false);
        Ni.setVisible(false);
        Cu.setVisible(false);
        Zn.setVisible(false);
        Ga.setVisible(false);
        Ge.setVisible(false);
        As.setVisible(false);
        Se.setVisible(false);
        Br.setVisible(false);
        Kr.setVisible(false);
        Rb.setVisible(false);
        Sr.setVisible(false);
        Y.setVisible(false);
        Zr.setVisible(false);
        Nb.setVisible(false);
        Mo.setVisible(false);
        Tc.setVisible(false);
        Ru.setVisible(false);
        Rh.setVisible(false);
        Pd.setVisible(false);
        Ag.setVisible(false);
        Cd.setVisible(false);
        In.setVisible(false);
        Sn.setVisible(false);
        Sb.setVisible(false);
        Te.setVisible(false);
        I.setVisible(false);
        Xe.setVisible(false);
        Cs.setVisible(false);
        Ba.setVisible(false);
        Hf.setVisible(false);
        Ta.setVisible(false);
        W.setVisible(false);
        Re.setVisible(false);
        Os.setVisible(false);
        Ir.setVisible(false);
        Pt.setVisible(false);
        Au.setVisible(false);
        Hg.setVisible(false);
        Tl.setVisible(false);
        Pb.setVisible(false);
        Bi.setVisible(false);
        Po.setVisible(false);
        At.setVisible(false);
        Rn.setVisible(false);
        Fr.setVisible(false);
        Ra.setVisible(false);
        Rf.setVisible(false);
        Db.setVisible(false);
        Sg.setVisible(false);
        Bh.setVisible(false);
        Hs.setVisible(false);
        Mt.setVisible(false);
        Ds.setVisible(false);
        Rg.setVisible(false);
        Cn.setVisible(false);
        Nh.setVisible(false);
        FI.setVisible(false);
        Mc.setVisible(false);
        Lv.setVisible(false);
        Ts.setVisible(false);
        Og.setVisible(false);
        La.setVisible(false);
        Ce.setVisible(false);
        Pr.setVisible(false);
        Nd.setVisible(false);
        Pm.setVisible(false);
        Sm.setVisible(false);
        Eu.setVisible(false);
        Gd.setVisible(false);
        Tb.setVisible(false);
        Dy.setVisible(false);
        Ho.setVisible(false);
        Er.setVisible(false);
        Tm.setVisible(false);
        Yb.setVisible(false);
        Lu.setVisible(false);
        Ac.setVisible(false);
        Th.setVisible(false);
        Pa.setVisible(false);
        U.setVisible(false);
        Np.setVisible(false);
        Pu.setVisible(false);
        Am.setVisible(false);
        Bk.setVisible(false);
        Cf.setVisible(false);
        Es.setVisible(false);
        Fm.setVisible(false);
        Md.setVisible(false);
        No.setVisible(false);
        Lr.setVisible(false);
        */

        //Score show
         
        
        try {
            String ScoreList = ScoreValue.getText();
           
            
           String Name=  JOptionPane.showInputDialog(null,"Eɳƚҽɾ Pʅαყҽɾ Nαɱҽ","                             𝓗𝓔𝓨 𝓣𝓗𝓔𝓘𝓡", JOptionPane.INFORMATION_MESSAGE);  //n
          
           if(Name.getBytes().length<=0)
           {
               JOptionPane.showMessageDialog(null, "Player Name Is Empty!");
              
           }
             
            Connection con = ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("insert into maxscore values(?,?)");
            // PreparedStatement pst=con.prepareStatement("select max(id) from studentms");

            pst.setString(1, ScoreList);
                   pst.setString(2, Name);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        TableUpdateLive();
        
    }//GEN-LAST:event_EndGameActionPerformed

    private void HideScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HideScoreActionPerformed
        // TODO add your handling code here:
        jLabel6.setVisible(false);
        MaxScore.setVisible(false);
        jScrollPane2.setVisible(false);
        jTable1.setVisible(false);
        Delete.setVisible(false);
        ShowScore.setVisible(true);

    }//GEN-LAST:event_HideScoreActionPerformed

    private void DeleteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DeleteAncestorAdded
        // TODO add your handling code here:


    }//GEN-LAST:event_DeleteAncestorAdded

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked

        int row = jTable1.getSelectedRow();
        String cell = jTable1.getModel().getValueAt(row, 0).toString();
        String sql = "Delete from maxscore where ScoreList=" + cell;
        try {
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete Succesfully");
            // TableUpdateLive();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        TableUpdateLive();


    }//GEN-LAST:event_DeleteMouseClicked

    private void OsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OsActionPerformed

    private void EnablePTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnablePTKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnablePTKeyPressed

    private void PlayGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayGameActionPerformed
        // TODO add your handling code here:
     // String Name=  JOptionPane.showInputDialog(this,"Enter Player Name");
   
         t.start();
         EnableAllEliment();
        EndGame.setVisible(true);
        HideScore.setVisible(true);
        ShowScore.setVisible(true);
        
        TimeLabel.setVisible(true);
        Miniut.setVisible(true);
        ColonLabel.setVisible(true);
        Time.setVisible(true);
        Secondlebel.setVisible(true);
        jLabel1.setVisible(true);
        PlayGame.setVisible(false);
    }//GEN-LAST:event_PlayGameActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTable1AncestorAdded

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ac;
    private javax.swing.JLabel Ag;
    private javax.swing.JLabel Al;
    private javax.swing.JLabel All;
    private javax.swing.JLabel AllEliment;
    private javax.swing.JButton Am;
    private javax.swing.JLabel Ar;
    private javax.swing.JLabel As;
    private javax.swing.JButton At;
    private javax.swing.JButton Au;
    private javax.swing.JLabel B;
    private javax.swing.JButton Ba;
    private javax.swing.JLabel Be;
    private javax.swing.JButton Bh;
    private javax.swing.JButton Bi;
    private javax.swing.JButton Bk;
    private javax.swing.JLabel Br;
    private javax.swing.JLabel C;
    private javax.swing.JLabel Ca;
    private javax.swing.JLabel Cd;
    private javax.swing.JButton Ce;
    private javax.swing.JButton Cf;
    private javax.swing.JLabel Cl;
    private javax.swing.JButton Cm;
    private javax.swing.JButton Cn;
    private javax.swing.JLabel Co;
    private javax.swing.JLabel ColonLabel;
    private javax.swing.JLabel Cr;
    private javax.swing.JButton Cs;
    private javax.swing.JLabel Cu;
    private javax.swing.JButton Db;
    private javax.swing.JLabel Delete;
    private javax.swing.JLabel DesablePT;
    private javax.swing.JButton Ds;
    private javax.swing.JButton Dy;
    private javax.swing.JLabel EnablePT;
    private javax.swing.JButton EndGame;
    private javax.swing.JButton Er;
    private javax.swing.JButton Es;
    private javax.swing.JButton Eu;
    private javax.swing.JLabel F;
    private javax.swing.JButton FI;
    private javax.swing.JLabel Fe;
    private javax.swing.JButton Fm;
    private javax.swing.JButton Fr;
    private javax.swing.JLabel Ga;
    private javax.swing.JButton Gd;
    private javax.swing.JLabel Ge;
    private javax.swing.JLabel H;
    private javax.swing.JLabel He;
    private javax.swing.JButton Hf;
    private javax.swing.JButton Hg;
    private javax.swing.JButton HideScore;
    private javax.swing.JButton Ho;
    private javax.swing.JButton Hs;
    private javax.swing.JLabel I;
    private javax.swing.JLabel In;
    private javax.swing.JButton Ir;
    private javax.swing.JLabel K;
    private javax.swing.JLabel Kr;
    private javax.swing.JButton La;
    private javax.swing.JLabel Li;
    private javax.swing.JButton Lr;
    private javax.swing.JButton Lu;
    private javax.swing.JButton Lv;
    private javax.swing.JLabel MaxScore;
    private javax.swing.JButton Mc;
    private javax.swing.JButton Md;
    private javax.swing.JLabel Mg;
    private javax.swing.JLabel Miniut;
    private javax.swing.JLabel Mn;
    private javax.swing.JLabel Mo;
    private javax.swing.JButton Mt;
    private javax.swing.JLabel N;
    private javax.swing.JLabel Na;
    private javax.swing.JLabel Nb;
    private javax.swing.JButton Nd;
    private javax.swing.JLabel Ne;
    private javax.swing.JButton Nh;
    private javax.swing.JLabel Ni;
    private javax.swing.JButton No;
    private javax.swing.JButton Np;
    private javax.swing.JLabel O;
    private javax.swing.JButton Og;
    private javax.swing.JButton Os;
    private javax.swing.JLabel P;
    private javax.swing.JButton Pa;
    private javax.swing.JButton Pb;
    private javax.swing.JLabel Pd;
    private javax.swing.JButton PlayAgain;
    private javax.swing.JButton PlayGame;
    private javax.swing.JButton Pm;
    private javax.swing.JButton Po;
    private javax.swing.JButton Pr;
    private javax.swing.JButton Pt;
    private javax.swing.JButton Pu;
    private javax.swing.JButton Ra;
    private javax.swing.JLabel Rb;
    private javax.swing.JButton Re;
    private javax.swing.JButton Rf;
    private javax.swing.JButton Rg;
    private javax.swing.JLabel Rh;
    private javax.swing.JButton Rn;
    private javax.swing.JLabel Ru;
    private javax.swing.JLabel S;
    private javax.swing.JLabel SCORE;
    private javax.swing.JLabel Sb;
    private javax.swing.JLabel Sc;
    private javax.swing.JLabel ScoreValue;
    private javax.swing.JLabel Se;
    private javax.swing.JLabel Secondlebel;
    private javax.swing.JButton Sg;
    private javax.swing.JButton ShowScore;
    private javax.swing.JLabel Si;
    private javax.swing.JButton Sm;
    private javax.swing.JLabel Sn;
    private javax.swing.JLabel Sr;
    private javax.swing.JButton Ta;
    private javax.swing.JButton Tb;
    private javax.swing.JLabel Tc;
    private javax.swing.JLabel Te;
    private javax.swing.JButton Th;
    private javax.swing.JLabel Ti;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton Tl;
    private javax.swing.JButton Tm;
    private javax.swing.JButton Ts;
    private javax.swing.JButton U;
    private javax.swing.JLabel V;
    private javax.swing.JButton W;
    private javax.swing.JLabel Write;
    private javax.swing.JLabel WriteValue;
    private javax.swing.JLabel Wrong;
    private javax.swing.JLabel WrongValue;
    private javax.swing.JLabel Xe;
    private javax.swing.JLabel Y;
    private javax.swing.JButton Yb;
    private javax.swing.JLabel Zn;
    private javax.swing.JLabel Zr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel score1;
    // End of variables declaration//GEN-END:variables

}
