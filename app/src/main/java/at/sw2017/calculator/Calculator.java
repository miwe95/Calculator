package at.sw2017.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends Activity implements View.OnClickListener{

    private enum State {
        ADD, SUB, MUL, DIV, INIT, NUM
    }

    State state;
    Integer firstNumber;
    Button buttonplus;
    Button buttonminus;
    Button buttonmultiply;
    Button buttondivide;
    Button buttonequal;
    Button buttonC;
    TextView numberView;
    ArrayList<Button> numberButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
         setNumberButtonListener();
         buttonplus = (Button) findViewById(R.id.buttonPlus);
        buttonplus.setOnClickListener(this);
         buttonminus= (Button) findViewById(R.id.buttonMinus);
        buttonminus.setOnClickListener(this);
         buttonmultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonmultiply.setOnClickListener(this);
         buttondivide = (Button) findViewById(R.id.buttonDivide);
        buttondivide.setOnClickListener(this);
         buttonequal = (Button) findViewById(R.id.buttonEqual);
        buttonequal.setOnClickListener(this);
         buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this);
         numberView = (TextView) findViewById(R.id.numberView);
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;
        switch (clickedButton.getId()) {
            case R.id.buttonPlus:
                clearNumberView();
                state = State.ADD;
                break;
            case R.id.buttonMinus:
                clearNumberView();
                state = State.SUB;
                break;
            case R.id.buttonMultiply:
                clearNumberView();
                state = State.MUL;
                break;
            case R.id.buttonDivide:
                clearNumberView();
                state = State.DIV;
                break;
            case R.id.buttonC:
                clearTextView();
                break;
            case R.id.buttonEqual:
                calculateResult();
                state = State.INIT;
                break;
            default:
                String recentNumber​ = numberView.getText().toString();
                if (recentNumber​.equals("0")) {
                    recentNumber​ = "";
                }
                recentNumber​ += clickedButton.getText().toString();
                numberView.setText(recentNumber​);
        }
    }

    public void setNumberButtonListener() {
        for(int i = 0; i<= 9;i++)
        {
            String buttonName = "button" + i;
            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            numberButtons.add(button);
        }
    }

    private  void clearTextView() {
        numberView.setText("0");
        firstNumber = 0;
        state = State.INIT;
    }

    private void clearNumberView() {
        String tempString = numberView.getText().toString();
        if (!tempString.equals("")) {
            firstNumber = Integer.valueOf(tempString);
        }
        numberView.setText("");
    }

    private void calculateResult() {
        int secondNumber = 0;

        String tempString = numberView.getText().toString();
        if (!tempString.equals("")) {
            secondNumber = Integer.valueOf(tempString);
        }

        int result;
        switch (state) {
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        numberView.setText(Integer.toString(result));
    }

}
