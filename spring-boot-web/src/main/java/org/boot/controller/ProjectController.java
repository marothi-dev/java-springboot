package org.boot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boot.convert.TypeConverter;
import org.boot.model.Project;
import org.boot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectController {

	@RequestMapping(value = "project", method = RequestMethod.GET)
	public ModelAndView projects() {
		ModelAndView modelview = new ModelAndView("login");
		try {
			URL url = new URL("http://projectservice.staging.tangentmicroservices.com:80/api/v1/projects/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "46d2ab1b9fdb092f803fc83e16bf001292d98fa5");
			conn.connect();
			if (conn.getResponseCode() != 200) {
				modelview = new ModelAndView("welcome");
				modelview.addObject("userForm", new User());
				return modelview;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			TypeConverter<Project> converter = new TypeConverter<>(Project.class);
			List<Project> list = null;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				list = converter.convert(output);
			}

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("projects", list);
			modelview = new ModelAndView("project", model);
			conn.disconnect();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return modelview;

	}
}
