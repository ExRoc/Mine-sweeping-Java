package main;

import javax.swing.*;
import java.io.*;

// 排行榜数据
public class Rank {
    static class Item {
        String name;
        int score;

        public Item() {
            name = "匿名";
            score = 999;
        }

        public void setItem(String n, int s) {
            name = n;
            score = s;
        }
    }

    Item[] item;

    public Rank(String filename) {
        String name;
        int score;
        item = new Item[3];
        for (int i = 0; i < 3; ++i) {
            item[i] = new Item();
        }
        File file = new File(filename);
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            try {
                ObjectInputStream cin = new ObjectInputStream(in);
                for (int i = 0; i < 3; ++i) {
                    try {
                        score = cin.readInt();
                        name = (String) cin.readObject();
                        item[i].setItem(name, score);
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "文件损坏，请删除文件" + filename + " 后重启程序",
                                "错误", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
                cin.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "文件损坏，请删除文件" + filename + " 后重启程序",
                        "错误", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            writeFile(filename);
        }
    }

    public void writeFile(String filename) {
        File file = new File(filename);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            try {
                ObjectOutputStream cout = new ObjectOutputStream(out);
                for (int i = 0; i < 3; ++i) {
                    cout.writeInt(item[i].score);
                    cout.writeObject(item[i].name);
                }
                cout.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "文件损坏，请删除文件" + filename + " 后重启程序",
                        "错误", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null, "文件损坏，请删除文件" + filename + " 后重启程序",
                    "错误", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void reSet() {
        for (int i = 0; i < 3; ++i) {
            item[i] = new Item();
        }
    }
}
