package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaiJiu = new MaotaiJiu();

        InvocationHandler invocationHandler = new Guitai(maotaiJiu);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(), MaotaiJiu.class.getInterfaces(), invocationHandler);

        dynamicProxy.sellWine();
    }
}
