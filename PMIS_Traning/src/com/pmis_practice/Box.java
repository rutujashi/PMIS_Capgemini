package genericexample.com;

class Box1<T> {
	private T item;
	void set(T item)
	{
		this.item=item;
	}
	T get()
	{
		return item;
	}
     
}

class Box
{
	public static void main(String[] args)
	{
		Box1<String> box = new Box1<>();
		box.set("hello");
		String s = box.get();
		System.out.println(s);
	}
}
