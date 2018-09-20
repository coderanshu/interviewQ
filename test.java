package test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Test {
	public static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string: "
					+ Base64.encodeBase64String(encrypted));

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			if(encrypted == null || encrypted.trim().isEmpty() || encrypted.trim() =="")
				System.out.println("The key provide is either not correct or problem with the value");
			else
				System.out.println(encrypted+" is not a encypted key");
		}

		return null;
	}

	public static void main(String[] args) {
		String key = "Bar12345Bar12341"; // 128 bit key
		String key1 = "Bar12345Bar12351";
		String initVector = "RandonInitVector"; // 16 bytes IV
		String encrypt="{test: anshu}";
		String test=encrypt(key, initVector, encrypt);
		System.out.println(test);
		System.out.println(decrypt(key1, initVector,test));
	}
}
