package util;
import uy.edu.ort.obli.EnumCriticidad;

// for map
import java.io.File;  			// Import the File class
import java.io.FileWriter;   	// Import the FileWriter class
import java.io.IOException;  	// Import the IOException class to handle errors
import java.awt.Desktop;

public class PaginaWeb {
	File miArchivo;
	
	// key que dieron en clase
	// AIzaSyC2kHGtzaC300yc7Wi1LMBcEwM9btRZLqw
	
	// key que hice yo
	//AIzaSyB7pBWV7XFfIbxYWxfXRWM8Rx420nRkF-Y
	
	
	String htmlAntesDeMarkers;
	String htmlEntreMarkersYKey;
	String htmlMarkers;
	String key;
	String htmlDespuesDeKey;
	String htmlCompleto;
	
	VerticeGrafo[] vertices;
	
	public void EscribirArchivo(){
		//create file
		try {
			miArchivo = new File("map.html");
			if (miArchivo.createNewFile()) {
			//System.out.println("File created: " + miArchivo.getName());
            } else {
        	//System.out.println("File already exists.");
			}
		} catch (IOException e) {
			//System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		BuildMarkersString();
		htmlCompleto = htmlAntesDeMarkers + htmlMarkers + htmlEntreMarkersYKey + key + htmlDespuesDeKey;
		
		//write to file
	    try {
	        FileWriter myWriter = new FileWriter(miArchivo);
	        myWriter.write(htmlCompleto);
	        myWriter.close();
	        //System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        //System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	public void EjecutarArchivo() {
		try {
			File map = new File("map.html");
			Desktop.getDesktop().open(map);
		}catch(IOException e){
	        //System.out.println("An error occurred.");
	        e.printStackTrace();
		}
	}
	
	
	public void BuildMarkersString() {
		/*
		String estructura = 	"  var uluru = {lat: -34.903924, lng: -56.190451};\r\n" + 
								"  var uluru1 = {lat: -34.903868, lng: -56.189300};\r\n" +
								"  var uluru2 = {lat: -34.904772, lng: -56.189228};\r\n" +
								"  var uluru3 = {lat: -34.905753, lng: -56.189158};\r\n" +
								
								"  // The map, centered at Uluru\r\n" + 
								"  var map = new google.maps.Map(\r\n" + 
								"      document.getElementById('map'), {zoom: 16, center: uluru});\r\n" + 
								"  // The marker, positioned at Uluru\r\n" + 
								"  var marker = new google.maps.Marker({position: uluru, map: map});\r\n" +
								"  var marker = new google.maps.Marker({position: uluru1, map: map});\r\n" +
								"  var marker = new google.maps.Marker({position: uluru2, map: map});\r\n" +
								"  var marker = new google.maps.Marker({position: uluru3, map: map});\r\n";
		 */
		
		
		StringBuilder declaracionDeVars  = new StringBuilder();
		for (int i = 0; i < vertices.length; i++) {
			declaracionDeVars.append("var uluru"+i+" = {lat: " + vertices[i].x + ", lng: " + vertices[i].y + "};\r\n");
		}
		
		declaracionDeVars.append("var imagenRoja = \"marker_Rojo.png\";\r\n");
		declaracionDeVars.append("var imagenAzul = \"marker_Azul.png\";\r\n");
		declaracionDeVars.append("var imagenVerde = \"marker_Verde.png\";\r\n");
		declaracionDeVars.append("var imagenAmarilla = \"marker_Amarillo.png\";\r\n");
		
		String medio = 	"  // The map, centered at Uluru\r\n" + 
						"  var map = new google.maps.Map(\r\n" + 
						"      document.getElementById('map'), {zoom: 16, center: uluru0});\r\n" + 
						"  // The marker, positioned at Uluru\r\n";
		
		StringBuilder usoDeVars  = new StringBuilder();
		for (int i = 0; i < vertices.length; i++) {
			if(vertices[i].tipo == Enums.TipoDePunto.Esquina) {
				usoDeVars.append("var marker = new google.maps.Marker({position: uluru" + i + ", map: map, icon: imagenAzul});\r\n");	
			}else {
				switch(vertices[i].crit) {
				  case BAJA: 
					  usoDeVars.append("var marker = new google.maps.Marker({position: uluru" + i + ", map: map, icon: imagenVerde});\r\n");
				    break;
				  case MEDIA:
					  usoDeVars.append("var marker = new google.maps.Marker({position: uluru" + i + ", map: map, icon: imagenAmarilla});\r\n");
				    break;
				  case ALTA:
					  usoDeVars.append("var marker = new google.maps.Marker({position: uluru" + i + ", map: map, icon: imagenRoja});\r\n");
				    break;
				}
			}
		}
		
		htmlMarkers = declaracionDeVars + medio + usoDeVars;
	}
	
	
	
	public PaginaWeb(String pKey, VerticeGrafo[] pVertices) {
		miArchivo = null;
		key = pKey;
		vertices = pVertices;
		
		htmlAntesDeMarkers =	"<!DOCTYPE html>\r\n" + 
							"<html>\r\n" + 
							"  <head>\r\n" + 
							"    <head>\r\n" + 
							"        <title>Map</title>\r\n" + 
							"        <meta charset=\"UTF-8\">\r\n" + 
							"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
							"    </head>  \r\n" + 
							"    <style>\r\n" + 
							"       /* Set the size of the div element that contains the map */\r\n" + 
							"	   #container{\r\n" + 
							"		width = 100%; \r\n" + 
							"		display:flex;\r\n" + 
							"		align-items: center;\r\n" + 
							"		flex-direction: column;\r\n" + 
							"		justify-content: center;\r\n" + 
							"	   }\r\n" + 
							"	   \r\n" + 
							"      #map {\r\n" + 
							"        height: 600px;  /* The height is 400 pixels */\r\n" + 
							"        width: 1200px;  /* The width is the width of the web page */\r\n" + 
							"       }\r\n" + 
							"    </style>\r\n" + 
							"  </head>\r\n" + 
							"  <body>\r\n" + 
							"	<div id=\"container\">\r\n" + 
							"    <h3>My Google Maps Demo</h3>\r\n" + 
							"    <!--The div element for the map -->\r\n" + 
							"    <div id=\"map\"></div>\r\n" + 
							"	</div>\r\n" + 
							"    <script>\r\n" + 
							"// Initialize and add the map\r\n" + 
							"function initMap() {\r\n" + 
							"  // The location of Uluru\r\n"; 
							
						
		htmlEntreMarkersYKey= 	"}\r\n" + 
									"    </script>\r\n" + 
									"    <!--Load the API from the specified URL\r\n" + 
									"    * The async attribute allows the browser to render the page while the API loads\r\n" + 
									"    * The key parameter will contain your own API key (which is not needed for this tutorial)\r\n" + 
									"    * The callback parameter executes the initMap() function\r\n" + 
									"    -->\r\n" + 
									"    <script async defer\r\n" + 
									"    src=\"https://maps.googleapis.com/maps/api/js?key=";
		
		htmlDespuesDeKey =	"&callback=initMap\">\r\n" + 
						" </script>\r\n" + 
						"  </body>\r\n" + 
						"</html>";
	}
}
