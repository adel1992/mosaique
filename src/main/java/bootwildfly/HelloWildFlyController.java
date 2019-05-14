package bootwildfly;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWildFlyController {


    @RequestMapping("hello")
    public String sayHello(){
        return ("Hello, SpringBoot on Wildfly");
    }
    
    @RequestMapping("getStreaming")
	void getStreaming(HttpServletResponse response) throws MalformedURLException, IOException{
		response.setContentType("audio/mpeg");
		IOUtils.copy(RadioConnector.getRadioStream("http://radio.mosaiquefm.net:8000/mosalive"), response.getOutputStream());
	}
}