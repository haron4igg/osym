import java.applet.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.image.*;

public class one_img extends Applet{

    TextField tbend, step;
    Label time, Texttime1, Texttime2, Textstep, Textstart, Textvision;
    Choice metod;
    List vision;
    Button Butt1;
    Checkbox mostfile;

    CheckboxGroup grup;
    Checkbox poten, scor, nonull;

    int mp = 13; int point = 1;
    int startpoint = 1, mymetod = 0, myvision = 0, first = 0, myfile = 0;

    double PI = 3.14159265358979323;
    double alpha = 45*PI/180;
    double mk3 = Math.sqrt(3);

    double c[]= new double[mp];
    double b[][]= new double[mp][mp-1];

    int ta = 0, tb = 5;
    double h = 1e-4;
    long Nh = 0, tstart, tend;
    int SLOW_CONST = 100;

    double av[] = new double[48];
    double avstart[] = new double[48];

    int Nmas = 2500000;
    int gol = 0; //uconst = 100;

    double delta100[] = new double[36];
    int Nkslow[][] = new int[36][SLOW_CONST];
    double Pk[][] = new double[36][SLOW_CONST];

    //double umas[][] = new double[48][2*uconst+1];
    double negol[][] = new double[9][Nmas];
    double maxMin[][] = new double[52][2];
    double MaxMin[][] = new double[48][24];

    int img3D_u1All[][] = new int[420][420];
    int img3D_u2All[][] = new int[420][420];
    int img3D_u3All[][] = new int[420][420];
    int img3D_u4All[][] = new int[420][420];
    int img3D_u5All[][] = new int[420][420];
    int img3D_u6All[][] = new int[420][420];
    int img3D_u7All[][] = new int[420][420];
    int img3D_u8All[][] = new int[420][420];
    int img3D_uAll1_123[][] = new int[420][420];
    int img3D_uAll2_123[][] = new int[420][420];
    int img3D_uAll3_123[][] = new int[420][420];
    int img3D_uAll1_147[][] = new int[420][420];
    int img3D_uAll2_147[][] = new int[420][420];
    int img3D_uAll3_147[][] = new int[420][420];
    int img3D_uAll1_156[][] = new int[420][420];
    int img3D_uAll2_156[][] = new int[420][420];
    int img3D_uAll3_156[][] = new int[420][420];
    int img3D_uAll1_246[][] = new int[420][420];
    int img3D_uAll2_246[][] = new int[420][420];
    int img3D_uAll3_246[][] = new int[420][420];
    int img3D_uAll1_257[][] = new int[420][420];
    int img3D_uAll2_257[][] = new int[420][420];
    int img3D_uAll3_257[][] = new int[420][420];
    int img3D_uAll1_3458[][] = new int[420][420];
    int img3D_uAll2_3458[][] = new int[420][420];
    int img3D_uAll3_3458[][] = new int[420][420];
    int img3D_uAll1_3678[][] = new int[420][420];
    int img3D_uAll2_3678[][] = new int[420][420];
    int img3D_uAll3_3678[][] = new int[420][420];
    int img3D_mod123[][] = new int[420][420];
    int img3D_mod147[][] = new int[420][420];
    int img3D_mod156[][] = new int[420][420];
    int img3D_mod246[][] = new int[420][420];
    int img3D_mod257[][] = new int[420][420];
    int img3D_mod3458[][] = new int[420][420];
    int img3D_mod3678[][] = new int[420][420];

    byte img_u11[][] = new byte[602][402];
    byte img_u12[][] = new byte[602][402];
    byte img_u13[][] = new byte[602][402];
    byte img_u21[][] = new byte[602][402];
    byte img_u22[][] = new byte[602][402];
    byte img_u23[][] = new byte[602][402];
    byte img_u31[][] = new byte[602][402];
    byte img_u32[][] = new byte[602][402];
    byte img_u33[][] = new byte[602][402];
    byte img_u41[][] = new byte[602][402];
    byte img_u42[][] = new byte[602][402];
    byte img_u43[][] = new byte[602][402];
    byte img_u51[][] = new byte[602][402];
    byte img_u52[][] = new byte[602][402];
    byte img_u53[][] = new byte[602][402];
    byte img_u61[][] = new byte[602][402];
    byte img_u62[][] = new byte[602][402];
    byte img_u63[][] = new byte[602][402];
    byte img_u71[][] = new byte[602][402];
    byte img_u72[][] = new byte[602][402];
    byte img_u73[][] = new byte[602][402];
    byte img_u81[][] = new byte[602][402];
    byte img_u82[][] = new byte[602][402];
    byte img_u83[][] = new byte[602][402];

    byte img_uc11[][] = new byte[602][402];
    byte img_uc12[][] = new byte[602][402];
    byte img_uc13[][] = new byte[602][402];
    byte img_uc21[][] = new byte[602][402];
    byte img_uc22[][] = new byte[602][402];
    byte img_uc23[][] = new byte[602][402];
    byte img_uc31[][] = new byte[602][402];
    byte img_uc32[][] = new byte[602][402];
    byte img_uc33[][] = new byte[602][402];
    byte img_uc41[][] = new byte[602][402];
    byte img_uc42[][] = new byte[602][402];
    byte img_uc43[][] = new byte[602][402];
    byte img_uc51[][] = new byte[602][402];
    byte img_uc52[][] = new byte[602][402];
    byte img_uc53[][] = new byte[602][402];
    byte img_uc61[][] = new byte[602][402];
    byte img_uc62[][] = new byte[602][402];
    byte img_uc63[][] = new byte[602][402];
    byte img_uc71[][] = new byte[602][402];
    byte img_uc72[][] = new byte[602][402];
    byte img_uc73[][] = new byte[602][402];
    byte img_uc81[][] = new byte[602][402];
    byte img_uc82[][] = new byte[602][402];
    byte img_uc83[][] = new byte[602][402];

    byte img_uf11[][] = new byte[602][402];
    byte img_uf12[][] = new byte[602][402];
    byte img_uf13[][] = new byte[602][402];
    byte img_uf21[][] = new byte[602][402];
    byte img_uf22[][] = new byte[602][402];
    byte img_uf23[][] = new byte[602][402];
    byte img_uf31[][] = new byte[602][402];
    byte img_uf32[][] = new byte[602][402];
    byte img_uf33[][] = new byte[602][402];
    byte img_uf41[][] = new byte[602][402];
    byte img_uf42[][] = new byte[602][402];
    byte img_uf43[][] = new byte[602][402];
    byte img_uf51[][] = new byte[602][402];
    byte img_uf52[][] = new byte[602][402];
    byte img_uf53[][] = new byte[602][402];
    byte img_uf61[][] = new byte[602][402];
    byte img_uf62[][] = new byte[602][402];
    byte img_uf63[][] = new byte[602][402];
    byte img_uf71[][] = new byte[602][402];
    byte img_uf72[][] = new byte[602][402];
    byte img_uf73[][] = new byte[602][402];
    byte img_uf81[][] = new byte[602][402];
    byte img_uf82[][] = new byte[602][402];
    byte img_uf83[][] = new byte[602][402];

    byte img_EUK[][] = new byte[602][402];
    byte img_E[][] = new byte[602][402];

    double utime[][] = new double[49][602];
    double utimezym[][] = new double[49][602];

    int wndXMin=400, wndYMin=50, wndXMax=1000, wndYMax=450;
    double uAll[][] = new double[70][4];
    int sizeX = 1050, sizeY = 530, sizePanel = (int)(wndXMin) - 100;

    int XDown, YDown, XUp, YUp;
    byte mouse[] = new byte[49];

    Font fFont0;

    String mytest = "test.txt";  File ftest = new File(mytest); DataOutputStream dostest;
    String mytestr = "test.txt";  File ftestr = new File(mytest); DataInputStream dostestr;

    String myslow = "slow.txt";  File fslow = new File(myslow); DataOutputStream dosslow;
    String myslowr = "slow.txt";  File fslowr = new File(myslow); DataInputStream dosslowr;

    String myimg = "img.txt";  File fimg = new File(mytest); DataOutputStream dosimg;
    String myimgr = "img.txt";  File fimgr = new File(mytest); DataInputStream dosimgr;

    String myzoom = "zoom.txt";  File fzoom = new File(mytest); DataOutputStream doszoom;
    String myzoomr = "zoom.txt";  File fzoomr = new File(mytest); DataInputStream doszoomr;

    public void init(){
        setSize(sizeX, sizeY);

        setBackground(Color.white);
        setLayout(null);
        fFont0 = new Font("Helvetica", Font.PLAIN, 11);
        setFont(fFont0);

        metod = new Choice();
        vision = new List(111+36, false);

        Butt1 = new Button("Õ‡˜‡Ú¸");

        time = new Label ("ÔÓÏÂÊÛÚÓÍ ‚ÂÏÂÌË ‰Îˇ Ò˜ÂÚ‡",Label.CENTER);
        Texttime1 = new Label ("t = [ 0, ");
        Texttime2 = new Label ("]");
        Textstep = new Label ("¯‡„ ‰ËÒÍÂÚËÁ‡ˆËË",Label.CENTER);
        Textstart = new Label ("Ì‡˜‡Î¸Ì˚Â ÛÒÎÓ‚Ëˇ",Label.CENTER);
        Textvision = new Label ("ÓÚÓ·‡ÁËÚ¸",Label.CENTER);

        mostfile = new Checkbox("Ò˜ËÚ‡Ú¸ Ï‡Ò¯Ú‡·Ì˚Â ÏÌÓÊËÚÂÎË ËÁ Ù‡ÈÎ‡", false);

        tbend = new TextField("10",8);
        step = new TextField("1e-4",8);

        grup = new CheckboxGroup();
        poten = new Checkbox("ÌÛÎÂ‚˚Â ÔÓÚÂÌˆË‡Î˚", grup, false);
        scor = new Checkbox("ÌÛÎÂ‚˚Â ÔÓËÁ‚Ó‰Ì˚Â ÓÚ ÔÓÚÂÌˆË‡ÎÓ‚", grup, true);
        nonull = new Checkbox("ÔÓËÁ‚ÓÎ¸Ì˚Â", grup, false);

        metod.addItem("–ÛÌ„Â- ÛÚÚ‡ 4-„Ó ÔÓˇ‰Í‡");
        metod.addItem("–ÛÌ„Â- ÛÚÚ‡-¡ÛÚ˜Â‡ 6-„Ó ÔÓˇ‰Í‡");
        metod.addItem("–ÛÌ„Â- ÛÚÚ‡-‘ÂÎ¸‰·Â„‡ 8-„Ó ÔÓˇ‰Í‡");
        metod.select(1);

        vision.addItem("‚˚˜ËÒÎËÚÂÎ¸Ì‡ˇ ÔÓ„Â¯ÌÓÒÚ¸");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U11 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U12 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U13 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U21 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U22 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U23 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U31 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U32 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U33 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U41 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U42 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U43 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U51 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U52 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U53 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U61 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U62 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U63 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U71 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U72 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U73 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U81 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U82 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÔÓÚÂÌˆË‡Î‡ U83 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U11 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U12 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U13 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U21 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U22 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U23 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U31 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U32 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U33 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U41 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U42 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U43 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U51 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U52 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U53 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U61 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U62 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U63 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U71 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U72 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U73 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U81 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U82 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Á‡‚ËÒËÏÓÒÚ¸ ÒÍÓÓÒÚË ÔÓÚÂÌˆË‡Î‡ U83 ÓÚ ‚ÂÏÂÌË");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U11");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U12");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U13");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U21");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U22");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U23");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U31");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U32");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U33");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U41");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U42");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U43");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U51");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U52");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U53");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U61");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U62");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U63");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U71");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U72");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U73");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U81");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U82");
        vision.addItem("Ù‡ÁÓ‚‡ˇ Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ ‰Îˇ ÔÓÚÂÌˆË‡Î‡ U83");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U11,U12,U13}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U21,U22,U23}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U31,U32,U33}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U41,U42,U43}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U51,U52,U53}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U61,U62,U63}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U71,U72,U73}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U81,U82,U83}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U11,U21,U31}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U12,U22,U32}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U13,U23,U33}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U11,U41,U71}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U12,U42,U72}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U13,U43,U73}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U11,U51,U61}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U12,U52,U62}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U13,U53,U63}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U21,U41,U61}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U22,U42,U62}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U23,U43,U63}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U21,U51,U71}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U22,U52,U72}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {U23,U53,U73}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv+1,U41,U51}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv+2,U42,U52}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv+3,U43,U53}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv-1,U61,U71}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv-2,U62,U72}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {Uv-3,U63,U73}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {123}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {147}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {156}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {246}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {257}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {3458}");
        vision.addItem("Ú‡ÂÍÚÓËˇ ÓÒˆËÎÎˇÚÓ‡ Ì‡ ÔÎÓÒÍÓÒÚË {3678}");
        vision.addItem("ÌÂ„ÓÎÓÌÓÏÌ˚Â Ò‚ˇÁË");
        vision.addItem("ÔÂÂÎË‚˚ ˝ÌÂ„ËË");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u4");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u5");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u6");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u7");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u8");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_123");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_123");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_123");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_147");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_147");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_147");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_156");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_156");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_156");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_246");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_246");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_246");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_257");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_257");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_257");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_v+45");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_v+45");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_v+45");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u1_v-67");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u2_v-67");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ u3_v-67");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 123");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 147");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 156");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 246");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 257");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 3458");
        vision.addItem("ÔÎÓÚÌÓÒÚ¸ 3678");
        vision.select(0);

        add(metod); add(vision);
        add(Butt1);
        add(time); add(Texttime1); add(Texttime2); add(Textstep); add(Textstart); add(Textvision);
        add(tbend); add(step);
        add(poten); add(scor); add(nonull);
        add(mostfile);

        time.reshape(10, 5, 270, 20);
        Texttime1.reshape(50, 25, 40, 20);
        tbend.reshape(100, 25, 100, 20);
        Texttime2.reshape(220, 25, 10, 20);
        Textstep.reshape(10, 45, 270, 20);
        step.reshape(100, 65, 100, 20);
        metod.reshape(10, 105, 270, 10);
        Textstart.reshape(10, 145, 270, 20);
        poten.reshape(10, 165, 270, 20);
        scor.reshape(10, 185, 270, 20);
        nonull.reshape(10, 205, 270, 20);
        Textvision.reshape(40, 255, 210, 20);
        vision.reshape(10, 275, 270, 90);
        mostfile.reshape(30, 425, 200, 20);
        Butt1.reshape(70, 460, 170, 30);

    }

    public boolean action(Event evt, Object obj)
    {
        if(evt.target instanceof Button)
        {
            if(evt.target.equals(Butt1))
            {
                tb = Integer.parseInt(tbend.getText());
                h = Double.parseDouble(step.getText());

                if(poten.getState())
                    startpoint = 0;
                else if(scor.getState())
                    startpoint = 1;
                else if(nonull.getState())
                    startpoint = 2;

                mymetod = metod.getSelectedIndex();
                myvision = vision.getSelectedIndex();

                if(mostfile.getState())
                    myfile = 1;
                else
                    myfile = 0;

                obrabotca();
            }
            else
            {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean mouseDown(Event evt, int x, int y)
    {
        if(myvision < 49)
        {
            if(evt.clickCount == 1)
            {
                XDown = x; YDown = y;
                if(mouse[myvision] == 0)
                    mouse[myvision] = 1;
                else
                    mouse[myvision] = 2;
                System.out.println("Down -> "+XDown+"   "+ YDown);
                return true;
            }
        }
        return false;
    }
    public boolean mouseUp(Event evt, int x, int y)
    {
        if(myvision < 49 && (mouse[myvision] == 1 || mouse[myvision] == 2))
        {
            XUp = x; YUp = y;
            System.out.println("Up -> "+XUp+"   "+ YUp);
            zym();
        }
        return true;
    }
    public boolean mouseDrag(Event evt, int x, int y)
    {
        if(myvision < 49 && (mouse[myvision] == 1 || mouse[myvision] == 2))
        {
            XUp = x; YUp = y;

            Graphics g = getGraphics();

            //update(g);

            g.setColor(Color.red);
            g.drawLine(XDown, YDown, XUp, YDown);
            g.drawLine(XDown, YDown, XDown, YUp);
            g.drawLine(XDown, YUp, XUp, YUp);
            g.drawLine(XUp, YDown, XUp, YUp);
        }
        return true;
    }

    public void obrabotca()
    {
        Graphics g = getGraphics();

        if(mymetod == 0)
        {
            mp = 4;
            masRK4(c,b,mp);
        }
        else if(mymetod == 1)
        {
            mp = 7;
            masRKB6(c,b,mp);
        }
        else if(mymetod == 2)
        {
            mp = 13;
            masRKF8(c,b,mp);
        }

        if(first == 0 && myfile == 0)
        {
            first = 1;
            gol = 0;

            nachysl();

            clear();
            g.setColor(Color.red);
            g.drawString("œÓ‰ÓÊ‰ËÚÂ, ÔÓÊ‡ÎÛÈÒÚ‡, Ë‰ÂÚ ÔÓËÒÍ Ï‡Ò¯Ú‡·Ì˚ı ÍÓ˝ÙÙËˆËÂÌÚÓ‚", 500, 250);

            h = Double.parseDouble(step.getText());
            Nh = (long)((tb-ta)/h)+1;
            //inu = 0;
            clear();
            draw();
            mywritln();

        }
        else if(first == 0 && myfile == 1)
        {
				/*
				first = 1;
				gol = 0;
				
				clear();
				myread();
				//myreadslow();
				mypaint();
				mywritlnslow();
				*/
				/*
				//ÂÒÎË ÌÛÊÌÓ ÔÓ˜ËÚ‡Ú¸ ËÁ Ù‡ÈÎ‡
				first = 2;
				clear();
				myread();
				myreadslow();
				myreadImg();
				draw();
				*/

            //ÂÒÎË ÌÛÊÌÓ Á‡ÔËÒ‡Ú¸ ‚ Ù‡ÈÎ
            first = 1;
            gol = 0;

            clear();
            myread();
            mypaint();
            mywritlnslow();
            mywritlnImg();
            System.out.println("Ù‡ÈÎ Á‡ÔËÒ‡Ì");

        }
        else
        {
            first = 2;

            clear();

            for(int i = 0; i < 49; i++)
                mouse[i] = 0;

            draw();
        }

        System.out.println("ÔÓ‰ÓÎÊËÚ¸");
    }
    public void mywritln()
    {
        try {
            dostest = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(mytest),128));

            dostest.writeDouble(Nh);
            dostest.writeDouble(h);

            for(int i = 0; i < 48; i++)
                dostest.writeDouble(avstart[i]);

            for(int i = 0; i < 52; i++)
                for(int j = 0; j < 2; j++)
                    dostest.writeDouble(maxMin[i][j]);

            for(int i = 0; i < 48; i++)
                for(int j = 0; j < 24; j++)
                    dostest.writeDouble(MaxMin[i][j]);

            dostest.flush();
        }
        catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: caught i/o exception: Á‡ÔËÒ¸ ÌÂ Û‰‡Î‡Ò¸");
        }
    }
    public void myread()
    {
        try {
            dostestr = new DataInputStream(new BufferedInputStream(new FileInputStream(mytestr),128));
            Nh = (long)(dostestr.readDouble());
            h = dostestr.readDouble();

            for(int i = 0; i < 48; i++)
            {
                avstart[i] = dostestr.readDouble();
                System.out.println(i + ": " + avstart[i]);
            }

            for(int i = 0; i < 52; i++)
                for(int j = 0; j < 2; j++)
                    maxMin[i][j] = dostestr.readDouble();

            for(int i = 0; i < 48; i++)
                for(int j = 0; j < 24; j++)
                    MaxMin[i][j] = dostestr.readDouble();
        }
        catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: Ù‡ÈÎ ÌÂ Ì‡È‰ÂÌ ");
        }
    }
    public void mywritlnslow()
    {
        try {
            dosslow = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myslow),128));

            for(int j = 0; j < 36; j++)
                dosslow.writeDouble(delta100[j]);

            for(int j = 0; j < 36; j++)
                for(int i = 0; i < SLOW_CONST; i++)
                    dosslow.writeInt(Nkslow[j][SLOW_CONST - 1 - i]);

            dosslow.flush();
        }
        catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: caught i/o exception: Á‡ÔËÒ¸ ÌÂ Û‰‡Î‡Ò¸");
        }
    }
    public void myreadslow()
    {
        try {
            dosslowr = new DataInputStream(new BufferedInputStream(new FileInputStream(myslowr),128));

            for(int i = 0; i < 36; i++)
                delta100[i] = dosslowr.readDouble();

            for(int i = 0; i < 36; i++)
                for(int j = 0; j < SLOW_CONST; j++)
                    Nkslow[i][SLOW_CONST - 1 - j] = dosslowr.readInt();
        }
        catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: Ù‡ÈÎ ÌÂ Ì‡È‰ÂÌ ");
        }
    }
    public void mywritlnImg()
    {
        try {
            dosimg = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myimg),128));

            imgwrite(img_EUK, dosimg);

            imgwrite(img_u11, dosimg);
            imgwrite(img_u12, dosimg);
            imgwrite(img_u13, dosimg);
            imgwrite(img_u21, dosimg);
            imgwrite(img_u22, dosimg);
            imgwrite(img_u23, dosimg);
            imgwrite(img_u31, dosimg);
            imgwrite(img_u32, dosimg);
            imgwrite(img_u33, dosimg);
            imgwrite(img_u41, dosimg);
            imgwrite(img_u42, dosimg);
            imgwrite(img_u43, dosimg);
            imgwrite(img_u51, dosimg);
            imgwrite(img_u52, dosimg);
            imgwrite(img_u53, dosimg);
            imgwrite(img_u61, dosimg);
            imgwrite(img_u62, dosimg);
            imgwrite(img_u63, dosimg);
            imgwrite(img_u71, dosimg);
            imgwrite(img_u72, dosimg);
            imgwrite(img_u73, dosimg);
            imgwrite(img_u81, dosimg);
            imgwrite(img_u82, dosimg);
            imgwrite(img_u83, dosimg);
            imgwrite(img_uc11, dosimg);
            imgwrite(img_uc12, dosimg);
            imgwrite(img_uc13, dosimg);
            imgwrite(img_uc21, dosimg);
            imgwrite(img_uc22, dosimg);
            imgwrite(img_uc23, dosimg);
            imgwrite(img_uc31, dosimg);
            imgwrite(img_uc32, dosimg);
            imgwrite(img_uc33, dosimg);
            imgwrite(img_uc41, dosimg);
            imgwrite(img_uc42, dosimg);
            imgwrite(img_uc43, dosimg);
            imgwrite(img_uc51, dosimg);
            imgwrite(img_uc52, dosimg);
            imgwrite(img_uc53, dosimg);
            imgwrite(img_uc61, dosimg);
            imgwrite(img_uc62, dosimg);
            imgwrite(img_uc63, dosimg);
            imgwrite(img_uc71, dosimg);
            imgwrite(img_uc72, dosimg);
            imgwrite(img_uc73, dosimg);
            imgwrite(img_uc81, dosimg);
            imgwrite(img_uc82, dosimg);
            imgwrite(img_uc83, dosimg);
            imgwrite(img_uf11, dosimg);
            imgwrite(img_uf12, dosimg);
            imgwrite(img_uf13, dosimg);
            imgwrite(img_uf21, dosimg);
            imgwrite(img_uf22, dosimg);
            imgwrite(img_uf23, dosimg);
            imgwrite(img_uf31, dosimg);
            imgwrite(img_uf32, dosimg);
            imgwrite(img_uf33, dosimg);
            imgwrite(img_uf41, dosimg);
            imgwrite(img_uf42, dosimg);
            imgwrite(img_uf43, dosimg);
            imgwrite(img_uf51, dosimg);
            imgwrite(img_uf52, dosimg);
            imgwrite(img_uf53, dosimg);
            imgwrite(img_uf61, dosimg);
            imgwrite(img_uf62, dosimg);
            imgwrite(img_uf63, dosimg);
            imgwrite(img_uf71, dosimg);
            imgwrite(img_uf72, dosimg);
            imgwrite(img_uf73, dosimg);
            imgwrite(img_uf81, dosimg);
            imgwrite(img_uf82, dosimg);
            imgwrite(img_uf83, dosimg);

            imgwrite3D(img3D_u1All, dosimg);
            imgwrite3D(img3D_u2All, dosimg);
            imgwrite3D(img3D_u3All, dosimg);
            imgwrite3D(img3D_u4All, dosimg);
            imgwrite3D(img3D_u5All, dosimg);
            imgwrite3D(img3D_u6All, dosimg);
            imgwrite3D(img3D_u7All, dosimg);
            imgwrite3D(img3D_u8All, dosimg);
            imgwrite3D(img3D_uAll1_123, dosimg);
            imgwrite3D(img3D_uAll2_123, dosimg);
            imgwrite3D(img3D_uAll3_123, dosimg);
            imgwrite3D(img3D_uAll1_147, dosimg);
            imgwrite3D(img3D_uAll2_147, dosimg);
            imgwrite3D(img3D_uAll3_147, dosimg);
            imgwrite3D(img3D_uAll1_156, dosimg);
            imgwrite3D(img3D_uAll2_156, dosimg);
            imgwrite3D(img3D_uAll3_156, dosimg);
            imgwrite3D(img3D_uAll1_246, dosimg);
            imgwrite3D(img3D_uAll2_246, dosimg);
            imgwrite3D(img3D_uAll3_246, dosimg);
            imgwrite3D(img3D_uAll1_257, dosimg);
            imgwrite3D(img3D_uAll2_257, dosimg);
            imgwrite3D(img3D_uAll3_257, dosimg);
            imgwrite3D(img3D_uAll1_3458, dosimg);
            imgwrite3D(img3D_uAll2_3458, dosimg);
            imgwrite3D(img3D_uAll3_3458, dosimg);
            imgwrite3D(img3D_uAll1_3678, dosimg);
            imgwrite3D(img3D_uAll2_3678, dosimg);
            imgwrite3D(img3D_uAll3_3678, dosimg);
            imgwrite3D(img3D_mod123, dosimg);
            imgwrite3D(img3D_mod147, dosimg);
            imgwrite3D(img3D_mod156, dosimg);
            imgwrite3D(img3D_mod246, dosimg);
            imgwrite3D(img3D_mod257, dosimg);
            imgwrite3D(img3D_mod3458, dosimg);
            imgwrite3D(img3D_mod3678, dosimg);

            dosimg.writeInt(gol);
            for(int j = 0; j < gol; j++)
                for(int j2 = 0; j2 < 9; j2++)
                    dosimg.writeDouble(negol[j2][j]);

            for(int j = 0; j < 49; j++)
                for(int i = 0; i < 602; i++)
                    dosimg.writeDouble(utime[j][i]);

            dosimg.flush();
        }catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: caught i/o exception: Á‡ÔËÒ¸ ÌÂ Û‰‡Î‡Ò¸");
        }
    }

    public void myreadImg()
    {
        try {
            dosimgr = new DataInputStream(new BufferedInputStream(new FileInputStream(myimgr),128));

            imgread(img_EUK, dosimgr);

            imgread(img_u11, dosimgr);
            imgread(img_u12, dosimgr);
            imgread(img_u13, dosimgr);
            imgread(img_u21, dosimgr);
            imgread(img_u22, dosimgr);
            imgread(img_u23, dosimgr);
            imgread(img_u31, dosimgr);
            imgread(img_u32, dosimgr);
            imgread(img_u33, dosimgr);
            imgread(img_u41, dosimgr);
            imgread(img_u42, dosimgr);
            imgread(img_u43, dosimgr);
            imgread(img_u51, dosimgr);
            imgread(img_u52, dosimgr);
            imgread(img_u53, dosimgr);
            imgread(img_u61, dosimgr);
            imgread(img_u62, dosimgr);
            imgread(img_u63, dosimgr);
            imgread(img_u71, dosimgr);
            imgread(img_u72, dosimgr);
            imgread(img_u73, dosimgr);
            imgread(img_u81, dosimgr);
            imgread(img_u82, dosimgr);
            imgread(img_u83, dosimgr);
            imgread(img_uc11, dosimgr);
            imgread(img_uc12, dosimgr);
            imgread(img_uc13, dosimgr);
            imgread(img_uc21, dosimgr);
            imgread(img_uc22, dosimgr);
            imgread(img_uc23, dosimgr);
            imgread(img_uc31, dosimgr);
            imgread(img_uc32, dosimgr);
            imgread(img_uc33, dosimgr);
            imgread(img_uc41, dosimgr);
            imgread(img_uc42, dosimgr);
            imgread(img_uc43, dosimgr);
            imgread(img_uc51, dosimgr);
            imgread(img_uc52, dosimgr);
            imgread(img_uc53, dosimgr);
            imgread(img_uc61, dosimgr);
            imgread(img_uc62, dosimgr);
            imgread(img_uc63, dosimgr);
            imgread(img_uc71, dosimgr);
            imgread(img_uc72, dosimgr);
            imgread(img_uc73, dosimgr);
            imgread(img_uc81, dosimgr);
            imgread(img_uc82, dosimgr);
            imgread(img_uc83, dosimgr);
            imgread(img_uf11, dosimgr);
            imgread(img_uf12, dosimgr);
            imgread(img_uf13, dosimgr);
            imgread(img_uf21, dosimgr);
            imgread(img_uf22, dosimgr);
            imgread(img_uf23, dosimgr);
            imgread(img_uf31, dosimgr);
            imgread(img_uf32, dosimgr);
            imgread(img_uf33, dosimgr);
            imgread(img_uf41, dosimgr);
            imgread(img_uf42, dosimgr);
            imgread(img_uf43, dosimgr);
            imgread(img_uf51, dosimgr);
            imgread(img_uf52, dosimgr);
            imgread(img_uf53, dosimgr);
            imgread(img_uf61, dosimgr);
            imgread(img_uf62, dosimgr);
            imgread(img_uf63, dosimgr);
            imgread(img_uf71, dosimgr);
            imgread(img_uf72, dosimgr);
            imgread(img_uf73, dosimgr);
            imgread(img_uf81, dosimgr);
            imgread(img_uf82, dosimgr);
            imgread(img_uf83, dosimgr);

            imgread3D(img3D_u1All, dosimgr);
            imgread3D(img3D_u2All, dosimgr);
            imgread3D(img3D_u3All, dosimgr);
            imgread3D(img3D_u4All, dosimgr);
            imgread3D(img3D_u5All, dosimgr);
            imgread3D(img3D_u6All, dosimgr);
            imgread3D(img3D_u7All, dosimgr);
            imgread3D(img3D_u8All, dosimgr);
            imgread3D(img3D_uAll1_123, dosimgr);
            imgread3D(img3D_uAll2_123, dosimgr);
            imgread3D(img3D_uAll3_123, dosimgr);
            imgread3D(img3D_uAll1_147, dosimgr);
            imgread3D(img3D_uAll2_147, dosimgr);
            imgread3D(img3D_uAll3_147, dosimgr);
            imgread3D(img3D_uAll1_156, dosimgr);
            imgread3D(img3D_uAll2_156, dosimgr);
            imgread3D(img3D_uAll3_156, dosimgr);
            imgread3D(img3D_uAll1_246, dosimgr);
            imgread3D(img3D_uAll2_246, dosimgr);
            imgread3D(img3D_uAll3_246, dosimgr);
            imgread3D(img3D_uAll1_257, dosimgr);
            imgread3D(img3D_uAll2_257, dosimgr);
            imgread3D(img3D_uAll3_257, dosimgr);
            imgread3D(img3D_uAll1_3458, dosimgr);
            imgread3D(img3D_uAll2_3458, dosimgr);
            imgread3D(img3D_uAll3_3458, dosimgr);
            imgread3D(img3D_uAll1_3678, dosimgr);
            imgread3D(img3D_uAll2_3678, dosimgr);
            imgread3D(img3D_uAll3_3678, dosimgr);
            imgread3D(img3D_mod123, dosimgr);
            imgread3D(img3D_mod147, dosimgr);
            imgread3D(img3D_mod156, dosimgr);
            imgread3D(img3D_mod246, dosimgr);
            imgread3D(img3D_mod257, dosimgr);
            imgread3D(img3D_mod3458, dosimgr);
            imgread3D(img3D_mod3678, dosimgr);

            gol = dosimgr.readInt();
            for(int j = 0; j < gol; j++)
                for(int j2 = 0; j2 < 9; j2++)
                    negol[j2][j] = dosimgr.readDouble();

            for(int j = 0; j < 49; j++)
                for(int i = 0; i < 602; i++)
                    utime[j][i] = dosimgr.readDouble();
        }
        catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        }
        catch (IOException ioe) {
            System.out.println("writeFile: Ù‡ÈÎ ÌÂ Ì‡È‰ÂÌ ");
        }

        macshtab3D();

        for(int i = 0; i < 49; i++)
            mouse[i] = 0;
    }

    public void imgwrite(byte [][]img, DataOutputStream dosimg)throws IOException
    {
        for(int i = 0; i < 602; i ++)
            for(int j = 0; j < 402; j++)
                dosimg.writeByte(img[i][j]);
    }

    public void imgwrite3D(int [][]img, DataOutputStream dosimg)throws IOException
    {
        for(int i = 0; i < 420; i ++)
            for(int j = 0; j < 420; j++)
                dosimg.writeInt(img[i][j]);
    }

    public void imgread(byte [][] img, DataInputStream dosimgr)throws IOException
    {
        for(int i = 0; i < 602; i++)
            for(int j = 0; j < 402; j++)
                img[i][j] = dosimgr.readByte();
    }

    public void imgread3D(int [][] img, DataInputStream dosimgr)throws IOException
    {
        for(int i = 0; i < 420; i++)
            for(int j = 0; j < 420; j++)
                img[i][j] = dosimgr.readInt();
    }

    public void clear()
    {
        Graphics g = getGraphics();

        g.setColor(Color.white);
        g.fillRect(sizePanel, 0, sizeX-sizePanel, sizeY);
    }

    public void nachysl()
    {
        double UKpot, kappa, betta;
        double[] msign = new double[9];
        int flag = 0;

        if(startpoint == 0)
        {
            for(int i = 0; i < 24; i++)
                av[i] = 0.0;

            //for(int i = 24; i < 48; i++)
            //av[i] = Math.random()*2.0 - 1;

            kiral_test(24);

            UKpot = K();
            betta = 1.0/Math.pow(UKpot, 1.0/2);

            for(int i = 24; i < 48; i++)
                av[i] *= betta;
        }
        else if(startpoint == 1)
        {
            for(int i = 24; i < 48; i++)
                av[i] = 0.0;
    		/*
    		do{
    		for(int i = 0; i < 24; i++)
    			av[i] = Math.random()*2.0 - 1;
    		
    		test_kiral(msign);
    		flag = 0;
    		for(int i = 0; i < 9; i++)
    			if(msign[i] < 0)
    			{
    				flag = 1;
    				break;
    			}
    		}while(flag == 1);
    		*/
            kiral_test(0);

            UKpot = U();
            kappa = 1.0/Math.pow(UKpot, 1.0/4);

            for(int i = 0; i < 24; i++)
                av[i] *= kappa;
        }
        else if(startpoint == 2)
        {
            int index[] = new int[8];
            int myif = 0;

            index[0] = 2; index[1] = 3; index[2] = 1;
            index[3] = 2; index[4] = 2; index[5] = 3;
            index[6] = 3; index[7] = 1;
            for(int i = 0; i < 8; i++)
                System.out.println("ÌÂËÁ‚ÂÒÚÌ˚Â " + index[i]);

            do{/*
    			int count = 0;
    			do{
    				count++;
    				for(int i = 0; i < 24; i++)
    	    			av[i] = Math.random()*2.0 - 1;
    				
    				test_kiral(msign);
    	    		flag = 0;
    	    		for(int i = 0; i < 9; i++)
    	    			if(msign[i] < 0)
    	    			{
    	    				flag = 1;
    	    				break;
    	    			}
    	    	}while(flag == 1);
    		System.out.println("rand step  " + count);	
    		*/
                for(int i = 24; i < 48; i++)
                    av[i] = Math.random()*2.0 - 1;

                kiral_test(0);

                for(int i = 0; i < 8; i++)
                    av[23 + i*3+index[i]] = 0.0;

                myif = GaussTriplet(index);
            }while(myif != 1);

            UKpot = U() + K();
            kappa = 1.0/Math.pow(UKpot, 1.0/4);
            betta = 1.0/Math.pow(UKpot, 1.0/2);

            for(int i = 0; i < 24; i++)
            {
                av[i] *= kappa;
                av[24 + i] *= betta;
            }
        }
		/*
    	//start
    	av[24]= 0.011186988499692139;
    	av[25]=0.05296305936567022;
    	av[26]=0.02196340357247722;
    	av[27]=-0.05402368070581049;
    	av[28]= 0.04419232601247416;
    	av[29]=0.025654621682055692;
    	av[30]= 0.02613193855474189;
    	av[31]= -0.001926350966718389;
    	av[32]= 0.028607476412795096;
    	av[33]=0.08715423820633467;
    	av[34]= 0.35830265352701196;
    	av[35]= -0.6655353891190653;
    	av[36]= 0.2790138645106351;
    	av[37]= 0.23767057052114887;
    	av[38]= 0.1436018278141828;
    	av[39]= -0.6551088289389261;
    	av[40]= -0.520794809641574;
    	av[41]= 0.13674524280160258;
    	av[42]= -0.06710286988765399;
    	av[43]= 0.2070001019145885;
    	av[44]= -0.28062192702915334;
    	av[45]= -0.1289568448135076;
    	av[46]= -0.5866578699359576;
    	av[47]= 0.22291094515552204;
    	*/


        for(int i = 0; i < 48; i++)
            avstart[i] = av[i];

        //‰Îˇ ÍÓÌÚÓÎˇ

        UKpot = EUK();

        System.out.println("Ì‡˜‡Î¸Ì˚Â ÛÒÎÓ‚Ëˇ ‚ ‰Îˇ Ò˜ÂÚ‡");
        for(int i = 0; i < 48; i++)
            System.out.println(i+ ": " + av[i]);

        System.out.println("˝ÌÂ„Ëˇ = " + UKpot);

        double ty; int ut = 0;
        ty = kiral(1,2,3,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  123  " + ty);
        ty = kiral(1,4,7,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  147  " + ty);
        ty = kiral(1,6,5,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  165  " + ty);
        ty = kiral(2,4,6,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  246  " + ty);
        ty = kiral(2,5,7,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  257  " + ty);
        ty = kiral(3,4,5,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  345  " + ty);
        ty = kiral(3,7,6,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  376  " + ty);
        ty = kiral(4,5,8,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  458  " + ty);
        ty = kiral(6,7,8,ut);
        System.out.println("ÓËÂÌÚ‡ˆËˇ ÚÓÈÍË  678  " + ty);

    }
    public void test_kiral(double[] msign, int vv)
    {
        msign[0] = kiral(1,2,3,vv);
        msign[1] = kiral(1,4,7,vv);
        msign[2] = kiral(1,6,5,vv);
        msign[3] = kiral(2,4,6,vv);
        msign[4] = kiral(2,5,7,vv);
        msign[5] = kiral(3,4,5,vv);
        msign[6] = kiral(3,7,6,vv);
        msign[7] = kiral(4,5,8,vv);
        msign[8] = kiral(6,7,8,vv);
    }
    public void kiral_test(int vv)
    {
        //double[] msign = new double[9];
        int flag = 0;
        int cch = 0, count = 0, ch = 0;

        do{
            ch++;
            for(int i = 9; i < 24; i++)
                av[i+vv] = Math.random()*2.0 - 1;

            for(int i = 0; i < 3; i++)
                av[i+vv] = 0.0;

            double ty1, ty2;
            ty1 = kiral(4,5,8,vv);
            ty2 = kiral(6,7,8,vv);

            if(ty1 > 0 && ty2 < 0)
            {
                double temp;
                for(int i = 15; i < 18; i++)
                {
                    temp = av[i+vv];
                    av[i+vv] = av[i+3+vv];
                    av[i+3+vv] = temp;
                }
            }
            else if(ty1 < 0 && ty2 > 0)
            {
                double temp;
                for(int i = 9; i < 12; i++)
                {
                    temp = av[i+vv];
                    av[i+vv] = av[i+3+vv];
                    av[i+3+vv] = temp;
                }
            }
            else if(ty1 < 0 && ty2 < 0)
            {
                for(int i = 21; i < 24; i++)
                    av[i+vv] *= -1;
            }

            count = 0;
            do{
                step_4(4,5,7,6,3,vv);

                cch = 0;
                do{
                    step_4(4,6,5,7,2,vv);
                    flag = step_8(2,3,4,7,6,5,1,vv);
                    cch++;
                }while(flag == 1 && cch < 10);

                count++;
            }while(flag == 1 && count < 10);

        }while(flag == 1);

        System.out.println("step  " + ch*count*cch);
    }
    public void step_4(int n1, int n2, int n3, int n4, int mout, int vv)
    {
        double[] vc1 = new double[3];
        double[] vc2 = new double[3];

        double[] p = new double[3];
        double[] q = new double[3];
        double[] r = new double[3];

        double pp, qq, ss;
        double alfa, betta, gamma;

        for(int i = 0; i < 3; i++)
        {
            vc1[i] = av[(n1-1)*3+i+vv];
            vc2[i] = av[(n2-1)*3+i+vv];
        }
        pp = vec_pr(vc1, vc2, p);

        for(int i = 0; i < 3; i++)
        {
            vc1[i] = av[(n3-1)*3+i+vv];
            vc2[i] = av[(n4-1)*3+i+vv];
        }
        qq = vec_pr(vc1, vc2, q);

        ss = vec_pr(p, q, r);
        ss = Svec(p,q)*1.0/(pp*qq);

        betta = Math.random();
        gamma = Math.random()*2.0 - 1;

        double g1, g2;
        g1 = -betta*qq*ss/pp;
        g2 = -betta*qq/(pp*ss);

        if(ss > 0)
            alfa = Math.random();
        else
            alfa = Math.random()*(g2-g1)+g1;

        for(int i = 0; i < 3; i++)
            av[i+(mout-1)*3+vv] = alfa*p[i] + betta*q[i] + gamma*r[i];
    }
    public int step_8(int n1, int n2, int n3, int n4, int n5, int n6, int mout, int vv)
    {
        double[] vc1 = new double[3];
        double[] vc2 = new double[3];

        double[] p = new double[3];
        double[] q = new double[3];
        double[] r = new double[3];

        double pp, qq, rr, ss1, ss2, ss3;
        double alfa, betta, gamma;

        for(int i = 0; i < 3; i++)
        {
            vc1[i] = av[(n1-1)*3+i+vv];
            vc2[i] = av[(n2-1)*3+i+vv];
        }
        pp = vec_pr(vc1, vc2, p);

        for(int i = 0; i < 3; i++)
        {
            vc1[i] = av[(n3-1)*3+i+vv];
            vc2[i] = av[(n4-1)*3+i+vv];
        }
        qq = vec_pr(vc1, vc2, q);

        for(int i = 0; i < 3; i++)
        {
            vc1[i] = av[(n5-1)*3+i+vv];
            vc2[i] = av[(n6-1)*3+i+vv];
        }
        rr = vec_pr(vc1, vc2, r);

        ss1 = Svec(p,q)*1.0/(pp*qq);
        ss2 = Svec(p,r)*1.0/(pp*rr);
        ss3 = Svec(q,r)*1.0/(rr*qq);

        alfa = betta = gamma = 0;
        int count = 0, flag = 0;

        if(ss1 > 0)
        {
            if(ss2 > 0)
            {
                if(ss3 > 0)
                {
                    betta = Math.random();
                    gamma = Math.random();
                    alfa = Math.random();
                }
                else
                {
                    do{
                        flag = 0;
                        betta = Math.random();
                        alfa = Math.random();

                        double g1, g2;
                        g1 = -betta*qq*ss3/rr-alfa*pp*ss2/rr;
                        g2 = -(betta+alfa*pp*ss1/qq)*qq/(rr*ss3);

                        if(g2 > g1)
                            gamma = Math.random()*(g2-g1)+g1;
                        else
                            flag = 1;
                        count++;
                    }while(flag == 1 && count < 10);
                }
            }
            else if(ss3 > 0)
            {
                do{
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random();

                    double g1, g2;
                    g1 = -gamma*rr*ss2/pp-betta*qq*ss1/pp;
                    g2 = -(betta*qq*ss3/rr+gamma)*rr/(pp*ss2);

                    if(g2 > g1)
                        alfa = Math.random()*(g2-g1)+g1;
                    else
                        flag = 1;
                    count++;
                }while(flag == 1 && count < 10);
            }
            else
            {
                do{
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random()*(1+betta*qq*ss3/rr)-betta*qq*ss3/rr;

                    double g1, g2, g3;
                    g1 = -gamma*rr*ss2/pp-betta*qq*ss1/pp;
                    g2 = (-gamma*rr*ss3/qq-betta)*qq/(pp*ss1);
                    g3 = -(gamma+betta*qq*ss3/rr)*rr/(pp*ss2);

                    if(g3 > g2 && g3 > g1)
                    {
                        if(g2 > g1)
                            alfa = Math.random()*(g3-g2)+g2;
                        else
                            alfa = Math.random()*(g3-g1)+g1;
                    }
                    else
                        flag = 1;

                    count++;
                }while(flag == 1 && count < 10);
            }
        }
        else if(ss2 > 0)
        {
            if(ss3 > 0)
            {
                do{
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random();

                    double g1, g2;
                    g1 = -betta*qq*ss1/pp-gamma*rr*ss2/pp;
                    g2 = -(betta+gamma*rr*ss3/qq)*qq/(pp*ss1);

                    if(g2 > g1)
                        alfa = Math.random()*(g2-g1)+g1;
                    else
                        flag = 1;
                    count++;
                }while(flag == 1 && count < 10);
            }
            else
            {
                do{
                    flag = 0;
                    gamma = Math.random();
                    betta = Math.random()*(1+gamma*rr*ss3/qq)-gamma*rr*ss3/qq;

                    double g1, g2, g3;
                    g1 = -betta*qq*ss1/pp-gamma*rr*ss2/pp;
                    g2 = -(betta+gamma*rr*ss3/qq)*qq/(pp*ss1);
                    g3 = (-gamma-betta*qq*ss3/rr)*rr/(pp*ss2);

                    if(g2 > g1 && g2 > g3)
                    {
                        if(g3 > g1)
                            alfa = Math.random()*(g2-g3)+g3;
                        else
                            alfa = Math.random()*(g2-g1)+g1;
                    }
                    else
                        flag = 1;
                    count++;
                }while(flag == 1 && count < 10);
            }
        }
        else if(ss3 > 0)
        {
            do{
                flag = 0;
                gamma = Math.random();
                betta = Math.random();

                double g1, g2, g3;
                g1 = -betta*qq*ss1/pp-gamma*rr*ss2/pp;
                g2 = -(betta+gamma*rr*ss3/qq)*qq/(pp*ss1);
                g3 = -(gamma+betta*qq*ss3/rr)*rr/(pp*ss2);

                if(g2 > g1 && g3 > g1)
                {
                    if(g3 > g2)
                        alfa = Math.random()*(g2-g1)+g1;
                    else
                        alfa = Math.random()*(g3-g1)+g1;
                }
                else
                    flag = 1;
                count++;
            }while(flag == 1 && count < 10);
        }
        else
        {
            do{
                flag = 0;
                betta = Math.random();
                gamma = (Math.random()*(-1.0/ss3+ss3)-ss3)*betta*qq/rr;

                double g1, g2, g3;
                g1 = -betta*qq*ss1/pp-gamma*rr*ss2/pp;
                g2 = -(betta+gamma*rr*ss3/qq)*qq/(pp*ss1);
                g3 = -(gamma+betta*qq*ss3/rr)*rr/(pp*ss2);

                if(g2 > g1 && g3 > g1)
                {
                    if(g3 > g2)
                        alfa = Math.random()*(g2-g1)+g1;
                    else
                        alfa = Math.random()*(g3-g1)+g1;
                }
                else
                    flag = 1;
                count++;
            }while(flag == 1 && count < 10);
        }

        if(flag == 0)
            for(int i = 0; i < 3; i++)
                av[i+(mout-1)*3+vv] = alfa*p[i] + betta*q[i] + gamma*r[i];

        System.out.println("step8  " + count);
        return flag;
    }
    public double vec_pr(double[] v1, double[] v2, double[] res)
    {
        res[0] = v1[1]*v2[2]-v1[2]*v2[1];
        res[1] = v1[2]*v2[0]-v1[0]*v2[2];
        res[2] = v1[0]*v2[1]-v1[1]*v2[0];

        return (double)(Math.sqrt(Svec(res,res)));
    }
    public double kiral(int v1, int v2, int v3, int vv)
    {
        v1 = (v1-1)*3;
        v2 = (v2-1)*3;
        v3 = (v3-1)*3;
        return (double)(av[v3+vv]*(av[v1+1+vv]*av[v2+2+vv]-av[v1+2+vv]*av[v2+1+vv])+av[v3+1+vv]*(av[v1+2+vv]*av[v2+vv]-av[v1+vv]*av[v2+2+vv])+av[v3+2+vv]*(av[v1+vv]*av[v2+1+vv]-av[v1+1+vv]*av[v2+vv]));
    }
    public double kiral_vec(double[] vec1, double[] vec2, double[] vec3)
    {
        return (double)(vec3[0]*(vec1[1]*vec2[2]-vec1[2]*vec2[1])+vec3[1]*(vec1[2]*vec2[0]-vec1[0]*vec2[2])+vec3[2]*(vec1[0]*vec2[1]-vec1[1]*vec2[0]));
    }

    public void negolonomnost(double t)
    {
        double SymbN[][] = {{0.0, 0.0, 0.0, -av[6], -av[7], -av[8], av[3], av[4], av[5], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[15], 0.5*av[16], 0.5*av[17], -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.0, 0.0, 0.0},
                {av[6], av[7], av[8], 0.0, 0.0, 0.0, -av[0], -av[1], -av[2], -0.5*av[15], -0.5*av[16], -0.5*av[17], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.5*av[12], 0.5*av[13], 0.5*av[14], 0.0, 0.0, 0.0},
                {-av[3], -av[4], -av[5], av[0], av[1], av[2], 0.0, 0.0, 0.0, -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.5*av[18], 0.5*av[19], 0.5*av[20], -0.5*av[15], -0.5*av[16], -0.5*av[17], 0.0, 0.0, 0.0},
                {0.5*av[18], 0.5*av[19], 0.5*av[20], 0.5*av[15], 0.5*av[16], 0.5*av[17], 0.5*av[12], 0.5*av[13], 0.5*av[14], 0.0, 0.0, 0.0, -0.5*av[6]-0.5*mk3*av[21], -0.5*av[7]-0.5*mk3*av[22], -0.5*av[8]-0.5*mk3*av[23], -0.5*av[3], -0.5*av[4], -0.5*av[5], -0.5*av[0], -0.5*av[1], -0.5*av[2], 0.5*mk3*av[12], 0.5*mk3*av[13], 0.5*mk3*av[14]},
                {-0.5*av[15], -0.5*av[16], -0.5*av[17], 0.5*av[18], 0.5*av[19], 0.5*av[20], -0.5*av[9], -0.5*av[10], -0.5*av[11], 0.5*av[6]+0.5*mk3*av[21], 0.5*av[7]+0.5*mk3*av[22], 0.5*av[8]+0.5*mk3*av[23], 0.0, 0.0, 0.0, 0.5*av[0], 0.5*av[1], 0.5*av[2], -0.5*av[3], -0.5*av[4], -0.5*av[5], -0.5*mk3*av[9], -0.5*mk3*av[10], -0.5*mk3*av[11]},
                {0.5*av[12], 0.5*av[13], 0.5*av[14], -0.5*av[9], -0.5*av[10], -0.5*av[11], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[3], 0.5*av[4], 0.5*av[5], -0.5*av[0], -0.5*av[1], -0.5*av[2], 0.0, 0.0, 0.0, 0.5*av[6]-0.5*mk3*av[21], 0.5*av[7]-0.5*mk3*av[22], 0.5*av[8]-0.5*mk3*av[23], 0.5*mk3*av[18], 0.5*mk3*av[19], 0.5*mk3*av[20]},
                {-0.5*av[9], -0.5*av[10], -0.5*av[11], -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[15], 0.5*av[16], 0.5*av[17], 0.5*av[0], 0.5*av[1], 0.5*av[2], 0.5*av[3], 0.5*av[4], 0.5*av[5], -0.5*av[6]+0.5*mk3*av[21], -0.5*av[7]+0.5*mk3*av[22], -0.5*av[8]+0.5*mk3*av[23], 0.0, 0.0, 0.0, -0.5*mk3*av[15], -0.5*mk3*av[16], -0.5*mk3*av[17]},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5*mk3*av[12], -0.5*mk3*av[13], -0.5*mk3*av[14], 0.5*mk3*av[9], 0.5*mk3*av[10], 0.5*mk3*av[11], -0.5*mk3*av[18], -0.5*mk3*av[19], -0.5*mk3*av[20], 0.5*mk3*av[15], 0.5*mk3*av[16], 0.5*mk3*av[17], 0.0, 0.0, 0.0}};

        for(int i = 0; i < 8; i++)
            negol[i][gol] = 0.0;
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 24; j++)
                negol[i][gol] += SymbN[i][j]*av[24+j];

        for(int i = 0; i < 8; i++)
            negol[i][gol] = Math.log10(Math.abs(negol[i][gol]));
        negol[8][gol] = t;
    }
    public int GaussTriplet(int[] mas)
    {
        double Symb[][] = {{0.0, 0.0, 0.0, -av[6], -av[7], -av[8], av[3], av[4], av[5], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[15], 0.5*av[16], 0.5*av[17], -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.0, 0.0, 0.0},
                {av[6], av[7], av[8], 0.0, 0.0, 0.0, -av[0], -av[1], -av[2], -0.5*av[15], -0.5*av[16], -0.5*av[17], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.5*av[12], 0.5*av[13], 0.5*av[14], 0.0, 0.0, 0.0},
                {-av[3], -av[4], -av[5], av[0], av[1], av[2], 0.0, 0.0, 0.0, -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[9], 0.5*av[10], 0.5*av[11], 0.5*av[18], 0.5*av[19], 0.5*av[20], -0.5*av[15], -0.5*av[16], -0.5*av[17], 0.0, 0.0, 0.0},
                {0.5*av[18], 0.5*av[19], 0.5*av[20], 0.5*av[15], 0.5*av[16], 0.5*av[17], 0.5*av[12], 0.5*av[13], 0.5*av[14], 0.0, 0.0, 0.0, -0.5*av[6]-0.5*mk3*av[21], -0.5*av[7]-0.5*mk3*av[22], -0.5*av[8]-0.5*mk3*av[23], -0.5*av[3], -0.5*av[4], -0.5*av[5], -0.5*av[0], -0.5*av[1], -0.5*av[2], 0.5*mk3*av[12], 0.5*mk3*av[13], 0.5*mk3*av[14]},
                {-0.5*av[15], -0.5*av[16], -0.5*av[17], 0.5*av[18], 0.5*av[19], 0.5*av[20], -0.5*av[9], -0.5*av[10], -0.5*av[11], 0.5*av[6]+0.5*mk3*av[21], 0.5*av[7]+0.5*mk3*av[22], 0.5*av[8]+0.5*mk3*av[23], 0.0, 0.0, 0.0, 0.5*av[0], 0.5*av[1], 0.5*av[2], -0.5*av[3], -0.5*av[4], -0.5*av[5], -0.5*mk3*av[9], -0.5*mk3*av[10], -0.5*mk3*av[11]},
                {0.5*av[12], 0.5*av[13], 0.5*av[14], -0.5*av[9], -0.5*av[10], -0.5*av[11], -0.5*av[18], -0.5*av[19], -0.5*av[20], 0.5*av[3], 0.5*av[4], 0.5*av[5], -0.5*av[0], -0.5*av[1], -0.5*av[2], 0.0, 0.0, 0.0, 0.5*av[6]-0.5*mk3*av[21], 0.5*av[7]-0.5*mk3*av[22], 0.5*av[8]-0.5*mk3*av[23], 0.5*mk3*av[18], 0.5*mk3*av[19], 0.5*mk3*av[20]},
                {-0.5*av[9], -0.5*av[10], -0.5*av[11], -0.5*av[12], -0.5*av[13], -0.5*av[14], 0.5*av[15], 0.5*av[16], 0.5*av[17], 0.5*av[0], 0.5*av[1], 0.5*av[2], 0.5*av[3], 0.5*av[4], 0.5*av[5], -0.5*av[6]+0.5*mk3*av[21], -0.5*av[7]+0.5*mk3*av[22], -0.5*av[8]+0.5*mk3*av[23], 0.0, 0.0, 0.0, -0.5*mk3*av[15], -0.5*mk3*av[16], -0.5*mk3*av[17]},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5*mk3*av[12], -0.5*mk3*av[13], -0.5*mk3*av[14], 0.5*mk3*av[9], 0.5*mk3*av[10], 0.5*mk3*av[11], -0.5*mk3*av[18], -0.5*mk3*av[19], -0.5*mk3*av[20], 0.5*mk3*av[15], 0.5*mk3*av[16], 0.5*mk3*av[17], 0.0, 0.0, 0.0}};

        int N = 8;
        double aGauss[][] = new double[N][N];
        double bGauss[][] = new double[N][1];
        double cGauss[][] = new double[N][N+1];
        double xGauss[][] = new double[N][1];
        double det;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                aGauss[i][j] = Symb[i][j*3 + mas[j]-1];

        for(int i = 0; i < N; i++)
            bGauss[i][0] = 0.0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < 24; j++)
                bGauss[i][0] -= Symb[i][j]*av[24+j];

        zapolnenieGauss (aGauss, bGauss, cGauss, N);
        int k = pr_hod (cGauss, N);
        det = opred(cGauss, k, N);

        if (det < 1e-15 && det > -1e-15)
            return 0;
        else
        {
            obr_hod (cGauss, xGauss, N);

            for(int i = 0; i < N; i++)
                av[23 + i*3 +mas[i]] = xGauss[i][0];
        }
        return 1;
    }
    public void zapolnenieGauss (double[][] aG, double[][] bG, double[][] cG, int N)
    {
        int i,j;

        for (i=0; i<N; i++)
            for (j=0; j<N+1; j++)
                if (j<N)
                    cG[i][j]=aG[i][j];
                else
                    cG[i][j]=bG[i][j-N];
    }
    public int pr_hod (double[][] cG, int N)
    {
        int i, j, k, p=0, l;
        double m;

        for (i=0; i<N-1; i++)
        {
            l=perectanovka (cG, i, N);
            p+=l;

            for (k=i+1; k<N; k++)
            {
                m=cG[k][i]/cG[i][i];
                for (j=i; j<N+1; j++)
                    cG[k][j]=cG[k][j]-m*cG[i][j];
            }
        }

        return p;
    }
    public int perectanovka (double[][] cG, int i, int N)
    {
        double max=Math.abs(cG[i][i]);
        int hh =i, j, k;
        double m;

        for (j=i+1; j<N; j++)
            if (max<Math.abs(cG[j][i]))
            {
                max=Math.abs(cG[j][i]);
                hh=j;
            }

        if (hh!=i)
        {
            for (k=i; k<N+1; k++)
            {
                m=cG[i][k];
                cG[i][k]=cG[hh][k];
                cG[hh][k]=m;
            }
            return 1;
        }
        else return 0;
    }
    public void obr_hod (double[][] cG, double[][] xG, int N)
    {
        int i, j, k;
        double d=0;

        for (i=N-2; i>=0; i--)
            for (j=0; j<1; j++)
            {
                xG[N-1][j]=cG[N-1][N+j]/cG[N-1][N-1];

                for (k=i+1; k<N; k++)
                    d+=cG[i][k]*xG[k][j];

                xG[i][j]=1/cG[i][i]*(cG[i][N+j]-d);
                d=0;
            }
    }

    public double opred (double[][] cG, int p, int N)
    {
        int i;
        double det=1;

        for (i=0; i<N; i++)
            det*=cG[i][i];

        det*=Math.pow((double)(-1),p);

        return det;
    }
    public void zapolnenie(double[] cc, double[] bb, double[] c, double[][] b, int mp)
    {
        for(int i = 0; i < mp; i++)
            c[i] = cc[i];

        b[0][0] = 0;
        int ij = 0;
        for(int i = 1; i < mp; i++)
            for(int j = 0; j < i; j++)
            {
                b[i][j] = bb[ij];
                ij++;
            }
    }
    public void zapolnenie2(double[] cc, double[] bb, double[] c, double[][] b, int mp)
    {
        for(int i = 0; i < mp; i++)
            c[i] = cc[i];

        b[0][0] = 0;
        int ij = 0;

        for(int j = 0; j < mp -1; j++)
            for(int i = 0; i < mp; i++)
                b[i][j] = 0;

        for(int j = 1; j < mp -1; j++)
            for(int i = 1; i < j+1; i++)
            {
                b[i][j] = bb[ij];
                ij++;
            }
    }
    public void masRK4(double[] c, double[][] b, int mp)
    {
        double cc[] = {1.0/6, 1.0/3, 1.0/3, 1.0/6};
        double bb[] = {1.0/2, 0.0, 1.0/2, 0.0, 0.0, 1.0};

        zapolnenie(cc,bb,c,b,mp);
    }
    public void masRKB6(double[] c, double[][] b, int mp)
    {
        double cc[] = {13.0/200, 0.0, 11.0/40, 11.0/40, 4.0/25, 4.0/25, 13.0/200};
        double bb[] = {1.0/2, 2.0/9, 4.0/9, 7.0/36, 2.0/9, -1.0/12, -35.0/144, -55.0/36, 35.0/48, 15.0/8, -1.0/360, -11.0/36, -1.0/8, 1.0/2, 1.0/10, -41.0/260, 22.0/13, 43.0/156, -118.0/39, 32.0/195, 80.0/39};

        zapolnenie(cc,bb,c,b,mp);
    }
    public void masRKF8(double[] c, double[][] b, int mp)
    {
        double cc[] = {41.0/840, 0.0, 0.0, 0.0, 0.0, 34.0/105, 9.0/35, 9.0/35, 9.0/280, 9.0/280, 0.0, 0.0, 41.0/840};
        double bb[] = {2.0/27, 1.0/36, 1.0/12, 1.0/24, 0.0, 1.0/8, 5.0/12, 0.0, -25.0/16, 25.0/16, 1.0/20, 0.0, 0.0, 1.0/4, 1.0/5, -25.0/108, 0.0, 0.0, 125.0/108, -65.0/27, 125.0/54, 31.0/300, 0.0, 0.0, 0.0, 61.0/225, -2.0/9, 13.0/900, 2.0, 0.0, 0.0, -53.0/6, 704.0/45, -107.0/9, 67.0/90, 3.0, -91.0/108, 0.0, 0.0, 23.0/108, -976.0/135, 311.0/54, -19.0/60, 17.0/6, -1.0/12, 2383.0/4100, 0.0, 0.0, -341.0/164, 4496.0/1025, -301.0/82, 2133.0/4100, 45.0/82, 45.0/164, 18.0/41, 3.0/205, 0.0, 0.0, 0.0, 0.0, -6.0/41, -3.0/205, -3.0/41, 3.0/41, 6.0/41, 0.0, -1777.0/4100, 0.0, 0.0, -341.0/164, 4496.0/1025, -289.0/82, 2193.0/4100, 51.0/82, 33.0/164, 12.0/41, 0.0, 1.0};

        zapolnenie(cc,bb,c,b,mp);
    }
    public double Svec (double[] v1, double[] v2)
    {
        return (double)(v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2]);
    }
    public double svec (int v1, int v2)
    {
        int r1 = (v1 - 1)*3;
        int r2 = (v2 - 1)*3;
        return (double)(av[r1]*av[r2] + av[r1+1]*av[r2+1] + av[r1+2]*av[r2+2]);
    }
    public double kvvvec (int v1, int v2)
    {
        return (double)(svec(v1,v1)*svec(v2,v2)-svec(v1,v2)*svec(v1,v2));
    }
    public double f1 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(-v1[j%3]*(Svec(v2,v2)+Svec(v3,v3)+0.25*Svec(v4,v4)+0.25*Svec(v5,v5)+0.25*Svec(v6,v6)+0.25*Svec(v7,v7))+v2[j%3]*Svec(v1,v2)+v3[j%3]*Svec(v1,v3)+v4[j%3]*(0.25*Svec(v1,v4)-0.75*Svec(v2,v5)+0.75*Svec(v3,v6)+0.25*mk3*Svec(v6,v8))+v5[j%3]*(0.75*Svec(v2,v4)+0.25*Svec(v1,v5)+0.75*Svec(v3,v7)+0.25*mk3*Svec(v7,v8))+v6[j%3]*(-0.75*Svec(v3,v4)+0.25*Svec(v1,v6)+0.75*Svec(v2,v7)+0.25*mk3*Svec(v4,v8))+v7[j%3]*(-0.75*Svec(v3,v5)-0.75*Svec(v2,v6)+0.25*Svec(v1,v7)+0.25*mk3*Svec(v5,v8))+v8[j%3]*(-0.5*mk3*Svec(v4,v6)-0.5*mk3*Svec(v5,v7)));
    }
    public double f2 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*Svec(v1,v2)-v2[j%3]*(Svec(v1,v1)+Svec(v3,v3)+0.25*Svec(v4,v4)+0.25*Svec(v5,v5)+0.25*Svec(v6,v6)+0.25*Svec(v7,v7))+v3[j%3]*Svec(v2,v3)+v4[j%3]*(0.25*Svec(v2,v4)+0.75*Svec(v1,v5)-0.75*Svec(v3,v7)-0.25*mk3*Svec(v7,v8))+v5[j%3]*(-0.75*Svec(v1,v4)+0.25*Svec(v2,v5)+0.75*Svec(v3,v6)+0.25*mk3*Svec(v6,v8))+v6[j%3]*(-0.75*Svec(v3,v5)+0.25*Svec(v2,v6)-0.75*Svec(v1,v7)+0.25*mk3*Svec(v5,v8))+v7[j%3]*(0.75*Svec(v3,v4)+0.75*Svec(v1,v6)+0.25*Svec(v2,v7)-0.25*mk3*Svec(v4,v8))+v8[j%3]*(-0.5*mk3*Svec(v5,v6)+0.5*mk3*Svec(v4,v7)));
    }
    public double f3 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*Svec(v1,v3)+v2[j%3]*Svec(v2,v3)-v3[j%3]*(Svec(v1,v1)+Svec(v2,v2)+0.25*Svec(v4,v4)+0.25*Svec(v5,v5)+0.25*Svec(v6,v6)+0.25*Svec(v7,v7))+v4[j%3]*(0.25*Svec(v3,v4)-0.75*Svec(v1,v6)+0.75*Svec(v2,v7)+0.25*mk3*Svec(v4,v8))+v5[j%3]*(0.25*Svec(v3,v5)-0.75*Svec(v2,v6)-0.75*Svec(v1,v7)+0.25*mk3*Svec(v5,v8))+v6[j%3]*(0.75*Svec(v1,v4)+0.75*Svec(v2,v5)+0.25*Svec(v3,v6)-0.25*mk3*Svec(v6,v8))+v7[j%3]*(-0.75*Svec(v2,v4)+0.75*Svec(v1,v5)+0.25*Svec(v3,v7)-0.25*mk3*Svec(v7,v8))+v8[j%3]*0.25*mk3*(-Svec(v4,v4)-Svec(v5,v5)+Svec(v6,v6)+Svec(v7,v7)));
    }
    public double f4 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*(0.25*Svec(v1,v4)-0.75*Svec(v2,v5)+0.75*Svec(v3,v6)+0.25*mk3*Svec(v6,v8))+v2[j%3]*(0.25*Svec(v2,v4)+0.75*Svec(v1,v5)-0.75*Svec(v3,v7)-0.25*mk3*Svec(v7,v8))+v3[j%3]*(0.25*Svec(v3,v4)-0.75*Svec(v1,v6)+0.75*Svec(v2,v7)+0.25*mk3*Svec(v4,v8))-v4[j%3]*(0.25*Svec(v1,v1)+0.25*Svec(v2,v2)+0.25*Svec(v3,v3)+Svec(v5,v5)+0.25*Svec(v6,v6)+0.25*Svec(v7,v7)+0.5*mk3*Svec(v3,v8)+0.75*Svec(v8,v8))+v5[j%3]*Svec(v4,v5)+v6[j%3]*(0.25*Svec(v4,v6)-0.75*Svec(v5,v7)-0.5*mk3*Svec(v1,v8))+v7[j%3]*(0.75*Svec(v5,v6)+0.25*Svec(v4,v7)+0.5*mk3*Svec(v2,v8))+v8[j%3]*0.25*mk3*(Svec(v3,v4)+Svec(v1,v6)-Svec(v2,v7)+mk3*Svec(v4,v8)));
    }
    public double f5 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*(0.75*Svec(v2,v4)+0.25*Svec(v1,v5)+0.75*Svec(v3,v7)+0.25*mk3*Svec(v7,v8))+v2[j%3]*(-0.75*Svec(v1,v4)+0.25*Svec(v2,v5)+0.75*Svec(v3,v6)+0.25*mk3*Svec(v6,v8))+v3[j%3]*(0.25*Svec(v3,v5)-0.75*Svec(v2,v6)-0.75*Svec(v1,v7)+0.25*mk3*Svec(v5,v8))+v4[j%3]*Svec(v4,v5)-v5[j%3]*(0.25*Svec(v1,v1)+0.25*Svec(v2,v2)+0.25*Svec(v3,v3)+Svec(v4,v4)+0.25*Svec(v6,v6)+0.25*Svec(v7,v7)+0.5*mk3*Svec(v3,v8)+0.75*Svec(v8,v8))+v6[j%3]*(0.25*Svec(v5,v6)+0.75*Svec(v4,v7)-0.5*mk3*Svec(v2,v8))+v7[j%3]*(-0.75*Svec(v4,v6)+0.25*Svec(v5,v7)-0.5*mk3*Svec(v1,v8))+v8[j%3]*0.25*mk3*(Svec(v3,v5)+Svec(v2,v6)+Svec(v1,v7)+mk3*Svec(v5,v8)));
    }
    public double f6 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*0.25*(-3*Svec(v3,v4)+Svec(v1,v6)+3*Svec(v2,v7)+mk3*Svec(v4,v8))+v2[j%3]*0.25*(-3*Svec(v3,v5)+Svec(v2,v6)-3*Svec(v1,v7)+mk3*Svec(v5,v8))+v3[j%3]*0.25*(3*Svec(v1,v4)+3*Svec(v2,v5)+Svec(v3,v6)-mk3*Svec(v6,v8))+v4[j%3]*0.25*(Svec(v4,v6)-3*Svec(v5,v7)-2*mk3*Svec(v1,v8))+v5[j%3]*0.25*(Svec(v5,v6)+3*Svec(v4,v7)-2*mk3*Svec(v2,v8))-v6[j%3]*0.25*(Svec(v1,v1)+Svec(v2,v2)+Svec(v3,v3)+Svec(v4,v4)+Svec(v5,v5)+4*Svec(v7,v7)-2*mk3*Svec(v3,v8)+3*Svec(v8,v8))+v7[j%3]*Svec(v6,v7)+v8[j%3]*mk3*0.25*(Svec(v1,v4)+Svec(v2,v5)-Svec(v3,v6)+mk3*Svec(v6,v8)));
    }
    public double f7 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*0.25*(-3*Svec(v3,v5)-3*Svec(v2,v6)+Svec(v1,v7)+mk3*Svec(v5,v8))+v2[j%3]*0.25*(3*Svec(v3,v4)+3*Svec(v1,v6)+Svec(v2,v7)-mk3*Svec(v4,v8))+v3[j%3]*0.25*(-3*Svec(v2,v4)+3*Svec(v1,v5)+Svec(v3,v7)-mk3*Svec(v7,v8))+v4[j%3]*0.25*(3*Svec(v5,v6)+Svec(v4,v7)+2*mk3*Svec(v2,v8))+v5[j%3]*0.25*(-3*Svec(v4,v6)+Svec(v5,v7)-2*mk3*Svec(v1,v8))+v6[j%3]*Svec(v6,v7)-v7[j%3]*0.25*(Svec(v1,v1)+Svec(v2,v2)+Svec(v3,v3)+Svec(v4,v4)+Svec(v5,v5)+4*Svec(v6,v6)-2*mk3*Svec(v3,v8)+3*Svec(v8,v8))+v8[j%3]*mk3*0.25*(-Svec(v2,v4)+Svec(v1,v5)-Svec(v3,v7)+mk3*Svec(v7,v8)));
    }
    public double f8 (int j, double[] mas)
    {
        double v1[] = {av[0]+h*mas[0], av[1]+h*mas[1], av[2]+h*mas[2]};
        double v2[] = {av[3]+h*mas[3], av[4]+h*mas[4], av[5]+h*mas[5]};
        double v3[] = {av[6]+h*mas[6], av[7]+h*mas[7], av[8]+h*mas[8]};
        double v4[] = {av[9]+h*mas[9], av[10]+h*mas[10], av[11]+h*mas[11]};
        double v5[] = {av[12]+h*mas[12], av[13]+h*mas[13], av[14]+h*mas[14]};
        double v6[] = {av[15]+h*mas[15], av[16]+h*mas[16], av[17]+h*mas[17]};
        double v7[] = {av[18]+h*mas[18], av[19]+h*mas[19], av[20]+h*mas[20]};
        double v8[] = {av[21]+h*mas[21], av[22]+h*mas[22], av[23]+h*mas[23]};

        return (double)(v1[j%3]*(-0.5)*mk3*(Svec(v4,v6)+Svec(v5,v7))+v2[j%3]*0.5*mk3*(-Svec(v5,v6)+Svec(v4,v7))+v3[j%3]*0.25*mk3*(-Svec(v4,v4)-Svec(v5,v5)+Svec(v6,v6)+Svec(v7,v7))+v4[j%3]*0.25*mk3*(Svec(v3,v4)+Svec(v1,v6)-Svec(v2,v7)+mk3*Svec(v4,v8))+v5[j%3]*0.25*mk3*(Svec(v3,v5)+Svec(v2,v6)+Svec(v1,v7)+mk3*Svec(v5,v8))+v6[j%3]*0.25*mk3*(Svec(v1,v4)+Svec(v2,v5)-Svec(v3,v6)+mk3*Svec(v6,v8))+v7[j%3]*0.25*mk3*(-Svec(v2,v4)+Svec(v1,v5)-Svec(v3,v7)+mk3*Svec(v7,v8))-v8[j%3]*0.75*(Svec(v4,v4)+Svec(v5,v5)+Svec(v6,v6)+Svec(v7,v7)));
    }
    public double fc (double u1)
    {
        return u1;
    }
    public double U123 ()
    {
        return (double)(0.5*(kvvvec(1,2)+kvvvec(3,1)+kvvvec(2,3)));
    }
    public double U147 ()
    {
        return (double)(0.125*(kvvvec(1,4)+kvvvec(4,7)+kvvvec(7,1)));
    }
    public double U156 ()
    {
        return (double)(0.125*(kvvvec(1,5)+kvvvec(5,6)+kvvvec(6,1)));
    }
    public double U246 ()
    {
        return (double)(0.125*(kvvvec(2,4)+kvvvec(4,6)+kvvvec(6,2)));
    }
    public double U257 ()
    {
        return (double)(0.125*(kvvvec(2,5)+kvvvec(5,7)+kvvvec(7,2)));
    }
    public double U3458 ()
    {
        return (double)(0.125*(kvvvec(3,4)+kvvvec(3,5)+4*kvvvec(4,5)+3*kvvvec(4,8)+3*kvvvec(5,8)-2*mk3*svec(3,4)*svec(8,4)-2*mk3*svec(5,3)*svec(8,5)+2*mk3*svec(4,4)*svec(8,3)+2*mk3*svec(5,5)*svec(8,3)));
    }
    public double U3678 ()
    {
        return (double)(0.125*(kvvvec(6,3)+kvvvec(3,7)+4*kvvvec(7,6)+3*kvvvec(6,8)+3*kvvvec(7,8)+2*mk3*svec(6,3)*svec(8,6)+2*mk3*svec(7,3)*svec(8,7)-2*mk3*svec(8,3)*svec(6,6)-2*mk3*svec(8,3)*svec(7,7)));
    }
    public double RU ()
    {
        return (double)(0.5*mk3*(svec(2,8)*svec(5,6)-svec(2,8)*svec(4,7)+svec(1,8)*svec(4,6)+svec(1,8)*svec(5,7))+0.75*(svec(5,7)*svec(4,6)-svec(4,7)*svec(5,6)+svec(3,4)*svec(1,6)-svec(3,4)*svec(2,7)-svec(1,6)*svec(2,7)+svec(1,7)*svec(3,5)+svec(2,6)*svec(1,7)+svec(2,6)*svec(3,5)+svec(2,5)*svec(1,4)-svec(2,5)*svec(3,6)-svec(1,4)*svec(3,6)-svec(1,5)*svec(2,4)-svec(3,7)*svec(1,5)+svec(3,7)*svec(2,4))+0.25*mk3*(-svec(4,8)*svec(1,6)+svec(2,7)*svec(4,8)-svec(2,6)*svec(5,8)-svec(5,8)*svec(1,7)-svec(6,8)*svec(1,4)-svec(6,8)*svec(2,5)+svec(7,8)*svec(2,4)-svec(7,8)*svec(1,5)));
    }
    public double U ()
    {
        return (double)(U123()+U147()+U156()+U246()+U257()+U3458()+U3678()+RU());
    }
    public double K ()
    {
        return (double)(0.5*(svec(9,9)+svec(10,10)+svec(11,11)+svec(12,12)+svec(13,13)+svec(14,14)+svec(15,15)+svec(16,16)));
    }
    public double EUK ()
    {
        return (double)(Math.log10(Math.abs(K()+U()-1.0)));
    }
    public double Kone (double[] v1, double[] v2, double[] v3)
    {
        return (double)(0.5*(Svec(v1,v1)+Svec(v2,v2)+Svec(v3,v3)));
    }
    public double Kone1 (int v1, int v2, int v3, double uy)
    {
        v1 = v1+8; v2 = v2+8; v3 = v3+8;
        return (double)(uy*(svec(v1,v1)+svec(v2,v2)+svec(v3,v3)));
    }

    public void schetstep()
    {
        double k1[][] = new double[48][mp];
        double ss1[] = new double[48];

        for(int s = 0; s < 48; s++)
            ss1[s] = 0;

        for(int j = 0; j < 24; j++)
            k1[j][0] = fc(av[j+24]);
        for(int j = 24; j < 27; j++)
            k1[j][0] = f1(j,ss1);
        for(int j = 27; j < 30; j++)
            k1[j][0] = f2(j,ss1);
        for(int j = 30; j < 33; j++)
            k1[j][0] = f3(j,ss1);
        for(int j = 33; j < 36; j++)
            k1[j][0] = f4(j,ss1);
        for(int j = 36; j < 39; j++)
            k1[j][0] = f5(j,ss1);
        for(int j = 39; j < 42; j++)
            k1[j][0] = f6(j,ss1);
        for(int j = 42; j < 45; j++)
            k1[j][0] = f7(j,ss1);
        for(int j = 45; j < 48; j++)
            k1[j][0] = f8(j,ss1);

        for(int j = 1; j < mp; j++)
        {
            for(int s = 0; s < 48; s++)
                ss1[s] = 0;

            for(int ss = 0; ss < 48; ss++)
                for(int s = 0; s < j; s++)
                    ss1[ss] += b[j][s]*k1[ss][s];


            for(int ss = 0; ss < 24; ss++)
                k1[ss][j] = fc(av[ss+24]+h*ss1[ss+24]);
            for(int ss = 24; ss < 27; ss++)
                k1[ss][j] = f1(ss,ss1);
            for(int ss = 27; ss < 30; ss++)
                k1[ss][j] = f2(ss,ss1);
            for(int ss = 30; ss < 33; ss++)
                k1[ss][j] = f3(ss,ss1);
            for(int ss = 33; ss < 36; ss++)
                k1[ss][j] = f4(ss,ss1);
            for(int ss = 36; ss < 39; ss++)
                k1[ss][j] = f5(ss,ss1);
            for(int ss = 39; ss < 42; ss++)
                k1[ss][j] = f6(ss,ss1);
            for(int ss = 42; ss < 45; ss++)
                k1[ss][j] = f7(ss,ss1);
            for(int ss = 45; ss < 48; ss++)
                k1[ss][j] = f8(ss,ss1);
        }

        for(int s = 0; s < 48; s++)
            ss1[s] = 0;
        for(int ss = 0; ss < 48; ss++)
            for(int s = 0; s < mp; s++)
                ss1[ss] += c[s]*k1[ss][s];


        for(int s = 0; s < 48; s++)
            av[s] = av[s] + h*ss1[s];
    }
    /*
	public void myMaxMin()
	{
		for(int i = 0; i < 24; i++)
		{
			maxMin[i][0] = umas[i][1];
			for(int j = 3; j < 2*umas[i][0]; j+=2)
				if(umas[i][j] < maxMin[i][0])
					maxMin[i][0] = umas[i][j];
		}
		for(int i = 0; i < 24; i++)
		{
			maxMin[i][1] = umas[i+24][1];
			for(int j = 3; j < 2*umas[i+24][0]; j+=2)
				if(umas[i+24][j] > maxMin[i][1])
					maxMin[i][1] = umas[i+24][j];
		}
	}
	*/
    public double myMax3(double m1, double m2, double m3)
    {
        double max;

        if(Math.abs(m1) > Math.abs(m2))
            if(Math.abs(m1) > Math.abs(m3))
                max = m1;
            else
                max = m3;
        else if(Math.abs(m3) > Math.abs(m2))
            max = m3;
        else
            max = m2;

        return max;
    }

    public double myMod(int vec, int j)
    {
        double max;
        max = myMax3(MaxMin[vec + j][vec], MaxMin[vec + j][vec+1], MaxMin[vec + j][vec+2]);

        return (double)(Math.signum(max)*Math.sqrt(MaxMin[vec+j][vec]*MaxMin[vec+j][vec] + MaxMin[vec+j][vec+1]*MaxMin[vec+j][vec+1] + MaxMin[vec+j][vec+2]*MaxMin[vec+j][vec+2]));
    }
    public double myModav(int vec)
    {
        double max;
        max = myMax3(av[vec], av[vec + 1], av[vec + 2]);

        return (double)(Math.signum(max)*Math.sqrt(av[vec]*av[vec] + av[vec+1]*av[vec+1] + av[vec+2]*av[vec+2]));
    }
    public double myMod_vec(double xx, double yy, double zz)
    {
        double max;
        max = myMax3(xx, yy, zz);

        return (double)(Math.signum(max)*Math.sqrt(xx*xx + yy*yy + zz*zz));
    }
    public void macshtab2(double[][] mas, int in, double[] kof, int dl)
    {
        double min, max;

        int j =-1;
        do{
            j++;
            min  = mas[in][j];
            max = mas[in][j];
        }while(mas[in][j]<-2000||mas[in][j]>200000);

        for(int i = 1; i < dl;  i++)
        {
            if(mas[in][i]>max && mas[in][i] < 200000)
                max = mas[in][i];
            if(mas[in][i]<min && mas[in][i] > -2000)
                min = mas[in][i];
        }

        kof[0] = min;
        kof[1] = max;
    }
    public int wndX(double x, int index){
        return (int)((x-maxMin[index][0])*1.0/(maxMin[index][1]-maxMin[index][0])*(wndXMax-wndXMin)+wndXMin);
    }

    public int wndY(double y, int index){
        return (int)(wndYMax-(y-maxMin[index][0])*1.0/(maxMin[index][1]-maxMin[index][0])*(wndYMax-wndYMin));
    }

    public int wndXAll(double x, int index){
        return (int)((x-uAll[index][0])*1.0/(uAll[index][1]-uAll[index][0])*(wndXMax-wndXMin)+wndXMin);
    }

    public int wndYAll(double y, int index){
        return (int)(wndYMax-(y-uAll[index][2])*1.0/(uAll[index][3]-uAll[index][2])*(wndYMax-wndYMin));
    }

    public int wndXYAll(double x, int index){
        return (int)((x-uAll[index][0])*1.0/(uAll[index][1]-uAll[index][0])*(wndYMax-wndYMin)+wndXMin);
    }

    public double obrwndY(int Yy, int index)
    {
        return (double)((wndYMax-Yy)*(maxMin[index][1]-maxMin[index][0])*1.0/(wndYMax-wndYMin)+maxMin[index][0]);
    }

    public void norm(int index)
    {
        if(uAll[index][1] > uAll[index][3])
            uAll[index][3] = uAll[index][1];
        else
            uAll[index][1] = uAll[index][3];

        if(uAll[index][0] < uAll[index][2])
            uAll[index][2] = uAll[index][0];
        else
            uAll[index][0] = uAll[index][2];
    }

    public void shcala(int indexX, int indexY)
    {
        Graphics g = getGraphics();

        g.setColor(Color.BLACK);
        g.drawRect((int)(wndXMin), (int)(wndYMin), (int)(wndXMax-wndXMin), (int)(wndYMax-wndYMin));

        double xMax = maxMin[indexX][1], xMin = maxMin[indexX][0];
        double yMax = maxMin[indexY][1], yMin = maxMin[indexY][0];
        int rline = 20;
        double xh = (int)((xMax-xMin)/rline);
        double yh = (int)((yMax-yMin)/(rline-5));
        int t = 1;

        if(xh != 0)
        {
            double xm = (int)(xMin);

            while(xm%5 != 0 || xm < xMin)
                xm++;

            while(xh%5 != 0)
                xh++;

            while(xm < xMax)
            {
                g.drawLine(wndX(xm, indexX), wndYMax, wndX(xm, indexX), wndYMax-2);
                g.drawLine(wndX(xm, indexX), wndYMin, wndX(xm, indexX), wndYMin+2);

                if(t%2 == 0)
                {
                    g.drawString(""+(int)(xm), wndX(xm, indexX) - 10, wndYMax + 15);
                    g.drawString(""+(int)(xm), wndX(xm, indexX) - 10, wndYMin - 5);
                }

                xm += xh; t++;
            }
        }
        else
        {
            double px = 1.0*(xMax-xMin)/rline;
            if(px < 0.25)
                xh = 0.2;
            else
                xh = 0.5;

            double xm = (int)(xMin);

            while(xm > xMin)
                xm -= xh;
            while(xm < xMin)
                xm += xh;

            while(xm < xMax)
            {
                g.drawLine(wndX(xm, indexX), wndYMax, wndX(xm, indexX), wndYMax-2);
                g.drawLine(wndX(xm, indexX), wndYMin, wndX(xm, indexX), wndYMin+2);

                if(t%2 == 0)
                {
                    g.drawString(""+(double)(Math.round(xm*10)/10.0), wndX(xm, indexX) - 10, wndYMax + 15);
                    g.drawString(""+(double)(Math.round(xm*10)/10.0), wndX(xm, indexX) - 10, wndYMin - 5);
                }

                xm += xh; t++;
            }
        }

        if(yh != 0)
        {
            double ym = (int)(yMin);

            while(ym%5 != 0)
                ym++;

            while(yh%5 != 0)
                yh++;

            while(ym < yMax)
            {
                g.drawLine(wndXMin, wndY(ym, indexY), wndXMin+2, wndY(ym, indexY));
                g.drawLine(wndXMax, wndY(ym, indexY), wndXMax-2, wndY(ym, indexY));

                g.drawString(""+(int)(ym), wndXMin - 30, wndY(ym, indexY)+5);
                g.drawString(""+(int)(ym), wndXMax + 10, wndY(ym, indexY)+5);

                ym += yh;
            }
        }
        else
        {
            double py = 1.0*(yMax-yMin)/(rline-5);
            if(py < 0.1)
            {
                yh = Math.round(py*1000)/1000.0;
                if(yh == 0)
                    yh = py;
            }
            else if(py < 0.25)
                yh = 0.2;
            else
                yh = 0.5;

            double ym = (int)(yMin);

            if(ym > yMin)
            {
                while(ym > yMin)
                    ym -= yh;
                ym += yh;
            }
            else
            {
                while(ym < yMin)
                    ym += yh;
            }

            while(ym < yMax)
            {
                g.drawLine(wndXMin, wndY(ym, indexY), wndXMin+2, wndY(ym, indexY));
                g.drawLine(wndXMax, wndY(ym, indexY), wndXMax-2, wndY(ym, indexY));

                if(Math.round(yh*1000)/1000.0 == 0)
                {
                    g.drawString(""+(double)(Math.round(ym*100000)/100000.0), wndXMin - 45, wndY(ym, indexY)+5);
                    g.drawString(""+(double)(Math.round(ym*100000)/100000.0), wndXMax + 10, wndY(ym, indexY)+5);
                }
                else{
                    g.drawString(""+(double)(Math.round(ym*1000)/1000.0), wndXMin - 37, wndY(ym, indexY)+5);
                    g.drawString(""+(double)(Math.round(ym*1000)/1000.0), wndXMax + 10, wndY(ym, indexY)+5);
                }

                ym += yh;
            }
        }
    }

    public double razdelSlow(int nk, int in1, int in2, int in3)
    {
        double Max1, Max2, Max3, Min1, Min2, Min3, delta;

        Max1 = Math.sqrt(MaxMin[in1+24][in1]*MaxMin[in1+24][in1] + MaxMin[in1+24][in2]*MaxMin[in1+24][in2] +MaxMin[in1+24][in3]*MaxMin[in1+24][in3]);
        Max2 = Math.sqrt(MaxMin[in2+24][in1]*MaxMin[in2+24][in1] + MaxMin[in2+24][in2]*MaxMin[in2+24][in2] +MaxMin[in2+24][in3]*MaxMin[in2+24][in3]);
        Max3 = Math.sqrt(MaxMin[in3+24][in1]*MaxMin[in3+24][in1] + MaxMin[in3+24][in2]*MaxMin[in3+24][in2] +MaxMin[in3+24][in3]*MaxMin[in3+24][in3]);

        Min1 = Math.sqrt(MaxMin[in1][in1]*MaxMin[in1][in1] + MaxMin[in1][in2]*MaxMin[in1][in2] +MaxMin[in1][in3]*MaxMin[in1][in3]);
        Min2 = Math.sqrt(MaxMin[in2][in1]*MaxMin[in2][in1] + MaxMin[in2][in2]*MaxMin[in2][in2] +MaxMin[in2][in3]*MaxMin[in2][in3]);
        Min3 = Math.sqrt(MaxMin[in3][in1]*MaxMin[in3][in1] + MaxMin[in3][in2]*MaxMin[in3][in2] +MaxMin[in3][in3]*MaxMin[in3][in3]);

        Max1 = myMax3(Max1, Max2, Max3);
        Min1 = myMax3(Min1, Min2, Min3);

        if(Max1 > Min1)
            delta = 1.0*Max1/nk;
        else
            delta = 1.0*Min1/nk;

        return delta;
    }
    public double razdelSlowMod(int nk, int t1, int t2, int t3)
    {
        double Max, Min, delta;

        Max = myMax3(myMod(t1,24), myMod(t2,24), myMod(t3,24));
        Min = myMax3(myMod(t1,0), myMod(t2,0), myMod(t3,0));

        if(Math.abs(Max) > Math.abs(Min))
            delta = 1.0*Math.abs(Max)/nk;
        else
            delta = 1.0*Math.abs(Min)/nk;

        return delta;
    }
    public double razdelSlow_4(int nk, int s, int i, int in2, int in3)
    {
        double Max1, Max2, Max3, Min1, Min2, Min3, delta;
        double Vmax, Vmin;
        int in1, n;

        if(s == 1)
        {
            if(MaxMin[6 + i + 24][6+i] > MaxMin[21 + i + 24][21+i])
                in1 = 6 + i;
            else
                in1 = 21 + i;

            Vmax = 0.5*(MaxMin[in1 + 24][6+i]+s*mk3*MaxMin[in1 + 24][21+i]);
            n = 24;
        }
        else
        {
            if(MaxMin[6 + i + 24][6+i] > -MaxMin[21 + i][21+i])
                in1 = 6 + i;
            else
                in1 = 21 + i;

            Vmax = 0.5*(MaxMin[in1 + 24][6+i]+s*mk3*MaxMin[in1][21+i]);
            n = 0;
        }

        Max1 = Math.sqrt(Vmax*Vmax + MaxMin[in1+24][in2]*MaxMin[in1+24][in2] +MaxMin[in1+24][in3]*MaxMin[in1+24][in3]);
        Max2 = Math.sqrt((0.5*(MaxMin[in2 + 24][6+i]+s*mk3*MaxMin[in2 + n][21+i])*0.5*(MaxMin[in2 + 24][6+i]+s*mk3*MaxMin[in2 + n][21+i])) + MaxMin[in2+24][in2]*MaxMin[in2+24][in2] +MaxMin[in2+24][in3]*MaxMin[in2+24][in3]);
        Max3 = Math.sqrt((0.5*(MaxMin[in3 + 24][6+i]+s*mk3*MaxMin[in3 + n][21+i])*0.5*(MaxMin[in3 + 24][6+i]+s*mk3*MaxMin[in3 + n][21+i])) + MaxMin[in3+24][in2]*MaxMin[in3+24][in2] +MaxMin[in3+24][in3]*MaxMin[in3+24][in3]);

        if(s == 1)
        {
            if(MaxMin[6 + i][6+i] > MaxMin[21 + i][21+i])
                in1 = 21 + i;
            else
                in1 = 6 + i;

            Vmin = 0.5*(MaxMin[in1][6+i]+s*mk3*MaxMin[in1][21+i]);
            n = 0;
        }
        else
        {
            if(MaxMin[6 + i][6+i] > -MaxMin[21 + i + 24][21+i])
                in1 = 21 + i;
            else
                in1 = 6 + i;

            Vmin = 0.5*(MaxMin[in1][6+i]+s*mk3*MaxMin[in1+24][21+i]);
            n = 24;
        }

        Min1 = Math.sqrt(Vmin*Vmin + MaxMin[in1][in2]*MaxMin[in1][in2] +MaxMin[in1][in3]*MaxMin[in1][in3]);
        Min2 = Math.sqrt(0.5*(MaxMin[in2][6+i]+s*mk3*MaxMin[in2 + n][21+i])*0.5*(MaxMin[in2][6+i]+s*mk3*MaxMin[in2 + n][21+i]) + MaxMin[in2][in2]*MaxMin[in2][in2] +MaxMin[in2][in3]*MaxMin[in2][in3]);
        Min3 = Math.sqrt(0.5*(MaxMin[in3][6+i]+s*mk3*MaxMin[in3 + n][21+i])*0.5*(MaxMin[in3][6+i]+s*mk3*MaxMin[in3 + n][21+i]) + MaxMin[in3][in2]*MaxMin[in3][in2] +MaxMin[in3][in3]*MaxMin[in3][in3]);

        Max1 = myMax3(Max1, Max2, Max3);
        Min1 = myMax3(Min1, Min2, Min3);

        if(Max1 > Min1)
            delta = 1.0*Max1/nk;
        else
            delta = 1.0*Min1/nk;

        return delta;
    }
    public double razdelSlowMod_4(int nk, int s, int t2, int t3)
    {
        double Max, Min, delta;
        double Vmax, Vmin;
        double Vmax1, Vmin1, Vmax2, Vmin2, Vmax3, Vmin3;

        if(s == 1)
        {
            Vmax1 = 0.5*(maxMin[6][1]+s*mk3*maxMin[21][1]);
            Vmin1 = 0.5*(maxMin[6][0]+s*mk3*maxMin[21][0]);
            Vmax2 = 0.5*(maxMin[6+1][1]+s*mk3*maxMin[21+1][1]);
            Vmin2 = 0.5*(maxMin[6+1][0]+s*mk3*maxMin[21+1][0]);
            Vmax3 = 0.5*(maxMin[6+2][1]+s*mk3*maxMin[21+2][1]);
            Vmin3 = 0.5*(maxMin[6+2][0]+s*mk3*maxMin[21+2][0]);
        }
        else
        {
            Vmax1 = 0.5*(maxMin[6][1]+s*mk3*maxMin[21][0]);
            Vmin1 = 0.5*(maxMin[6][0]+s*mk3*maxMin[21][1]);
            Vmax2 = 0.5*(maxMin[6+1][1]+s*mk3*maxMin[21+1][0]);
            Vmin2 = 0.5*(maxMin[6+1][0]+s*mk3*maxMin[21+1][1]);
            Vmax3 = 0.5*(maxMin[6+2][1]+s*mk3*maxMin[21+2][0]);
            Vmin3 = 0.5*(maxMin[6+2][0]+s*mk3*maxMin[21+2][1]);
        }

        Vmax = myMax3(Vmax1, Vmax2, Vmax3);
        Vmax = Math.signum(Vmax)*Math.sqrt(Vmax1*Vmax1 + Vmax2*Vmax2 + Vmax3*Vmax3);

        Max = myMax3(Vmax, myMod(t2,24), myMod(t3,24));

        Vmin = myMax3(Vmin1, Vmin2, Vmin3);
        Vmin = Math.signum(Vmin)*Math.sqrt(Vmin1*Vmin1 + Vmin2*Vmin2 + Vmin3*Vmin3);

        Min = myMax3(Vmin, myMod(t2,0), myMod(t3,0));

        if(Math.abs(Max) > Math.abs(Min))
            delta = 1.0*Math.abs(Max)/nk;
        else
            delta = 1.0*Math.abs(Min)/nk;

        return delta;
    }
    public int slow_ravnomer(int nk, double m1, double m2, double m3, double delta)
    {
        //‰Îˇ ‡‚ÌÓÏÂÌÓ„Ó ÒÎÛ˜‡ˇ
        double p = Math.sqrt(m1*m1+m2*m2+m3*m3);
        int ps = nk -(int)(p/delta);

        if(ps > 0)
            return ps;
        return 1;

    }
    public void paint(Graphics g){
        update(g);
    }

    public void update(Graphics g)
    {
        g.setColor(Color.red);
        g.drawLine(sizePanel-1, 0, sizePanel-1, sizeY);

        if(first != 0)
            draw();
    }
    public void macshtab3D()
    {
        for(int i = 0; i < 8; i++)
        {
            uAll[i][1] = maxMin[i*3][1]+maxMin[i*3+2][1]*Math.cos(alpha);
            if(uAll[i][1] < 0)
                uAll[i][1] = 0;
            uAll[i][0] = maxMin[i*3][0]+maxMin[i*3+2][0]*Math.cos(alpha);
            if(uAll[i][0] > 0)
                uAll[i][0] = 0;
            uAll[i][3] = maxMin[i*3+1][1]+maxMin[i*3+2][1]*Math.sin(alpha);
            if(uAll[i][3] < 0)
                uAll[i][3] = 0;
            uAll[i][2] = maxMin[i*3+1][0]+maxMin[i*3+2][0]*Math.sin(alpha);
            if(uAll[i][2] > 0)
                uAll[i][2] = 0;

            norm(i);
        }

        for(int i = 0; i < 3; i++)
        {
            macsh_3D(8,1,2,3,i);
            macsh_3D(11,1,4,7,i);
            macsh_3D(14,1,5,6,i);
            macsh_3D(17,2,4,6,i);
            macsh_3D(20,2,5,7,i);
            macsh_3D_4(23,1,4,5,i);
            macsh_3D_4(26,-1,6,7,i);
        }

        macsh_3D_mod(29,1,2,3);
        macsh_3D_mod(30,1,4,7);
        macsh_3D_mod(31,1,5,6);
        macsh_3D_mod(32,2,4,6);
        macsh_3D_mod(33,2,5,7);

        macsh_3D_mod_4(34,1,4,5);
        macsh_3D_mod_4(35,-1,6,7);
    }

    public void mypaint()
    {
        clear();

        macshtab3D();

        for(int j1 = 0; j1 < 420; j1++)
            for(int j2 = 0; j2 < 420; j2++)
            {
                img3D_u1All[j1][j2] = 100;
                img3D_u2All[j1][j2] = 100;
                img3D_u3All[j1][j2] = 100;
                img3D_u4All[j1][j2] = 100;
                img3D_u5All[j1][j2] = 100;
                img3D_u6All[j1][j2] = 100;
                img3D_u7All[j1][j2] = 100;
                img3D_u8All[j1][j2] = 100;
                img3D_uAll1_123[j1][j2] = 100;
                img3D_uAll2_123[j1][j2] = 100;
                img3D_uAll3_123[j1][j2] = 100;
                img3D_uAll1_147[j1][j2] = 100;
                img3D_uAll2_147[j1][j2] = 100;
                img3D_uAll3_147[j1][j2] = 100;
                img3D_uAll1_156[j1][j2] = 100;
                img3D_uAll2_156[j1][j2] = 100;
                img3D_uAll3_156[j1][j2] = 100;
                img3D_uAll1_246[j1][j2] = 100;
                img3D_uAll2_246[j1][j2] = 100;
                img3D_uAll3_246[j1][j2] = 100;
                img3D_uAll1_257[j1][j2] = 100;
                img3D_uAll2_257[j1][j2] = 100;
                img3D_uAll3_257[j1][j2] = 100;
                img3D_uAll1_3458[j1][j2] = 100;
                img3D_uAll2_3458[j1][j2] = 100;
                img3D_uAll3_3458[j1][j2] = 100;
                img3D_uAll1_3678[j1][j2] = 100;
                img3D_uAll2_3678[j1][j2] = 100;
                img3D_uAll3_3678[j1][j2] = 100;
                img3D_mod123[j1][j2] = 100;
                img3D_mod147[j1][j2] = 100;
                img3D_mod156[j1][j2] = 100;
                img3D_mod246[j1][j2] = 100;
                img3D_mod257[j1][j2] = 100;
                img3D_mod3458[j1][j2] = 100;
                img3D_mod3678[j1][j2] = 100;
            }

        for(int i = 20; i < 410; i++)
        {
            //ÓÒ¸ y
            img3D_u1All[wndXYAll(0,0)-wndXMin+10][i] = 102;
            img3D_u2All[wndXYAll(0,1)-wndXMin+10][i] = 102;
            img3D_u3All[wndXYAll(0,2)-wndXMin+10][i] = 102;
            img3D_u4All[wndXYAll(0,3)-wndXMin+10][i] = 102;
            img3D_u5All[wndXYAll(0,4)-wndXMin+10][i] = 102;
            img3D_u6All[wndXYAll(0,5)-wndXMin+10][i] = 102;
            img3D_u7All[wndXYAll(0,6)-wndXMin+10][i] = 102;
            img3D_u8All[wndXYAll(0,7)-wndXMin+10][i] = 102;

            img3D_uAll1_123[wndXYAll(0,8)-wndXMin+10][i] = 102;
            img3D_uAll2_123[wndXYAll(0,9)-wndXMin+10][i] = 102;
            img3D_uAll3_123[wndXYAll(0,10)-wndXMin+10][i] = 102;
            img3D_uAll1_147[wndXYAll(0,11)-wndXMin+10][i] = 102;
            img3D_uAll2_147[wndXYAll(0,12)-wndXMin+10][i] = 102;
            img3D_uAll3_147[wndXYAll(0,13)-wndXMin+10][i] = 102;
            img3D_uAll1_156[wndXYAll(0,14)-wndXMin+10][i] = 102;
            img3D_uAll2_156[wndXYAll(0,15)-wndXMin+10][i] = 102;
            img3D_uAll3_156[wndXYAll(0,16)-wndXMin+10][i] = 102;
            img3D_uAll1_246[wndXYAll(0,17)-wndXMin+10][i] = 102;
            img3D_uAll2_246[wndXYAll(0,18)-wndXMin+10][i] = 102;
            img3D_uAll3_246[wndXYAll(0,19)-wndXMin+10][i] = 102;
            img3D_uAll1_257[wndXYAll(0,20)-wndXMin+10][i] = 102;
            img3D_uAll2_257[wndXYAll(0,21)-wndXMin+10][i] = 102;
            img3D_uAll3_257[wndXYAll(0,22)-wndXMin+10][i] = 102;
            img3D_uAll1_3458[wndXYAll(0,23)-wndXMin+10][i] = 102;
            img3D_uAll2_3458[wndXYAll(0,24)-wndXMin+10][i] = 102;
            img3D_uAll3_3458[wndXYAll(0,25)-wndXMin+10][i] = 102;
            img3D_uAll1_3678[wndXYAll(0,26)-wndXMin+10][i] = 102;
            img3D_uAll2_3678[wndXYAll(0,27)-wndXMin+10][i] = 102;
            img3D_uAll3_3678[wndXYAll(0,28)-wndXMin+10][i] = 102;

            img3D_mod123[wndXYAll(0,29)-wndXMin+10][i] = 102;
            img3D_mod147[wndXYAll(0,30)-wndXMin+10][i] = 102;
            img3D_mod156[wndXYAll(0,31)-wndXMin+10][i] = 102;
            img3D_mod246[wndXYAll(0,32)-wndXMin+10][i] = 102;
            img3D_mod257[wndXYAll(0,33)-wndXMin+10][i] = 102;
            img3D_mod3458[wndXYAll(0,34)-wndXMin+10][i] = 102;
            img3D_mod3678[wndXYAll(0,35)-wndXMin+10][i] = 102;

            //ÓÒ¸ x
            img3D_u1All[i][wndYAll(0,0)-wndYMin+10] = 102;
            img3D_u2All[i][wndYAll(0,1)-wndYMin+10] = 102;
            img3D_u3All[i][wndYAll(0,2)-wndYMin+10] = 102;
            img3D_u4All[i][wndYAll(0,3)-wndYMin+10] = 102;
            img3D_u5All[i][wndYAll(0,4)-wndYMin+10] = 102;
            img3D_u6All[i][wndYAll(0,5)-wndYMin+10] = 102;
            img3D_u7All[i][wndYAll(0,6)-wndYMin+10] = 102;
            img3D_u8All[i][wndYAll(0,7)-wndYMin+10] = 102;

            img3D_uAll1_123[i][wndYAll(0,8)-wndYMin+10] = 102;
            img3D_uAll2_123[i][wndYAll(0,9)-wndYMin+10] = 102;
            img3D_uAll3_123[i][wndYAll(0,10)-wndYMin+10] = 102;
            img3D_uAll1_147[i][wndYAll(0,11)-wndYMin+10] = 102;
            img3D_uAll2_147[i][wndYAll(0,12)-wndYMin+10] = 102;
            img3D_uAll3_147[i][wndYAll(0,13)-wndYMin+10] = 102;
            img3D_uAll1_156[i][wndYAll(0,14)-wndYMin+10] = 102;
            img3D_uAll2_156[i][wndYAll(0,15)-wndYMin+10] = 102;
            img3D_uAll3_156[i][wndYAll(0,16)-wndYMin+10] = 102;
            img3D_uAll1_246[i][wndYAll(0,17)-wndYMin+10] = 102;
            img3D_uAll2_246[i][wndYAll(0,18)-wndYMin+10] = 102;
            img3D_uAll3_246[i][wndYAll(0,19)-wndYMin+10] = 102;
            img3D_uAll1_257[i][wndYAll(0,20)-wndYMin+10] = 102;
            img3D_uAll2_257[i][wndYAll(0,21)-wndYMin+10] = 102;
            img3D_uAll3_257[i][wndYAll(0,22)-wndYMin+10] = 102;
            img3D_uAll1_3458[i][wndYAll(0,23)-wndYMin+10] = 102;
            img3D_uAll2_3458[i][wndYAll(0,24)-wndYMin+10] = 102;
            img3D_uAll3_3458[i][wndYAll(0,25)-wndYMin+10] = 102;
            img3D_uAll1_3678[i][wndYAll(0,26)-wndYMin+10] = 102;
            img3D_uAll2_3678[i][wndYAll(0,27)-wndYMin+10] = 102;
            img3D_uAll3_3678[i][wndYAll(0,28)-wndYMin+10] = 102;

            img3D_mod123[i][wndYAll(0,29)-wndYMin+10] = 102;
            img3D_mod147[i][wndYAll(0,30)-wndYMin+10] = 102;
            img3D_mod156[i][wndYAll(0,31)-wndYMin+10] = 102;
            img3D_mod246[i][wndYAll(0,32)-wndYMin+10] = 102;
            img3D_mod257[i][wndYAll(0,33)-wndYMin+10] = 102;
            img3D_mod3458[i][wndYAll(0,34)-wndYMin+10] = 102;
            img3D_mod3678[i][wndYAll(0,35)-wndYMin+10] = 102;

            //ÓÒ¸ z
            img3D_u1All[420 - i][i] = 102;
            img3D_u2All[420 - i][i] = 102;
            img3D_u3All[420 - i][i] = 102;
            img3D_u4All[420 - i][i] = 102;
            img3D_u5All[420 - i][i] = 102;
            img3D_u6All[420 - i][i] = 102;
            img3D_u7All[420 - i][i] = 102;
            img3D_u8All[420 - i][i] = 102;

            img3D_uAll1_123[420 - i][i] = 102;
            img3D_uAll2_123[420 - i][i] = 102;
            img3D_uAll3_123[420 - i][i] = 102;
            img3D_uAll1_147[420 - i][i] = 102;
            img3D_uAll2_147[420 - i][i] = 102;
            img3D_uAll3_147[420 - i][i] = 102;
            img3D_uAll1_156[420 - i][i] = 102;
            img3D_uAll2_156[420 - i][i] = 102;
            img3D_uAll3_156[420 - i][i] = 102;
            img3D_uAll1_246[420 - i][i] = 102;
            img3D_uAll2_246[420 - i][i] = 102;
            img3D_uAll3_246[420 - i][i] = 102;
            img3D_uAll1_257[420 - i][i] = 102;
            img3D_uAll2_257[420 - i][i] = 102;
            img3D_uAll3_257[420 - i][i] = 102;
            img3D_uAll1_3458[420 - i][i] = 102;
            img3D_uAll2_3458[420 - i][i] = 102;
            img3D_uAll3_3458[420 - i][i] = 102;
            img3D_uAll1_3678[420 - i][i] = 102;
            img3D_uAll2_3678[420 - i][i] = 102;
            img3D_uAll3_3678[420 - i][i] = 102;

            img3D_mod123[420 - i][i] = 102;
            img3D_mod147[420 - i][i] = 102;
            img3D_mod156[420 - i][i] = 102;
            img3D_mod246[420 - i][i] = 102;
            img3D_mod257[420 - i][i] = 102;
            img3D_mod3458[420 - i][i] = 102;
            img3D_mod3678[420 - i][i] = 102;
        }

        for(int i = 0; i < 602; i++)
            for(int j = 0; j < 402; j++)
            {
                img_u11[i][j] = 0;
                img_u12[i][j] = 0;
                img_u13[i][j] = 0;
                img_u21[i][j] = 0;
                img_u22[i][j] = 0;
                img_u23[i][j] = 0;
                img_u31[i][j] = 0;
                img_u32[i][j] = 0;
                img_u33[i][j] = 0;
                img_u41[i][j] = 0;
                img_u42[i][j] = 0;
                img_u43[i][j] = 0;
                img_u51[i][j] = 0;
                img_u52[i][j] = 0;
                img_u53[i][j] = 0;
                img_u61[i][j] = 0;
                img_u62[i][j] = 0;
                img_u63[i][j] = 0;
                img_u71[i][j] = 0;
                img_u72[i][j] = 0;
                img_u73[i][j] = 0;
                img_u81[i][j] = 0;
                img_u82[i][j] = 0;
                img_u83[i][j] = 0;
                img_uc11[i][j] = 0;
                img_uc12[i][j] = 0;
                img_uc13[i][j] = 0;
                img_uc21[i][j] = 0;
                img_uc22[i][j] = 0;
                img_uc23[i][j] = 0;
                img_uc31[i][j] = 0;
                img_uc32[i][j] = 0;
                img_uc33[i][j] = 0;
                img_uc41[i][j] = 0;
                img_uc42[i][j] = 0;
                img_uc43[i][j] = 0;
                img_uc51[i][j] = 0;
                img_uc52[i][j] = 0;
                img_uc53[i][j] = 0;
                img_uc61[i][j] = 0;
                img_uc62[i][j] = 0;
                img_uc63[i][j] = 0;
                img_uc71[i][j] = 0;
                img_uc72[i][j] = 0;
                img_uc73[i][j] = 0;
                img_uc81[i][j] = 0;
                img_uc82[i][j] = 0;
                img_uc83[i][j] = 0;
                img_uf11[i][j] = 0;
                img_uf12[i][j] = 0;
                img_uf13[i][j] = 0;
                img_uf21[i][j] = 0;
                img_uf22[i][j] = 0;
                img_uf23[i][j] = 0;
                img_uf31[i][j] = 0;
                img_uf32[i][j] = 0;
                img_uf33[i][j] = 0;
                img_uf41[i][j] = 0;
                img_uf42[i][j] = 0;
                img_uf43[i][j] = 0;
                img_uf51[i][j] = 0;
                img_uf52[i][j] = 0;
                img_uf53[i][j] = 0;
                img_uf61[i][j] = 0;
                img_uf62[i][j] = 0;
                img_uf63[i][j] = 0;
                img_uf71[i][j] = 0;
                img_uf72[i][j] = 0;
                img_uf73[i][j] = 0;
                img_uf81[i][j] = 0;
                img_uf82[i][j] = 0;
                img_uf83[i][j] = 0;
                img_E[i][j] = 0;
            }

        for(int i = 0; i < 49; i++)
            for(int j = 0; j < 602; j++)
                utime[i][j] = -1;

        for(int i = 0; i < 49; i++)
            mouse[i] = 0;

        //‰Îˇ ÔÓ‰Ò˜ÂÚ‡ ÍÓÎË˜ÂÒÚ‚‡ ÚÓ˜ÂÍ ‚ 100 ÒÙÂË˜ÂÒÍËı ÒÎÓˇı

        for(int i = 0; i < SLOW_CONST; i++)
            for(int j = 0; j < 36; j++)
                Nkslow[j][i] = 0;

        for(int i = 0; i < 8; i++)
            delta100[i] = razdelSlow(SLOW_CONST, i*3, i*3+1, i*3+2);

        for(int i = 0; i < 3; i++)
        {
            delta100[8+i] = razdelSlow(SLOW_CONST, i, i+3, i+6);
            delta100[8+i+3] = razdelSlow(SLOW_CONST, i, i+9, i+18);
            delta100[8+i+6] = razdelSlow(SLOW_CONST, i, i+12, i+15);
            delta100[8+i+9] = razdelSlow(SLOW_CONST, i+3, i+9, i+15);
            delta100[8+i+12] = razdelSlow(SLOW_CONST, i+3, i+12, i+18);
            delta100[8+i+15] = razdelSlow_4(SLOW_CONST, 1, i, 9+i, 12+i);
            delta100[8+i+18] = razdelSlow_4(SLOW_CONST, -1, i, 15+i, 18+i);
        }

        delta100[29] = razdelSlowMod(SLOW_CONST, 0, 3, 6);
        delta100[30] = razdelSlowMod(SLOW_CONST, 0, 9, 18);
        delta100[31] = razdelSlowMod(SLOW_CONST, 0, 12, 15);
        delta100[32] = razdelSlowMod(SLOW_CONST, 3, 9, 15);
        delta100[33] = razdelSlowMod(SLOW_CONST, 3, 12, 18);
        delta100[34] = razdelSlowMod_4(SLOW_CONST, 1, 9, 12);
        delta100[35] = razdelSlowMod_4(SLOW_CONST, -1, 15, 18);

        for(int i = 0; i < 36; i++)
            System.out.println("delta " + i + " :  " + delta100[i]);

        draw();
    }
    public void draw()
    {
        Graphics g = getGraphics();

        if(myvision > 72 && myvision < 109)
            osXYZ(myvision - 73);

        for(int i = 0; i < 48; i++)
            av[i] = avstart[i];

        double delta[] = new double[36];

        if(first == 1)
        {
            for(int i = 0; i < 602; i++)
                for(int j = 0; j < 402; j++)
                    img_EUK[i][j] = 0;

            if(myfile == 1)
            {
                for(int i = 0; i < 8; i++)
                    delta[i] = razdelSlow(25, i*3, i*3+1, i*3+2);

                for(int i = 0; i < 3; i++)
                {
                    delta[8+i] = razdelSlow(25, i, i+3, i+6);
                    delta[8+i+3] = razdelSlow(25, i, i+9, i+18);
                    delta[8+i+6] = razdelSlow(25, i, i+12, i+15);
                    delta[8+i+9] = razdelSlow(25, i+3, i+9, i+15);
                    delta[8+i+12] = razdelSlow(25, i+3, i+12, i+18);
                    delta[8+i+15] = razdelSlow_4(25, 1, i, 9+i, 12+i);
                    delta[8+i+18] = razdelSlow_4(25, -1, i, 15+i, 18+i);
                }

                delta[29] = razdelSlowMod(25, 0, 3, 6);
                delta[30] = razdelSlowMod(25, 0, 9, 18);
                delta[31] = razdelSlowMod(25, 0, 12, 15);
                delta[32] = razdelSlowMod(25, 3, 9, 15);
                delta[33] = razdelSlowMod(25, 3, 12, 18);
                delta[34] = razdelSlowMod_4(25, 1, 9, 12);
                delta[35] = razdelSlowMod_4(25, -1, 15, 18);
            }
        }

        long i = tstart;

        if(myvision == 0)
        {
            Color col = new Color(0,0,139);
            g.setColor(col);

            if(first == 1 && myfile == 0)
            {

                maxMin[48][0] = -16; maxMin[48][1] = -5.0;
                maxMin[49][0] = 0; maxMin[49][1] = tb;

                for(int i1 = 0; i1 < 24; i1++)
                {
                    MaxMin[i1+24][i1] = av[i1];
                    MaxMin[i1][i1] = av[i1];
                    maxMin[i1+24][0] = av[i1+24];
                    maxMin[i1+24][1] = av[i1+24];
                }

                shcala(49, 48);
                int px, py;
                double myE, tlast = tstart*h;
                double tnegolh, tnegol = (tb - ta)*1.0/Nmas;
                tnegolh = tnegol;

                while (tlast < tb)
                {
                    schetstep();

                    for(int s = 0; s < 24; s++)
                    {
                        if(av[s] > MaxMin[s+24][s])
                            for(int j = 0; j < 24; j++)
                                MaxMin[s+24][j] = av[j];
                        else if(av[s] < MaxMin[s][s])
                            for(int j = 0; j < 24; j++)
                                MaxMin[s][j] = av[j];
                        if(av[s+24] > maxMin[s+24][1])
                            maxMin[s+24][1] = av[s+24];
                        else if(av[s+24] < maxMin[s+24][0])
                            maxMin[s+24][0] = av[s+24];
                    }

                    myE = EUK();

                    px = wndX(tlast, 49);
                    py = wndY(myE, 48);
                    if(py - wndYMin + 1 < 401 && py - wndYMin + 1 > -1)
                    {
                        img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
                        g.fillOval(px, py, point, point);
                    }

                    tlast += h; i++;

                    if(tlast > tnegol && gol < Nmas - 1)
                    {
                        gol++;
                        negolonomnost(tlast);
                        tnegol += tnegolh;
                    }
                }

                for(int s = 0; s < 24; s++)
                {
                    maxMin[s][0] = MaxMin[s][s]-Math.abs(MaxMin[s+24][s]-MaxMin[s][s])*0.1;
                    maxMin[s][1] = MaxMin[s+24][s]+Math.abs(MaxMin[s+24][s]-MaxMin[s][s])*0.2;
                    maxMin[s+24][0] = maxMin[s+24][0]-Math.abs(maxMin[s+24][1]-maxMin[s+24][0])*0.1;
                    maxMin[s+24][1] = maxMin[s+24][1]+Math.abs(maxMin[s+24][1]-maxMin[s+24][0])*0.2;
                }
            }
            if(first == 1 && myfile == 1)
            {
                maxMin[48][0] = -16; maxMin[48][1] = -5.0;
                shcala(49, 48);
                int px, py;
                double myE, tlast = tstart*h;
                double tnegolh, tnegol = (tb - ta)*1.0/Nmas;
                tnegolh = tnegol;

                while (tlast < tb)
                {
                    schetstep();
                    zapolnGrap(tlast, delta);

                    myE = EUK();

                    px = wndX(tlast, 49);
                    py = wndY(myE, 48);
                    if(py - wndYMin < 400 && py - wndYMin > -2)
                    {
                        img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
                        g.fillOval(px, py, point, point);
                    }

                    tlast += h; i++;

                    if(tlast > tnegol && gol < Nmas - 1)
                    {
                        gol++;
                        negolonomnost(tlast);
                        tnegol += tnegolh;
                    }
                }
            }
            else
            {
                shcala(49, 48);
                col = new Color(0,0,139);
                g.setColor(col);
                for(int j1 = 0; j1 < 602; j1++)
                    for(int j2 = 0; j2 < 402; j2++)
                        if(img_EUK[j1][j2] == 1)
                            g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, point, point);

                Image img1;
                img1 = getImage(getCodeBase(),"textlog.jpg");
                g.drawImage(img1, wndXMin-25, wndYMax+20, this);
                img1 = getImage(getCodeBase(),"time.jpg");
                g.drawImage(img1, wndXMax-60, wndYMin+8, this);
                img1 = getImage(getCodeBase(),"log.jpg");
                g.drawImage(img1, wndXMin+10, wndYMin+8, this);
            }
        }
        else if(myvision < 49)
        {
            if(myvision < 25)
            {
                Color col = new Color(0,0,205);
                g.setColor(col);
            }
            else
            {
                Color col = new Color(139,0,0);
                g.setColor(col);
            }


            int index = myvision - 1;
            shcala(49, index);
            double tlast = tstart*h;

            if(first == 1)
            {
                while (tlast < tb)
                {
                    schetstep();
                    zapolnGrap(tlast, delta);

                    g.fillOval(wndX(i*h, 49), wndY(av[index], index), point, point);
                    tlast += h;
                }
            }
            else if(myvision == 1)
                draw_img_1(img_u11);
            else if(myvision == 2)
                draw_img_1(img_u12);
            else if(myvision == 3)
                draw_img_1(img_u13);
            else if(myvision == 4)
                draw_img_1(img_u21);
            else if(myvision == 5)
                draw_img_1(img_u22);
            else if(myvision == 6)
                draw_img_1(img_u23);
            else if(myvision == 7)
                draw_img_1(img_u31);
            else if(myvision == 8)
                draw_img_1(img_u32);
            else if(myvision == 9)
                draw_img_1(img_u33);
            else if(myvision == 10)
                draw_img_1(img_u41);
            else if(myvision == 11)
                draw_img_1(img_u42);
            else if(myvision == 12)
                draw_img_1(img_u43);
            else if(myvision == 13)
                draw_img_1(img_u51);
            else if(myvision == 14)
                draw_img_1(img_u52);
            else if(myvision == 15)
                draw_img_1(img_u53);
            else if(myvision == 16)
                draw_img_1(img_u61);
            else if(myvision == 17)
                draw_img_1(img_u62);
            else if(myvision == 18)
                draw_img_1(img_u63);
            else if(myvision == 19)
                draw_img_1(img_u71);
            else if(myvision == 20)
                draw_img_1(img_u72);
            else if(myvision == 21)
                draw_img_1(img_u73);
            else if(myvision == 22)
                draw_img_1(img_u81);
            else if(myvision == 23)
                draw_img_1(img_u82);
            else if(myvision == 24)
                draw_img_1(img_u83);
            else if(myvision == 25)
                draw_img_1(img_uc11);
            else if(myvision == 26)
                draw_img_1(img_uc12);
            else if(myvision == 27)
                draw_img_1(img_uc13);
            else if(myvision == 28)
                draw_img_1(img_uc21);
            else if(myvision == 29)
                draw_img_1(img_uc22);
            else if(myvision == 30)
                draw_img_1(img_uc23);
            else if(myvision == 31)
                draw_img_1(img_uc31);
            else if(myvision == 32)
                draw_img_1(img_uc32);
            else if(myvision == 33)
                draw_img_1(img_uc33);
            else if(myvision == 34)
                draw_img_1(img_uc41);
            else if(myvision == 35)
                draw_img_1(img_uc42);
            else if(myvision == 36)
                draw_img_1(img_uc43);
            else if(myvision == 37)
                draw_img_1(img_uc51);
            else if(myvision == 38)
                draw_img_1(img_uc52);
            else if(myvision == 39)
                draw_img_1(img_uc53);
            else if(myvision == 40)
                draw_img_1(img_uc61);
            else if(myvision == 41)
                draw_img_1(img_uc62);
            else if(myvision == 42)
                draw_img_1(img_uc63);
            else if(myvision == 43)
                draw_img_1(img_uc71);
            else if(myvision == 44)
                draw_img_1(img_uc72);
            else if(myvision == 45)
                draw_img_1(img_uc73);
            else if(myvision == 46)
                draw_img_1(img_uc81);
            else if(myvision == 47)
                draw_img_1(img_uc82);
            else if(myvision == 48)
                draw_img_1(img_uc83);
        }
        else if(myvision < 73)
        {
            Color col = new Color(153,50,204);
            g.setColor(col);

            int index1 = myvision-49, index2 = myvision-25;
            double tlast = tstart*h;

            shcala(index1, index2);

            if(first == 1)
            {
                while (tlast < tb)
                {
                    schetstep();
                    zapolnGrap(tlast, delta);
                    g.fillOval(wndX(av[index1], index1), wndY(av[index2], index2), point, point);
                    tlast += h;
                }
            }
            else if(myvision == 49)
                draw_img_1(img_uf11);
            else if(myvision == 50)
                draw_img_1(img_uf12);
            else if(myvision == 51)
                draw_img_1(img_uf13);
            else if(myvision == 52)
                draw_img_1(img_uf21);
            else if(myvision == 53)
                draw_img_1(img_uf22);
            else if(myvision == 54)
                draw_img_1(img_uf23);
            else if(myvision == 55)
                draw_img_1(img_uf31);
            else if(myvision == 56)
                draw_img_1(img_uf32);
            else if(myvision == 57)
                draw_img_1(img_uf33);
            else if(myvision == 58)
                draw_img_1(img_uf41);
            else if(myvision == 59)
                draw_img_1(img_uf42);
            else if(myvision == 60)
                draw_img_1(img_uf43);
            else if(myvision == 61)
                draw_img_1(img_uf51);
            else if(myvision == 62)
                draw_img_1(img_uf52);
            else if(myvision == 63)
                draw_img_1(img_uf53);
            else if(myvision == 64)
                draw_img_1(img_uf61);
            else if(myvision == 65)
                draw_img_1(img_uf62);
            else if(myvision == 66)
                draw_img_1(img_uf63);
            else if(myvision == 67)
                draw_img_1(img_uf71);
            else if(myvision == 68)
                draw_img_1(img_uf72);
            else if(myvision == 69)
                draw_img_1(img_uf73);
            else if(myvision == 70)
                draw_img_1(img_uf81);
            else if(myvision == 71)
                draw_img_1(img_uf82);
            else if(myvision == 72)
                draw_img_1(img_uf83);
        }
        else if(myvision < 109)
        {
            if(myvision == 73)
                draw_img_3D(img3D_u1All);
            else if(myvision == 74)
                draw_img_3D(img3D_u2All);
            else if(myvision == 75)
                draw_img_3D(img3D_u3All);
            else if(myvision == 76)
                draw_img_3D(img3D_u4All);
            else if(myvision == 77)
                draw_img_3D(img3D_u5All);
            else if(myvision == 78)
                draw_img_3D(img3D_u6All);
            else if(myvision == 79)
                draw_img_3D(img3D_u7All);
            else if(myvision == 80)
                draw_img_3D(img3D_u8All);
            else if(myvision == 81)
                draw_img_3D(img3D_uAll1_123);
            else if(myvision == 82)
                draw_img_3D(img3D_uAll2_123);
            else if(myvision == 83)
                draw_img_3D(img3D_uAll3_123);
            else if(myvision == 84)
                draw_img_3D(img3D_uAll1_147);
            else if(myvision == 85)
                draw_img_3D(img3D_uAll2_147);
            else if(myvision == 86)
                draw_img_3D(img3D_uAll3_147);
            else if(myvision == 87)
                draw_img_3D(img3D_uAll1_156);
            else if(myvision == 88)
                draw_img_3D(img3D_uAll2_156);
            else if(myvision == 89)
                draw_img_3D(img3D_uAll3_156);
            else if(myvision == 90)
                draw_img_3D(img3D_uAll1_246);
            else if(myvision == 91)
                draw_img_3D(img3D_uAll2_246);
            else if(myvision == 92)
                draw_img_3D(img3D_uAll3_246);
            else if(myvision == 93)
                draw_img_3D(img3D_uAll1_257);
            else if(myvision == 94)
                draw_img_3D(img3D_uAll2_257);
            else if(myvision == 95)
                draw_img_3D(img3D_uAll3_257);
            else if(myvision == 96)
                draw_img_3D(img3D_uAll1_3458);
            else if(myvision == 97)
                draw_img_3D(img3D_uAll2_3458);
            else if(myvision == 98)
                draw_img_3D(img3D_uAll3_3458);
            else if(myvision == 99)
                draw_img_3D(img3D_uAll1_3678);
            else if(myvision == 100)
                draw_img_3D(img3D_uAll2_3678);
            else if(myvision == 101)
                draw_img_3D(img3D_uAll3_3678);
            else if(myvision == 102)
                draw_img_3D(img3D_mod123);
            else if(myvision == 103)
                draw_img_3D(img3D_mod147);
            else if(myvision == 104)
                draw_img_3D(img3D_mod156);
            else if(myvision == 105)
                draw_img_3D(img3D_mod246);
            else if(myvision == 106)
                draw_img_3D(img3D_mod257);
            else if(myvision == 107)
                draw_img_3D(img3D_mod3458);
            else if(myvision == 108)
                draw_img_3D(img3D_mod3678);
        }
        else if(myvision == 109)
        {
            int col[] = new int[3];

            shcala(49, 48);

            for(int j = 0; j < gol; j++)
                for(int j2 = 0; j2 < 8; j2++)
                    if(negol[j2][j] > -16)
                    {
                        myNewColor8(col, j2+1);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);

                        g.fillOval(wndX(negol[8][j], 49), wndY(negol[j2][j], 48), point, point);
                    }

            Image img1;
            img1 = getImage(getCodeBase(),"textgol.jpg");
            g.drawImage(img1, wndXMin-20, wndYMax+20, this);
            img1 = getImage(getCodeBase(),"time.jpg");
            g.drawImage(img1, wndXMax-60, wndYMin+8, this);
            img1 = getImage(getCodeBase(),"gol.jpg");
            g.drawImage(img1, wndXMin+10, wndYMin+8, this);
            System.out.println("gol = " + gol);

        }
        else if(myvision == 110)
        {
            int col[] = new int[3];

            maxMin[50][0] = 0; maxMin[50][1] = 10;
            shcala(49, 50);

            for(int j1 = 0; j1 < 602; j1++)
                for(int j2 = 0; j2 < 402; j2++)
                    if(img_E[j1][j2] != 0)
                    {
                        myNewColor8(col, img_E[j1][j2]);
                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(j1+wndXMin-1, j2+wndYMin-1, point, point);
                    }
        }
        else if(myvision > 110)
        {
            int index = myvision - 111;

            for(int j2 = 0; j2 < SLOW_CONST; j2++)
                Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1- j2]*h/(4*PI*(j2 + 1)*(j2 + 1)*Nh*delta100[index]*delta100[index]));

            double kof[] = new double[2];
            macshtab2(Pk, index, kof, SLOW_CONST - 1);
            maxMin[50][0] = Math.log10(delta100[index]);
            maxMin[50][1] = Math.log10(delta100[index]*99);
            maxMin[51][0] = kof[0] - Math.abs(kof[1] - kof[0])*0.12;
            maxMin[51][1] = kof[1] + Math.abs(kof[1] - kof[0])*0.2;

            shcala(50, 51);

            if(myvision < 111 + 8)
            {
                Color col = new Color(0,0,205);
                g.setColor(col);
            }
            else if(myvision < 111 + 8 + 21)
            {
                Color col = new Color(139,0,0);
                g.setColor(col);
            }
            else
            {
                Color col = new Color(153,50,204);
                g.setColor(col);
            }

            for(int ii = 0; ii < SLOW_CONST-2; ii++)
            {
                //‡‚ÌÓÏÂÌÓ
                g.drawLine(wndX(Math.log10((ii+1)*delta100[index]), 50), wndY(Pk[index][ii], 51), wndX(Math.log10((ii+2)*delta100[index]), 50), wndY(Pk[index][ii+1], 51));
                g.fillOval(wndX(Math.log10((ii+1)*delta100[index]), 50)-2, wndY(Pk[index][ii], 51)-2, 4, 4);
            }
            g.fillOval(wndX(Math.log10((SLOW_CONST-1)*delta100[index]), 50)-2, wndY(Pk[index][98], 51)-2, 4, 4);

            text_plot();
        }

        first = 2;
        System.out.println("‚ÒÂ ÚÓ˜ÍË Ì‡ÌÂÒÂÌ˚");
    }
    public void my3D(double xx, double yy, double zz, int in, int[][] mas, double[] delta)
    {
        int px, py, x1, y1, num1;

        px = wndXYAll(xx+zz*Math.cos(alpha), in);
        py = wndYAll(yy+zz*Math.sin(alpha), in);

        num1 = slow_ravnomer(25, xx, yy, zz, delta[in]);

        x1 = px - wndXMin+10;
        y1 = py - wndYMin+10;

        if(x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420)
        {
            if(mas[x1][y1] == 102)
            {
                if(420 - x1 == y1)
                {
                    if(yy > 0)
                        mas[x1][y1] = num1;
                }
                else if(zz < 0)
                    mas[x1][y1] = num1;
            }
            else{
                if(num1 < mas[x1][y1] && zz < 0)
                    mas[x1][y1] = num1;
                else if((num1 > mas[x1][y1] || mas[x1][y1] == 100) && zz > 0)
                    mas[x1][y1] = num1;
            }
        }
    }
    public void zapolnGrap(double st, double[] delta)
    {
        my3D(av[0], av[1], av[2], 0, img3D_u1All, delta);
        my3D(av[3], av[4], av[5], 1, img3D_u2All, delta);
        my3D(av[6], av[7], av[8], 2, img3D_u3All, delta);
        my3D(av[9], av[10], av[11], 3, img3D_u4All, delta);
        my3D(av[12], av[13], av[14], 4, img3D_u5All, delta);
        my3D(av[15], av[16], av[17], 5, img3D_u6All, delta);
        my3D(av[18], av[19], av[20], 6, img3D_u7All, delta);
        my3D(av[21], av[22], av[23], 7, img3D_u8All, delta);

        my3D(av[0], av[3], av[6], 8, img3D_uAll1_123, delta);
        my3D(av[1], av[4], av[7], 9, img3D_uAll2_123, delta);
        my3D(av[2], av[5], av[8], 10, img3D_uAll3_123, delta);

        my3D(av[0], av[9], av[18], 11, img3D_uAll1_147, delta);
        my3D(av[1], av[10], av[19], 12, img3D_uAll2_147, delta);
        my3D(av[2], av[11], av[20], 13, img3D_uAll3_147, delta);

        my3D(av[0], av[12], av[15], 14, img3D_uAll1_156, delta);
        my3D(av[1], av[13], av[16], 15, img3D_uAll2_156, delta);
        my3D(av[2], av[14], av[17], 16, img3D_uAll3_156, delta);

        my3D(av[3], av[9], av[15], 17, img3D_uAll1_246, delta);
        my3D(av[4], av[10], av[16], 18, img3D_uAll2_246, delta);
        my3D(av[5], av[11], av[17], 19, img3D_uAll3_246, delta);

        my3D(av[3], av[12], av[18], 20, img3D_uAll1_257, delta);
        my3D(av[4], av[13], av[19], 21, img3D_uAll2_257, delta);
        my3D(av[5], av[14], av[20], 22, img3D_uAll3_257, delta);

        double v_p;

        v_p = 0.5*(av[6]+mk3*av[21]);
        my3D(av[9], av[12], v_p, 23, img3D_uAll1_3458, delta);
        v_p = 0.5*(av[7]+mk3*av[22]);
        my3D(av[10], av[13], v_p, 24, img3D_uAll2_3458, delta);
        v_p = 0.5*(av[8]+mk3*av[23]);
        my3D(av[11], av[14], v_p, 25, img3D_uAll3_3458, delta);

        v_p = 0.5*(av[6]-mk3*av[21]);
        my3D(av[15], av[18], v_p, 26, img3D_uAll1_3678, delta);
        v_p = 0.5*(av[7]-mk3*av[22]);
        my3D(av[16], av[19], v_p, 27, img3D_uAll2_3678, delta);
        v_p = 0.5*(av[8]-mk3*av[23]);
        my3D(av[17], av[20], v_p, 28, img3D_uAll3_3678, delta);

        int num1;
        double mod1, mod2, mod3;

        mod1 = myModav(0);
        mod2 = myModav(3);
        mod3 = myModav(6);
        my3D(mod1, mod2, mod3, 29, img3D_mod123, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[29]);
        Nkslow[29][num1 - 1]++;

        mod1 = myModav(0);
        mod2 = myModav(9);
        mod3 = myModav(18);
        my3D(mod1, mod2, mod3, 30, img3D_mod147, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[30]);
        Nkslow[30][num1 - 1]++;

        mod1 = myModav(0);
        mod2 = myModav(12);
        mod3 = myModav(15);
        my3D(mod1, mod2, mod3, 31, img3D_mod156, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[31]);
        Nkslow[31][num1 - 1]++;

        mod1 = myModav(3);
        mod2 = myModav(9);
        mod3 = myModav(15);
        my3D(mod1, mod2, mod3, 32, img3D_mod246, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[32]);
        Nkslow[32][num1 - 1]++;

        mod1 = myModav(3);
        mod2 = myModav(12);
        mod3 = myModav(18);
        my3D(mod1, mod2, mod3, 33, img3D_mod257, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[33]);
        Nkslow[33][num1 - 1]++;

        mod1 = myModav(9);
        mod2 = myModav(12);

        double v_p2, v_p3;
        v_p = 0.5*(av[6]+mk3*av[21]);
        v_p2 = 0.5*(av[7]+mk3*av[22]);
        v_p3 = 0.5*(av[8]+mk3*av[23]);
        mod3 = myMod_vec(v_p, v_p2, v_p3);
        my3D(mod1, mod2, mod3, 34, img3D_mod3458, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[34]);
        Nkslow[34][num1 - 1]++;

        mod1 = myModav(15);
        mod2 = myModav(18);

        v_p = 0.5*(av[6]-mk3*av[21]);
        v_p2 = 0.5*(av[7]-mk3*av[22]);
        v_p3 = 0.5*(av[8]-mk3*av[23]);
        mod3 = myMod_vec(v_p, v_p2, v_p3);
        my3D(mod1, mod2, mod3, 35, img3D_mod3678, delta);

        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, delta100[35]);
        Nkslow[35][num1 - 1]++;

        int px, py;

        px = wndX(st, 49);

        if(utime[48][px - wndXMin + 1] == -1)
        {
            for(int j = 0; j < 48; j++)
                utime[j][px - wndXMin + 1] = av[j];
            utime[48][px - wndXMin + 1] = st;
        }

        py = wndY(EUK(), 48);
        if(py - wndYMin < 400 && py - wndYMin > -1)
            img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
	/*
		maxMin[50][0] = 0; maxMin[50][1] = 10; 
		
		py = wndY(U123(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 1;
		py = wndY(U147(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 2;
		py = wndY(U156(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 3;
		py = wndY(U246(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 4;
		py = wndY(U257(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 5;
		py = wndY(U3458(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 6;
		py = wndY(U3678(), 50);
		img_E[px - wndXMin + 1][py - wndYMin + 1] = 7;
		*/
		
		/*
		System.out.println("123 - > " + U123());
		System.out.println("147 - > " + U147());
		System.out.println("156 - > " + U156());
		System.out.println("246 - > " + U246());
		System.out.println("257 - > " + U257());
		System.out.println("3458 - > " + U3458());
		System.out.println("3678 - > " + U3678());
		*/

        //System.out.println("U - > " + U());
        //System.out.println("RU - > " + RU());
        //System.out.println("sum - > " + (double)(U123()+U147()+U156()+U246()+U257()+U3458()+U3678()));

        for(int i = 0; i < 8; i++)
        {
            num1 = slow_ravnomer(SLOW_CONST, av[i*3], av[i*3+1], av[i*3+2], delta100[i]);
            Nkslow[i][num1 - 1]++;
        }

        double x1, y1, z1;
        for(int i = 0; i < 3; i++)
        {
            num1 = slow_ravnomer(SLOW_CONST, av[i], av[i+3], av[i+6], delta100[8+i]);
            Nkslow[8+i][num1 - 1]++;
            num1 = slow_ravnomer(SLOW_CONST, av[i], av[i+9], av[i+18], delta100[8+i+3]);
            Nkslow[8+i+3][num1 - 1]++;
            num1 = slow_ravnomer(SLOW_CONST, av[i], av[i+12], av[i+15], delta100[8+i+6]);
            Nkslow[8+i+6][num1 - 1]++;
            num1 = slow_ravnomer(SLOW_CONST, av[i+3], av[i+9], av[i+15], delta100[8+i+9]);
            Nkslow[8+i+9][num1 - 1]++;
            num1 = slow_ravnomer(SLOW_CONST, av[i+3], av[i+12], av[i+18], delta100[8+i+12]);
            Nkslow[8+i+12][num1 - 1]++;

            x1 = av[i+9]; y1 = av[12+i]; z1 = 0.5*(av[i+6]+mk3*av[21+i]);
            num1 = slow_ravnomer(SLOW_CONST, x1, y1, z1, delta100[8+i+15]);
            Nkslow[8+i+15][num1 - 1]++;

            x1 = av[i+15]; y1 = av[18+i]; z1 = 0.5*(av[i+6]-mk3*av[21+i]);
            num1 = slow_ravnomer(SLOW_CONST, x1, y1, z1, delta100[8+i+18]);
            Nkslow[8+i+18][num1 - 1]++;
        }

        py = wndY(av[0], 0);
        img_u11[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[1], 1);
        img_u12[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[2], 2);
        img_u13[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[3], 3);
        img_u21[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[4], 4);
        img_u22[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[5], 5);
        img_u23[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[6], 6);
        img_u31[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[7], 7);
        img_u32[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[8], 8);
        img_u33[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[9], 9);
        img_u41[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[10], 10);
        img_u42[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[11], 11);
        img_u43[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[12], 12);
        img_u51[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[13], 13);
        img_u52[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[14], 14);
        img_u53[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[15], 15);
        img_u61[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[16], 16);
        img_u62[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[17], 17);
        img_u63[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[18], 18);
        img_u71[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[19], 19);
        img_u72[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[20], 20);
        img_u73[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[21], 21);
        img_u81[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[22], 22);
        img_u82[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[23], 23);
        img_u83[px - wndXMin + 1][py - wndYMin + 1] = 1;

        int pz;

        py = wndY(av[24], 24);
        pz = wndX(av[0], 0);
        img_uc11[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf11[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[25], 25);
        pz = wndX(av[1], 1);
        img_uc12[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf12[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[26], 26);
        pz = wndX(av[2], 2);
        img_uc13[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf13[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[27], 27);
        pz = wndX(av[3], 3);
        img_uc21[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf21[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[28], 28);
        pz = wndX(av[4], 4);
        img_uc22[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf22[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[29], 29);
        pz = wndX(av[5], 5);
        img_uc23[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf23[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[30], 30);
        pz = wndX(av[6], 6);
        img_uc31[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf31[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[31], 31);
        pz = wndX(av[7], 7);
        img_uc32[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf32[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[32], 32);
        pz = wndX(av[8], 8);
        img_uc33[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf33[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[33], 33);
        pz = wndX(av[9], 9);
        img_uc41[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf41[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[34], 34);
        pz = wndX(av[10], 10);
        img_uc42[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf42[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[35], 35);
        pz = wndX(av[11], 11);
        img_uc43[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf43[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[36], 36);
        pz = wndX(av[12], 12);
        img_uc51[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf51[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[37], 37);
        pz = wndX(av[13], 13);
        img_uc52[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf52[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[38], 38);
        pz = wndX(av[14], 14);
        img_uc53[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf53[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[39], 39);
        pz = wndX(av[15], 15);
        img_uc61[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf61[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[40], 40);
        pz = wndX(av[16], 16);
        img_uc62[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf62[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[41], 41);
        pz = wndX(av[17], 17);
        img_uc63[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf63[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[42], 42);
        pz = wndX(av[18], 18);
        img_uc71[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf71[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[43], 43);
        pz = wndX(av[19], 19);
        img_uc72[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf72[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[44], 44);
        pz = wndX(av[20], 20);
        img_uc73[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf73[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[45], 45);
        pz = wndX(av[21], 21);
        img_uc81[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf81[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[46], 46);
        pz = wndX(av[22], 22);
        img_uc82[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf82[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(av[47], 47);
        pz = wndX(av[23], 23);
        img_uc83[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf83[pz - wndXMin + 1][py - wndYMin + 1] = 1;
    }
    public void osXYZ(int index)
    {
        Graphics g = getGraphics();

        g.drawLine(wndXMin, wndYAll(0,index), wndXMin+wndYMax-wndYMin + 10, wndYAll(0, index));
        g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index), wndYMax);
        g.drawLine(wndXMin, wndYMax, wndXMin + wndYMax - wndYMin + 10, wndYMin - 10);

        g.drawLine(wndXMin+wndYMax-wndYMin + 10, wndYAll(0, index), wndXMin+wndYMax-wndYMin + 10 - 5, wndYAll(0, index)+3);
        g.drawLine(wndXMin+wndYMax-wndYMin + 10, wndYAll(0, index), wndXMin+wndYMax-wndYMin + 10 - 5, wndYAll(0, index)-3);

        g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) + 3, wndYMin + 10 + 5);
        g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) - 3, wndYMin + 10 + 5);

        g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYMin - 10, wndXMin + wndYMax - wndYMin + 10 - 5, wndYMin - 10 + 7);
        g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYMin - 10, wndXMin + wndYMax - wndYMin + 10 - 7, wndYMin - 10 + 5);

    }
    public void draw_img_1(byte mas[][])
    {
        Graphics g = getGraphics();

        if(myvision < 25)
        {
            Color col = new Color(0,0,205);
            g.setColor(col);

            text_pot();
        }
        else if(myvision < 49)
        {
            Color col = new Color(139,0,0);
            g.setColor(col);

            text_ckor();
        }
        else if(myvision < 73)
        {
            Color col = new Color(153,50,204);
            g.setColor(col);
        }

        for(int j1 = 0; j1 < 602; j1++)
            for(int j2 = 0; j2 < 402; j2++)
                if(mas[j1][j2] == 1)
                    g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, point, point);
    }
    public void draw_img_3D(int mas[][])
    {
        Graphics g = getGraphics();
        int col[] = new int[3];

        for(int j1 = 0; j1 < 420; j1++)
            for(int j2 = 0; j2 < 420; j2++)
                if(mas[j1][j2] != 100)
                {
                    myNewColor(col, mas[j1][j2]);
                    Color colC = new Color(col[0], col[1], col[2]);
                    g.setColor(colC);
                    g.fillOval(j1+wndXMin-10, j2+wndYMin-10, point, point);
                }

        text3D();
    }

    public void macsh_3D(int n, int t1, int t2, int t3, int i)
    {
        uAll[n + i][1] = maxMin[(t1-1)*3 + i][1]+maxMin[(t3-1)*3 + i][1]*Math.cos(alpha);
        uAll[n + i][0] = maxMin[(t1-1)*3 + i][0]+maxMin[(t3-1)*3 + i][0]*Math.cos(alpha);
        uAll[n + i][3] = maxMin[(t2-1)*3 + i][1]+maxMin[(t3-1)*3 + i][1]*Math.sin(alpha);
        uAll[n + i][2] = maxMin[(t2-1)*3 + i][0]+maxMin[(t3-1)*3 + i][0]*Math.sin(alpha);

        norm(n + i);
    }
    public void macsh_3D_4(int n, int s, int t2, int t3, int i)
    {
        double Vmax, Vmin;
        if(s == 1)
        {
            Vmax = 0.5*(maxMin[6 + i][1]+s*mk3*maxMin[21 + i][1]);
            Vmin = 0.5*(maxMin[6 + i][0]+s*mk3*maxMin[21 + i][0]);
        }
        else
        {
            Vmax = 0.5*(maxMin[6 + i][1]+s*mk3*maxMin[21 + i][0]);
            Vmin = 0.5*(maxMin[6 + i][0]+s*mk3*maxMin[21 + i][1]);
        }
        uAll[n + i][1] = Vmax+maxMin[(t3-1)*3 + i][1]*Math.cos(alpha);
        uAll[n + i][0] = Vmin+maxMin[(t3-1)*3 + i][0]*Math.cos(alpha);
        uAll[n + i][3] = maxMin[(t2-1)*3 + i][1]+maxMin[(t3-1)*3 + i][1]*Math.sin(alpha);
        uAll[n + i][2] = maxMin[(t2-1)*3 + i][0]+maxMin[(t3-1)*3 + i][0]*Math.sin(alpha);

        norm(n + i);
    }
    public void macsh_3D_mod(int n, int t1, int t2, int t3)
    {
        double mod1, mod2, mod3;

        mod1 = myMod((t1-1)*3,24);
        mod2 = myMod((t2-1)*3,24);
        mod3 = myMod((t3-1)*3,24);

        uAll[n][3] = mod2+mod3*Math.sin(alpha);
        uAll[n][1] = mod1+mod3*Math.cos(alpha);

        mod1 = myMod((t1-1)*3,0);
        mod2 = myMod((t2-1)*3,0);
        mod3 = myMod((t3-1)*3,0);

        uAll[n][2] = mod2+mod3*Math.sin(alpha);
        uAll[n][0] = mod1+mod3*Math.cos(alpha);

        norm(n);
    }
    public void macsh_3D_mod_4(int n, int s, int t2, int t3)
    {
        double mod1, mod2, mod3;
        double Vmax1, Vmin1, Vmax2, Vmin2, Vmax3, Vmin3;

        if(s == 1)
        {
            Vmax1 = 0.5*(maxMin[6][1]+s*mk3*maxMin[21][1]);
            Vmin1 = 0.5*(maxMin[6][0]+s*mk3*maxMin[21][0]);
            Vmax2 = 0.5*(maxMin[6+1][1]+s*mk3*maxMin[21+1][1]);
            Vmin2 = 0.5*(maxMin[6+1][0]+s*mk3*maxMin[21+1][0]);
            Vmax3 = 0.5*(maxMin[6+2][1]+s*mk3*maxMin[21+2][1]);
            Vmin3 = 0.5*(maxMin[6+2][0]+s*mk3*maxMin[21+2][0]);
        }
        else
        {
            Vmax1 = 0.5*(maxMin[6][1]+s*mk3*maxMin[21][0]);
            Vmin1 = 0.5*(maxMin[6][0]+s*mk3*maxMin[21][1]);
            Vmax2 = 0.5*(maxMin[6+1][1]+s*mk3*maxMin[21+1][0]);
            Vmin2 = 0.5*(maxMin[6+1][0]+s*mk3*maxMin[21+1][1]);
            Vmax3 = 0.5*(maxMin[6+2][1]+s*mk3*maxMin[21+2][0]);
            Vmin3 = 0.5*(maxMin[6+2][0]+s*mk3*maxMin[21+2][1]);
        }

        mod1 = myMax3(Vmax1, Vmax2, Vmax3);
        mod1 = Math.signum(mod1)*Math.sqrt(Vmax1*Vmax1 + Vmax2*Vmax2 + Vmax3*Vmax3);
        mod2 = myMod((t2-1)*3,24);
        mod3 = myMod((t3-1)*3,24);

        uAll[n][3] = mod2+mod3*Math.sin(alpha);
        uAll[n][1] = mod1+mod3*Math.cos(alpha);

        mod1 = myMax3(Vmin1, Vmin2, Vmin3);
        mod1 = Math.signum(mod1)*Math.sqrt(Vmin1*Vmin1 + Vmin2*Vmin2 + Vmin3*Vmin3);
        mod2 = myMod((t2-1)*3,0);
        mod3 = myMod((t3-1)*3,0);

        uAll[n][2] = mod2+mod3*Math.sin(alpha);
        uAll[n][0] = mod1+mod3*Math.cos(alpha);

        norm(n);
    }
    public void zym()
    {
        clear();

        Graphics g = getGraphics();

        double istart, iend;

        if(mouse[myvision] == 1)
        {
            if(XDown < XUp)
            {
                istart = utime[48][XDown - wndXMin + 1];
                iend = utime[48][XUp - wndXMin + 1];

                for(int i = 0; i < 48; i++)
                    av[i] = utime[i][XDown - wndXMin + 1];
            }
            else
            {
                iend = utime[48][XDown - wndXMin + 1];
                istart = utime[48][XUp - wndXMin + 1];

                for(int i = 0; i < 48; i++)
                    av[i] = utime[i][XUp - wndXMin + 1];
            }
        }
        else
        {
            if(XDown < XUp)
            {
                istart = utimezym[48][XDown - wndXMin + 1];
                iend = utimezym[48][XUp - wndXMin + 1];

                for(int i = 0; i < 48; i++)
                    av[i] = utimezym[i][XDown - wndXMin + 1];
            }
            else
            {
                iend = utimezym[48][XDown - wndXMin + 1];
                istart = utimezym[48][XUp - wndXMin + 1];

                for(int i = 0; i < 48; i++)
                    av[i] = utimezym[i][XUp - wndXMin + 1];
            }
        }

        if(myvision != 0)
        {
            maxMin[50][0] = istart; maxMin[50][1] = iend;

            int index = myvision - 1;

            if(YDown > YUp)
            {
                maxMin[51][0] = obrwndY(YDown, index);
                maxMin[51][1] = obrwndY(YUp, index);
            }
            else
            {
                maxMin[51][1] = obrwndY(YDown, index);
                maxMin[51][0] = obrwndY(YUp, index);
            }

            for(int j1 = 0; j1 < 49; j1++)
                for(int j2 = 0; j2 < 602; j2++)
                    utimezym[j1][j2] = -1;

            if(myvision < 25)
            {
                Color col = new Color(0,0,205);
                g.setColor(col);
            }
            else
            {
                Color col = new Color(139,0,0);
                g.setColor(col);
            }

            System.out.println("x : " + maxMin[50][0]+ "   "+maxMin[50][1]);
            System.out.println("y : " + maxMin[51][0]+ "   "+maxMin[51][1]);

            shcala(50, 51);

            int px;
            while (istart < iend)
            {
                schetstep();

                if(av[index] >= maxMin[51][0] && av[index] <= maxMin[51][1])
                    g.fillOval(wndX(istart, 50), wndY(av[index], 51), point, point);

                px = wndX(istart, 50);
                if(utimezym[48][px - wndXMin + 1] == -1)
                {
                    for(int j = 0; j < 48; j++)
                        utimezym[j][px - wndXMin + 1] = av[j];
                    utimezym[48][px - wndXMin + 1] = istart;
                }
                istart+=h;
            }
        }
        mouse[myvision] = 2;
    }
    public void myNewColor(int[] col, int num)
    {
        if(num == 102)
        {	col[0] = 0; col[1] = 0; col[2] = 0;}
        else if(num == 1)
        {	col[0] = 85; col[1] = 26; col[2] = 139;}
        else if(num == 2)
        {	col[0] = 0; col[1] = 0; col[2] = 205;}
        else if(num == 3)
        {	col[0] = 58; col[1] = 95; col[2] = 205;}
        else if(num == 4)
        {	col[0] = 72; col[1] = 118; col[2] = 255;}
        else if(num == 5)
        {	col[0] = 32; col[1] = 178; col[2] = 170;}
        else if(num == 6)
        {	col[0] = 142; col[1] = 229; col[2] = 238;}
        else if(num == 7)
        {	col[0] = 135; col[1] = 206; col[2] = 250;}
        else if(num == 8)
        {	col[0] = 164; col[1] = 211; col[2] = 238;}
        else if(num == 9)
        {	col[0] = 176; col[1] = 226; col[2] = 255;}
        else if(num == 10)
        {	col[0] = 0; col[1] = 255; col[2] = 255;}
        else if(num == 11)
        {	col[0] = 0; col[1] = 100; col[2] = 0;}
        else if(num == 12)
        {	col[0] = 34; col[1] = 139; col[2] = 34;}
        else if(num == 13)
        {	col[0] = 50; col[1] = 205; col[2] = 50;}
        else if(num == 14)
        {	col[0] = 124; col[1] = 252; col[2] = 0;}
        else if(num == 15)
        {	col[0] = 173; col[1] = 255; col[2] = 47;}
        else if(num == 16)
        {	col[0] = 255; col[1] = 255; col[2] = 0;}
        else if(num == 17)
        {	col[0] = 255; col[1] = 215; col[2] = 0;}
        else if(num == 18)
        {	col[0] = 255; col[1] = 193; col[2] = 37;}
        else if(num == 19)
        {	col[0] = 255; col[1] = 127; col[2] = 0;}
        else if(num == 20)
        {	col[0] = 238; col[1] = 118; col[2] = 0;}
        else if(num == 21)
        {	col[0] = 205; col[1] = 102; col[2] = 0;}
        else if(num == 22)
        {	col[0] = 255; col[1] = 69; col[2] = 0;}
        else if(num == 23)
        {	col[0] = 238; col[1] = 0; col[2] = 0;}
        else if(num == 24)
        {	col[0] = 205; col[1] = 0; col[2] = 0;}
        else
        {	col[0] = 139; col[1] = 0; col[2] = 0;}
    }
    public void myNewColor8(int[] col, int num)
    {
        if(num == 1)
        {	col[0] = 238; col[1] = 0; col[2] = 0;}
        else if(num == 2)
        {	col[0] = 255; col[1] = 185; col[2] = 15;}
        else if(num == 3)
        {	col[0] = 255; col[1] = 255; col[2] = 0;}
        else if(num == 4)
        {	col[0] = 179; col[1] = 238; col[2] = 58;}
        else if(num == 5)
        {	col[0] = 0; col[1] = 139; col[2] = 0;}
        else if(num == 6)
        {	col[0] = 141; col[1] = 238; col[2] = 238;}
        else if(num == 7)
        {	col[0] = 0; col[1] = 0; col[2] = 205;}
        else
        {	col[0] = 104; col[1] = 34; col[2] = 139;}
    }

    public void text(String str1, String str2, String str3)
    {
        Graphics g = getGraphics();

        Image img1;
        img1 = getImage(getCodeBase(), str1);
        g.drawImage(img1, wndXMin+95, wndYMax+38, this);
        img1 = getImage(getCodeBase(), str2);
        g.drawImage(img1, wndXMin+135, wndYMax+38, this);
        img1 = getImage(getCodeBase(), str3);
        g.drawImage(img1, wndXMin+170, wndYMax+38, this);
    }
    public void text1(String str1, String str2, String str3)
    {
        Graphics g = getGraphics();

        Image img1;
        img1 = getImage(getCodeBase(), str1);
        g.drawImage(img1, wndXMin+198, wndYMax+45, this);
        img1 = getImage(getCodeBase(), str2);
        g.drawImage(img1, wndXMin+235, wndYMax+45, this);
        img1 = getImage(getCodeBase(), str3);
        g.drawImage(img1, wndXMin+272, wndYMax+45, this);
    }

    public void text3D()
    {
        Graphics g = getGraphics();

        Image img1;
        img1 = getImage(getCodeBase(),"3D.jpg");
        g.drawImage(img1, wndXMin - 20, wndYMax+20, this);

        if(myvision == 73)
            text("u11.jpg", "u12.jpg", "u13.jpg");
        else if(myvision == 74)
            text("u21.jpg", "u22.jpg", "u23.jpg");
        else if(myvision == 75)
            text("u31.jpg", "u32.jpg", "u33.jpg");
        else if(myvision == 76)
            text("u41.jpg", "u42.jpg", "u43.jpg");
        else if(myvision == 77)
            text("u51.jpg", "u52.jpg", "u53.jpg");
        else if(myvision == 78)
            text("u61.jpg", "u62.jpg", "u63.jpg");
        else if(myvision == 79)
            text("u71.jpg", "u72.jpg", "u73.jpg");
        else if(myvision == 80)
            text("u81.jpg", "u82.jpg", "u83.jpg");
        else if(myvision == 81)
            text("u11.jpg", "u21.jpg", "u31.jpg");
        else if(myvision == 82)
            text("u12.jpg", "u22.jpg", "u32.jpg");
        else if(myvision == 83)
            text("u13.jpg", "u23.jpg", "u33.jpg");
        else if(myvision == 84)
            text("u11.jpg", "u41.jpg", "u71.jpg");
        else if(myvision == 85)
            text("u12.jpg", "u42.jpg", "u72.jpg");
        else if(myvision == 86)
            text("u13.jpg", "u43.jpg", "u73.jpg");
        else if(myvision == 87)
            text("u11.jpg", "u51.jpg", "u61.jpg");
        else if(myvision == 88)
            text("u12.jpg", "u52.jpg", "u62.jpg");
        else if(myvision == 89)
            text("u13.jpg", "u53.jpg", "u63.jpg");
        else if(myvision == 90)
            text("u21.jpg", "u41.jpg", "u61.jpg");
        else if(myvision == 91)
            text("u22.jpg", "u42.jpg", "u62.jpg");
        else if(myvision == 92)
            text("u23.jpg", "u43.jpg", "u63.jpg");
        else if(myvision == 93)
            text("u21.jpg", "u51.jpg", "u71.jpg");
        else if(myvision == 94)
            text("u22.jpg", "u52.jpg", "u72.jpg");
        else if(myvision == 95)
            text("u23.jpg", "u53.jpg", "u73.jpg");
        else if(myvision == 96)
            text("u41.jpg", "u51.jpg", "v+1.jpg");
        else if(myvision == 97)
            text("u42.jpg", "u52.jpg", "v+2.jpg");
        else if(myvision == 98)
            text("u43.jpg", "u53.jpg", "v+3.jpg");
        else if(myvision == 99)
            text("u61.jpg", "u71.jpg", "v-1.jpg");
        else if(myvision == 100)
            text("u62.jpg", "u72.jpg", "v-2.jpg");
        else if(myvision == 101)
            text("u63.jpg", "u73.jpg", "v-3.jpg");
        else if(myvision == 102)
            text("u1.jpg", "u2.jpg", "u3.jpg");
        else if(myvision == 103)
            text("u1.jpg", "u4.jpg", "u7.jpg");
        else if(myvision == 104)
            text("u1.jpg", "u5.jpg", "u6.jpg");
        else if(myvision == 105)
            text("u2.jpg", "u4.jpg", "u6.jpg");
        else if(myvision == 106)
            text("u2.jpg", "u5.jpg", "u7.jpg");
        else if(myvision == 107)
            text("u4.jpg", "u5.jpg", "v+.jpg");
        else if(myvision == 108)
            text("u6.jpg", "u7.jpg", "v-.jpg");
    }

    public void text_pot()
    {
        Graphics g = getGraphics();

        Image img1;
        img1 = getImage(getCodeBase(),"strelka.jpg");
        g.drawImage(img1, wndXMin+10, wndYMin + 8, this);

        img1 = getImage(getCodeBase(),"time.jpg");
        g.drawImage(img1, wndXMax-60, wndYMax-30, this);

        img1 = getImage(getCodeBase(),"pot.jpg");
        g.drawImage(img1, wndXMin+20, wndYMax+20, this);

        if(myvision == 1)
            img1 = getImage(getCodeBase(),"u11.jpg");
        else if(myvision == 2)
            img1 = getImage(getCodeBase(),"u12.jpg");
        else if(myvision == 3)
            img1 = getImage(getCodeBase(),"u13.jpg");
        else if(myvision == 4)
            img1 = getImage(getCodeBase(),"u21.jpg");
        else if(myvision == 5)
            img1 = getImage(getCodeBase(),"u22.jpg");
        else if(myvision == 6)
            img1 = getImage(getCodeBase(),"u23.jpg");
        else if(myvision == 7)
            img1 = getImage(getCodeBase(),"u31.jpg");
        else if(myvision == 8)
            img1 = getImage(getCodeBase(),"u32.jpg");
        else if(myvision == 9)
            img1 = getImage(getCodeBase(),"u33.jpg");
        else if(myvision == 10)
            img1 = getImage(getCodeBase(),"u41.jpg");
        else if(myvision == 11)
            img1 = getImage(getCodeBase(),"u42.jpg");
        else if(myvision == 12)
            img1 = getImage(getCodeBase(),"u43.jpg");
        else if(myvision == 13)
            img1 = getImage(getCodeBase(),"u51.jpg");
        else if(myvision == 14)
            img1 = getImage(getCodeBase(),"u52.jpg");
        else if(myvision == 15)
            img1 = getImage(getCodeBase(),"u53.jpg");
        else if(myvision == 16)
            img1 = getImage(getCodeBase(),"u61.jpg");
        else if(myvision == 17)
            img1 = getImage(getCodeBase(),"u62.jpg");
        else if(myvision == 18)
            img1 = getImage(getCodeBase(),"u63.jpg");
        else if(myvision == 19)
            img1 = getImage(getCodeBase(),"u71.jpg");
        else if(myvision == 20)
            img1 = getImage(getCodeBase(),"u72.jpg");
        else if(myvision == 21)
            img1 = getImage(getCodeBase(),"u73.jpg");
        else if(myvision == 22)
            img1 = getImage(getCodeBase(),"u81.jpg");
        else if(myvision == 23)
            img1 = getImage(getCodeBase(),"u82.jpg");
        else
            img1 = getImage(getCodeBase(),"u83.jpg");

        g.drawImage(img1, wndXMin+390, wndYMax + 21, this);
        g.drawImage(img1, wndXMin+20, wndYMin + 20, this);
    }

    public void text_ckor()
    {
        Graphics g = getGraphics();

        Image img1;
        img1 = getImage(getCodeBase(),"strelka.jpg");
        g.drawImage(img1, wndXMin+10, wndYMin + 8, this);

        img1 = getImage(getCodeBase(),"time.jpg");
        g.drawImage(img1, wndXMax-60, wndYMax-30, this);

        img1 = getImage(getCodeBase(),"ckor.jpg");
        g.drawImage(img1, wndXMin+20, wndYMax+20, this);

        if(myvision == 25)
            img1 = getImage(getCodeBase(),"u11c.jpg");
        else if(myvision == 26)
            img1 = getImage(getCodeBase(),"u12c.jpg");
        else if(myvision == 27)
            img1 = getImage(getCodeBase(),"u13c.jpg");
        else if(myvision == 28)
            img1 = getImage(getCodeBase(),"u21c.jpg");
        else if(myvision == 29)
            img1 = getImage(getCodeBase(),"u22c.jpg");
        else if(myvision == 30)
            img1 = getImage(getCodeBase(),"u23c.jpg");
        else if(myvision == 31)
            img1 = getImage(getCodeBase(),"u31c.jpg");
        else if(myvision == 32)
            img1 = getImage(getCodeBase(),"u32c.jpg");
        else if(myvision == 33)
            img1 = getImage(getCodeBase(),"u33c.jpg");
        else if(myvision == 34)
            img1 = getImage(getCodeBase(),"u41c.jpg");
        else if(myvision == 35)
            img1 = getImage(getCodeBase(),"u42c.jpg");
        else if(myvision == 36)
            img1 = getImage(getCodeBase(),"u43c.jpg");
        else if(myvision == 37)
            img1 = getImage(getCodeBase(),"u51c.jpg");
        else if(myvision == 38)
            img1 = getImage(getCodeBase(),"u52c.jpg");
        else if(myvision == 39)
            img1 = getImage(getCodeBase(),"u53c.jpg");
        else if(myvision == 40)
            img1 = getImage(getCodeBase(),"u61c.jpg");
        else if(myvision == 41)
            img1 = getImage(getCodeBase(),"u62c.jpg");
        else if(myvision == 42)
            img1 = getImage(getCodeBase(),"u63c.jpg");
        else if(myvision == 43)
            img1 = getImage(getCodeBase(),"u71c.jpg");
        else if(myvision == 44)
            img1 = getImage(getCodeBase(),"u72c.jpg");
        else if(myvision == 45)
            img1 = getImage(getCodeBase(),"u73c.jpg");
        else if(myvision == 46)
            img1 = getImage(getCodeBase(),"u81c.jpg");
        else if(myvision == 47)
            img1 = getImage(getCodeBase(),"u82c.jpg");
        else
            img1 = getImage(getCodeBase(),"u83c.jpg");

        g.drawImage(img1, wndXMin+20, wndYMin + 20, this);
        g.drawImage(img1, wndXMin+450, wndYMax + 18, this);
    }

    public void text_plot()
    {
        Graphics g = getGraphics();

        Image img1;

        img1 = getImage(getCodeBase(),"p_slow.jpg");
        g.drawImage(img1, wndXMin-35, wndYMax+15, this);

        img1 = getImage(getCodeBase(),"rk.jpg");
        g.drawImage(img1, wndXMax-60, wndYMax-33, this);

        if(myvision == 111)
        {
            text1("u11.jpg", "u12.jpg", "u13.jpg");
            img1 = getImage(getCodeBase(),"lg1p.jpg");
        }
        else if(myvision == 112)
        {
            text1("u21.jpg", "u22.jpg", "u23.jpg");
            img1 = getImage(getCodeBase(),"lg2p.jpg");
        }
        else if(myvision == 113)
        {
            text1("u31.jpg", "u32.jpg", "u33.jpg");
            img1 = getImage(getCodeBase(),"lg3p.jpg");
        }
        else if(myvision == 114)
        {
            text1("u41.jpg", "u42.jpg", "u43.jpg");
            img1 = getImage(getCodeBase(),"lg4p.jpg");
        }
        else if(myvision == 115)
        {
            text1("u51.jpg", "u52.jpg", "u53.jpg");
            img1 = getImage(getCodeBase(),"lg5p.jpg");
        }
        else if(myvision == 116)
        {
            text1("u61.jpg", "u62.jpg", "u63.jpg");
            img1 = getImage(getCodeBase(),"lg6p.jpg");
        }
        else if(myvision == 117)
        {
            text1("u71.jpg", "u72.jpg", "u73.jpg");
            img1 = getImage(getCodeBase(),"lg7p.jpg");
        }
        else if(myvision == 118)
        {
            text1("u81.jpg", "u82.jpg", "u83.jpg");
            img1 = getImage(getCodeBase(),"lg8p.jpg");
        }
        else if(myvision == 119)
        {
            text1("u11.jpg", "u21.jpg", "u31.jpg");
            img1 = getImage(getCodeBase(),"lg123_1.jpg");
        }
        else if(myvision == 120)
        {
            text1("u12.jpg", "u22.jpg", "u32.jpg");
            img1 = getImage(getCodeBase(),"lg123_2.jpg");
        }
        else if(myvision == 121)
        {
            text1("u13.jpg", "u23.jpg", "u33.jpg");
            img1 = getImage(getCodeBase(),"lg123_3.jpg");
        }
        else if(myvision == 122)
        {
            text1("u11.jpg", "u41.jpg", "u71.jpg");
            img1 = getImage(getCodeBase(),"lg147_1.jpg");
        }
        else if(myvision == 123)
        {
            text1("u12.jpg", "u42.jpg", "u72.jpg");
            img1 = getImage(getCodeBase(),"lg147_2.jpg");
        }
        else if(myvision == 124)
        {
            text1("u13.jpg", "u43.jpg", "u73.jpg");
            img1 = getImage(getCodeBase(),"lg147_3.jpg");
        }
        else if(myvision == 125)
        {
            text1("u11.jpg", "u51.jpg", "u61.jpg");
            img1 = getImage(getCodeBase(),"lg156_1.jpg");
        }
        else if(myvision == 126)
        {
            text1("u12.jpg", "u52.jpg", "u62.jpg");
            img1 = getImage(getCodeBase(),"lg156_2.jpg");
        }
        else if(myvision == 127)
        {
            text1("u13.jpg", "u53.jpg", "u63.jpg");
            img1 = getImage(getCodeBase(),"lg156_3.jpg");
        }
        else if(myvision == 128)
        {
            text1("u21.jpg", "u41.jpg", "u61.jpg");
            img1 = getImage(getCodeBase(),"lg246_1.jpg");
        }
        else if(myvision == 129)
        {
            text1("u22.jpg", "u42.jpg", "u62.jpg");
            img1 = getImage(getCodeBase(),"lg246_2.jpg");
        }
        else if(myvision == 130)
        {
            text1("u23.jpg", "u43.jpg", "u63.jpg");
            img1 = getImage(getCodeBase(),"lg246_3.jpg");
        }
        else if(myvision == 131)
        {
            text1("u21.jpg", "u51.jpg", "u71.jpg");
            img1 = getImage(getCodeBase(),"lg257_1.jpg");
        }
        else if(myvision == 132)
        {
            text1("u22.jpg", "u52.jpg", "u72.jpg");
            img1 = getImage(getCodeBase(),"lg257_2.jpg");
        }
        else if(myvision == 133)
        {
            text1("u23.jpg", "u53.jpg", "u73.jpg");
            img1 = getImage(getCodeBase(),"lg257_3.jpg");
        }
        else if(myvision == 134)
        {
            text1("u41.jpg", "u51.jpg", "v+1.jpg");
            img1 = getImage(getCodeBase(),"lg3458_1.jpg");
        }
        else if(myvision == 135)
        {
            text1("u42.jpg", "u52.jpg", "v+2.jpg");
            img1 = getImage(getCodeBase(),"lg3458_2.jpg");
        }
        else if(myvision == 136)
        {
            text1("u43.jpg", "u53.jpg", "v+3.jpg");
            img1 = getImage(getCodeBase(),"lg3458_3.jpg");
        }
        else if(myvision == 137)
        {
            text1("u61.jpg", "u71.jpg", "v-1.jpg");
            img1 = getImage(getCodeBase(),"lg3678_1.jpg");
        }
        else if(myvision == 138)
        {
            text1("u62.jpg", "u72.jpg", "v-2.jpg");
            img1 = getImage(getCodeBase(),"lg3678_2.jpg");
        }
        else if(myvision == 139)
        {
            text1("u63.jpg", "u73.jpg", "v-3.jpg");
            img1 = getImage(getCodeBase(),"lg3678_3.jpg");
        }
        else if(myvision == 140)
        {
            text1("u1.jpg", "u2.jpg", "u3.jpg");
            img1 = getImage(getCodeBase(),"lg123.jpg");
        }
        else if(myvision == 141)
        {
            text1("u1.jpg", "u4.jpg", "u7.jpg");
            img1 = getImage(getCodeBase(),"lg147.jpg");
        }
        else if(myvision == 142)
        {
            text1("u1.jpg", "u5.jpg", "u6.jpg");
            img1 = getImage(getCodeBase(),"lg156.jpg");
        }
        else if(myvision == 143)
        {
            text1("u2.jpg", "u4.jpg", "u6.jpg");
            img1 = getImage(getCodeBase(),"lg246.jpg");
        }
        else if(myvision == 144)
        {
            text1("u2.jpg", "u5.jpg", "u7.jpg");
            img1 = getImage(getCodeBase(),"lg257.jpg");
        }
        else if(myvision == 145)
        {
            text1("u4.jpg", "u5.jpg", "v+.jpg");
            img1 = getImage(getCodeBase(),"lg3458.jpg");
        }
        else if(myvision == 146)
        {
            text1("u6.jpg", "u7.jpg", "v-.jpg");
            img1 = getImage(getCodeBase(),"lg3678.jpg");
        }

        g.drawImage(img1, wndXMin+10, wndYMin + 3, this);
    }
}


