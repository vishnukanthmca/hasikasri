package com.aha.web.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aha.config.social.facebook.FBConnection;
import com.aha.core.service.ImageService;
import com.aha.core.service.ProductService;

@Controller
public class HomeController {

	private static final String HOME_PAGE = "home";
	private static final String LISTING_PAGE = "listing";
	private static final String ERROR_PAGE = "error";

	@Autowired
	private Facebook faceBook;

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/listing")
	public ModelAndView listing() {
		// System.out.println("facebook " + faceBook);
		// System.out.println(faceBook.ge);

		ModelAndView modelAndView = new ModelAndView(LISTING_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/callback", params = "code", method = RequestMethod.GET)
	@ResponseBody
	public void accessCode(@RequestParam("code") String code,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			response.setContentType("text/html");
			System.out.println("code " + code);
			if (code == null || code.equals("")) {
				throw new RuntimeException(
						"ERROR: Didn't get code parameter in callback.");
			}
			FBConnection fbConnection = new FBConnection();
			String accessToken = fbConnection.getAccessToken(code);
			//
			// FBGraph fbGraph = new FBGraph(accessToken);
			// String graph = fbGraph.getFBGraph();
			// Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
			// ServletOutputStream out = response.getOutputStream();
			// out.println("<h1>Facebook Login using Java</h1>");
			// out.println("<h2>Application Main Menu</h2>");
			// out.println("<div>Welcome " + fbProfileData.get("first_name"));
			// out.println("<div>Your Email: " + fbProfileData.get("email"));
			// out.println("<div>You are " + fbProfileData.get("id"));

			String graph = null;
			try {

				String g = "https://graph.facebook.com/me?fields=id,first_name,email&"
						+ accessToken;
				URL u = new URL(g);
				URLConnection c = u.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						c.getInputStream()));
				String inputLine;
				StringBuffer b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
				graph = b.toString();
				System.out.println("graph " + graph);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("ERROR in getting FB graph data. "
						+ e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
	@ResponseBody
	public void error(@RequestParam("error_reason") String errorReason,
			@RequestParam("error") String error,
			@RequestParam("error_description") String description,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
			System.out.println(errorReason);
			System.out.println(error);
			System.out.println(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/googleCallback", method = RequestMethod.GET)
	@ResponseBody
	public void googleCallback(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html");
			// FBConnection fbConnection = new FBConnection();
			// String accessToken = fbConnection.getAccessToken(code);
			//
			// FBGraph fbGraph = new FBGraph(accessToken);
			// String graph = fbGraph.getFBGraph();
			// Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
			// ServletOutputStream out = response.getOutputStream();
			// out.println("<h1>Facebook Login using Java</h1>");
			// out.println("<h2>Application Main Menu</h2>");
			// out.println("<div>Welcome " + fbProfileData.get("first_name"));
			// out.println("<div>Your Email: " + fbProfileData.get("email"));
			// out.println("<div>You are " + fbProfileData.get("id"));

			System.out.println("url " + request.getQueryString());

			String graph = null;
			try {

				// String g =
				// "https://www.googleapis.com/auth/userinfo.email?access_token="
				// + code;
				// String g =
				// "www.googleapis.com?/oauth2/v1/tokeninfo?id_token="
				// + code;
				URL u = new URL("");
				System.out.println("url " + u);
				URLConnection c = u.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						c.getInputStream()));
				String inputLine;
				StringBuffer b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
				graph = b.toString();
				System.out.println("graph " + graph);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("ERROR in getting FB graph data. "
						+ e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		// con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

}
