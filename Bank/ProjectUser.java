package FullStack;
		import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
		 
		public class ProjectUser {
			
			public static void main(String[] args) {
				long o=0,nmb=0;
			String grt=null;
					int lk=5;
					Scanner sc5=new Scanner(System.in);
				 while(lk>0) {
				try {
				 
					Class.forName("com.mysql.jdbc.Driver");
					Scanner sc=new Scanner(System.in);
					Scanner sc1=new Scanner(System.in);
					Scanner sc2=new Scanner(System.in);
					//Class.forName("com.mysql.jdbc.driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","Adarsh@150401");
					Statement st=con.createStatement();
//					jdbc:mysql://hostname:port/database?useSSL=true&requireSSL=true

//					String cre= "insert into King("
//							+ "id int,name varchar(50),acno varchar(16),mobile varchar(10),email varchar(50),gender varchar(10),District varchar(50),balance varchar(50) )" ; 
//					int p=st.executeUpdate(cre);
//					if(p>0) 
					
					System.out.println("___________________________________________");
					System.err.println("\n                  WELCOME TO OUR BANK");
					System.out.println("_____________________________________");
					System.out.println("\n                  BANK LOG IN PAGE\n");
					System.out.println("1 . USER                            2 . ADMIN");
					int choose = sc.nextInt();
					System.out.println("______________________________________");
					
					if(choose == 1) {
					
					   System.out.println("\n1 . REGISTER PAGE                              2 . SIGNIN\n");
					   System.out.println("______________________________________");
					   int acnum=sc.nextInt();
					   if(acnum==1) {
						   System.err.println("               REGISTER FORM"
						   		            + "\n               -------------\n");
						   System.out.println("Enter Your Full Name ");
						   String nam=sc1.nextLine();
						   System.out.println("Enter Your Mobile Number ");
						   Long mobno=sc.nextLong();
						   System.out.println("Enter Your Email Id ");
						   String emai=sc1.nextLine();
						   System.out.println("Enter Your Account Number ");
						   Long ano=sc.nextLong();
//						   System.out.println("Enter Your Account Number ");
//						   Long ano=sc.nextLong();
						   
						   System.out.println("Enter Your Account Type 1.Saving 2.current ");
						   String typ=sc1.nextLine();
						
						   System.out.println("Enter Your  Gender ");
						   String gen=sc1.nextLine();
						   System.out.println("Enter Your State ");
						   String stat=sc1.nextLine();
						   String use="insert into customer(name,acno,mobile,email,gender,state)value('"+nam+"','"+ano+"','"+mobno+"','"+emai+"','"+gen+"','"+stat+"' )";
						   int i=st.executeUpdate(use);
						
						   if(i>0) {
							   System.out.print("Your details are processing...");
							   for(int k=1;k<=10;k++) {
								   System.out.print(".");
								   Thread.sleep(1000);
							   }
							System.out.println("\nYour Account Was Created successfully");
							System.out.println("____________________________________");
							
						   }
						   else {
							   System.err.println("Unable to process");
						   }
						
					   
					   }
					   
					   else if(acnum==2) {
						   System.out.println("Enter your name");
						   String nam=sc1.nextLine();
						  
						    if(nam != null)
							  {
								
						   ResultSet rs=st.executeQuery("Select * from customer where name='"+nam+"'");
					 
							 while(rs.next()) {
								   o=rs.getInt(8);
							   nmb = rs.getLong(3);
							 grt=rs.getString(2);
							   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO:"+rs.getLong(3)+"\t"+"Balance:"+rs.getInt(8));
							 
						 }
						 	   if(nam.equalsIgnoreCase(grt)) {
						 
						   System.out.println("\n\nif this  your account press confirm \n1 . CONFIRM                         2 . CANCEL");
							int co=sc.nextInt();
							if(co==1) {
								System.out.println("_____________________________________");
						
						  
						   System.out.println("          Enter Your Choice");
						   System.out.println("1 . Deposit                       2 . Withraw");
						   System.out.println("3 . balance enquiry               4 . Change Mobile Number");
						   int cho=sc.nextInt();
						   System.out.println("_____________________________________");
						   switch(cho) {
						   case 1:{
							 
							   System.out.println("Enter Your Amount");
							   int am=sc.nextInt();
							 
							  if(am!=0) {
							  
							 String  rs1="UPDATE customer SET Balance ='"+(am+o)+"'WHERE name = '"+nam+"'";
							 int i1=st.executeUpdate(rs1);
							 
					  rs=st.executeQuery("Select * from customer where name='"+nam+"'");
					  System.out.print("Please Wait .....");
					  for(int h=0;h<=8;h++) {
						 Thread.sleep(1000);
						 System.out.print(".");
					  }
							  System.out.println("\nYour Amount Has Deposited Successfully");
							   while(rs.next()) {
								
								   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO:"+rs.getLong(3)+"\t"+"Balance:"+rs.getInt(8));
									System.out.println("......... Thank You .......");
							   }
							  }else {
								  System.out.println(" We Cant take of your Amount.....");
							  }
						   
							   break;
						   }
		                   case 2:{
		                	   System.out.println("Enter your withdraw amount");
		                	   int aq=sc1.nextInt();
		                	   if(o>=aq) {
		                		   String  rs1="UPDATE customer SET Balance ='"+(o-aq)+"'WHERE name = '"+nam+"'";
		      					 int i1=st.executeUpdate(rs1);
		      					 
		      					   rs=st.executeQuery("Select * from customer where name='"+nam+"'");
		      					  while(rs.next()) {
		      						
		   						   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO:"+rs.getLong(3)+"\t"+"Balance:"+rs.getInt(8));
		   							
		   					   }
		      					  
		                	   }
		                	   else
		                	   {
		                		   System.out.println("Insufficient balance");
		                	   }
		                	   
		                	   break;
						   }case 3:{
							   System.out.println("Your Account Balance is  :"+o);
							   
							   break;
						   }case 4:{
							   System.out.print("Enter Your Old Mobile Numbet :");
							   long om=sc.nextLong();
							   if(nmb==om) {
							   System.out.print("Enter your new mobile number");
							   long om1=sc.nextLong();
							    String mbn="Update customer set mobile='"+om1+"'"+"'where name = '"+nam+"";
							    int ilm=st.executeUpdate(mbn);
							    if(ilm>0) {
							    	System.out.print("Please Wait we are Processing your Account ..");
							    	for(int i2=0;i2<=5;i2++) {
							    	Thread.sleep(3000);
							    	System.out.print(".");
							    }
							    	System.out.println("\nYour Mobile has been updated Successfully  ");
							    	}
							   }
							   else
								   System.out.println("Your mobile number is wrong");
							   break;
						   }
						   }
							System.out.println("___________________________________________");
									
						   System.out.println("If YOu want to exit press no : 0");
							System.out.println("If You Want To Continue Press Any Number");
							lk=sc5.nextInt();
					   } else {
						   System.out.println("Please Check Your Account Number");
					   }
						 	   }
						 	   else
						 		   System.out.println("Result Not Found");
							  }
						 	   else {
								  System.out.println("hello");
							  }}
					   else {
						   System.err.println("enter the valid number");
					   }}
							
					
					else if(choose == 2) {
						System.out.println("USER NAME :");
						String userna=sc1.nextLine();
						System.out.println("PASSWORD  :");
						int pass=sc1.nextInt();
						System.out.println("______________________________________");
						
						if(pass==1234) {
							System.out.println("                  CHOOSE YOUR PERFORMANCE\n");
							System.out.println("1 . SELECT PERSON                    2 . ALL DETAILS");
							System.out.println("3 . BLOCK PERSON                     3 . UPDATE PERSON");
							int ch=sc.nextInt();
							System.out.println("_____________________________________\n");
							
							switch(ch) {
							case 1:{
							
								System.out.println("Enter The Name :");
								String namee=sc2.nextLine();
								ResultSet rs=st.executeQuery("Select * From customer where name='"+namee+"'");
								while(rs.next()) {
									String pri = rs.getString(2);
									if(namee.equalsIgnoreCase(pri)) {
									   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO :"+rs.getLong(3)+"\t"+"MOBILE NO :"+rs.getLong(4)+"\t"+"EMAIL ID :"+rs.getString(5)+"\t"+"GENDER :"+rs.getString(6)+"\t"+"STATE :"+rs.getString(7));
									}else {
										System.out.println("Result Couldnt Found");
									}
									}
							break;
							}
							case 2:{
								String rs1="select * from customer";
								ResultSet rs=st.executeQuery(rs1);
								while(rs.next()) {
									   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO :"+rs.getLong(3)+"\t"+"MOBILE NO :"+rs.getLong(4)+"\t"+"EMAIL ID :"+rs.getString(5)+"\t"+"GENDER :"+rs.getString(6)+"\t"+"STATE :"+rs.getString(7));
									}
							
								System.out.println("");
								
								break;
							}
							case 3:{

								
								System.out.println("Enter The Name :");
								String namee=sc2.nextLine();
								ResultSet rs=st.executeQuery("Select * From customer where name='"+namee+"'");
								while(rs.next()) {
									String pri = rs.getString(2);
									if(namee.equalsIgnoreCase(pri)) {
									   System.out.println("ID :"+rs.getInt(1)+"\t"+" NAME :"+rs.getString(2)+"\t"+"ACCOUNT NO :"+rs.getLong(3)+"\t"+"MOBILE NO :"+rs.getLong(4)+"\t"+"EMAIL ID :"+rs.getString(5)+"\t"+"GENDER :"+rs.getString(6)+"\t"+"STATE :"+rs.getString(7));
									}else {
										System.out.println("Result Couldnt Found");
									}
									}
							break;
							
							
							}
							case 4:{
								
								break;
							}
							}
							System.out.println("_____________________________________");
							System.out.println("If YOu want to exit press no : 0");
							System.out.println("If You Want To Continue Press Any Number");
							lk=sc5.nextInt();
						}
						
						else {
							System.err.println("Out of Performance .....");
						}

						
					}
				}

				catch (Exception e) {
					 
					e.printStackTrace();
				}

			}
				 
			
				 }

		
}
