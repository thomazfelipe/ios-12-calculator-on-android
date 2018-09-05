package sm.unitri.br.calculator2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ZERO = "0", ONE = "1", TWO = "2", THREE = "3", FOUR = "4", FIVE = "5",
            SIX = "6", SEVEN = "7", EIGHT = "8", NINE = "9", SIGNAL = "-", DOT = ".";
    private TextView textViewDisplay;
    private Button buttonNumberZero, buttonNumberOne, buttonNumberTwo,
            buttonNumberThree, buttonNumberFour, buttonNumberFive,
            buttonNumberSix, buttonNumberSeven, buttonNumberEight,
            buttonNumberNine, buttonOperatorSum, buttonOperatorSubtract,
            buttonOperatorMultiply, buttonOperatorDivision, buttonOperatorEquals,
            buttonOperatorPercent, buttonDot, buttonSignalNumber, buttonCleanDisplay;
    private String operatorDisplay = "", operator = "";
    private Double operand;
    private List<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Objects.requireNonNull( getSupportActionBar() ).hide();
        setContentView( R.layout.activity_main );
        initializeVariables();

        buttonNumberZero.setOnClickListener( this );
        buttonNumberOne.setOnClickListener( this );
        buttonNumberTwo.setOnClickListener( this );
        buttonNumberThree.setOnClickListener( this );
        buttonNumberFour.setOnClickListener( this );
        buttonNumberFive.setOnClickListener( this );
        buttonNumberSix.setOnClickListener( this );
        buttonNumberSeven.setOnClickListener( this );
        buttonNumberEight.setOnClickListener( this );
        buttonNumberNine.setOnClickListener( this );
        buttonSignalNumber.setOnClickListener( this );
        buttonCleanDisplay.setOnClickListener( this );
        buttonDot.setOnClickListener( this );
        buttonOperatorEquals.setOnClickListener( this );
        buttonOperatorSum.setOnClickListener( this );
        buttonOperatorSubtract.setOnClickListener( this );
        buttonOperatorMultiply.setOnClickListener( this );
        buttonOperatorDivision.setOnClickListener( this );
        buttonOperatorPercent.setOnClickListener( this );

        buttonList.add(buttonOperatorSum);
        buttonList.add(buttonOperatorSubtract);
        buttonList.add(buttonOperatorMultiply);
        buttonList.add(buttonOperatorDivision);
        buttonList.add(buttonOperatorPercent);
    }

    private void initializeVariables() {
        textViewDisplay = findViewById( R.id.text_view_display );
        buttonNumberZero = findViewById( R.id.button_zero );
        buttonNumberOne = findViewById( R.id.button_one );
        buttonNumberTwo = findViewById( R.id.button_two );
        buttonNumberThree = findViewById( R.id.button_three );
        buttonNumberFour = findViewById( R.id.button_four );
        buttonNumberFive = findViewById( R.id.button_five );
        buttonNumberSix = findViewById( R.id.button_six );
        buttonNumberSeven = findViewById( R.id.button_seven );
        buttonNumberEight = findViewById( R.id.button_eight );
        buttonNumberNine = findViewById( R.id.button_nine );
        buttonCleanDisplay = findViewById( R.id.button_clean_display );
        buttonSignalNumber = findViewById( R.id.button_signal_number );
        buttonOperatorPercent = findViewById( R.id.button_percent );
        buttonOperatorDivision = findViewById( R.id.button_division );
        buttonOperatorMultiply = findViewById( R.id.button_multiply );
        buttonOperatorSubtract = findViewById( R.id.button_subtract );
        buttonOperatorEquals = findViewById( R.id.button_equals );
        buttonDot = findViewById( R.id.button_dot );
        buttonOperatorSum = findViewById( R.id.button_sum );
    }

    @SuppressLint({"SetTextI18n"})
    @Override
    public void onClick( View view ) {

        Button button = (Button) view;

        switch ( view.getId() ) {
            case R.id.button_zero:
                changeTextViewDisplay( ZERO );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_one:
                changeTextViewDisplay( ONE );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_two:
                changeTextViewDisplay( TWO );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_three:
                changeTextViewDisplay( THREE );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_four:
                changeTextViewDisplay( FOUR );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_five:
                changeTextViewDisplay( FIVE );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_six:
                changeTextViewDisplay( SIX );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_seven:
                changeTextViewDisplay( SEVEN );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_eight:
                changeTextViewDisplay( EIGHT );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_nine:
                changeTextViewDisplay( NINE );
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_sum:
                unselectedOperatorButton();
                operatorDisplay = operator = "+";
                buttonOperatorSum.setTextColor( Color.parseColor("#FBA644") );
                clearStateButton(button);
                break;
            case R.id.button_subtract:
                unselectedOperatorButton();
                operatorDisplay = operator = "-";
                buttonOperatorSubtract.setTextColor( Color.parseColor("#FBA644") );
                clearStateButton(button);
                break;
            case R.id.button_multiply:
                unselectedOperatorButton();
                operatorDisplay = operator = "*";
                buttonOperatorMultiply.setTextColor(Color.parseColor("#FBA644") );
                clearStateButton(button);
                break;
            case R.id.button_division:
                unselectedOperatorButton();
                operatorDisplay = operator = "/";
                buttonOperatorDivision.setTextColor( Color.parseColor("#FBA644") );
                clearStateButton(button);
                break;
            case R.id.button_equals:
                result();
                unselectedOperatorButton();
                clearStateButton(null);
                break;
            case R.id.button_percent:
                unselectedOperatorButton();
                textViewDisplay.setText( String.valueOf( Double.parseDouble( textViewDisplay.getText().toString() ) / 100 ) );
                clearStateButton(null);
                break;
            case R.id.button_dot:
                unselectedOperatorButton();
                textViewDisplay.setText( textViewDisplay.getText().toString() + DOT );
                clearStateButton(null);
                break;
            case R.id.button_clean_display:
                unselectedOperatorButton();
                textViewDisplay.setText( ZERO );
                operand = null;
                clearStateButton(null);
                break;
            case R.id.button_signal_number:
                changeTextViewDisplay( SIGNAL );
                clearStateButton(null);
        }
    }

    private void clearStateButton(Button button){

        for(Button b : buttonList){
            b.setSelected(false);
            b.setPressed(false);
        }

        if(button != null) {
            button.setSelected(true);
            button.setPressed(false);
        }
    }

    private void unselectedOperatorButton() {
        buttonOperatorSum.setTextColor( Color.WHITE );
        buttonOperatorMultiply.setTextColor( Color.WHITE );
        buttonOperatorDivision.setTextColor( Color.WHITE );
        buttonOperatorSubtract.setTextColor( Color.WHITE );
        operatorDisplay = "";
    }

    @SuppressLint( "SetTextI18n" )
    private void changeTextViewDisplay( String value ) {

        if ( !operatorDisplay.equals( "" ) ) {
            operand = Double.valueOf( textViewDisplay.getText().toString() );
            textViewDisplay.setText( ZERO );
        }
        if ( textViewDisplay.getText().equals( ZERO ) ) {
            if ( value.equals( SIGNAL ) ) {
                textViewDisplay.setText( SIGNAL + ZERO );
            } else {
                textViewDisplay.setText( value );
            }
        } else if ( !value.equals( SIGNAL ) ) {
            textViewDisplay.setText( textViewDisplay.getText() + value );
        } else if ( textViewDisplay.getText().toString().contains( SIGNAL ) ) {
            textViewDisplay.setText( new StringBuilder( textViewDisplay
                    .getText()
                    .toString() )
                    .replace( 0, 1, "" ) );
        } else {
            textViewDisplay.setText( value + textViewDisplay.getText() );
        }
    }

    @SuppressLint( "SetTextI18n" )
    private void result() {

        Double anotherOperand = Double.valueOf( textViewDisplay.getText().toString() );
        Double result = null;

        if ( operand != null ) {
            switch ( operator ) {
                case "+":
                    result = operand + anotherOperand;
                    break;
                case "-":
                    result = operand - anotherOperand;
                    break;
                case "*":
                    result = operand * anotherOperand;
                    break;
                case "/":
                    result = operand / anotherOperand;
            }
            assert result != null;
            String display = result.toString();

            textViewDisplay.setText( display.endsWith( ".0" ) ? display.replace( ".0", "" ) : display );
        }
    }
}
