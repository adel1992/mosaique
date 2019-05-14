package bootwildfly;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class RadioConnector {
	
	public RadioConnector() {

	}

	public static void playRadioStream(String spec) throws IOException, JavaLayerException {

		URLConnection urlConnection = new URL(spec).openConnection();
		urlConnection.connect();
		Player player = new Player(urlConnection.getInputStream());
		player.play();
	}

	public static InputStream getRadioStream(String stationName) throws MalformedURLException, IOException {
		URLConnection urlConnection = new URL(stationName).openConnection();
		return urlConnection.getInputStream();
	}

}
