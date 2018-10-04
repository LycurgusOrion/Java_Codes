import java.io.*;

import java.sql.*;

import java.util.*;

public class RandomDBGen_VHCL
{
	public static void main(String[] args) 
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle", "root", "");
			PreparedStatement ps;

			String op = args[2];

			Random rand = new Random();
			// String filepath = args[2];
	
			// FileWriter fw = new FileWriter(filepath);
	
			int[] rpm = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
			int[] speed = {10, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 130};
			int[] m = {-1, 1};
			
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
					"Zambia", "Zimbabwe" };

			int gear;
			float kmpl;
			int x, y;
			int i = 0;
			int j = 0;
			int k = 0;
	
			// String dataText;

			if(op.compareToIgnoreCase("dml") == 0)
			{
				Statement st = con.createStatement();
				String vehicleTableQuery = args[3];
				st.executeUpdate(vehicleTableQuery);
				System.out.println("Query executed successfully!");
			}
			else if(op.compareToIgnoreCase("ddl") == 0)
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT max(ID) FROM STATS");
				while(rs.next())
					i = rs.getInt(1);
				k = i;
				for(j = 0 ; i < Integer.parseInt(args[0]) ; i++, j++)
				{
					ps = con.prepareStatement("INSERT INTO STATS VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	
					gear = rand.nextInt(7) + 1;
					kmpl = (rand.nextFloat() * 30.0f) + 5.0f;
					x = rand.nextInt(Integer.parseInt(args[1])) * m[rand.nextInt(m.length)];
					y = rand.nextInt(Integer.parseInt(args[1])) * m[rand.nextInt(m.length)];
					
					ps.setInt(1, (i + 1));
					ps.setInt(2, rpm[rand.nextInt(rpm.length)]);
					ps.setInt(3, speed[rand.nextInt(speed.length)]);
					ps.setFloat(4, kmpl);
					ps.setInt(5, gear);
					ps.setInt(6, x);
					ps.setInt(7, y);
					ps.setString(8, countries[rand.nextInt(countries.length)]);
					
					ps.execute();
					
					double u = ((double)j / (Double.parseDouble(args[0]) - k) * 100f);
					u = Math.floor(u * 100) / 100;
					System.out.print(u + "% done...\t\t\r");
					
					// dataText = ("(" + (i + 1) + ", " + rpm[rand.nextInt(rpm.length)] + ", " + speed[rand.nextInt(speed.length)] + ", " + kmpl + ", " + gear + ", " + x + ", " + y + ", \""
							// + countries[rand.nextInt(countries.length)] + "\"),\n");
					// fw.write(dataText);
				}

				System.out.println("\ninsertion complete!");
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}