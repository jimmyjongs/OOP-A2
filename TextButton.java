import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class TextButton extends Panel {
    JButton button;
    JTextArea text;

    public TextButton(String buttonLabel){
        super();
        button = new JButton();
        button.setText(buttonLabel);
        button.setBounds(0,0, 100, 100);
        
        text = new JTextArea(1, 20);
        this.getPanel().add(button);
        this.getPanel().add(text);
        this.setColor(Color.blue);
        

    }

    public JButton getButton(){
        return button;
    }



}