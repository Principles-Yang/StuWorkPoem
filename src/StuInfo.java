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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }
}
