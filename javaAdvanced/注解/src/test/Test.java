package test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TestAnnotation(msg = "hello")
public class Test {

    @Check(value = "hi")
    int a;

    @Perform
    public void testMethod(){}

    @SuppressWarnings("deprecation")
    public void test1() {
        System.out.println("test1");
    }
    public static void main(String[] args) {
        if (Test.class.isAnnotationPresent(TestAnnotation.class)) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("testAnnotation.id" + testAnnotation.id());
            System.out.println("testAnnotation.msg" + testAnnotation.msg());
        }

        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check.value" + check.value());
            }

            Method testMethod = Test.class.getDeclaredMethod("testMethod");
            Perform perform = testMethod.getAnnotation(Perform.class);
            if (perform != null) {
                System.out.println("perform" + perform);
            }

            if (testMethod != null) {
                Annotation[] annotations = testMethod.getAnnotations();
                for (Annotation ann : annotations) {
                    System.out.println("method testMethod annotation:" + ann.annotationType().getSimpleName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
