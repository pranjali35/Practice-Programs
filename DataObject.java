
import java.io.*;

public class DataObject implements Serializable{


	protected String message;
		
	public DataObject(){

		message = null;
	}

	public void setMessage(String m){

		message = m;
	}

	public String getMessage(){

		return message;
	}

}