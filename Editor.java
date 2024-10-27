import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.TableColumn;

import  java.io.*;

public class Editor {

    private JFrame frame;
    private JTable tablePanel;
    private String tansyuku = " 短縮よみ";

    // private static final Logger logger = LoggerFactory.getLogger(Editor.class);

    public void show() throws IOException{
        frame = new JFrame("Java Editor");
        frame.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
        // tablePanel = new JTable();
        // for(int i=0;i<3;i++){
        //     tablePanel.addColumn(new TableColumn(i));
        // }
        // ComponentクラスとJSplitPaneの違い
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            new ScrollPane(ScrollPane.SCROLLBARS_NEVER),
            new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS));
        frame.add(split);

        var text1 = new JTextField();
        frame.add("North",text1);
        
        var text2 = new JTextField();
        frame.add("South",text2);

        var btn1 = new JButton("辞書変換");
        // インデックス文字が自動生成されるボタン
        // btn1.addActionListener(ea -> text2.setText(text1.getText().substring(0, 2)+"  "+text1.getText()+tansyuku));
        btn1.addActionListener(ea -> calcIndexString(text1, text2));
        frame.add(btn1);
        // インデックス文字を登録できるボタン
        var textForIndex = new JTextField();
        var btn2 = new JButton("");
        btn2.addActionListener(ea -> calcIndexString(textForIndex.getText(), text1,text2));
        // frame.add(btn2);

        // =========追加予定の機能
        // インデックス文字の算出メソッドを選択可能にする
        // 既存の辞書ファイルを読み込んで表示
        // 登録予定のレコードをファイルに追加して保存
        // 既存の辞書ファイルの辞書登録自動化
        
        frame.add(loadTargetFile("C:\\Users\\a3123\\Documents\\Archives\\user_dictionary\\aa.txt"));

        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
    
    /**
     * 登録用レコードが作成される_インデックス文字を自動生成
     * @param input
     * @param output
     */
    private void calcIndexString(JTextField input,JTextField output){
        int length = input.getText().length();
        if(length >= 2){
            calcIndexString(input.getText().substring(0, 2),input, output);
        } else {
            new Exception("登録対象の文字数が少なすぎます");
        }
    }
    /**
     * 登録用レコードが作成される_インデックス文字は手入力
     * @param indexString
     * @param input
     * @param output
     */
    private void calcIndexString(String indexString,JTextField input,JTextField output){
        output.setText(indexString+"    "+input.getText()+"   "+tansyuku);
    }
    /**
     * 辞書ファイル読み込み
     * TODOファイルの改行を一行と見做してしまう問題
     * TODO文字コードの管理
     * 
     */
    private JTextArea loadTargetFile(String filePath) throws FileNotFoundException, IOException{
        System.out.println("start load");
        var textArea = new JTextArea();
        // textArea.setFont("UTF-16");
        
        try(BufferedReader in = new BufferedReader(new FileReader(filePath))){
            // UTF-16LEの改行コードは？
            String line = in.readLine();
            while(line!=null){
                if(!line.equals("\n")&&!line.equals("\r")){
                    textArea.append(line);
                    textArea.append("\n");
                    System.out.println("read a line："+line);
                } else {
                    System.out.println("remove a line："+line);
                }
                line = in.readLine();
            }
            return textArea;
        }
    }

    /**
     * ファイル作成(保存ボタン押下)
     * ファイルの更新は、textareaを直接編集できる
     */
    private void writeFile(String filePath){
        //JTextAreaのthisとは？
    }
    
    public static void main(String[] args) throws IOException {
        
        Editor e = new Editor();
        // if(args != null && args.length == 1){
            
        // }
        e.show();
    }
}
