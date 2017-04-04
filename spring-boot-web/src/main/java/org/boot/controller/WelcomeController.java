
package org.boot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.boot.convert.TypeConverter;
import org.boot.model.Project;
import org.boot.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

  // inject via application.properties
  @Value("${welcome.message:test}")
  private String message = "Hello World";

  @RequestMapping("/")
  public String welcome(Model model) {
    model.addAttribute("userForm", new User());
    return "welcome";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,
      Model model) {

    try {
      URL url = new URL("http://projectservice.staging.tangentmicroservices.com:80/api/v1/projects/");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      conn.setRequestProperty("Authorization", "46d2ab1b9fdb092f803fc83e16bf001292d98fa5");
      conn.connect();
      if (conn.getResponseCode() != 200) {
        return "welcome";
      }

      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

      String output;
      System.out.println("Output from Server .... \n");
      while ((output = br.readLine()) != null) {
        System.out.println(output);
      }
      TypeConverter<Project> converter = new TypeConverter<>(Project.class);
      List<Project> list = converter.convert(output);
      conn.disconnect();

    } catch (IOException e) {

      e.printStackTrace();

    }

    return "index";
  }

}
