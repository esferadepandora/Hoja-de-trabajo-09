//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////HOJA DE TRABAJO 9///////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////14482////////////////////////FERNANDA DAVILA//////////////////////
////////////////////////14015////////////////////////CRISTIAN DE LEON/////////////////////
////////////////////////14069////////////////////////MICHEL RAMIREZ///////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////ESTE MAIN SE PUEDE CORRER DESDE NETBEANS, EL OTRO SOLO DESDE CMD//
////////////////////////HAY QUE MODIFICAR LAS DIRECCIONES DEPENDIENDO DE LA COMPU/////////
////////////////////////EL ARGS2 SE DEBE CAMBIAR ENTRE 1 Y 5//////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

import java.io.*;
class WordTypeCounter {
	public static void main(String[] args) throws Exception{
            String[] args2 = new String[3];
            args2[0] = "/Users/EsferaDePandora/Copy/2015/CICLO 2/CC2003 ALGORITMOS Y ESTRUCTURAS DE DATOS/Hojas de trabajo/HT09 - BST y MAPEO/HT9 proyecto/src/words.txt";
            args2[1] = "/Users/EsferaDePandora/Copy/2015/CICLO 2/CC2003 ALGORITMOS Y ESTRUCTURAS DE DATOS/Hojas de trabajo/HT09 - BST y MAPEO/HT9 proyecto/src/text.txt";
            args2[2] = "5";
            
		if(args2.length > 1){
			File wordFile = new File(args2[0]);
			File textFile = new File(args2[1]);
			
			///////////////////////////////////////////////////////////////////
			//  1 SimpleSet
			//  2 Red Black Tree
			//  3 Splay Tree
			//  4 Hash Table
			//  5 TreeMap (de java collection framework)
			///////////////////////////////////////////////////////////////////
			
			int implementacion = Integer.parseInt(args2[2]);
			BufferedReader wordreader;
			BufferedReader textreader;
			int verbs=0;
			int nouns=0;
			int adjectives=0;
			int adverbs=0;
			int gerunds=0;
			long starttime;
			long endtime;
			
			//VERIFICA QUE PARAMETROS EXISTEN
			if(wordFile.isFile() && textFile.isFile()) {
				// Leer archivos
				try{
					wordreader = new BufferedReader(new FileReader(wordFile));
					textreader = new BufferedReader(new FileReader(textFile));
				}
				catch (Exception ex){
					System.out.println("Error al leer!");
					return;
				}

				///////////////////////////////////////////////////////////////////
				WordSet words =  WordSetFactory.generateSet(implementacion);
				///////////////////////////////////////////////////////////////////
				
				String line = null;
				String[] wordParts;
				
				//LEE ARCHIVO
				starttime = System.currentTimeMillis();
				line = wordreader.readLine();
				while(line!=null){
					wordParts = line.split("\\.");  // lo que esta entre comillas es una expresi�n regular.
					if(wordParts.length == 2){
						words.add(new Word(wordParts[0].trim(),wordParts[1].trim()));
					}
					line = wordreader.readLine();
				}
				wordreader.close();
				endtime = System.currentTimeMillis();
				
				System.out.println("Palabras cargadas en " + (endtime-starttime) + " ms.");
				
				starttime = System.currentTimeMillis();
				line = textreader.readLine();
				String[] textParts;
				Word currentword;
				Word lookupword = new Word();
				
				while(line!=null){
					// SEPARA PALABRAS
					textParts = line.split("[^\\w-]+");
					
					// VERIFICA EL TIPO 
					for(int i=0;i<textParts.length;i++){
						lookupword.setWord(textParts[i].trim().toLowerCase());
						currentword = words.get(lookupword);
						if(currentword != null){
							if(currentword.getType().equals("v-d") || currentword.getType().equals("v") || currentword.getType().equals("q"))
								verbs++;
							else if(currentword.getType().equals("g") )
								gerunds++;
							else if(currentword.getType().equals("a-s") || currentword.getType().equals("a-c") || currentword.getType().equals("a"))
								adjectives++;
							else if(currentword.getType().equals("e"))
								adverbs++;
							else 
								nouns++;
						}
					}
					
					line = textreader.readLine();
				}
				textreader.close();
				endtime = System.currentTimeMillis();
				System.out.println("Texto analizado en " + (endtime-starttime) + " ms.");
				
				///////////////////////////////////////////////////////////////////
				System.out.println("El texto tiene:");
				System.out.println(verbs + " verbos");
				System.out.println(nouns + " sustantivos");
				System.out.println(adjectives + " adjetivos");
				System.out.println(adverbs + " adverbios");
				System.out.println(gerunds + " gerundios");
				///////////////////////////////////////////////////////////////////
			}
			else{
				System.out.println("No encuentro los archivos :'( ");
			}
		}
		else{
			System.out.println("Faltan Parametros.");
		}
	}
}
