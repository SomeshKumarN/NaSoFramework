package nasofw.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import nasofw.root.Constants;
import nasofw.root.CustomConfigProperties;

public class DynamicClass {
	// private static int methodPresenceIterator = 0;
	static WebDriver w;
	static Class<?> noparams[] = {};
	static File root = new File(System.getProperty("user.dir"));
	static String[] extensions = { "java" };
	static int methodCounter = 0;// use this to calculate how many classes have
									// the same method name

	public static void callMethodOf(String methodName) {
		Collection<File> files = FileUtils.listFiles(root, extensions, true);
		System.out.println(files);
		Iterator<File> file = files.iterator();
		while (file.hasNext()) {
			String filePath = ((File) file.next()).getAbsolutePath()
					.replace((System.getProperty("user.dir") + "\\"), "").replace(".java", "").replace("\\", ".");

			if (filePath.contains(CustomConfigProperties.getValueOf(Constants.CustomConfigFile.testScritPackage))) {
				System.out.println(filePath);
				if (invokeMethod(filePath, methodName)) {
					break;
				}
			}
		}
		methodCounter = 0;
	}

	static boolean invokeMethod(String filePath, String methodName) {
		Class<?> _class;
		try {
			_class = Class.forName(filePath);
			Object dynamicObject = _class.newInstance();
			Method method = _class.getDeclaredMethod(methodName, noparams);
			System.out.println(methodName);
			method.invoke(dynamicObject, (Object[]) null);
			return true;
		} catch (NoSuchMethodException e) {
			System.out.println("Method not available");
		
		}catch (InvocationTargetException i){
			System.out.println(i.getCause());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	static boolean methodPresence(String filePath, String methodName) {

		if (methodCounter > 1) {
			System.out.println("method is available in another fille:" + filePath);
			return false;
		} else {
			return true;
		}

	}

}
