
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Windows extends JFrame {
    public static void main(String[] args) {
        StringBuffer str=new StringBuffer();
        StringBuffer str1=new StringBuffer();
        StringBuffer s1=new StringBuffer();
        StringBuffer s2=new StringBuffer();

        str=ArrayToString(args);
        str1=FormatOutput(str);
        String str2=new String(str1);

        StuInfo stu1=new StuInfo("白居易","唐","写诗");


        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //设置文件编码，解决文件乱码问题
            //将字节流转换为字符流，实际上使用了一种设计模式——适配器模式
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./txt/FileB.txt"), "GBK");
            bufferedReader = new BufferedReader(isr);
            bufferedWriter = new BufferedWriter(new FileWriter("./txt/FileA.txt",true));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                s1.append(s);
                s2=FormatOutput(s1);
                bufferedWriter.write(String.valueOf(s2));
                bufferedWriter.newLine();//按行读取，写入一个分行符，否则所有内容都在一行显示
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //GUI部分
        Windows win=new Windows();
        win.setTitle("学生作业——诗词格式化");
        ImageIcon icon=new ImageIcon("./image/book.png");
        win.setIconImage(icon.getImage());
        win.setLayout(null);
        win.setBg();
//        ImageIcon img=new ImageIcon("./image/bg.PNG");
//        JLabel jl_bg=new JLabel(img);
//        win.add(jl_bg);
//        win.getLayeredPane().add(jl_bg,new Integer(Integer.MIN_VALUE));
//        ((JPanel)win.getContentPane()).setOpaque(false); //设置透明


        win.setDefaultLookAndFeelDecorated(true);
        JTextArea jta= new JTextArea();
        JTextArea jta1= new JTextArea();

        JLabel userLabel1 = new JLabel("学生信息");
        JLabel StuInfoN = new JLabel(stu1.getName());
        JLabel StuInfoA = new JLabel(stu1.getTime());
        JLabel StuInfoW = new JLabel(stu1.getWorker());
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        Font f = new Font("楷体", Font.LAYOUT_LEFT_TO_RIGHT,17);
        Font bf = new Font("楷体", Font.BOLD+Font.HANGING_BASELINE,17);
        Font s = new Font("宋体", Font.BOLD,18);

        userLabel1.setBounds(20,375,200,100);
        StuInfoN.setBounds(100,385,80,25);
        StuInfoA.setBounds(100,415,80,25);
        StuInfoW.setBounds(100,445,80,25);
        userLabel1.setFont(bf);
        StuInfoN.setFont(bf);
        StuInfoW.setFont(bf);
        StuInfoA.setFont(bf);
        win.add(userLabel1);
        win.add(StuInfoN);
        win.add(StuInfoA);
        win.add(StuInfoW);

        JLabel userLabel = new JLabel("请输入要统计的文字:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(20,475,200,35);
        win.add(userLabel);


        JButton btn=new JButton("统计");
        btn.setFont(s);
        btn.setBounds(220, 500, 85, 30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String str3=jta1.getText();
                int i=WordFrequency(str2,str3);
                JOptionPane.showMessageDialog(null, "该文字在文章中出现的次数为: "+i);
            }
        });
        jta1.setBounds(13, 500, 200, 30);
        jta1.setBackground(new Color(255,255,182,193));
        jta.setColumns(16);
        jta.setRows(50);
        jta.setLineWrap(true);
        jta.append(str2);
        jta.setFont(f);
        jta.setBackground(new Color(255,255,182,193));

        JScrollPane jsp = new JScrollPane(jta);
        jsp.setBounds(13, 10, 350, 340);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        win.add(btn);
        win.add(jta1);
        win.add(jsp);
        win.setSize(600, 600);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //数组转换成字符串函数
    public static StringBuffer ArrayToString(String[] args) {
        StringBuffer str=new StringBuffer();
        for(int i=0;i<args.length;i++) {
            str.append(args[i]);
        }
        return str;
    }

    //格式化输出函数
    public static StringBuffer FormatOutput(StringBuffer str) {
        StringBuffer str2=new StringBuffer();
        for(int i=0;i<str.length()/7;i++) {
            str2.append(str.substring(7*i, 7*(i+1)));
            if((i+1)%2!=0) {
                str2.append(",");
            }
            else {
                str2.append("。").append("\r\n");
            }
        }
        return str2;
    }

    //词频统计函数
    public static int WordFrequency(String str1,String str0) {
        int i=0;
        while(str1.indexOf(str0)!=-1) {
            if(str1.indexOf(str0)!=-1) {
                i++;
                str1=str1.substring(str1.indexOf(str0)+str0.length(), str1.length());
            }
        }
        return i;
    }

    //设置背景板
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("./image/bg.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }

}

