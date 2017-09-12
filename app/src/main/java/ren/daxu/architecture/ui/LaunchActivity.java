package ren.daxu.architecture.ui;

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

    @Override
    public void initView() {
        SetTranslanteBar();
        ParticleTextView particleTextView = (ParticleTextView) findViewById(R.id.particleTextView);
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        ParticleTextViewConfig config = new ParticleTextViewConfig.Builder()
                .setRowStep(8)
                .setColumnStep(8)
                .setTargetText("Android")
                .setReleasing(0.2)
                .setParticleRadius(4)
                .setMiniDistance(0.1)
                .setTextSize(150)
                .setMovingStrategy(randomMovingStrategy)
                .instance();
        particleTextView.setConfig(config);
        particleTextView.startAnimation();
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void setBeforeContentView() {

    }
}
