package in.nit.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class UploadUtil {

	public static String upload(String BaseLoc,HttpServletRequest  req) throws IOException, ServletException {

		Part part = req.getPart("photos");
		String fileName=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		System.out.println(fileName);
		String applicationPath=req.getServletContext().getRealPath("");
		String basePath=applicationPath+File.separator+BaseLoc+File.separator;
		InputStream io=part.getInputStream();
		File file=new File(basePath+fileName);
		OutputStream os=new FileOutputStream(file);
		byte[] bytes=new byte[1024];
		int read=0;
		try {
			while((read=io.read(bytes))!=-1) {
				os.write(bytes, 0, read);
			}
		}catch(Exception e) {                                                    
			e.printStackTrace();
		}
		finally{
			if(io!=null)
				io.close();
			if(os!=null)
				os.close();

		}

       return fileName;

	}
}
