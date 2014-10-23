package dc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import dc.character.CharPlayer;
import dc.character.Race;

public abstract class SaveLoad {

	private static File saveFile = new File("dc_savegame");
	
	public static void save(CharPlayer player) {
		BufferedWriter writer;
		if(saveFile.isFile()) {
			saveFile.delete();
		}
		try {
			writer = new BufferedWriter(new FileWriter(saveFile));
			writer.write("Name: " + player.getName() + '\n');
			writer.write("Race: " + player.getRace().getRace() + '\n');
			writer.write("HP: " + player.getRace().getMaxHP() + "/" + player.getHP() + '\n');
			writer.write("MP: " + player.getRace().getMaxMP() + "/" + player.getMP() + '\n');
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CharPlayer load() {
		BufferedReader reader;
		String line;
		CharPlayer player = null;
		String name = new String();
		Race race = null;
		try {
			reader = new BufferedReader(new FileReader(saveFile));
			while ((line = reader.readLine()) != null) {
				if(line.matches("^Name.*")) {
					name = line.substring(6);
				}
				if(line.matches("^Race.*")) {
					String lineHelp = line.substring(6);
					for(Race testRace: Race.values()) {
						if(lineHelp.matches(testRace.getRace())) {
							race = testRace;
						}
					}
				}
				if(!name.isEmpty() && race != null) {
					player = (CharPlayer) Race.getNewChar(name, race);
				}
			}
			reader.close();
			if(player != null) {
				return player;
			} else {
				throw new NullPointerException();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NullPointerException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NullPointerException();
		}
	}
}