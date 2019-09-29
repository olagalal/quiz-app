package com.example.olaglal.projectquizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    List<Question> chosenList;
    Float score = 0f;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    RadioGroup rdg;
    RadioButton rda, rdb, rdc;
    Button butNext;

    private static int numOfQ ;
    public static long gcd( long a, long b ){
        if( a % b == 0 ) return b ;
        return gcd( b , a % b ) ;
    }
    public static int genStep(){
        int step = ( ( (int)( Math.random() * ( 1e9 + 7 ) ) ) % 40 ) + 2 ;
        while( gcd( Math.max( numOfQ , step) , Math.min( numOfQ , step) ) != 1 )
            ++step ;
        return step ;
    }
    public static List chooseQ( List< Question > all ){
        List<Question> viwed = new ArrayList<Question>() ;
        Collections.shuffle( all ) ;
        numOfQ = all.size() ;
        int numWantedQ = 10 ;
        int step = genStep() ;
        int bsStep = step ;
        for( int i = 0 ; i < numWantedQ ; ++i ){
            int choosenIndex = ( bsStep  ) % numOfQ ;
            viwed.add( all.get( choosenIndex ) ) ;
            bsStep += step ;
        }
        return viwed ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);

        quesList = db.getAllQuestions();
        chosenList = chooseQ(quesList);

        currentQ = chosenList.get(qid);

        txtQuestion = findViewById(R.id.textView1);
        rdg = findViewById(R.id.radioGroup1);
        rda = findViewById(R.id.radio0);
        rdb = findViewById(R.id.radio1);
        rdc = findViewById(R.id.radio2);
        butNext = findViewById(R.id.button1);
        setQuestionView();
        butNext.setEnabled(false);

        rdg.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged (RadioGroup group , int checkedId){
                butNext.setEnabled(true);
            }
        });

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = findViewById(R.id.radioGroup1);
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                if (answer.getText()== null) {
                    Toast.makeText(QuizActivity.this ,"Please choose one answer",Toast.LENGTH_LONG).show();
                }
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score+=0.5f;
                }
                if (qid < 10) {
                    currentQ = chosenList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putFloat("score", score); // score
                    intent.putExtras(b); // to next Intent
                    startActivity(intent);
                    finish();
                }
                if(qid == 10){
                    butNext.setText("Get Result");
                }
                butNext.setEnabled(false);
            }
        });
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}
