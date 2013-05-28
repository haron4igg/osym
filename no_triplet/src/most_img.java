import java.applet.*;
import java.awt.*;
import java.awt.List;
import java.io.*;

public class most_img extends Applet {

    TextField tbend, step, kadrstart, kadrend;
    Label time, Texttime1, Texttime2, Textstep, Textstart, Textvision;
    Choice metod;
    List vision;
    Button Butt1;
    Checkbox kadr;
    Checkbox mostfile;

    CheckboxGroup grup;
    Checkbox poten, scor, nonull, mystart;

    int mp = 17;
    int startpoint = 1, mymetod = 0, myvision = 0, first = 0, mykadr = 0, myfile = 0;

    double PI = 3.14159265358979323;
    double alpha = 45 * PI / 180;
    double TOCH = -12.0;
    int SLOW_CONST = 100;
    double Q100 = 1.059306;
    double sl = 3;

    double c[] = new double[mp];
    double b[][] = new double[mp][mp - 1];

    int ta = 0, tb = 10, ts, te;
    double h = 1e-4;
    long Nh = 0, tstart, tend;

    double input[] = new double[18];
    double avstart[] = new double[18];
    double avlast[] = new double[18];

    int Nmas = 2500000;
    int gol = 0, inu = 0, ucconst = 10000, uconst = 100;

    double umas[][] = new double[18][2 * uconst + 1];
    double negol[][] = new double[4][Nmas];
    double maxMin[][] = new double[22][2];
    double MaxMin[][] = new double[18][9];

    double delta100[] = new double[7];
    int Nkslow[][] = new int[7][SLOW_CONST];
    double Pk[][] = new double[7][SLOW_CONST];
    double Pk20[][] = new double[7][SLOW_CONST];
    double PkN[][] = new double[7][SLOW_CONST];
    double Pc[][] = new double[6][7];
    int luch[][] = new int[7][6];
    double stepen[][] = new double[7][SLOW_CONST];

    int img3D_u1All[][] = new int[420][420];
    int img3D_u2All[][] = new int[420][420];
    int img3D_u3All[][] = new int[420][420];
    int img3D_uAll1[][] = new int[420][420];
    int img3D_uAll2[][] = new int[420][420];
    int img3D_uAll3[][] = new int[420][420];
    int img3D_mod[][] = new int[420][420];

    int imgD3_u1All[][] = new int[420][420];
    int imgD3_u2All[][] = new int[420][420];
    int imgD3_u3All[][] = new int[420][420];
    int imgD3_uAll1[][] = new int[420][420];
    int imgD3_uAll2[][] = new int[420][420];
    int imgD3_uAll3[][] = new int[420][420];
    int imgD3_mod[][] = new int[420][420];

    byte img_u11[][] = new byte[602][402];
    byte img_u12[][] = new byte[602][402];
    byte img_u13[][] = new byte[602][402];
    byte img_u21[][] = new byte[602][402];
    byte img_u22[][] = new byte[602][402];
    byte img_u23[][] = new byte[602][402];
    byte img_u31[][] = new byte[602][402];
    byte img_u32[][] = new byte[602][402];
    byte img_u33[][] = new byte[602][402];

    byte img_uc11[][] = new byte[602][402];
    byte img_uc12[][] = new byte[602][402];
    byte img_uc13[][] = new byte[602][402];
    byte img_uc21[][] = new byte[602][402];
    byte img_uc22[][] = new byte[602][402];
    byte img_uc23[][] = new byte[602][402];
    byte img_uc31[][] = new byte[602][402];
    byte img_uc32[][] = new byte[602][402];
    byte img_uc33[][] = new byte[602][402];

    byte img_uf11[][] = new byte[602][402];
    byte img_uf12[][] = new byte[602][402];
    byte img_uf13[][] = new byte[602][402];
    byte img_uf21[][] = new byte[602][402];
    byte img_uf22[][] = new byte[602][402];
    byte img_uf23[][] = new byte[602][402];
    byte img_uf31[][] = new byte[602][402];
    byte img_uf32[][] = new byte[602][402];
    byte img_uf33[][] = new byte[602][402];

    int img_EUK[][] = new int[602][402];

    double utime[][] = new double[19][602];
    double utimezym[][] = new double[19][602];

    int wndXMin = 400, wndYMin = 50, wndXMax = 1000, wndYMax = 450;
    double uAll[][] = new double[70][4];
    int sizeX = 1050, sizeY = 520, sizePanel = (int) (wndXMin) - 100;

    int XDown, YDown, XUp, YUp;
    byte mouse[] = new byte[19];


    // временно 8 октантов

    byte D8_u1All_1[][] = new byte[420][420];
    byte D8_u1All_2[][] = new byte[420][420];
    byte D8_u1All_3[][] = new byte[420][420];
    byte D8_u1All_4[][] = new byte[420][420];
    byte D8_u1All_5[][] = new byte[420][420];
    byte D8_u1All_6[][] = new byte[420][420];
    byte D8_u1All_7[][] = new byte[420][420];
    byte D8_u1All_8[][] = new byte[420][420];
    byte D8_u1All[][] = new byte[602][402];

    byte D8_u2All_1[][] = new byte[420][420];
    byte D8_u2All_2[][] = new byte[420][420];
    byte D8_u2All_3[][] = new byte[420][420];
    byte D8_u2All_4[][] = new byte[420][420];
    byte D8_u2All_5[][] = new byte[420][420];
    byte D8_u2All_6[][] = new byte[420][420];
    byte D8_u2All_7[][] = new byte[420][420];
    byte D8_u2All_8[][] = new byte[420][420];
    byte D8_u2All[][] = new byte[602][402];

    byte D8_u3All_1[][] = new byte[420][420];
    byte D8_u3All_2[][] = new byte[420][420];
    byte D8_u3All_3[][] = new byte[420][420];
    byte D8_u3All_4[][] = new byte[420][420];
    byte D8_u3All_5[][] = new byte[420][420];
    byte D8_u3All_6[][] = new byte[420][420];
    byte D8_u3All_7[][] = new byte[420][420];
    byte D8_u3All_8[][] = new byte[420][420];
    byte D8_u3All[][] = new byte[602][402];

    byte D8_uAll1_1[][] = new byte[420][420];
    byte D8_uAll1_2[][] = new byte[420][420];
    byte D8_uAll1_3[][] = new byte[420][420];
    byte D8_uAll1_4[][] = new byte[420][420];
    byte D8_uAll1_5[][] = new byte[420][420];
    byte D8_uAll1_6[][] = new byte[420][420];
    byte D8_uAll1_7[][] = new byte[420][420];
    byte D8_uAll1_8[][] = new byte[420][420];
    byte D8_uAll1[][] = new byte[602][402];

    byte D8_uAll2_1[][] = new byte[420][420];
    byte D8_uAll2_2[][] = new byte[420][420];
    byte D8_uAll2_3[][] = new byte[420][420];
    byte D8_uAll2_4[][] = new byte[420][420];
    byte D8_uAll2_5[][] = new byte[420][420];
    byte D8_uAll2_6[][] = new byte[420][420];
    byte D8_uAll2_7[][] = new byte[420][420];
    byte D8_uAll2_8[][] = new byte[420][420];
    byte D8_uAll2[][] = new byte[602][402];

    byte D8_uAll3_1[][] = new byte[420][420];
    byte D8_uAll3_2[][] = new byte[420][420];
    byte D8_uAll3_3[][] = new byte[420][420];
    byte D8_uAll3_4[][] = new byte[420][420];
    byte D8_uAll3_5[][] = new byte[420][420];
    byte D8_uAll3_6[][] = new byte[420][420];
    byte D8_uAll3_7[][] = new byte[420][420];
    byte D8_uAll3_8[][] = new byte[420][420];
    byte D8_uAll3[][] = new byte[602][402];

    byte D8_mod_1[][] = new byte[420][420];
    byte D8_mod_2[][] = new byte[420][420];
    byte D8_mod_3[][] = new byte[420][420];
    byte D8_mod_4[][] = new byte[420][420];
    byte D8_mod_5[][] = new byte[420][420];
    byte D8_mod_6[][] = new byte[420][420];
    byte D8_mod_7[][] = new byte[420][420];
    byte D8_mod_8[][] = new byte[420][420];
    byte D8_mod[][] = new byte[602][402];

    double radius[] = new double[7];

    Font fFont0;

    String mytest = "test.txt";
    File ftest = new File(mytest);
    DataOutputStream dostest;
    String mytestr = "test.txt";
    File ftestr = new File(mytest);
    DataInputStream dostestr;

    String myslow = "slow.txt";
    File fslow = new File(myslow);
    DataOutputStream dosslow;
    String myslowr = "slow.txt";
    File fslowr = new File(myslow);
    DataInputStream dosslowr;

    public void init() {
        setSize(sizeX, sizeY);

        setBackground(Color.white);
        setLayout(null);
        fFont0 = new Font("Helvetica", Font.PLAIN, 11);
        setFont(fFont0);

        metod = new Choice();
        vision = new List(77 + 56 + 7, false);

        Butt1 = new Button("Начать");

        time = new Label("промежуток времени для счета", Label.CENTER);
        Texttime1 = new Label("t = [ 0, ");
        Texttime2 = new Label("]");
        Textstep = new Label("шаг дискретизации", Label.CENTER);
        Textstart = new Label("начальные условия", Label.CENTER);
        Textvision = new Label("отобразить", Label.CENTER);

        //kadr = new Checkbox("рисовать по кадрам", false);
        mostfile = new Checkbox("считать масштабные множители из файла", false);

        tbend = new TextField("10", 8);
        step = new TextField("1e-4", 8);
        //kadrstart = new TextField("0",8);
        //kadrend = new TextField("100",8);

        grup = new CheckboxGroup();
        poten = new Checkbox("нулевые потенциалы", grup, false);
        scor = new Checkbox("нулевые производные от потенциалов", grup, true);
        nonull = new Checkbox("произвольные", grup, false);
        //mystart = new Checkbox("использовать созданные раннее", grup, false);

        metod.addItem("Рунге-Кутта 4-го порядка");
        metod.addItem("Рунге-Кутта-Бутчера 6-го порядка");
        metod.addItem("Рунге-Кутта-Фельдберга 8-го порядка");
        //metod.addItem("Рунге-Кутта 10-го порядка");
        metod.select(2);

        vision.addItem("вычислительная погрешность");
        vision.addItem("зависимость потенциала U11 от времени");
        vision.addItem("зависимость потенциала U12 от времени");
        vision.addItem("зависимость потенциала U13 от времени");
        vision.addItem("зависимость потенциала U21 от времени");
        vision.addItem("зависимость потенциала U22 от времени");
        vision.addItem("зависимость потенциала U23 от времени");
        vision.addItem("зависимость потенциала U31 от времени");
        vision.addItem("зависимость потенциала U32 от времени");
        vision.addItem("зависимость потенциала U33 от времени");
        vision.addItem("зависимость скорости потенциала U11 от времени");
        vision.addItem("зависимость скорости потенциала U12 от времени");
        vision.addItem("зависимость скорости потенциала U13 от времени");
        vision.addItem("зависимость скорости потенциала U21 от времени");
        vision.addItem("зависимость скорости потенциала U22 от времени");
        vision.addItem("зависимость скорости потенциала U23 от времени");
        vision.addItem("зависимость скорости потенциала U31 от времени");
        vision.addItem("зависимость скорости потенциала U32 от времени");
        vision.addItem("зависимость скорости потенциала U33 от времени");
        vision.addItem("фазовая траектория осциллятора для потенциала U11");
        vision.addItem("фазовая траектория осциллятора для потенциала U12");
        vision.addItem("фазовая траектория осциллятора для потенциала U13");
        vision.addItem("фазовая траектория осциллятора для потенциала U21");
        vision.addItem("фазовая траектория осциллятора для потенциала U22");
        vision.addItem("фазовая траектория осциллятора для потенциала U23");
        vision.addItem("фазовая траектория осциллятора для потенциала U31");
        vision.addItem("фазовая траектория осциллятора для потенциала U32");
        vision.addItem("фазовая траектория осциллятора для потенциала U33");
        vision.addItem("траектория осциллятора на плоскости {U11,U12,U13}");
        vision.addItem("траектория осциллятора на плоскости {U21,U22,U23}");
        vision.addItem("траектория осциллятора на плоскости {U31,U32,U33}");
        vision.addItem("траектория осциллятора на плоскости {U11,U21,U31}");
        vision.addItem("траектория осциллятора на плоскости {U12,U22,U32}");
        vision.addItem("траектория осциллятора на плоскости {U13,U23,U33}");
        vision.addItem("траектория осциллятора на плоскости {U1,U2,U3}");
        vision.addItem("неголономные связи");
        vision.addItem("локальные максимумы и минимумы");
        vision.addItem("локальные максимумы и минимумы для u1");
        vision.addItem("локальные максимумы и минимумы для u2");
        vision.addItem("локальные максимумы и минимумы для u3");
        vision.addItem("инверсия по z координате для {U11,U12,U13}");
        vision.addItem("инверсия по z координате для {U21,U22,U23}");
        vision.addItem("инверсия по z координате для {U31,U32,U33}");
        vision.addItem("инверсия по z координате для {U11,U21,U31}");
        vision.addItem("инверсия по z координате для {U12,U22,U32}");
        vision.addItem("инверсия по z координате для {U13,U23,U33}");
        vision.addItem("инверсия по z координате для {U1,U2,U3}");
        vision.addItem("лучики для {U11,U12,U13}");
        vision.addItem("лучики для {U21,U22,U23}");
        vision.addItem("лучики для {U31,U32,U33}");
        vision.addItem("лучики для {U11,U21,U31}");
        vision.addItem("лучики для {U12,U22,U32}");
        vision.addItem("лучики для {U13,U23,U33}");
        vision.addItem("лучики для {U1,U2,U3}");
        /*
		vision.addItem("20 лучики для {U11,U12,U13}");
		vision.addItem("20 лучики для {U21,U22,U23}");
		vision.addItem("20 лучики для {U31,U32,U33}");
		vision.addItem("20 лучики для {U11,U21,U31}");
		vision.addItem("20 лучики для {U12,U22,U32}");
		vision.addItem("20 лучики для {U13,U23,U33}");
		vision.addItem("20 лучики для {U1,U2,U3}");
		vision.addItem("N лучики для {U11,U12,U13}");
		vision.addItem("N лучики для {U21,U22,U23}");
		vision.addItem("N лучики для {U31,U32,U33}");
		vision.addItem("N лучики для {U11,U21,U31}");
		vision.addItem("N лучики для {U12,U22,U32}");
		vision.addItem("N лучики для {U13,U23,U33}");
		vision.addItem("N лучики для {U1,U2,U3}");
		vision.addItem("эффект бабочки для u11");
		vision.addItem("эффект бабочки для u12");
		vision.addItem("эффект бабочки для u13");
		vision.addItem("эффект бабочки для u21");
		vision.addItem("эффект бабочки для u22");
		vision.addItem("эффект бабочки для u23");
		vision.addItem("эффект бабочки для u31");
		vision.addItem("эффект бабочки для u32");
		vision.addItem("эффект бабочки для u33");
		vision.addItem("1 для u1All");
		vision.addItem("2 для u1All");
		vision.addItem("3 для u1All");
		vision.addItem("4 для u1All");
		vision.addItem("5 для u1All");
		vision.addItem("6 для u1All");
		vision.addItem("7 для u1All");
		vision.addItem("8 для u1All");
		vision.addItem("1 для u2All");
		vision.addItem("2 для u2All");
		vision.addItem("3 для u2All");
		vision.addItem("4 для u2All");
		vision.addItem("5 для u2All");
		vision.addItem("6 для u2All");
		vision.addItem("7 для u2All");
		vision.addItem("8 для u2All");
		vision.addItem("1 для u3All");
		vision.addItem("2 для u3All");
		vision.addItem("3 для u3All");
		vision.addItem("4 для u3All");
		vision.addItem("5 для u3All");
		vision.addItem("6 для u3All");
		vision.addItem("7 для u3All");
		vision.addItem("8 для u3All");
		vision.addItem("1 для uAll1");
		vision.addItem("2 для uAll1");
		vision.addItem("3 для uAll1");
		vision.addItem("4 для uAll1");
		vision.addItem("5 для uAll1");
		vision.addItem("6 для uAll1");
		vision.addItem("7 для uAll1");
		vision.addItem("8 для uAll1");
		vision.addItem("1 для uAll2");
		vision.addItem("2 для uAll2");
		vision.addItem("3 для uAll2");
		vision.addItem("4 для uAll2");
		vision.addItem("5 для uAll2");
		vision.addItem("6 для uAll2");
		vision.addItem("7 для uAll2");
		vision.addItem("8 для uAll2");
		vision.addItem("1 для uAll3");
		vision.addItem("2 для uAll3");
		vision.addItem("3 для uAll3");
		vision.addItem("4 для uAll3");
		vision.addItem("5 для uAll3");
		vision.addItem("6 для uAll3");
		vision.addItem("7 для uAll3");
		vision.addItem("8 для uAll3");
		vision.addItem("1 для mod");
		vision.addItem("2 для mod");
		vision.addItem("3 для mod");
		vision.addItem("4 для mod");
		vision.addItem("5 для mod");
		vision.addItem("6 для mod");
		vision.addItem("7 для mod");
		vision.addItem("8 для mod");
		vision.addItem("лучи u1All");
		vision.addItem("лучи u2All");
		vision.addItem("лучи u3All");
		vision.addItem("лучи uAll1");
		vision.addItem("лучи uAll2");
		vision.addItem("лучи uAll3");
		vision.addItem("лучи mod");*/
        vision.select(0);

        add(metod);
        add(vision);
        add(Butt1);
        add(time);
        add(Texttime1);
        add(Texttime2);
        add(Textstep);
        add(Textstart);
        add(Textvision);
        add(tbend);
        add(step); //add(kadrstart); add(kadrend);
        add(poten);
        add(scor);
        add(nonull); //add(mystart); 
        //add(kadr); 
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
        //mystart.reshape(10, 225, 270, 20);
        Textvision.reshape(40, 255, 210, 20);
        vision.reshape(10, 275, 270, 90);
        //kadr.reshape(30, 375, 200, 20);
        //kadrstart.reshape(30, 395, 100, 20);
        //kadrend.reshape(150, 395, 100, 20);
        mostfile.reshape(30, 425, 250, 20);
        Butt1.reshape(70, 460, 170, 30);

    }

    public boolean action(Event evt, Object obj) {
        if (evt.target instanceof Button) {
            if (evt.target.equals(Butt1)) {
                tb = Integer.parseInt(tbend.getText());
                h = Double.parseDouble(step.getText());

                if (poten.getState())
                    startpoint = 0;
                else if (scor.getState())
                    startpoint = 1;
                else if (nonull.getState())
                    startpoint = 2;
                else
                    startpoint = 3;

                mymetod = metod.getSelectedIndex();
                myvision = vision.getSelectedIndex();
                /*
			    	if(kadr.getState())
			    	{
				    	  mykadr = 1;
				    	  ts = Integer.parseInt(kadrstart.getText());
				    	  te = Integer.parseInt(kadrend.getText());
				    	  tstart = (long)(ts/h);
				    	  tend = (long)(te/h)+1;
			    	}
			    	else
			    	{
			    		mykadr = 0;
				    	tstart = 0; tend = (long)((tb-ta)/h)+1;
			    	}*/

                tstart = 0;
                tend = (long) ((tb - ta) / h) + 1;

                if (mostfile.getState())
                    myfile = 1;
                else
                    myfile = 0;

                obrabotca();
            } else {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean mouseDown(Event evt, int x, int y) {
        if (myvision < 19) {
            if (evt.clickCount == 1) {
                XDown = x;
                YDown = y;
                if (mouse[myvision] == 0)
                    mouse[myvision] = 1;
                else
                    mouse[myvision] = 2;
                System.out.println("Down -> " + XDown + "   " + YDown);
                return true;
            }
        }
        return false;
    }

    public boolean mouseUp(Event evt, int x, int y) {
        if (myvision < 19 && (mouse[myvision] == 1 || mouse[myvision] == 2)) {
            XUp = x;
            YUp = y;
            System.out.println("Up -> " + XUp + "   " + YUp);
            zym();
        }
        return true;
    }

    public boolean mouseDrag(Event evt, int x, int y) {
        if (myvision < 19 && (mouse[myvision] == 1 || mouse[myvision] == 2)) {
            XUp = x;
            YUp = y;

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

    public void obrabotca() {
        Graphics g = getGraphics();

        if (mymetod == 0) {
            mp = 4;
            masRK4(c, b, mp);
        } else if (mymetod == 1) {
            mp = 7;
            masRKB6(c, b, mp);
        } else if (mymetod == 2) {
            mp = 13;
            masRKF8(c, b, mp);
        } else if (mymetod == 3) {
            mp = 17;
            masRK10(c, b, mp);
        }

        if (startpoint == 3 && first == 0) {
            clear();
            g.setColor(Color.red);
            g.drawString("Ранее сформированных начальных условий нет", 500, 250);
            g.drawString("выберите, пожалуйста, вариант для их создания", 500, 250);
        } else {
            if (first == 0 && myfile == 0) {
                first = 1;
                gol = 0;

                nachysl();

                clear();
                g.setColor(Color.red);
                g.drawString("Подождите, пожалуйста, идет поиск масштабных коэффициентов", 500, 250);

                h = Double.parseDouble(step.getText());
                Nh = (long) ((tb - ta) / h) + 1;
                inu = 0;
                clear();
                draw();
                mywritln();
            } else if (first == 0 && myfile == 1) {
                first = 1;
                gol = 0;

                clear();
                myread();
                myreadslow();
                mypaint();
                //mywritlnslow();
            } else {
                first = 2;

                clear();

                for (int i = 0; i < 19; i++)
                    mouse[i] = 0;

                draw();
            }

            System.out.println("продолжить");
        }
    }

    public void mywritln() {
        try {
            dostest = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(mytest), 128));

            dostest.writeDouble(Nh);
            dostest.writeDouble(h);

            for (int i = 0; i < 18; i++)
                dostest.writeDouble(avstart[i]);

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 2; j++)
                    dostest.writeDouble(maxMin[i][j]);

            for (int i = 0; i < 18; i++)
                for (int j = 0; j < 9; j++)
                    dostest.writeDouble(MaxMin[i][j]);

            dostest.flush();
        } catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        } catch (IOException ioe) {
            System.out.println("writeFile: caught i/o exception: запись не удалась");
        }
    }

    public void myread() {
        try {
            dostestr = new DataInputStream(new BufferedInputStream(new FileInputStream(mytestr), 128));
            Nh = (long) (dostestr.readDouble());
            h = dostestr.readDouble();

            for (int i = 0; i < 18; i++)
                avstart[i] = dostestr.readDouble();

            for (int i = 0; i < 20; i++)
                for (int j = 0; j < 2; j++)
                    maxMin[i][j] = dostestr.readDouble();

            for (int i = 0; i < 18; i++)
                for (int j = 0; j < 9; j++)
                    MaxMin[i][j] = dostestr.readDouble();
        } catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        } catch (IOException ioe) {
            System.out.println("writeFile: файл не найден ");
        }
    }

    public void mywritlnslow() {
        try {
            dosslow = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myslow), 128));

            for (int j = 0; j < 7; j++)
                dosslow.writeDouble(delta100[j]);

            /*
			for(int i = 0; i < 100; i++)
			{
				System.out.print("i : " + i + "   ");
				for(int j = 0; j < 7; j++)
					System.out.print(Nkslow[j][99 - i] + "   ");
				System.out.println();
			}
				*/
            for (int j = 0; j < 7; j++)
                for (int i = 0; i < 100; i++)
                    dosslow.writeInt(Nkslow[j][99 - i]);

            dosslow.flush();
        } catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        } catch (IOException ioe) {
            System.out.println("writeFile: caught i/o exception: запись не удалась");
        }
    }

    public void myreadslow() {
        try {
            dosslowr = new DataInputStream(new BufferedInputStream(new FileInputStream(myslowr), 128));

            for (int i = 0; i < 7; i++)
                delta100[i] = dosslowr.readDouble();

            for (int i = 0; i < 7; i++)
                for (int j = 0; j < 100; j++)
                    Nkslow[i][99 - j] = dosslowr.readInt();

            for (int i = 0; i < 100; i++) {
                System.out.print("i : " + i + "   ");
                for (int j = 0; j < 7; j++)
                    System.out.print(Nkslow[j][99 - i] + "   ");
                System.out.println();
            }
        } catch (SecurityException e) {
            System.out.println("writeFile: caught security exception: " + e);
        } catch (IOException ioe) {
            System.out.println("writeFile: файл не найден ");
        }
    }

    public void clear() {
        Graphics g = getGraphics();

        g.setColor(Color.white);
        g.fillRect(sizePanel, 0, sizeX - sizePanel, sizeY);
    }

    public void nachysl() {
        double UKpot, kappa, betta;

        if (startpoint == 0) {
            for (int i = 0; i < 9; i++)
                avstart[i] = 0.0;

            for (int i = 9; i < 18; i++)
                avstart[i] = Math.random() * 2.0 - 1;

            for (int i = 0; i < 18; i++)
                input[i] = avstart[i];

            UKpot = K();
            betta = 1.0 / Math.pow(UKpot, 1.0 / 2);

            for (int i = 9; i < 18; i++)
                avstart[i] *= betta;
        } else if (startpoint == 1) {
            for (int i = 9; i < 18; i++)
                avstart[i] = 0.0;

            for (int i = 0; i < 9; i++)
                avstart[i] = Math.random() * 2.0 - 1;

            for (int i = 0; i < 18; i++)
                input[i] = avstart[i];

            UKpot = U();
            kappa = 1.0 / Math.pow(UKpot, 1.0 / 4);

            for (int i = 0; i < 9; i++)
                avstart[i] *= kappa;
        } else if (startpoint == 2) {
            int index[] = new int[3];
            int myif = 0;


            do {
                for (int i = 0; i < 3; i++)
                    index[i] = (int) (Math.random() * 3.0 - 0.5) + 1;
            } while ((index[0] == index[1]) || (index[0] == index[2]));

            index[0] = 2;
            index[1] = 1;
            index[2] = 2;
            for (int i = 0; i < 3; i++)
                System.out.println("неизвестные " + index[i]);

            do {
                for (int i = 0; i < 18; i++)
                    avstart[i] = Math.random() * 2.0 - 1;

                for (int i = 0; i < 3; i++)
                    avstart[8 + i * 3 + index[i]] = 0.0;

                myif = GaussTriplet(index);
            } while (myif != 1);

            for (int i = 0; i < 18; i++)
                input[i] = avstart[i];

            UKpot = U() + K();
            kappa = 1.0 / Math.pow(UKpot, 1.0 / 4);
            betta = 1.0 / Math.pow(UKpot, 1.0 / 2);

            for (int i = 0; i < 9; i++) {
                avstart[i] *= kappa;
                avstart[9 + i] *= betta;
            }
        }

        for (int i = 0; i < 18; i++)
            input[i] = avstart[i];

        //для контроля

        UKpot = EUK();

        System.out.println("начальные условия в для счета");
        for (int i = 0; i < 18; i++)
            System.out.println(i + ": " + input[i]);

        System.out.println("энергия = " + UKpot);
    }

    public void negolonomnost(double t) {
        double SymbN[][] = {{0.0, 0.0, 0.0, -input[6], -input[7], -input[8], input[3], input[4], input[5]},
                {input[6], input[7], input[8], 0.0, 0.0, 0.0, -input[0], -input[1], -input[2]},
                {-input[3], -input[4], -input[5], input[0], input[1], input[2], 0.0, 0.0, 0.0}};

        for (int i = 0; i < 3; i++)
            negol[i][gol] = 0.0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                negol[i][gol] += SymbN[i][j] * input[9 + j];

        for (int i = 0; i < 3; i++)
            negol[i][gol] = Math.log10(Math.abs(negol[i][gol]));
        negol[3][gol] = t;
    }

    public int GaussTriplet(int[] mas) {
        double Symb[][] = {{0.0, 0.0, 0.0, -avstart[6], -avstart[7], -avstart[8], avstart[3], avstart[4], avstart[5]},
                {avstart[6], avstart[7], avstart[8], 0.0, 0.0, 0.0, -avstart[0], -avstart[1], -avstart[2]},
                {-avstart[3], -avstart[4], -avstart[5], avstart[0], avstart[1], avstart[2], 0.0, 0.0, 0.0}};

        int N = 3;
        double aGauss[][] = new double[N][N];
        double bGauss[][] = new double[N][1];
        double cGauss[][] = new double[N][N + 1];
        double xGauss[][] = new double[N][1];
        double det;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                aGauss[i][j] = Symb[i][j * 3 + mas[j] - 1];

        for (int i = 0; i < N; i++)
            bGauss[i][0] = 0.0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 9; j++)
                bGauss[i][0] -= Symb[i][j] * avstart[9 + j];

        zapolnenieGauss(aGauss, bGauss, cGauss, N);
        int k = pr_hod(cGauss, N);
        det = opred(cGauss, k, N);

        if (det < 1e-15 && det > -1e-15)
            return 0;
        else {
            obr_hod(cGauss, xGauss, N);

            for (int i = 0; i < N; i++)
                avstart[8 + i * 3 + mas[i]] = xGauss[i][0];
        }
        return 1;
    }

    public void zapolnenieGauss(double[][] aG, double[][] bG, double[][] cG, int N) {
        int i, j;

        for (i = 0; i < N; i++)
            for (j = 0; j < N + 1; j++)
                if (j < N)
                    cG[i][j] = aG[i][j];
                else
                    cG[i][j] = bG[i][j - N];
    }

    public int pr_hod(double[][] cG, int N) {
        int i, j, k, p = 0, l;
        double m;

        for (i = 0; i < N - 1; i++) {
            l = perectanovka(cG, i, N);
            p += l;

            for (k = i + 1; k < N; k++) {
                m = cG[k][i] / cG[i][i];
                for (j = i; j < N + 1; j++)
                    cG[k][j] = cG[k][j] - m * cG[i][j];
            }
        }

        return p;
    }

    public int perectanovka(double[][] cG, int i, int N) {
        double max = Math.abs(cG[i][i]);
        int hh = i, j, k;
        double m;

        for (j = i + 1; j < N; j++)
            if (max < Math.abs(cG[j][i])) {
                max = Math.abs(cG[j][i]);
                hh = j;
            }

        if (hh != i) {
            for (k = i; k < N + 1; k++) {
                m = cG[i][k];
                cG[i][k] = cG[hh][k];
                cG[hh][k] = m;
            }
            return 1;
        } else return 0;
    }

    public void obr_hod(double[][] cG, double[][] xG, int N) {
        int i, j, k;
        double d = 0;

        for (i = N - 2; i >= 0; i--)
            for (j = 0; j < 1; j++) {
                xG[N - 1][j] = cG[N - 1][N + j] / cG[N - 1][N - 1];

                for (k = i + 1; k < N; k++)
                    d += cG[i][k] * xG[k][j];

                xG[i][j] = 1 / cG[i][i] * (cG[i][N + j] - d);
                d = 0;
            }
    }

    public double opred(double[][] cG, int p, int N) {
        int i;
        double det = 1;

        for (i = 0; i < N; i++)
            det *= cG[i][i];

        det *= Math.pow((double) (-1), p);

        return det;
    }

    public void zapolnenie(double[] cc, double[] bb, double[] c, double[][] b, int mp) {
        for (int i = 0; i < mp; i++)
            c[i] = cc[i];

        b[0][0] = 0;
        int ij = 0;
        for (int i = 1; i < mp; i++)
            for (int j = 0; j < i; j++) {
                b[i][j] = bb[ij];
                ij++;
            }
    }

    public void zapolnenie2(double[] cc, double[] bb, double[] c, double[][] b, int mp) {
        for (int i = 0; i < mp; i++)
            c[i] = cc[i];

        b[0][0] = 0;
        int ij = 0;

        for (int j = 0; j < mp - 1; j++)
            for (int i = 0; i < mp; i++)
                b[i][j] = 0;

        for (int j = 1; j < mp - 1; j++)
            for (int i = 1; i < j + 1; i++) {
                b[i][j] = bb[ij];
                ij++;
            }
    }

    public void masRK4(double[] c, double[][] b, int mp) {
        double cc[] = {1.0 / 6, 1.0 / 3, 1.0 / 3, 1.0 / 6};
        double bb[] = {1.0 / 2, 0.0, 1.0 / 2, 0.0, 0.0, 1.0};

        zapolnenie(cc, bb, c, b, mp);
    }

    public void masRKB6(double[] c, double[][] b, int mp) {
        double cc[] = {13.0 / 200, 0.0, 11.0 / 40, 11.0 / 40, 4.0 / 25, 4.0 / 25, 13.0 / 200};
        double bb[] = {1.0 / 2, 2.0 / 9, 4.0 / 9, 7.0 / 36, 2.0 / 9, -1.0 / 12, -35.0 / 144, -55.0 / 36, 35.0 / 48, 15.0 / 8, -1.0 / 360, -11.0 / 36, -1.0 / 8, 1.0 / 2, 1.0 / 10, -41.0 / 260, 22.0 / 13, 43.0 / 156, -118.0 / 39, 32.0 / 195, 80.0 / 39};

        zapolnenie(cc, bb, c, b, mp);
    }

    public void masRKF8(double[] c, double[][] b, int mp) {
        double cc[] = {41.0 / 840, 0.0, 0.0, 0.0, 0.0, 34.0 / 105, 9.0 / 35, 9.0 / 35, 9.0 / 280, 9.0 / 280, 0.0, 0.0, 41.0 / 840};
        double bb[] = {2.0 / 27, 1.0 / 36, 1.0 / 12, 1.0 / 24, 0.0, 1.0 / 8, 5.0 / 12, 0.0, -25.0 / 16, 25.0 / 16, 1.0 / 20, 0.0, 0.0, 1.0 / 4, 1.0 / 5, -25.0 / 108, 0.0, 0.0, 125.0 / 108, -65.0 / 27, 125.0 / 54, 31.0 / 300, 0.0, 0.0, 0.0, 61.0 / 225, -2.0 / 9, 13.0 / 900, 2.0, 0.0, 0.0, -53.0 / 6, 704.0 / 45, -107.0 / 9, 67.0 / 90, 3.0, -91.0 / 108, 0.0, 0.0, 23.0 / 108, -976.0 / 135, 311.0 / 54, -19.0 / 60, 17.0 / 6, -1.0 / 12, 2383.0 / 4100, 0.0, 0.0, -341.0 / 164, 4496.0 / 1025, -301.0 / 82, 2133.0 / 4100, 45.0 / 82, 45.0 / 164, 18.0 / 41, 3.0 / 205, 0.0, 0.0, 0.0, 0.0, -6.0 / 41, -3.0 / 205, -3.0 / 41, 3.0 / 41, 6.0 / 41, 0.0, -1777.0 / 4100, 0.0, 0.0, -341.0 / 164, 4496.0 / 1025, -289.0 / 82, 2193.0 / 4100, 51.0 / 82, 33.0 / 164, 12.0 / 41, 0.0, 1.0};

        zapolnenie(cc, bb, c, b, mp);
    }

    public void masRK10(double[] c, double[][] b, int mp) {
        double cc[] = {0.0333333333333333, -0.0333333333333333, -0.12, 0.0, 0.0, -0.13, -0.18, 0.0, 0.2774291885177432, 0.1892374781489234, 0.2774291885177432, 0.1892374781499234, 0.13, 0.0, 0.12, 0.0333333333333333, 0.0333333333333333};
        double bb[] = {0.5,
                0.2492972676096890, 0.2772118325319301,
                0.1974409125531046, 0.0, 0.5923227376593137,
                0.1973205486287021, 0.0, 0.2950833340926718, -0.0984803125957024,
                0.1313134173444615, 0.0, 0.0, 0.1101544395386385, 0.5251861293704488,
                0.1342003418463224, 0.0, 0.0, 0.6960887032880769, 0.2504977215703393, -0.7910231164923204,
                0.0722182741896621, 0.0, 0.0, 0.0, -0.0583363229364550, 0.0030475576685745, 0.0915481802977846,
                0.0312550081351656, 0.0, 0.0, 0.0, 0.0, 0.0001091238215424, 0.1567257586309950, 0.1692943511719744,
                0.0119066044146750, 0.0, 0.0, 0.0, 0.0, 0.2834370820246065, -0.4163121675705613, 0.2646463339497430, 0.7388498091462691,
                0.0234065736913354, 0.0, 0.0, 0.0, 0.0, 0.0944931301894962, -0.2728720559019564, 0.2240220461155922, 0.6043814410751351, -0.0308153769292800,
                0.0454437753101764, 0.0, 0.0, 0.0, 0.0, -1.0011879966718644, 0.0120356549909281, 0.0751269029876479, 0.0182209240988846, -0.0002571528540841, 0.0045320783713483,
                0.1784010864004364, 0.0, 0.0, 0.1101544395386385, 0.5251861293704488, -0.4891485918200436, 0.9324436126351357, -0.7744750534398395, -1.0549021781393582, 0.1310467120341571, 0.5870497775994874, 0.6208980520748788,
                0.1302208066004978, 0.0, 0.0, 0.6960887032880769, 0.2504977215703394, -0.7589489871296073, -0.1715172084634884, -0.3702176736789067, 0.1249810085747473, 0.0033531092483727, 0.0066325461367625, 0.4291165731216179, -0.0371778567824698,
                0.2492972676096820, 0.2772118325319302, 0.0, 0.0, 0.0, -0.1459405959360852, -0.7990158935110294, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1459405959360852, 0.7990158935110294,
                0.5, 0.0, 0.8070970760953411, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.8070970760953411,
                0.0573207954320575, -0.5, -0.8974701633948552, 0.0, 0.0, -1.0399100492669534, -0.4073570142883858, -1.1828302366407418, -0.3336592706492250, 0.3956485423760579, 0.6950570494599823, 0.2714873764573832, 0.5854237348665898, 0.9588190722132354, 0.8974701633948552, 0.5};

        zapolnenie2(cc, bb, c, b, mp);
    }

    public void masprint(double[] c, double[][] b, int mp) {
        for (int i = 0; i < mp; i++)
            System.out.println("c[" + i + "]=" + c[i]);

        System.out.println(b[0][0]);
        for (int i = 1; i < mp; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(b[i][j] + "  ");
            System.out.println();
        }
    }

    public double Svec(double[] v1, double[] v2) {
        return (double) (v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2]);
    }

    public double svec(int v1, int v2) {
        int r1 = (v1 - 1) * 3;
        int r2 = (v2 - 1) * 3;
        return (double) (input[r1] * input[r2] + input[r1 + 1] * input[r2 + 1] + input[r1 + 2] * input[r2 + 2]);
    }

    public double kvvvec(int v1, int v2) {
        return (double) (svec(v1, v1) * svec(v2, v2) - svec(v1, v2) * svec(v1, v2));
    }

    public double f1(int j, double[] mas) {
        double v1[] = {input[0] + h * mas[0], input[1] + h * mas[1], input[2] + h * mas[2]};
        double v2[] = {input[3] + h * mas[3], input[4] + h * mas[4], input[5] + h * mas[5]};
        double v3[] = {input[6] + h * mas[6], input[7] + h * mas[7], input[8] + h * mas[8]};

        return (double) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3));
    }

    public double f2(int j, double[] mas) {
        double v1[] = {input[0] + h * mas[0], input[1] + h * mas[1], input[2] + h * mas[2]};
        double v2[] = {input[3] + h * mas[3], input[4] + h * mas[4], input[5] + h * mas[5]};
        double v3[] = {input[6] + h * mas[6], input[7] + h * mas[7], input[8] + h * mas[8]};

        return (double) (-v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3)) + v1[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v2, v3));
    }

    public double f3(int j, double[] mas) {
        double v1[] = {input[0] + h * mas[0], input[1] + h * mas[1], input[2] + h * mas[2]};
        double v2[] = {input[3] + h * mas[3], input[4] + h * mas[4], input[5] + h * mas[5]};
        double v3[] = {input[6] + h * mas[6], input[7] + h * mas[7], input[8] + h * mas[8]};

        return (double) (-v3[j % 3] * (Svec(v2, v2) + Svec(v1, v1)) + v2[j % 3] * Svec(v3, v2) + v1[j % 3] * Svec(v1, v3));
    }

    public double fc(double u1) {
        return u1;
    }

    public double U() {
        return (double) (0.5 * (kvvvec(1, 2) + kvvvec(1, 3) + kvvvec(3, 2)));
    }

    public double K() {
        return (double) (0.5 * (svec(4, 4) + svec(5, 5) + svec(6, 6)));
    }

    public double EUK() {
        return (double) (Math.log10(Math.abs(K() + U() - 1.0)));
    }


    public int chistka(int s, double[] porog) {
        double min, max, raz;

        min = max = umas[s][1];

        for (int i = 3; i < 2 * uconst; i += 2) {
            if (umas[s][i] > max)
                max = umas[s][i];
            if (umas[s][i] < min)
                min = umas[s][i];
        }

        raz = (max - min) / 5.0;

        int len = uconst;
        if (s > 8) {
            for (int i = 1; i < 2 * len; i += 2)
                if (umas[s][i] < min + raz) {
                    len -= 1;
                    for (int j = i; j < 2 * len; j++)
                        umas[s][j] = umas[s][j + 2];
                }

            porog[s] = min + raz;
        } else {
            for (int i = 1; i < 2 * len; i += 2)
                if (umas[s][i] > max - raz) {
                    len -= 1;
                    for (int j = i; j < 2 * len; j++)
                        umas[s][j] = umas[s][j + 2];
                }

            porog[s] = max - raz;
        }

        return len;
    }

    public void schetstep() {
        double k1[][] = new double[18][mp];
        double ss1[] = new double[18];

        for (int s = 0; s < 18; s++)
            ss1[s] = 0;

        for (int j = 0; j < 9; j++)
            k1[j][0] = fc(input[j + 9]);
        for (int j = 9; j < 12; j++)
            k1[j][0] = f1(j, ss1);
        for (int j = 12; j < 15; j++)
            k1[j][0] = f2(j, ss1);
        for (int j = 15; j < 18; j++)
            k1[j][0] = f3(j, ss1);

        for (int j = 1; j < mp; j++) {
            for (int s = 0; s < 18; s++)
                ss1[s] = 0;

            for (int ss = 0; ss < 18; ss++)
                for (int s = 0; s < j; s++)
                    ss1[ss] += b[j][s] * k1[ss][s];


            for (int ss = 0; ss < 9; ss++)
                k1[ss][j] = fc(input[ss + 9] + h * ss1[ss + 9]);
            for (int ss = 9; ss < 12; ss++)
                k1[ss][j] = f1(ss, ss1);
            for (int ss = 12; ss < 15; ss++)
                k1[ss][j] = f2(ss, ss1);
            for (int ss = 15; ss < 18; ss++)
                k1[ss][j] = f3(ss, ss1);

        }

        for (int s = 0; s < 18; s++)
            ss1[s] = 0;
        for (int ss = 0; ss < 18; ss++)
            for (int s = 0; s < mp; s++)
                ss1[ss] += c[s] * k1[ss][s];


        for (int s = 0; s < 18; s++)
            input[s] = input[s] + h * ss1[s];
    }

    public void myMaxMin() {
        for (int i = 0; i < 9; i++) {
            maxMin[i][0] = umas[i][1];
            for (int j = 3; j < 2 * umas[i][0]; j += 2)
                if (umas[i][j] < maxMin[i][0])
                    maxMin[i][0] = umas[i][j];
        }
        for (int i = 0; i < 9; i++) {
            maxMin[i][1] = umas[i + 9][1];
            for (int j = 3; j < 2 * umas[i + 9][0]; j += 2)
                if (umas[i + 9][j] > maxMin[i][1])
                    maxMin[i][1] = umas[i + 9][j];
        }
    }

    public double myMax3(double m1, double m2, double m3) {
        double max;

        if (Math.abs(m1) > Math.abs(m2))
            if (Math.abs(m1) > Math.abs(m3))
                max = m1;
            else
                max = m3;
        else if (Math.abs(m3) > Math.abs(m2))
            max = m3;
        else
            max = m2;

        return max;
    }

    public double myMod(int vec, int j) {
        double max;
        max = myMax3(MaxMin[vec + j][vec], MaxMin[vec + j][vec + 1], MaxMin[vec + j][vec + 2]);

        return (double) (Math.signum(max) * Math.sqrt(MaxMin[vec + j][vec] * MaxMin[vec + j][vec] + MaxMin[vec + j][vec + 1] * MaxMin[vec + j][vec + 1] + MaxMin[vec + j][vec + 2] * MaxMin[vec + j][vec + 2]));
    }

    public double myModav(int vec) {
        double max;
        max = myMax3(input[vec], input[vec + 1], input[vec + 2]);

        return (double) (Math.signum(max) * Math.sqrt(input[vec] * input[vec] + input[vec + 1] * input[vec + 1] + input[vec + 2] * input[vec + 2]));
    }

    public void macshtab2(double[][] mas, int in, double[] kof, int dl) {
        double min, max;

        int j = -1;
        do {
            j++;
            min = mas[in][j];
            max = mas[in][j];
        } while (mas[in][j] < -2000 || mas[in][j] > 200000);

        for (int i = 1; i < dl; i++) {
            if (mas[in][i] > max && mas[in][i] < 200000)
                max = mas[in][i];
            if (mas[in][i] < min && mas[in][i] > -2000)
                min = mas[in][i];
        }

        kof[0] = min;
        kof[1] = max;
    }

    public int wndX(double x, int index) {
        return (int) ((x - maxMin[index][0]) * 1.0 / (maxMin[index][1] - maxMin[index][0]) * (wndXMax - wndXMin) + wndXMin);
    }

    public int wndY(double y, int index) {
        return (int) (wndYMax - (y - maxMin[index][0]) * 1.0 / (maxMin[index][1] - maxMin[index][0]) * (wndYMax - wndYMin));
    }

    public int wndXAll(double x, int index) {
        return (int) ((x - uAll[index][0]) * 1.0 / (uAll[index][1] - uAll[index][0]) * (wndXMax - wndXMin) + wndXMin);
    }

    public int wndYAll(double y, int index) {
        return (int) (wndYMax - (y - uAll[index][2]) * 1.0 / (uAll[index][3] - uAll[index][2]) * (wndYMax - wndYMin));
    }

    public int wndXYAll(double x, int index) {
        return (int) ((x - uAll[index][0]) * 1.0 / (uAll[index][1] - uAll[index][0]) * (wndYMax - wndYMin) + wndXMin);
    }

    public double obrwndY(int Yy, int index) {
        return (double) ((wndYMax - Yy) * (maxMin[index][1] - maxMin[index][0]) * 1.0 / (wndYMax - wndYMin) + maxMin[index][0]);
    }

    public void norm(int index) {
        if (uAll[index][1] > uAll[index][3])
            uAll[index][3] = uAll[index][1];
        else
            uAll[index][1] = uAll[index][3];

        if (uAll[index][0] < uAll[index][2])
            uAll[index][2] = uAll[index][0];
        else
            uAll[index][0] = uAll[index][2];
    }

    public void mypaint() {
        clear();

        for (int i = 0; i < 3; i++) {
            uAll[i][1] = maxMin[i * 3][1] + maxMin[i * 3 + 2][1] * Math.cos(alpha);
            uAll[i][0] = maxMin[i * 3][0] + maxMin[i * 3 + 2][0] * Math.cos(alpha);
            uAll[i][3] = maxMin[i * 3 + 1][1] + maxMin[i * 3 + 2][1] * Math.sin(alpha);
            uAll[i][2] = maxMin[i * 3 + 1][0] + maxMin[i * 3 + 2][0] * Math.sin(alpha);

            norm(i);
        }

        for (int i = 3; i < 6; i++) {
            uAll[i][1] = maxMin[i - 3][1] + maxMin[i + 3][1] * Math.cos(alpha);
            uAll[i][0] = maxMin[i - 3][0] + maxMin[i + 3][0] * Math.cos(alpha);
            uAll[i][3] = maxMin[i][1] + maxMin[i + 3][1] * Math.sin(alpha);
            uAll[i][2] = maxMin[i][0] + maxMin[i + 3][0] * Math.sin(alpha);

            norm(i);
        }

        double mod1, mod2, mod3;

        mod1 = myMod(0, 9);
        mod2 = myMod(3, 9);
        mod3 = myMod(6, 9);

        uAll[6][3] = mod2 + mod3 * Math.sin(alpha);
        uAll[6][1] = mod1 + mod3 * Math.cos(alpha);

        mod1 = myMod(0, 0);
        mod2 = myMod(3, 0);
        mod3 = myMod(6, 0);

        uAll[6][2] = mod2 + mod3 * Math.sin(alpha);
        uAll[6][0] = mod1 + mod3 * Math.cos(alpha);

        norm(6);

        for (int i = 0; i < 3; i++) {
            uAll[i + 7][1] = maxMin[i * 3][1] - maxMin[i * 3 + 2][0] * Math.cos(alpha);
            uAll[i + 7][0] = maxMin[i * 3][0] - maxMin[i * 3 + 2][1] * Math.cos(alpha);
            uAll[i + 7][3] = maxMin[i * 3 + 1][1] - maxMin[i * 3 + 2][0] * Math.sin(alpha);
            uAll[i + 7][2] = maxMin[i * 3 + 1][0] - maxMin[i * 3 + 2][1] * Math.sin(alpha);

            norm(i + 7);
        }

        for (int i = 3; i < 6; i++) {
            uAll[i + 7][1] = maxMin[i - 3][1] - maxMin[i + 3][0] * Math.cos(alpha);
            uAll[i + 7][0] = maxMin[i - 3][0] - maxMin[i + 3][1] * Math.cos(alpha);
            uAll[i + 7][3] = maxMin[i][1] - maxMin[i + 3][0] * Math.sin(alpha);
            uAll[i + 7][2] = maxMin[i][0] - maxMin[i + 3][1] * Math.sin(alpha);

            norm(i + 7);
        }

        mod1 = myMod(0, 9);
        mod2 = myMod(3, 9);
        mod3 = myMod(6, 0);

        uAll[13][3] = mod2 - mod3 * Math.sin(alpha);
        uAll[13][1] = mod1 - mod3 * Math.cos(alpha);

        mod1 = myMod(0, 0);
        mod2 = myMod(3, 0);
        mod3 = myMod(6, 9);

        uAll[13][2] = mod2 - mod3 * Math.sin(alpha);
        uAll[13][0] = mod1 - mod3 * Math.cos(alpha);

        norm(13);

        for (int j1 = 0; j1 < 420; j1++)
            for (int j2 = 0; j2 < 420; j2++) {
                img3D_uAll1[j1][j2] = 100;
                img3D_uAll2[j1][j2] = 100;
                img3D_uAll3[j1][j2] = 100;
                img3D_u1All[j1][j2] = 100;
                img3D_u2All[j1][j2] = 100;
                img3D_u3All[j1][j2] = 100;
                img3D_mod[j1][j2] = 100;

                imgD3_uAll1[j1][j2] = 100;
                imgD3_uAll2[j1][j2] = 100;
                imgD3_uAll3[j1][j2] = 100;
                imgD3_u1All[j1][j2] = 100;
                imgD3_u2All[j1][j2] = 100;
                imgD3_u3All[j1][j2] = 100;
                imgD3_mod[j1][j2] = 100;
            }

        for (int i = 20; i < 410; i++) {
            //ось y
            img3D_u1All[wndXYAll(0, 0) - wndXMin + 10][i] = 102;
            img3D_u2All[wndXYAll(0, 1) - wndXMin + 10][i] = 102;
            img3D_u3All[wndXYAll(0, 2) - wndXMin + 10][i] = 102;

            img3D_uAll1[wndXYAll(0, 3) - wndXMin + 10][i] = 102;
            img3D_uAll2[wndXYAll(0, 4) - wndXMin + 10][i] = 102;
            img3D_uAll3[wndXYAll(0, 5) - wndXMin + 10][i] = 102;

            imgD3_u1All[wndXYAll(0, 7) - wndXMin + 10][i] = 102;
            imgD3_u2All[wndXYAll(0, 8) - wndXMin + 10][i] = 102;
            imgD3_u3All[wndXYAll(0, 9) - wndXMin + 10][i] = 102;

            imgD3_uAll1[wndXYAll(0, 10) - wndXMin + 10][i] = 102;
            imgD3_uAll2[wndXYAll(0, 11) - wndXMin + 10][i] = 102;
            imgD3_uAll3[wndXYAll(0, 12) - wndXMin + 10][i] = 102;

            img3D_mod[wndXYAll(0, 6) - wndXMin + 10][i] = 102;
            imgD3_mod[wndXYAll(0, 13) - wndXMin + 10][i] = 102;

            //ось x
            img3D_u1All[i][wndYAll(0, 0) - wndYMin + 10] = 102;
            img3D_u2All[i][wndYAll(0, 1) - wndYMin + 10] = 102;
            img3D_u3All[i][wndYAll(0, 2) - wndYMin + 10] = 102;

            img3D_uAll1[i][wndYAll(0, 3) - wndYMin + 10] = 102;
            img3D_uAll2[i][wndYAll(0, 4) - wndYMin + 10] = 102;
            img3D_uAll3[i][wndYAll(0, 5) - wndYMin + 10] = 102;

            imgD3_u1All[i][wndYAll(0, 7) - wndYMin + 10] = 102;
            imgD3_u2All[i][wndYAll(0, 8) - wndYMin + 10] = 102;
            imgD3_u3All[i][wndYAll(0, 9) - wndYMin + 10] = 102;

            imgD3_uAll1[i][wndYAll(0, 10) - wndYMin + 10] = 102;
            imgD3_uAll2[i][wndYAll(0, 11) - wndYMin + 10] = 102;
            imgD3_uAll3[i][wndYAll(0, 12) - wndYMin + 10] = 102;

            img3D_mod[i][wndYAll(0, 6) - wndYMin + 10] = 102;
            imgD3_mod[i][wndYAll(0, 13) - wndYMin + 10] = 102;

            //ось z
            img3D_u1All[420 - i][i] = 102;
            img3D_u2All[420 - i][i] = 102;
            img3D_u3All[420 - i][i] = 102;

            img3D_uAll1[420 - i][i] = 102;
            img3D_uAll2[420 - i][i] = 102;
            img3D_uAll3[420 - i][i] = 102;

            imgD3_u1All[420 - i][i] = 102;
            imgD3_u2All[420 - i][i] = 102;
            imgD3_u3All[420 - i][i] = 102;

            imgD3_uAll1[420 - i][i] = 102;
            imgD3_uAll2[420 - i][i] = 102;
            imgD3_uAll3[420 - i][i] = 102;

            img3D_mod[420 - i][i] = 102;
            imgD3_mod[420 - i][i] = 102;
        }

        //для подсчета количества точек в 100 сферических слоях
        /*
				for(int i = 0; i < SLOW_CONST; i++)
					for(int j = 0; j < 7; j++)
						Nkslow[j][i] = 0;
				*/
        for (int i = 0; i < 3; i++) {
            delta100[i] = razdelSlow((int) (sl * SLOW_CONST), i * 3, i * 3 + 1, i * 3 + 2);
            System.out.println("delta " + i + " :  " + delta100[i]);
            delta100[i + 3] = razdelSlow((int) (sl * SLOW_CONST), i, i + 3, i + 6);
            System.out.println("delta " + (int) (i + 3) + " :  " + delta100[i + 3]);
        }
        delta100[6] = razdelSlowMod((int) (sl * SLOW_CONST));
        System.out.println("delta 6 :  " + delta100[6]);

        for (int j = 0; j < 7; j++)
            for (int i = 0; i < SLOW_CONST; i++)
                stepen[j][i] = Math.pow(Q100, i) * delta100[j];

        for (int i = 0; i < 602; i++)
            for (int j = 0; j < 402; j++) {
                img_u11[i][j] = 0;
                img_u12[i][j] = 0;
                img_u13[i][j] = 0;
                img_u21[i][j] = 0;
                img_u22[i][j] = 0;
                img_u23[i][j] = 0;
                img_u31[i][j] = 0;
                img_u32[i][j] = 0;
                img_u33[i][j] = 0;
                img_uc11[i][j] = 0;
                img_uc12[i][j] = 0;
                img_uc13[i][j] = 0;
                img_uc21[i][j] = 0;
                img_uc22[i][j] = 0;
                img_uc23[i][j] = 0;
                img_uc31[i][j] = 0;
                img_uc32[i][j] = 0;
                img_uc33[i][j] = 0;
                img_uf11[i][j] = 0;
                img_uf12[i][j] = 0;
                img_uf13[i][j] = 0;
                img_uf21[i][j] = 0;
                img_uf22[i][j] = 0;
                img_uf23[i][j] = 0;
                img_uf31[i][j] = 0;
                img_uf32[i][j] = 0;
                img_uf33[i][j] = 0;
            }

        for (int i = 0; i < 19; i++)
            for (int j = 0; j < 602; j++)
                utime[i][j] = -1;

        for (int i = 0; i < 19; i++)
            mouse[i] = 0;

        //oktant();	
        draw();
    }

    public void shcala(int indexX, int indexY) {
        Graphics g = getGraphics();

        g.setColor(Color.BLACK);
        g.drawRect((int) (wndXMin), (int) (wndYMin), (int) (wndXMax - wndXMin), (int) (wndYMax - wndYMin));

        double xMax = maxMin[indexX][1], xMin = maxMin[indexX][0];
        double yMax = maxMin[indexY][1], yMin = maxMin[indexY][0];
        int rline = 20;
        double xh = (int) ((xMax - xMin) / rline);
        double yh = (int) ((yMax - yMin) / rline);
        int t = 1;

        if (xh != 0) {
            double xm = (int) (xMin);

            while (xm % 5 != 0 || xm < xMin)
                xm++;

            while (xh % 5 != 0)
                xh++;

            while (xm < xMax) {
                g.drawLine(wndX(xm, indexX), wndYMax, wndX(xm, indexX), wndYMax - 2);
                g.drawLine(wndX(xm, indexX), wndYMin, wndX(xm, indexX), wndYMin + 2);

                if (t % 2 == 0) {
                    g.drawString("" + (int) (xm), wndX(xm, indexX) - 10, wndYMax + 15);
                    g.drawString("" + (int) (xm), wndX(xm, indexX) - 10, wndYMin - 5);
                }

                xm += xh;
                t++;
            }
        } else {
            double px = 1.0 * (xMax - xMin) / rline;
            if (px < 0.25)
                xh = 0.2;
            else
                xh = 0.5;

            double xm = (int) (xMin);

            while (xm > xMin)
                xm -= xh;
            while (xm < xMin)
                xm += xh;

            while (xm < xMax) {
                g.drawLine(wndX(xm, indexX), wndYMax, wndX(xm, indexX), wndYMax - 2);
                g.drawLine(wndX(xm, indexX), wndYMin, wndX(xm, indexX), wndYMin + 2);

                if (t % 2 == 0) {
                    g.drawString("" + (double) (Math.round(xm * 10) / 10.0), wndX(xm, indexX) - 10, wndYMax + 15);
                    g.drawString("" + (double) (Math.round(xm * 10) / 10.0), wndX(xm, indexX) - 10, wndYMin - 5);
                }

                xm += xh;
                t++;
            }
        }

        if (yh != 0) {
            double ym = (int) (yMin);

            while (ym % 5 != 0)
                ym++;

            while (yh % 5 != 0)
                yh++;

            while (ym < yMax) {
                g.drawLine(wndXMin, wndY(ym, indexY), wndXMin + 2, wndY(ym, indexY));
                g.drawLine(wndXMax, wndY(ym, indexY), wndXMax - 2, wndY(ym, indexY));

                g.drawString("" + (int) (ym), wndXMin - 30, wndY(ym, indexY) + 5);
                g.drawString("" + (int) (ym), wndXMax + 10, wndY(ym, indexY) + 5);

                ym += yh;
            }
        } else {
            double py = 1.0 * (yMax - yMin) / rline;
            if (py < 0.1 && (myvision > 46 || myvision == 0))
                yh = 0.05;
            else if (py < 0.25)
                yh = 0.2;
            else
                yh = 0.5;

            double ym = (int) (yMin);

            if (ym > yMin) {
                while (ym > yMin)
                    ym -= yh;
                ym += yh;
            } else {
                while (ym < yMin)
                    ym += yh;
            }

            while (ym < yMax) {
                g.drawLine(wndXMin, wndY(ym, indexY), wndXMin + 2, wndY(ym, indexY));
                g.drawLine(wndXMax, wndY(ym, indexY), wndXMax - 2, wndY(ym, indexY));

                if (yh != 0.05) {
                    g.drawString("" + (double) (Math.round(ym * 10) / 10.0), wndXMin - 30, wndY(ym, indexY) + 5);
                    g.drawString("" + (double) (Math.round(ym * 10) / 10.0), wndXMax + 10, wndY(ym, indexY) + 5);
                } else {
                    g.drawString("" + (double) (Math.round(ym * 100) / 100.0), wndXMin - 30, wndY(ym, indexY) + 5);
                    g.drawString("" + (double) (Math.round(ym * 100) / 100.0), wndXMax + 10, wndY(ym, indexY) + 5);
                }

                ym += yh;
            }
        }
    }

    public double razdelSlow(int nk, int in1, int in2, int in3) {
        double Max1, Max2, Max3, Min1, Min2, Min3, delta;

        Max1 = Math.sqrt(MaxMin[in1 + 9][in1] * MaxMin[in1 + 9][in1] + MaxMin[in1 + 9][in2] * MaxMin[in1 + 9][in2] + MaxMin[in1 + 9][in3] * MaxMin[in1 + 9][in3]);
        Max2 = Math.sqrt(MaxMin[in2 + 9][in1] * MaxMin[in2 + 9][in1] + MaxMin[in2 + 9][in2] * MaxMin[in2 + 9][in2] + MaxMin[in2 + 9][in3] * MaxMin[in2 + 9][in3]);
        Max3 = Math.sqrt(MaxMin[in3 + 9][in1] * MaxMin[in3 + 9][in1] + MaxMin[in3 + 9][in2] * MaxMin[in3 + 9][in2] + MaxMin[in3 + 9][in3] * MaxMin[in3 + 9][in3]);

        Min1 = Math.sqrt(MaxMin[in1][in1] * MaxMin[in1][in1] + MaxMin[in1][in2] * MaxMin[in1][in2] + MaxMin[in1][in3] * MaxMin[in1][in3]);
        Min2 = Math.sqrt(MaxMin[in2][in1] * MaxMin[in2][in1] + MaxMin[in2][in2] * MaxMin[in2][in2] + MaxMin[in2][in3] * MaxMin[in2][in3]);
        Min3 = Math.sqrt(MaxMin[in3][in1] * MaxMin[in3][in1] + MaxMin[in3][in2] * MaxMin[in3][in2] + MaxMin[in3][in3] * MaxMin[in3][in3]);

        Max1 = myMax3(Max1, Max2, Max3);
        Min1 = myMax3(Min1, Min2, Min3);

        if (Max1 > Min1)
            delta = 1.0 * Max1 / nk;
        else
            delta = 1.0 * Min1 / nk;

        return delta;
    }

    public double razdelSlowMod(int nk) {
        double Max, Min, delta;

        Max = myMax3(myMod(0, 9), myMod(3, 9), myMod(6, 9));
        Min = myMax3(myMod(0, 0), myMod(3, 0), myMod(6, 0));

        if (Math.abs(Max) > Math.abs(Min))
            delta = 1.0 * Math.abs(Max) / nk;
        else
            delta = 1.0 * Math.abs(Min) / nk;

        return delta;
    }

    public int slow(int nk, double m1, double m2, double m3, int nom) {
        //закон нарастания - геометрическая прогрессия
        double p = Math.sqrt(m1 * m1 + m2 * m2 + m3 * m3);

        for (int j = 0; j < nk; j++)
            if (p < stepen[nom][j])
                return (int) (nk - j);

        return 1;
    }

    public int slow_ravnomer(int nk, double m1, double m2, double m3, double delta) {
        //для равномерного случая
        double p = Math.sqrt(m1 * m1 + m2 * m2 + m3 * m3);
        int ps = nk - (int) (p / delta);

        if (ps > 0)
            return ps;
        return 1;

    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(sizePanel - 1, 0, sizePanel - 1, sizeY);

        if (first != 0)
            draw();
    }

    public void draw() {
        Graphics g = getGraphics();

        if (myvision > 27 && myvision < 35)
            osXYZ(myvision - 28, 0);
        else if (myvision > 39 && myvision < 47)
            osXYZ(myvision - 40 + 7, 0);

        if (tstart == 0) {
            for (int i = 0; i < 18; i++)
                input[i] = avstart[i];
        } else {
            for (int i = 0; i < 18; i++)
                input[i] = avlast[i];
        }

        double delta[] = new double[7];

        if (first == 1) {
            for (int i = 0; i < 602; i++)
                for (int j = 0; j < 402; j++)
                    img_EUK[i][j] = 0;

            if (myfile == 1) {
                for (int i = 0; i < 3; i++) {
                    delta[i] = razdelSlow(25, i * 3, i * 3 + 1, i * 3 + 2);
                    delta[i + 3] = razdelSlow(25, i, i + 3, i + 6);
                }

                delta[6] = razdelSlowMod(25);
            }
        }

        long i = tstart;

        if (myvision == 0) {
            Color col = new Color(0, 0, 139);
            g.setColor(col);

            if (first == 1 && myfile == 0) {

                maxMin[18][0] = -16;
                maxMin[18][1] = -5.0;
                maxMin[19][0] = 0;
                maxMin[19][1] = tb;

                for (int i1 = 9; i1 < 18; i1++) {
                    maxMin[i1][0] = -2;
                    maxMin[i1][1] = 2;
                }

                for (int i1 = 0; i1 < 18; i1++)
                    avlast[i1] = input[i1];

                for (int i1 = 0; i1 < 9; i1++) {
                    if (input[i1] > 0) {
                        MaxMin[i1 + 9][i1] = input[i1];
                        MaxMin[i1][i1] = 0.0;
                    } else {
                        MaxMin[i1][i1] = input[i1];
                        MaxMin[i1 + 9][i1] = 0.0;
                    }
                }

                shcala(19, 18);
                int px, py;
                double myE, tlast = tstart * h;
                double tnegolh, tnegol = (tb - ta) * 1.0 / Nmas;
                tnegolh = tnegol;


                b = new double[][]{
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.07407407407407407, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.027777777777777776, 0.08333333333333333, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.041666666666666664, 0.0, 0.125, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.4166666666666667, 0.0, -1.5625, 1.5625, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.05, 0.0, 0.0, 0.25, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {-0.23148148148148148, 0.0, 0.0, 1.1574074074074074, -2.4074074074074074, 2.314814814814815, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.10333333333333333, 0.0, 0.0, 0.0, 0.27111111111111114, -0.2222222222222222, 0.014444444444444444, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {2.0, 0.0, 0.0, -8.833333333333334, 15.644444444444444, -11.88888888888889, 0.7444444444444445, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {-0.8425925925925926, 0.0, 0.0, 0.21296296296296297, -7.229629629629629, 5.7592592592592595, -0.31666666666666665, 2.8333333333333335, -0.08333333333333333, 0.0, 0.0, 0.0, 0.0},
                        {0.5812195121951219, 0.0, 0.0, -2.0792682926829267, 4.3863414634146345, -3.6707317073170733, 0.5202439024390244, 0.5487804878048781, 0.27439024390243905, 0.43902439024390244, 0.0, 0.0, 0.0},
                        {0.014634146341463415, 0.0, 0.0, 0.0, 0.0, -0.14634146341463414, -0.014634146341463415, -0.07317073170731707, 0.07317073170731707, 0.14634146341463414, 0.0, 0.0, 0.0},
                        {-0.43341463414634146, 0.0, 0.0, -2.0792682926829267, 4.3863414634146345, -3.524390243902439, 0.5348780487804878, 0.6219512195121951, 0.20121951219512196, 0.2926829268292683, 0.0, 1.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
                };

                c = new double[]{0.04880952380952381, 0.0, 0.0, 0.0, 0.0, 0.3238095238095238, 0.2571428571428571, 0.2571428571428571, 0.03214285714285714, 0.03214285714285714, 0.0, 0.0, 0.04880952380952381, 0.0, 0.0, 0.0, 0.0, 0.0};
                input = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5446230076646713, 0.257800690054833, 0.25436137854197866, 0.2461605091991794, -0.3193534630602443, 0.628712774525114, 0.5874934622379206, -0.5699922058548407, 0.5867911096969345};


                //long time = nativeCalc.run(b,c,MaxMin,input,tstart,tb,h);

                //System.out.println("Execution time: " + time);

                long startTime = System.currentTimeMillis();
                // Calculator calc = new Calculator(new TripletFunctions());


                while (tlast < tb) {

                    //calc.solveByRK(input,b,c,h);
                    schetstep();

                    for (int s = 0; s < 9; s++) {
                        if (input[s] > 0) {
                            if (input[s] > MaxMin[s + 9][s])
                                for (int j = 0; j < 9; j++)
                                    MaxMin[s + 9][j] = input[j];
                        } else if (input[s] < MaxMin[s][s])
                            for (int j = 0; j < 9; j++)
                                MaxMin[s][j] = input[j];
                    }

                    myE = EUK();

                    px = wndX(tlast, 19);
                    py = wndY(myE, 18);
                    if (py - wndYMin < 400 && py - wndYMin > 50) {
                        if (img_EUK[px - wndXMin + 1][py - wndYMin + 1] != 1) {
                            img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
                            g.fillRect(px, py, 1, 1);
                            //g.fillOval(px, py, 1, 1);
                        }

                    }

                    tlast += h;
                    i++;

                    if (tlast > tnegol && gol < Nmas - 1) {
                        gol++;
                        negolonomnost(tlast);
                        tnegol += tnegolh;
                    }

                }


                for (int s = 0; s < 9; s++) {
                    maxMin[s][0] = MaxMin[s][s];
                    maxMin[s][1] = MaxMin[s + 9][s];
                }

                System.out.println("Done in: " + (System.currentTimeMillis() - startTime));

            }
            if (first == 1 && myfile == 1) {

                maxMin[18][0] = -16;
                maxMin[18][1] = -5.0;
                shcala(19, 18);
                int px, py;
                double myE, tlast = tstart * h;
                double tnegolh, tnegol = (tb - ta) * 1.0 / Nmas;
                tnegolh = tnegol;

                while (tlast < tb) {
                    schetstep();

                    //Thread thread = new Thread();
                    zapolnGrap(i, delta, delta100);

                    myE = EUK();

                    px = wndX(tlast, 19);
                    py = wndY(myE, 18);
                    if (py - wndYMin < 400 && py - wndYMin > -2) {
                        if (img_EUK[px - wndXMin + 1][py - wndYMin + 1] != 1) {
                            img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
                            g.fillRect(px, py, 1, 1);
                            //g.fillOval(px, py, 1, 1);
                        }
                    }

                    tlast += h;
                    i++;

                    if (tlast > tnegol && gol < Nmas - 1) {
                        gol++;
                        negolonomnost(tlast);
                        tnegol += tnegolh;
                    }
                }

                /*
		  		//скользящее среднее
		  		
		  		maxMin[20][0] = 0.0;
		  		maxMin[20][1] = 1.0;
		  		maxMin[21][0] = ta;
		  		maxMin[21][1] = tb;
		  		
		  		shcala(21, 20);
				int px, py, mydelta = 10000000, myd = 0;
				double myE = 0, myE_sum = 0, myK = 0, myK_sum = 0, tlast = tstart*h;
				double uv, kv;
				double tnegolh, tnegol = (tb - ta)*1.0/Nmas;
				tnegolh = tnegol; 
				
				double my_d[] = new double[mydelta];
				double my_kd[] = new double[mydelta];
				my_d[0] = U();
				my_kd[0] = K();
				
				//col = new Color(0,0,139);
			  	//g.setColor(col);
			  	
				while (tlast < tb)
		        {
		            schetstep();
		            zapolnGrap(i, delta, delta100);
		       
		            maxMin[20][0] = 0.0;
			  		maxMin[20][1] = 1.0;
			  		maxMin[21][0] = ta;
			  		maxMin[21][1] = tb;
			  		
		            if(i < mydelta - 1)
		            {
		            	my_d[(int)(i)+1] = U();
		            	myE_sum += my_d[(int)(i)+1];
		            	
		            	my_kd[(int)(i)+1] = K();
		            	myK_sum += my_kd[(int)(i)+1];
		            	
		            	
		            	col = new Color(200,0,0);
					  	g.setColor(col);
					  	
					  	px = wndX(tlast, 21);
			    		py = wndY(my_d[(int)(i)+1], 20);
			    		
			    		if(py - wndYMin < 400)
			    		{
			    			img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
			    			g.fillOval(px, py, 1, 1);
			    		}
			    		
		            }
		            else
		            {
		            	uv = U();
		            	myE_sum = myE_sum + uv - my_d[myd];
		            	myE = myE_sum*1.0/mydelta;
			    		my_d[myd] = uv;
			    		
			    		kv = K();
			    		myK_sum = myK_sum + kv - my_kd[myd];
		            	myK = myK_sum*1.0/mydelta;
			    		my_kd[myd] = kv;
			    		
			    		col = new Color(200,0,0);
					  	g.setColor(col);
					  	
					  	px = wndX(tlast, 21);
			    		py = wndY(myK, 20);
			    		
			    		if(py - wndYMin < 400)
			    		{
			    			img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;
			    			g.fillOval(px, py, 1, 1);
			    		}
			    		
			    		px = wndX(tlast, 21);
			    		py = wndY(myE, 20);
				    		
				    	col = new Color(0,0,139);
						g.setColor(col);
						  	
				    	if(py - wndYMin < 400)
				    	{
				    		img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 2;
				    		g.fillOval(px, py, 1, 1);
				    	}
				    		
			    		myd++;
			    		
			    		if(myd == mydelta)
			    			myd = 0;
		            }
		            tlast += h; i++;
		            
		            
		            if(tlast > tnegol && gol < Nmas - 1)
		  			{
		  				gol++;
		  				negolonomnost(tlast);
		  				tnegol += tnegolh;
		  			}
		        }*/
            } else {
                col = new Color(0, 0, 139);
                g.setColor(col);

                shcala(19, 18);
                for (int j1 = 0; j1 < 602; j1++)
                    for (int j2 = 0; j2 < 402; j2++)
                        if (img_EUK[j1][j2] == 1)
                            g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, 1, 1);

            }
        } else if (myvision < 19) {
            if (myvision < 10) {
                Color col = new Color(0, 0, 205);
                g.setColor(col);
            } else {
                Color col = new Color(139, 0, 0);
                g.setColor(col);
            }


            int index = myvision - 1;
            shcala(19, index);

            if (first == 1) {
                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    g.fillOval(wndX(i * h, 19), wndY(input[index], index), 1, 1);
                    i++;
                }
            } else if (myvision == 1)
                draw_img_1(img_u11);
            else if (myvision == 2)
                draw_img_1(img_u12);
            else if (myvision == 3)
                draw_img_1(img_u13);
            else if (myvision == 4)
                draw_img_1(img_u21);
            else if (myvision == 5)
                draw_img_1(img_u22);
            else if (myvision == 6)
                draw_img_1(img_u23);
            else if (myvision == 7)
                draw_img_1(img_u31);
            else if (myvision == 8)
                draw_img_1(img_u32);
            else if (myvision == 9)
                draw_img_1(img_u33);
            else if (myvision == 10)
                draw_img_1(img_uc11);
            else if (myvision == 11)
                draw_img_1(img_uc12);
            else if (myvision == 12)
                draw_img_1(img_uc13);
            else if (myvision == 13)
                draw_img_1(img_uc21);
            else if (myvision == 14)
                draw_img_1(img_uc22);
            else if (myvision == 15)
                draw_img_1(img_uc23);
            else if (myvision == 16)
                draw_img_1(img_uc31);
            else if (myvision == 17)
                draw_img_1(img_uc32);
            else if (myvision == 18)
                draw_img_1(img_uc33);
        } else if (myvision < 28) {
            Color col = new Color(153, 50, 204);
            g.setColor(col);

            int index1 = myvision - 19, index2 = myvision - 10;

            shcala(index1, index2);

            if (first == 1) {
                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);
                    g.fillOval(wndX(input[index1], index1), wndY(input[index2], index2), 1, 1);
                    i++;
                }
            } else if (myvision == 19)
                draw_img_1(img_uf11);
            else if (myvision == 20)
                draw_img_1(img_uf12);
            else if (myvision == 21)
                draw_img_1(img_uf13);
            else if (myvision == 22)
                draw_img_1(img_uf21);
            else if (myvision == 23)
                draw_img_1(img_uf22);
            else if (myvision == 24)
                draw_img_1(img_uf23);
            else if (myvision == 25)
                draw_img_1(img_uf31);
            else if (myvision == 26)
                draw_img_1(img_uf32);
            else if (myvision == 27)
                draw_img_1(img_uf33);
        } else if (myvision < 31) {
            int px, py;
            int col[] = new int[3];

            if (first == 1) {
                int index = (myvision - 28) * 3;
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    px = wndXYAll(input[index] + input[index + 2] * Math.cos(alpha), index / 3);
                    py = wndYAll(input[index + 1] + input[index + 2] * Math.sin(alpha), index / 3);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        if (index == 0)
                            myNewColor(col, img3D_u1All[x1][y1]);
                        else if (index == 3)
                            myNewColor(col, img3D_u2All[x1][y1]);
                        else
                            myNewColor(col, img3D_u3All[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else {
                if (myvision == 28)
                    draw_img_3D(img3D_u1All);
                else if (myvision == 29)
                    draw_img_3D(img3D_u2All);
                else
                    draw_img_3D(img3D_u3All);
            }

            if (mykadr == 1) {
                System.out.println("начальные условия в для счета last со времени " + tend);
                for (int ii = 0; ii < 18; ii++) {
                    avlast[ii] = input[ii];
                    System.out.println(ii + ": " + input[ii]);
                }
            }

        } else if (myvision < 34) {
            int px, py;
            int col[] = new int[3];

            if (first == 1) {
                int index = myvision - 31;
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    px = wndXYAll(input[index] + input[index + 6] * Math.cos(alpha), index + 3);
                    py = wndYAll(input[index + 3] + input[index + 6] * Math.sin(alpha), index + 3);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        if (index == 0)
                            myNewColor(col, img3D_uAll1[x1][y1]);
                        else if (index == 1)
                            myNewColor(col, img3D_uAll2[x1][y1]);
                        else
                            myNewColor(col, img3D_uAll3[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else {
                if (myvision == 31)
                    draw_img_3D(img3D_uAll1);
                else if (myvision == 32)
                    draw_img_3D(img3D_uAll2);
                else
                    draw_img_3D(img3D_uAll3);
            }

            if (mykadr == 1) {
                System.out.println("начальные условия в для счета last со времени " + tend);
                for (int ii = 0; ii < 18; ii++) {
                    avlast[ii] = input[ii];
                    System.out.println(ii + ": " + input[ii]);
                }
            }
        } else if (myvision == 34) {
            int px, py;
            int col[] = new int[3];
            double mod1, mod2, mod3;

            if (first == 1) {
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    mod1 = myModav(0);
                    mod2 = myModav(3);
                    mod3 = myModav(6);

                    px = wndXYAll(mod1 + mod3 * Math.cos(alpha), 6);
                    py = wndYAll(mod2 + mod3 * Math.sin(alpha), 6);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        myNewColor(col, img3D_mod[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else
                draw_img_3D(img3D_mod);
        } else if (myvision == 35) {
            Color cgol = new Color(32, 178, 170);
            Color ros = new Color(238, 18, 137);
            Color fio = new Color(139, 0, 139);

            shcala(19, 18);

            for (int j = 0; j < gol; j++) {
                if (negol[0][j] > -16) {
                    g.setColor(cgol);
                    g.fillOval(wndX(negol[3][j], 19), wndY(negol[0][j], 18), 1, 1);
                }
                if (negol[1][j] > -16) {
                    g.setColor(ros);
                    g.fillOval(wndX(negol[3][j], 19), wndY(negol[1][j], 18), 1, 1);
                }
                if (negol[2][j] > -16) {
                    g.setColor(fio);
                    g.fillOval(wndX(negol[3][j], 19), wndY(negol[2][j], 18), 1, 1);
                }
            }

            System.out.println("gol = " + gol);
        } else if (myvision == 36) {
            int mycolor[][] = {{139, 0, 139}, {0, 0, 205}, {72, 118, 255},
                    {34, 139, 34}, {50, 205, 50}, {255, 215, 0},
                    {255, 69, 0}, {238, 0, 0}, {139, 0, 0}};

            for (int j = 0; j < 18; j++) {
                if (j < 9) {
                    Color col = new Color(mycolor[j][0], mycolor[j][1], mycolor[j][2]);
                    g.setColor(col);
                } else {
                    Color col = new Color(mycolor[j - 9][0], mycolor[j - 9][1], mycolor[j - 9][2]);
                    g.setColor(col);
                }

                maxMin[20][1] = maxMin[0][1];
                maxMin[20][0] = maxMin[0][0];

                for (int i1 = 1; i1 < 9; i1++) {
                    if (maxMin[i1][0] < maxMin[20][0])
                        maxMin[20][0] = maxMin[i1][0];
                    if (maxMin[i1][1] > maxMin[20][1])
                        maxMin[20][1] = maxMin[i1][1];
                }

                shcala(19, 20);

                g.drawLine(wndX(umas[j][2], 19), wndY(umas[j][1], 20), wndX(0, 19), wndY(0, 20));
                g.fillOval(wndX(umas[j][2], 19) - 2, wndY(umas[j][1], 20) - 2, 4, 4);

                for (int ii = 1; ii < 2 * umas[j][0] - 4; ii += 2) {
                    g.drawLine(wndX(umas[j][ii + 1], 19), wndY(umas[j][ii], 20), wndX(umas[j][ii + 3], 19), wndY(umas[j][ii + 2], 20));
                    g.fillOval(wndX(umas[j][ii + 3], 19) - 2, wndY(umas[j][ii + 2], 20) - 2, 4, 4);
                }
            }
        } else if (myvision > 36 && myvision < 40) {
            int mycolor[][] = {{139, 0, 139}, {0, 0, 205}, {72, 118, 255},
                    {34, 139, 34}, {50, 205, 50}, {255, 215, 0},
                    {255, 69, 0}, {238, 0, 0}, {139, 0, 0}};

            int index = (myvision - 37) * 3;

            maxMin[20][1] = maxMin[index][1];
            maxMin[20][0] = maxMin[index][0];

            for (int i1 = index; i1 < index + 3; i1++) {
                if (maxMin[i1][0] < maxMin[20][0])
                    maxMin[20][0] = maxMin[i1][0];
                if (maxMin[i1][1] > maxMin[20][1])
                    maxMin[20][1] = maxMin[i1][1];
            }

            shcala(19, 20);

            for (int j = index; j < index + 3; j++) {
                Color col = new Color(mycolor[j][0], mycolor[j][1], mycolor[j][2]);
                g.setColor(col);

                g.drawLine(wndX(umas[j][2], 19), wndY(umas[j][1], 20), wndX(0, 19), wndY(0, 20));
                g.fillOval(wndX(umas[j][2], 19) - 2, wndY(umas[j][1], 20) - 2, 4, 4);

                for (int ii = 1; ii < 2 * umas[j][0] - 4; ii += 2) {
                    g.drawLine(wndX(umas[j][ii + 1], 19), wndY(umas[j][ii], 20), wndX(umas[j][ii + 3], 19), wndY(umas[j][ii + 2], 20));
                    g.fillOval(wndX(umas[j][ii + 3], 19) - 2, wndY(umas[j][ii + 2], 20) - 2, 4, 4);
                }
                g.drawLine(wndX(umas[j + 9][2], 19), wndY(umas[j + 9][1], 20), wndX(0, 19), wndY(0, 20));
                g.fillOval(wndX(umas[j + 9][2], 19) - 2, wndY(umas[j + 9][1], 20) - 2, 4, 4);

                for (int ii = 1; ii < 2 * umas[j + 9][0] - 4; ii += 2) {
                    g.drawLine(wndX(umas[j + 9][ii + 1], 19), wndY(umas[j + 9][ii], 20), wndX(umas[j + 9][ii + 3], 19), wndY(umas[j + 9][ii + 2], 20));
                    g.fillOval(wndX(umas[j + 9][ii + 3], 19) - 2, wndY(umas[j + 9][ii + 2], 20) - 2, 4, 4);
                }

            }
        } else if (myvision < 43) {
            int px, py;
            int col[] = new int[3];

            if (first == 1) {
                int index = (myvision - 40) * 3;
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    px = wndXYAll(input[index] - input[index + 2] * Math.cos(alpha), index / 3 + 7);
                    py = wndYAll(input[index + 1] - input[index + 2] * Math.sin(alpha), index / 3 + 7);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        if (index == 0)
                            myNewColor(col, imgD3_u1All[x1][y1]);
                        else if (index == 3)
                            myNewColor(col, imgD3_u2All[x1][y1]);
                        else
                            myNewColor(col, imgD3_u3All[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else {
                if (myvision == 40)
                    draw_img_3D(imgD3_u1All);
                else if (myvision == 41)
                    draw_img_3D(imgD3_u2All);
                else
                    draw_img_3D(imgD3_u3All);
            }
            /*	
				if(mykadr == 1)
				{
					System.out.println("начальные условия в для счета last со времени " + tend);
					for(int ii = 0; ii< 18; ii++)
					{
						avlast[ii] = input[ii];
						System.out.println(ii+ ": " + input[ii]);
					}
				}
		  	*/
        } else if (myvision < 46) {
            int px, py;
            int col[] = new int[3];

            if (first == 1) {
                int index = myvision - 43;
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    px = wndXYAll(input[index] - input[index + 6] * Math.cos(alpha), index + 10);
                    py = wndYAll(input[index + 3] - input[index + 6] * Math.sin(alpha), index + 10);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        if (index == 0)
                            myNewColor(col, imgD3_uAll1[x1][y1]);
                        else if (index == 1)
                            myNewColor(col, imgD3_uAll2[x1][y1]);
                        else
                            myNewColor(col, imgD3_uAll3[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else {
                if (myvision == 43)
                    draw_img_3D(imgD3_uAll1);
                else if (myvision == 44)
                    draw_img_3D(imgD3_uAll2);
                else
                    draw_img_3D(imgD3_uAll3);
            }
            /*
			if(mykadr == 1)
			{
				System.out.println("начальные условия в для счета last со времени " + tend);
				for(int ii = 0; ii< 18; ii++)
				{
					avlast[ii] = input[ii];
					System.out.println(ii+ ": " + input[ii]);
				}
			}*/
        } else if (myvision == 46) {
            int px, py;
            int col[] = new int[3];
            double mod1, mod2, mod3;

            if (first == 1) {
                int x1, y1;

                while (i < tend) {
                    schetstep();
                    zapolnGrap(i, delta, delta100);

                    mod1 = myModav(0);
                    mod2 = myModav(3);
                    mod3 = myModav(6);

                    px = wndXYAll(mod1 - mod3 * Math.cos(alpha), 13);
                    py = wndYAll(mod2 - mod3 * Math.sin(alpha), 13);

                    x1 = px - wndXMin + 10;
                    y1 = py - wndYMin + 10;

                    if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                        myNewColor(col, imgD3_mod[x1][y1]);

                        Color colC = new Color(col[0], col[1], col[2]);
                        g.setColor(colC);
                        g.fillOval(px, py, 1, 1);
                    }
                    i++;
                }
            } else
                draw_img_3D(imgD3_mod);
        } else if (myvision < 54) {
            int index = myvision - 47;

            Pk[index][0] = Math.log10(Nkslow[index][SLOW_CONST - 1] * h / (Nh * 4.0 / 3 * PI * Math.pow(delta100[index], 3)));
            for (int j2 = 1; j2 < SLOW_CONST; j2++)
                Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1 - j2] * h / (4.0 / 3 * PI * Nh * (Math.pow(stepen[index][j2], 3) - Math.pow(stepen[index][j2 - 1], 3))));

            //Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1- j2]*h/(4*PI*(j2 + 1)*(j2 + 1)*Nh*delta100[index]*delta100[index]));

            //Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1- j2]*h/(4.0/3*PI*Nh*(Math.pow(stepen[index][j2],3)-Math.pow(stepen[index][j2-1],3))));
            //Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1- j2]*h/(4*PI*Nh*stepen[index][j2]*stepen[index][j2]*(stepen[index][j2]-stepen[index][j2-1])));

            //Pk[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1- j2]*h/(4*PI*(j2 + 1)*(j2 + 1)*Nh*delta100[index]*delta100[index]));

            /*
			if(index < 6)
				monte_karlo(Pc, Pk, index);
			else
				monte_karlo_mod(Pc, Pk);
			*/
            double kof[] = new double[2];
            macshtab2(Pk, index, kof, SLOW_CONST - 1);
            maxMin[21][0] = Math.log10(delta100[index]);
            //maxMin[21][1] = Math.log10(delta100[index]*99);
            maxMin[21][1] = Math.log10(delta100[index] * Math.pow(Q100, 98));
            maxMin[20][0] = kof[0];
            maxMin[20][1] = kof[1];
            //maxMin[20][1] = kof[1] - kof[1]/20.0;

            shcala(21, 20);

            if (myvision < 50) {
                Color col = new Color(0, 0, 205);
                g.setColor(col);
            } else if (myvision < 53) {
                Color col = new Color(139, 0, 0);
                g.setColor(col);
            } else {
                Color col = new Color(153, 50, 204);
                g.setColor(col);
            }

            for (int ii = 0; ii < SLOW_CONST - 2; ii++) {
                //равномерно
                //g.drawLine(wndX(Math.log10((ii+1)*delta100[index]), 21), wndY(Pk[index][ii], 20), wndX(Math.log10((ii+2)*delta100[index]), 21), wndY(Pk[index][ii+1], 20));
                //g.fillOval(wndX(Math.log10((ii+1)*delta100[index]), 21)-2, wndY(Pk[index][ii], 20)-2, 4, 4);

                g.drawLine(wndX(Math.log10(delta100[index] * Math.pow(Q100, ii)), 21), wndY(Pk[index][ii], 20), wndX(Math.log10(delta100[index] * Math.pow(Q100, ii + 1)), 21), wndY(Pk[index][ii + 1], 20));
                g.fillOval(wndX(Math.log10(delta100[index] * Math.pow(Q100, ii)), 21) - 2, wndY(Pk[index][ii], 20) - 2, 4, 4);

            }
            //g.fillOval(wndX(Math.log10((SLOW_CONST-1)*delta100[index]), 21)-2, wndY(Pk[index][98], 20)-2, 4, 4);	
            g.fillOval(wndX(Math.log10(delta100[index] * Math.pow(Q100, 98)), 21) - 2, wndY(Pk[index][98], 20) - 2, 4, 4);

            /*
			double p;

			g.setColor(Color.red);
			
			if(index < 6)
			{
				for(double x = delta100[index]; x < Pc[3][index]*delta100[index]; x += 0.001)
				{
					p = Math.log10(Pc[1][index]*1.0/(1+Math.pow(x*1.0/Pc[2][index], Pc[0][index])));
					g.fillOval(wndX(Math.log10(x), 21), wndY(p, 20), 1, 1);
				}
			}
			else
			{
				for(double x = delta100[index]*(Pc[5][index] + 1); x < Pc[3][index]*delta100[index]; x += 0.001)
				{
					p = Math.log10(Pc[1][index]*Math.pow(x*1.0/Pc[2][index], Pc[4][index])*1.0/(1+Math.pow(x*1.0/Pc[2][index], Pc[0][index]+Pc[4][index])));
					g.fillOval(wndX(Math.log10(x), 21), wndY(p, 20), 1, 1);
				}
			}*/
        } else if (myvision < 61) {
            int index = myvision - 54;

            for (int j2 = 0; j2 < SLOW_CONST; j2++)
                Pk20[index][j2] = Nkslow[index][SLOW_CONST - 1 - j2] * 1.0 / Nh;

            double kof[] = new double[2];
            macshtab2(Pk20, index, kof, SLOW_CONST);
            maxMin[21][0] = Math.log10(delta100[index]);
            maxMin[21][1] = Math.log10(100 * delta100[index]);
            maxMin[20][0] = kof[0];
            maxMin[20][1] = kof[1];


            shcala(21, 20);

            if (myvision < 57) {
                Color col = new Color(0, 0, 205);
                g.setColor(col);
            } else if (myvision < 60) {
                Color col = new Color(139, 0, 0);
                g.setColor(col);
            } else {
                Color col = new Color(153, 50, 204);
                g.setColor(col);
            }

            for (int ii = 0; ii < SLOW_CONST - 1; ii++) {
                g.drawLine(wndX(Math.log10((ii + 1) * delta100[index]), 21), wndY(Pk20[index][ii], 20), wndX(Math.log10((ii + 2) * delta100[index]), 21), wndY(Pk20[index][ii + 1], 20));
                g.fillOval(wndX(Math.log10((ii + 1) * delta100[index]), 21) - 2, wndY(Pk20[index][ii], 20) - 2, 4, 4);
            }
            g.fillOval(wndX(Math.log10(SLOW_CONST * delta100[index]), 21) - 2, wndY(Pk20[index][99], 20) - 2, 4, 4);
        } else if (myvision < 68) {
            int index = myvision - 61;

            for (int j2 = 0; j2 < SLOW_CONST; j2++)
                PkN[index][j2] = Math.log10(Nkslow[index][SLOW_CONST - 1 - j2] * 1.0 / Nh);

            double kof[] = new double[2];
            macshtab2(PkN, index, kof, SLOW_CONST);
            //maxMin[21][0] = Math.log10(delta100[index]);
            //maxMin[21][1] = Math.log10(SLOW_CONST*delta100[index]);
            maxMin[21][0] = delta100[index];
            maxMin[21][1] = SLOW_CONST * delta100[index];
            maxMin[20][0] = kof[0];
            maxMin[20][1] = kof[1];

            shcala(21, 20);

            if (myvision < 64) {
                Color col = new Color(0, 0, 205);
                g.setColor(col);
            } else if (myvision < 67) {
                Color col = new Color(139, 0, 0);
                g.setColor(col);
            } else {
                Color col = new Color(153, 50, 204);
                g.setColor(col);
            }

            for (int ii = 0; ii < SLOW_CONST - 1; ii++) {
                //g.drawLine(wndX(Math.log10((ii+1)*delta100[index]), 21), wndY(PkN[index][ii], 20), wndX(Math.log10((ii+2)*delta100[index]), 21), wndY(PkN[index][ii+1], 20));
                //g.fillOval(wndX(Math.log10((ii+1)*delta100[index]), 21)-2, wndY(PkN[index][ii], 20)-2, 4, 4);

                g.drawLine(wndX((ii + 1) * delta100[index], 21), wndY(PkN[index][ii], 20), wndX((ii + 2) * delta100[index], 21), wndY(PkN[index][ii + 1], 20));
                g.fillOval(wndX((ii + 1) * delta100[index], 21) - 2, wndY(PkN[index][ii], 20) - 2, 4, 4);
            }
            g.fillOval(wndX(SLOW_CONST * delta100[index], 21) - 2, wndY(PkN[index][99], 20) - 2, 4, 4);
        } else if (myvision < 77) {
            if (first == 1) {
                maxMin[19][0] = 0;
                maxMin[19][1] = tb;

                avstart[0] = 0.2780761047776666;
                avstart[1] = -0.12845049504506342;
                avstart[2] = -0.594273482409198;
                avstart[3] = 0.49482083474871474;
                avstart[4] = 0.025163790441152446;
                avstart[5] = 0.03179905988701076;
                avstart[6] = 0.47974141170465007;
                avstart[7] = 0.16736590187900602;
                avstart[8] = -0.5634247759565282;
                avstart[9] = 0.2593301495318718;
                avstart[10] = -0.21923717653225333;
                avstart[11] = 0.33098527074505446;
                avstart[12] = -0.3154378784747257;
                avstart[13] = 0.21620023533714908;
                avstart[14] = -0.4186909130466871;
                avstart[15] = 0.1877076255752361;
                avstart[16] = 1.08237440588539;
                avstart[17] = 0.020078625761224746;

                for (int i1 = 0; i1 < 18; i1++)
                    input[i1] = avstart[i1];

                for (int i1 = 0; i1 < 9; i1++) {
                    if (input[i1] > 0) {
                        MaxMin[i1 + 9][i1] = input[i1];
                        MaxMin[i1][i1] = 0.0;
                    } else {
                        MaxMin[i1][i1] = input[i1];
                        MaxMin[i1 + 9][i1] = 0.0;
                    }
                }

                for (int j = 1; j < 3; j++) {
                    for (int i1 = 0; i1 < 18; i1++)
                        input[i1] = avstart[i1];

                    if (j == 0) {
                        //mp = 4;
                        //masRK4(c,b,mp);
                        h = 0.0001;
                    } else if (j == 1) {
                        mp = 7;
                        masRKB6(c, b, mp);
                        i = tstart;
                        //h = 0.00005;
                    } else {
                        //mp = 13;
                        //masRKF8(c,b,mp);
                        mp = 7;
                        masRKB6(c, b, mp);
                        i = (long) (10.0 / h);

                        try {
                            dosslowr = new DataInputStream(new BufferedInputStream(new FileInputStream(myslowr), 128));

                            for (int i1 = 0; i1 < 18; i1++)
                                avlast[i1] = dosslowr.readDouble();

                            //for(int i1 = 0; i1 < 18; i1++)
                            int t = (int) (Math.random() * 18);

                            avlast[t] += 0.0000000000000001;

                            System.out.println("преобразую  i = " + t + " результат " + avlast[t]);

                        } catch (SecurityException e) {
                            System.out.println("writeFile: caught security exception: " + e);
                        } catch (IOException ioe) {
                            System.out.println("writeFile: файл не найден ");
                        }

                        for (int i1 = 0; i1 < 18; i1++)
                            input[i1] = avlast[i1];
                        //h = 0.00001;
                    }

                    //i = tstart;
                    tend = (long) ((tb - ta) / h) + 1;

                    while (i < tend) {
                        schetstep();

                        //if(i >= 100.0/h)
                        //{
                        for (int s = 0; s < 9; s++) {
                            if (input[s] > MaxMin[s + 9][s])
                                MaxMin[s + 9][s] = input[s];
                            else if (input[s] < MaxMin[s][s])
                                MaxMin[s][s] = input[s];
                        }
                        //}

                        if (i == (long) (10.0 / h) && j == 1) {
                            //for(int i1 = 0; i1 < 18; i1++)
                            //avlast[i1] = input[i1];

                            try {
                                dosslow = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(myslow), 128));

                                for (int j1 = 0; j1 < 18; j1++)
                                    dosslow.writeDouble(input[j1]);

                                for (int j1 = 0; j1 < 18; j1++)
                                    System.out.println("запись " + input[j1]);

                                dosslow.flush();
                            } catch (SecurityException e) {
                                System.out.println("writeFile: caught security exception: " + e);
                            } catch (IOException ioe) {
                                System.out.println("writeFile: caught i/o exception: запись не удалась");
                            }
                        }
                        i++;
                    }
                }

                for (int s = 0; s < 9; s++) {
                    maxMin[s][0] = MaxMin[s][s];
                    maxMin[s][1] = MaxMin[s + 9][s];
                }

                int px, py, index = myvision - 68;

                for (int ij = 0; ij < 602; ij++)
                    for (int j = 0; j < 402; j++) {
                        img_u11[ij][j] = 0;
                        img_u12[ij][j] = 0;
                        img_u13[ij][j] = 0;
                        img_u21[ij][j] = 0;
                        img_u22[ij][j] = 0;
                        img_u23[ij][j] = 0;
                        img_u31[ij][j] = 0;
                        img_u32[ij][j] = 0;
                        img_u33[ij][j] = 0;
                    }

                maxMin[19][0] = 0;
                maxMin[19][1] = tb;
                shcala(19, index);

                for (byte j = 2; j < 4; j++) {
                    for (int i1 = 0; i1 < 18; i1++)
                        input[i1] = avstart[i1];

                    if (j == 1) {
                        //mp = 4;
                        //masRK4(c,b,mp);
                        h = 0.0001;

                        Color col = new Color(0, 160, 0);
                        g.setColor(col);
                    } else if (j == 2) {
                        mp = 7;
                        masRKB6(c, b, mp);
                        i = tstart;
                        //h = 0.00005;

                        Color col = new Color(210, 0, 0);
                        g.setColor(col);
                    } else {
                        //mp = 13;
                        //masRKF8(c,b,mp);
                        //h = 0.00001;

                        mp = 7;
                        masRKB6(c, b, mp);
                        i = (long) (10.0 / h);

                        for (int i1 = 0; i1 < 18; i1++)
                            input[i1] = avlast[i1];

                        Color col = new Color(0, 0, 200);
                        g.setColor(col);
                    }

                    //i = tstart;
                    tend = (long) ((tb - ta) / h) + 1;

                    while (i < tend) {
                        schetstep();

                        //if(i >= 100.0/h)
                        //{
                        px = wndX(i * h, 19);

                        py = wndY(input[0], 0);
                        img_u11[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[1], 1);
                        img_u12[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[2], 2);
                        img_u13[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[3], 3);
                        img_u21[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[4], 4);
                        img_u22[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[5], 5);
                        img_u23[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[6], 6);
                        img_u31[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[7], 7);
                        img_u32[px - wndXMin + 1][py - wndYMin + 1] = j;
                        py = wndY(input[8], 8);
                        img_u33[px - wndXMin + 1][py - wndYMin + 1] = j;

                        py = wndY(input[index], index);
                        g.fillOval(px, py, 1, 1);
                        //}
                        i++;
                    }
                }
            } else {
                int index = myvision - 68;
                shcala(19, index);

                if (index == 0)
                    draw_img(img_u11);
                else if (index == 1)
                    draw_img(img_u12);
                else if (index == 2)
                    draw_img(img_u13);
                else if (index == 3)
                    draw_img(img_u21);
                else if (index == 4)
                    draw_img(img_u22);
                else if (index == 5)
                    draw_img(img_u23);
                else if (index == 6)
                    draw_img(img_u31);
                else if (index == 7)
                    draw_img(img_u32);
                else if (index == 8)
                    draw_img(img_u33);
            }
        } else if (myvision < 133) {
            int index = myvision - 77;

            if (index < 8)
                osXYZ(14 + index, index + 1);
            else if (index < 16)
                osXYZ(14 + index, index - 8 + 1);
            else if (index < 24)
                osXYZ(14 + index, index - 16 + 1);
            else if (index < 32)
                osXYZ(14 + index, index - 24 + 1);
            else if (index < 40)
                osXYZ(14 + index, index - 32 + 1);
            else if (index < 48)
                osXYZ(14 + index, index - 40 + 1);
            else
                osXYZ(14 + index, index - 48 + 1);

            if (index == 0)
                draw_img_D8(D8_u1All_1);
            else if (index == 1)
                draw_img_D8(D8_u1All_2);
            else if (index == 2)
                draw_img_D8(D8_u1All_3);
            else if (index == 3)
                draw_img_D8(D8_u1All_4);
            else if (index == 4)
                draw_img_D8(D8_u1All_5);
            else if (index == 5)
                draw_img_D8(D8_u1All_6);
            else if (index == 6)
                draw_img_D8(D8_u1All_7);
            else if (index == 7)
                draw_img_D8(D8_u1All_8);
            else if (index == 8)
                draw_img_D8(D8_u2All_1);
            else if (index == 9)
                draw_img_D8(D8_u2All_2);
            else if (index == 10)
                draw_img_D8(D8_u2All_3);
            else if (index == 11)
                draw_img_D8(D8_u2All_4);
            else if (index == 12)
                draw_img_D8(D8_u2All_5);
            else if (index == 13)
                draw_img_D8(D8_u2All_6);
            else if (index == 14)
                draw_img_D8(D8_u2All_7);
            else if (index == 15)
                draw_img_D8(D8_u2All_8);
            else if (index == 16)
                draw_img_D8(D8_u3All_1);
            else if (index == 17)
                draw_img_D8(D8_u3All_2);
            else if (index == 18)
                draw_img_D8(D8_u3All_3);
            else if (index == 19)
                draw_img_D8(D8_u3All_4);
            else if (index == 20)
                draw_img_D8(D8_u3All_5);
            else if (index == 21)
                draw_img_D8(D8_u3All_6);
            else if (index == 22)
                draw_img_D8(D8_u3All_7);
            else if (index == 23)
                draw_img_D8(D8_u3All_8);
            else if (index == 24)
                draw_img_D8(D8_uAll1_1);
            else if (index == 25)
                draw_img_D8(D8_uAll1_2);
            else if (index == 26)
                draw_img_D8(D8_uAll1_3);
            else if (index == 27)
                draw_img_D8(D8_uAll1_4);
            else if (index == 28)
                draw_img_D8(D8_uAll1_5);
            else if (index == 29)
                draw_img_D8(D8_uAll1_6);
            else if (index == 30)
                draw_img_D8(D8_uAll1_7);
            else if (index == 31)
                draw_img_D8(D8_uAll1_8);
            else if (index == 32)
                draw_img_D8(D8_uAll2_1);
            else if (index == 33)
                draw_img_D8(D8_uAll2_2);
            else if (index == 34)
                draw_img_D8(D8_uAll2_3);
            else if (index == 35)
                draw_img_D8(D8_uAll2_4);
            else if (index == 36)
                draw_img_D8(D8_uAll2_5);
            else if (index == 37)
                draw_img_D8(D8_uAll2_6);
            else if (index == 38)
                draw_img_D8(D8_uAll2_7);
            else if (index == 39)
                draw_img_D8(D8_uAll2_8);
            else if (index == 40)
                draw_img_D8(D8_uAll3_1);
            else if (index == 41)
                draw_img_D8(D8_uAll3_2);
            else if (index == 42)
                draw_img_D8(D8_uAll3_3);
            else if (index == 43)
                draw_img_D8(D8_uAll3_4);
            else if (index == 44)
                draw_img_D8(D8_uAll3_5);
            else if (index == 45)
                draw_img_D8(D8_uAll3_6);
            else if (index == 46)
                draw_img_D8(D8_uAll3_7);
            else if (index == 47)
                draw_img_D8(D8_uAll3_8);
            else if (index == 48)
                draw_img_D8(D8_mod_1);
            else if (index == 49)
                draw_img_D8(D8_mod_2);
            else if (index == 50)
                draw_img_D8(D8_mod_3);
            else if (index == 51)
                draw_img_D8(D8_mod_4);
            else if (index == 52)
                draw_img_D8(D8_mod_5);
            else if (index == 53)
                draw_img_D8(D8_mod_6);
            else if (index == 54)
                draw_img_D8(D8_mod_7);
            else if (index == 55)
                draw_img_D8(D8_mod_8);
        } else if (myvision > 132) {
            int index = myvision - 133;

            for (int i1 = 0; i1 < 3; i1++) {
                delta[i1] = razdelSlow(25, i1 * 3, i1 * 3 + 1, i1 * 3 + 2);
                delta[i1 + 3] = razdelSlow(25, i1, i1 + 3, i1 + 6);
            }

            delta[6] = razdelSlowMod(25);

            maxMin[20][0] = -delta[index] * 25;
            maxMin[20][1] = delta[index] * 25;

            shcala(19, 20);

            if (index == 0)
                draw_img_8(D8_u1All);
            else if (index == 1)
                draw_img_8(D8_u2All);
            else if (index == 2)
                draw_img_8(D8_u3All);
            else if (index == 3)
                draw_img_8(D8_uAll1);
            else if (index == 4)
                draw_img_8(D8_uAll2);
            else if (index == 5)
                draw_img_8(D8_uAll3);
            else if (index == 6)
                draw_img_8(D8_mod);

            for (int j = 0; j < 6; j++)
                System.out.println("luch " + luch[index][j]);
        }

        first = 2;
        System.out.println("все точки нанесены");
    }

    public void zapolnGrap(long st, double[] delta, double[] delta100) {
        int px, py, num1, x1, y1;

        for (int i = 0; i < 3; i++) {
            px = wndXYAll(input[i * 3] + input[i * 3 + 2] * Math.cos(alpha), i);
            py = wndYAll(input[i * 3 + 1] + input[i * 3 + 2] * Math.sin(alpha), i);

            num1 = slow_ravnomer(25, input[i * 3], input[i * 3 + 1], input[i * 3 + 2], delta[i]);

            x1 = px - wndXMin + 10;
            y1 = py - wndYMin + 10;

            if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                if (i == 0) {
                    if (img3D_u1All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                img3D_u1All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] < 0)
                            img3D_u1All[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_u1All[x1][y1] && input[i * 3 + 2] < 0)
                            img3D_u1All[x1][y1] = num1;
                        else if ((num1 > img3D_u1All[x1][y1] || img3D_u1All[x1][y1] == 100) && input[i * 3 + 2] > 0)
                            img3D_u1All[x1][y1] = num1;
                    }
                } else if (i == 1) {
                    if (img3D_u2All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                img3D_u2All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] < 0)
                            img3D_u2All[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_u2All[x1][y1] && input[i * 3 + 2] < 0)
                            img3D_u2All[x1][y1] = num1;
                        else if ((num1 > img3D_u2All[x1][y1] || img3D_u2All[x1][y1] == 100) && input[i * 3 + 2] > 0)
                            img3D_u2All[x1][y1] = num1;
                    }
                } else {
                    if (img3D_u3All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                img3D_u3All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] < 0)
                            img3D_u3All[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_u3All[x1][y1] && input[i * 3 + 2] < 0)
                            img3D_u3All[x1][y1] = num1;
                        else if ((num1 > img3D_u3All[x1][y1] || img3D_u3All[x1][y1] == 100) && input[i * 3 + 2] > 0)
                            img3D_u3All[x1][y1] = num1;
                    }
                }
            }

            px = wndXYAll(input[i * 3] - input[i * 3 + 2] * Math.cos(alpha), i + 7);
            py = wndYAll(input[i * 3 + 1] - input[i * 3 + 2] * Math.sin(alpha), i + 7);

            x1 = px - wndXMin + 10;
            y1 = py - wndYMin + 10;

            if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                if (i == 0) {
                    if (imgD3_u1All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                imgD3_u1All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] > 0)
                            imgD3_u1All[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_u1All[x1][y1] && input[i * 3 + 2] > 0)
                            imgD3_u1All[x1][y1] = num1;
                        else if ((num1 > imgD3_u1All[x1][y1] || imgD3_u1All[x1][y1] == 100) && input[i * 3 + 2] < 0)
                            imgD3_u1All[x1][y1] = num1;
                    }
                } else if (i == 1) {
                    if (imgD3_u2All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                imgD3_u2All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] > 0)
                            imgD3_u2All[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_u2All[x1][y1] && input[i * 3 + 2] > 0)
                            imgD3_u2All[x1][y1] = num1;
                        else if ((num1 > imgD3_u2All[x1][y1] || imgD3_u2All[x1][y1] == 100) && input[i * 3 + 2] < 0)
                            imgD3_u2All[x1][y1] = num1;
                    }
                } else {
                    if (imgD3_u3All[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i * 3 + 1] > 0)
                                imgD3_u3All[x1][y1] = num1;
                        } else if (input[i * 3 + 2] > 0)
                            imgD3_u3All[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_u3All[x1][y1] && input[i * 3 + 2] > 0)
                            imgD3_u3All[x1][y1] = num1;
                        else if ((num1 > imgD3_u3All[x1][y1] || imgD3_u3All[x1][y1] == 100) && input[i * 3 + 2] < 0)
                            imgD3_u3All[x1][y1] = num1;
                    }
                }
            }

        }

        for (int i = 0; i < 3; i++) {
            px = wndXYAll(input[i] + input[i + 6] * Math.cos(alpha), i + 3);
            py = wndYAll(input[i + 3] + input[i + 6] * Math.sin(alpha), i + 3);

            num1 = slow_ravnomer(25, input[i], input[i + 3], input[i + 6], delta[i + 3]);

            x1 = px - wndXMin + 10;
            y1 = py - wndYMin + 10;

            if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                if (i == 0) {
                    if (img3D_uAll1[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                img3D_uAll1[x1][y1] = num1;
                        } else if (input[i + 6] < 0)
                            img3D_uAll1[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_uAll1[x1][y1] && input[i + 6] < 0)
                            img3D_uAll1[x1][y1] = num1;
                        else if ((num1 > img3D_uAll1[x1][y1] || img3D_uAll1[x1][y1] == 100) && input[i + 6] > 0)
                            img3D_uAll1[x1][y1] = num1;
                    }
                } else if (i == 1) {
                    if (img3D_uAll2[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                img3D_uAll2[x1][y1] = num1;
                        } else if (input[i + 6] < 0)
                            img3D_uAll2[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_uAll2[x1][y1] && input[i + 6] < 0)
                            img3D_uAll2[x1][y1] = num1;
                        else if ((num1 > img3D_u2All[x1][y1] || img3D_uAll2[x1][y1] == 100) && input[i + 6] > 0)
                            img3D_uAll2[x1][y1] = num1;
                    }
                } else {
                    if (img3D_uAll3[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                img3D_uAll3[x1][y1] = num1;
                        } else if (input[i + 6] < 0)
                            img3D_uAll3[x1][y1] = num1;
                    } else {
                        if (num1 < img3D_uAll3[x1][y1] && input[i + 6] < 0)
                            img3D_uAll3[x1][y1] = num1;
                        else if ((num1 > img3D_u3All[x1][y1] || img3D_uAll3[x1][y1] == 100) && input[i + 6] > 0)
                            img3D_uAll3[x1][y1] = num1;
                    }
                }
            }

            px = wndXYAll(input[i] - input[i + 6] * Math.cos(alpha), i + 10);
            py = wndYAll(input[i + 3] - input[i + 6] * Math.sin(alpha), i + 10);

            x1 = px - wndXMin + 10;
            y1 = py - wndYMin + 10;

            if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
                if (i == 0) {
                    if (imgD3_uAll1[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                imgD3_uAll1[x1][y1] = num1;
                        } else if (input[i + 6] > 0)
                            imgD3_uAll1[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_uAll1[x1][y1] && input[i + 6] > 0)
                            imgD3_uAll1[x1][y1] = num1;
                        else if ((num1 > imgD3_uAll1[x1][y1] || imgD3_uAll1[x1][y1] == 100) && input[i + 6] < 0)
                            imgD3_uAll1[x1][y1] = num1;
                    }
                } else if (i == 1) {
                    if (imgD3_uAll2[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                imgD3_uAll2[x1][y1] = num1;
                        } else if (input[i + 6] > 0)
                            imgD3_uAll2[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_uAll2[x1][y1] && input[i + 6] > 0)
                            imgD3_uAll2[x1][y1] = num1;
                        else if ((num1 > imgD3_u2All[x1][y1] || imgD3_uAll2[x1][y1] == 100) && input[i + 6] < 0)
                            imgD3_uAll2[x1][y1] = num1;
                    }
                } else {
                    if (imgD3_uAll3[x1][y1] == 102) {
                        if (420 - x1 == y1) {
                            if (input[i + 3] > 0)
                                imgD3_uAll3[x1][y1] = num1;
                        } else if (input[i + 6] > 0)
                            imgD3_uAll3[x1][y1] = num1;
                    } else {
                        if (num1 < imgD3_uAll3[x1][y1] && input[i + 6] > 0)
                            imgD3_uAll3[x1][y1] = num1;
                        else if ((num1 > imgD3_u3All[x1][y1] || imgD3_uAll3[x1][y1] == 100) && input[i + 6] < 0)
                            imgD3_uAll3[x1][y1] = num1;
                    }
                }
            }
        }

        double mod1, mod2, mod3;

        mod1 = myModav(0);
        mod2 = myModav(3);
        mod3 = myModav(6);

        px = wndXYAll(mod1 + mod3 * Math.cos(alpha), 6);
        py = wndYAll(mod2 + mod3 * Math.sin(alpha), 6);

        num1 = slow_ravnomer(25, mod1, mod2, mod3, delta[6]);

        x1 = px - wndXMin + 10;
        y1 = py - wndYMin + 10;

        if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
            if (img3D_mod[x1][y1] == 102) {
                if (420 - x1 == y1) {
                    if (mod2 > 0)
                        img3D_mod[x1][y1] = num1;
                } else if (mod3 < 0)
                    img3D_mod[x1][y1] = num1;
            } else {
                if (num1 < img3D_mod[x1][y1] && mod3 < 0)
                    img3D_mod[x1][y1] = num1;
                else if ((num1 > img3D_mod[x1][y1] || img3D_mod[x1][y1] == 100) && mod3 > 0)
                    img3D_mod[x1][y1] = num1;
            }
        }

        px = wndXYAll(mod1 - mod3 * Math.cos(alpha), 13);
        py = wndYAll(mod2 - mod3 * Math.sin(alpha), 13);

        x1 = px - wndXMin + 10;
        y1 = py - wndYMin + 10;

        if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
            if (imgD3_mod[x1][y1] == 102) {
                if (420 - x1 == y1) {
                    if (mod2 > 0)
                        imgD3_mod[x1][y1] = num1;
                } else if (mod3 < 0)
                    imgD3_mod[x1][y1] = num1;
            } else {
                if (num1 < imgD3_mod[x1][y1] && mod3 < 0)
                    imgD3_mod[x1][y1] = num1;
                else if ((num1 > imgD3_mod[x1][y1] || imgD3_mod[x1][y1] == 100) && mod3 > 0)
                    imgD3_mod[x1][y1] = num1;
            }
        }

        for (int i = 0; i < 3; i++) {
            num1 = slow_ravnomer(SLOW_CONST, input[i * 3], input[i * 3 + 1], input[i * 3 + 2], i);
            Nkslow[i][num1 - 1]++;
            num1 = slow_ravnomer(SLOW_CONST, input[i], input[i + 3], input[i + 6], i + 3);
            Nkslow[i + 3][num1 - 1]++;
        }
        num1 = slow_ravnomer(SLOW_CONST, mod1, mod2, mod3, 6);
        Nkslow[6][num1 - 1]++;


        px = wndX(st * h, 19);

        if (utime[18][px - wndXMin + 1] == -1) {
            for (int j = 0; j < 18; j++)
                utime[j][px - wndXMin + 1] = input[j];
            utime[18][px - wndXMin + 1] = st * h;
        }

        py = wndY(EUK(), 18);
        if (py - wndYMin < 400)
            img_EUK[px - wndXMin + 1][py - wndYMin + 1] = 1;

        py = wndY(input[0], 0);
        img_u11[px - wndXMin + 1][py - wndYMin + 1] = 1;

        py = wndY(input[1], 1);
        img_u12[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[2], 2);
        img_u13[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[3], 3);
        img_u21[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[4], 4);
        img_u22[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[5], 5);
        img_u23[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[6], 6);
        img_u31[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[7], 7);
        img_u32[px - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[8], 8);
        img_u33[px - wndXMin + 1][py - wndYMin + 1] = 1;

        int pz;

        py = wndY(input[9], 9);
        pz = wndX(input[0], 0);
        img_uc11[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf11[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[10], 10);
        pz = wndX(input[1], 1);
        img_uc12[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf12[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[11], 11);
        pz = wndX(input[2], 2);
        img_uc13[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf13[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[12], 12);
        pz = wndX(input[3], 3);
        img_uc21[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf21[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[13], 13);
        pz = wndX(input[4], 4);
        img_uc22[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf22[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[14], 14);
        pz = wndX(input[5], 5);
        img_uc23[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf23[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[15], 15);
        pz = wndX(input[6], 6);
        img_uc31[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf31[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[16], 16);
        pz = wndX(input[7], 7);
        img_uc32[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf32[pz - wndXMin + 1][py - wndYMin + 1] = 1;
        py = wndY(input[17], 17);
        pz = wndX(input[8], 8);
        img_uc33[px - wndXMin + 1][py - wndYMin + 1] = 1;
        img_uf33[pz - wndXMin + 1][py - wndYMin + 1] = 1;

        //zapolnOktant(delta, st);
    }

    public void osXYZ(int index, int os) {
        Graphics g = getGraphics();

        if (index < 14) {
            g.drawLine(wndXMin, wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index));
            g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index), wndYMax);
            g.drawLine(wndXMin, wndYMax, wndXMin + wndYMax - wndYMin + 10, wndYMin - 10);

            g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10 - 5, wndYAll(0, index) + 3);
            g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10 - 5, wndYAll(0, index) - 3);

            g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) + 3, wndYMin + 10 + 5);
            g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) - 3, wndYMin + 10 + 5);

            if (index < 7) {
                g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYMin - 10, wndXMin + wndYMax - wndYMin + 10 - 5, wndYMin - 10 + 7);
                g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYMin - 10, wndXMin + wndYMax - wndYMin + 10 - 7, wndYMin - 10 + 5);
            } else {
                g.drawLine(wndXMin, wndYMax, wndXMin + 5, wndYMax - 7);
                g.drawLine(wndXMin, wndYMax, wndXMin + 7, wndYMax - 5);
            }
        } else {
            g.drawLine(wndXYAll(0, index), wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index));
            g.drawLine(wndXYAll(0, index), wndYAll(0, index), wndXYAll(0, index), wndYMin);
            g.drawLine(wndXYAll(0, index), wndYAll(0, index), wndXMin, wndYMax);

            if (os < 5) {
                g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10 - 5, wndYAll(0, index) + 3);
                g.drawLine(wndXMin + wndYMax - wndYMin + 10, wndYAll(0, index), wndXMin + wndYMax - wndYMin + 10 - 5, wndYAll(0, index) - 3);
            }
            if (os == 1 || os == 2 || os == 5 || os == 6) {
                g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) + 3, wndYMin + 10 + 5);
                g.drawLine(wndXYAll(0, index), wndYMin + 10, wndXYAll(0, index) - 3, wndYMin + 10 + 5);
            }
            if (os % 2 != 0) {
                g.drawLine(wndXMin, wndYMax, wndXMin + 5, wndYMax - 7);
                g.drawLine(wndXMin, wndYMax, wndXMin + 7, wndYMax - 5);
            }
        }
    }

    public void draw_img(byte mas[][]) {
        Graphics g = getGraphics();

        for (int j1 = 0; j1 < 602; j1++)
            for (int j2 = 0; j2 < 402; j2++)
                if (mas[j1][j2] != 0) {
                    if (mas[j1][j2] == 1) {
                        Color col = new Color(0, 160, 0);
                        g.setColor(col);
                    } else if (mas[j1][j2] == 2) {
                        Color col = new Color(210, 0, 0);
                        g.setColor(col);
                    } else {
                        Color col = new Color(0, 0, 200);
                        g.setColor(col);
                    }
                    g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, 2, 2);
                }
    }

    public void draw_img_1(byte mas[][]) {
        Graphics g = getGraphics();

        if (myvision < 10) {
            Color col = new Color(0, 0, 205);
            g.setColor(col);
        } else if (myvision < 19) {
            Color col = new Color(139, 0, 0);
            g.setColor(col);
        } else if (myvision < 28) {
            Color col = new Color(153, 50, 204);
            g.setColor(col);
        }

        for (int j1 = 0; j1 < 602; j1++)
            for (int j2 = 0; j2 < 402; j2++)
                if (mas[j1][j2] == 1)
                    g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, 2, 2);
    }

    public void draw_img_3D(int mas[][]) {
        Graphics g = getGraphics();
        int col[] = new int[3];

        for (int j1 = 0; j1 < 420; j1++)
            for (int j2 = 0; j2 < 420; j2++)
                if (mas[j1][j2] != 100) {
                    myNewColor(col, mas[j1][j2]);
                    Color colC = new Color(col[0], col[1], col[2]);
                    g.setColor(colC);
                    g.fillOval(j1 + wndXMin - 10, j2 + wndYMin - 10, 2, 2);
                }
    }

    public void draw_img_D8(byte mas[][]) {
        Graphics g = getGraphics();
        int col[] = new int[3];

        for (int j1 = 0; j1 < 420; j1++)
            for (int j2 = 0; j2 < 420; j2++)
                if (mas[j1][j2] != 100) {
                    myNewColor(col, mas[j1][j2]);
                    Color colC = new Color(col[0], col[1], col[2]);
                    g.setColor(colC);
                    g.fillOval(j1 + wndXMin - 10, j2 + wndYMin - 10, 2, 2);
                }
    }

    public void draw_img_8(byte mas[][]) {
        Graphics g = getGraphics();
        int col[] = new int[3];

        for (int j1 = 0; j1 < 602; j1++)
            for (int j2 = 0; j2 < 402; j2++)
                if (mas[j1][j2] != 0) {
                    myNewColor8(col, mas[j1][j2]);
                    Color colC = new Color(col[0], col[1], col[2]);
                    g.setColor(colC);
                    g.fillOval(j1 + wndXMin - 1, j2 + wndYMin - 1, 2, 2);
                }
    }

    public void zym() {
        clear();

        Graphics g = getGraphics();

        long istart, iend;

        if (myvision == 0)
            if (XDown < XUp)
                XDown -= 6;
            else
                XUp -= 6;

        if (mouse[myvision] == 1) {
            if (XDown < XUp) {
                istart = (long) (utime[18][XDown - wndXMin + 1] / h);
                iend = (long) (utime[18][XUp - wndXMin + 1] / h);

                for (int i = 0; i < 18; i++)
                    input[i] = utime[i][XDown - wndXMin + 1];
            } else {
                iend = (long) (utime[18][XDown - wndXMin + 1] / h);
                istart = (long) (utime[18][XUp - wndXMin + 1] / h);

                for (int i = 0; i < 18; i++)
                    input[i] = utime[i][XUp - wndXMin + 1];
            }
        } else {
            if (XDown < XUp) {
                istart = (long) (utimezym[18][XDown - wndXMin + 1] / h);
                iend = (long) (utimezym[18][XUp - wndXMin + 1] / h);

                for (int i = 0; i < 18; i++)
                    input[i] = utimezym[i][XDown - wndXMin + 1];
            } else {
                iend = (long) (utimezym[18][XDown - wndXMin + 1] / h);
                istart = (long) (utimezym[18][XUp - wndXMin + 1] / h);

                for (int i = 0; i < 18; i++)
                    input[i] = utimezym[i][XUp - wndXMin + 1];
            }
        }

        if (myvision != 0) {
            maxMin[20][0] = istart * h;
            maxMin[20][1] = iend * h;

            int index = myvision - 1;

            if (YDown > YUp) {
                maxMin[21][0] = obrwndY(YDown, index);
                maxMin[21][1] = obrwndY(YUp, index);
            } else {
                maxMin[21][1] = obrwndY(YDown, index);
                maxMin[21][0] = obrwndY(YUp, index);
            }

            for (int j1 = 0; j1 < 19; j1++)
                for (int j2 = 0; j2 < 602; j2++)
                    utimezym[j1][j2] = -1;

            if (myvision < 10) {
                Color col = new Color(0, 0, 205);
                g.setColor(col);
            } else {
                Color col = new Color(139, 0, 0);
                g.setColor(col);
            }

            System.out.println("x : " + maxMin[20][0] + "   " + maxMin[20][1]);
            System.out.println("y : " + maxMin[21][0] + "   " + maxMin[21][1]);

            shcala(20, 21);

            int px;
            while (istart < iend) {
                schetstep();

                if (input[index] >= maxMin[21][0] && input[index] <= maxMin[21][1])
                    g.fillOval(wndX(istart * h, 20), wndY(input[index], 21), 1, 1);

                px = wndX(istart * h, 20);
                if (utimezym[18][px - wndXMin + 1] == -1) {
                    for (int j = 0; j < 18; j++)
                        utimezym[j][px - wndXMin + 1] = input[j];
                    utimezym[18][px - wndXMin + 1] = istart * h;
                }
                istart++;
            }
        } else {
            maxMin[20][0] = istart * h;
            maxMin[20][1] = iend * h;
            maxMin[21][0] = 0;
            maxMin[21][1] = 1;

            for (int j1 = 0; j1 < 19; j1++)
                for (int j2 = 0; j2 < 602; j2++)
                    utimezym[j1][j2] = -1;

            Color col = new Color(0, 0, 139);
            g.setColor(col);

            shcala(20, 21);
            int px, py, mydelta = 10000000, myd = 0;
            double myE = 0, myE_sum = 0, myK = 0, myK_sum = 0, tlast = tstart * h;
            double uv, kv;
            double tnegolh, tnegol = (tb - ta) * 1.0 / Nmas;
            tnegolh = tnegol;
            long i = istart;

            double my_d[] = new double[mydelta];
            double my_kd[] = new double[mydelta];
            my_d[0] = U();
            my_kd[0] = K();

            while (tlast < tb) {
                schetstep();

                if (i < mydelta - 1) {
                    my_d[(int) (i) + 1] = U();
                    myE_sum += my_d[(int) (i) + 1];

                    my_kd[(int) (i) + 1] = K();
                    myK_sum += my_kd[(int) (i) + 1];

                } else {
                    uv = U();
                    myE_sum = myE_sum + uv - my_d[myd];
                    myE = myE_sum * 1.0 / mydelta;
                    my_d[myd] = uv;

                    kv = K();
                    myK_sum = myK_sum + kv - my_kd[myd];
                    myK = myK_sum * 1.0 / mydelta;
                    my_kd[myd] = kv;

                    col = new Color(200, 0, 0);
                    g.setColor(col);

                    px = wndX(tlast, 21);
                    py = wndY(myK, 20);

                    if (py - wndYMin < 400 && px - wndXMin + 1 > -1)
                        g.fillOval(px, py, 1, 1);

                    px = wndX(tlast, 21);
                    py = wndY(myE, 20);

                    col = new Color(0, 0, 139);
                    g.setColor(col);

                    if (py - wndYMin < 400 && px - wndXMin + 1 > -1)
                        g.fillOval(px, py, 1, 1);

                    myd++;

                    if (myd == mydelta)
                        myd = 0;
                }

                px = wndX(istart * h, 20);
                if (utimezym[18][px - wndXMin + 1] == -1) {
                    for (int j = 0; j < 18; j++)
                        utimezym[j][px - wndXMin + 1] = input[j];
                    utimezym[18][px - wndXMin + 1] = i * h;
                }

                tlast += h;
                i++;
            }
        }
        mouse[myvision] = 2;
    }

    public void myNewColor(int[] col, int num) {
        if (num == 102) {
            col[0] = 0;
            col[1] = 0;
            col[2] = 0;
        } else if (num == 1) {
            col[0] = 85;
            col[1] = 26;
            col[2] = 139;
        } else if (num == 2) {
            col[0] = 0;
            col[1] = 0;
            col[2] = 205;
        } else if (num == 3) {
            col[0] = 58;
            col[1] = 95;
            col[2] = 205;
        } else if (num == 4) {
            col[0] = 72;
            col[1] = 118;
            col[2] = 255;
        } else if (num == 5) {
            col[0] = 32;
            col[1] = 178;
            col[2] = 170;
        } else if (num == 6) {
            col[0] = 142;
            col[1] = 229;
            col[2] = 238;
        } else if (num == 7) {
            col[0] = 135;
            col[1] = 206;
            col[2] = 250;
        } else if (num == 8) {
            col[0] = 164;
            col[1] = 211;
            col[2] = 238;
        } else if (num == 9) {
            col[0] = 176;
            col[1] = 226;
            col[2] = 255;
        } else if (num == 10) {
            col[0] = 0;
            col[1] = 255;
            col[2] = 255;
        } else if (num == 11) {
            col[0] = 0;
            col[1] = 100;
            col[2] = 0;
        } else if (num == 12) {
            col[0] = 34;
            col[1] = 139;
            col[2] = 34;
        } else if (num == 13) {
            col[0] = 50;
            col[1] = 205;
            col[2] = 50;
        } else if (num == 14) {
            col[0] = 124;
            col[1] = 252;
            col[2] = 0;
        } else if (num == 15) {
            col[0] = 173;
            col[1] = 255;
            col[2] = 47;
        } else if (num == 16) {
            col[0] = 255;
            col[1] = 255;
            col[2] = 0;
        } else if (num == 17) {
            col[0] = 255;
            col[1] = 215;
            col[2] = 0;
        } else if (num == 18) {
            col[0] = 255;
            col[1] = 193;
            col[2] = 37;
        } else if (num == 19) {
            col[0] = 255;
            col[1] = 127;
            col[2] = 0;
        } else if (num == 20) {
            col[0] = 238;
            col[1] = 118;
            col[2] = 0;
        } else if (num == 21) {
            col[0] = 205;
            col[1] = 102;
            col[2] = 0;
        } else if (num == 22) {
            col[0] = 255;
            col[1] = 69;
            col[2] = 0;
        } else if (num == 23) {
            col[0] = 238;
            col[1] = 0;
            col[2] = 0;
        } else if (num == 24) {
            col[0] = 205;
            col[1] = 0;
            col[2] = 0;
        } else {
            col[0] = 139;
            col[1] = 0;
            col[2] = 0;
        }
    }

    public void myNewColor8(int[] col, int num) {
        if (num == 1) {
            col[0] = 238;
            col[1] = 0;
            col[2] = 0;
        } else if (num == 2) {
            col[0] = 255;
            col[1] = 185;
            col[2] = 15;
        } else if (num == 3) {
            col[0] = 255;
            col[1] = 255;
            col[2] = 0;
        } else if (num == 4) {
            col[0] = 179;
            col[1] = 238;
            col[2] = 58;
        } else if (num == 5) {
            col[0] = 0;
            col[1] = 139;
            col[2] = 0;
        } else if (num == 6) {
            col[0] = 141;
            col[1] = 238;
            col[2] = 238;
        } else if (num == 7) {
            col[0] = 0;
            col[1] = 0;
            col[2] = 205;
        } else {
            col[0] = 104;
            col[1] = 34;
            col[2] = 139;
        }
    }

    public void monte_karlo(double[][] Pc, double[][] Pk, int index) {
        double al;
        double rc = delta100[index];
        double min_pogr = 0, centr_rc = rc;
        double sum = 0, myP, mytan_const, mytan;

        //поиск максимальной плотности
        int Index_Pk = 0, k;
        double pc = Pk[index][0], pc1;

        for (int i = 0; i < 15; i++)
            if (Pk[index][i] > pc) {
                pc = Pk[index][i];
                Index_Pk = i;
            }

        pc = Nkslow[index][SLOW_CONST - 1 - Index_Pk] * h / (4 * PI * (Index_Pk + 1) * (Index_Pk + 1) * Nh * delta100[index] * delta100[index]);
        pc1 = Nkslow[index][SLOW_CONST - 1] * h / (4 * PI * Nh * delta100[index] * delta100[index]);
        pc = (pc + pc1) / 2.0;
        Pc[1][index] = pc;

        //определение линейного участка
        int kstart = 5;

        k = -1;
        do {
            k++;
            mytan = Math.abs((Math.log10(delta100[index] * (k + 2)) - Math.log10(delta100[index] * (k + 1))) / (Math.log10(delta100[index] * (k + 4)) - Math.log10(delta100[index] * (k + 1))) - (Pk[index][k + 1] - Pk[index][k]) / (Pk[index][k + 3] - Pk[index][k]));
            mytan += Math.abs((Math.log10(delta100[index] * (k + 3)) - Math.log10(delta100[index] * (k + 1))) / (Math.log10(delta100[index] * (k + 4)) - Math.log10(delta100[index] * (k + 1))) - (Pk[index][k + 2] - Pk[index][k]) / (Pk[index][k + 3] - Pk[index][k]));
        } while (mytan > 0.05 && k < SLOW_CONST - 6);

        mytan_const = 1.0 * (Pk[index][k] - Pk[index][k + 1]) / (Math.log10(delta100[index] * (k + 2)) - Math.log10(delta100[index] * (k + 1)));
        mytan = mytan_const;
        kstart = k;

        while (Math.abs(mytan_const - mytan) < 6 && k < SLOW_CONST - 2) {
            k++;
            mytan_const = (mytan_const * (k - kstart) + mytan) / (k - kstart + 1);
            mytan = 1.0 * (Pk[index][k - 1] - Pk[index][k]) / (Math.log10(delta100[index] * (k + 1)) - Math.log10(delta100[index] * k));
        }
        Pc[3][index] = k;

        System.out.println(" kstart = " + kstart + " slow = " + k);

        //поиск наклона прямой, по методу наименьших квадратов
        double Pk_x[] = new double[k - kstart];
        double cr_x = 0, cr_y = 0, sum_z = 0, sum_ch = 0;
        for (int i = 0; i < k - kstart - 1; i++) {
            Pk_x[i] = Math.log10(delta100[index] * (i + kstart));
            cr_x += Pk_x[i];
            cr_y += Pk[index][i + kstart - 1];
        }

        cr_x = cr_x * 1.0 / (k - kstart - 1);
        cr_y = cr_y * 1.0 / (k - kstart - 1);

        for (int i = 0; i < k - kstart - 1; i++) {
            sum_z += (Pk_x[i] - cr_x) * (Pk_x[i] - cr_x);
            sum_ch += (Pk_x[i] - cr_x) * (Pk[index][i + kstart - 1] - cr_y);
        }
        al = -sum_ch * 1.0 / sum_z;
        Pc[0][index] = al;

        //вычисление значимости найденного коэффициента
        double betta = cr_y + cr_x * al, y_new;

        sum_z = 0;
        sum_ch = 0;
        for (int i = 0; i < k - kstart - 1; i++) {
            y_new = betta - al * Pk_x[i];
            sum_z += (Pk[index][i + kstart - 1] - cr_y) * (Pk[index][i + kstart - 1] - cr_y);
            sum_ch += (Pk[index][i + kstart - 1] - y_new) * (Pk[index][i + kstart - 1] - y_new);
        }
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 = " + betta);

        betta = Math.sqrt(sum_z * 1.0 / (k - kstart - 1));
        System.out.println("среднеквадратичная погрешность для al = " + betta);

        sum_ch = sum_ch * 1.0 / (k - kstart - 1 - 2);
        sum_z = sum_z * 1.0 / (k - kstart - 1 - 1);
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 нормированный = " + betta);

        sum_z = 0;
        sum_ch = 0;
        betta = cr_y + cr_x * al;
        for (int i = 0; i < k - kstart - 1; i++) {
            y_new = betta - al * Pk_x[i];
            sum_z += (Pk_x[i] - cr_x) * (Pk_x[i] - cr_x);
            sum_ch += (Pk[index][i + kstart - 1] - y_new) * (Pk[index][i + kstart - 1] - y_new);
        }

        betta = Math.sqrt(sum_ch * 1.0 / ((k - kstart - 1 - 2) * sum_z));
        System.out.println(" стандартная ошибка для al = " + betta);

        betta = Math.sqrt(sum_ch * 1.0 / (k - kstart - 1));
        System.out.println(" моя погрешность для al = " + betta);

        //поиск радиуса центрального ядра
        for (int i = 0; i < k; i++) {
            myP = Math.log10(pc * 1.0 / (1 + Math.pow(delta100[index] * (i + 1) * 1.0 / rc, al)));
            min_pogr += (Pk[index][i] - myP) * (Pk[index][i] - myP);
        }
        rc += 0.0001;

        while (rc < k * delta100[index]) {
            sum = 0;
            for (int i = 0; i < k; i++) {
                myP = Math.log10(pc * 1.0 / (1 + Math.pow(delta100[index] * (i + 1) * 1.0 / rc, al)));
                sum += (Pk[index][i] - myP) * (Pk[index][i] - myP);
            }

            if (sum < min_pogr) {
                min_pogr = sum;
                centr_rc = rc;
            }

            rc += 0.0001;
        }
        Pc[2][index] = centr_rc;

        System.out.println(" al = " + al + " Pc = " + Pc[1][index] + " rc  =  " + centr_rc + " slow = " + k);


        //вычисление погрешности
        cr_x = 0;
        cr_y = 0;
        for (int i = 0; i < k - 1; i++) {
            cr_x += Math.log10(delta100[index] * (i + 1));
            cr_y += Pk[index][i];
        }

        cr_x = cr_x * 1.0 / (k - 1);
        cr_y = cr_y * 1.0 / (k - 1);

        sum_z = 0;
        sum_ch = 0;
        for (int i = 0; i < k - 1; i++) {
            y_new = Math.log10(Pc[1][index] * 1.0 / (1 + Math.pow(delta100[index] * (i + 1) * 1.0 / centr_rc, al)));
            sum_z += (Pk[index][i] - cr_y) * (Pk[index][i] - cr_y);
            sum_ch += (Pk[index][i] - y_new) * (Pk[index][i] - y_new);
        }
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 = " + betta);

        betta = Math.sqrt(sum_z * 1.0 / (k - 1));
        System.out.println("среднеквадратичная погрешность для Pc = " + betta);

        sum_ch = sum_ch * 1.0 / (k - 1 - 3);
        sum_z = sum_z * 1.0 / (k - 1 - 1);
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 нормированный = " + betta);

        sum_z = 0;
        sum_ch = 0;
        for (int i = 0; i < k - 1; i++) {
            betta = Math.log10(delta100[index] * (i + 1));
            y_new = Math.log10(Pc[1][index] * 1.0 / (1 + Math.pow(delta100[index] * (i + 1) * 1.0 / centr_rc, al)));
            sum_z += (betta - cr_x) * (betta - cr_x);
            sum_ch += (Pk[index][i] - y_new) * (Pk[index][i] - y_new);
        }

        betta = Math.sqrt(sum_ch * 1.0 / ((k - 1 - 3) * sum_z));
        System.out.println(" стандартная ошибка для Pc = " + betta);

        betta = Math.sqrt(sum_ch * 1.0 / (k - 1));
        System.out.println("моя погрешность для Pc = " + betta);

    }

    public void monte_karlo_mod(double[][] Pc, double[][] Pk) {
        double al, betta;
        double rc = delta100[6];
        double min_pogr = 0, centr_rc = rc;
        double sum = 0, myP, mytan_const, mytan;

        //поиск максимальной плотности
        int Index_Pk = 0, k, ji = 0;
        double pc, pc1;

        while (Pk[6][ji] > 200 || Pk[6][ji] < -200)
            ji++;

        Pc[5][6] = ji;

        pc = Pk[6][ji];
        for (int i = ji; i < SLOW_CONST; i++)
            if (Pk[6][i] > pc) {
                pc = Pk[6][i];
                Index_Pk = i;
            }

        System.out.println("max = " + Index_Pk);
        pc = Nkslow[6][SLOW_CONST - 1 - Index_Pk] * h / (4 * PI * (Index_Pk + 1) * (Index_Pk + 1) * Nh * delta100[6] * delta100[6]);
        Pc[1][6] = pc * 2;

        //определение линейного участка #2
        int kstart = Index_Pk;

        k = Index_Pk;
        do {
            k++;
            mytan = Math.abs((Math.log10(delta100[6] * (k + 2)) - Math.log10(delta100[6] * (k + 1))) / (Math.log10(delta100[6] * (k + 4)) - Math.log10(delta100[6] * (k + 1))) - (Pk[6][k + 1] - Pk[6][k]) / (Pk[6][k + 3] - Pk[6][k]));
            mytan += Math.abs((Math.log10(delta100[6] * (k + 3)) - Math.log10(delta100[6] * (k + 1))) / (Math.log10(delta100[6] * (k + 4)) - Math.log10(delta100[6] * (k + 1))) - (Pk[6][k + 2] - Pk[6][k]) / (Pk[6][k + 3] - Pk[6][k]));
        } while (mytan > 0.05 && k < SLOW_CONST - 6);

        mytan_const = 1.0 * (Pk[6][k] - Pk[6][k + 1]) / (Math.log10(delta100[6] * (k + 2)) - Math.log10(delta100[6] * (k + 1)));
        mytan = mytan_const;
        kstart = k;

        while (Math.abs(mytan_const - mytan) < 6 && k < SLOW_CONST - 2) {
            k++;
            mytan_const = (mytan_const * (k - kstart) + mytan) / (k - kstart + 1);
            mytan = 1.0 * (Pk[6][k - 1] - Pk[6][k]) / (Math.log10(delta100[6] * (k + 1)) - Math.log10(delta100[6] * k));
        }
        Pc[3][6] = k;

        System.out.println(" kstart = " + kstart + " slow = " + k);

        //поиск наклона прямой #2, по методу наименьших квадратов
        double Pk_x[] = new double[k - kstart];
        double cr_x = 0, cr_y = 0, sum_z = 0, sum_ch = 0;
        for (int i = 0; i < k - kstart - 1; i++) {
            Pk_x[i] = Math.log10(delta100[6] * (i + kstart));
            cr_x += Pk_x[i];
            cr_y += Pk[6][i + kstart - 1];
        }

        cr_x = cr_x * 1.0 / (k - kstart - 1);
        cr_y = cr_y * 1.0 / (k - kstart - 1);

        for (int i = 0; i < k - kstart - 1; i++) {
            sum_z += (Pk_x[i] - cr_x) * (Pk_x[i] - cr_x);
            sum_ch += (Pk_x[i] - cr_x) * (Pk[6][i + kstart - 1] - cr_y);
        }
        al = -sum_ch * 1.0 / sum_z;
        Pc[0][6] = al;

        System.out.println("al = " + al);

        //вычисление значимости найденного коэффициента
        betta = cr_y + cr_x * al;
        double y_new;

        sum_z = 0;
        sum_ch = 0;
        for (int i = 0; i < k - kstart - 1; i++) {
            y_new = betta - al * Pk_x[i];
            sum_z += (Pk[6][i + kstart - 1] - cr_y) * (Pk[6][i + kstart - 1] - cr_y);
            sum_ch += (Pk[6][i + kstart - 1] - y_new) * (Pk[6][i + kstart - 1] - y_new);
        }
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 = " + betta);

        betta = Math.sqrt(sum_z * 1.0 / (k - kstart - 1));
        System.out.println("среднеквадратичная погрешность для al = " + betta);

        sum_ch = sum_ch * 1.0 / (k - kstart - 1 - 2);
        sum_z = sum_z * 1.0 / (k - kstart - 1 - 1);
        betta = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 нормированный = " + betta);

        sum_z = 0;
        sum_ch = 0;
        betta = cr_y + cr_x * al;
        for (int i = 0; i < k - kstart - 1; i++) {
            y_new = betta - al * Pk_x[i];
            sum_z += (Pk_x[i] - cr_x) * (Pk_x[i] - cr_x);
            sum_ch += (Pk[6][i + kstart - 1] - y_new) * (Pk[6][i + kstart - 1] - y_new);
        }

        betta = Math.sqrt(sum_ch * 1.0 / ((k - kstart - 1 - 2) * sum_z));
        System.out.println(" стандартная ошибка для al = " + betta);

        betta = Math.sqrt(sum_ch * 1.0 / (k - kstart - 1));
        System.out.println(" моя погрешность для al = " + betta);

        //поиск бетта и rc
        pc = Nkslow[6][SLOW_CONST - 1 - Index_Pk] * h / (4 * PI * (Index_Pk + 1) * (Index_Pk + 1) * Nh * delta100[6] * delta100[6]);
        //Pc[1][6] = pc;
        double cp = pc, cp1 = 1;
        Pc[1][6] = pc * cp1;

        betta = 1;
        rc = Math.pow(betta * 1.0 / al, 1.0 / (al + betta));
        rc = delta100[6] * (Index_Pk + 1) / rc;
        Pc[4][6] = betta;

        min_pogr = 0;
        for (int i = ji; i < k; i++) {
            myP = Math.log10(Pc[1][6] * Math.pow(delta100[6] * (i + 1) * 1.0 / rc, betta) * 1.0 / (1 + Math.pow(delta100[6] * (i + 1) * 1.0 / rc, al + betta)));
            min_pogr += (Pk[6][i] - myP) * (Pk[6][i] - myP);
        }
        betta += 0.01;

        while (cp1 < 3) {
            pc = cp * cp1;
            betta = 1;
            rc = Math.pow(betta * 1.0 / al, 1.0 / (al + betta));
            rc = delta100[6] * (Index_Pk + 1) / rc;

            while (betta < 10) {
                sum = 0;
                rc = Math.pow(betta * 1.0 / al, 1.0 / (al + betta));
                rc = delta100[6] * (Index_Pk + 1) / rc;
                for (int i = ji; i < k; i++) {
                    myP = Math.log10(pc * Math.pow(delta100[6] * (i + 1) * 1.0 / rc, betta) * 1.0 / (1 + Math.pow(delta100[6] * (i + 1) * 1.0 / rc, al + betta)));
                    sum += (Pk[6][i] - myP) * (Pk[6][i] - myP);
                }

                if (sum < min_pogr) {
                    min_pogr = sum;
                    centr_rc = rc;
                    Pc[4][6] = betta;
                    Pc[1][6] = cp * cp1;
                }
                betta += 0.01;
            }
            cp1 += 0.01;
        }
        Pc[2][6] = centr_rc;

        System.out.println(" al = " + Pc[0][6] + " A = " + Pc[1][6] + " rc  =  " + Pc[2][6] + " slow = " + k + " betta = " + Pc[4][6]);

        //вычисление погрешности
        double betta1;
        cr_x = 0;
        cr_y = 0;
        for (int i = ji; i < k - 1; i++) {
            cr_x += Math.log10(delta100[6] * (i + 1));
            cr_y += Pk[6][i];
        }

        cr_x = cr_x * 1.0 / (k - 1 - ji);
        cr_y = cr_y * 1.0 / (k - 1 - ji);

        sum_z = 0;
        sum_ch = 0;
        for (int i = ji; i < k - 1; i++) {
            y_new = Math.log10(Pc[1][6] * Math.pow(delta100[6] * (i + 1) * 1.0 / Pc[2][6], Pc[4][6]) * 1.0 / (1 + Math.pow(delta100[6] * (i + 1) * 1.0 / Pc[2][6], al + Pc[4][6])));
            sum_z += (Pk[6][i] - cr_y) * (Pk[6][i] - cr_y);
            sum_ch += (Pk[6][i] - y_new) * (Pk[6][i] - y_new);
        }
        betta1 = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 = " + betta1);

        betta1 = Math.sqrt(sum_z * 1.0 / (k - 1 - ji));
        System.out.println("среднеквадратичная погрешность для Pc = " + betta1);

        sum_ch = sum_ch * 1.0 / (k - 1 - ji - 4);
        sum_z = sum_z * 1.0 / (k - 1 - ji - 1);
        betta1 = 1 - sum_ch * 1.0 / sum_z;
        System.out.println(" R2 нормированный = " + betta1);

        sum_z = 0;
        sum_ch = 0;
        for (int i = ji; i < k - 1; i++) {
            betta = Math.log10(delta100[6] * (i + 1));
            y_new = Math.log10(Pc[1][6] * Math.pow(delta100[6] * (i + 1) * 1.0 / Pc[2][6], Pc[4][6]) * 1.0 / (1 + Math.pow(delta100[6] * (i + 1) * 1.0 / Pc[2][6], al + Pc[4][6])));
            sum_z += (betta - cr_x) * (betta - cr_x);
            sum_ch += (Pk[6][i] - y_new) * (Pk[6][i] - y_new);
        }

        betta1 = Math.sqrt(sum_ch * 1.0 / ((k - 1 - ji - 4) * sum_z));
        System.out.println(" стандартная ошибка для Pc = " + betta1);

        betta1 = Math.sqrt(sum_ch * 1.0 / (k - 1 - ji));
        System.out.println("моя погрешность для Pc = " + betta1);
    }

    public void oktant() {
        /*
		radius[0] = 0.026119145159556285*27;
		radius[1] = 0.03517543606046519*31;
		radius[2] = 0.031047321721977744*24;
		radius[3] = 0.02142979943120103*26;
		radius[4] = 0.03661083807716515*34;
		radius[5] = 0.01945089090876163*29;
		radius[6] = 0.03504547571013643*30;
		*/

        radius[0] = 0.31678610379143135 * 27;
        radius[1] = 0.28406899662646073 * 31;
        radius[2] = 0.3417726194192386 * 24;
        radius[3] = 0.5051610994636835 * 26;
        radius[4] = 0.1752437449458092 * 34;
        radius[5] = 0.1629519828350702 * 29;
        radius[6] = 0.3417726194192386 * 30;

        for (int j1 = 0; j1 < 420; j1++)
            for (int j2 = 0; j2 < 420; j2++) {
                D8_u1All_1[j1][j2] = 100;
                D8_u1All_2[j1][j2] = 100;
                D8_u1All_3[j1][j2] = 100;
                D8_u1All_4[j1][j2] = 100;
                D8_u1All_5[j1][j2] = 100;
                D8_u1All_6[j1][j2] = 100;
                D8_u1All_7[j1][j2] = 100;
                D8_u1All_8[j1][j2] = 100;

                D8_u2All_1[j1][j2] = 100;
                D8_u2All_2[j1][j2] = 100;
                D8_u2All_3[j1][j2] = 100;
                D8_u2All_4[j1][j2] = 100;
                D8_u2All_5[j1][j2] = 100;
                D8_u2All_6[j1][j2] = 100;
                D8_u2All_7[j1][j2] = 100;
                D8_u2All_8[j1][j2] = 100;

                D8_u3All_1[j1][j2] = 100;
                D8_u3All_2[j1][j2] = 100;
                D8_u3All_3[j1][j2] = 100;
                D8_u3All_4[j1][j2] = 100;
                D8_u3All_5[j1][j2] = 100;
                D8_u3All_6[j1][j2] = 100;
                D8_u3All_7[j1][j2] = 100;
                D8_u3All_8[j1][j2] = 100;

                D8_uAll1_1[j1][j2] = 100;
                D8_uAll1_2[j1][j2] = 100;
                D8_uAll1_3[j1][j2] = 100;
                D8_uAll1_4[j1][j2] = 100;
                D8_uAll1_5[j1][j2] = 100;
                D8_uAll1_6[j1][j2] = 100;
                D8_uAll1_7[j1][j2] = 100;
                D8_uAll1_8[j1][j2] = 100;

                D8_uAll2_1[j1][j2] = 100;
                D8_uAll2_2[j1][j2] = 100;
                D8_uAll2_3[j1][j2] = 100;
                D8_uAll2_4[j1][j2] = 100;
                D8_uAll2_5[j1][j2] = 100;
                D8_uAll2_6[j1][j2] = 100;
                D8_uAll2_7[j1][j2] = 100;
                D8_uAll2_8[j1][j2] = 100;

                D8_uAll3_1[j1][j2] = 100;
                D8_uAll3_2[j1][j2] = 100;
                D8_uAll3_3[j1][j2] = 100;
                D8_uAll3_4[j1][j2] = 100;
                D8_uAll3_5[j1][j2] = 100;
                D8_uAll3_6[j1][j2] = 100;
                D8_uAll3_7[j1][j2] = 100;
                D8_uAll3_8[j1][j2] = 100;

                D8_mod_1[j1][j2] = 100;
                D8_mod_2[j1][j2] = 100;
                D8_mod_3[j1][j2] = 100;
                D8_mod_4[j1][j2] = 100;
                D8_mod_5[j1][j2] = 100;
                D8_mod_6[j1][j2] = 100;
                D8_mod_7[j1][j2] = 100;
                D8_mod_8[j1][j2] = 100;
            }

        for (int i = 0; i < 602; i++)
            for (int j = 0; j < 402; j++) {
                D8_u1All[i][j] = 0;
                D8_u2All[i][j] = 0;
                D8_u3All[i][j] = 0;
                D8_uAll1[i][j] = 0;
                D8_uAll2[i][j] = 0;
                D8_uAll3[i][j] = 0;
                D8_mod[i][j] = 0;
            }

        for (int i = 0; i < 3; i++) {
            oktMacshtab(1, 1, -1, i, 14, maxMin[i * 3][1], maxMin[i * 3 + 1][1], maxMin[i * 3 + 2][1]);
            oktMacshtab(1, 1, 1, i, 15, maxMin[i * 3][1], maxMin[i * 3 + 1][1], maxMin[i * 3 + 2][0]);
            oktMacshtab(1, -1, -1, i, 16, maxMin[i * 3][1], maxMin[i * 3 + 1][0], maxMin[i * 3 + 2][1]);
            oktMacshtab(1, -1, 1, i, 17, maxMin[i * 3][1], maxMin[i * 3 + 1][0], maxMin[i * 3 + 2][0]);
            oktMacshtab(-1, 1, -1, i, 18, maxMin[i * 3][0], maxMin[i * 3 + 1][1], maxMin[i * 3 + 2][1]);
            oktMacshtab(-1, 1, 1, i, 19, maxMin[i * 3][0], maxMin[i * 3 + 1][1], maxMin[i * 3 + 2][0]);
            oktMacshtab(-1, -1, -1, i, 20, maxMin[i * 3][0], maxMin[i * 3 + 1][0], maxMin[i * 3 + 2][1]);
            oktMacshtab(-1, -1, 1, i, 21, maxMin[i * 3][0], maxMin[i * 3 + 1][0], maxMin[i * 3 + 2][0]);
        }
        for (int i = 0; i < 3; i++) {
            oktMacshtab(1, 1, -1, i + 3, 14, maxMin[i][1], maxMin[i + 3][1], maxMin[i + 6][1]);
            oktMacshtab(1, 1, 1, i + 3, 15, maxMin[i][1], maxMin[i + 3][1], maxMin[i + 6][0]);
            oktMacshtab(1, -1, -1, i + 3, 16, maxMin[i][1], maxMin[i + 3][0], maxMin[i + 6][1]);
            oktMacshtab(1, -1, 1, i + 3, 17, maxMin[i][1], maxMin[i + 3][0], maxMin[i + 6][0]);
            oktMacshtab(-1, 1, -1, i + 3, 18, maxMin[i][0], maxMin[i + 3][1], maxMin[i + 6][1]);
            oktMacshtab(-1, 1, 1, i + 3, 19, maxMin[i][0], maxMin[i + 3][1], maxMin[i + 6][0]);
            oktMacshtab(-1, -1, -1, i + 3, 20, maxMin[i][0], maxMin[i + 3][0], maxMin[i + 6][1]);
            oktMacshtab(-1, -1, 1, i + 3, 21, maxMin[i][0], maxMin[i + 3][0], maxMin[i + 6][0]);
        }
        double mod1, mod2, mod3, mod11, mod22, mod33;

        mod1 = myMod(0, 9);
        mod2 = myMod(3, 9);
        mod3 = myMod(6, 9);
        mod11 = myMod(0, 0);
        mod22 = myMod(3, 0);
        mod33 = myMod(6, 0);

        oktMacshtab(1, 1, -1, 6, 14, mod1, mod2, mod3);
        oktMacshtab(1, 1, 1, 6, 15, mod1, mod2, mod33);
        oktMacshtab(1, -1, -1, 6, 16, mod1, mod22, mod3);
        oktMacshtab(1, -1, 1, 6, 17, mod1, mod22, mod33);
        oktMacshtab(-1, 1, -1, 6, 18, mod11, mod2, mod3);
        oktMacshtab(-1, 1, 1, 6, 19, mod11, mod2, mod33);
        oktMacshtab(-1, -1, -1, 6, 20, mod11, mod22, mod3);
        oktMacshtab(-1, -1, 1, 6, 21, mod11, mod22, mod33);

        for (int j = 0; j < 7; j++)
            for (int j2 = 0; j2 < 6; j2++)
                luch[j][j2] = 0;
    }

    public void zapolnOktant(double[] delta, long st) {
        double mod;
        int num1, px, py;
        byte myokt;

        for (byte i = 0; i < 3; i++) {
            mod = Math.sqrt(input[i * 3] * input[i * 3] + input[i * 3 + 1] * input[i * 3 + 1] + input[i * 3 + 2] * input[i * 3 + 2]);

            if (mod > radius[i]) {
                num1 = slow_ravnomer(25, input[i * 3], input[i * 3 + 1], input[i * 3 + 2], delta[i]);

                if (input[i * 3] > 0) {
                    if (input[i * 3 + 1] > 0) {
                        if (input[i * 3 + 2] > 0) {
                            px = wndXYAll(input[i * 3] - input[i * 3 + 2] * Math.cos(alpha), i * 8 + 14);
                            py = wndYAll(input[i * 3 + 1] - input[i * 3 + 2] * Math.sin(alpha), i * 8 + 14);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_1);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_1);
                            else
                                okt(num1, px, py, D8_u3All_1);

                            myokt = 1;
                        } else {
                            px = wndXYAll(input[i * 3] + input[i * 3 + 2] * Math.cos(alpha), i * 8 + 15);
                            py = wndYAll(input[i * 3 + 1] + input[i * 3 + 2] * Math.sin(alpha), i * 8 + 15);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_2);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_2);
                            else
                                okt(num1, px, py, D8_u3All_2);

                            myokt = 2;
                        }
                    } else {
                        if (input[i * 3 + 2] > 0) {
                            px = wndXYAll(input[i * 3] - input[i * 3 + 2] * Math.cos(alpha), i * 8 + 16);
                            py = wndYAll(-input[i * 3 + 1] - input[i * 3 + 2] * Math.sin(alpha), i * 8 + 16);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_3);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_3);
                            else
                                okt(num1, px, py, D8_u3All_3);

                            myokt = 3;
                        } else {
                            px = wndXYAll(input[i * 3] + input[i * 3 + 2] * Math.cos(alpha), i * 8 + 17);
                            py = wndYAll(-input[i * 3 + 1] + input[i * 3 + 2] * Math.sin(alpha), i * 8 + 17);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_4);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_4);
                            else
                                okt(num1, px, py, D8_u3All_4);

                            myokt = 4;
                        }
                    }
                } else {
                    if (input[i * 3 + 1] > 0) {
                        if (input[i * 3 + 2] > 0) {
                            px = wndXYAll(-input[i * 3] - input[i * 3 + 2] * Math.cos(alpha), i * 8 + 18);
                            py = wndYAll(input[i * 3 + 1] - input[i * 3 + 2] * Math.sin(alpha), i * 8 + 18);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_5);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_5);
                            else
                                okt(num1, px, py, D8_u3All_5);

                            myokt = 5;
                        } else {
                            px = wndXYAll(-input[i * 3] + input[i * 3 + 2] * Math.cos(alpha), i * 8 + 19);
                            py = wndYAll(input[i * 3 + 1] + input[i * 3 + 2] * Math.sin(alpha), i * 8 + 19);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_6);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_6);
                            else
                                okt(num1, px, py, D8_u3All_6);

                            myokt = 6;
                        }
                    } else {
                        if (input[i * 3 + 2] > 0) {
                            px = wndXYAll(-input[i * 3] - input[i * 3 + 2] * Math.cos(alpha), i * 8 + 20);
                            py = wndYAll(-input[i * 3 + 1] - input[i * 3 + 2] * Math.sin(alpha), i * 8 + 20);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_7);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_7);
                            else
                                okt(num1, px, py, D8_u3All_7);

                            myokt = 7;
                        } else {
                            px = wndXYAll(-input[i * 3] + input[i * 3 + 2] * Math.cos(alpha), i * 8 + 21);
                            py = wndYAll(-input[i * 3 + 1] + input[i * 3 + 2] * Math.sin(alpha), i * 8 + 21);

                            if (i == 0)
                                okt(num1, px, py, D8_u1All_8);
                            else if (i == 1)
                                okt(num1, px, py, D8_u2All_8);
                            else
                                okt(num1, px, py, D8_u3All_8);

                            myokt = 8;
                        }
                    }
                }

                maxMin[20][0] = -delta[i] * 25;
                maxMin[20][1] = delta[i] * 25;

                int ry = wndY(radius[i], 20);
                int ryy = wndY(-radius[i], 20);

                px = wndX(st * h, 19);
                py = wndY(myModav(i * 3), 20);
                if (py - wndYMin < 400 && py - wndYMin > -1)
                    if (i == 0)
                        D8_u1All[px - wndXMin + 1][py - wndYMin + 1] = myokt;
                    else if (i == 1)
                        D8_u2All[px - wndXMin + 1][py - wndYMin + 1] = myokt;
                    else
                        D8_u3All[px - wndXMin + 1][py - wndYMin + 1] = myokt;

                if (py == ry)
                    luch[i][0]++;
                else if (py == ry - 1)
                    luch[i][1]++;
                else if (py == ry + 1)
                    luch[i][2]++;
                else if (py == ryy)
                    luch[i][3]++;
                else if (py == ryy - 1)
                    luch[i][4]++;
                else if (py == ryy + 1)
                    luch[i][5]++;

                /*
				 	luch 0
					luch 45773
					luch 0
					luch 153711
					luch 0
					luch 167235
				 */
            }
        }


        for (byte i = 0; i < 3; i++) {
            mod = Math.sqrt(input[i] * input[i] + input[i + 3] * input[i + 3] + input[i + 6] * input[i + 6]);

            if (mod > radius[i + 3]) {
                num1 = slow_ravnomer(25, input[i], input[i + 3], input[i + 6], delta[i + 3]);

                if (input[i] > 0) {
                    if (input[i + 3] > 0) {
                        if (input[i + 6] > 0) {
                            px = wndXYAll(input[i] - input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 14);
                            py = wndYAll(input[i + 3] - input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 14);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_1);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_1);
                            else
                                okt(num1, px, py, D8_uAll3_1);

                            myokt = 1;
                        } else {
                            px = wndXYAll(input[i] + input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 15);
                            py = wndYAll(input[i + 3] + input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 15);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_2);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_2);
                            else
                                okt(num1, px, py, D8_uAll3_2);

                            myokt = 2;
                        }
                    } else {
                        if (input[i + 6] > 0) {
                            px = wndXYAll(input[i] - input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 16);
                            py = wndYAll(-input[i + 3] - input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 16);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_3);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_3);
                            else
                                okt(num1, px, py, D8_uAll3_3);

                            myokt = 3;
                        } else {
                            px = wndXYAll(input[i] + input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 17);
                            py = wndYAll(-input[i + 3] + input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 17);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_4);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_4);
                            else
                                okt(num1, px, py, D8_uAll3_4);

                            myokt = 4;
                        }
                    }
                } else {
                    if (input[i + 3] > 0) {
                        if (input[i + 6] > 0) {
                            px = wndXYAll(-input[i] - input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 18);
                            py = wndYAll(input[i + 3] - input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 18);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_5);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_5);
                            else
                                okt(num1, px, py, D8_uAll3_5);

                            myokt = 5;
                        } else {
                            px = wndXYAll(-input[i] + input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 19);
                            py = wndYAll(input[i + 3] + input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 19);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_6);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_6);
                            else
                                okt(num1, px, py, D8_uAll3_6);

                            myokt = 6;
                        }
                    } else {
                        if (input[i + 6] > 0) {
                            px = wndXYAll(-input[i] - input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 20);
                            py = wndYAll(-input[i + 3] - input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 20);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_7);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_7);
                            else
                                okt(num1, px, py, D8_uAll3_7);

                            myokt = 7;
                        } else {
                            px = wndXYAll(-input[i] + input[i + 6] * Math.cos(alpha), (i + 3) * 8 + 21);
                            py = wndYAll(-input[i + 3] + input[i + 6] * Math.sin(alpha), (i + 3) * 8 + 21);

                            if (i == 0)
                                okt(num1, px, py, D8_uAll1_8);
                            else if (i == 1)
                                okt(num1, px, py, D8_uAll2_8);
                            else
                                okt(num1, px, py, D8_uAll3_8);

                            myokt = 8;
                        }
                    }
                }

                maxMin[20][0] = -delta[i + 3] * 25;
                maxMin[20][1] = delta[i + 3] * 25;

                int ry = wndY(radius[i + 3], 20);
                int ryy = wndY(-radius[i + 3], 20);

                px = wndX(st * h, 19);
                py = wndY(Math.signum(myMax3(input[i], input[i + 3], input[i + 6])) * mod, 20);
                if (py - wndYMin < 400 && py - wndYMin > -1)
                    if (i == 0)
                        D8_uAll1[px - wndXMin + 1][py - wndYMin + 1] = myokt;
                    else if (i == 1)
                        D8_uAll2[px - wndXMin + 1][py - wndYMin + 1] = myokt;
                    else
                        D8_uAll3[px - wndXMin + 1][py - wndYMin + 1] = myokt;

                if (py == ry)
                    luch[i + 3][0]++;
                else if (py == ry - 1)
                    luch[i + 3][1]++;
                else if (py == ry + 1)
                    luch[i + 3][2]++;
                else if (py == ryy)
                    luch[i + 3][3]++;
                else if (py == ryy - 1)
                    luch[i + 3][4]++;
                else if (py == ryy + 1)
                    luch[i + 3][5]++;
            }
        }

        double mod2, mod3, md;
        mod = myModav(0);
        mod2 = myModav(3);
        mod3 = myModav(6);

        md = Math.sqrt(mod * mod + mod2 * mod2 + mod3 * mod3);

        if (md > radius[6]) {
            num1 = slow_ravnomer(25, mod, mod2, mod3, delta[6]);

            if (mod > 0) {
                if (mod2 > 0) {
                    if (mod3 > 0) {
                        px = wndXYAll(mod - mod3 * Math.cos(alpha), 48 + 14);
                        py = wndYAll(mod2 - mod3 * Math.sin(alpha), 48 + 14);

                        okt(num1, px, py, D8_mod_1);
                        myokt = 1;
                    } else {
                        px = wndXYAll(mod + mod3 * Math.cos(alpha), 48 + 15);
                        py = wndYAll(mod2 + mod3 * Math.sin(alpha), 48 + 15);

                        okt(num1, px, py, D8_mod_2);
                        myokt = 2;
                    }
                } else {
                    if (mod3 > 0) {
                        px = wndXYAll(mod - mod3 * Math.cos(alpha), 48 + 16);
                        py = wndYAll(-mod2 - mod3 * Math.sin(alpha), 48 + 16);

                        okt(num1, px, py, D8_mod_3);
                        myokt = 3;
                    } else {
                        px = wndXYAll(mod + mod3 * Math.cos(alpha), 48 + 17);
                        py = wndYAll(-mod2 + mod3 * Math.sin(alpha), 48 + 17);

                        okt(num1, px, py, D8_mod_4);
                        myokt = 4;
                    }
                }
            } else {
                if (mod2 > 0) {
                    if (mod3 > 0) {
                        px = wndXYAll(-mod - mod3 * Math.cos(alpha), 48 + 18);
                        py = wndYAll(mod2 - mod3 * Math.sin(alpha), 48 + 18);

                        okt(num1, px, py, D8_mod_5);
                        myokt = 5;
                    } else {
                        px = wndXYAll(-mod + mod3 * Math.cos(alpha), 48 + 19);
                        py = wndYAll(mod2 + mod3 * Math.sin(alpha), 48 + 19);

                        okt(num1, px, py, D8_mod_6);
                        myokt = 6;
                    }
                } else {
                    if (mod3 > 0) {
                        px = wndXYAll(-mod - mod3 * Math.cos(alpha), 48 + 20);
                        py = wndYAll(-mod2 - mod3 * Math.sin(alpha), 48 + 20);

                        okt(num1, px, py, D8_mod_7);
                        myokt = 7;
                    } else {
                        px = wndXYAll(-mod + mod3 * Math.cos(alpha), 48 + 21);
                        py = wndYAll(-mod2 + mod3 * Math.sin(alpha), 48 + 21);

                        okt(num1, px, py, D8_mod_8);
                        myokt = 8;
                    }
                }
            }

            maxMin[20][0] = -delta[6] * 25;
            maxMin[20][1] = delta[6] * 25;

            int ry = wndY(radius[6], 20);
            int ryy = wndY(-radius[6], 20);

            px = wndX(st * h, 19);
            py = wndY(Math.signum(myMax3(mod, mod2, mod3)) * md, 20);
            if (py - wndYMin < 401 && py - wndYMin > -2)
                D8_mod[px - wndXMin + 1][py - wndYMin + 1] = myokt;

            if (py == ry)
                luch[6][0]++;
            else if (py == ry - 1)
                luch[6][1]++;
            else if (py == ry + 1)
                luch[6][2]++;
            else if (py == ryy)
                luch[6][3]++;
            else if (py == ryy - 1)
                luch[6][4]++;
            else if (py == ryy + 1)
                luch[6][5]++;
        }
    }

    public void okt(int num1, int px, int py, byte[][] mas) {
        px = px - wndXMin + 10;
        py = py - wndYMin + 10;
        if (px > -1 && px < 420 && py > -1 && py < 420)
            if ((byte) (num1) < mas[px][py])
                mas[px][py] = (byte) (num1);
    }

    public void oktMacshtab(int x, int y, int z, int i, int c, double m1, double m2, double m3) {
        uAll[i * 8 + c][1] = x * m1;
        uAll[i * 8 + c][0] = z * m3 * Math.cos(alpha);
        uAll[i * 8 + c][3] = y * m2;
        uAll[i * 8 + c][2] = z * m3 * Math.sin(alpha);

        norm(i * 8 + c);
    }
}


