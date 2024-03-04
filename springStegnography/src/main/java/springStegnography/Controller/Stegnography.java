package springStegnography.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import springStegnography.Extract.Extract_img;
import springStegnography.Hide.Hide_img;

@Controller
public class Stegnography
{
	@Autowired
	private Hide_img hide;
	
	@Autowired
	private Extract_img extract;
	
	@RequestMapping("/hideimg")
	public String hide()
	{
		return "Hide";
	}
	
	@RequestMapping("/extractimg")
	public String extract()
	{
		return "Extract";
	}
	
	@RequestMapping(path="/proccess", method=RequestMethod.POST)
	public ResponseEntity<byte[]> HideImg(@RequestParam("img")CommonsMultipartFile img,@RequestParam("textarea")String textarea,HttpServletResponse res) throws IOException
	{
			
		    BufferedImage image=hide.Hide(img,textarea);
		      
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    
		    ImageIO.write(image, "png", baos);
		    	    
		    byte[] imgbyte=baos.toByteArray();
		    
		    HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG);

	        headers.setContentDispositionFormData(img.getOriginalFilename(), img.getOriginalFilename());
	        
		
           return ResponseEntity.ok().headers(headers).body(imgbyte);
		
	}
	
	
	@RequestMapping(path="/extract", method=RequestMethod.POST)
	public String getData(@RequestParam("img")CommonsMultipartFile img,Model model) throws IOException
	{
		
		String data=extract.getdata(img);
		
		//System.out.println(data);
		
		model.addAttribute("content",data);
		return "Extract";
	}

}
