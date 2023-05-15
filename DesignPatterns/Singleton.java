public class Singleton{
    public static void main(String[] args) {
        Sample sample = Sample.getInstance();
    }
}
class Sample{
    private static Sample sample;
    private Sample(){}
    public static Sample getInstance(){
        if(sample==null){
            sample = new Sample();
        }
        return sample;
    }
}