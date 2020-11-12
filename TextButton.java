import javax.swing.*;
import java.awt.*;

public class TextButton extends Panel {
    private JButton button;
    private JTextArea text;

    public TextButton(String buttonLabel){
        super();
        button = new JButton();
        button.setText(buttonLabel);
        button.setBounds(0,0, 400, 100);
        
        text = new JTextArea(1, 20);
        this.getPanel().add(button);
        this.getPanel().add(text);
        this.setColor(Color.blue);
    }

    public String getText(){
        return text.getText();
    }

    public JButton getButton(){
        return button;
    }



}