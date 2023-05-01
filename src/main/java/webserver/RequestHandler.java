package webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DataBase;
import model.User;
import util.HttpRequestUtils;
import util.IOUtils;

public class RequestHandler extends Thread {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            // TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
        	
        	// 요구 사항 1. index.html 응답하기
        	BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        	String headerMessage = br.readLine();
        	log.debug("HTTP Request Line : {}", headerMessage);
        	
        	if (headerMessage == null) return;
        	
        	String tokens[] = headerMessage.split(" ");
        	
//        	while (!headerMessage.equals("")) {
//        		headerMessage = br.readLine();
//        		log.debug(" : {}", headerMessage);
//        	}
        	
        	
        	// 요구사항 2. GET 방식으로 회원 가입하기
//        	String url = tokens[1];
//        	if (url.startsWith("/user/create")) {
//        		int index = url.indexOf("?");
//        		String queryString = url.substring(index + 1);
//        		
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(queryString);
//        		
//        		User user = new User(params.get("userId"), params.get("password"),
//        				params.get("name"), params.get("email"));
//        		
//        		log.debug("User : {}", user);
//        	} else {
//        		DataOutputStream dos = new DataOutputStream(out);
//        		byte[] body = Files.readAllBytes(new File("./webapp" + tokens[1]).toPath());
//        		response200Header(dos, body.length);
//                responseBody(dos, body);
//        	}
        	
        	// 요구사항 3. POST 방식으로 회원 가입하기
//        	int contentLength = 0;
//        	while (!headerMessage.equals("")) {
//        		headerMessage = br.readLine();
//        		log.debug(" : {}", headerMessage);
//        		
//        		if (headerMessage.contains("Content-Length")) {
//        			String[] headerTokens = headerMessage.split(":");
//        			contentLength = Integer.parseInt(headerTokens[1].trim());
//        		}
//        	}
//        	
//        	String url = tokens[1];
//        	if (url.startsWith("/user/create")) {
//        		String queryString = IOUtils.readData(br, contentLength);
//        		
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(queryString);
//        		
//        		User user = new User(params.get("userId"), params.get("password"),
//        				params.get("name"), params.get("email"));
//        		
//        		log.debug("User : {}", user);
//        	} else {
//        		DataOutputStream dos = new DataOutputStream(out);
//        		byte[] body = Files.readAllBytes(new File("./webapp" + tokens[1]).toPath());
//        		response200Header(dos, body.length);
//                responseBody(dos, body);
//        	}
        	
//        	// 요구사항 4.302 status code 적용하기
//        	int contentLength = 0;
//        	while (!headerMessage.equals("")) {
//        		headerMessage = br.readLine();
//        		log.debug(" : {}", headerMessage);
//        		
//        		if (headerMessage.contains("Content-Length")) {
//        			String[] headerTokens = headerMessage.split(":");
//        			contentLength = Integer.parseInt(headerTokens[1].trim());
//        		}
//        	}
//        	
//        	String url = tokens[1];
//        	if (url.startsWith("/user/create")) {
//        		String queryString = IOUtils.readData(br, contentLength);
//        		
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(queryString);
//        		
//        		User user = new User(params.get("userId"), params.get("password"),
//        				params.get("name"), params.get("email"));
//        		
//        		log.debug("User : {}", user);
//        		url = "/index.html";
//        		
//        		DataOutputStream dos = new DataOutputStream(out);
//        		byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
//        		response302Header(dos, "/index.html");
//                
//        	} else {
//        		DataOutputStream dos = new DataOutputStream(out);
//        		byte[] body = Files.readAllBytes(new File("./webapp" + tokens[1]).toPath());
//        		response200Header(dos, body.length);
//                responseBody(dos, body);
//        	}
        	
//        	// 요구사항 5.로그인하기
//        	int contentLength = 0;
//        	while (!headerMessage.equals("")) {
//        		headerMessage = br.readLine();
//        		log.debug(" : {}", headerMessage);
//        		
//        		if (headerMessage.contains("Content-Length")) {
//        			String[] headerTokens = headerMessage.split(":");
//        			contentLength = Integer.parseInt(headerTokens[1].trim());
//        		}
//        	}
//        	
//        	String url = tokens[1];
//        	if (url.startsWith("/user/create")) {
//        		String queryString = IOUtils.readData(br, contentLength);
//        		
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(queryString);
//        		
//        		User user = new User(params.get("userId"), params.get("password"),
//        				params.get("name"), params.get("email"));
//        		
//        		DataBase.addUser(user);
//        	} else if ("/user/login".equals(url)){
//        		String body = IOUtils.readData(br, contentLength);
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(body);
//        		
//        		User user = DataBase.findUserById(params.get("userId"));
//        		
//        		if (user == null) {
//        			responseResource(out, "/user/login_failed.html");
//        			return;
//        		}
//        		
//        		if (user.getPassword().equals(params.get("password"))) {
//        			DataOutputStream dos = new DataOutputStream(out);
//        			response302LoginSuccessHeader(dos);
//        		} else {
//        			responseResource(out, "/user/login_failed.html");
//        		}
//        	} else {
//        		responseResource(out, url);
//        	}
        	
//        	// 요구사항 6.로그인한 목록
//        	boolean logined = false;
//        	
//        	int contentLength = 0;
//        	while (!headerMessage.equals("")) {
//        		headerMessage = br.readLine();
//        		
//        		if (headerMessage.contains("Cookie")) {
//        			logined = isLogin(headerMessage);
//        		}
//        		
//        		if (headerMessage.contains("Content-Length")) {
//        			String[] headerTokens = headerMessage.split(":");
//        			contentLength = Integer.parseInt(headerTokens[1].trim());
//        		}
//        	}
//        	
//        	String url = tokens[1];
//        	if (url.startsWith("/user/create")) {
//        		String queryString = IOUtils.readData(br, contentLength);
//        		
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(queryString);
//        		
//        		User user = new User(params.get("userId"), params.get("password"),
//        				params.get("name"), params.get("email"));
//        		
//        		DataBase.addUser(user);
//        	} else if ("/user/login".equals(url)){
//        		String body = IOUtils.readData(br, contentLength);
//        		Map<String, String> params = 
//        				HttpRequestUtils.parseQueryString(body);
//        		
//        		User user = DataBase.findUserById(params.get("userId"));
//        		
//        		if (user == null) {
//        			responseResource(out, "/user/login_failed.html");
//        			return;
//        		}
//        		
//        		if (user.getPassword().equals(params.get("password"))) {
//        			DataOutputStream dos = new DataOutputStream(out);
//        			response302LoginSuccessHeader(dos);
//        		} else {
//        			responseResource(out, "/user/login_failed.html");
//        		}
//        	} else if ("/user/list".equals(url)) {
//        		if (!logined) {
//        			responseResource(out, "/user/login.html");
//        		}
//        		
//        		Collection<User> users = DataBase.findAll();
//        		
//        		StringBuilder sb = new StringBuilder();
//        		sb.append("<table border='1'>");
//        		
//        		for (User user : users) {
//        			sb.append("<tr>");
//        			sb.append("<td>" + user.getUserId() + "</td>");
//        			sb.append("<td>" + user.getName() + "</td>");
//        			sb.append("<td>" + user.getEmail() + "</td>");
//        			sb.append("<tr>");
//        		}
//        		
//        		sb.append("</table>");
//        		byte[] body = sb.toString().getBytes();
//        		DataOutputStream dos = new DataOutputStream(out);
//        		
//        		response200Header(dos, body.length);
//        		responseBody(dos, body);
//        		
//        	} else {
//        		responseResource(out, url);
//        	}
//            
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        }
        	
	    	// 요구사항 7.CSS 지원하기 
	    	boolean logined = false;
	    	
	    	int contentLength = 0;
	    	while (!headerMessage.equals("")) {
	    		headerMessage = br.readLine();
	    		
	    		if (headerMessage.contains("Cookie")) {
	    			logined = isLogin(headerMessage);
	    		}
	    		
	    		if (headerMessage.contains("Content-Length")) {
	    			String[] headerTokens = headerMessage.split(":");
	    			contentLength = Integer.parseInt(headerTokens[1].trim());
	    		}
	    	}
	    	
	    	String url = tokens[1];
	    	if (url.startsWith("/user/create")) {
	    		String queryString = IOUtils.readData(br, contentLength);
	    		
	    		Map<String, String> params = 
	    				HttpRequestUtils.parseQueryString(queryString);
	    		
	    		User user = new User(params.get("userId"), params.get("password"),
	    				params.get("name"), params.get("email"));
	    		
	    		DataBase.addUser(user);
	    	} else if ("/user/login".equals(url)){
	    		String body = IOUtils.readData(br, contentLength);
	    		Map<String, String> params = 
	    				HttpRequestUtils.parseQueryString(body);
	    		
	    		User user = DataBase.findUserById(params.get("userId"));
	    		
	    		if (user == null) {
	    			responseResource(out, "/user/login_failed.html");
	    			return;
	    		}
	    		
	    		if (user.getPassword().equals(params.get("password"))) {
	    			DataOutputStream dos = new DataOutputStream(out);
	    			response302LoginSuccessHeader(dos);
	    		} else {
	    			responseResource(out, "/user/login_failed.html");
	    		}
	    	} else if ("/user/list".equals(url)) {
	    		if (!logined) {
	    			responseResource(out, "/user/login.html");
	    		}
	    		
	    		Collection<User> users = DataBase.findAll();
	    		
	    		StringBuilder sb = new StringBuilder();
	    		sb.append("<table border='1'>");
	    		
	    		for (User user : users) {
	    			sb.append("<tr>");
	    			sb.append("<td>" + user.getUserId() + "</td>");
	    			sb.append("<td>" + user.getName() + "</td>");
	    			sb.append("<td>" + user.getEmail() + "</td>");
	    			sb.append("<tr>");
	    		}
	    		
	    		sb.append("</table>");
	    		byte[] body = sb.toString().getBytes();
	    		DataOutputStream dos = new DataOutputStream(out);
	    		
	    		response200Header(dos, body.length);
	    		responseBody(dos, body);
	    		
	    	} else if (url.endsWith(".css")) {
	    		DataOutputStream dos = new DataOutputStream(out);
	    		byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
	    		
	    		response200CssHeader(dos, body.length);
	    		responseBody(dos, body);
	    	} else {
	    		responseResource(out, url);
	    	}
            
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response200CssHeader(DataOutputStream dos, int length) {
    	try {
			dos.writeBytes("HTTP/1.1 200 OK \r\n");
			dos.writeBytes("Content-Type: text/css\r\n");
	        dos.writeBytes("Content-Length:" + length + " \r\n");
	        dos.writeBytes("\r\n");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private boolean isLogin(String headerMessage) {
    	String[] headerTokens = headerMessage.split(":");
    	Map<String, String> cookies = HttpRequestUtils.parseCookies(headerTokens[1].trim());
    	String value = cookies.get("logined");
    	
    	if (value == null) return false;
		return Boolean.parseBoolean(value);
	}

	private void response302LoginSuccessHeader(DataOutputStream dos) {
    	try {
			dos.writeBytes("HTTP/1.1 302 OK \r\n");
			dos.writeBytes("Set-Cookie: logined=true \r\n");
	        dos.writeBytes("Location: /index.html \r\n");
	        dos.writeBytes("\r\n");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private void responseResource(OutputStream out, String url) throws IOException{
		DataOutputStream dos = new DataOutputStream(out);
		byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
		response200Header(dos, body.length);
		responseBody(dos, body);
	}

	private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
    
    private void response302Header(DataOutputStream dos, String url) {
    	try {
    		dos.writeBytes("HTTP/1.1 302 Redirect \r\n");
    		dos.writeBytes("Location: " + url + "\r\n");
    		dos.writeBytes("HTTP/1.1 302 Redirect \r\n");
    	} catch (Exception e) {
    		log.error(e.getMessage());
		}
    }
}
