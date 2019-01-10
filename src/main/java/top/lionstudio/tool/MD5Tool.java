package top.lionstudio.tool;






import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class MD5Tool {  
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",  
            "8", "9", "a", "b", "c", "d", "e", "f"};  
  
    public static String byteArrayToHexString(byte[] b) {  
        StringBuilder resultSb = new StringBuilder();  
        for (byte aB : b) {  
            resultSb.append(byteToHexString(aB));  
        }  
        return resultSb.toString();  
    }  
  
    private static String byteToHexString(byte b) {  
        int n = b;  
        if (n < 0) {  
            n = 256 + n;  
        }  
        int d1 = n / 16;  
        int d2 = n % 16;  
        return hexDigits[d1] + hexDigits[d2];  
    }  
    public static String MD5Encode(String origin) {  
        String resultString = null;  
        try {  
            resultString = origin;  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(resultString.getBytes("UTF-8"));  
            resultString = byteArrayToHexString(md.digest());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return resultString;  
    }  
    
	public static String decryptUserinfo(String encryptedData, String sessionKey, String iv) {
		// 被加密的数据
		byte[] dataByte = Base64Tool.decode(encryptedData.getBytes());
		// 加密秘钥
		byte[] keyByte = Base64Tool.decode(sessionKey.getBytes());
		// 偏移量
		byte[] ivByte = Base64Tool.decode(iv.getBytes());
		try {
			// 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
			int base = 16;
			if (keyByte.length % base != 0) {
				int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
				byte[] temp = new byte[groups * base];
				Arrays.fill(temp, (byte) 0);
				System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
				keyByte = temp;
			}
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
			SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
			AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
			parameters.init(new IvParameterSpec(ivByte));
			cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
			byte[] resultByte = cipher.doFinal(dataByte);
			if (null != resultByte && resultByte.length > 0) {
				String result = new String(resultByte, "UTF-8");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

  
}  