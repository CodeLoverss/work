package work9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    public int age;
    public String name;
    public String sex;
    public void setName(String name) {this.name=name;}
    public void setAge(int age) {this.age=age;}
    public void setSex(String sex) {this.sex=sex;}
}
class Teacher extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	public int salary;
    public void setSalary(int salary) {this.salary=salary;}
}
class Student extends Person{
	public int grade;
	public void setGrade(int grade) {this.grade=grade;}
}
class Animal{
	public int age;
    public String name;
    public String sex;
    public void setName(String name) {this.name=name;}
    public void setAge(int age) {this.age=age;}
    public void setSex(String sex) {this.sex=sex;}
}
class Dog extends Animal implements Serializable{
	public int weight;
	public void setWeight(int weight) {this.weight=weight;}
}
public class SerializeTest {

	private static void SerializeObject(int flag) throws FileNotFoundException,IOException, ClassNotFoundException {
		if(flag==1) {
			Person father = new Person();
			Teacher son=new Teacher();
			father.setName("gacl");
			father.setAge(25);
			father.setSex("男");
			son.setSalary(1500);
			// ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
			ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:/Person.txt")));
			oo.writeObject(father);
			oo.writeObject(son);
			//反序列化
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/Person.txt")));
	        Person father1 = (Person) ois.readObject();
	        Teacher son1=(Teacher)ois.readObject();
	        //System.out.println(father1.name+" "+son1.salary);
			oo.close();
			if(father instanceof Serializable){
				System.out.println("Person被序列化");
			}
			else {System.out.println("Person未序列化");}
			if(son instanceof Serializable){
				System.out.println("Teacher被序列化");
			}
			else {System.out.println("Teacher未序列化");}
			}
		else if(flag==2) {
			Animal animal=new Animal();
			Dog dog=new Dog();
			if(animal instanceof Serializable){
				System.out.println("Animal被序列化");
			}
			else {System.out.println("Animal未序列化");}
			if(dog instanceof Serializable){
				System.out.println("Dog被序列化");
			}
			else {System.out.println("Dog未序列化");}
		}
		else if(flag==3) {
			Person p=new Person();
			Student stu=new Student();
			if(p instanceof Serializable){
				System.out.println("Person被序列化");
			}
			else {System.out.println("Person未序列化");}
			if(stu instanceof Serializable){
				System.out.println("Student被序列化");
			}
			else {System.out.println("Student未序列化");}
		}
		else return;
		//System.out.println("对象序列化成功！");
		
}
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
				SerializeObject(1);//父类和子类都实现Serializable
				SerializeObject(2);//子类实现Serializable，父类未实现Serializable
				SerializeObject(3);//父类实现Serializable，子类未实现Serializable
	}		
}
