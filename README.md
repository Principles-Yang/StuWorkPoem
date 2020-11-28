# 计G202 2020322092 杨昀昊

## 实验五：模拟学生作业处理

## 一、实验目的
 1.掌握字符串String及其方法的使用<br>
 2.掌握文件的读取/写入方法<br>
 3.掌握异常处理结构<br>

## 二、实验内容
##### 逻辑与业务要求:
  在某课上,学生要提交实验结果，该结果存储在一个文本文件A中。<br>
    文件A包括两部分内容：<br>
    一是学生的基本信息；<br>
    二是学生处理后的作业信息，该作业的业务逻辑内容是：利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法，实现如下功能：<br>
	-----
    1.每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”<br>
    2.允许提供输入参数，统计古诗中某个字或词出现的次数<br>
    3.输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A<br>
    4.考虑操作中可能出现的异常，在程序中设计异常处理程序<br>
	
    >输入：汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧回眸一笑百媚生
    >六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起
    >从此君王不早朝承欢侍宴无闲暇春从春游夜专夜后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列士
    >可怜光采生门户遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足渔阳鼙鼓动地来
    >惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行<未完，待续>
	
	
	>输出：
    >汉皇重色思倾国，御宇多年求不得。
    >杨家有女初长成，养在深闺人未识。
    >天生丽质难自弃，一朝选在君王侧。
    >回眸一笑百媚生，六宫粉黛无颜色。
    >春寒赐浴华清池，温泉水滑洗凝脂。
    >侍儿扶起娇无力，始是新承恩泽时。
    >云鬓花颜金步摇，芙蓉帐暖度春宵。
    >春宵苦短日高起，从此君王不早朝。
    >…………
	----

#### 实验要求
- [x] 1.设计学生类（可利用之前的）；
- [x] 2.采用交互式方式实例化某学生；
- [x] 3.设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。。
- [x] 4.编写实验报告。


## 三、实验设计
 1、构造了一个ArrayToString函数，将字符串数组转换为字符串（StringBuffer）,以StringBuffer类型返回。<br>
 2、利用字符串的substring()函数对文本进行分割，逢奇加“，”，逢偶加“。”与“\r\n”;返回格式化后的字符串，利用此可以方便的在txt内进行换行。<br>
 3、利用字符流和字符串数组完成文件无乱码的拷贝文件。
 4、利用while循环进行反复查找，并且每查找一次便进行字符串的更新，返回所查询文字出现的字数。<br>
 5、为实现界面的友好化，添加GUI窗口，具体展示请看结果项<br>

 ##### 流程图
 ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/lichengtu.png) <br><br>

 ##### 类图设计
  ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/diagram1.png) <br><br>






## 四、关键代码
1.学生类Students且完成交互实例化：
```Java
public class StuInfo {
    private  String name;
    private  String time;
    private  String worker;
    public StuInfo(){

    }
    public StuInfo(String s,String t,String w){
        name =s;
        time =t;
        worker = w;
    }
	}
	
	StuInfo stu1=new StuInfo("白居易","唐","写诗");
```

2.文件拷贝（并解决乱码问题）
```Java
 try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("./txt/FileB.txt"), "GBK");
            bufferedReader = new BufferedReader(isr);
            bufferedWriter = new BufferedWriter(new FileWriter("./txt/FileA.txt",true));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                s1.append(s);
                s2=FormatOutput(s1);
                bufferedWriter.write(String.valueOf(s2));
                bufferedWriter.newLine();
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
   ```

3.格式化：逢奇数（7）加逗号，逢偶数（14）加句号，使用”\r\n“完成txt文件内的回行
 ```Java
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
 ```

 4.GUI友好界面的设计
 ```Java
        Windows win=new Windows();
        win.setTitle("学生作业——诗词格式化");
        ImageIcon icon=new ImageIcon("./image/book.png");
        win.setIconImage(icon.getImage());
        win.setLayout(null);
        win.setBg();
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
 ```


5.词频统计
 ```Java
      int i=0;
        while(str1.indexOf(str0)!=-1) {
            if(str1.indexOf(str0)!=-1) {
                i++;
                str1=str1.substring(str1.indexOf(str0)+str0.length(), str1.length());
            }
        }
        return i;
 ```
 
 6.设计背景板
  ```Java
      public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("./image/bg.png");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
 ```


## 五、系统运行截图

  #### 最终界面化结果显示
  ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/result1.PNG) <br><br>
  
   #### 词频统计结果显示
  ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/result2.PNG) <br><br>
  
   #### 文件拷贝前
  ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/notepad_before.png) <br><br>

   #### 文件拷贝后，追加输入，并完成格式化存放
  ![](https://github.com/Principles-Yang/StuWorkPoem/blob/master/result/notepad_after.png) <br><br>
  
  
## 七、感想与体会
   1.掌握了字符串的substring方法、append方法与indexof方法以及异常处理机制<br>
   2.学习并使用了IO文件系统<br>
   3.了解了字符流、字节流、字符串数组之间的转化问题<br>
   4.完成了简单的GUI的编写，比较成功的实现了界面的友好化<br>
   5.总结：收益颇丰<br>

  

