import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * 图片资源初始化
 * @author wangdong
 *
 */
public class ImagesMgr {
	static BufferedImage tankU;
	static BufferedImage tankD;
	static BufferedImage tankL;
	static BufferedImage tankR;
	
	static BufferedImage bulletU;
	static BufferedImage bulletD;
	static BufferedImage bulletL;
	static BufferedImage bulletR;

	
	static {
		  try {
			  ClassLoader loader = ImagesMgr.class.getClassLoader();
			  tankU = ImageIO.read(loader.getResourceAsStream("images/tankU.gif"));
			  tankD = ImageIO.read(loader.getResourceAsStream("images/tankD.gif"));
			  tankL = ImageIO.read(loader.getResourceAsStream("images/tankL.gif"));
			  tankR = ImageIO.read(loader.getResourceAsStream("images/tankR.gif"));
			  
			  bulletU = ImageIO.read(loader.getResourceAsStream("images/bulletU.gif"));
			  bulletD = ImageIO.read(loader.getResourceAsStream("images/bulletD.gif"));
			  bulletL = ImageIO.read(loader.getResourceAsStream("images/bulletL.gif"));
			  bulletR = ImageIO.read(loader.getResourceAsStream("images/bulletR.gif"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
