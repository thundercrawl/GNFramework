package  com.github.framework.starter.logging;

public class CommonLogger {
    private static CommonLogger log;
	public static  synchronized void consolePrint(String msg)
	{
		System.out.println("[ "+Thread.currentThread().getName()+" ]"+msg);
	
	}
}