package com.huawei.examples.remoteconfig;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.agconnect.remoteconfig.AGConnectConfig;
import com.huawei.agconnect.remoteconfig.ConfigValues;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;

public class SplashActivity extends AppCompatActivity {
    private AGConnectConfig config;
    private String themeName;
    public static final String EXTRA_MESSAGE = "com.huawei.examples.remoteconfig.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        config = AGConnectConfig.getInstance();
        config.fetch(0).addOnSuccessListener(new OnSuccessListener<ConfigValues>() {
            @Override
            public void onSuccess(ConfigValues configValues) {
                config.apply(configValues);
                //На сервере происходит проверка условия, по результатам которой возвращается та
                //или иная настройка. В данному примере происходит проверка версии приложения. Для
                //версии 1.0 следующая строчка возвращает "Green", для версии 1.1 - "Red".
                //Условия и возвращаемые параметры задаются в консоли в разделе Удаленная настройка
                //вашего проекта. 
                themeName = config.getValueAsString("THEME");
                startActivity(new Intent(SplashActivity.this, MainActivity.class).putExtra(EXTRA_MESSAGE,themeName));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
            }
        });
    }
}