package AnnotationDemo;

import java.lang.annotation.Target;
import java.util.Date;

@AnnoDemo1(age = 12, anno = @AnnoDemo2(13), st = AnnoTest.class, str = "132", p = Person.age, arr = {1,2,3,4})     // ×¢½âµÄ¸³Öµ
@AnnoDemo3
public class AnnoTest {
    @AnnoDemo3
    public int a = 3;
    @AnnoDemo3
    public int add(int a1, int a2) {
        return a1 + a2;
    }
}
