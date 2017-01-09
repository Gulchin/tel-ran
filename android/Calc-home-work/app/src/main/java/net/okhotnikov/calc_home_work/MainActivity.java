package net.okhotnikov.calc_home_work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private boolean isEditing = false;
    private boolean editSecond = false;
    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private String operation = "";
    private float op1 = Float.NaN;
    private float op2 = Float.NaN;
    private float res = Float.NaN;
    private TextView output;

    private static HashMap<String, MathOperation> operations = new HashMap<>();

    static {
        operations.put("+", new MathOperation() {
            @Override
            public float calculate(float op1, float op2) {
                return op1 + op2;
            }
        });
        operations.put("-", new MathOperation() {
            @Override
            public float calculate(float op1, float op2) {
                return op1 - op2;
            }
        });
        operations.put("*", new MathOperation() {
            @Override
            public float calculate(float op1, float op2) {
                return op1 * op2;
            }
        });
        operations.put("%", new MathOperation() {
            @Override
            public float calculate(float op1, float op2) {
                return op1 / op2;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output= (TextView) findViewById(R.id.textview);
    }

    private void edit(char s) {
        if (isEditing) {
            if (editSecond) {
                sb2.append(s);
            } else {
                sb1.append(s);
            }
        } else {
            isEditing = true;
            if (editSecond) {
                sb2 = new StringBuilder();
                sb2.append(s);
            } else {
                sb1 = new StringBuilder();
                sb1.append(s);
            }
        }

        if (editSecond) output.setText(sb2.toString());
            else output.setText(sb1.toString());

    }

    private void convert() {
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        if (!s1.isEmpty()) op1 = Float.parseFloat(s1);
        if (!s2.isEmpty()) op2 = Float.parseFloat(s2);
    }

    private boolean isReady() {
        if (operation.isEmpty() || op1 !=op1 || op2 !=op2) return false;
        return true;
    }

    public void button0Click(View view) {
        edit('0');
    }

    public void button1Click(View view) {
        edit('1');
    }

    public void button2Click(View view) {
        edit('2');
    }

    public void button3Click(View view) {
        edit('3');
    }

    public void button4Click(View view) {
        edit('4');
    }

    public void button5Click(View view) {
        edit('5');
    }

    public void button6Click(View view) {
        edit('6');
    }

    public void button7Click(View view) {
        edit('7');
    }

    public void button8Click(View view) {
        edit('8');
    }

    public void button9Click(View view) {
        edit('9');
    }

    private void setOperation(String op) {
        convert();
        if (isReady()) calculate();
        operation = op;
        editSecond=true;
        isEditing=false;
    }

    private void setOp1(float val){
        op1=val;
        sb1=new StringBuilder();
        sb1.append(String.valueOf(op1));
    }

    private void resetOp2(){
        op2=Float.NaN;
        sb2=new StringBuilder();
    }

    private void calculate() {
        try {
            res = operations.get(operation).calculate(op1, op2);
            // System.out.println(op1+operation+op2+"="+res);
            setOp1(res);
            resetOp2();
            editSecond = false;
            output.setText(String.valueOf(res));
        }catch (Exception e){

        }
    }

    public void buttonPlusClick(View view) {
        setOperation("+");
    }

    public void buttonMinusClick(View view) {
        setOperation("-");
    }

    public void buttonMultiplyClick(View view) {
        setOperation("*");
    }

    public void buttonDivideClick(View view) {
        setOperation("%");
    }

    public void buttonClearClick(View view) {
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        operation = "";
        op1 = Float.NaN;
        op2 = Float.NaN;
        res = Float.NaN;
        output.setText(String.valueOf(0));
        editSecond=false;
        isEditing=false;
    }

    public void buttonEqualClick(View view){
        convert();
        calculate();
        isEditing=false;
    }

    public void buttonComaClick(View view){
        if(editSecond){
            if(sb2.indexOf(".")==-1){
                if(sb2.length()==0) {
                    sb2.append("0");
                    isEditing=true;
                }
                sb2.append(".");
            }
        } else {
            if(sb1.indexOf(".")==-1){
                if(sb1.length()==0) {
                    sb1.append("0");
                    isEditing=true;
                }
                sb1.append(".");
            }
        }
    }

}
