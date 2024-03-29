package kr.co.sist.recordcrud;

public class StudentVO {
	private int num;
	private String name;
	private int age;
	private String address;

	public StudentVO(int num, String name, int age, String address) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "번호 : " + num + ", 이름 : " + name + ", 나이 : " + age + ", 주소 : " + address;
	}
}
