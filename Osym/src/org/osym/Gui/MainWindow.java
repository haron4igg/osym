package org.osym.Gui;

import org.osym.Core.Engine;
import org.osym.Images.Image2D;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: sonny
 * Date: 07.04.12
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow implements Engine.EngineDelegate {

    private JPanel MainPanel;
    private JComboBox displayComboBox;
    private JButton saveStateButton;
    private JButton saveImageButton;

    private JRadioButton groundPotentialRadioButton;
    private JRadioButton groundDerivativsFromPotentialRadioButton;
    private JRadioButton randomRadioButton;
    private JTextField beginRangeTextField;
    private JTextField endRangeTextField;
    private JComboBox chMethodComboBox;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JProgressBar calculatingProgressBar;
    private JTextField stepTextField;
    private JButton loadStateButton;
    private JComboBox potentialComboBox;
    private JComboBox faceComboBox;
    private JComboBox densityComboBox;
    private JComboBox systemComboBox;
    private JTextPane textPane1;
    private JButton clearLogButton;
    private JPanel drawPanel;
    private JProgressBar drawingProgressBar;


    private String[] systems = {"Triplet", "Triplet (native)", "Triplet (jni native)", "Octplet"};
    /*
private String[] displayItems = {  "Вычислительная погрешность",
"Зависимотсть от времени потенциала:",
"Зависимотсть от времени скорости потенциала:",
"Фазовая траектория осцилятора для потенциала",
"Траектория осцилятора на плоскости",
"Неголомные связи",
"Переливы энэргии",
"Плотность" };
    */
    private String[] potentials = {"U11", "U12", "U13",
            "U21", "U22", "U23",
            "U31", "U32", "U33",
            "U41", "U42", "U43",
            "U51", "U52", "U53",
            "U61", "U62", "U63",
            "U71", "U72", "U73",
            "U81", "U82", "U83",};


    private String[] faces = {"U11, U12, U13",
            "U21, U22, U23",
            "U31, U32, U33",
            "U41, U42, U43",
            "U51, U52, U53",
            "U61, U62, U63",
            "U71, U72, U73",
            "U81, U82, U83",};

    private String[] densities = {"U1", "U2", "U3", "U4", "U5", "U6", "U7", "U8"};
    private String[] chMethods = {"Runge Kutta 4", "Runge Kutta Butcher 6", "Runge Kutta Fehlberg 8"};

    private Engine engine = null;

    private Engine.CalculationMethod method = Engine.CalculationMethod.CalculationMethodRKLevel4;
    private Engine.StartingConditions conditions = Engine.StartingConditions.StartingConditionRandom;
    private Engine.CalculationMode mode = Engine.CalculationMode.CalculationModeTriplet;

    private double beginPoint = 0;
    private double endPoint = 10;
    private double step = 1e-4;

    private Boolean isPauseDown;


    private void enableSettings(Boolean flag) {

        beginRangeTextField.setEnabled(flag);
        endRangeTextField.setEnabled(flag);
        stepTextField.setEnabled(flag);

        chMethodComboBox.setEnabled(flag);
        systemComboBox.setEnabled(flag);
        displayComboBox.setEnabled(flag);

        //densityComboBox.setEnabled(flag);
        //faceComboBox.setEnabled(flag);
        //potentialComboBox.setEnabled(flag);

        groundDerivativsFromPotentialRadioButton.setEnabled(flag);
        groundPotentialRadioButton.setEnabled(flag);
        randomRadioButton.setEnabled(flag);
    }

    public MainWindow() {
        chMethodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedIndex = chMethodComboBox.getSelectedIndex();
                System.out.println("Index " + selectedIndex + " Item " + chMethodComboBox.getItemAt(selectedIndex));
                switch (selectedIndex) {
                    case 0: {
                        method = Engine.CalculationMethod.CalculationMethodRKLevel4;
                    }
                    break;
                    case 1: {
                        method = Engine.CalculationMethod.CalculationMethodRKLevel6;
                    }
                    break;
                    case 2: {
                        method = Engine.CalculationMethod.CalculationMethodRKLevel8;
                    }
                    break;
                }
                engine.setCalculationMethod(method);
                //setupCurrentSettingsToEngine();
            }
        });
        displayComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) displayComboBox.getSelectedItem();
                Integer selectedIndex = displayComboBox.getSelectedIndex();
                System.out.println("Index " + selectedIndex + " Item " + displayComboBox.getItemAt(selectedIndex));
                switch (selectedIndex) {
                    case 0:
                    case 5:
                    case 6: {
                        densityComboBox.setEnabled(false);
                        potentialComboBox.setEnabled(false);
                        faceComboBox.setEnabled(false);
                    }
                    break;
                    case 1:
                    case 2:
                    case 3: {
                        densityComboBox.setEnabled(false);
                        potentialComboBox.setEnabled(true);
                        faceComboBox.setEnabled(false);
                    }
                    break;
                    case 4: {
                        densityComboBox.setEnabled(false);
                        potentialComboBox.setEnabled(false);
                        faceComboBox.setEnabled(true);
                    }
                    break;
                    case 7: {
                        potentialComboBox.setEnabled(false);
                        faceComboBox.setEnabled(false);
                        densityComboBox.setEnabled(true);
                    }
                    break;
                }

                ((ImagePanel) drawPanel).setImageToDisplay(engine.getImages().get(selectedIndex));
                drawPanel.updateUI();
                //setupCurrentSettingsToEngine();
            }
        });
        systemComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedIndex = systemComboBox.getSelectedIndex();
                System.out.println("Index " + selectedIndex + " Item " + systemComboBox.getItemAt(selectedIndex));
                switch (selectedIndex) {
                    case 0: {
                        mode = Engine.CalculationMode.CalculationModeTriplet;
                    }
                    break;

                    case 1: {
                        mode = Engine.CalculationMode.CalculationModeTripletNative;
                    }
                    break;

                    case 2: {
                        mode = Engine.CalculationMode.CalculationModeTripletNativeJNI;
                    }
                    break;

                    case 3: {
                        mode = Engine.CalculationMode.CalculationModeOctplet;
                    }
                    break;
                }
                engine.setCalculationMode(mode);
                //setupCurrentSettingsToEngine();
            }
        });

        saveStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                System.out.println("CLicked Save State");
                saveState();
            }
        });
        saveImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                System.out.println("Clicked save Image");
            }
        });
        loadStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked load State");
                loadState();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Start");
                start();
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked pause");
                pause();
                engine.pause();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Stop");
                stop();
                engine.stop();
            }
        });
        clearLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane1.setText("");
            }
        });

        groundPotentialRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (groundPotentialRadioButton.isSelected()) {
                    System.out.println("Ground potencial sel");
                    //conditions = Engine.StartingConditions.StartingConditionZeroPotentials;
                    engine.setStartingConditions(Engine.StartingConditions.StartingConditionZeroPotentials);
                }
                //setupCurrentSettingsToEngine();
            }
        });
        groundDerivativsFromPotentialRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (groundDerivativsFromPotentialRadioButton.isSelected()) {
                    System.out.println("groundDerivativsFromPotentialRadioButton.isSelected");
                    //conditions = Engine.StartingConditions.StartingConditionZeroDerivatives;
                    engine.setStartingConditions(Engine.StartingConditions.StartingConditionZeroDerivatives);
                }
                //setupCurrentSettingsToEngine();
            }
        });
        randomRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (randomRadioButton.isSelected()) {
                    System.out.println("randomRadioButton.isSelected");
                    //conditions = Engine.StartingConditions.StartingConditionRandom;
                    engine.setStartingConditions(Engine.StartingConditions.StartingConditionRandom);
                }
                //setupCurrentSettingsToEngine();
            }
        });
    }

    private void start() {
        if (isCorrectStep() && isCorrectBeginRange() && isCorrectEndRange()) {
            if (beginPoint < endPoint) {
                enableSettings(false);
                //((ImagePanel) drawPanel).clearUI();
                startButton.setEnabled(false);
                pauseButton.setEnabled(true);
                stopButton.setEnabled(true);

                loadStateButton.setEnabled(false);
                saveStateButton.setEnabled(false);
                saveImageButton.setEnabled(false);

                setupCurrentSettingsToEngine();

                ((ImagePanel) drawPanel).setImageToDisplay(engine.getImages().get(displayComboBox.getSelectedIndex()));
                drawPanel.updateUI();

                engine.begin();
            } else {
                breakCalculation("End point less then begin point");
            }
            //engine.begin();
        }
    }

    public void setupCurrentSettingsToEngine() {
        if (engine != null) {
            //engine.setCalculationMethod(method);
            //engine.setCalculationMode(mode);
            engine.setCalculationStep(step);
            //engine.setIterationLimit(step);
            //engine.setStartingConditions(conditions);

            engine.setStartIteration(beginPoint);
            engine.setIterationLimit(endPoint);
        }
    }

    private void saveState() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save State in: " + fileChooser.getSelectedFile().getPath());
            engine.saveState(fileChooser.getSelectedFile().getPath());
        }
    }

    private void loadState() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save State in: " + fileChooser.getSelectedFile().getPath());
            engine.loadState(fileChooser.getSelectedFile().getPath());
            setupSettingsToUIFromLoadedData();
        }
    }

    private void stop() {
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);

        saveStateButton.setEnabled(false);
        saveImageButton.setEnabled(false);
        loadStateButton.setEnabled(true);

        enableSettings(true);
    }

    private void pause() {

        if (isPauseDown) {
            isPauseDown = false;
            pauseButton.setText("Continue");

        } else {
            isPauseDown = true;
            pauseButton.setText("Pause");

//            saveStateButton.setEnabled(true);
//            savieImageButton.setEnabled(true);
//            loadStateButton.setEnabled(false);
        }

        //saveStateButton.setEnabled(true);
        //saveImageButton.setEnabled(true);
        //loadStateButton.setEnabled(false);

        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
        startButton.setEnabled(false);
        enableSettings(false);
    }

    private boolean isCorrectBeginRange() {
        Boolean success = true;
        if (beginRangeTextField.getText().length() == 0) {
            breakCalculation("Void value in \"End range\" textField");
            success = false;
        } else {
            try {
                beginPoint = Double.parseDouble(beginRangeTextField.getText());
            } catch (NumberFormatException e) {
                breakCalculation("Bad value in \"End range\" textField");
                success = false;
            }
        }
        return success;
    }

    private Boolean isCorrectEndRange() {
        Boolean success = true;
        if (endRangeTextField.getText().length() == 0) {
            breakCalculation("Void value in \"End range\" textField");
            success = false;
        } else {
            try {
                endPoint = Double.parseDouble(endRangeTextField.getText());
            } catch (NumberFormatException e) {
                breakCalculation("Bad value in \"End range\" textField ");
                success = false;
            }
        }
        return success;
    }

    private boolean isCorrectStep() {
        Boolean success = true;
        if (stepTextField.getText().length() == 0) {
            breakCalculation("Void value in \" Step\" Text Field");
            success = false;
        } else {
            try {
                step = Double.parseDouble(stepTextField.getText());
//                int stepInt  = Integer.parseInt(stepTextField.getText());
//                if (stepInt> 0) {
//                    String str = "1e-"+stepInt;
//                    step = Double.parseDouble(str);
//                } else {
//                    breakCalculation("Bad value in To \"Step \" Field");
//                }
            } catch (NumberFormatException e) {
                breakCalculation("Bad value in To \"Step \" Field");
                success = false;
            }
        }
        return success;
    }

    private void breakCalculation(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void setupSettingsToUIFromLoadedData() {
        step = engine.getCalculationStep();
        beginPoint = engine.getStartIteration();
        endPoint = engine.getIterationLimit();

        method = engine.getCalculationMethod();
        mode = engine.getCalculationMode();
        conditions = engine.getStartingConditions();

        stepTextField.setText(String.valueOf(step));
        beginRangeTextField.setText(String.valueOf(beginPoint));
        endRangeTextField.setText(String.valueOf(endPoint));

        chMethodComboBox.setSelectedIndex(method.ordinal());
        systemComboBox.setSelectedIndex(mode.ordinal());

        //groundDerivativsFromPotentialRadioButton.set

        switch (conditions) {
            case StartingConditionRandom: {
                randomRadioButton.setSelected(true);
            }
            break;
            case StartingConditionZeroPotentials: {
                groundPotentialRadioButton.setSelected(true);
            }
            break;
            case StartingConditionZeroDerivatives: {
                groundDerivativsFromPotentialRadioButton.setSelected(true);
            }
            break;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = new Dimension(930, 700);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(d);
    }

    private void createUIComponents() {
        engine = new Engine();
        engine.setDelegate(this);

        displayComboBox = new JComboBox();

        for (Integer i : engine.getImages().keySet()) {
            Image2D image = engine.getImages().get(i);
            displayComboBox.addItem(image.getMyName());
        }

        potentialComboBox = new JComboBox(potentials);
        potentialComboBox.setEnabled(false);

        faceComboBox = new JComboBox(faces);
        faceComboBox.setEnabled(false);

        densityComboBox = new JComboBox(densities);
        densityComboBox.setEnabled(false);

        drawPanel = new ImagePanel(engine.getImages().get(0));

        chMethodComboBox = new JComboBox(chMethods);

        systemComboBox = new JComboBox(systems);
        redirectSystemStreams();

        isPauseDown = true;

        stepTextField = new JTextField();
        stepTextField.setText(String.valueOf(step));

        beginRangeTextField = new JTextField();
        beginRangeTextField.setText(String.valueOf(beginPoint));

        endRangeTextField = new JTextField();
        endRangeTextField.setText(String.valueOf(endPoint));
    }

    @Override
    public void coreConfigurationDone(Engine core) {

        ((ImagePanel) drawPanel).setImageToDisplay(core.getImages().get(displayComboBox.getSelectedIndex()));
        drawPanel.updateUI();
    }

    @Override
    public void calculationProgressDidChange(int progress) {
        calculatingProgressBar.setValue(progress);
    }

    @Override
    public void drawingProgressDidChange(int progress) {
        drawingProgressBar.setValue(progress);
    }

    @Override
    public void calculationPaused() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void calculationResumed() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void calculationBegan(int progress) {
        System.out.println("Calculation began: " + progress);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void performDoneOperation() {
        drawPanel.updateUI();
        saveStateButton.setEnabled(true);
        saveImageButton.setEnabled(true);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        pauseButton.setEnabled(false);
        loadStateButton.setEnabled(true);

        int result = JOptionPane.showConfirmDialog(null,
                "Would you like to save scope factor?",
                "An Inane Question",
                JOptionPane.YES_NO_OPTION);

        switch (result) {
            case 0: {
                System.out.println("YES");
                saveState();
            }
            break;
            case 1: {
                System.out.println("NO");
            }
            break;
        }
        enableSettings(true);
    }

    @Override
    public void calculationDone() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                performDoneOperation();
            }
        });
    }

    @Override
    public void calculationFailed(Exception e) {
        System.out.println("Caused exception " + e.getLocalizedMessage());
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stateRestored() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stateSaved() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = textPane1.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                textPane1.setCaretPosition(doc.getLength() - 1);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

}

