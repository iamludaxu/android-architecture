package ren.daxu.architecture.ui;

import android.os.Handler;
import android.os.Message;

import com.yasic.library.particletextview.MovingStrategy.RandomMovingStrategy;
import com.yasic.library.particletextview.Object.ParticleTextViewConfig;
import com.yasic.library.particletextview.View.ParticleTextView;

import ren.daxu.architecture.R;
import ren.daxu.architecture.comm.CommActivity;

public class LaunchActivity extends CommActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_launch;
    }

    ParticleTextView particleTextView;

    @Override
    public void initView() {
        SetTranslanteBar();
        particleTextView = (ParticleTextView) findViewById(R.id.particleTextView);
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        ParticleTextViewConfig config = new ParticleTextViewConfig.Builder()
                .setRowStep(8)
                .setColumnStep(4)
                .setTargetText("Android")
                .setReleasing(0.2)
                .setParticleRadius(4)
                .setDelay(-1L)
                .setMiniDistance(0.1)
                .setTextSize(150)
                .setMovingStrategy(randomMovingStrategy)
                .instance();
        particleTextView.setConfig(config);
        particleTextView.startAnimation();

        // mHandler.sendEmptyMessageDelayed(0,3000);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            particleTextView.stopAnimation();
        }
    };

    @Override
    public void initPresenter() {

    }

    @Override
    public void setBeforeContentView() {

    }
}
