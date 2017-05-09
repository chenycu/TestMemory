package com.tc.testmemory.effectivejava;

/**
 * <p></p>
 *
 * @author chenyou
 * @version 2.0.1.0 , 2017/5/4
 */

public class TestPerson {

    private String name;
    private int age;
    private String sex;

    private TestPerson(Builder build){
        this.name = build.name;
        this.age = build.age;
        this.sex = build.sex;

    }

    public static class Builder {
        private String name;
        private int age;
        private String sex;

        public TestPerson build(){
            return new TestPerson(this);
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setAge(int age){
            this.age = age;
            return this;
        }
        public Builder setSex(String sex){
            this.sex = sex;
            return this;
        }
    }

    @Override
    public String toString() {
        return "TestPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
