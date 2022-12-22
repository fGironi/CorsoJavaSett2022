package srl.neotech.services;

import java.util.Random;

import org.springframework.stereotype.Service;
	
@Service
public class HomeService {
	
	Random rnd=new Random();
	
	public String urlImmagineRandom() {
		String bgimg="";
		Integer rndImg=rnd.nextInt(4);
		if (rndImg==0) bgimg="https://wallpaperaccess.com/full/5384.jpg";
		if (rndImg==1) bgimg="https://images.pexels.com/photos/120049/pexels-photo-120049.jpeg";
		if (rndImg==2) bgimg="https://images.pexels.com/photos/1335077/pexels-photo-1335077.jpeg";
		if (rndImg==3) bgimg="https://wallpaperaccess.com/full/1705956.jpg";
		return bgimg;
	}
}
