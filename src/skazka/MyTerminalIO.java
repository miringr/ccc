package ru.neva.stu.hop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Класс для ввода-вывода информации в терминальное окно
 *
 */
public class MyTerminalIO {

    private MyTerminalIOFrame myframe;

    public MyTerminalIO() // это конструктор класса - метод, вызываемый при создании объекта
    {
        myframe = new MyTerminalIOFrame();
        myframe.setTitle("MyTerminalIO Display");
        myframe.setVisible(true);
    } // здесь конструктор класса заканчивается

    public File getFile(String path) {

        File f = null;
        try {
            f = new File(path);
            if (!f.exists()) {
                f = null;
                println("ОШИБКА: Файл '" + path + "' не существует.");
            }
        } catch (SecurityException se) {
            println("ошибка: Нет прав на чтение файла '" + path + "'");
        }


        return f;
    }

    public String[] readWordArray(String path) {
        File f = getFile(path);
        if (f == null) {
            println("Данные не прочитаны.");
            return null;
        }
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            println("ОШИБКА создания BufferedReader");
            return null;
        }
        String str;
        int j = 1;
        try {
            while ((str = in.readLine()) != null) {
                String t[] = str.split("[ \t]+");
                for (String x : t) {
                    al.add(x);
                    j++;
                }
            }
        } catch (IOException ex) {
            println("ОШИБКА чтения");
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String r[] = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            r[i] = al.get(i);
        }



        return r;
    }

    public String[] readPureWordArray(String path) {
        File f = getFile(path);
        if (f == null) {
            println("Данные не прочитаны.");
            return null;
        }
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            println("ОШИБКА создания BufferedReader");
            return null;
        }
        String str;
        int j = 1;
        try {
            while ((str = in.readLine()) != null) {
                String t[] = str.split("[! \t\\.\\?“”:;,]+");
                for (String x : t) {
                    if (!x.equals("–")) {
                        al.add(x);
                        j++;
                    }
                }
            }
        } catch (IOException ex) {
            println("ОШИБКА чтения");
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String r[] = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            r[i] = al.get(i);
        }



        return r;
    }

    public String[] readParagraphArray(String path) {
        File f = getFile(path);
        if (f == null) {
            println("Данные не прочитаны.");
            return null;
        }
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            println("ОШИБКА создания BufferedReader");
            return null;
        }
        String str;
        int j = 1;
        try {
            while ((str = in.readLine()) != null) {
                al.add(str);
                j++;
            }
        } catch (IOException ex) {
            println("ОШИБКА чтения");
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String r[] = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            r[i] = al.get(i);
        }



        return r;
    }

    public int[] readIntArray(String path) {

        File f = getFile(path);
        if (f == null) {
            println("Данные не прочитаны.");
            return null;
        }

        ArrayList<Integer> al = new ArrayList<Integer>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            println("ОШИБКА создания BufferedReader");
            return null;
        }
        String str;
        int j = 1;
        try {
            while ((str = in.readLine()) != null) {
                al.add(Integer.parseInt(str));
                j++;
            }
        } catch (IOException ex) {
            println("ОШИБКА чтения");
        } catch (NumberFormatException ex) {
            println("ОШИБКА неправильный формат числа в строке " + j);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        int r[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            r[i] = al.get(i);
        }
        // if( j >= 2 )
        //println("Кол-во прочитанных чисел: " + (j-1) + ", начинаются с " + al.get(0) + ", " + al.get(1) + " и так далее...");
        //else println("Прочитано одно целое число: " + al.get(0));

        return (r);
    }

    public double[] readDoubleArray(String path) {

        File f = getFile(path);
        if (f == null) {
            println("Данные не прочитаны.");
            return null;
        }

        ArrayList<Double> al = new ArrayList<Double>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            println("ОШИБКА создания BufferedReader");
            return null;
        }
        String str;
        int j = 1;
        try {
            while ((str = in.readLine()) != null) {
                al.add(Double.parseDouble(str));
                j++;
            }
        } catch (IOException ex) {
            println("ОШИБКА чтения");
        } catch (NumberFormatException ex) {
            println("ОШИБКА неправильный формат числа в строке " + j);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTerminalIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        double r[] = new double[al.size()];
        for (int i = 0; i < al.size(); i++) {
            r[i] = al.get(i);
        }
        //if( j >= 2 )
        // println("Кол-во прочитанных чисел: " + (j-1) + ", начинаются с " + al.get(0) + ", " + al.get(1) + " и так далее...");
        //else println("Прочитано одно целое число: " + al.get(0));
        return (r);
    }

    /**
     * Метод для вывода в окно терминала строкового значения
     * с переводом на новую строку
     * @param messageString - выводимое строковое значение
     * @return ничего
     */
    public void println(String messageString) {
        myframe.appendString(messageString + "\n");
    }

    /**
     * Метод для вывода в окно терминала строкового значения
     * без перевода на новую строку
     * @param messageString - выводимое строковое значение
     * @return ничего
     */
    public void print(String messageString) {
        myframe.appendString(messageString);
    }

    /**
     * Запрашивает сначала количество целых чисел в массиве,
     * затем все элементы по очереди.
     */
    public int[] getIntArray() {
        int n = this.getInt("Введите кол-во элементов");
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = this.getInt("Введите элемент № " + i + " :");
        }
        return a;
    }

    /**
     * Запрашивает сначала количество вещ. чисел в массиве,
     * затем все элементы по очереди.
     */
    public double[] getDoubleArray() {
        int n = this.getInt("Введите кол-во элементов");
        double a[] = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = this.getDouble("Введите элемент № " + i + " :");
        }
        return a;
    }

    /**
     * Запрашивает сначала количество строк в массиве,
     * затем все элементы по очереди.
     */
    public String[] getStringArray() {
        int n = this.getInt("Введите кол-во элементов");
        String a[] = new String[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = this.getString("Введите элемент № " + i + " :");
        }
        return a;
    }

    /**
     * Метод для вывода в окно терминала массива целых чисел
     * @param - массив целых чисел
     * @return ничего
     */
    public void printIntArray(int a[]) {
        int k = 0, max = 100;
        for (int i = 0; i < a.length && i < max; i++) {
            myframe.appendString(a[i] + "\t");
            if ((++k) % 10 == 0) {
                myframe.appendString("\n");
            }
        }
        if (a.length > max) {
            println("\n выведены первые " + max + " чисел");
        }
    }

    /**
     * Метод для вывода в окно терминала массива вещ. чисел
     * @param - массив вещ. чисел
     * @return ничего
     */
    public void printDoubleArray(double a[]) {
        int k = 0, max = 100;
        for (int i = 0; i < a.length && i < max; i++) {
            myframe.appendString(a[i] + "\t");
            if ((++k) % 10 == 0) {
                myframe.appendString("\n");
            }
        }
        if (a.length > max) {
            println("\n выведены первые " + max + " чисел");
        }
    }

    /**
     * Метод для вывода в окно терминала массива строк в столбец
     * @param - массив строк
     * @return ничего
     */
    public void printStringArray(String a[]) {

        for (int i = 0; i < a.length; i++) {
            myframe.appendString(a[i] + "\n");
        }
    }

    public void println(Object objectReference) {
        if (objectReference == null) {
            myframe.appendString("null\n");
        } else {
            String objectString = objectReference.toString();
            myframe.appendString(objectString + "\n");
        }
    }

    public void print(Object objectReference) {
        if (objectReference == null) {
            myframe.appendString("null");
        } else {
            String objectString = objectReference.toString();
            myframe.appendString(objectString);
        }
    }

    public void println(int expressionIn) {
        Integer integerObject = new Integer(expressionIn);
        println(integerObject);
    }

    public void print(int expressionIn) {
        Integer integerObject = new Integer(expressionIn);
        print(integerObject);
    }

    public void println(double expressionIn) {
        Double doubleObject = new Double(expressionIn);
        println(doubleObject);
    }

    public void print(double expressionIn) {
        Double doubleObject = new Double(expressionIn);
        print(doubleObject);
    }

    public void println() {
        print("\n");
    }

    public String getString(String promptString) {
        String inputString = "";

        println(promptString);

        inputString = JOptionPane.showInputDialog(promptString);

        println(inputString);

        return inputString;
    }

    public String getString() {
        String inputString = "";
        inputString = JOptionPane.showInputDialog("");
        println(inputString);
        return inputString;
    }

    public int getInt(String promptString) {
        String inputString = "";
        int inputInt = 0;
        boolean flag = false;

        println(promptString);

        inputString = JOptionPane.showInputDialog(promptString);

        while (flag == false) {
            try {
                inputInt = Integer.parseInt(inputString);
                flag = true;
            } catch (NumberFormatException n) {
                inputString = JOptionPane.showInputDialog("Вам нужно ввести ЦЕЛОЕ ЧИСЛО!");
            }
        }

        println(inputString);

        return inputInt;
    }

    public boolean getBoolean(String promptString) {
        String inputString = "";
        boolean inputBoolean = false;


        println(promptString);

        inputString = JOptionPane.showInputDialog(myframe, promptString);

        while (true) {

            if (inputString.equalsIgnoreCase("да")
                    || inputString.equalsIgnoreCase("yes")) {
                inputBoolean = true;
                break;
            }
            if (inputString.equalsIgnoreCase("нет")
                    || inputString.equalsIgnoreCase("no")) {
                inputBoolean = false;
                break;
            }


            inputString = JOptionPane.showInputDialog(myframe, "Вам нужно ввести ДА или НЕТ");

        }

        println(inputString);

        return inputBoolean;
    }

    public int getInt() {
        String inputString = "";
        int inputInt = 0;
        boolean flag = false;

        inputString = JOptionPane.showInputDialog("");

        while (flag == false) {
            try {
                inputInt = Integer.parseInt(inputString);
                flag = true;
            } catch (NumberFormatException n) {
                inputString = JOptionPane.showInputDialog("Вам нужно ввести ЦЕЛОЕ ЧИСЛО!");
            }
        }

        println(inputString);

        return inputInt;
    }

    public double getDouble(String promptString) {
        String inputString = "";
        double inputDouble = 0.0;
        boolean flag = false;

        println(promptString);

        inputString = JOptionPane.showInputDialog(promptString);

        while (flag == false) {
            try {
                inputDouble = Double.parseDouble(inputString);
                flag = true;
            } catch (NumberFormatException n) {
                inputString = JOptionPane.showInputDialog("Вам нужно ввести ВЕЩЕСТВЕННОЕ ЧИСЛО");
            }
        }

        println(inputString);

        return inputDouble;
    }

    public double getDouble() {
        String inputString = "";
        double inputDouble = 0.0;
        boolean flag = false;

        inputString = JOptionPane.showInputDialog("");

        while (flag == false) {
            try {
                inputDouble = Double.parseDouble(inputString);
                flag = true;
            } catch (NumberFormatException n) {
                inputString = JOptionPane.showInputDialog("Вам нужно ввести ВЕЩЕСТВЕННОЕ ЧИСЛО");
            }
        }

        println(inputString);

        return inputDouble;
    }
}

class MyTerminalIOFrame extends JFrame {

    private TextArea myTextArea;

    public MyTerminalIOFrame() {
        setSize(1000, 500);
        myTextArea = new TextArea("", 1024, 90);
        Font myfont = new Font("DialogInput", Font.PLAIN, 16);
        myTextArea.setFont(myfont);
        Container contentPane = getContentPane();
        contentPane.add(myTextArea, "Center");
        addWindowListener(new WindowCloser());
    }

    public void appendString(String inputString) {
        myTextArea.append(inputString);
    }

    private class WindowCloser extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent event) {
            System.exit(0);
        }
    }
}

