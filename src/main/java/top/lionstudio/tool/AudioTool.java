package top.lionstudio.tool;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

/**
 * MP3转PCM Java方式实现
 */
public class AudioTool {

	public static File convertMP32Pcm(String mp3filepath, String pcmfilepath) {
		try {
			// 获取文件的音频流，pcm的格式
			AudioInputStream audioInputStream = getPcmAudioInputStream(mp3filepath);
			// 将音频转化为 pcm的格式保存下来
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(pcmfilepath));

			return new File(pcmfilepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static AudioInputStream getPcmAudioInputStream(String mp3filepath) {
		File mp3 = new File(mp3filepath);
		AudioInputStream audioInputStream = null;
		AudioFormat targetFormat = null;
		try {
			AudioInputStream in = null;

			// 读取音频文件的类
			MpegAudioFileReader mp = new MpegAudioFileReader();
			in = mp.getAudioInputStream(mp3);
			AudioFormat baseFormat = in.getFormat();

			// 设定输出格式为pcm格式的音频文件
			targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

			// 输出到音频
			audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return audioInputStream;
	}

}