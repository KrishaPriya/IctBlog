package Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class userLog {
	static Logger logger = LogManager.getLogger(userLog.class);
	
	public static void main(String[] args)
	{
	
		logger.info("\n this is  \n");
	}

}
