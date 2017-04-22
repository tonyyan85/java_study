package guava.object;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import org.junit.Test;
import com.google.common.base.Objects;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yandi on 2017/4/15.
 */
class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person other = (Person)obj;
            return Objects.equal(name,other.name)
                    && Objects.equal(age,other.age);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name,age);
    }

//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("name",this.name).add("age",this.age).toString();
//    }
}

public class GuavaObjectsTest {

    @Test
    public void testEqual() {
        System.out.println(Objects.equal("a","a")); // true
        System.out.println(Objects.equal(1,1));  // true
        System.out.println(Objects.equal("a",null)); // false
        System.out.println(Objects.equal(null,1)); // false
        System.out.println(Objects.equal(null,null)); // true
    }

    @Test
    public void testObjectEqual() {
        Person person1 = new Person("lgq",123);
        Person person2 = new Person("lgq",123);
        Person person3 = new Person("yj",23);
        Person person4 = person1;
        System.out.println(Objects.equal(person1,null)); // false
        System.out.println(Objects.equal(person1,person2)); // false
        System.out.println(Objects.equal(person1,person3)); // false
        System.out.println(Objects.equal(person1,person4)); // true
    }

    @Test
    public void testToString() {
        System.out.println(MoreObjects.toStringHelper(this).add("test",1).toString());
        System.out.println(MoreObjects.toStringHelper(Person.class).add("name", "lgq").add("age", 12).toString());

        Person person = new Person("lgq",128);
        String msg = MoreObjects.toStringHelper(Person.class).add("name11",person.name)
                .add("age",person.age).toString();
        System.out.println(msg);

    }

    @Test
    public void testCompare() {
        Person person1=new Person("apple",25);
        Person person2=new Person("bill",25);
        Person person3=new Person("candy",26);
        Person person4=new Person("david",26);
        List<Person> list = Lists.newArrayList(person1, person2, person3, person4);
        ///////////////////////////////////////////////////////////////////////////
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return ComparisonChain.start().compare(o1.name, o2.name)
                        .compare(o1.age, o2.age).result();
            }
        });
        ///////////////////////////////////////////////////////////////////////////

    }
}