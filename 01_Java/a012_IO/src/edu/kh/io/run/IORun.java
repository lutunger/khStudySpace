package edu.kh.io.run;

import edu.kh.io.service.IOservice;

public class IORun {

	public static void main(String[] args) {

		IOservice service = new IOservice();
		
//		service.byteOutPut();
//		service.charOutPut();
//		service.byteInput();
//		service.charInput();
//		service.fileCopy();
//		service.objectOutput();
//		service.objectInput();
//		service.listOutput();
		service.listInput();
		
	}

}
