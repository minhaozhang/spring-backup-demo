package com.hfi;

import org.apache.log4j.Logger;
import com.hfi.sys.ApplicationContextHost;



/**
* Class Name: ServerStartUp
* Description: TODO
* @author zmh
* @date 2015年12月22日 上午11:20:20 
*/
public class ServerStartUp {
	private static final Logger LOGGER=Logger.getLogger(ServerStartUp.class);

	public static void main(String[] args) {
	    LOGGER.info("--------ServerStartUp is started .------");
		// 初始化
		ApplicationContextHost.init();
		
		
	}
}


