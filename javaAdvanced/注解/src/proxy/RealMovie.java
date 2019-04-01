package proxy;

public class RealMovie implements Movie {
    @Override
    public void play() {
        System.out.println("正在看电影《绿皮书》");
    }
}
