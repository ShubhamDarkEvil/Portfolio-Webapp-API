package com.portfolio;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;



@Service   
public class FirebaseInitialize {
	@PostConstruct  
	public void initialize() { 
		try {
				System.out.println("Connection to firebase DataBase Initialized !");
				FileInputStream serviceAccount =
				new FileInputStream("src/main/java/com/portfolio/portfolio-db-c4d3b-firebase-adminsdk-1iehj-9f72b88ec1.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.build();

				FirebaseApp.initializeApp(options);
				System.out.println("Connection to FireBase DataBase Successful !");

		    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
