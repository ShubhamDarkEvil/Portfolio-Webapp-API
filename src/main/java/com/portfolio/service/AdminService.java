package com.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.portfolio.entity.UserEntity;

@Service
public class AdminService {
	
	 public static final String COL_NAME="users";  

	 UserEntity userEntity = null;
	public UserEntity getAdmninDetails(String name)throws InterruptedException, ExecutionException {
		 Firestore dbFirestore = FirestoreClient.getFirestore(); 
		 DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name); 
		 ApiFuture<DocumentSnapshot> future = documentReference.get();
		 DocumentSnapshot document = future.get();
		 System.out.println(document);
		 if(document.exists()) {  
			 userEntity = document.toObject(UserEntity.class);
			 return userEntity;
		 }
		 else
			 return null;
	}


	public String addAdminDetails(UserEntity userentity) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();  
		 ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(userentity.getName()).set(userentity);
				 
		 return "Record added" + collectionsApiFuture.get().getUpdateTime().toString();	
		 }
	
	
	 public String updateAdminDetails(UserEntity userentity) throws InterruptedException, ExecutionException {  
		 Firestore dbFirestore = FirestoreClient.getFirestore();  
		 ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(userentity.getName()).set(userentity);  
		 return "Records Updated  "+collectionsApiFuture.get().getUpdateTime().toString();  
		 }  
	 
	 
		 public String deleteAdminRecord(String name) {  
		 Firestore dbFirestore = FirestoreClient.getFirestore();  
		 ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();  
		 return "Document with Name :  "+name+" has been deleted";  
		 }


		public  List<UserEntity> getAllAdmninDetails() throws InterruptedException, ExecutionException {
			 Firestore dbFirestore = FirestoreClient.getFirestore();  
			List<UserEntity> allusersList = new ArrayList<UserEntity>();
			CollectionReference alluserListFirebase = dbFirestore.collection(COL_NAME);
			ApiFuture<QuerySnapshot> querySnapshot = alluserListFirebase.get();
			for(DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
				allusersList.add(doc.toObject(UserEntity.class));
				
			}
			return allusersList;
			 
		}
			
			
		
	
	
}


