import Calculation_Modules.Calculator;
import Calculation_Modules.OctpletFunctions;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 18.02.12
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class OSYMApplet extends Applet {

    int wndXMin=400, wndYMin=50, wndXMax=1000, wndYMax=450;
    int sizeX = 1050, sizeY = 520, sizePanel = (int)(wndXMin) - 100;


    protected void addLabel(String text, int x, int y, int w, int h) {
        Label label = new Label (text,Label.CENTER);
        add(label);
        label.reshape(x, y, w, h);
    }


    @Override
    public void init() {

        Calculator calc = new Calculator(new OctpletFunctions());

        //calc.func(new double[] {0,0,0}, 3);

        setSize(sizeX, sizeY);

		setBackground(Color.white);
		setLayout(null);
		setFont(new Font("Helvetica", Font.PLAIN, 11));

        Button butt1 = new Button("Начать");
        butt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

		add(butt1);
        butt1.reshape(70, 460, 170, 30);

        addLabel("промежуток времени для счета",10, 5, 270, 20);
        addLabel("t = [ 0, ",50, 25, 40, 20);
        addLabel("]",220, 25, 10, 20);
        addLabel("шаг дискретизации",10, 45, 270, 20);
        addLabel("начальные условия",10, 145, 270, 20);
        addLabel("отобразить",40, 255, 210, 20);

        Choice metod = new Choice();

        metod.addItem("Рунге-Кутта 4-го порядка");
		metod.addItem("Рунге-Кутта-Бутчера 6-го порядка");
		metod.addItem("Рунге-Кутта-Фельдберга 8-го порядка");
        metod.setLocation(10,105);
		metod.select(2);
        add(metod);

        List vision = new List(77, false);
        add(vision);

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
        vision.select(0);

        /*
		tbend.reshape(100, 25, 100, 20);

		Textstep.reshape(10, 45, 270, 20);
		step.reshape(100, 65, 100, 20);

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
		Butt1.


		time =


		//kadr = new Checkbox("рисовать по кадрам", false);
		mostfile = new Checkbox("считать масштабные множители из файла", false);

		tbend = new TextField("100000",8);
		step = new TextField("1e-4",8);
		//kadrstart = new TextField("0",8);
		//kadrend = new TextField("100",8);

		grup = new CheckboxGroup();
		poten = new Checkbox("нулевые потенциалы", grup, false);
		scor = new Checkbox("нулевые производные от потенциалов", grup, true);
		nonull = new Checkbox("произвольные", grup, false);
		//mystart = new Checkbox("использовать созданные раннее", grup, false);








		add(time); add(Texttime1); add(Texttime2); add(Textstep); add(Textstart); add(Textvision);
		add(tbend); add(step); //add(kadrstart); add(kadrend);
		add(poten); add(scor); add(nonull); //add(mystart);
		//add(kadr);
		add(mostfile);

		*/
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void start() {
        super.start();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void stop() {
        super.stop();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void destroy() {
        super.destroy();    //To change body of overridden methods use File | Settings | File Templates.
    }


}
