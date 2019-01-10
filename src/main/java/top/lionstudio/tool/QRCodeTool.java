package top.lionstudio.tool;




import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



public class QRCodeTool {
    private static final String CHARSET = "UTF-8";  
    private static final String FORMAT_NAME = "JPG";  
    // 二维码尺寸  
    private static final int QRCODE_SIZE = 200;  
    // LOGO宽度  
    private static final int WIDTH = 60;  
    // LOGO高度  
    private static final int HEIGHT = 60; 
    


    
 
    private static BufferedImage createImage(String content, String logoImgPath, boolean needCompress) throws WriterException, IOException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);  
        hints.put(EncodeHintType.MARGIN, 1);  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);  
        int width = bitMatrix.getWidth();  
        int height = bitMatrix.getHeight();  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        for (int x = 0; x < width; x++) {  
            for (int y = 0; y < height; y++) {  
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);  
            }  
        }  
        if (logoImgPath == null || "".equals(logoImgPath)) {  
            return image;  
        }  
        
        // 插入图片  
        QRCodeTool.insertImage(image, logoImgPath, needCompress);  
        return image;  
    }
    
  
    private static void insertImage(BufferedImage source, String logoImgPath, boolean needCompress) throws IOException{
        File file = new File(logoImgPath);  
        if (!file.exists()) {  
            return;  
        }  
        
        Image src = ImageIO.read(new File(logoImgPath));  
        int width = src.getWidth(null);  
        int height = src.getHeight(null);  
        if (needCompress) { // 压缩LOGO  
            if (width > WIDTH) {  
                width = WIDTH;  
            }  
            
            if (height > HEIGHT) {  
                height = HEIGHT;  
            }  
            
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);  
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
            src = image;  
        }  
        
        // 插入LOGO  
        Graphics2D graph = source.createGraphics();  
        int x = (QRCODE_SIZE - width) / 2;  
        int y = (QRCODE_SIZE - height) / 2;  
        graph.drawImage(src, x, y, width, height, null);  
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);  
        graph.setStroke(new BasicStroke(3f));  
        graph.draw(shape);  
        graph.dispose();  
    }

    public static void mkdirs(String dir){
       
        
        File file = new File(dir);
        if(file.isDirectory()){
            return;
        } else {
            file.mkdirs();
        }
    }
    public static void encode(String content, String logoImgPath, String destPath, boolean needCompress) throws Exception {  
        BufferedImage image = QRCodeTool.createImage(content, logoImgPath, needCompress);  
       mkdirs(destPath);  
        ImageIO.write(image, FORMAT_NAME, new File(destPath));  
    }   
    
   
    public static void encode(String content, String destPath) throws Exception {  
        QRCodeTool.encode(content, null, destPath, false);  
    }  

    public static void encode(String content, String logoImgPath, OutputStream output, boolean needCompress) throws Exception {  
        BufferedImage image = QRCodeTool.createImage(content, logoImgPath, needCompress);  
        ImageIO.write(image, FORMAT_NAME, output);  
    }  
    
   
    public static void encode(String content, OutputStream output) throws Exception {  
        QRCodeTool.encode(content, null, output, false);  
    }  
    
 
    public static String decode(File file) throws Exception {  
        BufferedImage image;  
        image = ImageIO.read(file);  
        if (image == null) {  
            return null;  
        }  
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);  
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
        Result result;  
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();  
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);  
        result = new MultiFormatReader().decode(bitmap, hints);  
        String resultStr = result.getText();  
        return resultStr;  
    }  
    
  
    public static String decode(String path) throws Exception {  
        return QRCodeTool.decode(new File(path));  
    } 
    
    public  void getQrcode(String path,String MINIID,String MINISECRET) throws Exception {
//		StringBuffer buffer = new StringBuffer();
//		try {
//			TrustManager[] tm = { new HttpsTrustManagerTool() };
//			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//			sslContext.init(null, tm, new SecureRandom());
//			SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//			URL urlo = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+MINIID+"&secret="+MINISECRET);
//			HttpsURLConnection httpUrlConn = (HttpsURLConnection) urlo
//					.openConnection();
//			httpUrlConn.setSSLSocketFactory(ssf);
//
//			httpUrlConn.setDoOutput(true);
//			httpUrlConn.setDoInput(true);
//			httpUrlConn.setUseCaches(false);
//			httpUrlConn.setRequestMethod("GET");
//			httpUrlConn.connect();
//			InputStream inputStream = httpUrlConn.getInputStream();
//			InputStreamReader inputStreamReader = new InputStreamReader(
//					inputStream, "utf-8");
//			BufferedReader bufferedReader = new BufferedReader(
//					inputStreamReader);
//
//			String str = null;
//			while ((str = bufferedReader.readLine()) != null) {
//				buffer.append(str);
//			}
//			bufferedReader.close();
//			inputStreamReader.close();
//			inputStream.close();
//			inputStream = null;
//			httpUrlConn.disconnect();
//			
//		
//
//		} catch (ConnectException ce) {
//			System.out.println("Weixin server connection timed out.");
//		} catch (Exception e) {
//			System.out.println("https request error:{}" + e);
//		}
//	
//		String content= buffer.toString();
//		
//		@SuppressWarnings("unchecked")
//		Map<String,Object> map=new Gson().fromJson(content,Map.class);
//		
//		String token=(String) map.get("access_token");
//		
//		System.out.println(token);
//		
//	    buffer = new StringBuffer();
//		try {
//			TrustManager[] tm = { new HttpsTrustManagerTool() };
//			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//			sslContext.init(null, tm, new SecureRandom());
//			SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//			URL urlo = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token);
//			HttpsURLConnection httpUrlConn = (HttpsURLConnection) urlo
//					.openConnection();
//			httpUrlConn.setSSLSocketFactory(ssf);
//
//			httpUrlConn.setDoOutput(true);
//			httpUrlConn.setDoInput(true);
//			httpUrlConn.setUseCaches(false);
//			httpUrlConn.setRequestMethod("POST");
//            httpUrlConn.connect();
//            GsonBuilder gb =new GsonBuilder();
//            gb.disableHtmlEscaping();
//         
//            Map<String,Object> resmap=new HashMap<>();
//            resmap.put("page", "pages/index/index");
//       
//            
//            
//            resmap.put("scene", "3");
//        
//            String data_out=   gb.create().toJson(resmap);
//            
//            System.out.println(data_out);
//
//			if (data_out!=null) {
//				OutputStream outputStream = httpUrlConn.getOutputStream();
//				outputStream.write(data_out.getBytes());
//				outputStream.close();
//			}
//
//			InputStream inputStream = httpUrlConn.getInputStream();
//	
//			
//			
//			File file=new File(path);
//            FileOutputStream fos=new FileOutputStream(file);
//			
//			 byte[] b = new byte[1024];
//             int nRead = 0;
//             while ((nRead = inputStream.read(b)) != -1) {
//                 fos.write(b, 0, nRead);
//             }
//             fos.flush();
//             fos.close();
//
//	
//			inputStream.close();
//			inputStream = null;
//			httpUrlConn.disconnect();
//
//		} catch (ConnectException ce) {
//			System.out.println("Weixin server connection timed out.");
//		} catch (Exception e) {
//			System.out.println("https request error:{}" + e);
//		}
			
	}
}