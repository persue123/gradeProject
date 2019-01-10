package top.lionstudio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Test {

	public static void main(String[] args) throws Exception {
		long S=System.currentTimeMillis();
		int N=100000000;
		int[] Z = new int[N];
		int[] P = new int[N];
		a:for (int i = 0; i < N; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) 
				if (i % j == 0) 
					continue a;
			Z[i]=1;
		}
		for (int i = 5; i < N/2; i++) {
			int p = 0;
			while (!(Z[i - p] == 1 && Z[i + p] == 1))
				p++;
			P[i] = p;
		}
		FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/P.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
		for (int i = 5; i < N/2; i++) {
			if (i % 5 == 0) 
				bufferedWriter.write("\n"+i+"-"+(i+4)+":");
			bufferedWriter.write(P[i]+" ");
		}
		System.out.println("Times:"+(System.currentTimeMillis()-S)/1000+ "S");
		bufferedWriter.flush();
		bufferedWriter.close();
	
	}
}

