
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

/**
 * Created by Shaan on 4/23/2017.
 */
public class SoundEffects {

    private static SoundPool soundPool;
    private static int upsound;
    private static int downsound;
    private static int rightsound;
    private static int leftsound;
    private static int resetsound;

    public SoundEffects(Context context) {
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 2);
        upsound = soundPool.load(context, R.raw.buttonclick, 1);
        downsound = soundPool.load(context, R.raw.buttonclick, 1);
        leftsound = soundPool.load(context, R.raw.buttonclick, 1);
        rightsound = soundPool.load(context, R.raw.buttonclick, 1);
        resetsound = soundPool.load(context, R.raw.resetclick, 1);
    }

    public void playUpSound() {
        soundPool.play(upsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playDownSound() {
        soundPool.play(downsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playLeftSound() {
        soundPool.play(leftsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playRightSound() {
        soundPool.play(rightsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playResetSound() {
        soundPool.play(resetsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
