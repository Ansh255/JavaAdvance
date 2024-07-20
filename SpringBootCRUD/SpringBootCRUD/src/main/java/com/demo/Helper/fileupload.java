package com.demo.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.hibernate.loader.custom.Return;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileupload {
//	public final String UPLOAD_DIR="D:\\java_jsp\\SpringBootCRUD\\SpringBootCRUD\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();
	public fileupload()throws IOException{
		
	}
	public boolean fileupload(MultipartFile file){
		
		boolean f =false;
		try{
//			InputStream s = file.getInputStream();
//			byte[] b = new byte[s.available()];
//			
//			s.read(b);
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(b);
//			
//			fos.close();
//			s.close();
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );
			f=true;	
		}
		catch(Exception e){
			e.printStackTrace();	
		}
		return f;	
	}
	
}
