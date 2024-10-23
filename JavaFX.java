import javax.swing.*;
import java.awt.image.*;
import java.awt.color.*;

public class JavaFX {

    // 6.2章
    public static void main(String[] args) {
        
        var f = new JFrame("drawing");
        f.setVisible(true);
        var label = new JLabel("私の名前は村上英太郎です");
        f.add(label);
        // 配置されたコンポーネントに合わせてウィンドウのサイズを変更
        f.pack();
        // 画像はjava.awt.image1パッケージのBufferedImageクラスを使用
        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        label.setIcon(new ImageIcon(image));
        f.pack();
        // 画像に描画処理を行う
        // Javaでの図形描画はGraphicsオブジェクトに対して行う
        var g = image.createGraphics();
        g.drawLine(0, 0, 600, 400);
        label.repaint();
        g.setColor(Color.RED);
        g.fillRect(300, 200, 150, 100);
        label.repaint();

    }


    // 6.1章
    // public static void main(String[] args) {
    //     JFrame f = new JFrame("test");
    //     f.setVisible(true);
    //     f.setSize(400, 600);
    //     f.setLocation(200,200);
    //     var t = new JTextField();
    //     f.add("North",t);
    //     // f.validate();
    //     t.setText("OOOOOjiojsifojaio");

    //     var t2 = new JTextField("second");
    //     f.add("South", t2);
    //     t.setText(t2.getText().toUpperCase());
    //     f.validate();

    //     var b = new JButton("Upper");
    //     f.add("Center",b);
    //     f.validate();
        
    //     // aeの部分は何でも構わない
    //     b.addActionListener(ae -> t.setText(t2.getText().toUpperCase()));
    //     System.out.println(t.getText());

    // }
}