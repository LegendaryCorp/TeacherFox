package com.teacherfox.legendary.teacherfox;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Results extends AppCompatActivity {
Boolean res=false;
    int premio=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        res=getIntent().getBooleanExtra("resultado", false);
        premio=getIntent().getIntExtra("coins", 0);
        TextView txresultado = (TextView)findViewById(R.id.txRes);
        TextView txmoney = (TextView)findViewById(R.id.gotMoney);
        ImageView hatav = (ImageView)findViewById(R.id.hatavr);
        int icon = getResources().getIdentifier("drawable/item" + Avatar.hatnum, "drawable", getPackageName());
        hatav.setImageResource(icon);
        Resources r = getResources();
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][1], r.getDisplayMetrics());

        int height =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][2], r.getDisplayMetrics());
        int m1 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][5], r.getDisplayMetrics());

        int m2 =(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Avatar.positionsr[0][6] , r.getDisplayMetrics());
        RelativeLayout.LayoutParams size = new RelativeLayout.LayoutParams(width, height);
        size.setMargins(m1, m2, 0, 0);
        hatav.setLayoutParams(size);
        if(res){
            txresultado.setText("Acertou!");
            txmoney.setText("+" + premio + "$");
            Avatar.money=Avatar.money+premio;
            boolean lup = addExp(10);
            if(lup){
                txresultado.setText("LEVEL " + Avatar.lvl);
            }

        }else{
            txresultado.setText("Errou");
        }
    }

    public void returnToMenu(View view){
        finish();
    }
    public boolean addExp(int x){
        Avatar.exp=Avatar.exp+x;
        boolean lvlup=false;
        for(int cont=0;cont<=5;cont++){
            if(Avatar.levels[cont]<=Avatar.exp){
                Avatar.lvl=cont;

                lvlup=true;
            }
        }
        return lvlup;

    }
}
