import java.io.*;

import java.sql.*;

import java.util.*;

public class RandomDBGen_EMP {
	final static int MAX = 27608;
	public static void main(String[] args) {
		try {
			int i = 0;
			int j = 0;
			int k = 0;
			int x = 0;

			Random rand = new Random();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "");
			PreparedStatement ps;
			Scanner file = new Scanner(new FileInputStream("names.txt"));
`
			int numOfRecords = Integer.parseInt(args[0]);
			String op = args[1];
			
			String[] name = new String[MAX];
			while(file.hasNext())
			{
				name[x] = file.nextLine();
				x++;
			}
			
			String[] desig = new String[] {
				"Software engineer", "Systems analyst",
				"Business analyst", "Technical support",
				"Network engineer", "Technical consultant",
				"Technical sales", "Project manager",
				"Web developer", "Software tester",
			};
			int salary;
			String[] dept = new String[] {
				"Production", "R&D",
				"Purchasing", "Marketing",
				"HR Management", "Accounting and Finance",
				"IT"
			};
			int age;
			float performance;
			String[] countries = new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
					"Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
					"Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
					"Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana",
					"Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria",
					"Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
					"Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands",
					"Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands",
					"Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark",
					"Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador",
					"Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)",
					"Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
					"French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
					"Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea",
					"Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)",
					"Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)",
					"Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya",
					"Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan",
					"Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
					"Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau",
					"Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives",
					"Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico",
					"Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
					"Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands",
					"Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
					"Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama",
					"Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal",
					"Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
					"Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
					"Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
					"Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
					"South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena",
					"St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland",
					"Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan",
					"Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago",
					"Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
					"United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands",
					"Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)",
					"Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia",
					"Zambia", "Zimbabwe" 
				};
			
				while(file.hasNextLine()){
				name[i++] = file.nextLine();
			}
			String[] bg = new String[] {
				"A+", "A-",
				"B+", "B-",
				"AB+", "AB-",
				"O+", "O-"
			};
			String[] gender = new String[] {
				"Male", "Female", "LGBTQ"
			};
			String[] married = new String[] {
				"Yes", "No"
			};

			if (op.compareToIgnoreCase("dml") == 0) {
				String tableQuery = args[2];
				Statement st = con.createStatement();
				st.executeUpdate(tableQuery);
				System.out.println("Query executed successfully!");
			} else if (op.compareToIgnoreCase("ddl") == 0) {
				PreparedStatement st = con.prepareStatement("SELECT max(e_id) FROM EMPLOYEE");
				ResultSet rs = st.executeQuery();
				while (rs.next())
					i = rs.getInt(1);
				
				k = i;
				for (j = 0; i < numOfRecords; i++, j++) {

					salary = rand.nextInt(200000) + 10000;
					age = rand.nextInt(63) + 18;
					performance = rand.nextFloat() * 100f;

					ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

					int y = rand.nextInt(name.length);
					// if(name[y].compareTo("null"))
						// System.out.println(y + " " + name[y]);
					ps.setInt(1, (i + 1));
					ps.setString(2, name[y]);
					ps.setString(3, desig[rand.nextInt(desig.length)]);
					ps.setInt(4, salary);
					ps.setString(5, dept[rand.nextInt(dept.length)]);
					ps.setInt(6, age);
					ps.setFloat(7, performance);
					ps.setString(8, countries[rand.nextInt(countries.length)]);
					ps.setString(9, bg[rand.nextInt(bg.length)]);
					ps.setString(10, gender[rand.nextInt(gender.length)]);
					ps.setString(11, married[rand.nextInt(married.length)]);

					ps.execute();

					double u = ((double) j / (Double.parseDouble(args[0]) - k) * 100f);
					u = Math.floor(u * 100) / 100;
					System.out.print(u + "% done...\t\t\r");

					// dataText = ("(" + (i + 1) + ", " + rpm[rand.nextInt(rpm.length)] + ", " + speed[rand.nextInt(speed.length)] + ", " + kmpl + ", " + gear + ", " + x + ", " + y + ", \""
					// + countries[rand.nextInt(countries.length)] + "\"),\n");
					// fw.write(dataText);
				}

				System.out.println("\ninsertion complete!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}