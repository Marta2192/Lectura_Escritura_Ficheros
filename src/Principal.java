import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Principal {

	static ArrayList<Mamiferos> listMam = new ArrayList<>();
	static ArrayList<Paxaros> listPax = new ArrayList<>();
	static ArrayList<Reptiles> listRep = new ArrayList<>();

	
	public static void main(String[] args) {

		//Leer un csv
		//Guardarlo en varios ArrayList
		//Pasarlo a xml
		
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("C:\\PRUEBAEXAMEN\\animales.csv"));
			Stream<String> lines = br.lines();
			
			lines.forEach(copy -> {
			String[] pedazo = copy.split(" ");
				
				if(pedazo[3].equals("1")) {
					System.out.println(pedazo[0] + " es un animal MAMÍFERO");
					
					listMam.add(new Mamiferos(pedazo[0], Integer.parseInt(pedazo[1]), pedazo[2]));
				
				}else if(pedazo[3].equals("2")) {
					System.out.println(pedazo[0] + " es un PAXARO.");
					
					listPax.add(new Paxaros(pedazo[0], Integer.parseInt(pedazo[1]), pedazo[2]));

				
				}else if(pedazo[3].equals("3")) {
					System.out.println(pedazo[0] + " es un REPTIL.");
					
					listRep.add(new Reptiles(pedazo[0], Integer.parseInt(pedazo[1]), pedazo[2]));

				}
			});
			
			Utilidades.generarXML(listMam, listPax, listRep);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
