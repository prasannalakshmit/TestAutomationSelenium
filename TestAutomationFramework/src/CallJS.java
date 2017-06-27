import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CallJS {

	public CallJS() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String...strings){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		try{
			engine.eval("print('Hello')");
		}catch(ScriptException e){
			e.printStackTrace();
		}
		
	}

}
