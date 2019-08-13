package Hangman;

public class Countries {
	
	@SuppressWarnings("unused")
	private static String[] COUNTRIES =  {
		    "Afghanistan", "Albania", "Algeria", "Andorra",
		    "Angola", "Anguilla", "Antarctica", "Argentina",
		    "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
		    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
		    "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
		    "Botswana", "Bouvet Island", "Brazil", 
		    "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
		    "Cambodia", "Cameroon", "Canada", "Cape Verde",
		    "Cayman Islands", "Chad", "Chile", "China",
		    "Christmas Island","Colombia", "Comoros", "Congo",
		    "Costa Rica", "Croatia", "Cuba", "Cyprus",
		    "Denmark", "Djibouti", "Dominica",
		    "Ecuador", "Egypt", "Eritrea",
		    "Estonia", "Ethiopia", "Fiji", "Finland",
		    "France", 
		    "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
		    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
		    "Guyana", "Haiti", "Honduras", "Hungary",
		    "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
		    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
		    "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
		    "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta",
		    "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
		    "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
		    "Nauru", "Nepal", "Netherlands", 
		    "Nicaragua", "Niger", "Nigeria", "Niue",
		    "Norway", "Oman", "Pakistan", "Palau", "Panama","Paraguay", "Peru",
		    "Philippines", "Poland", "Portugal","Qatar",
		    "Reunion", "Romania", "Russia", "Rwanda",    
		    "Samoa", "Senegal",
		    "Seychelles","Singapore", "Slovakia", "Slovenia",
		    "Somalia",
		    "Spain","Sudan", "Suriname","Swaziland", "Sweden",
		    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand",
		    "The Gambia", "Togo", "Tokelau", "Tonga","Tunisia", "Turkey",
		    "Turkmenistan", "Tuvalu","Uganda",
		    "Ukraine", 
		    "USA","Uruguay", "Uzbekistan",
		    "Vanuatu","Venezuela", "Vietnam",
		    "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
		  };

	public String getRandomWord()  {
		String word = COUNTRIES[(int) (Math.random() *COUNTRIES.length)];
        // Call the replaceAll() method 
        word = word.replaceAll("\\s", ""); 
		return word;
	}

	
}
